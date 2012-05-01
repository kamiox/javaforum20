/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.annotations;

import java.lang.reflect.Field;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test of the PrintField class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-06)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class PrintFieldTest
{

  /**
   * Default values.
   */
  @PrintField
  private static final String DEFAULT_VALUES = "";
  /**
   * Alternate values.
   */
  @PrintField(hidden = true, maximumHexDump = 8, maximumItemDump = 8)
  private static final String ALL_VALUES = "";
  /**
   * The Field instance of the defaultValues field.
   */
  private final Field defaultValuesField;
  /**
   * The Field instance of the allValues field.
   */
  private final Field allValuesField;

  /**
   * The default constructor.
   *
   * @throws NoSuchFieldException If no such field
   */
  public PrintFieldTest() throws NoSuchFieldException
  {
    super();

    defaultValuesField = PrintFieldTest.class.getDeclaredField("DEFAULT_VALUES");
    allValuesField = PrintFieldTest.class.getDeclaredField("ALL_VALUES");
  }

  /**
   * Test value of variables.
   *
   * @throws IllegalAccessException IllegalAccessException
   */
  @Test
  public final void testVariables() throws IllegalAccessException
  {
    assertEquals(DEFAULT_VALUES, (String) defaultValuesField.get(this),
            "It's impossible... :)");
    assertEquals(ALL_VALUES, (String) allValuesField.get(this),
            "It's impossible... :)");
  }

  /**
   * Test of hidden method, of class PrintField.
   *
   * @throws NoSuchFieldException If no such field
   */
  @Test
  public final void testHidden() throws NoSuchFieldException
  {
    assertNotNull(defaultValuesField, "value is null");
    PrintField defaultValuesPrintField = defaultValuesField.getAnnotation(PrintField.class);
    assertNotNull(defaultValuesPrintField, "value is null");
    assertFalse(defaultValuesPrintField.hidden(), "value is not false");

    assertNotNull(allValuesField, "value is null");
    PrintField allValuesPrintField = allValuesField.getAnnotation(PrintField.class);
    assertNotNull(allValuesPrintField, "valus is null");
    assertTrue(allValuesPrintField.hidden(), "value is not true");
  }

  /**
   * Test of maximumHexDump method, of class PrintField.
   *
   * @throws NoSuchFieldException If no such field
   */
  @Test
  public final void testMaximumHexDump() throws NoSuchFieldException
  {
    assertNotNull(defaultValuesField, "value is null");
    PrintField defaultValuesPrintField = defaultValuesField.getAnnotation(PrintField.class);
    assertNotNull(defaultValuesPrintField, "value is null");
    assertEquals(defaultValuesPrintField.maximumHexDump(), Integer.MAX_VALUE, "values are not equal");

    assertNotNull(allValuesField, "value is null");
    PrintField allValuesPrintField = allValuesField.getAnnotation(PrintField.class);
    assertNotNull(allValuesPrintField, "value is null");
    assertEquals(allValuesPrintField.maximumHexDump(), 8, "values are not equal");
  }

  /**
   * Test of maximumItemDump method, of class PrintField.
   *
   * @throws NoSuchFieldException If no such field
   */
  @Test
  public final void testMaximumItemDump() throws NoSuchFieldException
  {
    assertNotNull(defaultValuesField, "value is null");
    PrintField defaultValuesPrintField = defaultValuesField.getAnnotation(PrintField.class);
    assertNotNull(defaultValuesPrintField, "value is null");
    assertEquals(defaultValuesPrintField.maximumItemDump(), Integer.MAX_VALUE, "values are not equal");

    assertNotNull(allValuesField, "value is null");
    PrintField allValuesPrintField = allValuesField.getAnnotation(PrintField.class);
    assertNotNull(allValuesPrintField, "value is null");
    assertEquals(allValuesPrintField.maximumItemDump(), 8, "values are not equal");
  }
}
