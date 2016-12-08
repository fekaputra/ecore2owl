package org.cdlflex.sri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.hp.hpl.jena.datatypes.RDFDatatype;
import com.hp.hpl.jena.datatypes.TypeMapper;
import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.ontology.DataRange;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.ontology.Ontology;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.vocabulary.XSD;

/**
 * Transform Ecore class to OWL-DL Ontology.
 * 
 * @author A. Kusel (2006)
 * @author F. Ekaputra (2015)
 */
public class EcoreToOWL {

    private static Logger log = Logger.getLogger(EcoreToOWL.class);

    /**
     * counter for OWL individual creation
     */
    protected int counter = 0;

    /**
     * Constructor
     */
    public EcoreToOWL() {
    }

    /**
     * Convenient static method to transform Ecore to OWL
     * 
     * @param inputFile
     * @param outputFile
     */
    public static void transformEcore2OWL(String inputFile, String instanceFile, String outputFile) {

        Long time = System.currentTimeMillis();

        log.info("start transformEcore2OWL");
        log.info("start logging time");

        EcoreToOWL ecore2owl = new EcoreToOWL();
        log.info("instantiate ecore2owl");
        try {
            ecore2owl.convertEcore2OWLInclusiveInstances(inputFile, instanceFile, outputFile);
        } catch (TransformationException e) {
            e.printStackTrace();
        }
        log.info("finish convertEcore2OWLInclusiveInstances");

        log.info("Done converting " + instanceFile + " to OWL in " + (System.currentTimeMillis() - time)
            + " miliseconds");
    }

    /**
     * Method that performs all the work. Preconditions: inputFile != null && inputFile != "" && validURI(inputFile)
     * 
     * @param inputFile
     * @throws TransformationException
     */
    public void convertEcore2OWL(String inputFile) throws TransformationException {

        convertEcore2OWL(inputFile, getOutputFileName(inputFile));

    }

    /**
     * Method that performs all the work. Preconditions: inputFile != null && inputFile != "" && validURI(inputFile) &&
     * outputFile != null && outputFile != "" && validURI(outputFile)
     * 
     * @param inputFile
     * @param outputFile
     * @throws TransformationException
     */
    public void convertEcore2OWL(String inputFile, String outputFile) throws TransformationException {

        // OntModel use RDFS reasoner to derive attribute to subclass - @FJE: seems not used; switched to non-reasoner
        // OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RDFS_INF);
        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        EPackage ep = getEPackage(inputFile);

        // performs the actual transformation work
        transformEcore2OWL(ep, ontModel);

        // save the Ontology to a file
        saveOntology(outputFile, ontModel);
    }

    /**
     * Method, that allows the lifting a model plus instances. Preconditions: modelFile != null && modelFile != "" &&
     * validURI(modelFile) && instancesFile != null && instancesFile != "" && validURI(instancesFile).
     * 
     * @param modelFile
     * @param instancesFile
     * @throws TransformationException
     */
    public void convertEcore2OWLInclusiveInstances(String modelFile, String instancesFile)
        throws TransformationException {

        convertEcore2OWLInclusiveInstances(modelFile, instancesFile, getOutputFileName(modelFile));

    }

    /**
     * Method, that allows the lifting a model plus instances. Preconditions: modelFile != null && modelFile != "" &&
     * validURI(modelFile) && instancesFile != null && instancesFile != "" && validURI(instancesFile) && outputFile !=
     * null && outputFile != "" && validURI(outputFile)
     * 
     * @param modelFile
     * @param instancesFile
     * @throws TransformationException
     */
    public void convertEcore2OWLInclusiveInstances(String modelFile, String instancesFile, String outputFile)
        throws TransformationException {
        log.info("start convertEcore2OWLInclusiveInstances");

        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        log.info("ontModel created");
        EPackage ep = getEPackage(modelFile);
        log.info("epackage created");

        // performs the actual transformation work of the model
        transformEcore2OWL(ep, ontModel);
        log.info("done transformEcore2OWL");

        // read the instance List
        EList<?> instanceList = getInstanceList(instancesFile, ep);
        log.info("done getInstanceList");

        // maps EObjects (= keys of the Hashmap) to the individuals
        // (= values of the HashMap) in the ontModel;
        // this is necessary, because EObjects (= Instances) are nameless,
        // but individuals in the ontology should have names to be able to be
        // referenced; so we need this mapping to be able to get the corresponding
        // individuals of an EObject
        HashMap<EObject, Individual> instanceMapping = new HashMap<EObject, Individual>();
        log.info("done create instanceMapping");

        // create the instances
        createIndividuals(instanceList, ontModel, instanceMapping);
        log.info("done createIndividuals");

        // create the statements for the instances
        createStatements(instanceList, ontModel, instanceMapping);
        log.info("done createStatements");

        // save the Ontology to a file
        saveOntology(outputFile, ontModel);
        log.info("done saveOntology");

    }

