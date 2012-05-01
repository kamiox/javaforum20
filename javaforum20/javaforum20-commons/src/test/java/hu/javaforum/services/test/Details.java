/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services.test;

import hu.javaforum.annotations.PrintField;
import hu.javaforum.services.CommonBean;
import java.util.Calendar;
import java.util.Date;
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
public class Details extends CommonBean
{

  /**
   * A Calendar value.
   */
  @PrintField
  private Calendar calendarValue;
  /**
   * A Date value.
   */
  @PrintField
  private Date dateValue;
  /**
   * The array of SubDetails instances.
   */
  @PrintField(maximumItemDump = 2)
  private SubDetails[] subDetailsArray;
  /**
   * The list of SubDetails instances.
   */
  @PrintField(maximumItemDump = 2)
  private List<SubDetails> subDetailsList;
  /**
   * An integer array.
   */
  @PrintField(maximumItemDump = 2)
  private int[] intArray;
  /**
   * A byte array.
   */
  @PrintField(maximumHexDump = 2)
  private byte[] byteArray;

  /**
   * Empty constructor for bean pattern.
   */
  public Details()
  {
    super();
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final Calendar getCalendarValue()
  {
    return calendarValue;
  }

  /**
   * Sets the value.
   *
   * @param calendarValue The value
   */
  public final void setCalendarValue(final Calendar calendarValue)
  {
    this.calendarValue = calendarValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final Date getDateValue()
  {
    return dateValue;
  }

  /**
   * Sets the value.
   *
   * @param dateValue The value
   */
  public final void setDateValue(final Date dateValue)
  {
    this.dateValue = dateValue;
  }

  /**
   * Returns with the SubDetails instances.
   *
   * @return The SubDetails instances
   */
  public final SubDetails[] getSubDetailsArray()
  {
    return subDetailsArray;
  }

  /**
   * Sets the SubDetails instances.
   *
   * @param subDetailsArray The SubDetails instances
   */
  public final void setSubDetails(final SubDetails[] subDetailsArray)
  {
    this.subDetailsArray = subDetailsArray;
  }

  /**
   * Returns with the SubDetails instances.
   *
   * @return The SubDetails instances
   */
  public final List<SubDetails> getSubDetailsList()
  {
    return subDetailsList;
  }

  /**
   * Sets the SubDetails instances.
   *
   * @param subDetailsList The SubDetails instances
   */
  public final void setSubDetailsList(final List<SubDetails> subDetailsList)
  {
    this.subDetailsList = subDetailsList;
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
