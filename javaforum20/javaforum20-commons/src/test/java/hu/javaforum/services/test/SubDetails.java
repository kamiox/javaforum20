/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services.test;

import hu.javaforum.annotations.PrintField;
import hu.javaforum.enums.Move;
import hu.javaforum.services.CommonBean;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Test class for the CommonBeanTest tests.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * First implementation (2011-07-02)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class SubDetails extends CommonBean
{

  /**
   * A boolean value.
   */
  @PrintField
  private boolean booleanValue;
  /**
   * A Byte value.
   */
  @PrintField
  private byte byteValue;
  /**
   * A double value.
   */
  @PrintField
  private double doubleValue;
  /**
   * A float value.
   */
  @PrintField
  private float floatValue;
  /**
   * An int value.
   */
  @PrintField
  private int intValue;
  /**
   * A long value.
   */
  @PrintField
  private long longValue;
  /**
   * A short value.
   */
  @PrintField
  private short shortValue;
  /**
   * A text value.
   */
  @PrintField
  private String textValue;
  /**
   * A hidden text value.
   */
  @PrintField(hidden = true)
  private String hiddenTextValue;
  /**
   * A non printable text value.
   */
  private String nonPrintableTextValue;
  /**
   * An enum value.
   */
  @PrintField
  private Move move;
  /**
   * A BigDecimal value.
   */
  @PrintField
  private BigDecimal bigDecimal;
  /**
   * A BigInteger value.
   */
  @PrintField
  private BigInteger bigInteger;

  /**
   * Empty constructor for bean pattern.
   */
  public SubDetails()
  {
    super();
  }

  /**
   * Fills up the fields.
   *
   * @param booleanValue A boolean value
   * @param byteValue A byte value
   * @param doubleValue A double value
   * @param floatValue A float value
   * @param intValue An integer value
   * @param longValue A long value
   * @param shortValue A short value
   * @param textValue A text value
   * @param hiddenTextValue A hidden text value
   * @param nonPrintableTextValue A non printable text value
   * @param move An enum value
   * @param bigInteger A BigInteger value
   * @param bigDecimal A BigDecimal value
   */
  public SubDetails(final boolean booleanValue, final byte byteValue,
          final double doubleValue, final float floatValue,
          final int intValue, final long longValue,
          final short shortValue, final String textValue,
          final String hiddenTextValue, final String nonPrintableTextValue,
          final Move move, final BigDecimal bigDecimal, final BigInteger bigInteger)
  {
    this.booleanValue = booleanValue;
    this.byteValue = byteValue;
    this.doubleValue = doubleValue;
    this.floatValue = floatValue;
    this.intValue = intValue;
    this.longValue = longValue;
    this.shortValue = shortValue;
    this.textValue = textValue;
    this.hiddenTextValue = hiddenTextValue;
    this.nonPrintableTextValue = nonPrintableTextValue;
    this.move = move;
    this.bigDecimal = bigDecimal;
    this.bigInteger = bigInteger;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final boolean getBooleanValue()
  {
    return booleanValue;
  }

  /**
   * Sets the value.
   *
   * @param booleanValue The value
   */
  public final void setBooleanValue(final boolean booleanValue)
  {
    this.booleanValue = booleanValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final byte getByteValue()
  {
    return byteValue;
  }

  /**
   * Sets the value.
   *
   * @param byteValue The value
   */
  public final void setByteValue(final byte byteValue)
  {
    this.byteValue = byteValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final double getDoubleValue()
  {
    return doubleValue;
  }

  /**
   * Sets the value.
   *
   * @param doubleValue The value
   */
  public final void setDoubleValue(final double doubleValue)
  {
    this.doubleValue = doubleValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final float getFloatValue()
  {
    return floatValue;
  }

  /**
   * Sets the value.
   *
   * @param floatValue The value
   */
  public final void setFloatValue(final float floatValue)
  {
    this.floatValue = floatValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final int getIntValue()
  {
    return intValue;
  }

  /**
   * Sets the value.
   *
   * @param intValue The value
   */
  public final void setIntValue(final int intValue)
  {
    this.intValue = intValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final long getLongValue()
  {
    return longValue;
  }

  /**
   * Sets the value.
   *
   * @param longValue The value
   */
  public final void setLongValue(final long longValue)
  {
    this.longValue = longValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final short getShortValue()
  {
    return shortValue;
  }

  /**
   * Sets the value.
   *
   * @param shortValue The value
   */
  public final void setShortValue(final short shortValue)
  {
    this.shortValue = shortValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final String getTextValue()
  {
    return textValue;
  }

  /**
   * Sets the value.
   *
   * @param textValue The value
   */
  public final void setTextValue(final String textValue)
  {
    this.textValue = textValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final String getHiddenTextValue()
  {
    return hiddenTextValue;
  }

  /**
   * Sets the value.
   *
   * @param hiddenTextValue The value
   */
  public final void setHiddenTextValue(final String hiddenTextValue)
  {
    this.hiddenTextValue = hiddenTextValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final String getNonPrintableTextValue()
  {
    return nonPrintableTextValue;
  }

  /**
   * Sets the value.
   *
   * @param nonPrintableTextValue The value
   */
  public final void setNonPrintableTextValue(final String nonPrintableTextValue)
  {
    this.nonPrintableTextValue = nonPrintableTextValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final Move getMove()
  {
    return move;
  }

  /**
   * Sets the value.
   *
   * @param move The value
   */
  public final void setMove(final Move move)
  {
    this.move = move;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final BigDecimal getBigDecimal()
  {
    return bigDecimal;
  }

  /**
   * Sets the value.
   *
   * @param bigDecimal The value
   */
  public final void setBigDecimal(final BigDecimal bigDecimal)
  {
    this.bigDecimal = bigDecimal;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final BigInteger getBigInteger()
  {
    return bigInteger;
  }

  /**
   * Sets the value.
   *
   * @param bigInteger The value
   */
  public final void setBigInteger(final BigInteger bigInteger)
  {
    this.bigInteger = bigInteger;
  }
}
