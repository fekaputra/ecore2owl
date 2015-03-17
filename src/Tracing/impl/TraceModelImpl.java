/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Tracing.impl;

import Tracing.TraceElement;
import Tracing.TraceModel;
import Tracing.TracingFactory;
import Tracing.TracingPackage;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Tracing.impl.TraceModelImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceModelImpl extends EObjectImpl implements TraceModel {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList elements = new EObjectContainmentEList(TraceElement.class, this, TracingPackage.TRACE_MODEL__ELEMENTS);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TracingPackage.eINSTANCE.getTraceModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList(TraceElement.class, this, TracingPackage.TRACE_MODEL__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void add(EObject ecoreObject, Object ontologyObject) {
		TraceElement traceElement = TracingFactory.eINSTANCE.createTraceElement();
		traceElement.setEcoreObject(ecoreObject);
		traceElement.setOntologyObject(ontologyObject);
		if(lookup(ontologyObject) == null){
			elements.add(traceElement);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject lookup(Object ontologyObject) {
		Iterator iter = elements.iterator();
		TraceElement traceElement = null;
		EObject ecoreObject = null;
		boolean found = false;
		
		while(iter.hasNext() && !found){
			traceElement = (TraceElement) iter.next();
			if(traceElement.getOntologyObject().equals(ontologyObject)){
				ecoreObject = traceElement.getEcoreObject();
				found = true;
			}		
		}	
		
		return ecoreObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TracingPackage.TRACE_MODEL__ELEMENTS:
					return ((InternalEList)getElements()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TracingPackage.TRACE_MODEL__ELEMENTS:
				return getElements();
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
			case TracingPackage.TRACE_MODEL__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection)newValue);
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
			case TracingPackage.TRACE_MODEL__ELEMENTS:
				getElements().clear();
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
			case TracingPackage.TRACE_MODEL__ELEMENTS:
				return elements != null && !elements.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //TraceModelImpl
