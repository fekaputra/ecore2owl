/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.impl;

import MyTestPackage.Colors;
import MyTestPackage.MySubClass;
import MyTestPackage.MyTestPackagePackage;
import MyTestPackage.Root;

import MyTestPackage.mySecPackage.MySecPackageClass;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Sub Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link MyTestPackage.impl.MySubClassImpl#getRefmysecsubclass <em>Refmysecsubclass</em>}</li>
 *   <li>{@link MyTestPackage.impl.MySubClassImpl#getAge <em>Age</em>}</li>
 *   <li>{@link MyTestPackage.impl.MySubClassImpl#getColor <em>Color</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MySubClassImpl extends RootImpl implements MySubClass {
	/**
	 * The cached value of the '{@link #getRefmysecsubclass() <em>Refmysecsubclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefmysecsubclass()
	 * @generated
	 * @ordered
	 */
	protected MySecPackageClass refmysecsubclass = null;

	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected int age = AGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final Colors COLOR_EDEFAULT = Colors.WHITE_LITERAL;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected Colors color = COLOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MySubClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MyTestPackagePackage.eINSTANCE.getMySubClass();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySecPackageClass getRefmysecsubclass() {
		if (refmysecsubclass != null && refmysecsubclass.eIsProxy()) {
			MySecPackageClass oldRefmysecsubclass = refmysecsubclass;
			refmysecsubclass = (MySecPackageClass)eResolveProxy((InternalEObject)refmysecsubclass);
			if (refmysecsubclass != oldRefmysecsubclass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MyTestPackagePackage.MY_SUB_CLASS__REFMYSECSUBCLASS, oldRefmysecsubclass, refmysecsubclass));
			}
		}
		return refmysecsubclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MySecPackageClass basicGetRefmysecsubclass() {
		return refmysecsubclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefmysecsubclass(MySecPackageClass newRefmysecsubclass) {
		MySecPackageClass oldRefmysecsubclass = refmysecsubclass;
		refmysecsubclass = newRefmysecsubclass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MyTestPackagePackage.MY_SUB_CLASS__REFMYSECSUBCLASS, oldRefmysecsubclass, refmysecsubclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAge() {
		return age;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAge(int newAge) {
		int oldAge = age;
		age = newAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MyTestPackagePackage.MY_SUB_CLASS__AGE, oldAge, age));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Colors getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(Colors newColor) {
		Colors oldColor = color;
		color = newColor == null ? COLOR_EDEFAULT : newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MyTestPackagePackage.MY_SUB_CLASS__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MyTestPackagePackage.MY_SUB_CLASS__SELF_REF:
				if (resolve) return getSelfRef();
				return basicGetSelfRef();
			case MyTestPackagePackage.MY_SUB_CLASS__MY_SUB_CLASSES:
				return getMySubClasses();
			case MyTestPackagePackage.MY_SUB_CLASS__NUMBERS:
				return getNumbers();
			case MyTestPackagePackage.MY_SUB_CLASS__REFMYSECSUBCLASS:
				if (resolve) return getRefmysecsubclass();
				return basicGetRefmysecsubclass();
			case MyTestPackagePackage.MY_SUB_CLASS__AGE:
				return new Integer(getAge());
			case MyTestPackagePackage.MY_SUB_CLASS__COLOR:
				return getColor();
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
			case MyTestPackagePackage.MY_SUB_CLASS__SELF_REF:
				setSelfRef((Root)newValue);
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__MY_SUB_CLASSES:
				getMySubClasses().clear();
				getMySubClasses().addAll((Collection)newValue);
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__NUMBERS:
				getNumbers().clear();
				getNumbers().addAll((Collection)newValue);
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__REFMYSECSUBCLASS:
				setRefmysecsubclass((MySecPackageClass)newValue);
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__AGE:
				setAge(((Integer)newValue).intValue());
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__COLOR:
				setColor((Colors)newValue);
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
			case MyTestPackagePackage.MY_SUB_CLASS__SELF_REF:
				setSelfRef((Root)null);
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__MY_SUB_CLASSES:
				getMySubClasses().clear();
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__NUMBERS:
				getNumbers().clear();
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__REFMYSECSUBCLASS:
				setRefmysecsubclass((MySecPackageClass)null);
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__AGE:
				setAge(AGE_EDEFAULT);
				return;
			case MyTestPackagePackage.MY_SUB_CLASS__COLOR:
				setColor(COLOR_EDEFAULT);
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
			case MyTestPackagePackage.MY_SUB_CLASS__SELF_REF:
				return selfRef != null;
			case MyTestPackagePackage.MY_SUB_CLASS__MY_SUB_CLASSES:
				return mySubClasses != null && !mySubClasses.isEmpty();
			case MyTestPackagePackage.MY_SUB_CLASS__NUMBERS:
				return numbers != null && !numbers.isEmpty();
			case MyTestPackagePackage.MY_SUB_CLASS__REFMYSECSUBCLASS:
				return refmysecsubclass != null;
			case MyTestPackagePackage.MY_SUB_CLASS__AGE:
				return age != AGE_EDEFAULT;
			case MyTestPackagePackage.MY_SUB_CLASS__COLOR:
				return color != COLOR_EDEFAULT;
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
		result.append(" (age: ");
		result.append(age);
		result.append(", Color: ");
		result.append(color);
		result.append(')');
		return result.toString();
	}

} //MySubClassImpl
