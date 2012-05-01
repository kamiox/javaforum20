/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test of the CacheMap class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-15)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CacheMapTest
{

  /**
   * The CacheMap instance.
   */
  private CacheMap cacheMap;

  /**
   * The constructor.
   */
  public CacheMapTest()
  {
    this.cacheMap = new CacheMap(1000, 4);
  }

  /**
   * Test of constructor, of class CacheMap.
   */
  @Test
  public final void testConstructor()
  {
    this.cacheMap = new CacheMap(null, null);
    assertNotNull(this.cacheMap, "value is null");

    this.cacheMap = new CacheMap(null, 4);
    assertNotNull(this.cacheMap, "value is null");

    this.cacheMap = new CacheMap(1000, null);
    assertNotNull(this.cacheMap, "value is null");

    this.cacheMap = new CacheMap(1000, 4);
    assertNotNull(this.cacheMap, "value is null");
  }

  /**
   * Test of put method, of class CacheMap.
   */
  @Test
  public final void testPut()
  {
    this.cacheMap.put("key1", "value2");
    assertEquals(this.cacheMap.get("key1"), "value2", "values are not equal");

    this.cacheMap.put(null, "value");
    assertEquals(this.cacheMap.get("key1"), "value2", "values are not equal");

    this.cacheMap.put("key1", null);
    assertEquals(this.cacheMap.get("key1"), "value2", "values are not equal");

    this.cacheMap.put("key1", "value1");
    assertEquals(this.cacheMap.get("key1"), "value1", "values are not equal");

    this.cacheMap.put("key2", "value2");
    assertEquals(this.cacheMap.get("key1"), "value1", "values are not equal");
    assertEquals(this.cacheMap.get("key2"), "value2", "values are not equal");

    this.cacheMap.put("key3", "value3");
    assertEquals(this.cacheMap.get("key1"), "value1", "values are not equal");
    assertEquals(this.cacheMap.get("key2"), "value2", "values are not equal");
    assertEquals(this.cacheMap.get("key3"), "value3", "values are not equal");

    this.cacheMap.put("key4", "value4");
    assertEquals(this.cacheMap.get("key1"), "value1", "values are not equal");
    assertEquals(this.cacheMap.get("key2"), "value2", "values are not equal");
    assertEquals(this.cacheMap.get("key3"), "value3", "values are not equal");
    assertEquals(this.cacheMap.get("key4"), "value4", "values are not equal");

    this.cacheMap.put("key5", "value5");
    assertNull(this.cacheMap.get("key1"), "value is not null");
    assertEquals(this.cacheMap.get("key2"), "value2", "values are not equal");
    assertEquals(this.cacheMap.get("key3"), "value3", "values are not equal");
    assertEquals(this.cacheMap.get("key4"), "value4", "values are not equal");
    assertEquals(this.cacheMap.get("key5"), "value5", "values are not equal");

    try
    {
      Thread.sleep(2000);
    } catch (InterruptedException ex)
    {
      Logger.getLogger(CacheMapTest.class.getName()).log(Level.SEVERE, null, ex);
    }

    /**
     * The get method will remove the key, if the lifetime of that key is
     * expired, but the method returns with the value!
     */
    assertNull(this.cacheMap.get("key1"), "value is not null");
    assertEquals(this.cacheMap.get("key2"), "value2", "values are not equal");
    assertEquals(this.cacheMap.get("key3"), "value3", "values are not equal");
    assertEquals(this.cacheMap.get("key4"), "value4", "values are not equal");
    assertEquals(this.cacheMap.get("key5"), "value5", "values are not equal");
    assertNull(this.cacheMap.get("key1"), "value is not null");
    assertNull(this.cacheMap.get("key2"), "value is not null");
    assertNull(this.cacheMap.get("key3"), "value is not null");
    assertNull(this.cacheMap.get("key4"), "value is not null");
    assertNull(this.cacheMap.get("key5"), "value is not null");
  }

  /**
   * Test of get method, of class CacheMap.
   */
  @Test
  public final void testGet()
  {
    assertNull(this.cacheMap.get(null), "value is not null");
  }
}
