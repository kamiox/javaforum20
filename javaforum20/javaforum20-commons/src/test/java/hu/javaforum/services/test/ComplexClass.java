/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for the CommonBeanTest tests.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * First implementation (2011-07-02)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class ComplexClass
{

  /**
   * A SimpleClass value.
   */
  private SimpleClass value;
  /**
   * A list of SimpleClass instances.
   */
  private List<SimpleClass> simpleClasses;
  /**
   * An integer array.
   */
  private int[] intArray;
  /**
   * A byte array.
   */
  private byte[] byteArray;

  /**
   * Empty constructor for bean pattern.
   */
  public ComplexClass()
  {
    super();

    this.simpleClasses = new ArrayList<SimpleClass>();
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final SimpleClass getValue()
  {
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value The value
   */
  public final void setValue(final SimpleClass value)
  {
    this.value = value;
  }

  /**
   * Returns with the list.
   *
   * @return The list
   */
  public final List<SimpleClass> getSimpleClasses()
  {
    return simpleClasses;
  }

  /**
   * Sets the list.
   *
   * @param simpleClasses The list
   */
  public final void setSimpleClasses(final List<SimpleClass> simpleClasses)
  {
    this.simpleClasses = simpleClasses;
  }

  /**
   * Returns with the array.
   *
   * @return The array
   */
  public final byte[] getByteArray()
  {
    return byteArray;
  }

  /**
   * Sets the array.
   *
   * @param byteArray The array
   */
  public final void setByteArray(final byte[] byteArray)
  {
    this.byteArray = byteArray;
  }

  /**
   * Returns with the array.
   *
   * @return The array
   */
  public final int[] getIntArray()
  {
    return intArray;
  }

  /**
   * Sets the array.
   *
   * @param intArray The array
   */
  public final void setIntArray(final int[] intArray)
  {
    this.intArray = intArray;
  }
}
