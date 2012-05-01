/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import hu.javaforum.enums.Move;
import hu.javaforum.services.test.Details;
import hu.javaforum.services.test.SubDetails;
import hu.javaforum.services.test.SubDetailsWrapper;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test to the ReflectionUtil class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class ReflectionUtilTest
{

  /**
   * The default constructor.
   */
  public ReflectionUtilTest()
  {
    super();
  }

  /**
   * Test of invokeGetter method, of class ReflectionUtil.
   */
  @Test
  public final void testInvokeGetter()
  {
    CacheEntry cacheEntry = new CacheEntry("", "value");

    Object result = ReflectionUtil.invokeGetter(cacheEntry, "content");
    assertEquals("value", result, "values are not equal");

    result = ReflectionUtil.invokeGetter(null, "content");
    assertNull(result, "value is not null");

    result = ReflectionUtil.invokeGetter(new Object(), null);
    assertNull(result, "value is not null");

    result = ReflectionUtil.invokeGetter(new Object(), "");
    assertNull(result, "value is not null");

    result = ReflectionUtil.invokeGetter(new Object(), "content");
    assertNull(result, "value is not null");

    result = ReflectionUtil.invokeGetter(cacheEntry, "nonexistentMethod");
    assertNull(result, "value is not null");

    result = ReflectionUtil.invokeGetter(new FailClass(), "item");
    assertNull(result, "value is not null");
  }

  /**
   * Test of isGetterExists method, of class ReflectionUtil.
   */
  @Test
  public final void testIsGetterExists()
  {
    CacheEntry cacheEntry = new CacheEntry("", "value");

    Boolean result = ReflectionUtil.isGetterExists(cacheEntry, "content");
    assertTrue(result, "value is false");

    result = ReflectionUtil.isGetterExists(null, "content");
    assertFalse(result, "value is true");

    result = ReflectionUtil.isGetterExists(new Object(), null);
    assertFalse(result, "value is true");

    result = ReflectionUtil.isGetterExists(new Object(), "");
    assertFalse(result, "value is true");

    result = ReflectionUtil.isGetterExists(new Object(), "content");
    assertFalse(result, "value is true");
  }

  /**
   * Test of invokeSetterPrimitives method, of class ReflectionUtil.
   */
  @Test
  public final void testInvokeSetterPrimitives()
  {
    SubDetails subDetails = new SubDetails();
    FailClass failClass = new FailClass();

    boolean result = ReflectionUtil.invokeSetter(subDetails, "textValue", "value");
    assertTrue(result, "value is true");

    result = ReflectionUtil.invokeSetter(null, "textValue", "value");
    assertFalse(result, "value is true");

    result = ReflectionUtil.invokeSetter(new Object(), null, "value");
    assertFalse(result, "value is true");

    result = ReflectionUtil.invokeSetter(new Object(), "", "value");
    assertFalse(result, "value is true");

    result = ReflectionUtil.invokeSetter(new Object(), "textValue", "value");
    assertFalse(result, "value is true");

    result = ReflectionUtil.invokeSetter(subDetails, "textValue.textValue", "value");
    assertFalse(result, "value is true");

    result = ReflectionUtil.invokeSetter(failClass, "failField", "value");
    assertFalse(result, "value is true");

    result = ReflectionUtil.invokeSetter(failClass, "item", "value");
    assertFalse(result, "value is true");

    result = ReflectionUtil.invokeSetter(subDetails, "nonexistentMethod.textValue", "value");
    assertFalse(result, "value is true");

    result = ReflectionUtil.invokeSetter(subDetails, "intValue", "123");
    assertTrue(result, "value is false");
    assertEquals(subDetails.getIntValue(), 123, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "intValue", new String[]
            {
              "1234"
            });
    assertTrue(result, "value is false");
    assertEquals(subDetails.getIntValue(), 1234, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "intValue", new String[0]);
    assertFalse(result, "value is true");
    assertEquals(subDetails.getIntValue(), 1234, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "intValue", new String[]
            {
              "12345", "123456"
            });
    assertFalse(result, "value is true");
    assertEquals(subDetails.getIntValue(), 1234, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "intValue", new Integer[]
            {
              12345
            });
    assertFalse(result, "value is true");
    assertEquals(subDetails.getIntValue(), 1234, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "longValue", 1234567L);
    assertTrue(result, "value is false");
    assertEquals(subDetails.getLongValue(), 1234567L, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "longValue", new Long(12345678L));
    assertTrue(result, "value is false");
    assertEquals(subDetails.getLongValue(), 12345678L, "values are not equal");
  }

  /**
   * Test of invokeSetterArrays method, of class ReflectionUtil.
   */
  @Test
  public final void testInvokeSetterArrays()
  {
    SubDetails subDetails = new SubDetails();
    Details details = new Details();

    boolean result = ReflectionUtil.invokeSetter(details, "intArray", new int[]
            {
              12345, 123456
            });
    assertTrue(result, "value is false");
    assertEquals(details.getIntArray().length, 2, "values are not equal");
    assertEquals(details.getIntArray()[0], 12345, "values are not equal");
    assertEquals(details.getIntArray()[1], 123456, "values are not equal");

    result = ReflectionUtil.invokeSetter(details, "intArray", new Integer[]
            {
              12345, 123456
            });
    assertFalse(result, "value is true");

    List<SubDetails> subDetailsList = new ArrayList<SubDetails>();
    subDetailsList.add(subDetails);
    result = ReflectionUtil.invokeSetter(details, "subDetailsArray", subDetailsList);
    /**
     * TODO: It's ok?!
     */
    assertFalse(result, "value is true");
  }

  /**
   * Test of invokeSetterSubclasses method, of class ReflectionUtil.
   */
  @Test
  public final void testInvokeSetterSubclasses()
  {
    SubDetails subDetails = new SubDetails();
    SubDetailsWrapper subDetailsWrapper = new SubDetailsWrapper();
    Details details = new Details();

    boolean result = ReflectionUtil.invokeSetter(subDetails, "booleanValue", "true");
    assertTrue(result, "value is false");
    assertTrue(subDetails.getBooleanValue(), "value is false");

    result = ReflectionUtil.invokeSetter(subDetails, "booleanValue", Boolean.FALSE);
    assertTrue(result, "value is false");
    assertFalse(subDetails.getBooleanValue(), "value is true");

    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "booleanValue", "true");
    assertTrue(result, "value is false");
    assertEquals(subDetailsWrapper.getBooleanValue(), Boolean.TRUE, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "byteValue", "123");
    assertTrue(result, "value is false");
    assertEquals(subDetails.getByteValue(), 123, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "byteValue", new Byte((byte) -124));
    assertTrue(result, "value is false");
    assertEquals(subDetails.getByteValue(), (byte) -124, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "byteValue", "124");
    assertTrue(result, "value is false");
    assertEquals((Byte) subDetailsWrapper.getByteValue(), new Byte((byte) 124), "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "doubleValue", "123.1");
    assertTrue(result, "value is false");
    assertEquals(subDetails.getDoubleValue(), 123.1d, 0.0d, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "doubleValue", new Double(-12434));
    assertTrue(result, "value is false");
    assertEquals(subDetails.getDoubleValue(), -12434.0d, 0.0d, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "doubleValue", "124.34E2");
    assertTrue(result, "value is false");
    assertEquals(subDetailsWrapper.getDoubleValue(), 12434.0d, 0.0d, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "floatValue", "123.2");
    assertTrue(result, "value is false");
    assertEquals(subDetails.getFloatValue(), 123.2f, 0.1f, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "floatValue", new Float(-1234.5f));
    assertTrue(result, "value is false");
    assertEquals(subDetails.getFloatValue(), -1234.5f, 0.1f, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "floatValue", "123.45E1");
    assertTrue(result, "value is false");
    assertEquals(subDetailsWrapper.getFloatValue(), 1234.5f, 0.1f, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "intValue", "12345");
    assertTrue(result, "value is false");
    assertEquals(subDetails.getIntValue(), 12345, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "intValue", new Integer(-123456));
    assertTrue(result, "value is false");
    assertEquals(subDetails.getIntValue(), -123456, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "integerValue", "123456");
    assertTrue(result, "value is false");
    assertEquals(subDetailsWrapper.getIntegerValue(), new Integer(123456), "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "longValue", "9876543210");
    assertTrue(result, "value is false");
    assertEquals(subDetails.getLongValue(), 9876543210L, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "longValue", new Long(-98765432100L));
    assertTrue(result, "value is false");
    assertEquals(subDetails.getLongValue(), -98765432100L, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "longValue", "98765432100");
    assertTrue(result, "value is false");
    assertEquals(subDetailsWrapper.getLongValue(), new Long(98765432100L), "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "shortValue", "30000");
    assertTrue(result, "value is false");
    assertEquals(subDetails.getShortValue(), 30000, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "shortValue", new Short((short) -20000));
    assertTrue(result, "value is false");
    assertEquals(subDetails.getShortValue(), (short) -20000, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "shortValue", "20000");
    assertTrue(result, "value is false");
    assertEquals(subDetailsWrapper.getShortValue(), new Short((short) 20000), "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetails, "move", "TOP");
    assertTrue(result, "value is false");
    assertEquals(subDetails.getMove(), Move.TOP, "values are not equal");

    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "move", "BOTTOM");
    assertTrue(result, "value is false");
    assertEquals(subDetailsWrapper.getMove(), Move.BOTTOM, "values are not equal");

    BigDecimal bd = new BigDecimal("12345678901234567890.12345");
    result = ReflectionUtil.invokeSetter(subDetails, "bigDecimal", "12345678901234567890.12345");
    assertTrue(result, "value is false");
    assertTrue(subDetails.getBigDecimal().equals(bd), "value is false");

    bd = new BigDecimal("98765432109876543210.54321");
    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "bigDecimal", "98765432109876543210.54321");
    assertTrue(result, "value is false");
    assertTrue(subDetailsWrapper.getBigDecimal().equals(bd), "value is false");

    BigInteger bi = new BigInteger("12345678901234567890");
    result = ReflectionUtil.invokeSetter(subDetails, "bigInteger", "12345678901234567890");
    assertTrue(result, "value is false");
    assertTrue(subDetails.getBigInteger().equals(bi), "value is false");

    bi = new BigInteger("98765432109876543210");
    result = ReflectionUtil.invokeSetter(subDetailsWrapper, "bigInteger", "98765432109876543210");
    assertTrue(result, "value is false");
    assertTrue(subDetailsWrapper.getBigInteger().equals(bi), "value is false");

    result = ReflectionUtil.invokeSetter(details, "byteArray",
            "VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wcyBvdmVyIHRoZSBsYXp5IGRvZyE=");
    assertTrue(result, "value is false");
    assertEquals(details.getByteArray().length, 44, "values are not equal");
    assertEquals(details.getByteArray()[0], 'T', "values are not equal");
    assertEquals(details.getByteArray()[1], 'h', "values are not equal");
    assertEquals(details.getByteArray()[42], 'g', "values are not equal");
    assertEquals(details.getByteArray()[43], '!', "values are not equal");
  }

  /**
   * Test of invokeSetterCalendar method, of class ReflectionUtil.
   */
  @Test
  public final void testInvokeSetterCalendar()
  {
    Details details = new Details();

    boolean result = ReflectionUtil.invokeSetter(details, "calendarValue", "2011-08-14T12:41:45+0100");
    assertTrue(result, "value is false");
    assertNotNull(details.getCalendarValue(), "value is null");
    /**
     * TODO: http://traq.javaforum.hu/browse/JFPORTAL-99
     *
     * assertEquals(details.getCalendarValue().get(Calendar.YEAR), 2011);
     * assertEquals(details.getCalendarValue().get(Calendar.MONTH), Calendar.AUGUST);
     * assertEquals(details.getCalendarValue().get(Calendar.DAY_OF_MONTH), 14);
     * assertEquals(details.getCalendarValue().get(Calendar.HOUR_OF_DAY), 13);
     * assertEquals(details.getCalendarValue().get(Calendar.MINUTE), 41);
     * assertEquals(details.getCalendarValue().get(Calendar.SECOND), 45);
     * assertEquals(details.getCalendarValue().get(Calendar.MILLISECOND), 0);
     *
     */
    result = ReflectionUtil.invokeSetter(details, "calendarValue", "2011-08-14 12:41:45");
    assertTrue(result, "value is false");
    assertNotNull(details.getCalendarValue(), "value is null");
    /**
     * TODO: http://traq.javaforum.hu/browse/JFPORTAL-99
     *
     * assertEquals(details.getCalendarValue().get(Calendar.YEAR), 2011);
     * assertEquals(details.getCalendarValue().get(Calendar.MONTH), Calendar.AUGUST);
     * assertEquals(details.getCalendarValue().get(Calendar.DAY_OF_MONTH), 14);
     * assertEquals(details.getCalendarValue().get(Calendar.HOUR_OF_DAY), 12);
     * assertEquals(details.getCalendarValue().get(Calendar.MINUTE), 41);
     * assertEquals(details.getCalendarValue().get(Calendar.SECOND), 45);
     * assertEquals(details.getCalendarValue().get(Calendar.MILLISECOND), 0);
     *
     */
    result = ReflectionUtil.invokeSetter(details, "calendarValue", "2011-08-14 12:41");
    assertTrue(result, "value is false");
    assertNotNull(details.getCalendarValue(), "value is null");
    /**
     * TODO: http://traq.javaforum.hu/browse/JFPORTAL-99
     *
     * assertEquals(details.getCalendarValue().get(Calendar.YEAR), 2011);
     * assertEquals(details.getCalendarValue().get(Calendar.MONTH), Calendar.AUGUST);
     * assertEquals(details.getCalendarValue().get(Calendar.DAY_OF_MONTH), 14);
     * assertEquals(details.getCalendarValue().get(Calendar.HOUR_OF_DAY), 12);
     * assertEquals(details.getCalendarValue().get(Calendar.MINUTE), 41);
     * assertEquals(details.getCalendarValue().get(Calendar.SECOND), 0);
     * assertEquals(details.getCalendarValue().get(Calendar.MILLISECOND), 0);
     *
     */
    result = ReflectionUtil.invokeSetter(details, "calendarValue", "2011-08-14");
    assertTrue(result, "value is false");
    assertNotNull(details.getCalendarValue(), "value is null");
    /**
     * TODO: http://traq.javaforum.hu/browse/JFPORTAL-99
     *
     * assertEquals(details.getCalendarValue().get(Calendar.YEAR), 2011);
     * assertEquals(details.getCalendarValue().get(Calendar.MONTH), Calendar.AUGUST);
     * assertEquals(details.getCalendarValue().get(Calendar.DAY_OF_MONTH), 14);
     * assertEquals(details.getCalendarValue().get(Calendar.HOUR_OF_DAY), 0);
     * assertEquals(details.getCalendarValue().get(Calendar.MINUTE), 0);
     * assertEquals(details.getCalendarValue().get(Calendar.SECOND), 0);
     * assertEquals(details.getCalendarValue().get(Calendar.MILLISECOND), 0);
     *
     */
    result = ReflectionUtil.invokeSetter(details, "calendarValue", "2011-08");
    assertFalse(result, "value is true");
  }

  /**
   * Test of invokeSetterDate method, of class ReflectionUtil.
   */
  @Test
  public final void testInvokeSetterDate()
  {
    Details details = new Details();
    Calendar dateHelper = Calendar.getInstance();

    boolean result = ReflectionUtil.invokeSetter(details, "dateValue", "2011-08-14T12:41:45+0100");
    assertTrue(result, "value is false");
    assertNotNull(details.getDateValue(), "value is null");
    dateHelper.setTime(details.getDateValue());
    /**
     * TODO: http://traq.javaforum.hu/browse/JFPORTAL-99
     *
     * assertEquals(dateHelper.get(Calendar.YEAR), 2011);
     * assertEquals(dateHelper.get(Calendar.MONTH), Calendar.AUGUST);
     * assertEquals(dateHelper.get(Calendar.DAY_OF_MONTH), 14);
     * assertEquals(dateHelper.get(Calendar.HOUR_OF_DAY), 13);
     * assertEquals(dateHelper.get(Calendar.MINUTE), 41);
     * assertEquals(dateHelper.get(Calendar.SECOND), 45);
     * assertEquals(dateHelper.get(Calendar.MILLISECOND), 0);
     *
     */
    result = ReflectionUtil.invokeSetter(details, "dateValue", "2011-08-14 12:41:45");
    assertTrue(result, "value is false");
    assertNotNull(details.getDateValue(), "value is null");
    dateHelper.setTime(details.getDateValue());
    /**
     * TODO: http://traq.javaforum.hu/browse/JFPORTAL-99
     *
     * assertEquals(dateHelper.get(Calendar.YEAR), 2011);
     * assertEquals(dateHelper.get(Calendar.MONTH), Calendar.AUGUST);
     * assertEquals(dateHelper.get(Calendar.DAY_OF_MONTH), 14);
     * assertEquals(dateHelper.get(Calendar.HOUR_OF_DAY), 12);
     * assertEquals(dateHelper.get(Calendar.MINUTE), 41);
     * assertEquals(dateHelper.get(Calendar.SECOND), 45);
     * assertEquals(dateHelper.get(Calendar.MILLISECOND), 0);
     *
     */
    result = ReflectionUtil.invokeSetter(details, "dateValue", "2011-08-14 12:41");
    assertTrue(result, "value is false");
    assertNotNull(details.getDateValue(), "value is null");
    dateHelper.setTime(details.getDateValue());
    /**
     * TODO: http://traq.javaforum.hu/browse/JFPORTAL-99
     *
     * assertEquals(dateHelper.get(Calendar.YEAR), 2011);
     * assertEquals(dateHelper.get(Calendar.MONTH), Calendar.AUGUST);
     * assertEquals(dateHelper.get(Calendar.DAY_OF_MONTH), 14);
     * assertEquals(dateHelper.get(Calendar.HOUR_OF_DAY), 12);
     * assertEquals(dateHelper.get(Calendar.MINUTE), 41);
     * assertEquals(dateHelper.get(Calendar.SECOND), 0);
     * assertEquals(dateHelper.get(Calendar.MILLISECOND), 0);
     *
     */
    result = ReflectionUtil.invokeSetter(details, "dateValue", "2011-08-14");
    assertTrue(result, "value is false");
    assertNotNull(details.getDateValue(), "value is null");
    dateHelper.setTime(details.getDateValue());
    /**
     * TODO: http://traq.javaforum.hu/browse/JFPORTAL-99
     *
     * assertEquals(dateHelper.get(Calendar.YEAR), 2011);
     * assertEquals(dateHelper.get(Calendar.MONTH), Calendar.AUGUST);
     * assertEquals(dateHelper.get(Calendar.DAY_OF_MONTH), 14);
     * assertEquals(dateHelper.get(Calendar.HOUR_OF_DAY), 0);
     * assertEquals(dateHelper.get(Calendar.MINUTE), 0);
     * assertEquals(dateHelper.get(Calendar.SECOND), 0);
     * assertEquals(dateHelper.get(Calendar.MILLISECOND), 0);
     *
     */
    result = ReflectionUtil.invokeSetter(details, "dateValue", "2011-08");
    assertFalse(result, "value is true");
  }

  /**
   * Test of getField method, of class ReflectionUtil.
   *
   * @throws NoSuchFieldException If no such field
   */
  @Test
  public final void testGetField() throws NoSuchFieldException
  {
    Field field = ReflectionUtil.getField(FailClass.class, "return");
    assertNotNull(field, "value is null");
  }

  /**
   * Test of getFieldGenericClass method, of class ReflectionUtil.
   *
   * @throws NoSuchFieldException If no such field
   */
  @Test
  public final void testGetFieldGenericClass() throws NoSuchFieldException
  {
    Class cls = ReflectionUtil.getFieldGenericClass(Details.class, "dateValue");
    assertNull(cls, "value is not null");
    cls = ReflectionUtil.getFieldGenericClass(Details.class, "noSuchField");
    assertNull(cls, "value is not null");
    cls = ReflectionUtil.getFieldGenericClass(Details.class, "subDetailsList");
    assertEquals(SubDetails.class, cls, "values are not equal");
    cls = ReflectionUtil.getFieldGenericClass(Details.class, "subDetailsArray");
    assertEquals(SubDetails.class, cls, "values are not equal");
  }

  /**
   * Class for test, it is fails when getItem or setItem method called.
   */
  private class FailClass
  {

    /**
     * The entry.
     */
    private Object entry;
    /**
     * A field without getter and setter.
     */
    private Object failField;
    /**
     * The item.
     */
    private String item;
    /**
     * A field with '_return' name.
     */
    private String _return;

    /**
     * Returns with the value.
     *
     * @return The value
     */
    public Object getEntry()
    {
      return entry;
    }

    /**
     * Sets the value.
     *
     * @param entry The value
     */
    public final void setEntry(final Object entry)
    {
      this.entry = entry;
    }

    /**
     * Returns with error.
     *
     * @throws Exception If any exception
     * @return The value
     */
    public final String getItem() throws Exception
    {
      try
      {
        return item;
      } finally
      {
        throw new Exception();
      }
    }

    /**
     * Returns with error.
     *
     * @param item The item
     * @throws Exception If any exception
     */
    public final void setItem(final String item) throws Exception
    {
      this.failField = item;
      this.item = failField + item;
      throw new Exception();
    }

    /**
     * Returns with the value.
     *
     * @return The value
     */
    public final String getReturn()
    {
      return _return;
    }

    /**
     * Sets the value.
     *
     * @param retVal The value
     */
    public final void setReturn(final String retVal)
    {
      this._return = retVal;
    }
  }
}
