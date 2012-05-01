/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services.test;

import hu.javaforum.annotations.PrintField;

/**
 * Test class for the CommonBeanTest tests.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * First implementation (2011-07-02)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class SimpleClass
{

  /**
   * A String value.
   */
  @PrintField(hidden = true)
  private String value;
  /**
   * A String value with PrintField annotation.
   */
  @PrintField
  private String printValue;

  /**
   * Empty constructor for bean pattern.
   */
  public SimpleClass()
  {
    super();
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final String getValue()
  {
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value The value
   */
  public final void setValue(final String value)
  {
    this.value = value;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final String getPrintValue()
  {
    return printValue;
  }

  /**
   * Sets the value.
   *
   * @param printValue The value
   */
  public final void setPrintValue(final String printValue)
  {
    this.printValue = printValue;
  }
}
