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
public class SubDetailsWrapper extends CommonBean
{

  /**
   * A Boolean value.
   */
  @PrintField
  private Boolean booleanValue;
  /**
   * A Byte value.
   */
  @PrintField
  private Byte byteValue;
  /**
   * A Double value.
   */
  @PrintField
  private Double doubleValue;
  /**
   * A Float value.
   */
  @PrintField
  private Float floatValue;
  /**
   * An Integer value.
   */
  @PrintField
  private Integer integerValue;
  /**
   * A Long value.
   */
  @PrintField
  private Long longValue;
  /**
   * A Short value.
   */
  @PrintField
  private Short shortValue;
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
  public SubDetailsWrapper()
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
   * @param integerValue An integer value
   * @param longValue A long value
   * @param shortValue A short value
   * @param textValue A text value
   * @param hiddenTextValue A hidden text value
   * @param nonPrintableTextValue A non printable text value
   * @param move An enum value
   * @param bigInteger A BigInteger value
   * @param bigDecimal A BigDecimal value
   */
  public SubDetailsWrapper(final Boolean booleanValue, final Byte byteValue,
          final Double doubleValue, final Float floatValue,
          final Integer integerValue, final Long longValue,
          final Short shortValue, final String textValue,
          final String hiddenTextValue, final String nonPrintableTextValue,
          final Move move, final BigDecimal bigDecimal, final BigInteger bigInteger)
  {
    this.booleanValue = booleanValue;
    this.byteValue = byteValue;
    this.doubleValue = doubleValue;
    this.floatValue = floatValue;
    this.integerValue = integerValue;
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
  public final Boolean getBooleanValue()
  {
    return booleanValue;
  }

  /**
   * Sets the value.
   *
   * @param booleanValue The value
   */
  public final void setBooleanValue(final Boolean booleanValue)
  {
    this.booleanValue = booleanValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final Byte getByteValue()
  {
    return byteValue;
  }

  /**
   * Sets the value.
   *
   * @param byteValue The value
   */
  public final void setByteValue(final Byte byteValue)
  {
    this.byteValue = byteValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final Double getDoubleValue()
  {
    return doubleValue;
  }

  /**
   * Sets the value.
   *
   * @param doubleValue The value
   */
  public final void setDoubleValue(final Double doubleValue)
  {
    this.doubleValue = doubleValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final Float getFloatValue()
  {
    return floatValue;
  }

  /**
   * Sets the value.
   *
   * @param floatValue The value
   */
  public final void setFloatValue(final Float floatValue)
  {
    this.floatValue = floatValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final Integer getIntegerValue()
  {
    return integerValue;
  }

  /**
   * Sets the value.
   *
   * @param integerValue The value
   */
  public final void setIntegerValue(final Integer integerValue)
  {
    this.integerValue = integerValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final Long getLongValue()
  {
    return longValue;
  }

  /**
   * Sets the value.
   *
   * @param longValue The value
   */
  public final void setLongValue(final Long longValue)
  {
    this.longValue = longValue;
  }

  /**
   * Returns with the value.
   *
   * @return The value
   */
  public final Short getShortValue()
  {
    return shortValue;
  }

  /**
   * Sets the value.
   *
   * @param shortValue The value
   */
  public final void setShortValue(final Short shortValue)
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
