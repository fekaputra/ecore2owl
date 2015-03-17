/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.mySecPackage.impl;

import MyTestPackage.mySecPackage.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MySecPackageFactoryImpl extends EFactoryImpl implements MySecPackageFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySecPackageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MySecPackagePackage.MY_SEC_PACKAGE_CLASS: return createMySecPackageClass();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySecPackageClass createMySecPackageClass() {
		MySecPackageClassImpl mySecPackageClass = new MySecPackageClassImpl();
		return mySecPackageClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySecPackagePackage getMySecPackagePackage() {
		return (MySecPackagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static MySecPackagePackage getPackage() {
		return MySecPackagePackage.eINSTANCE;
	}

} //MySecPackageFactoryImpl