    /**
     * Help method for getting the EPackage out of the input File. Preconditions: inputFile != null && inputFile != ""
     * && validURI(inputFile)
     * 
     * @param inputFile
     * @return EPackage
     * @throws TransformationException
     */
    protected EPackage getEPackage(String inputFile) throws TransformationException {

        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
        Resource resource = null;

        // read input ecore file in memory structure
        if (inputFile == null || inputFile.equals("")) {
            throw new TransformationException("invalid Ecore File");
        }

        resourceSet.getResource(URI.createFileURI(inputFile), true);
        resource = (Resource) resourceSet.getResources().get(0);

        // check, if ecore file contains root package/elements at all
        if (resource.getContents().size() == 0
            || !org.eclipse.emf.ecore.EPackage.class.isInstance(resource.getContents().get(0))) {
            throw new TransformationException("Input Ecore file has no root package");
        }

        // get EPackage out of the resource
        return (EPackage) resource.getContents().get(0);

    }

    /**
     * Help method for getting the instances list out of the input File. Preconditions: inputFile != null && inputFile
     * != "" && validURI(inputFile) && modelPackage != null
     * 
     * @param inputFile
     * @param modelPackage
     * @return EList<?> EObject List
     * @throws TransformationException
     */
    protected EList<?> getInstanceList(String inputFile, EPackage modelPackage) throws TransformationException {

        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
        resourceSet.getPackageRegistry().put(modelPackage.getNsURI(), modelPackage);// IMPORTANT!!!
        Resource resource = null;

        // read input ecore file in memory structure
        if (inputFile == null || inputFile.equals("")) {
            throw new TransformationException("invalid Instances File");
        }

        resourceSet.getResource(URI.createFileURI(inputFile), true);
        resource = (Resource) resourceSet.getResources().get(0);

        // check, if ecore file contains elements at all
        if (resource.getContents().size() == 0) {
            throw new TransformationException("No Instances in Instances File");
        }

        // return the instances List
        return resource.getContents();
    }

    /**
     * Help method for the transformation process -> calls another help method for each transformation task.
     * Preconditions: ep != null && ontModel != null
     * 
     * @param ep
     * @param ontModel
     */
    protected void transformEcore2OWL(EPackage ep, OntModel ontModel) {

        // create the Ontologyheader info from the EPackage (namespace declarations, name, comments,...)
        createOntologyheader(ep, ontModel);

        // create Classes (EClass)
        createClasses(ep, ontModel);

        // create the subclass relationships
        createSubclassRelationships(ep, ontModel);

        // create DatatypeProperties out of the EAttributes
        createDatatypeProperties(ep, ontModel);

        // create ObjectProperties out of the EReferences
        createObjectProperties(ep, ontModel);

        // create (imported) Ontologies out of the Subpackages (EPackages)
        // contains recursive method call (transformEcore2OWL(ep, ontModel)) for subpackages
        createOntologies(ep, ontModel);
    }

    /**
     * Help method for the creation of the Ontologyheader info (namespace declarations, name, comments,...).
     * Preconditions: ep != null && ontModel != null && validURI(ep.getNsURI())
     * 
     * @param ep
     * @param ontModel
     * @return Ontology description
     */
    protected Ontology createOntologyheader(EPackage ep, OntModel ontModel) {

        // create the namespace of the Ontology
        String ns = ep.getNsURI() + "#";
        ontModel.setNsPrefix(ep.getNsPrefix(), ns);

        // create the name of the Ontology
        Ontology ontology = ontModel.createOntology(ns + ep.getName());

        // create the label of the Ontology
        // ontology.addLabel("EPackage - " + ep.getName(), "en");
        ontology.addLabel(ep.getName(), "en");

        // create the comments of the Ontology
        createComments(ep, ontology);

        return ontology;
    }

