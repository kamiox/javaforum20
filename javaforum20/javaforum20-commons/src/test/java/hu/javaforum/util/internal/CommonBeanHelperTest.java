/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util.internal;

import hu.javaforum.services.CommonBean;
import hu.javaforum.services.test.Details;
import hu.javaforum.services.test.SubDetails;
import java.lang.reflect.Field;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test to the CommonBeanTest class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * First implementation (2011-07-31)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CommonBeanHelperTest
{

  /**
   * The default constructor.
   */
  public CommonBeanHelperTest()
  {
    super();
  }

  /**
   * Test of quoteXMLValue method, of class CommonBeanHelper.
   */
  @Test
  public final void testQuoteXMLValue()
  {
    SubDetails testClass = new SubDetails();
    testClass.setTextValue("test");

    assertNull(CommonBeanHelper.quoteXMLValue(null), "value is not null");

    String result = CommonBeanHelper.quoteXMLValue(testClass);
    String expResult = "&lt;subDetails&gt;\n"
            + "  &lt;booleanValue&gt;false&lt;/booleanValue&gt;\n"
            + "  &lt;byteValue&gt;0&lt;/byteValue&gt;\n"
            + "  &lt;doubleValue&gt;0.0&lt;/doubleValue&gt;\n"
            + "  &lt;floatValue&gt;0.0&lt;/floatValue&gt;\n"
            + "  &lt;intValue&gt;0&lt;/intValue&gt;\n"
            + "  &lt;longValue&gt;0&lt;/longValue&gt;\n"
            + "  &lt;shortValue&gt;0&lt;/shortValue&gt;\n"
            + "  &lt;textValue&gt;test&lt;/textValue&gt;\n"
            + "&lt;/subDetails&gt;\n";
    assertEquals(expResult, result, "values are not equal");

    testClass.setTextValue("\"<>&á" + (char) 26);
    result = CommonBeanHelper.quoteXMLValue(testClass);
    expResult = "&lt;subDetails&gt;\n"
            + "  &lt;booleanValue&gt;false&lt;/booleanValue&gt;\n"
            + "  &lt;byteValue&gt;0&lt;/byteValue&gt;\n"
            + "  &lt;doubleValue&gt;0.0&lt;/doubleValue&gt;\n"
            + "  &lt;floatValue&gt;0.0&lt;/floatValue&gt;\n"
            + "  &lt;intValue&gt;0&lt;/intValue&gt;\n"
            + "  &lt;longValue&gt;0&lt;/longValue&gt;\n"
            + "  &lt;shortValue&gt;0&lt;/shortValue&gt;\n"
            + "  &lt;textValue&gt;&amp;quot;&amp;lt;&amp;gt;&amp;amp;&amp;#225;_&lt;/textValue&gt;\n"
            + "&lt;/subDetails&gt;\n";
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of getIndentString() method, of class CommonBeanHelper.
   */
  @Test
  public final void testGetIndentString()
  {
    assertEquals("", CommonBeanHelper.getIndentString(0), "values are not equal");
    assertEquals("  ", CommonBeanHelper.getIndentString(1), "values are not equal");
    assertEquals("    ", CommonBeanHelper.getIndentString(2), "values are not equal");
    assertEquals("                                        ",
            CommonBeanHelper.getIndentString(20), "values are not equal");
    assertEquals("                                          ",
            CommonBeanHelper.getIndentString(21), "values are not equal");
  }

  /**
   * Test of isTransformableEntity() method, of class CommonBeanHelper.
   */
  @Test
  public final void testIsTransformableEntity()
  {
    assertTrue(CommonBeanHelper.isTransformableEntity('"'), "value is false");
    assertTrue(CommonBeanHelper.isTransformableEntity('<'), "value is false");
    assertTrue(CommonBeanHelper.isTransformableEntity('>'), "value is false");
    assertTrue(CommonBeanHelper.isTransformableEntity('&'), "value is false");
    assertTrue(CommonBeanHelper.isTransformableEntity('á'), "value is false");
    assertTrue(CommonBeanHelper.isTransformableEntity((char) 26), "value is false");
    assertFalse(CommonBeanHelper.isTransformableEntity('a'), "value is true");
  }

  /**
   * Test of transformEntity() method, of class CommonBeanHelper.
   */
  @Test
  public final void testTransformEntity()
  {
    StringBuilder sb = new StringBuilder();
    CommonBeanHelper.transformEntity(sb, '"');
    CommonBeanHelper.transformEntity(sb, '<');
    CommonBeanHelper.transformEntity(sb, '>');
    CommonBeanHelper.transformEntity(sb, '&');
    CommonBeanHelper.transformEntity(sb, 'á');
    CommonBeanHelper.transformEntity(sb, (char) 26);
    String result = sb.toString();
    String expResult = "&quot;&lt;&gt;&amp;&#225;_";
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of getFieldValue(Field field, Object object) method, of class
   * CommonBean.
   */
  @Test
  public final void testGetFieldValueFieldObject()
  {
    Field[] fields = FieldsMetaData.iterateFields(Details.class);
    assertNotNull(fields, "value is null");
    assertEquals(fields.length, 6, "values are not equal");
    assertEquals("calendarValue", fields[0].getName(), "values are not equal");
    assertEquals("byteArray", fields[5].getName(), "values are not equal");

    Details details = new Details();
    details.setDateValue(new Date(1309621325123L));

    Object value = CommonBean.getFieldValue(fields[1], details);
    assertTrue(value instanceof Date, "value is false");
    Date dateValue = (Date) value;
    assertEquals(dateValue.getTime(), 1309621325123L, "values are not equal");

    value = CommonBean.getFieldValue(fields[1], "text");
    assertTrue(value instanceof String, "value is false");
    String result = value.toString();
    String expResult = "***java.lang.IllegalArgumentException: Can not set "
            + "java.util.Date field "
            + "hu.javaforum.services.test.Details.dateValue to "
            + "java.lang.String***";
    assertEquals(expResult, result, "values are not equal");
  }
}
