import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import java.util.ArrayList;

public class CreateInstancesReflective {

	//help method for getting the EPackage out of the input File
    //Preconditions: inputFile != null && inputFile != "" && validURI(inputFile)
	protected static EPackage getEPackage(String inputFile) throws TransformationException{
	
		ResourceSet resourceSet = new ResourceSetImpl();
	    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
	    Resource resource = null;
	    
    	//read input ecore file in memory structure
    	if(inputFile == null || inputFile.equals("")){
    		throw new TransformationException("invalid Ecore File");
    	}
    	
    	resourceSet.getResource(URI.createFileURI(inputFile), true);
    	resource = (Resource) resourceSet.getResources().get(0);
    	
    	//check, if ecore file contains root package/elements at all
    	if(resource.getContents().size() == 0 || !org.eclipse.emf.ecore.EPackage.class.isInstance(resource.getContents().get(0))){
    		throw new TransformationException("Input Ecore file has no root package");
    	}
    	
    	//get EPackage out of the resource
    	return (EPackage) resource.getContents().get(0);		
		
	}

	
	//help method for getting the instances list out of the input File
	//Preconditions: inputFile != null && inputFile != "" && validURI(inputFile) && modelPackage != null
	protected static EList getInstanceList(String inputFile, EPackage modelPackage) throws TransformationException{
		
		ResourceSet resourceSet = new ResourceSetImpl();
	    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
	    resourceSet.getPackageRegistry().put(modelPackage.getNsURI(), modelPackage);//IMPORTANT!!!
	    Resource resource = null;
	    
    	//read input ecore file in memory structure
    	if(inputFile == null || inputFile.equals("")){
    		throw new TransformationException("invalid Instances File");
    	}
    	
    	resourceSet.getResource(URI.createFileURI(inputFile), true);
    	resource = (Resource) resourceSet.getResources().get(0);
    	
    	//check, if ecore file contains elements at all
    	if(resource.getContents().size() == 0){
    		throw new TransformationException("No Instances in Instances File");
    	}
    	
    	//return the instances List
    	return resource.getContents();	
	}

	
	public static void main(String[] args) {
        
		String fileName = "testinput/transformEcoreTest.ecore";
		EPackage ep = null;
		
		//read the model
		try{
			ep = getEPackage(fileName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
        
		//get the model objects
		EFactory myFactory = ep.getEFactoryInstance();
		
		EClass rootClass = (EClass) ep.getEClassifier("Root");
		EClass mySubClass = (EClass) ep.getEClassifier("MySubClass");
		EClass myInterfaceClass = (EClass) ep.getEClassifier("MyInterfaceClass");
		
		EReference selfRef = (EReference) rootClass.getEStructuralFeature("selfRef");
		EReference mySubClassesRef = (EReference) rootClass.getEStructuralFeature("MySubClasses");
		
		EAttribute ageAtt = (EAttribute) mySubClass.getEStructuralFeature("age");				
		EAttribute ColorAtt = (EAttribute) mySubClass.getEStructuralFeature("Color");
		EAttribute theAgeAtt = (EAttribute) myInterfaceClass.getEStructuralFeature("theAge");
		
		EDataType colorDT = (EDataType) ep.getEClassifier("Colors");
		EDataType over12DT = (EDataType) ep.getEClassifier("over12");
		
		//create instances
		
		EObject rootObj = myFactory.create(rootClass);
		EObject rootObj2 = myFactory.create(rootClass);
		
		rootObj.eSet(selfRef, rootObj2);
		rootObj2.eSet(selfRef, rootObj);
		
		EObject mySubClassObj = myFactory.create(mySubClass);
		mySubClassObj.eSet(ColorAtt, myFactory.createFromString(colorDT, "Green"));
		mySubClassObj.eSet(ageAtt, new Integer(5));
		
		EObject mySubClassObj2 = myFactory.create(mySubClass);
		mySubClassObj2.eSet(ColorAtt, myFactory.createFromString(colorDT, "Red"));
		mySubClassObj2.eSet(ageAtt, new Integer(14));
		
		EObject mySubClassObj3 = myFactory.create(mySubClass);
		mySubClassObj3.eSet(ColorAtt, myFactory.createFromString(colorDT, "White"));
		mySubClassObj3.eSet(ageAtt, new Integer(56));
		
		ArrayList myList = new ArrayList();
		myList.add(mySubClassObj);
		myList.add(mySubClassObj2);
		myList.add(mySubClassObj3);
		
		rootObj.eSet(mySubClassesRef, myList);
		
		EObject myInterfaceClassObj = myFactory.create(myInterfaceClass);
		myInterfaceClassObj.eSet(theAgeAtt, myFactory.createFromString(over12DT, "13"));
		
		//save the instances
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI("testinput/instances.xmi"));
		
		resource.getContents().add(rootObj);
		resource.getContents().add(rootObj2);
		
		resource.getContents().add(mySubClassObj);
		resource.getContents().add(mySubClassObj2);
		resource.getContents().add(mySubClassObj3);
		
		resource.getContents().add(myInterfaceClassObj);
		
		try{
			resource.save(null);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		//*****************************************************************************
		//*****************************************************************************
		//*****************************************************************************
		
		//read the instances
		EList instanceList = null;
		try{
			 instanceList = getInstanceList("testinput/instances.xmi", ep);
		}
		catch(Exception e){
			e.printStackTrace();
		}

    	//traverse through all instances
    	
    	EObject instance = null;
    	EClass type = null;
    	EStructuralFeature feature = null;
    	Iterator iter = instanceList.iterator();
    	
    	while(iter.hasNext()){
    		
    		instance = (EObject) iter.next();    		
    		System.out.println("processing: " + instance.toString());
    		
    		//get the type of the instance
    		type = instance.eClass();
    		System.out.println("Type: " + type.toString());
    		
    		//get the references and attributes of the instance
    		System.out.println("EReferences and EAttributes of the instance");
    		Iterator iter2 = type.getEAllStructuralFeatures().iterator();
    		while(iter2.hasNext()){
    			feature = (EStructuralFeature) iter2.next();
    			
    			if(instance.eIsSet(feature)){
    				if(feature instanceof EReference){
    					System.out.print("EReference: ");
    				}
    				else if(feature instanceof EAttribute){
    					System.out.print("EAttribute: ");
    				}
    				System.out.println("Value of feature: " + feature.getName() +" is: " + instance.eGet(feature));
    			}
    		}    		
    		System.out.println("\n");
    	}	
		
	}

}
