/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util.internal;

import hu.javaforum.logger.PerfLoggerEngine;
import hu.javaforum.services.test.Details;
import java.lang.reflect.Field;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test to the FieldsMetaData class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * First implementation (2011-07-31)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class FieldsMetaDataTest
{

  /**
   * The default constructor.
   */
  public FieldsMetaDataTest()
  {
    super();
  }

  /**
   * Test of constructor, of class FieldsMetaData.
   */
  @Test
  public final void testInit()
  {
    Field[] fields = new FieldsMetaData(new Details()).getFields();
    assertNotNull(fields, "value is null");
    assertEquals(fields.length, 6, "values are not equal");
    assertEquals("calendarValue", fields[0].getName(), "values are not equal");
    assertEquals("byteArray", fields[5].getName(), "values are not equal");

    fields = new FieldsMetaData(new TestClass()).getFields();
    assertNotNull(fields, "value is null");
    assertEquals(fields.length, 1, "values are not equal");
    assertEquals("this$0", fields[0].getName(), "values are not equal");
  }

  /**
   * Test of iterateFields method, of class FieldsMetaData.
   */
  @Test
  public final void testIterateFields()
  {
    Field[] fields = FieldsMetaData.iterateFields(Details.class);
    assertNotNull(fields, "value is null");
    assertEquals(fields.length, 6, "values are not equal");
    assertEquals("calendarValue", fields[0].getName(), "values are not equal");
    assertEquals("byteArray", fields[5].getName(), "values are not equal");

    fields = FieldsMetaData.iterateFields(PerfLoggerEngine.class);
    assertNotNull(fields, "value is null");
    assertEquals(fields.length, 4, "values are not equal");
    assertEquals("logger", fields[2].getName(), "values are not equal");
    assertEquals("startTime", fields[3].getName(), "values are not equal");

    fields = FieldsMetaData.iterateFields(null);
    assertNotNull(fields, "value is null");
    assertEquals(fields.length, 0, "values are not equal");

    fields = FieldsMetaData.iterateFields(TestClass.class);
    assertNotNull(fields, "value is null");
    assertEquals(fields.length, 2, "values are not equal");
    assertEquals("__testValue", fields[0].getName(), "values are not equal");

    fields = FieldsMetaData.iterateFields(TestClass2.class);
    assertNotNull(fields, "value is null");
    assertEquals(fields.length, 3, "values are not equal");
    assertEquals("this$0", fields[0].getName(), "values are not equal");
  }

  /**
   * Test class.
   */
  private class TestClass
  {

    /**
     * Test value, the name is starts with __ prefix.
     */
    private String __testValue;

    /**
     * Gets the value.
     *
     * @return The value
     */
    public final String getTestValue()
    {
      return __testValue;
    }

    /**
     * Sets the value.
     *
     * @param __testValue The value
     */
    public final void setTestValue(final String __testValue)
    {
      this.__testValue = __testValue;
    }
  }

  /**
   * Simple descendant.
   */
  private class TestClass2 extends TestClass
  {
  }
}
