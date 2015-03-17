/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.mySubPackage.impl;

import MyTestPackage.mySubPackage.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MySubPackageFactoryImpl extends EFactoryImpl implements MySubPackageFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySubPackageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS: return createmySubPackageClass();
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS2: return createmySubPackageClass2();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public mySubPackageClass createmySubPackageClass() {
		mySubPackageClassImpl mySubPackageClass = new mySubPackageClassImpl();
		return mySubPackageClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public mySubPackageClass2 createmySubPackageClass2() {
		mySubPackageClass2Impl mySubPackageClass2 = new mySubPackageClass2Impl();
		return mySubPackageClass2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySubPackagePackage getMySubPackagePackage() {
		return (MySubPackagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static MySubPackagePackage getPackage() {
		return MySubPackagePackage.eINSTANCE;
	}

} //MySubPackageFactoryImpl
