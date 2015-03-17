/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package MyTestPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Colors</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see MyTestPackage.MyTestPackagePackage#getColors()
 * @model
 * @generated
 */
public final class Colors extends AbstractEnumerator {
	/**
	 * The '<em><b>White</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>White</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WHITE_LITERAL
	 * @model name="White"
	 * @generated
	 * @ordered
	 */
	public static final int WHITE = 0;

	/**
	 * The '<em><b>Green</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Green</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREEN_LITERAL
	 * @model name="Green"
	 * @generated
	 * @ordered
	 */
	public static final int GREEN = 1;

	/**
	 * The '<em><b>Red</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Red</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RED_LITERAL
	 * @model name="Red"
	 * @generated
	 * @ordered
	 */
	public static final int RED = 2;

	/**
	 * The '<em><b>White</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WHITE
	 * @generated
	 * @ordered
	 */
	public static final Colors WHITE_LITERAL = new Colors(WHITE, "White");

	/**
	 * The '<em><b>Green</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREEN
	 * @generated
	 * @ordered
	 */
	public static final Colors GREEN_LITERAL = new Colors(GREEN, "Green");

	/**
	 * The '<em><b>Red</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RED
	 * @generated
	 * @ordered
	 */
	public static final Colors RED_LITERAL = new Colors(RED, "Red");

	/**
	 * An array of all the '<em><b>Colors</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Colors[] VALUES_ARRAY =
		new Colors[] {
			WHITE_LITERAL,
			GREEN_LITERAL,
			RED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Colors</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Colors</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Colors get(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Colors result = VALUES_ARRAY[i];
			if (result.toString().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Colors</b></em>' literal with the specified value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Colors get(int value) {
		switch (value) {
			case WHITE: return WHITE_LITERAL;
			case GREEN: return GREEN_LITERAL;
			case RED: return RED_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Colors(int value, String name) {
		super(value, name);
	}

} //Colors
