/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link MyTestPackage.Root#getSelfRef <em>Self Ref</em>}</li>
 *   <li>{@link MyTestPackage.Root#getMySubClasses <em>My Sub Classes</em>}</li>
 *   <li>{@link MyTestPackage.Root#getNumbers <em>Numbers</em>}</li>
 * </ul>
 * </p>
 *
 * @see MyTestPackage.MyTestPackagePackage#getRoot()
 * @model annotation="myAnnotationtotheRootClass firstproperty='firstvalue' secondProperty='secondValue'"
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Self Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Self Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Self Ref</em>' reference.
	 * @see #setSelfRef(Root)
	 * @see MyTestPackage.MyTestPackagePackage#getRoot_SelfRef()
	 * @model
	 * @generated
	 */
	Root getSelfRef();

	/**
	 * Sets the value of the '{@link MyTestPackage.Root#getSelfRef <em>Self Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self Ref</em>' reference.
	 * @see #getSelfRef()
	 * @generated
	 */
	void setSelfRef(Root value);

	/**
	 * Returns the value of the '<em><b>My Sub Classes</b></em>' reference list.
	 * The list contents are of type {@link MyTestPackage.MySubClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Sub Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My Sub Classes</em>' reference list.
	 * @see MyTestPackage.MyTestPackagePackage#getRoot_MySubClasses()
	 * @model type="MyTestPackage.MySubClass" upper="3"
	 * @generated
	 */
	EList getMySubClasses();

	/**
	 * Returns the value of the '<em><b>Numbers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numbers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numbers</em>' attribute list.
	 * @see MyTestPackage.MyTestPackagePackage#getRoot_Numbers()
	 * @model type="int" default="" upper="3"
	 * @generated
	 */
	EList getNumbers();

} // Root