    /**
     * Help method for the creation of Classes (EClass). Preconditions: ep != null && ontModel != null
     * 
     * @param ep
     * @param ontModel
     */
    protected void createClasses(EPackage ep, OntModel ontModel) {

        EClassifier classifier = null;
        Iterator<?> classifierList = ep.getEClassifiers().iterator();

        while (classifierList.hasNext()) {

            classifier = (EClassifier) classifierList.next();

            if (classifier instanceof EClass) {
                createClass((EClass) classifier, ontModel);
            }
        }
    }

    /**
     * Help method for the creation of a OwlClass out of an EClass. Preconditions: eClass != null && ontModel != null.
     * 
     * @param eClass
     * @param ontModel
     * @return OntClass
     */
    protected OntClass createClass(EClass eClass, OntModel ontModel) {

        OntClass owlClass = ontModel.createClass(eClass.getEPackage().getNsURI() + "#" + eClass.getName());
        String label = null;

        // create the label for the EClass
        label = eClass.getName();
        owlClass.addLabel(label, "en");

        // create the comments for the EClass
        createComments(eClass, owlClass);

        return owlClass;

    }

    /**
     * Help method for the creation of the subclass relationships. Preconditions: ep != null && ontModel != null.
     * 
     * @param ep
     * @param ontModel
     */
    protected void createSubclassRelationships(EPackage ep, OntModel ontModel) {

        EClassifier classifier = null;
        EClass eClass = null;
        EClass eFather = null;
        OntClass owlClass = null;
        OntClass owlFather = null;
        Iterator<?> classifierList = ep.getEClassifiers().iterator();

        // traverse through all classifiers
        while (classifierList.hasNext()) {

            classifier = (EClassifier) classifierList.next();
            if (classifier instanceof EClass) {

                eClass = (EClass) classifier;
                owlClass = ontModel.getOntClass(ep.getNsURI() + "#" + eClass.getName());

                // traverse through all superClasses
                for (Iterator<?> superClassList = eClass.getESuperTypes().iterator(); superClassList.hasNext();) {
                    eFather = (EClass) superClassList.next();
                    owlFather = ontModel.getOntClass(eFather.getEPackage().getNsURI() + "#" + eFather.getName());

                    if (owlFather == null) {// owlFather is in a not yet visited subpackage
                        owlFather = createClass(eFather, ontModel);
                    }

                    owlClass.addSuperClass(owlFather);

                    // create the import relationship, if necessary TODO: Check
                    createImportRelationship(owlClass, ep, owlFather, eFather.getEPackage());
                }
            }
        }
    }

