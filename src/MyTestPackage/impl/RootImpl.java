/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.impl;

import MyTestPackage.MySubClass;
import MyTestPackage.MyTestPackagePackage;
import MyTestPackage.Root;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link MyTestPackage.impl.RootImpl#getSelfRef <em>Self Ref</em>}</li>
 *   <li>{@link MyTestPackage.impl.RootImpl#getMySubClasses <em>My Sub Classes</em>}</li>
 *   <li>{@link MyTestPackage.impl.RootImpl#getNumbers <em>Numbers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends EObjectImpl implements Root {
	/**
	 * The cached value of the '{@link #getSelfRef() <em>Self Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfRef()
	 * @generated
	 * @ordered
	 */
	protected Root selfRef = null;

	/**
	 * The cached value of the '{@link #getMySubClasses() <em>My Sub Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMySubClasses()
	 * @generated
	 * @ordered
	 */
	protected EList mySubClasses = null;

	/**
	 * The cached value of the '{@link #getNumbers() <em>Numbers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumbers()
	 * @generated
	 * @ordered
	 */
	protected EList numbers = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MyTestPackagePackage.eINSTANCE.getRoot();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root getSelfRef() {
		if (selfRef != null && selfRef.eIsProxy()) {
			Root oldSelfRef = selfRef;
			selfRef = (Root)eResolveProxy((InternalEObject)selfRef);
			if (selfRef != oldSelfRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MyTestPackagePackage.ROOT__SELF_REF, oldSelfRef, selfRef));
			}
		}
		return selfRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Root basicGetSelfRef() {
		return selfRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfRef(Root newSelfRef) {
		Root oldSelfRef = selfRef;
		selfRef = newSelfRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MyTestPackagePackage.ROOT__SELF_REF, oldSelfRef, selfRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMySubClasses() {
		if (mySubClasses == null) {
			mySubClasses = new EObjectResolvingEList(MySubClass.class, this, MyTestPackagePackage.ROOT__MY_SUB_CLASSES);
		}
		return mySubClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNumbers() {
		if (numbers == null) {
			numbers = new EDataTypeUniqueEList(Integer.class, this, MyTestPackagePackage.ROOT__NUMBERS);
		}
		return numbers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MyTestPackagePackage.ROOT__SELF_REF:
				if (resolve) return getSelfRef();
				return basicGetSelfRef();
			case MyTestPackagePackage.ROOT__MY_SUB_CLASSES:
				return getMySubClasses();
			case MyTestPackagePackage.ROOT__NUMBERS:
				return getNumbers();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MyTestPackagePackage.ROOT__SELF_REF:
				setSelfRef((Root)newValue);
				return;
			case MyTestPackagePackage.ROOT__MY_SUB_CLASSES:
				getMySubClasses().clear();
				getMySubClasses().addAll((Collection)newValue);
				return;
			case MyTestPackagePackage.ROOT__NUMBERS:
				getNumbers().clear();
				getNumbers().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MyTestPackagePackage.ROOT__SELF_REF:
				setSelfRef((Root)null);
				return;
			case MyTestPackagePackage.ROOT__MY_SUB_CLASSES:
				getMySubClasses().clear();
				return;
			case MyTestPackagePackage.ROOT__NUMBERS:
				getNumbers().clear();
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MyTestPackagePackage.ROOT__SELF_REF:
				return selfRef != null;
			case MyTestPackagePackage.ROOT__MY_SUB_CLASSES:
				return mySubClasses != null && !mySubClasses.isEmpty();
			case MyTestPackagePackage.ROOT__NUMBERS:
				return numbers != null && !numbers.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (numbers: ");
		result.append(numbers);
		result.append(')');
		return result.toString();
	}

} //RootImpl
