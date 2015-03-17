/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage.mySubPackage.impl;

import MyTestPackage.Root;

import MyTestPackage.impl.RootImpl;

import MyTestPackage.mySubPackage.MySubPackagePackage;
import MyTestPackage.mySubPackage.mySubPackageClass;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>my Sub Package Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class mySubPackageClassImpl extends RootImpl implements mySubPackageClass {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected mySubPackageClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MySubPackagePackage.eINSTANCE.getmySubPackageClass();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__SELF_REF:
				if (resolve) return getSelfRef();
				return basicGetSelfRef();
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__MY_SUB_CLASSES:
				return getMySubClasses();
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__NUMBERS:
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
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__SELF_REF:
				setSelfRef((Root)newValue);
				return;
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__MY_SUB_CLASSES:
				getMySubClasses().clear();
				getMySubClasses().addAll((Collection)newValue);
				return;
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__NUMBERS:
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
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__SELF_REF:
				setSelfRef((Root)null);
				return;
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__MY_SUB_CLASSES:
				getMySubClasses().clear();
				return;
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__NUMBERS:
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
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__SELF_REF:
				return selfRef != null;
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__MY_SUB_CLASSES:
				return mySubClasses != null && !mySubClasses.isEmpty();
			case MySubPackagePackage.MY_SUB_PACKAGE_CLASS__NUMBERS:
				return numbers != null && !numbers.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //mySubPackageClassImpl