    /**
     * Help method for the creation of the Datatype properties out of the EAttributes. Preconditions ep != null &&
     * ontModel != null.
     * 
     * TODO: Check what should be done with the "self-defined" datatype properties
     * 
     * @param ep
     * @param ontModel
     */
    protected void createDatatypeProperties(EPackage ep, OntModel ontModel) {

        EClassifier classifier = null;
        EClass eClass = null;
        OntClass owlClass = null;
        EAttribute eAttribute = null;
        DatatypeProperty datatypeProperty = null;
        String ns = ep.getNsURI() + "#";

        // create the xsd namespace for the Ontology
        ontModel.setNsPrefix("xsd", XSD.getURI());

        Iterator<?> classifierList = ep.getEClassifiers().iterator();

        // traverse through all classifiers
        while (classifierList.hasNext()) {

            classifier = (EClassifier) classifierList.next();
            if (classifier instanceof EClass) {

                eClass = (EClass) classifier;
                owlClass = ontModel.createClass(ns + eClass.getName());

                // traverse through all EAttributes of the EClass
                Iterator<?> eAttributesList = eClass.getEAttributes().iterator();
                while (eAttributesList.hasNext()) {

                    eAttribute = (EAttribute) eAttributesList.next();
                    datatypeProperty = ontModel.createDatatypeProperty(ns + eAttribute.getName());

                    // create the label for the datatypeProperty
                    // datatypeProperty.addLabel("EAttribute - " + eAttribute.getName(), "en");
                    datatypeProperty.addLabel(eAttribute.getName(), "en");

                    // set the domain for the datatypeProperty
                    datatypeProperty.addDomain(owlClass);

                    // Attributetype is set correctly
                    if (eAttribute.getEAttributeType() != null) {

                        // set the range for the datatypeProperty
                        if (!org.eclipse.emf.ecore.EEnum.class.isInstance(eAttribute.getEAttributeType())) {// type is
                                                                                                            // not an
                                                                                                            // EEnum

                            // type distinction => list of supported types
                            if (eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getEBoolean()) {// boolean
                                datatypeProperty.addRange(XSD.xboolean);
                            } else if (eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getEByte()) {// byte
                                datatypeProperty.addRange(XSD.xbyte);
                            } else if (eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getEShort()) {// short
                                datatypeProperty.addRange(XSD.xshort);
                            } else if (eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getEInt()) {// int
                                datatypeProperty.addRange(XSD.xint);
                            } else if (eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getEIntegerObject()) {// Integer
                                datatypeProperty.addRange(XSD.integer);
                            } else if (eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getELong()) {// long
                                datatypeProperty.addRange(XSD.xlong);
                            } else if (eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getEFloat()) {// float
                                datatypeProperty.addRange(XSD.xfloat);
                            } else if (eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getEDouble()) {// double
                                datatypeProperty.addRange(XSD.xdouble);
                            } else if (eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getEString()
                                || eAttribute.getEAttributeType().getInstanceClass() == String.class
                                || eAttribute.getEAttributeType() == EcorePackage.eINSTANCE.getEChar()) {// string
                                datatypeProperty.addRange(XSD.xstring);
                            } else if (eAttribute.getEAttributeType()
                                    .getInstanceClass() == XMLGregorianCalendar.class) {
                                datatypeProperty.addRange(XSD.dateTime);
                            }

                            if (datatypeProperty.getRange() == null) { // self defined Datatype
                                datatypeProperty.addRange(XSD.xstring);

                                // TODO: Revisit if necessary

                                // RDFDatatype datatype =
                                // createDatatype((EDataType) eAttribute.getEAttributeType(), ontModel);
                                // OntResource JENAOntResource = ontModel.createOntResource(datatype.getURI());
                                // datatypeProperty.addRange(JENAOntResource);
                                // datatypeProperty.addComment(
                                // "xdatatype"
                                // + " "
                                // + ((EDataType) eAttribute.getEAttributeType()).getName()
                                // + " "
                                // + ((EDataType) eAttribute.getEAttributeType()).getEPackage()
                                // .getNsPrefix() + " "
                                // + ((EDataType) eAttribute.getEAttributeType()).getEPackage().getNsURI()
                                // + " " + "testinput/daml+oil-ex-dt.xsd", null);

                            }

                            // unsupported type
                            if (datatypeProperty.getRange() == null) {
                                System.out.println("unsupported type: " + eAttribute.getEAttributeType().toString());
                                System.out.println(datatypeProperty.getDomain());

                            }

                        } else {

                            // type is an EEnum
                            datatypeProperty.addComment(
                                    "xdatarange" + " " + ((EEnum) eAttribute.getEAttributeType()).getName() + " "
                                        + ((EEnum) eAttribute.getEAttributeType()).getEPackage().getNsPrefix() + " "
                                        + ((EEnum) eAttribute.getEAttributeType()).getEPackage().getNsURI(),
                                    null);
                            datatypeProperty
                                    .addRange(createEnumeration((EEnum) eAttribute.getEAttributeType(), ontModel));
                        }
                    }

                    // create the Cardinality Restrictions for the datatypeProperty
                    if (eAttribute.getLowerBound() >= 0) {
                        owlClass.addSuperClass(ontModel.createMinCardinalityRestriction(null, datatypeProperty,
                                eAttribute.getLowerBound()));
                    }
                    if (eAttribute.getUpperBound() >= 0) {
                        owlClass.addSuperClass(ontModel.createMaxCardinalityRestriction(null, datatypeProperty,
                                eAttribute.getUpperBound()));
                    }
                    // create the comments for the datatypeProperty
                    createComments(eAttribute, datatypeProperty);
                }
            }
        }
    }

