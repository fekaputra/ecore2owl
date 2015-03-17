/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Tracing;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Tracing.TraceModel#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see Tracing.TracingPackage#getTraceModel()
 * @model
 * @generated
 */
public interface TraceModel extends EObject{
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link Tracing.TraceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see Tracing.TracingPackage#getTraceModel_Elements()
	 * @model type="Tracing.TraceElement" containment="true"
	 * @generated
	 */
	EList getElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ecoreObjectDataType="Tracing.EcoreObj"
	 * @generated
	 */
	void add(EObject ecoreObject, Object ontologyObject);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="Tracing.EcoreObj"
	 * @generated
	 */
	EObject lookup(Object ontologyObject);

} // TraceModel
