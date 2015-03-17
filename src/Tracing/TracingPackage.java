/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Tracing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Tracing.TracingFactory
 * @model kind="package"
 * @generated
 */
public interface TracingPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Tracing";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.tracing.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracingPackage eINSTANCE = Tracing.impl.TracingPackageImpl.init();

	/**
	 * The meta object id for the '{@link Tracing.impl.TraceModelImpl <em>Trace Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Tracing.impl.TraceModelImpl
	 * @see Tracing.impl.TracingPackageImpl#getTraceModel()
	 * @generated
	 */
	int TRACE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL__ELEMENTS = 0;

	/**
	 * The number of structural features of the the '<em>Trace Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link Tracing.impl.TraceElementImpl <em>Trace Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Tracing.impl.TraceElementImpl
	 * @see Tracing.impl.TracingPackageImpl#getTraceElement()
	 * @generated
	 */
	int TRACE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Ontology Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__ONTOLOGY_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Ecore Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT__ECORE_OBJECT = 1;

	/**
	 * The number of structural features of the the '<em>Trace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '<em>Ecore Obj</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EObject
	 * @see Tracing.impl.TracingPackageImpl#getEcoreObj()
	 * @generated
	 */
	int ECORE_OBJ = 2;


	/**
	 * Returns the meta object for class '{@link Tracing.TraceModel <em>Trace Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Model</em>'.
	 * @see Tracing.TraceModel
	 * @generated
	 */
	EClass getTraceModel();

	/**
	 * Returns the meta object for the containment reference list '{@link Tracing.TraceModel#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see Tracing.TraceModel#getElements()
	 * @see #getTraceModel()
	 * @generated
	 */
	EReference getTraceModel_Elements();

	/**
	 * Returns the meta object for class '{@link Tracing.TraceElement <em>Trace Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Element</em>'.
	 * @see Tracing.TraceElement
	 * @generated
	 */
	EClass getTraceElement();

	/**
	 * Returns the meta object for the attribute '{@link Tracing.TraceElement#getOntologyObject <em>Ontology Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ontology Object</em>'.
	 * @see Tracing.TraceElement#getOntologyObject()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_OntologyObject();

	/**
	 * Returns the meta object for the attribute '{@link Tracing.TraceElement#getEcoreObject <em>Ecore Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ecore Object</em>'.
	 * @see Tracing.TraceElement#getEcoreObject()
	 * @see #getTraceElement()
	 * @generated
	 */
	EAttribute getTraceElement_EcoreObject();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.EObject <em>Ecore Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ecore Obj</em>'.
	 * @see org.eclipse.emf.ecore.EObject
	 * @model instanceClass="org.eclipse.emf.ecore.EObject"
	 * @generated
	 */
	EDataType getEcoreObj();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TracingFactory getTracingFactory();

} //TracingPackage
