/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage;

import MyTestPackage.mySecPackage.MySecPackageClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Sub Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link MyTestPackage.MySubClass#getRefmysecsubclass <em>Refmysecsubclass</em>}</li>
 *   <li>{@link MyTestPackage.MySubClass#getAge <em>Age</em>}</li>
 *   <li>{@link MyTestPackage.MySubClass#getColor <em>Color</em>}</li>
 * </ul>
 * </p>
 *
 * @see MyTestPackage.MyTestPackagePackage#getMySubClass()
 * @model
 * @generated
 */
public interface MySubClass extends Root {
	/**
	 * Returns the value of the '<em><b>Refmysecsubclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refmysecsubclass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refmysecsubclass</em>' reference.
	 * @see #setRefmysecsubclass(MySecPackageClass)
	 * @see MyTestPackage.MyTestPackagePackage#getMySubClass_Refmysecsubclass()
	 * @model
	 * @generated
	 */
	MySecPackageClass getRefmysecsubclass();

	/**
	 * Sets the value of the '{@link MyTestPackage.MySubClass#getRefmysecsubclass <em>Refmysecsubclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refmysecsubclass</em>' reference.
	 * @see #getRefmysecsubclass()
	 * @generated
	 */
	void setRefmysecsubclass(MySecPackageClass value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see MyTestPackage.MyTestPackagePackage#getMySubClass_Age()
	 * @model
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link MyTestPackage.MySubClass#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * The literals are from the enumeration {@link MyTestPackage.Colors}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see MyTestPackage.Colors
	 * @see #setColor(Colors)
	 * @see MyTestPackage.MyTestPackagePackage#getMySubClass_Color()
	 * @model
	 * @generated
	 */
	Colors getColor();

	/**
	 * Sets the value of the '{@link MyTestPackage.MySubClass#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see MyTestPackage.Colors
	 * @see #getColor()
	 * @generated
	 */
	void setColor(Colors value);

} // MySubClass
