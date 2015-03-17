/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Tracing;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Tracing.TracingPackage
 * @generated
 */
public interface TracingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracingFactory eINSTANCE = new Tracing.impl.TracingFactoryImpl();

	/**
	 * Returns a new object of class '<em>Trace Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Model</em>'.
	 * @generated
	 */
	TraceModel createTraceModel();

	/**
	 * Returns a new object of class '<em>Trace Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Element</em>'.
	 * @generated
	 */
	TraceElement createTraceElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TracingPackage getTracingPackage();

} //TracingFactory
