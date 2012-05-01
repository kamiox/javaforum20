/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.annotations.PrintField;
import hu.javaforum.util.NullSafe;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The BaseFilter class is provides a simple filter and sort capabilities,
 * forked from the ExpressionFilter class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-02-15)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
@XmlTransient
public class BaseFilter extends CommonBean
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * The default string operation is 'like'.
   */
  @PrintField
  private Operation defaultFilterOperation = Operation.LIKE;
  /**
   * The filter operations map with field name as key and operation as value.
   */
  @PrintField
  private final Map<String, OperationValue> filters = new HashMap<String, OperationValue>();
  /**
   * The offset of the first result.
   */
  @PrintField
  private Integer firstResult = null;
  /**
   * The maximum number of the results.
   */
  @PrintField
  private Integer maxResults = null;
  /**
   * The sort map is contains field name as key and order direction as value.
   */
  @PrintField
  private final Map<String, OrderDirection> sorts = new HashMap<String, OrderDirection>();
  /**
   * The timeline filter (created-approved-expired-deleted) is disabled by default.
   */
  @PrintField
  private Boolean timelineFilter = Boolean.FALSE;

  /**
   * The default constructor with the default settings.
   */
  public BaseFilter()
  {
    this(Operation.LIKE, Boolean.FALSE);
  }

  /**
   * Constructor with operation set.
   *
   * @param operation The operation
   */
  public BaseFilter(final Operation operation)
  {
    this(operation, Boolean.FALSE);
  }

  /**
   * Constructor with operation and timeline set.
   *
   * @param operation The operation
   * @param timelineFilter The timeline filter
   */
  public BaseFilter(final Operation operation, final Boolean timelineFilter)
  {
    this.firstResult = null;
    this.maxResults = null;
    this.defaultFilterOperation = operation;
    this.timelineFilter = timelineFilter;
  }

  /**
   * Add filter entry with default operation.
   *
   * @param field The name of the field
   * @param value The value of the field
   * @return The BaseFilter instance for 'fluent interface' behaviour
   */
  public final BaseFilter addFilter(final String field, final Object value)
  {
    return addFilter(field, defaultFilterOperation, value);
  }

  /**
   * Add filter entry with specified operation.
   *
   * @param field The name of the field
   * @param operation The operation
   * @param value The value of the field
   * @return The BaseFilter instance for 'fluent interface' behaviour
   */
  public final BaseFilter addFilter(final String field, final Operation operation, final Object value)
  {
    /**
     * If the value is null, then modify operation to 'IS NULL' except the
     * default operation is 'IS NOT NULL'
     */
    if (!Operation.IS_NOT_NULL.equals(operation) && value == null)
    {
      filters.put(field, new OperationValue(Operation.IS_NULL, null));
    } else
    {
      filters.put(field, new OperationValue(operation, value));
    }

    return this;
  }

  /**
   * Returns an unmodifiable filters map.
   *
   * @return The map
   */
  public final Map<String, OperationValue> getFilters()
  {
    return Collections.unmodifiableMap(filters);
  }

  /**
   * Remove field from filter.
   *
   * @param field The field name
   * @return The BaseFilter instance for 'fluent interface' behaviour
   */
  public final BaseFilter removeFilter(final String field)
  {
    filters.remove(field);

    return this;
  }

  /**
   * Gets the value of the first result.
   *
   * @return The value
   */
  public final Integer getFirstResult()
  {
    return firstResult;
  }

  /**
   * Sets the value of the first result.
   *
   * @param firstResult The new value
   */
  public final void setFirstResult(final Integer firstResult)
  {
    this.firstResult = firstResult;
  }

  /**
   * Gets the value of the maximum results.
   *
   * @return The value
   */
  public final Integer getMaxResults()
  {
    return maxResults;
  }

  /**
   * Sets the value of the maximum results.
   *
   * @param maxResults The new value
   */
  public final void setMaxResults(final Integer maxResults)
  {
    this.maxResults = maxResults;
  }

  /**
   * Add a new sort entry.
   *
   * @param field The field name
   * @param direction The order direction
   * @return The BaseFilter instance for 'fluent interface' behaviour
   */
  public final BaseFilter addSort(final String field, final OrderDirection direction)
  {
    sorts.put(field, direction);

    return this;
  }

  /**
   * Returns an unmodifiable sorts map.
   *
   * @return The map
   */
  public final Map<String, OrderDirection> getSorts()
  {
    return Collections.unmodifiableMap(sorts);
  }

  /**
   * Remove the sort entry by field name.
   *
   * @param field The field name
   * @return The BaseFilter instance for 'fluent interface' behaviour
   */
  public final BaseFilter removeSort(final String field)
  {
    sorts.remove(field);

    return this;
  }

  /**
   * Gets the value of the timeline filter.
   *
   * @return The value
   */
  public final Boolean getTimelineFilter()
  {
    return timelineFilter;
  }

  /**
   * Sets the value of the timeline filter.
   *
   * @param timelineFilter The new value
   */
  public final void setTimelineFilter(final Boolean timelineFilter)
  {
    this.timelineFilter = timelineFilter;
  }

  /**
   * Equals method.
   *
   * @param obj The other obj
   * @return True, if this instance and the other object is equals
   */
  @Override
  public final boolean equals(final Object obj)
  {
    return obj instanceof BaseFilter && obj.hashCode() == this.hashCode();
  }

  /**
   * Generate a hash code.
   *
   * @return The hash code
   */
  @Override
  public final int hashCode()
  {
    int hash = HASH_BASE;
    hash = HASH_MULTIPLIER * hash + NullSafe.hashCode(this.defaultFilterOperation);
    hash = HASH_MULTIPLIER * hash + NullSafe.hashCode(this.filters);
    hash = HASH_MULTIPLIER * hash + NullSafe.hashCode(this.firstResult);
    hash = HASH_MULTIPLIER * hash + NullSafe.hashCode(this.maxResults);
    hash = HASH_MULTIPLIER * hash + NullSafe.hashCode(this.sorts);
    hash = HASH_MULTIPLIER * hash + NullSafe.hashCode(this.timelineFilter);

    return hash;
  }

  /**
   * This class holds an operation - value pair.
   */
  public static final class OperationValue implements Serializable
  {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * The operation.
     */
    private final Operation operation;
    /**
     * The value.
     */
    private final Object value;

    /**
     * Creates a new instance.
     *
     * @param operation The operation
     * @param value The value
     */
    public OperationValue(final Operation operation, final Object value)
    {
      this.operation = operation;
      this.value = value;
    }

    /**
     * Gets the operation.
     *
     * @return The operation
     */
    public Operation getOperation()
    {
      return operation;
    }

    /**
     * Gets the value.
     *
     * @return The value
     */
    public Object getValue()
    {
      return value;
    }
  }

  /**
   * The valid operations.
   */
  public enum Operation
  {

    /**
     * Equals.
     */
    EQUALS(" = "),
    /**
     * Not equals.
     */
    NOT_EQUALS(" <> "),
    /**
     * Greater than.
     */
    GREATER(" > "),
    /**
     * Greater or equals than.
     */
    GREATER_EQUALS(" >= "),
    /**
     * Less than.
     */
    LESS(" < "),
    /**
     * Less or equals than.
     */
    LESS_EQUALS(" <= "),
    /**
     * Like.
     */
    LIKE(" LIKE "),
    /**
     * Not like.
     */
    NOT_LIKE(" NOT LIKE "),
    /**
     * Is null.
     */
    IS_NULL(" IS NULL "),
    /**
     * Is not null.
     */
    IS_NOT_NULL(" IS NOT NULL ");
    /**
     * The operation as string.
     */
    private final String operation;

    /**
     * The private constructor.
     *
     * @param operation The operation
     */
    private Operation(final String operation)
    {
      this.operation = operation;
    }

    /**
     * Get the operation as string.
     *
     * @return The operation
     */
    @Override
    public String toString()
    {
      return operation;
    }
  }

  /**
   * The 'order by' directions.
   */
  public enum OrderDirection
  {

    /**
     * Ascent order.
     */
    ASCENT("ASC"),
    /**
     * Descent order.
     */
    DESCENT("DESC");
    /**
     * The order as string.
     */
    private final String direction;

    /**
     * The private constructor.
     *
     * @param direction The direction
     */
    private OrderDirection(final String direction)
    {
      this.direction = direction;
    }

    /**
     * Get the order as string.
     *
     * @return The order
     */
    @Override
    public String toString()
    {
      return direction;
    }
  }
}
