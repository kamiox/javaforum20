/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util.internal;

import hu.javaforum.logger.PerfLoggerEngine;
import hu.javaforum.services.test.Details;
import java.lang.reflect.Field;
import javax.xml.bind.annotation.XmlElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test to the ReflectionHelper class.
 *
 * Changelog:
 * First implementation (2012-04-30)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class ReflectionHelperTest
{

  /**
   * The default constructor.
   */
  public ReflectionHelperTest()
  {
    super();
  }

  /**
   * Test of iterateFields method, of class FieldsMetaData.
   */
  @Test
  public final void testGetFieldName()
  {
    Field[] fields = FieldsMetaData.iterateFields(TestClass.class);
    char[] testValue = "testValue".toCharArray();
    char[] annotatedTestValue = "AnnotatedTestValue".toCharArray();

    assertNotNull(fields, "value is null");
    assertEquals(ReflectionHelper.getFieldName(null), new char[0], "values are not equal");
    assertEquals(ReflectionHelper.getFieldName(fields[0]), testValue, "values are not equal");
    assertEquals(ReflectionHelper.getFieldName(fields[1]), annotatedTestValue, "values are not equal");
  }

  /**
   * Test class.
   */
  private class TestClass
  {

    /**
     * Test value.
     */
    private String testValue;
    /**
     * Annotated test value.
     */
    @XmlElement(name = "AnnotatedTestValue")
    private String annotatedTestValue;

    /**
     * Gets the value.
     *
     * @return The value
     */
    public final String getAnnotatedTestValue()
    {
      return annotatedTestValue;
    }

    /**
     * Sets the value.
     *
     * @param annotatedTestValue The value
     */
    public final void setAnnotatedTestValue(final String annotatedTestValue)
    {
      this.annotatedTestValue = annotatedTestValue;
    }

    /**
     * Gets the value.
     *
     * @return The value
     */
    public final String getTestValue()
    {
      return testValue;
    }

    /**
     * Sets the value.
     *
     * @param testValue The value
     */
    public final void setTestValue(final String testValue)
    {
      this.testValue = testValue;
    }
  }
}
