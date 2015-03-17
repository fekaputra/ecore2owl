/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.mySubPackage;

import MyTestPackage.MyTestPackagePackage;

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
 * @see MyTestPackage.mySubPackage.MySubPackageFactory
 * @model kind="package"
 * @generated
 */
public interface MySubPackagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mySubPackage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.mySubtest.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mySub";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MySubPackagePackage eINSTANCE = MyTestPackage.mySubPackage.impl.MySubPackagePackageImpl.init();

	/**
	 * The meta object id for the '{@link MyTestPackage.mySubPackage.impl.mySubPackageClassImpl <em>my Sub Package Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MyTestPackage.mySubPackage.impl.mySubPackageClassImpl
	 * @see MyTestPackage.mySubPackage.impl.MySubPackagePackageImpl#getmySubPackageClass()
	 * @generated
	 */
	int MY_SUB_PACKAGE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Self Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_PACKAGE_CLASS__SELF_REF = MyTestPackagePackage.ROOT__SELF_REF;

	/**
	 * The feature id for the '<em><b>My Sub Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_PACKAGE_CLASS__MY_SUB_CLASSES = MyTestPackagePackage.ROOT__MY_SUB_CLASSES;

	/**
	 * The feature id for the '<em><b>Numbers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_PACKAGE_CLASS__NUMBERS = MyTestPackagePackage.ROOT__NUMBERS;

	/**
	 * The number of structural features of the the '<em>my Sub Package Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_PACKAGE_CLASS_FEATURE_COUNT = MyTestPackagePackage.ROOT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link MyTestPackage.mySubPackage.impl.mySubPackageClass2Impl <em>my Sub Package Class2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MyTestPackage.mySubPackage.impl.mySubPackageClass2Impl
	 * @see MyTestPackage.mySubPackage.impl.MySubPackagePackageImpl#getmySubPackageClass2()
	 * @generated
	 */
	int MY_SUB_PACKAGE_CLASS2 = 1;

	/**
	 * The number of structural features of the the '<em>my Sub Package Class2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_PACKAGE_CLASS2_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link MyTestPackage.mySubPackage.mySubPackageClass <em>my Sub Package Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>my Sub Package Class</em>'.
	 * @see MyTestPackage.mySubPackage.mySubPackageClass
	 * @generated
	 */
	EClass getmySubPackageClass();

	/**
	 * Returns the meta object for class '{@link MyTestPackage.mySubPackage.mySubPackageClass2 <em>my Sub Package Class2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>my Sub Package Class2</em>'.
	 * @see MyTestPackage.mySubPackage.mySubPackageClass2
	 * @generated
	 */
	EClass getmySubPackageClass2();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MySubPackageFactory getMySubPackageFactory();

} //MySubPackagePackage