    /**
     * Help method for the creation of a SELF DEFINED Datatype. Preconditions: eDataType != null && ontModel != null.
     * 
     * TODO check suitability of this method
     * 
     * @param eDataType
     * @param ontModel
     * @return RDFDatatype
     */
    protected RDFDatatype createDatatype(EDataType eDataType, OntModel ontModel) {

        String fileName = "testinput/daml+oil-ex-dt.xsd";
        RDFDatatype JENARDFDatatype = null;
        TypeMapper tm = TypeMapper.getInstance();

        try {
            XSDDatatype.loadUserDefined(eDataType.getEPackage().getNsURI(), new FileReader(fileName), null, tm);

            // create the namespace for the datatype
            ontModel.setNsPrefix(eDataType.getEPackage().getNsPrefix(), eDataType.getEPackage().getNsURI() + "#");

        } catch (Exception e) {
            e.printStackTrace();
        }

        JENARDFDatatype = tm.getSafeTypeByName(eDataType.getEPackage().getNsURI() + "#" + eDataType.getName());

        return JENARDFDatatype;
    }

    /**
     * Help method for the creation of a data range(s) out of an EEnum. Preconditions eEnum != null && ontModel != null.
     * 
     * @param eEnum
     * @param ontModel
     * @return DataRange
     */
    protected DataRange createEnumeration(EEnum eEnum, OntModel ontModel) {

        EEnumLiteral enumLiteral = null;
        DataRange dr = null;
        RDFList rl = ontModel.createList();
        Iterator<?> et = eEnum.getELiterals().iterator();

        // add literals to the Datarange
        while (et.hasNext()) {
            enumLiteral = (EEnumLiteral) et.next();
            rl = rl.cons(ontModel.createTypedLiteral(enumLiteral.getName()));
        }

        dr = ontModel.createDataRange(rl);

        // create the label for the EEnum
        dr.addLabel("EEnum - " + eEnum.getName(), null);

        // create the comments for the EEnum
        createComments(eEnum, dr);

        return dr;
    }

    /**
     * Help method for the creation of the ObjectProperties out of the EReferences. Preconditions: ep != null &&
     * ontModel != null.
     * 
     * @param ep
     * @param ontModel
     */
    protected void createObjectProperties(EPackage ep, OntModel ontModel) {

        EClassifier classifier = null;
        EClass eClass = null;
        OntClass owlClass = null;
        EReference eReference = null;
        ObjectProperty objectProperty = null;
        OntClass range = null;
        Iterator<?> classifierList = ep.getEClassifiers().iterator();
        String ns = ep.getNsURI() + "#";

        // traverse through all classifiers
        while (classifierList.hasNext()) {

            classifier = (EClassifier) classifierList.next();
            if (classifier instanceof EClass) {

                eClass = (EClass) classifier;
                owlClass = ontModel.getOntClass(ns + eClass.getName());

                // traverse through all EAttributes of the EClass
                Iterator<?> eReferencesList = eClass.getEReferences().iterator();
                while (eReferencesList.hasNext()) {

                    eReference = (EReference) eReferencesList.next();
                    objectProperty = ontModel.createObjectProperty(ns + eReference.getName());

                    // create the label for the objectProperty
                    objectProperty.addLabel(eReference.getName(), "en");

                    // TODO: revisit, check if necessary
                    // if (eReference.isContainment())
                    // objectProperty.addSuperProperty(containment);

                    // set the domain for the objectProperty
                    objectProperty.addDomain(owlClass);

                    // Referencetype is set correctly
                    if (eReference.getEReferenceType() != null) {

                        // set the range for the objectProperty
                        range = ontModel.getOntClass(eReference.getEReferenceType().getEPackage().getNsURI() + "#"
                            + eReference.getEReferenceType().getName());

                        if (range == null) {// range is in a not yet visited subpackage
                            range = createClass(eReference.getEReferenceType(), ontModel);
                        }

                        objectProperty.addRange(range);

                        // create the import relationship, if necessary
                        createImportRelationship(owlClass, ep, range, eReference.getEReferenceType().getEPackage());
                    }

                    // create the Cardinality Restrictions for the objectProperty
                    if (eReference.getLowerBound() >= 0) {
                        owlClass.addSuperClass(ontModel.createMinCardinalityRestriction(null, objectProperty,
                                eReference.getLowerBound()));
                    }
                    if (eReference.getUpperBound() >= 0) {
                        owlClass.addSuperClass(ontModel.createMaxCardinalityRestriction(null, objectProperty,
                                eReference.getUpperBound()));
                    }

                    // create the comments for the objectProperty
                    createComments(eReference, objectProperty);
                }
            }
        }
    }

