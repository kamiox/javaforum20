/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test of the CacheEntry class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-04-28)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CacheEntryTest
{

  /**
   * The constructor.
   */
  public CacheEntryTest()
  {
    super();
  }

  /**
   * Test of constructor, of class CacheEntry.
   */
  @Test
  public final void testCacheEntryStringString()
  {
    CacheEntry instance = new CacheEntry("uniquekey", "value");
    assertNotNull(instance, "values is null");

    try
    {
      instance = new CacheEntry(null, "value");
      /**
       * ...because FindBugs marked above "DEAD CODE STORE.
       */
      instance.getKey();
      fail("illegal state");
    } catch (IllegalArgumentException except)
    {
      assertNotNull(except, "values is null");
    }
  }

  /**
   * Test of getContent method, of class CacheEntry.
   */
  @Test
  public final void testGetContent()
  {
    CacheEntry instance = new CacheEntry("key", "value");
    assertEquals("value", instance.getContent(), "values are not equal");
  }

  /**
   * Test of setContent method, of class CacheEntry.
   */
  @Test
  public final void testSetContent()
  {
    CacheEntry instance = new CacheEntry("key", "value");
    Long firstCreated = instance.getCreated();
    assertEquals("value", instance.getContent(), "values are not equal");

    instance.setContent("another");
    assertEquals("another", instance.getContent(), "values are not equal");
    assertTrue(firstCreated <= instance.getCreated(), "value is not true");
  }

  /**
   * Test of getCreated method, of class CacheEntry.
   */
  @Test
  public final void testGetCreated()
  {
    Long nanoTime = System.nanoTime();
    CacheEntry instance = new CacheEntry("key", "value");
    assertTrue(nanoTime <= instance.getCreated(), "value is not true");
  }

  /**
   * Test of getKey method, of class CacheEntry.
   */
  @Test
  public final void testGetKey()
  {
    CacheEntry instance = new CacheEntry("key", "value");
    assertEquals("key", instance.getKey(), "values are not equal");
  }
}
