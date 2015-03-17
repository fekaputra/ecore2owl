/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.mySecPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see MyTestPackage.mySecPackage.MySecPackageFactory
 * @model kind="package"
 * @generated
 */
public interface MySecPackagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mySecPackage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.mySecSubtest.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mySecSub";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MySecPackagePackage eINSTANCE = MyTestPackage.mySecPackage.impl.MySecPackagePackageImpl.init();

	/**
	 * The meta object id for the '{@link MyTestPackage.mySecPackage.impl.MySecPackageClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MyTestPackage.mySecPackage.impl.MySecPackageClassImpl
	 * @see MyTestPackage.mySecPackage.impl.MySecPackagePackageImpl#getMySecPackageClass()
	 * @generated
	 */
	int MY_SEC_PACKAGE_CLASS = 0;

	/**
	 * The number of structural features of the the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SEC_PACKAGE_CLASS_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link MyTestPackage.mySecPackage.MySecPackageClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see MyTestPackage.mySecPackage.MySecPackageClass
	 * @generated
	 */
	EClass getMySecPackageClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MySecPackageFactory getMySecPackageFactory();

} //MySecPackagePackage
