/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.mySubPackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see MyTestPackage.mySubPackage.MySubPackagePackage
 * @generated
 */
public interface MySubPackageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MySubPackageFactory eINSTANCE = new MyTestPackage.mySubPackage.impl.MySubPackageFactoryImpl();

	/**
	 * Returns a new object of class '<em>my Sub Package Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>my Sub Package Class</em>'.
	 * @generated
	 */
	mySubPackageClass createmySubPackageClass();

	/**
	 * Returns a new object of class '<em>my Sub Package Class2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>my Sub Package Class2</em>'.
	 * @generated
	 */
	mySubPackageClass2 createmySubPackageClass2();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MySubPackagePackage getMySubPackagePackage();

} //MySubPackageFactory
