/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage;

import MyTestPackage.mySubPackage.mySubPackageClass;
import MyTestPackage.mySubPackage.mySubPackageClass2;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Interface Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link MyTestPackage.MyInterfaceClass#getTest <em>Test</em>}</li>
 *   <li>{@link MyTestPackage.MyInterfaceClass#getTheAge <em>The Age</em>}</li>
 * </ul>
 * </p>
 *
 * @see MyTestPackage.MyTestPackagePackage#getMyInterfaceClass()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MyInterfaceClass extends mySubPackageClass {
	/**
	 * Returns the value of the '<em><b>Test</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test</em>' reference.
	 * @see #setTest(mySubPackageClass2)
	 * @see MyTestPackage.MyTestPackagePackage#getMyInterfaceClass_Test()
	 * @model
	 * @generated
	 */
	mySubPackageClass2 getTest();

	/**
	 * Sets the value of the '{@link MyTestPackage.MyInterfaceClass#getTest <em>Test</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test</em>' reference.
	 * @see #getTest()
	 * @generated
	 */
	void setTest(mySubPackageClass2 value);

	/**
	 * Returns the value of the '<em><b>The Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Age</em>' attribute.
	 * @see #setTheAge(int)
	 * @see MyTestPackage.MyTestPackagePackage#getMyInterfaceClass_TheAge()
	 * @model dataType="MyTestPackage.over12"
	 * @generated
	 */
	int getTheAge();

	/**
	 * Sets the value of the '{@link MyTestPackage.MyInterfaceClass#getTheAge <em>The Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Age</em>' attribute.
	 * @see #getTheAge()
	 * @generated
	 */
	void setTheAge(int value);

} // MyInterfaceClass
