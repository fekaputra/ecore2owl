/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.mySubPackage.impl;

import MyTestPackage.MyTestPackagePackage;

import MyTestPackage.impl.MyTestPackagePackageImpl;

import MyTestPackage.mySecPackage.MySecPackagePackage;

import MyTestPackage.mySecPackage.impl.MySecPackagePackageImpl;

import MyTestPackage.mySubPackage.MySubPackageFactory;
import MyTestPackage.mySubPackage.MySubPackagePackage;
import MyTestPackage.mySubPackage.mySubPackageClass;
import MyTestPackage.mySubPackage.mySubPackageClass2;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MySubPackagePackageImpl extends EPackageImpl implements MySubPackagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mySubPackageClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mySubPackageClass2EClass = null;

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
	 * @see MyTestPackage.mySubPackage.MySubPackagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MySubPackagePackageImpl() {
		super(eNS_URI, MySubPackageFactory.eINSTANCE);
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
	public static MySubPackagePackage init() {
		if (isInited) return (MySubPackagePackage)EPackage.Registry.INSTANCE.getEPackage(MySubPackagePackage.eNS_URI);

		// Obtain or create and register package
		MySubPackagePackageImpl theMySubPackagePackage = (MySubPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MySubPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MySubPackagePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MyTestPackagePackageImpl theMyTestPackagePackage = (MyTestPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MyTestPackagePackage.eNS_URI) instanceof MyTestPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MyTestPackagePackage.eNS_URI) : MyTestPackagePackage.eINSTANCE);
		MySecPackagePackageImpl theMySecPackagePackage = (MySecPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MySecPackagePackage.eNS_URI) instanceof MySecPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MySecPackagePackage.eNS_URI) : MySecPackagePackage.eINSTANCE);

		// Create package meta-data objects
		theMySubPackagePackage.createPackageContents();
		theMyTestPackagePackage.createPackageContents();
		theMySecPackagePackage.createPackageContents();

		// Initialize created meta-data
		theMySubPackagePackage.initializePackageContents();
		theMyTestPackagePackage.initializePackageContents();
		theMySecPackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMySubPackagePackage.freeze();

		return theMySubPackagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getmySubPackageClass() {
		return mySubPackageClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getmySubPackageClass2() {
		return mySubPackageClass2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySubPackageFactory getMySubPackageFactory() {
		return (MySubPackageFactory)getEFactoryInstance();
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
		mySubPackageClassEClass = createEClass(MY_SUB_PACKAGE_CLASS);

		mySubPackageClass2EClass = createEClass(MY_SUB_PACKAGE_CLASS2);
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
		MyTestPackagePackageImpl theMyTestPackagePackage = (MyTestPackagePackageImpl)EPackage.Registry.INSTANCE.getEPackage(MyTestPackagePackage.eNS_URI);

		// Add supertypes to classes
		mySubPackageClassEClass.getESuperTypes().add(theMyTestPackagePackage.getRoot());

		// Initialize classes and features; add operations and parameters
		initEClass(mySubPackageClassEClass, mySubPackageClass.class, "mySubPackageClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mySubPackageClass2EClass, mySubPackageClass2.class, "mySubPackageClass2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //MySubPackagePackageImpl