    /**
     * Help method for the creation of the import relationships between the Ontologies. Preconditions: root != null &&
     * rootPackage != null && importedResource != null && importedPackage != null.
     * 
     * @param root
     * @param rootPackage
     * @param importedResource
     * @param importedPackage
     */
    protected void createImportRelationship(OntResource root, EPackage rootPackage, OntResource importedResource,
        EPackage importedPackage) {

        createOntologyheader(importedPackage, importedResource.getOntModel());

        // TODO: the handling of other ecore is not important at the moment, consider to handle it in the future. as the
        // current handling procedure seems not suitable for the typical usage in OWL world

        // Ontology rootOntology = root.getOntModel().getOntology(rootPackage.getNsURI() + "#" + rootPackage.getName());
        // Ontology importedOntology =
        // importedResource.getOntModel().getOntology(importedPackage.getNsURI() + "#" + importedPackage.getName());

        // Ontology has not yet been created
        // if (importedOntology == null) {
        // importedOntology = createOntologyheader(importedPackage, importedResource.getOntModel());
        // }

        // // ontology should not import itself
        // if (rootOntology != importedOntology) {
        // rootOntology.addImport(importedOntology);
        // }
    }

    /**
     * Gelp method for the creation of the Ontologies out of the Subpackages (EPackage). Preconditions ep != null &&
     * ontModel != null.
     * 
     * @param ep
     * @param ontModel
     */
    protected void createOntologies(EPackage ep, OntModel ontModel) {

        EPackage eSubPackage = null;
        Iterator<?> eSubPackagesList = ep.getESubpackages().iterator();

        // traverse through all subpackages
        while (eSubPackagesList.hasNext()) {

            eSubPackage = (EPackage) eSubPackagesList.next();

            // create the ontology for the subpackage
            transformEcore2OWL(eSubPackage, ontModel);

        }
    }

    /**
     * Help method for the creation of the comments. Preconditions: eElement != null && resource != null.
     * 
     * @param eElement
     * @param resource
     */
    protected void createComments(ENamedElement eElement, OntResource resource) {

        EAnnotation eAnnotation = null;
        Object[] keys = null;
        Iterator<?> annotationList = eElement.getEAnnotations().iterator();

        // traverse through the list of the annotations
        while (annotationList.hasNext()) {

            eAnnotation = (EAnnotation) annotationList.next();

            // create comment out of source attribute
            // if (!eAnnotation.getSource().equals("")) {
            // resource.addComment(eAnnotation.getSource(), null);
            // }

            // create comments out of the details attribute
            keys = eAnnotation.getDetails().keySet().toArray();
            for (int i = 0; i < keys.length; i++) {
                if (keys[i].toString().equalsIgnoreCase("documentation")) {
                    resource.addComment(eAnnotation.getDetails().get(keys[i]).toString(), "en");
                }
                // resource.addComment(eAnnotation.getSource() + ": Key=" + keys[i].toString() + "; Value="
                // + eAnnotation.getDetails().get(keys[i]).toString() + ";", null);
            }
        }
    }

    /**
     * Help method for the creation of individuals. Preconditions: instanceList != null && ontModel != null &&
     * instanceMapping != null.
     * 
     * @param instanceList
     * @param ontModel
     * @param instanceMapping
     * @throws TransformationException
     */
    protected void createIndividuals(EList<?> instanceList, OntModel ontModel,
        HashMap<EObject, Individual> instanceMapping) throws TransformationException {

        // Metamodel objects
        EObject instance = null;

        Iterator<?> iter = instanceList.iterator();

        // traverse through all instances
        while (iter.hasNext()) {
            instance = (EObject) iter.next();
            createIndividual(instance, ontModel, instanceMapping);
        }
    }

