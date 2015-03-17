/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Tracing.impl;

import Tracing.TraceElement;
import Tracing.TracingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Tracing.impl.TraceElementImpl#getOntologyObject <em>Ontology Object</em>}</li>
 *   <li>{@link Tracing.impl.TraceElementImpl#getEcoreObject <em>Ecore Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceElementImpl extends EObjectImpl implements TraceElement {
	/**
	 * The default value of the '{@link #getOntologyObject() <em>Ontology Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOntologyObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object ONTOLOGY_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOntologyObject() <em>Ontology Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOntologyObject()
	 * @generated
	 * @ordered
	 */
	protected Object ontologyObject = ONTOLOGY_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEcoreObject() <em>Ecore Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreObject()
	 * @generated
	 * @ordered
	 */
	protected static final EObject ECORE_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEcoreObject() <em>Ecore Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreObject()
	 * @generated
	 * @ordered
	 */
	protected EObject ecoreObject = ECORE_OBJECT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TracingPackage.eINSTANCE.getTraceElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOntologyObject() {
		return ontologyObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOntologyObject(Object newOntologyObject) {
		Object oldOntologyObject = ontologyObject;
		ontologyObject = newOntologyObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracingPackage.TRACE_ELEMENT__ONTOLOGY_OBJECT, oldOntologyObject, ontologyObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getEcoreObject() {
		return ecoreObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreObject(EObject newEcoreObject) {
		EObject oldEcoreObject = ecoreObject;
		ecoreObject = newEcoreObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracingPackage.TRACE_ELEMENT__ECORE_OBJECT, oldEcoreObject, ecoreObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TracingPackage.TRACE_ELEMENT__ONTOLOGY_OBJECT:
				return getOntologyObject();
			case TracingPackage.TRACE_ELEMENT__ECORE_OBJECT:
				return getEcoreObject();
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
			case TracingPackage.TRACE_ELEMENT__ONTOLOGY_OBJECT:
				setOntologyObject((Object)newValue);
				return;
			case TracingPackage.TRACE_ELEMENT__ECORE_OBJECT:
				setEcoreObject((EObject)newValue);
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
			case TracingPackage.TRACE_ELEMENT__ONTOLOGY_OBJECT:
				setOntologyObject(ONTOLOGY_OBJECT_EDEFAULT);
				return;
			case TracingPackage.TRACE_ELEMENT__ECORE_OBJECT:
				setEcoreObject(ECORE_OBJECT_EDEFAULT);
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
			case TracingPackage.TRACE_ELEMENT__ONTOLOGY_OBJECT:
				return ONTOLOGY_OBJECT_EDEFAULT == null ? ontologyObject != null : !ONTOLOGY_OBJECT_EDEFAULT.equals(ontologyObject);
			case TracingPackage.TRACE_ELEMENT__ECORE_OBJECT:
				return ECORE_OBJECT_EDEFAULT == null ? ecoreObject != null : !ECORE_OBJECT_EDEFAULT.equals(ecoreObject);
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
		result.append(" (ontologyObject: ");
		result.append(ontologyObject);
		result.append(", ecoreObject: ");
		result.append(ecoreObject);
		result.append(')');
		return result.toString();
	}

} //TraceElementImpl
