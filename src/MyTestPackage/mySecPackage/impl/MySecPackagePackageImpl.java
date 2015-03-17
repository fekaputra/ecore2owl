/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.mySecPackage.impl;

import MyTestPackage.MyTestPackagePackage;

import MyTestPackage.impl.MyTestPackagePackageImpl;

import MyTestPackage.mySecPackage.MySecPackageClass;
import MyTestPackage.mySecPackage.MySecPackageFactory;
import MyTestPackage.mySecPackage.MySecPackagePackage;

import MyTestPackage.mySubPackage.MySubPackagePackage;

import MyTestPackage.mySubPackage.impl.MySubPackagePackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MySecPackagePackageImpl extends EPackageImpl implements MySecPackagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mySecPackageClassEClass = null;

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
	 * @see MyTestPackage.mySecPackage.MySecPackagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MySecPackagePackageImpl() {
		super(eNS_URI, MySecPackageFactory.eINSTANCE);
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
	public static MySecPackagePackage init() {
		if (isInited) return (MySecPackagePackage)EPackage.Registry.INSTANCE.getEPackage(MySecPackagePackage.eNS_URI);

		// Obtain or create and register package
		MySecPackagePackageImpl theMySecPackagePackage = (MySecPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof MySecPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new MySecPackagePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MyTestPackagePackageImpl theMyTestPackagePackage = (MyTestPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MyTestPackagePackage.eNS_URI) instanceof MyTestPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MyTestPackagePackage.eNS_URI) : MyTestPackagePackage.eINSTANCE);
		MySubPackagePackageImpl theMySubPackagePackage = (MySubPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MySubPackagePackage.eNS_URI) instanceof MySubPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MySubPackagePackage.eNS_URI) : MySubPackagePackage.eINSTANCE);

		// Create package meta-data objects
		theMySecPackagePackage.createPackageContents();
		theMyTestPackagePackage.createPackageContents();
		theMySubPackagePackage.createPackageContents();

		// Initialize created meta-data
		theMySecPackagePackage.initializePackageContents();
		theMyTestPackagePackage.initializePackageContents();
		theMySubPackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMySecPackagePackage.freeze();

		return theMySecPackagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMySecPackageClass() {
		return mySecPackageClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySecPackageFactory getMySecPackageFactory() {
		return (MySecPackageFactory)getEFactoryInstance();
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
		mySecPackageClassEClass = createEClass(MY_SEC_PACKAGE_CLASS);
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

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(mySecPackageClassEClass, MySecPackageClass.class, "MySecPackageClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //MySecPackagePackageImpl