    /**
     * Recursive function to create individual. Since containment is used heavily within model, it has to be solved via
     * recursive function of each individuals.
     * 
     * TODO check whether the recursive function is better done with conjuction with other creation method (properties,
     * comments, etc.)
     * 
     * @param instance
     * @param ontModel
     * @param instanceMapping
     * @throws TransformationException
     */
    protected void createIndividual(EObject instance, OntModel ontModel, HashMap<EObject, Individual> instanceMapping)
        throws TransformationException {

        Individual individual = null;
        OntClass owlType = null;
        EClass type = null;

        type = instance.eClass();

        // get the owlType
        owlType = ontModel.getOntClass(type.getEPackage().getNsURI() + "#" + type.getName());
        if (owlType == null) {
            throw new TransformationException("Type of Instance is not part of the Model");
        }

        // create the individual TODO: could be better named
        StringBuffer sb = new StringBuffer(type.getEPackage().getNsURI()).append("#");

        sb.append(type.getName()).append("_").append(counter++);

        // String str = createUniqueName();

        individual = ontModel.createIndividual(sb.toString(), owlType);
        // System.out.println(individual.getLocalName());

        // add the individual to the mapping
        instanceMapping.put(instance, individual);

        Iterator<EStructuralFeature> iterFeatures = type.getEAllStructuralFeatures().iterator();
        EStructuralFeature feature = null;
        Individual referencedIndividual = null;
        EObject innerInstance = null;

        // traverse through all References to create individuals
        while (iterFeatures.hasNext()) {
            feature = (EStructuralFeature) iterFeatures.next();
            if (instance.eIsSet(feature)) {
                if (feature instanceof EReference) {
                    // get the corresponding objectproperty out of the ontModel
                    if (feature.getUpperBound() > 1 || feature.getUpperBound() < 0) {// list of values
                        Iterator<?> iterObjects = ((List<?>) instance.eGet(feature)).iterator();
                        while (iterObjects.hasNext()) {

                            innerInstance = (EObject) iterObjects.next();
                            referencedIndividual = (Individual) instanceMapping.get(innerInstance);

                            if (referencedIndividual == null) {
                                createIndividual(innerInstance, ontModel, instanceMapping);
                            }
                        }
                    } else {// only one value is referenced -> maxcardinality = 1

                        referencedIndividual = (Individual) instanceMapping.get(instance.eGet(feature));

                        if (referencedIndividual == null) {
                            innerInstance = (EObject) instance.eGet(feature);
                            createIndividual(innerInstance, ontModel, instanceMapping);
                        }
                    }
                }
            }
        }
    }

