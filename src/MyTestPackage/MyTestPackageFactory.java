/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see MyTestPackage.MyTestPackagePackage
 * @generated
 */
public interface MyTestPackageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MyTestPackageFactory eINSTANCE = new MyTestPackage.impl.MyTestPackageFactoryImpl();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	Root createRoot();

	/**
	 * Returns a new object of class '<em>My Sub Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>My Sub Class</em>'.
	 * @generated
	 */
	MySubClass createMySubClass();

	/**
	 * Returns a new object of class '<em>My Sub Sub Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>My Sub Sub Class</em>'.
	 * @generated
	 */
	MySubSubClass createMySubSubClass();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MyTestPackagePackage getMyTestPackagePackage();

} //MyTestPackageFactory
