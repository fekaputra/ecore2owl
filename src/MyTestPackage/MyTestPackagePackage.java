/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage;

import MyTestPackage.mySubPackage.MySubPackagePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see MyTestPackage.MyTestPackageFactory
 * @model kind="package"
 * @generated
 */
public interface MyTestPackagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "MyTestPackage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.mytest.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "test";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MyTestPackagePackage eINSTANCE = MyTestPackage.impl.MyTestPackagePackageImpl.init();

	/**
	 * The meta object id for the '{@link MyTestPackage.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MyTestPackage.impl.RootImpl
	 * @see MyTestPackage.impl.MyTestPackagePackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Self Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__SELF_REF = 0;

	/**
	 * The feature id for the '<em><b>My Sub Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__MY_SUB_CLASSES = 1;

	/**
	 * The feature id for the '<em><b>Numbers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NUMBERS = 2;

	/**
	 * The number of structural features of the the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link MyTestPackage.impl.MySubClassImpl <em>My Sub Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MyTestPackage.impl.MySubClassImpl
	 * @see MyTestPackage.impl.MyTestPackagePackageImpl#getMySubClass()
	 * @generated
	 */
	int MY_SUB_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Self Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_CLASS__SELF_REF = ROOT__SELF_REF;

	/**
	 * The feature id for the '<em><b>My Sub Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_CLASS__MY_SUB_CLASSES = ROOT__MY_SUB_CLASSES;

	/**
	 * The feature id for the '<em><b>Numbers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_CLASS__NUMBERS = ROOT__NUMBERS;

	/**
	 * The feature id for the '<em><b>Refmysecsubclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_CLASS__REFMYSECSUBCLASS = ROOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_CLASS__AGE = ROOT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_CLASS__COLOR = ROOT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>My Sub Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_CLASS_FEATURE_COUNT = ROOT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link MyTestPackage.impl.MySubSubClassImpl <em>My Sub Sub Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MyTestPackage.impl.MySubSubClassImpl
	 * @see MyTestPackage.impl.MyTestPackagePackageImpl#getMySubSubClass()
	 * @generated
	 */
	int MY_SUB_SUB_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Self Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_SUB_CLASS__SELF_REF = MY_SUB_CLASS__SELF_REF;

	/**
	 * The feature id for the '<em><b>My Sub Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_SUB_CLASS__MY_SUB_CLASSES = MY_SUB_CLASS__MY_SUB_CLASSES;

	/**
	 * The feature id for the '<em><b>Numbers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_SUB_CLASS__NUMBERS = MY_SUB_CLASS__NUMBERS;

	/**
	 * The feature id for the '<em><b>Refmysecsubclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_SUB_CLASS__REFMYSECSUBCLASS = MY_SUB_CLASS__REFMYSECSUBCLASS;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_SUB_CLASS__AGE = MY_SUB_CLASS__AGE;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_SUB_CLASS__COLOR = MY_SUB_CLASS__COLOR;

	/**
	 * The number of structural features of the the '<em>My Sub Sub Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_SUB_SUB_CLASS_FEATURE_COUNT = MY_SUB_CLASS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link MyTestPackage.MyInterfaceClass <em>My Interface Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MyTestPackage.MyInterfaceClass
	 * @see MyTestPackage.impl.MyTestPackagePackageImpl#getMyInterfaceClass()
	 * @generated
	 */
	int MY_INTERFACE_CLASS = 3;

	/**
	 * The feature id for the '<em><b>Self Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_INTERFACE_CLASS__SELF_REF = MySubPackagePackage.MY_SUB_PACKAGE_CLASS__SELF_REF;

	/**
	 * The feature id for the '<em><b>My Sub Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_INTERFACE_CLASS__MY_SUB_CLASSES = MySubPackagePackage.MY_SUB_PACKAGE_CLASS__MY_SUB_CLASSES;

	/**
	 * The feature id for the '<em><b>Numbers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_INTERFACE_CLASS__NUMBERS = MySubPackagePackage.MY_SUB_PACKAGE_CLASS__NUMBERS;

	/**
	 * The feature id for the '<em><b>Test</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_INTERFACE_CLASS__TEST = MySubPackagePackage.MY_SUB_PACKAGE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>The Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_INTERFACE_CLASS__THE_AGE = MySubPackagePackage.MY_SUB_PACKAGE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>My Interface Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MY_INTERFACE_CLASS_FEATURE_COUNT = MySubPackagePackage.MY_SUB_PACKAGE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link MyTestPackage.Colors <em>Colors</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MyTestPackage.Colors
	 * @see MyTestPackage.impl.MyTestPackagePackageImpl#getColors()
	 * @generated
	 */
	int COLORS = 4;

	/**
	 * The meta object id for the '<em>over12</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see MyTestPackage.impl.MyTestPackagePackageImpl#getover12()
	 * @generated
	 */
	int OVER12 = 5;


	/**
	 * Returns the meta object for class '{@link MyTestPackage.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see MyTestPackage.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the reference '{@link MyTestPackage.Root#getSelfRef <em>Self Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Self Ref</em>'.
	 * @see MyTestPackage.Root#getSelfRef()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_SelfRef();

	/**
	 * Returns the meta object for the reference list '{@link MyTestPackage.Root#getMySubClasses <em>My Sub Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>My Sub Classes</em>'.
	 * @see MyTestPackage.Root#getMySubClasses()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_MySubClasses();

	/**
	 * Returns the meta object for the attribute list '{@link MyTestPackage.Root#getNumbers <em>Numbers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Numbers</em>'.
	 * @see MyTestPackage.Root#getNumbers()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_Numbers();

	/**
	 * Returns the meta object for class '{@link MyTestPackage.MySubClass <em>My Sub Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My Sub Class</em>'.
	 * @see MyTestPackage.MySubClass
	 * @generated
	 */
	EClass getMySubClass();

	/**
	 * Returns the meta object for the reference '{@link MyTestPackage.MySubClass#getRefmysecsubclass <em>Refmysecsubclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refmysecsubclass</em>'.
	 * @see MyTestPackage.MySubClass#getRefmysecsubclass()
	 * @see #getMySubClass()
	 * @generated
	 */
	EReference getMySubClass_Refmysecsubclass();

	/**
	 * Returns the meta object for the attribute '{@link MyTestPackage.MySubClass#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see MyTestPackage.MySubClass#getAge()
	 * @see #getMySubClass()
	 * @generated
	 */
	EAttribute getMySubClass_Age();

	/**
	 * Returns the meta object for the attribute '{@link MyTestPackage.MySubClass#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see MyTestPackage.MySubClass#getColor()
	 * @see #getMySubClass()
	 * @generated
	 */
	EAttribute getMySubClass_Color();

	/**
	 * Returns the meta object for class '{@link MyTestPackage.MySubSubClass <em>My Sub Sub Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My Sub Sub Class</em>'.
	 * @see MyTestPackage.MySubSubClass
	 * @generated
	 */
	EClass getMySubSubClass();

	/**
	 * Returns the meta object for class '{@link MyTestPackage.MyInterfaceClass <em>My Interface Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>My Interface Class</em>'.
	 * @see MyTestPackage.MyInterfaceClass
	 * @generated
	 */
	EClass getMyInterfaceClass();

	/**
	 * Returns the meta object for the reference '{@link MyTestPackage.MyInterfaceClass#getTest <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Test</em>'.
	 * @see MyTestPackage.MyInterfaceClass#getTest()
	 * @see #getMyInterfaceClass()
	 * @generated
	 */
	EReference getMyInterfaceClass_Test();

	/**
	 * Returns the meta object for the attribute '{@link MyTestPackage.MyInterfaceClass#getTheAge <em>The Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>The Age</em>'.
	 * @see MyTestPackage.MyInterfaceClass#getTheAge()
	 * @see #getMyInterfaceClass()
	 * @generated
	 */
	EAttribute getMyInterfaceClass_TheAge();

	/**
	 * Returns the meta object for enum '{@link MyTestPackage.Colors <em>Colors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Colors</em>'.
	 * @see MyTestPackage.Colors
	 * @generated
	 */
	EEnum getColors();

	/**
	 * Returns the meta object for data type '<em>over12</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>over12</em>'.
	 * @model instanceClass="int"
	 * @generated
	 */
	EDataType getover12();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MyTestPackageFactory getMyTestPackageFactory();

} //MyTestPackagePackage
