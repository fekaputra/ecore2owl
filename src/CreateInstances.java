import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import MyTestPackage.*;


public class CreateInstances {

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

		MyTestPackageFactory myFactory = MyTestPackageFactory.eINSTANCE;
		
		Root rootObj = myFactory.createRoot();
		Root rootObj2 = myFactory.createRoot();
		
		rootObj.setSelfRef(rootObj2);
		rootObj2.setSelfRef(rootObj);
		
		MySubClass mySubClassObj = myFactory.createMySubClass();
		mySubClassObj.setAge(5);
		mySubClassObj.setColor(Colors.GREEN_LITERAL);
		
		MySubClass mySubClassObj2 = myFactory.createMySubClass();
		mySubClassObj2.setAge(14);
		mySubClassObj2.setColor(Colors.RED_LITERAL);
		
		MySubClass mySubClassObj3 = myFactory.createMySubClass();
		mySubClassObj3.setAge(56);
		mySubClassObj3.setColor(Colors.WHITE_LITERAL);
		
		rootObj.getMySubClasses().add(mySubClassObj);
		rootObj.getMySubClasses().add(mySubClassObj2);
		rootObj.getMySubClasses().add(mySubClassObj3);
		
		rootObj.getNumbers().add(new Integer(1));
		rootObj.getNumbers().add(new Integer(2));
		rootObj.getNumbers().add(new Integer(3));
		
		rootObj2.getNumbers().add(new Integer(8));
		rootObj2.getNumbers().add(new Integer(9));
		rootObj2.getNumbers().add(new Integer(10));
		
		//save the instances
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI("testinput/instancesExtended.xmi"));
		
		resource.getContents().add(rootObj);
		resource.getContents().add(rootObj2);
		
		resource.getContents().add(mySubClassObj);
		resource.getContents().add(mySubClassObj2);
		resource.getContents().add(mySubClassObj3);
		
		try{
			resource.save(null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//**************************************************************
		//**************************************************************
		//**************************************************************
		
		//read in the instances again
		EList instanceList = null;
		try{
			instanceList = getInstanceList("testinput/instancesExtended.xmi", MyTestPackagePackage.eINSTANCE);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
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
