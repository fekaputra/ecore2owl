/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.impl;

import MyTestPackage.Colors;
import MyTestPackage.MyInterfaceClass;
import MyTestPackage.MySubClass;
import MyTestPackage.MySubSubClass;
import MyTestPackage.MyTestPackageFactory;
import MyTestPackage.MyTestPackagePackage;
import MyTestPackage.Root;

import MyTestPackage.mySecPackage.MySecPackagePackage;

import MyTestPackage.mySecPackage.impl.MySecPackagePackageImpl;

import MyTestPackage.mySubPackage.MySubPackagePackage;

import MyTestPackage.mySubPackage.impl.MySubPackagePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MyTestPackagePackageImpl extends EPackageImpl implements MyTestPackagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mySubClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mySubSubClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass myInterfaceClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum colorsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType over12EDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see MyTestPackage.MyTestPackagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MyTestPackagePackageImpl() {
		super(eNS_URI, MyTestPackageFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MyTestPackagePackage init() {
		if (isInited) return (MyTestPackagePackage)EPackage.Registry.INSTANCE.getEPackage(MyTestPackagePackage.eNS_URI);

		// Obtain or create and register package
		MyTestPackagePackageImpl theMyTestPackagePackage = (MyTestPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MyTestPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MyTestPackagePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MySubPackagePackageImpl theMySubPackagePackage = (MySubPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MySubPackagePackage.eNS_URI) instanceof MySubPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MySubPackagePackage.eNS_URI) : MySubPackagePackage.eINSTANCE);
		MySecPackagePackageImpl theMySecPackagePackage = (MySecPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MySecPackagePackage.eNS_URI) instanceof MySecPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MySecPackagePackage.eNS_URI) : MySecPackagePackage.eINSTANCE);

		// Create package meta-data objects
		theMyTestPackagePackage.createPackageContents();
		theMySubPackagePackage.createPackageContents();
		theMySecPackagePackage.createPackageContents();

		// Initialize created meta-data
		theMyTestPackagePackage.initializePackageContents();
		theMySubPackagePackage.initializePackageContents();
		theMySecPackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMyTestPackagePackage.freeze();

		return theMyTestPackagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_SelfRef() {
		return (EReference)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_MySubClasses() {
		return (EReference)rootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoot_Numbers() {
		return (EAttribute)rootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMySubClass() {
		return mySubClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMySubClass_Refmysecsubclass() {
		return (EReference)mySubClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMySubClass_Age() {
		return (EAttribute)mySubClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMySubClass_Color() {
		return (EAttribute)mySubClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMySubSubClass() {
		return mySubSubClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMyInterfaceClass() {
		return myInterfaceClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMyInterfaceClass_Test() {
		return (EReference)myInterfaceClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMyInterfaceClass_TheAge() {
		return (EAttribute)myInterfaceClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getColors() {
		return colorsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getover12() {
		return over12EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MyTestPackageFactory getMyTestPackageFactory() {
		return (MyTestPackageFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		rootEClass = createEClass(ROOT);
		createEReference(rootEClass, ROOT__SELF_REF);
		createEReference(rootEClass, ROOT__MY_SUB_CLASSES);
		createEAttribute(rootEClass, ROOT__NUMBERS);

		mySubClassEClass = createEClass(MY_SUB_CLASS);
		createEReference(mySubClassEClass, MY_SUB_CLASS__REFMYSECSUBCLASS);
		createEAttribute(mySubClassEClass, MY_SUB_CLASS__AGE);
		createEAttribute(mySubClassEClass, MY_SUB_CLASS__COLOR);

		mySubSubClassEClass = createEClass(MY_SUB_SUB_CLASS);

		myInterfaceClassEClass = createEClass(MY_INTERFACE_CLASS);
		createEReference(myInterfaceClassEClass, MY_INTERFACE_CLASS__TEST);
		createEAttribute(myInterfaceClassEClass, MY_INTERFACE_CLASS__THE_AGE);

		// Create enums
		colorsEEnum = createEEnum(COLORS);

		// Create data types
		over12EDataType = createEDataType(OVER12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MySubPackagePackageImpl theMySubPackagePackage = (MySubPackagePackageImpl)EPackage.Registry.INSTANCE.getEPackage(MySubPackagePackage.eNS_URI);
		MySecPackagePackageImpl theMySecPackagePackage = (MySecPackagePackageImpl)EPackage.Registry.INSTANCE.getEPackage(MySecPackagePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theMySubPackagePackage);
		getESubpackages().add(theMySecPackagePackage);

		// Add supertypes to classes
		mySubClassEClass.getESuperTypes().add(this.getRoot());
		mySubSubClassEClass.getESuperTypes().add(this.getMySubClass());
		myInterfaceClassEClass.getESuperTypes().add(theMySubPackagePackage.getmySubPackageClass());

		// Initialize classes and features; add operations and parameters
		initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoot_SelfRef(), this.getRoot(), null, "selfRef", null, 0, 1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_MySubClasses(), this.getMySubClass(), null, "MySubClasses", "", 0, 3, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoot_Numbers(), ecorePackage.getEInt(), "numbers", "", 0, 3, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mySubClassEClass, MySubClass.class, "MySubClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMySubClass_Refmysecsubclass(), theMySecPackagePackage.getMySecPackageClass(), null, "refmysecsubclass", null, 0, 1, MySubClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMySubClass_Age(), ecorePackage.getEInt(), "age", null, 0, 1, MySubClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMySubClass_Color(), this.getColors(), "Color", null, 0, 1, MySubClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mySubSubClassEClass, MySubSubClass.class, "MySubSubClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(myInterfaceClassEClass, MyInterfaceClass.class, "MyInterfaceClass", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMyInterfaceClass_Test(), theMySubPackagePackage.getmySubPackageClass2(), null, "test", null, 0, 1, MyInterfaceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMyInterfaceClass_TheAge(), this.getover12(), "theAge", null, 0, 1, MyInterfaceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(colorsEEnum, Colors.class, "Colors");
		addEEnumLiteral(colorsEEnum, Colors.WHITE_LITERAL);
		addEEnumLiteral(colorsEEnum, Colors.GREEN_LITERAL);
		addEEnumLiteral(colorsEEnum, Colors.RED_LITERAL);

		// Initialize data types
		initEDataType(over12EDataType, int.class, "over12", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// myPackageAnnotation
		createMyPackageAnnotationAnnotations();
		// myAnnotationtotheRootClass
		createMyAnnotationtotheRootClassAnnotations();
	}

	/**
	 * Initializes the annotations for <b>myPackageAnnotation</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMyPackageAnnotationAnnotations() {
		String source = "myPackageAnnotation";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
		   });	
	}

	/**
	 * Initializes the annotations for <b>myAnnotationtotheRootClass</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMyAnnotationtotheRootClassAnnotations() {
		String source = "myAnnotationtotheRootClass";			
		addAnnotation
		  (rootEClass, 
		   source, 
		   new String[] {
			 "firstproperty", "firstvalue",
			 "secondProperty", "secondValue"
		   });
	}

} //MyTestPackagePackageImpl
