import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.hp.hpl.jena.ontology.DataRange;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.Ontology;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Ecore2OWLTest extends TestCase {

    // *******************************************************************
    // *******************************************************************

    // help method
    private EPackage getEPackage(String inputfile) {

        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
        Resource resource = null;
        try {
            if (inputfile == null || inputfile.equals("")) {
                throw new TransformationException("invalid Ecore File");
            }
            resourceSet.getResource(URI.createFileURI(inputfile), true);
        } catch (Exception e) {
            System.out.println("readEcoreFile Problem");
        }
        resource = (Resource) resourceSet.getResources().get(0);
        if (resource.getContents().size() == 0
            || !org.eclipse.emf.ecore.EPackage.class.isInstance(resource.getContents().get(0))) {
            System.out.println("Input Ecore file has no root package");
        }
        // get EPackage out of the resource
        return (EPackage) resource.getContents().get(0);

    }

    // *******************************************************************
    // *******************************************************************

    /*
     * Test method for 'Ecore2OWLTransformer.convertEcore2OWL(String, String)'
     */
    public void testConvertEcore2OWL() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/transformEcoreTest.ecore";
        String outputfile = "testoutput/transformEcoreTest.owl";

        try {
            transform.convertEcore2OWL(inputfile, outputfile);
        } catch (TransformationException e) {
            System.out.println(e.toString());
        }
    }

    /*
     * Test method for 'Ecore2OWLTransformer.convertEcore2OWLInclusiveInstances(String, String, String)'
     */
    public void testConvertEcore2OWLInclusiveInstances() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/transformEcoreTest.ecore";
        String instancefile = "testinput/instances.xmi";
        String outputfile = "testoutput/transformEcoreTestWithInstances.owl";

        Ecore2OWLTransformer transform2 = new Ecore2OWLTransformer();
        String inputfile2 = "testinput/transformEcoreTestExtended.ecore";
        String instancefile2 = "testinput/instancesExtended.xmi";
        String outputfile2 = "testoutput/transformEcoreTestWithInstancesExtended.owl";

        try {
            transform.convertEcore2OWLInclusiveInstances(inputfile, instancefile, outputfile);
            transform2.convertEcore2OWLInclusiveInstances(inputfile2, instancefile2, outputfile2);

        } catch (TransformationException e) {
            e.printStackTrace();
        }

    }

    /*
     * Test method for 'Ecore2OWLTransformer.transformEcore2OWL(EPackage, OntModel)'
     */
    public void testTransformEcore2OWL() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/transformEcoreTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        transform.transformEcore2OWL(ep, ontModel);

        // ******************************************************************************

        Ontology MyTestPackage = ontModel.getOntology("http://www.mytest.com" + "#" + "MyTestPackage");
        assertNotNull(MyTestPackage);
        assertNotNull(transform.traceModel.lookup(MyTestPackage));

        Ontology mySubPackage = ontModel.getOntology("http://www.mySubtest.com" + "#" + "mySubPackage");
        assertNotNull(mySubPackage);
        assertNotNull(transform.traceModel.lookup(mySubPackage));

        Ontology MySubSubPackage = ontModel.getOntology("http://www.mySubSubtest.com" + "#" + "MySubSubPackage");
        assertNotNull(MySubSubPackage);
        assertNotNull(transform.traceModel.lookup(MySubSubPackage));

        Ontology mySecPackage = ontModel.getOntology("http://www.mySecSubtest.com" + "#" + "mySecPackage");
        assertNotNull(mySecPackage);
        assertNotNull(transform.traceModel.lookup(mySecPackage));

        assertTrue(MyTestPackage.imports(mySubPackage));
        assertTrue(MyTestPackage.imports(mySecPackage));
        assertFalse(MyTestPackage.imports(MySubSubPackage));

        assertTrue(mySubPackage.imports(MyTestPackage));

        assertTrue(MyTestPackage.hasComment("myPackageAnnotation", null));

        // ******************************************************************************

        OntClass Root = ontModel.getOntClass("http://www.mytest.com" + "#" + "Root");
        assertNotNull(Root);
        assertNotNull(transform.traceModel.lookup(Root));

        OntClass MySubClass = ontModel.getOntClass("http://www.mytest.com" + "#" + "MySubClass");
        assertNotNull(MySubClass);
        assertNotNull(transform.traceModel.lookup(MySubClass));

        OntClass MySubSubClass = ontModel.getOntClass("http://www.mytest.com" + "#" + "MySubSubClass");
        assertNotNull(MySubSubClass);
        assertNotNull(transform.traceModel.lookup(MySubSubClass));

        OntClass MyInterfaceClass = ontModel.getOntClass("http://www.mytest.com" + "#" + "MyInterfaceClass");
        assertNotNull(MyInterfaceClass);
        assertNotNull(transform.traceModel.lookup(MyInterfaceClass));

        OntClass mySubPackageClass = ontModel.getOntClass("http://www.mySubtest.com" + "#" + "mySubPackageClass");
        assertNotNull(mySubPackageClass);
        assertNotNull(transform.traceModel.lookup(mySubPackageClass));

        OntClass mySubPackageClass2 = ontModel.getOntClass("http://www.mySubtest.com" + "#" + "mySubPackageClass2");
        assertNotNull(mySubPackageClass2);
        assertNotNull(transform.traceModel.lookup(mySubPackageClass2));

        OntClass MySecPackageClass = ontModel.getOntClass("http://www.mySecSubtest.com" + "#" + "MySecPackageClass");
        assertNotNull(MySecPackageClass);
        assertNotNull(transform.traceModel.lookup(MySecPackageClass));

        assertTrue(Root.hasSubClass());
        assertTrue(Root.hasSubClass(MySubClass));
        assertTrue(Root.hasSubClass(mySubPackageClass));

        assertTrue(Root.hasSubClass());
        assertTrue(Root.hasSuperClass());
        assertTrue(MySubClass.hasSuperClass(Root));
        assertTrue(MySubClass.hasSubClass(MySubSubClass));

        assertFalse(MySubSubClass.hasSubClass());
        assertTrue(MySubSubClass.hasSuperClass());
        assertTrue(MySubSubClass.hasSuperClass(MySubClass));

        assertFalse(MyInterfaceClass.hasSubClass());
        assertTrue(MyInterfaceClass.hasSuperClass());
        assertTrue(MyInterfaceClass.hasSuperClass(mySubPackageClass));

        assertTrue(mySubPackageClass.hasSubClass());
        assertTrue(mySubPackageClass.hasSubClass(MyInterfaceClass));
        assertTrue(mySubPackageClass.hasSuperClass());
        assertTrue(mySubPackageClass.hasSuperClass(Root));

        assertFalse(mySubPackageClass2.hasSubClass());
        assertFalse(mySubPackageClass2.hasSuperClass());

        assertFalse(MySecPackageClass.hasSubClass());
        assertFalse(MySecPackageClass.hasSuperClass());

        // ******************************************************************************

        DatatypeProperty age =
            ontModel.getDatatypeProperty("http://www.mytest.com" + "#" + "MySubClass" + "_" + "age");
        assertNotNull(age);
        assertNotNull(transform.traceModel.lookup(age));

        assertTrue(age.hasDomain(MySubClass));
        assertEquals("http://www.w3.org/2001/XMLSchema#int", age.getRange().toString());

        DatatypeProperty Color =
            ontModel.getDatatypeProperty("http://www.mytest.com" + "#" + "MySubClass" + "_" + "Color");
        assertNotNull(Color);
        assertNotNull(transform.traceModel.lookup(Color));

        assertTrue(Color.hasDomain(MySubClass));

        // ******************************************************************************

        ObjectProperty selfRef = ontModel.getObjectProperty("http://www.mytest.com" + "#" + "Root" + "_" + "selfRef");
        assertNotNull(selfRef);
        assertNotNull(transform.traceModel.lookup(selfRef));

        assertTrue(selfRef.hasDomain(Root));
        assertTrue(selfRef.hasRange(Root));

        ObjectProperty refmysecsubclass =
            ontModel.getObjectProperty("http://www.mytest.com" + "#" + "MySubClass" + "_" + "refmysecsubclass");
        assertNotNull(refmysecsubclass);
        assertNotNull(transform.traceModel.lookup(refmysecsubclass));

        assertTrue(refmysecsubclass.hasDomain(MySubClass));
        assertTrue(refmysecsubclass.hasRange(MySecPackageClass));

        ObjectProperty test =
            ontModel.getObjectProperty("http://www.mytest.com" + "#" + "MyInterfaceClass" + "_" + "test");
        assertNotNull(test);
        assertNotNull(transform.traceModel.lookup(test));

        assertTrue(test.hasDomain(MyInterfaceClass));
        assertTrue(test.hasRange(mySubPackageClass2));

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createOntologyheader(EPackage, OntModel)'
     */
    public void testCreateOntologyheader() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CreateOntologyheaderTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        Ontology ont = transform.createOntologyheader(ep, ontModel);
        assertTrue(ont.hasLabel("EPackage_MyTestPackage", null));
        assertEquals("http://www.mytest.com#", ont.getNameSpace());

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createClassesAndDatatypes(EPackage, OntModel)'
     */
    public void testCreateClassesAndDatatypes() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CreateClassesAndDatatypesTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        transform.createClasses(ep, ontModel);

        OntClass aOnt = ontModel.getOntClass("http://www.mytest.com" + "#" + "ClassA");
        assertTrue(aOnt.hasLabel("EClass_ClassA", null));

        OntClass bOnt = ontModel.getOntClass("http://www.mytest.com" + "#" + "ClassB");
        assertTrue(bOnt.hasLabel("Interface_Abstract_EClass_ClassB", null));

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createClass(EClass, OntModel)'
     */
    public void testCreateClass() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CreateClassesTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        EClass a = (EClass) ep.getEClassifier("ClassA");
        assertNotNull(a);
        EClass b = (EClass) ep.getEClassifier("ClassB");
        assertNotNull(b);

        OntClass aOnt = transform.createClass(a, ontModel);
        assertTrue(aOnt.hasLabel("EClass_ClassA", null));

        OntClass bOnt = transform.createClass(b, ontModel);
        assertTrue(bOnt.hasLabel("Interface_Abstract_EClass_ClassB", null));

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createSubclassRelationships(EPackage, OntModel)'
     */
    public void testCreateSubclassRelationships() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CreateSubClassRelationshipsTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        transform.createOntologyheader(ep, ontModel);// create the root package
        transform.createClasses(ep, ontModel);// create the classes of the root package

        transform.createSubclassRelationships(ep, ontModel);

        OntClass a = ontModel.getOntClass("http://www.mytest.com" + "#" + "ClassA");
        assertNotNull(a);
        assertTrue(a.hasSuperClass());
        assertTrue(a.hasSubClass());

        OntClass b = ontModel.getOntClass("http://www.mytest.com" + "#" + "ClassB");
        assertNotNull(b);
        assertTrue(b.hasSuperClass());
        assertFalse(b.hasSubClass());

        OntClass subA = ontModel.getOntClass("http://www.mysubtest.com" + "#" + "ClassSubA");
        assertNotNull(subA);
        assertFalse(subA.hasSuperClass());
        assertTrue(subA.hasSubClass());

        OntClass sub2A = ontModel.getOntClass("http://www.mysubtest2.com" + "#" + "ClassSub2A");
        assertNotNull(sub2A);
        assertFalse(sub2A.hasSuperClass());
        assertTrue(sub2A.hasSubClass());

        assertTrue(a.hasSubClass(b));
        assertTrue(a.hasSuperClass(subA));
        assertTrue(a.hasSuperClass(sub2A));

        assertTrue(b.hasSuperClass(a));
        assertTrue(subA.hasSubClass(a));
        assertTrue(sub2A.hasSubClass(a));

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createDatatypeProperties(EPackage, OntModel)'
     */
    public void testCreateDatatypeProperties() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CreateDatatypePropertiesTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        transform.createOntologyheader(ep, ontModel);// create the root package
        transform.createClasses(ep, ontModel);// create the classes of the root package

        transform.createDatatypeProperties(ep, ontModel);

        Iterator datatypePropList = ontModel.listDatatypeProperties();

        assertTrue(datatypePropList.hasNext());
        DatatypeProperty prop1 = (DatatypeProperty) datatypePropList.next();
        assertTrue(prop1.hasLabel("EAttribute_ClassA_name", null));
        assertEquals("http://www.mytest.com#ClassA", prop1.getDomain().toString());
        assertEquals("http://www.w3.org/2001/XMLSchema#string", prop1.getRange().toString());

        assertTrue(datatypePropList.hasNext());
        DatatypeProperty prop2 = (DatatypeProperty) datatypePropList.next();
        assertTrue(prop2.hasLabel("EAttribute_ClassA_color", null));
        assertTrue(prop2.hasComment("xdatarange Colors test http://www.mytest.com", null));
        assertEquals("http://www.mytest.com#ClassA", prop2.getDomain().toString());
        assertTrue(prop2.getRange().hasLabel("EEnum_Colors", null));

        assertTrue(datatypePropList.hasNext());
        DatatypeProperty prop3 = (DatatypeProperty) datatypePropList.next();
        assertTrue(prop3.hasLabel("EAttribute_ClassA_flag", null));
        assertEquals("http://www.mytest.com#ClassA", prop3.getDomain().toString());
        assertEquals("http://www.w3.org/2001/XMLSchema#boolean", prop3.getRange().toString());

        assertTrue(datatypePropList.hasNext());
        DatatypeProperty prop4 = (DatatypeProperty) datatypePropList.next();
        assertTrue(prop4.hasLabel("EAttribute_ClassA_number", null));
        assertEquals("http://www.mytest.com#ClassA", prop4.getDomain().toString());

        assertFalse(datatypePropList.hasNext());

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createEnumeration(EEnum, OntModel)'
     */
    public void testCreateEnumeration() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CreateEnumerationTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        Iterator classifierList = ep.getEClassifiers().iterator();
        EClassifier classifier = null;
        DataRange dr = null;

        // traverse through all classifiers
        while (classifierList.hasNext()) {

            classifier = (EClassifier) classifierList.next();

            if (classifier instanceof EEnum) {
                dr = transform.createEnumeration((EEnum) classifier, ontModel);
            }
        }

        assertTrue(dr.hasLabel("EEnum_Colors", null));
        assertTrue(dr.hasComment("bla", null));
        assertTrue(dr.hasOneOf(ontModel.createLiteral("Blue")));
        assertTrue(dr.hasOneOf(ontModel.createLiteral("Yellow")));
        assertTrue(dr.hasOneOf(ontModel.createLiteral("Green")));
        assertFalse(dr.hasOneOf(ontModel.createLiteral("Black")));

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createObjectProperties(EPackage, OntModel)'
     */
    public void testCreateObjectProperties() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CreateObjectPropertiesTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        transform.createOntologyheader(ep, ontModel);// create the root package
        transform.createClasses(ep, ontModel);// create the classes of the root package

        transform.createObjectProperties(ep, ontModel);

        Iterator objPropList = ontModel.listObjectProperties();

        assertTrue(objPropList.hasNext());
        ObjectProperty prop1 = (ObjectProperty) objPropList.next();
        assertTrue(prop1.hasLabel("EReference_ClassA_ClassArefNoType", null));
        assertNull(prop1.getRange());

        assertTrue(objPropList.hasNext());
        ObjectProperty prop2 = (ObjectProperty) objPropList.next();
        assertTrue(prop2.hasLabel("EReference_ClassB_ClassBrefClassSubA", null));

        assertFalse(objPropList.hasNext());

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createImportRelationship(OntResource, EPackage, OntResource, EPackage)'
     */
    public void testCreateImportRelationship() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CreateImportRelationshipTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        transform.transformEcore2OWL(ep, ontModel);

        Ontology root = ontModel.getOntology(ep.getNsURI() + "#" + ep.getName());

        Iterator subpackagesList = ep.getESubpackages().iterator();
        assertTrue(subpackagesList.hasNext());

        EPackage esubPack1 = (EPackage) subpackagesList.next();
        Ontology ont1 = ontModel.getOntology(esubPack1.getNsURI() + "#" + esubPack1.getName());
        assertTrue(ont1.hasLabel("EPackage_MyTestSubPackage", null));

        assertTrue(subpackagesList.hasNext());

        EPackage esubPack2 = (EPackage) subpackagesList.next();
        Ontology ont2 = ontModel.getOntology(esubPack2.getNsURI() + "#" + esubPack2.getName());
        assertTrue(ont2.hasLabel("EPackage_MyTestSubPackage2", null));

        transform.createImportRelationship(root, ep, ont1, esubPack1);
        assertTrue(root.imports(ont1));

        transform.createImportRelationship(root, ep, ont2, esubPack2);
        assertTrue(root.imports(ont2));

        transform.createImportRelationship(root, ep, ont2, esubPack2);
        assertTrue(root.imports(ont2));

        transform.createImportRelationship(root, ep, root, ep);
        assertFalse(root.imports(root));

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createOntologies(EPackage, OntModel)'
     */
    public void testCreateOntologies() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CreateOntologiesTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        transform.createOntologies(ep, ontModel);

        Iterator subpackagesList = ep.getESubpackages().iterator();
        assertTrue(subpackagesList.hasNext());

        EPackage esubPack = (EPackage) subpackagesList.next();
        Ontology ont = ontModel.getOntology(esubPack.getNsURI() + "#" + esubPack.getName());
        assertTrue(ont.hasLabel("EPackage_MyTestSubPackage", null));

        assertTrue(subpackagesList.hasNext());

        esubPack = (EPackage) subpackagesList.next();
        ont = ontModel.getOntology(esubPack.getNsURI() + "#" + esubPack.getName());
        assertTrue(ont.hasLabel("EPackage_MyTestSubPackage2", null));

        assertFalse(subpackagesList.hasNext());

        // impossible
        // transform.createOntologies(null, null); //NullpointerException
        // transform.createOntologies(ep, null); //NullpointerException
        // transform.createOntologies(null, ontModel); //NullpointerException

    }

    /*
     * Test method for 'Ecore2OWLTransformer.createComments(ENamedElement, OntResource)'
     */
    public void testCreateComments() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        String inputfile = "testinput/CommentsTest.ecore";
        EPackage ep = getEPackage(inputfile);
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        OntClass ontClass1 = ontModel.createClass();
        OntClass ontClass2 = ontModel.createClass();
        OntClass ontClass3 = ontModel.createClass();

        Iterator commentsIter = null;
        String comment = null;

        EClass myClassWithoutComments = (EClass) ep.getEClassifier("MyClassWithoutComments");
        EClass myClassWithSimpleComments = (EClass) ep.getEClassifier("MyClassWithSimpleComments");
        EClass myClassWithComplexComments = (EClass) ep.getEClassifier("MyClassWithComplexComments");

        transform.createComments(myClassWithoutComments, ontClass1);
        commentsIter = ontClass1.listComments(null);// get all the comments
        assertFalse(commentsIter.hasNext());

        // *********************************************************************

        transform.createComments(myClassWithSimpleComments, ontClass2);
        commentsIter = ontClass2.listComments(null);// get all the comments
        assertTrue(commentsIter.hasNext());

        comment = commentsIter.next().toString();
        assertEquals("MyComment", comment);

        assertFalse(commentsIter.hasNext());

        // *********************************************************************

        transform.createComments(myClassWithComplexComments, ontClass3);
        commentsIter = ontClass3.listComments(null);// get all the comments
        assertTrue(commentsIter.hasNext());

        comment = commentsIter.next().toString();
        assertEquals("TestComment", comment);

        comment = commentsIter.next().toString();
        assertEquals("TestComment: Key=prop1; Value=value1;", comment);

        comment = commentsIter.next().toString();
        assertEquals("TestComment: Key=prop2; Value=value2;", comment);

        comment = commentsIter.next().toString();
        assertEquals("SecondTestComment", comment);

        comment = commentsIter.next().toString();
        assertEquals("SecondTestComment: Key=prop12; Value=value12;", comment);

        comment = commentsIter.next().toString();
        assertEquals("SecondTestComment: Key=prop22; Value=value22;", comment);

        comment = commentsIter.next().toString();
        assertEquals("ThirdTestComment", comment);

        assertFalse(commentsIter.hasNext());

        // impossible
        // transform.createComments(null, null); //NullpointerException
        // transform.createComments(myClassWithoutComments, null); //NullpointerException
        // transform.createComments(null, ontClass1); //NullpointerException

    }

    /*
     * Test method for 'Ecore2OWLTransformer.getOutputFileName(String)'
     */
    public void testGetOutputFileName() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();

        assertEquals("input.owl", transform.getOutputFileName("input.ecore"));
        assertEquals("Test/input.owl", transform.getOutputFileName("Test/input.ecore"));
        assertEquals("input.owl", transform.getOutputFileName("input"));// possible???
        assertEquals("Test/input.owl", transform.getOutputFileName("Test/input"));// possible???

        // impossible, because .ecore Filename is checked not to be null and not to be ""
        assertEquals(".owl", transform.getOutputFileName(""));
        // transform.getOutputFileName(null);

    }

    /*
     * Test method for 'Ecore2OWLTransformer.saveOntology(String, OntModel)'
     */
    public void testSaveOntology() {

        Ecore2OWLTransformer transform = new Ecore2OWLTransformer();
        OntModel ontModel = ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        ;

        transform.saveOntology("testoutput/TestSave.owl", ontModel);

        // impossible, because .owl will be attaced automatically
        // transform.saveOntology("testoutput/TestSave", ontModel);

        // impossible, because unvalid path would be recognised already while reading in .ecore file
        // transform.saveOntology("xy/TestSave", ontModel);

        // impossible, because filename can't be "" or null -> otherwise TransformationException
        // transform.saveOntology("", ontModel);
        // transform.saveOntology(null, ontModel);

        // impossible, because OntModel is initialized
        // transform.saveOntology("testoutput/Test.owl", null);

    }
}
