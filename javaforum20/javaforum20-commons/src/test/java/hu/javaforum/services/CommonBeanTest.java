/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.enums.Move;
import hu.javaforum.services.test.ComplexClass;
import hu.javaforum.services.test.Details;
import hu.javaforum.services.test.SimpleClass;
import hu.javaforum.services.test.SubDetails;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test to the CommonBean class.
 *
 * Changelog:
 * First implementation (2011-02-08)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CommonBeanTest
{

  /**
   * The SubDetails minimum values.
   */
  private SubDetails subDetailsMin;
  /**
   * The SubDetails maximum values.
   */
  private SubDetails subDetailsMax;
  /**
   * The Details instance.
   */
  private Details details;
  /**
   * The SimpleClass instance.
   */
  private SimpleClass simpleClass;
  /**
   * The ComplexClass instance.
   */
  private ComplexClass complexClass;

  /**
   * The default constructor.
   */
  public CommonBeanTest()
  {
    super();
  }

  /**
   * Initialize test data.
   */
  private void initialize()
  {
    subDetailsMin = new SubDetails(Boolean.TRUE, Byte.MIN_VALUE,
            Double.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE,
            Long.MIN_VALUE, Short.MIN_VALUE, "text", "hidden", "non-print",
            Move.BOTTOM, new BigDecimal("123456789012345678901234567890.12345"),
            new BigInteger("123456789012345678901234567890"));
    subDetailsMax = new SubDetails(Boolean.TRUE, Byte.MAX_VALUE,
            Double.MAX_VALUE, Float.MAX_VALUE, Integer.MAX_VALUE,
            Long.MAX_VALUE, Short.MAX_VALUE, "text", "hidden", "non-print",
            Move.TOP, new BigDecimal("987654321098765432109876543210.54321"),
            new BigInteger("987654321098765432109876543210"));
    SubDetails[] subDetails = new SubDetails[2];
    subDetails[0] = subDetailsMin;
    subDetails[1] = subDetailsMax;

    details = new Details();
    details.setSubDetails(subDetails);
    details.setDateValue(new Date(1309621325123L));

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"), Locale.ENGLISH);
    calendar.setTime(details.getDateValue());
    details.setCalendarValue(calendar);

    simpleClass = new SimpleClass();
    simpleClass.setPrintValue("text");
    simpleClass.setValue("text");

    complexClass = new ComplexClass();
    complexClass.setValue(simpleClass);
    List<SimpleClass> simpleClasses = new ArrayList<SimpleClass>();
    simpleClasses.add(simpleClass);
    simpleClasses.add(null);
    complexClass.setSimpleClasses(simpleClasses);
  }

  /**
   * Test of dumpXml() method, of class CommonBean.
   */
  @Test
  public final void testDumpXmlSimple()
  {
    initialize();

    String expResult = "";
    String result = CommonBean.dumpXml(null, null, null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<string>\n"
            + "  <value>t</value>\n"
            + "  <value>e</value>\n"
            + "  <value>x</value>\n"
            + "  <value>t</value>\n"
            + "  <offset>0</offset>\n"
            + "  <count>4</count>\n"
            + "  <hash>3556653</hash>\n"
            + "</string>\n";
    simpleClass.getValue().hashCode();
    result = CommonBean.dumpXml(simpleClass.getValue(), null, null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<simpleClass>\n"
            + "  <value>text</value>\n"
            + "  <printValue>text</printValue>\n"
            + "</simpleClass>\n";
    result = CommonBean.dumpXml(simpleClass, null, null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<complexClass>\n"
            + "  <value>\n"
            + "    <value>text</value>\n"
            + "    <printValue>text</printValue>\n"
            + "  </value>\n"
            + "  <simpleClasses>\n"
            + "    <value>text</value>\n"
            + "    <printValue>text</printValue>\n"
            + "  </simpleClasses>\n"
            + "</complexClass>\n";
    result = CommonBean.dumpXml(complexClass, null, null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<value>text</value>\n"
            + "<printValue>text</printValue>\n";
    result = CommonBean.dumpXml(simpleClass, "--", null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<value>\n"
            + "  <value>text</value>\n"
            + "  <printValue>text</printValue>\n"
            + "</value>\n"
            + "<simpleClasses>\n"
            + "  <value>text</value>\n"
            + "  <printValue>text</printValue>\n"
            + "</simpleClasses>\n";
    result = CommonBean.dumpXml(complexClass, "--", null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<SimpleClass>\n"
            + "  <value>text</value>\n"
            + "  <printValue>text</printValue>\n"
            + "</SimpleClass>\n";
    result = CommonBean.dumpXml(simpleClass, "SimpleClass", null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<ComplexClass>\n"
            + "  <value>\n"
            + "    <value>text</value>\n"
            + "    <printValue>text</printValue>\n"
            + "  </value>\n"
            + "  <simpleClasses>\n"
            + "    <value>text</value>\n"
            + "    <printValue>text</printValue>\n"
            + "  </simpleClasses>\n"
            + "</ComplexClass>\n";
    result = CommonBean.dumpXml(complexClass, "ComplexClass", null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<SimpleClass>\n"
            + "  <value>text</value>\n"
            + "</SimpleClass>\n";
    simpleClass.setPrintValue(null);
    result = CommonBean.dumpXml(simpleClass, "SimpleClass", null).toString();
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of dumpXml() method, of class CommonBean.
   */
  @Test
  public final void testDumpXmlArrayComplexClass()
  {
    initialize();

    String expResult = ""
            + "<complexClass>\n"
            + "  <value>\n"
            + "    <value>text</value>\n"
            + "    <printValue>text</printValue>\n"
            + "  </value>\n"
            + "  <simpleClasses>\n"
            + "    <value>text</value>\n"
            + "    <printValue>text</printValue>\n"
            + "  </simpleClasses>\n"
            + "  <intArray>0</intArray>\n"
            + "  <intArray>1</intArray>\n"
            + "  <intArray>2</intArray>\n"
            + "  <intArray>3</intArray>\n"
            + "</complexClass>\n";
    int[] intArray = new int[]
    {
      0, 1, 2, 3
    };
    complexClass.setIntArray(intArray);
    String result = CommonBean.dumpXml(complexClass, null, null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = "<complexClass>\n"
            + "  <value>\n"
            + "    <value>text</value>\n"
            + "    <printValue>text</printValue>\n"
            + "  </value>\n"
            + "  <simpleClasses>\n"
            + "    <value>text</value>\n"
            + "    <printValue>text</printValue>\n"
            + "  </simpleClasses>\n"
            + "  <byteArray><!-- HEX VALUE -->80e00001207f</byteArray>\n"
            + "</complexClass>\n";
    byte[] byteArray = new byte[]
    {
      -128, -32, 0, 1, 32, 127
    };
    complexClass.setByteArray(byteArray);
    complexClass.setIntArray(null);
    result = CommonBean.dumpXml(complexClass, null, null).toString();
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of dumpXml() method, of class CommonBean.
   */
  @Test
  public final void testDumpXmlArrayDetails()
  {
    initialize();

    details.setCalendarValue(null);
    details.setDateValue(null);
    String expResult = ""
            + "<details>\n"
            + "  <subDetailsArray>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>-128</byteValue>\n"
            + "    <doubleValue>4.9E-324</doubleValue>\n"
            + "    <floatValue>1.4E-45</floatValue>\n"
            + "    <intValue>-2147483648</intValue>\n"
            + "    <longValue>-9223372036854775808</longValue>\n"
            + "    <shortValue>-32768</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>BOTTOM</move>\n"
            + "    <bigDecimal>123456789012345678901234567890.12345</bigDecimal>\n"
            + "    <bigInteger>123456789012345678901234567890</bigInteger>\n"
            + "  </subDetailsArray>\n"
            + "  <subDetailsArray>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>127</byteValue>\n"
            + "    <doubleValue>1.7976931348623157E308</doubleValue>\n"
            + "    <floatValue>3.4028235E38</floatValue>\n"
            + "    <intValue>2147483647</intValue>\n"
            + "    <longValue>9223372036854775807</longValue>\n"
            + "    <shortValue>32767</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>TOP</move>\n"
            + "    <bigDecimal>987654321098765432109876543210.54321</bigDecimal>\n"
            + "    <bigInteger>987654321098765432109876543210</bigInteger>\n"
            + "  </subDetailsArray>\n"
            + "  <intArray>0</intArray>\n"
            + "  <intArray>1</intArray>\n"
            + "  <!--intArray>LIMIT REACHED (2 of 4)</intArray-->\n"
            + "</details>\n";
    details.setIntArray(new int[]
            {
              0, 1, 2, 3
            });
    String result = CommonBean.dumpXml(details, null, null).toString();
    details.setIntArray(null);
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<details>\n"
            + "  <subDetailsArray>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>-128</byteValue>\n"
            + "    <doubleValue>4.9E-324</doubleValue>\n"
            + "    <floatValue>1.4E-45</floatValue>\n"
            + "    <intValue>-2147483648</intValue>\n"
            + "    <longValue>-9223372036854775808</longValue>\n"
            + "    <shortValue>-32768</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>BOTTOM</move>\n"
            + "    <bigDecimal>123456789012345678901234567890.12345</bigDecimal>\n"
            + "    <bigInteger>123456789012345678901234567890</bigInteger>\n"
            + "  </subDetailsArray>\n"
            + "  <subDetailsArray>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>127</byteValue>\n"
            + "    <doubleValue>1.7976931348623157E308</doubleValue>\n"
            + "    <floatValue>3.4028235E38</floatValue>\n"
            + "    <intValue>2147483647</intValue>\n"
            + "    <longValue>9223372036854775807</longValue>\n"
            + "    <shortValue>32767</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>TOP</move>\n"
            + "    <bigDecimal>987654321098765432109876543210.54321</bigDecimal>\n"
            + "    <bigInteger>987654321098765432109876543210</bigInteger>\n"
            + "  </subDetailsArray>\n"
            + "  <byteArray><!-- HEX VALUE -->80e0<!--LIMIT REACHED (2 of 6)--></byteArray>\n"
            + "</details>\n";
    details.setByteArray(new byte[]
            {
              -128, -32, 0, 1, 32, 127
            });
    result = CommonBean.dumpXml(details, null, null).toString();
    details.setByteArray(null);
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of dumpXml() method, of class CommonBean.
   */
  @Test
  public final void testDumpXmlDateCalendar()
  {
    initialize();
    details.setSubDetails(null);
    details.setSubDetailsList(null);

    String result = CommonBean.dumpXml(details, null, null).toString();
    assertNotNull(result, "value is null");
    /**
     * TODO: http://traq.javaforum.hu/browse/JFPORTAL-99
     */
  }

  /**
   * Test of dumpXml() method, of class CommonBean.
   */
  @Test
  public final void testDumpXmlComplexNamespace()
  {
    initialize();
    details.setCalendarValue(null);
    details.setDateValue(null);

    String expResult = ""
            + "<details>\n"
            + "  <subDetailsArray>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>-128</byteValue>\n"
            + "    <doubleValue>4.9E-324</doubleValue>\n"
            + "    <floatValue>1.4E-45</floatValue>\n"
            + "    <intValue>-2147483648</intValue>\n"
            + "    <longValue>-9223372036854775808</longValue>\n"
            + "    <shortValue>-32768</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>BOTTOM</move>\n"
            + "    <bigDecimal>123456789012345678901234567890.12345</bigDecimal>\n"
            + "    <bigInteger>123456789012345678901234567890</bigInteger>\n"
            + "  </subDetailsArray>\n"
            + "  <subDetailsArray>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>127</byteValue>\n"
            + "    <doubleValue>1.7976931348623157E308</doubleValue>\n"
            + "    <floatValue>3.4028235E38</floatValue>\n"
            + "    <intValue>2147483647</intValue>\n"
            + "    <longValue>9223372036854775807</longValue>\n"
            + "    <shortValue>32767</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>TOP</move>\n"
            + "    <bigDecimal>987654321098765432109876543210.54321</bigDecimal>\n"
            + "    <bigInteger>987654321098765432109876543210</bigInteger>\n"
            + "  </subDetailsArray>\n"
            + "</details>\n";
    String result = CommonBean.dumpXml(details, null, null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = ""
            + "<prefix:details>\n"
            + "  <prefix:subDetailsArray>\n"
            + "    <prefix:booleanValue>true</prefix:booleanValue>\n"
            + "    <prefix:byteValue>-128</prefix:byteValue>\n"
            + "    <prefix:doubleValue>4.9E-324</prefix:doubleValue>\n"
            + "    <prefix:floatValue>1.4E-45</prefix:floatValue>\n"
            + "    <prefix:intValue>-2147483648</prefix:intValue>\n"
            + "    <prefix:longValue>-9223372036854775808</prefix:longValue>\n"
            + "    <prefix:shortValue>-32768</prefix:shortValue>\n"
            + "    <prefix:textValue>text</prefix:textValue>\n"
            + "    <prefix:hiddenTextValue>***hidden***</prefix:hiddenTextValue>\n"
            + "    <prefix:move>BOTTOM</prefix:move>\n"
            + "    <prefix:bigDecimal>123456789012345678901234567890.12345</prefix:bigDecimal>\n"
            + "    <prefix:bigInteger>123456789012345678901234567890</prefix:bigInteger>\n"
            + "  </prefix:subDetailsArray>\n"
            + "  <prefix:subDetailsArray>\n"
            + "    <prefix:booleanValue>true</prefix:booleanValue>\n"
            + "    <prefix:byteValue>127</prefix:byteValue>\n"
            + "    <prefix:doubleValue>1.7976931348623157E308</prefix:doubleValue>\n"
            + "    <prefix:floatValue>3.4028235E38</prefix:floatValue>\n"
            + "    <prefix:intValue>2147483647</prefix:intValue>\n"
            + "    <prefix:longValue>9223372036854775807</prefix:longValue>\n"
            + "    <prefix:shortValue>32767</prefix:shortValue>\n"
            + "    <prefix:textValue>text</prefix:textValue>\n"
            + "    <prefix:hiddenTextValue>***hidden***</prefix:hiddenTextValue>\n"
            + "    <prefix:move>TOP</prefix:move>\n"
            + "    <prefix:bigDecimal>987654321098765432109876543210.54321</prefix:bigDecimal>\n"
            + "    <prefix:bigInteger>987654321098765432109876543210</prefix:bigInteger>\n"
            + "  </prefix:subDetailsArray>\n"
            + "</prefix:details>\n";
    result = CommonBean.dumpXml(details, null, "prefix").toString();
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of dumpXml() method, of class CommonBean.
   */
  @Test
  public final void testDumpXmlArrayList()
  {
    initialize();
    details.setCalendarValue(null);
    details.setDateValue(null);

    String expResult = ""
            + "<details>\n"
            + "  <subDetailsArray>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>-128</byteValue>\n"
            + "    <doubleValue>4.9E-324</doubleValue>\n"
            + "    <floatValue>1.4E-45</floatValue>\n"
            + "    <intValue>-2147483648</intValue>\n"
            + "    <longValue>-9223372036854775808</longValue>\n"
            + "    <shortValue>-32768</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>BOTTOM</move>\n"
            + "    <bigDecimal>123456789012345678901234567890.12345</bigDecimal>\n"
            + "    <bigInteger>123456789012345678901234567890</bigInteger>\n"
            + "  </subDetailsArray>\n"
            + "  <subDetailsArray>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>127</byteValue>\n"
            + "    <doubleValue>1.7976931348623157E308</doubleValue>\n"
            + "    <floatValue>3.4028235E38</floatValue>\n"
            + "    <intValue>2147483647</intValue>\n"
            + "    <longValue>9223372036854775807</longValue>\n"
            + "    <shortValue>32767</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>TOP</move>\n"
            + "    <bigDecimal>987654321098765432109876543210.54321</bigDecimal>\n"
            + "    <bigInteger>987654321098765432109876543210</bigInteger>\n"
            + "  </subDetailsArray>\n"
            + "  <!--subDetailsArray>LIMIT REACHED (2 of 4)</subDetailsArray-->\n"
            + "</details>\n";
    details.setSubDetails(new SubDetails[]
            {
              subDetailsMin,
              subDetailsMax,
              subDetailsMin,
              subDetailsMax
            });
    String result = CommonBean.dumpXml(details, null, null).toString();
    assertEquals(expResult, result, "values are not equal");

    expResult = "<details>\n"
            + "  <subDetailsList>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>-128</byteValue>\n"
            + "    <doubleValue>4.9E-324</doubleValue>\n"
            + "    <floatValue>1.4E-45</floatValue>\n"
            + "    <intValue>-2147483648</intValue>\n"
            + "    <longValue>-9223372036854775808</longValue>\n"
            + "    <shortValue>-32768</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>BOTTOM</move>\n"
            + "    <bigDecimal>123456789012345678901234567890.12345</bigDecimal>\n"
            + "    <bigInteger>123456789012345678901234567890</bigInteger>\n"
            + "  </subDetailsList>\n"
            + "  <subDetailsList>\n"
            + "    <booleanValue>true</booleanValue>\n"
            + "    <byteValue>127</byteValue>\n"
            + "    <doubleValue>1.7976931348623157E308</doubleValue>\n"
            + "    <floatValue>3.4028235E38</floatValue>\n"
            + "    <intValue>2147483647</intValue>\n"
            + "    <longValue>9223372036854775807</longValue>\n"
            + "    <shortValue>32767</shortValue>\n"
            + "    <textValue>text</textValue>\n"
            + "    <hiddenTextValue>***hidden***</hiddenTextValue>\n"
            + "    <move>TOP</move>\n"
            + "    <bigDecimal>987654321098765432109876543210.54321</bigDecimal>\n"
            + "    <bigInteger>987654321098765432109876543210</bigInteger>\n"
            + "  </subDetailsList>\n"
            + "  <!--subDetailsList>LIMIT REACHED (2 of 4)</subDetailsList-->\n"
            + "</details>\n";
    details.setSubDetails(null);
    List<SubDetails> subDetailsList = new ArrayList<SubDetails>();
    subDetailsList.add(subDetailsMin);
    subDetailsList.add(subDetailsMax);
    subDetailsList.add(subDetailsMin);
    subDetailsList.add(subDetailsMax);
    details.setSubDetailsList(subDetailsList);
    result = CommonBean.dumpXml(details, null, null).toString();
    assertEquals(expResult, result, "values are not equal");
  }
}
