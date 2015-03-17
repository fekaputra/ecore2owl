/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.impl;

import MyTestPackage.Colors;
import MyTestPackage.MySubSubClass;
import MyTestPackage.MyTestPackagePackage;
import MyTestPackage.Root;

import MyTestPackage.mySecPackage.MySecPackageClass;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Sub Sub Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MySubSubClassImpl extends MySubClassImpl implements MySubSubClass {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MySubSubClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MyTestPackagePackage.eINSTANCE.getMySubSubClass();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__SELF_REF:
				if (resolve) return getSelfRef();
				return basicGetSelfRef();
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__MY_SUB_CLASSES:
				return getMySubClasses();
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__NUMBERS:
				return getNumbers();
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__REFMYSECSUBCLASS:
				if (resolve) return getRefmysecsubclass();
				return basicGetRefmysecsubclass();
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__AGE:
				return new Integer(getAge());
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__COLOR:
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
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__SELF_REF:
				setSelfRef((Root)newValue);
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__MY_SUB_CLASSES:
				getMySubClasses().clear();
				getMySubClasses().addAll((Collection)newValue);
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__NUMBERS:
				getNumbers().clear();
				getNumbers().addAll((Collection)newValue);
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__REFMYSECSUBCLASS:
				setRefmysecsubclass((MySecPackageClass)newValue);
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__AGE:
				setAge(((Integer)newValue).intValue());
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__COLOR:
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
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__SELF_REF:
				setSelfRef((Root)null);
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__MY_SUB_CLASSES:
				getMySubClasses().clear();
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__NUMBERS:
				getNumbers().clear();
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__REFMYSECSUBCLASS:
				setRefmysecsubclass((MySecPackageClass)null);
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__AGE:
				setAge(AGE_EDEFAULT);
				return;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__COLOR:
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
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__SELF_REF:
				return selfRef != null;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__MY_SUB_CLASSES:
				return mySubClasses != null && !mySubClasses.isEmpty();
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__NUMBERS:
				return numbers != null && !numbers.isEmpty();
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__REFMYSECSUBCLASS:
				return refmysecsubclass != null;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__AGE:
				return age != AGE_EDEFAULT;
			case MyTestPackagePackage.MY_SUB_SUB_CLASS__COLOR:
				return color != COLOR_EDEFAULT;
		}
		return eDynamicIsSet(eFeature);
	}

} //MySubSubClassImpl