    /**
     * Help method for the creation of the statements of the individuals. Preconditions: instanceList != null &&
     * ontModel != null && instanceMapping != null.
     * 
     * @param instanceList
     * @param ontModel
     * @param instanceMapping
     * @throws TransformationException
     */
    protected void createStatements(EList<?> instanceList, OntModel ontModel,
        HashMap<EObject, Individual> instanceMapping) throws TransformationException {

        // Metamodel objects
        EObject instance = null;
        EClass type = null;

        // Ontology objects
        Individual individual = null;
        Individual referencedIndividual = null;

        DatatypeProperty datatypeProperty = null;
        ObjectProperty objectProperty = null;

        Iterator<?> iter = instanceMapping.keySet().iterator();
        Iterator<?> iterFeatures = null;
        EStructuralFeature feature = null;

        // traverse through all instances
        while (iter.hasNext()) {

            instance = (EObject) iter.next();
            type = instance.eClass();

            // get the individual
            individual = (Individual) instanceMapping.get(instance);

            iterFeatures = type.getEAllStructuralFeatures().iterator();

            // traverse through all features (Attributes and References)
            while (iterFeatures.hasNext()) {

                feature = (EStructuralFeature) iterFeatures.next();
                // System.out.println("- " + feature.getName());

                // if this instance has a value for this attribute or reference
                if (instance.eIsSet(feature)) {

                    // the feature is a reference -> objectProperty
                    if (feature instanceof EReference) {

                        // get the corresponding objectproperty out of the ontModel
                        objectProperty = ontModel.getObjectProperty(
                                feature.getEContainingClass().getEPackage().getNsURI() + "#" + feature.getName());
                        if (objectProperty == null) {
                            throw new TransformationException(
                                    "ObjectProperty for Statement Creation not found: " + feature.toString());
                        }

                        // create the statements
                        if (feature.getUpperBound() > 1 || feature.getUpperBound() < 0) {// list of values
                            Iterator<?> iterObjects = ((List<?>) instance.eGet(feature)).iterator();
                            while (iterObjects.hasNext()) {
                                referencedIndividual = (Individual) instanceMapping.get(iterObjects.next());

                                if (referencedIndividual == null) {
                                    OntResource range = objectProperty.getRange();
                                    referencedIndividual =
                                        ontModel.createIndividual(range.getURI() + "Individual" + counter++, range);
                                }

                                individual.addProperty(objectProperty, referencedIndividual);
                            }
                        } else {// only one value is referenced -> maxcardinality = 1

                            referencedIndividual = (Individual) instanceMapping.get(instance.eGet(feature));

                            if (referencedIndividual == null) {
                                OntResource range = objectProperty.getRange();
                                referencedIndividual =
                                    ontModel.createIndividual(range.getURI() + "Individual" + counter++, range);
                            }

                            individual.addProperty(objectProperty, referencedIndividual);
                        }
                    }

                    // the feature is an attribute -> datatypeProperty
                    else if (feature instanceof EAttribute) {

                        // get the corresponding datatypeProperty out of the ontModel
                        datatypeProperty = ontModel.getDatatypeProperty(
                                feature.getEContainingClass().getEPackage().getNsURI() + "#" + feature.getName());
                        if (datatypeProperty == null) {
                            throw new TransformationException(
                                    "DatatypeProperty for Statement Creation not found: " + feature.toString());
                        }

                        // create the statements
                        if (feature.getUpperBound() > 1 || feature.getUpperBound() < 0) {// list of values
                            Iterator<?> iterObjects = ((List<?>) instance.eGet(feature)).iterator();
                            while (iterObjects.hasNext()) {
                                Literal literal = createTypedLiteral(iterObjects.next(), ontModel);
                                individual.addProperty(datatypeProperty, literal);
                            }
                        } else {// only one value is referenced -> maxcardinality = 1
                            Literal literal = createTypedLiteral(instance.eGet(feature), ontModel);
                            individual.addProperty(datatypeProperty, literal);
                        }
                    }
                }
            } // end iteration over features
        } // end iteration over instances
    }

    /**
     * Help method for the creation of Literals.
     * 
     * @param obj
     * @param ontModel
     * @return OWL literal
     * @throws TransformationException
     */
    protected Literal createTypedLiteral(Object obj, OntModel ontModel) throws TransformationException {

        Literal literal = null;

        if (obj instanceof Boolean) {
            literal = ontModel.createTypedLiteral(((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            literal = ontModel.createTypedLiteral(((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            literal = ontModel.createTypedLiteral(((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            literal = ontModel.createTypedLiteral(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            literal = ontModel.createTypedLiteral(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            literal = ontModel.createTypedLiteral(((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            literal = ontModel.createTypedLiteral(((Double) obj).doubleValue());
        } else if (obj instanceof String) {
            literal = ontModel.createTypedLiteral((String) obj);
        } else if (obj instanceof Character) {
            literal = ontModel.createTypedLiteral((Character) obj);
        } else if (obj instanceof EEnumLiteral) {
            literal = ontModel.createTypedLiteral(((EEnumLiteral) obj).getName());
        } else if (obj instanceof XMLGregorianCalendar) {
            literal = ontModel.createTypedLiteral(((XMLGregorianCalendar) obj).toGregorianCalendar());
        } else if (obj instanceof EDataType) {
            // self defined Datatype
            // TODO
        }
        return literal;
    }

    /**
     * Help method, that converts input file string in an output file string. Preconditions: inputFileName != null.
     * 
     * @param inputFileName
     * @return String output file name
     */
    protected String getOutputFileName(String inputFileName) {

        String outputFileName = null;
        int point = inputFileName.lastIndexOf(".");

        outputFileName = point == -1 ? inputFileName + ".owl" : inputFileName.substring(0, point + 1) + "owl";
        return outputFileName;

    }

    /**
     * Help method, that saves the Ontology with the given filename. Preconditions: filename != null && filename != ""
     * && filename == validpath && ontModel != null.
     * 
     * @param filename
     * @param ontModel
     */
    protected void saveOntology(String filename, OntModel ontModel) {

        try {
            Path path = Paths.get(filename);
            Files.createDirectories(path.getParent());
            ontModel.write(new FileOutputStream(new File(filename)), "RDF/XML");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
