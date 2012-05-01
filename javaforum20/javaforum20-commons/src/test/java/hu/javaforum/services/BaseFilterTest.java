/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.services.BaseFilter.Operation;
import hu.javaforum.services.BaseFilter.OrderDirection;
import java.util.Map;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test of the BaseFilter class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * First implementation (2011-06-23)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class BaseFilterTest
{

  /**
   * The default constructor.
   */
  public BaseFilterTest()
  {
    super();
  }

  /**
   * Test of constructor, of class BaseFilter.
   */
  @Test
  public final void testConstructor()
  {
    BaseFilter instance = new BaseFilter();
    assertNotNull(instance, "value is null");
    instance = new BaseFilter(Operation.EQUALS);
    assertNotNull(instance, "value is null");
    instance = new BaseFilter(Operation.EQUALS, Boolean.TRUE);
    assertNotNull(instance, "value is null");
  }

  /**
   * Test of addFilter, getFilters and removeFilter methods, of class
   * BaseFilter.
   */
  @Test
  public final void testFilter()
  {
    BaseFilter instance = new BaseFilter();
    Map<String, BaseFilter.OperationValue> filters = instance.getFilters();
    assertNotNull(filters, "value is null");
    assertTrue(filters.isEmpty(), "value is false");

    instance.addFilter("field", "value");
    filters = instance.getFilters();
    assertNotNull(filters, "value is null");
    assertEquals(filters.size(), 1, "values are not equal");
    assertNotNull(filters.get("field"), "value is null");
    assertEquals(filters.get("field").getOperation(), Operation.LIKE, "values are not equal");
    assertEquals(filters.get("field").getValue(), "value", "values are not equal");

    instance.addFilter("otherField", Operation.IS_NOT_NULL, "otherValue");
    filters = instance.getFilters();
    assertNotNull(filters, "value is null");
    assertEquals(filters.size(), 2, "values are not equal");
    assertNotNull(filters.get("field"), "value is null");
    assertEquals(filters.get("field").getOperation(), Operation.LIKE, "values are not equal");
    assertEquals(filters.get("field").getValue(), "value", "values are not equal");
    assertNotNull(filters.get("otherField"), "value is null");
    assertEquals(filters.get("otherField").getOperation(), Operation.IS_NOT_NULL, "values are not equal");
    assertEquals(filters.get("otherField").getValue(), "otherValue", "values are not equal");

    try
    {
      filters.put("fail", null);
      fail("illegal state");
    } catch (Exception except)
    {
      assertNotNull(except, "value is null");
    }

    instance.removeFilter("otherField");
    filters = instance.getFilters();
    assertNotNull(filters, "value is null");
    assertEquals(filters.size(), 1, "values are not equal");
    assertNotNull(filters.get("field"), "value is null");
    assertEquals(filters.get("field").getOperation(), Operation.LIKE, "values are not equal");
    assertNull(filters.get("otherField"), "value is not null");

    instance.addFilter("nextField", Operation.IS_NULL, null);
    filters = instance.getFilters();
    assertNotNull(filters, "value is null");
    assertEquals(filters.size(), 2, "values are not equal");
    assertNotNull(filters.get("field"), "value is null");
    assertEquals(filters.get("field").getOperation(), Operation.LIKE, "values are not equal");
    assertEquals(filters.get("field").getValue(), "value", "values are not equal");
    assertNotNull(filters.get("nextField"), "value is null");
    assertEquals(filters.get("nextField").getOperation(), Operation.IS_NULL, "values are not equal");
    assertEquals(filters.get("nextField").getValue(), null, "values are not equal");
  }

  /**
   * Test of getFirstResult and setFirstResult methods, of class BaseFilter.
   */
  @Test
  public final void testFirstResult()
  {
    BaseFilter instance = new BaseFilter();
    assertNull(instance.getFirstResult(), "value is not null");
    instance.setFirstResult(new Integer(10));
    assertEquals(instance.getFirstResult(), new Integer(10), "values are not equal");
    instance.setFirstResult(null);
    assertNull(instance.getFirstResult(), "value is not null");
  }

  /**
   * Test of getMaxResults and setMaxResults methods, of class BaseFilter.
   */
  @Test
  public final void testMaxResults()
  {
    BaseFilter instance = new BaseFilter();
    assertNull(instance.getMaxResults(), "value is not null");
    instance.setMaxResults(new Integer(10));
    assertEquals(instance.getMaxResults(), new Integer(10), "values are not equal");
    instance.setMaxResults(null);
    assertNull(instance.getMaxResults(), "value is not null");
  }

  /**
   * Test of addSort, getSorts and removeSort methods, of class BaseFilter.
   */
  @Test
  public final void testSort()
  {
    BaseFilter instance = new BaseFilter();
    Map<String, OrderDirection> sorts = instance.getSorts();
    assertNotNull(sorts, "value is null");
    assertTrue(sorts.isEmpty(), "value is false");

    instance.addSort("field", OrderDirection.ASCENT);
    sorts = instance.getSorts();
    assertNotNull(sorts, "value is null");
    assertEquals(sorts.size(), 1, "values are not equal");
    assertEquals(sorts.get("field"), OrderDirection.ASCENT, "values are not equal");

    instance.addSort("otherField", OrderDirection.DESCENT);
    sorts = instance.getSorts();
    assertNotNull(sorts, "value is null");
    assertEquals(sorts.size(), 2, "values are not equal");
    assertEquals(sorts.get("field"), OrderDirection.ASCENT, "values are not equal");
    assertEquals(sorts.get("field").toString(), "ASC", "values are not equal");
    assertEquals(sorts.get("otherField"), OrderDirection.DESCENT, "values are not equal");
    assertEquals(sorts.get("otherField").toString(), "DESC", "values are not equal");

    try
    {
      sorts.put("fail", OrderDirection.ASCENT);
      fail("illegal state");
    } catch (Exception except)
    {
      assertNotNull(except, "value is null");
    }

    instance.removeSort("otherField");
    sorts = instance.getSorts();
    assertNotNull(sorts, "value is null");
    assertEquals(sorts.size(), 1, "values are not equal");
    assertEquals(sorts.get("field"), OrderDirection.ASCENT, "values are not equal");

    instance.removeSort("field");
    sorts = instance.getSorts();
    assertNotNull(sorts, "value is null");
    assertTrue(sorts.isEmpty(), "value is false");
    assertNull(sorts.get("field"), "value is not null");
  }

  /**
   * Test of getTimelineFilter and setTimelineFilter methods, of class
   * BaseFilter.
   */
  @Test
  public final void testTimelineFilter()
  {
    BaseFilter instance = new BaseFilter();
    assertFalse(instance.getTimelineFilter(), "value is true");
    instance.setTimelineFilter(true);
    assertTrue(instance.getTimelineFilter(), "value is false");
  }

  /**
   * Test of equals method, of class BaseFilter.
   */
  @Test
  public final void testEquals()
  {
    BaseFilter instance = new BaseFilter();
    assertFalse(instance.equals(null), "value is true");
    BaseFilter other = new BaseFilter();
    assertTrue(instance.equals(other), "value is false");
    assertFalse(instance.equals("text"), "value is true");
    other.setTimelineFilter(true);
    assertFalse(instance.equals(other), "value is true");
  }

  /**
   * Test of hashCode method, of class BaseFilter.
   */
  @Test
  public final void testHashCode()
  {
    BaseFilter instance = new BaseFilter();
    int hashCode = instance.hashCode();
    assertEquals(hashCode, -323083221, "values are not equal");
  }

  /**
   * Test of toString method (test of PrintField annotations), of class
   * BaseFilter.
   */
  @Test
  public final void testToString()
  {
    BaseFilter instance = new BaseFilter();
    String xml = instance.toString();
    assertNotNull(xml, "value is null");
  }
}
