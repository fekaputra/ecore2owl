/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.util;

import MyTestPackage.*;

import MyTestPackage.mySubPackage.mySubPackageClass;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see MyTestPackage.MyTestPackagePackage
 * @generated
 */
public class MyTestPackageAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MyTestPackagePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MyTestPackageAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MyTestPackagePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MyTestPackageSwitch modelSwitch =
		new MyTestPackageSwitch() {
			public Object caseRoot(Root object) {
				return createRootAdapter();
			}
			public Object caseMySubClass(MySubClass object) {
				return createMySubClassAdapter();
			}
			public Object caseMySubSubClass(MySubSubClass object) {
				return createMySubSubClassAdapter();
			}
			public Object caseMyInterfaceClass(MyInterfaceClass object) {
				return createMyInterfaceClassAdapter();
			}
			public Object casemySubPackageClass(mySubPackageClass object) {
				return createmySubPackageClassAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link MyTestPackage.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MyTestPackage.Root
	 * @generated
	 */
	public Adapter createRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MyTestPackage.MySubClass <em>My Sub Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MyTestPackage.MySubClass
	 * @generated
	 */
	public Adapter createMySubClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MyTestPackage.MySubSubClass <em>My Sub Sub Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MyTestPackage.MySubSubClass
	 * @generated
	 */
	public Adapter createMySubSubClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MyTestPackage.MyInterfaceClass <em>My Interface Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MyTestPackage.MyInterfaceClass
	 * @generated
	 */
	public Adapter createMyInterfaceClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link MyTestPackage.mySubPackage.mySubPackageClass <em>my Sub Package Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see MyTestPackage.mySubPackage.mySubPackageClass
	 * @generated
	 */
	public Adapter createmySubPackageClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MyTestPackageAdapterFactory
