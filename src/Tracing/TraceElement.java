/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Tracing;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Tracing.TraceElement#getOntologyObject <em>Ontology Object</em>}</li>
 *   <li>{@link Tracing.TraceElement#getEcoreObject <em>Ecore Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see Tracing.TracingPackage#getTraceElement()
 * @model
 * @generated
 */
public interface TraceElement extends EObject{
	/**
	 * Returns the value of the '<em><b>Ontology Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ontology Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ontology Object</em>' attribute.
	 * @see #setOntologyObject(Object)
	 * @see Tracing.TracingPackage#getTraceElement_OntologyObject()
	 * @model
	 * @generated
	 */
	Object getOntologyObject();

	/**
	 * Sets the value of the '{@link Tracing.TraceElement#getOntologyObject <em>Ontology Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ontology Object</em>' attribute.
	 * @see #getOntologyObject()
	 * @generated
	 */
	void setOntologyObject(Object value);

	/**
	 * Returns the value of the '<em><b>Ecore Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore Object</em>' attribute.
	 * @see #setEcoreObject(EObject)
	 * @see Tracing.TracingPackage#getTraceElement_EcoreObject()
	 * @model dataType="Tracing.EcoreObj"
	 * @generated
	 */
	EObject getEcoreObject();

	/**
	 * Sets the value of the '{@link Tracing.TraceElement#getEcoreObject <em>Ecore Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Object</em>' attribute.
	 * @see #getEcoreObject()
	 * @generated
	 */
	void setEcoreObject(EObject value);

} // TraceElement
