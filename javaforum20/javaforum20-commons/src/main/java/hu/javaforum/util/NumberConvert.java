/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

/**
 * The NumberConvert class provides methods to parse numbers from text without
 * exceptions.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * Refactoring (2009-06-12)
 * Refactoring (2008-05-31)
 * The first implementation (2007-05-18)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public final class NumberConvert
{

  /**
   * The static instance (singleton pattern).
   */
  public static final NumberConvert INSTANCE = new NumberConvert();

  /**
   * The private constructor, because all methods are static.
   */
  private NumberConvert()
  {
    super();
  }

  /**
   * Tries to convert the text to double number value, if the text cannot be
   * converted to number, it returns with 'null' value.
   *
   * @param text The text
   * @return The result
   */
  public static Double doubleValue(final String text)
  {
    return doubleValue(text, null);
  }

  /**
   * Tries to convert the text to double number value, if the text cannot be
   * converted to number, it returns with the default value.
   *
   * @param text The text
   * @param defaultValue The default value
   * @return The result
   */
  public static Double doubleValue(final String text, final Double defaultValue)
  {
    try
    {
      return Double.parseDouble(text);
    } catch (Exception except)
    {
      return defaultValue;
    }
  }

  /**
   * Tries to convert the text to integer number value, if the text cannot be
   * converted to number, it returns with 'null' value.
   *
   * @param text The text
   * @return The result
   */
  public static Integer intValue(final String text)
  {
    return intValue(text, null);
  }

  /**
   * Tries to convert the text to integer number value, if the text cannot be
   * converted to number, it returns with the default value.
   *
   * @param text The text
   * @param defaultValue The default value
   * @return The result
   */
  public static Integer intValue(final String text, final Integer defaultValue)
  {
    try
    {
      return Integer.parseInt(text);
    } catch (Exception except)
    {
      return defaultValue;
    }
  }

  /**
   * Tries to convert the text to long number value, if the text cannot be
   * converted to number, it returns with 'null' value.
   *
   * @param text The text
   * @return The result
   */
  public static Long longValue(final String text)
  {
    return longValue(text, null);
  }

  /**
   * Tries to convert the text to integer number value, if the text cannot be
   * converted to number, it returns with the default value.
   *
   * @param text The text
   * @param defaultValue The default value
   * @return The result
   */
  public static Long longValue(final String text, final Long defaultValue)
  {
    try
    {
      return Long.parseLong(text);
    } catch (Exception except)
    {
      return defaultValue;
    }
  }
}
