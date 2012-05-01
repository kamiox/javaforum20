/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test of the LanguageQuality class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-13)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class LanguageQualityTest
{

  /**
   * The default constructor.
   */
  public LanguageQualityTest()
  {
    super();
  }

  /**
   * Test of getLanguage method, of class LanguageQuality.
   */
  @Test
  public final void testGetLanguage()
  {
    LanguageQuality instance = new LanguageQuality("hu_HU", 0.9);
    String expResult = "hu_HU";

    String result = instance.getLanguage();
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of setLanguage method, of class LanguageQuality.
   */
  @Test
  public final void testSetLanguage()
  {
    LanguageQuality instance = new LanguageQuality("hu_HU", 0.9);
    String language = "en_EN";
    instance.setLanguage(language);
    String result = instance.getLanguage();
    assertEquals(language, result, "values are not equal");

    language = null;
    instance.setLanguage(language);
    result = instance.getLanguage();
    assertEquals(language, result, "values are not equal");
  }

  /**
   * Test of getQuality method, of class LanguageQuality.
   */
  @Test
  public final void testGetQuality()
  {
    LanguageQuality instance = new LanguageQuality("hu_HU", 0.9);
    Double expResult = 0.9;

    Double result = instance.getQuality();
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of setQuality method, of class LanguageQuality.
   */
  @Test
  public final void testSetQuality()
  {
    LanguageQuality instance = new LanguageQuality("hu_HU", 0.9);
    Double quality = 0.75;
    instance.setQuality(quality);

    Double result = instance.getQuality();
    assertEquals(quality, result, "values are not equal");

    quality = null;
    instance.setQuality(quality);
    result = instance.getQuality();
    assertEquals(quality, result, "values are not equal");
  }

  /**
   * Test of compareTo method, of class LanguageQuality.
   */
  @Test
  public final void testCompareTo()
  {
    LanguageQuality instance = new LanguageQuality(null, null);
    LanguageQuality other = new LanguageQuality(null, null);
    int expResult = 0;

    int result = instance.compareTo(other);
    assertEquals(expResult, result, "values are not equal");

    instance = new LanguageQuality("hu_HU", 0.9);
    other = new LanguageQuality("en_EN", null);
    expResult = 0;

    result = instance.compareTo(other);
    assertEquals(expResult, result, "values are not equal");

    instance = new LanguageQuality("hu_HU", 0.9);
    other = new LanguageQuality("en_EN", 0.75);
    expResult = -1;

    result = instance.compareTo(other);
    assertEquals(expResult, result, "values are not equal");

    expResult = 0;
    result = instance.compareTo(null);
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of equals method, of class LanguageQuality.
   */
  @Test
  public final void testEquals()
  {
    LanguageQuality instance = new LanguageQuality(null, null);
    LanguageQuality other = new LanguageQuality(null, null);

    boolean result = instance.equals(other);
    assertTrue(result, "value is false");

    instance = new LanguageQuality("hu_HU", 0.9);
    other = new LanguageQuality("en_EN", null);

    result = instance.equals(other);
    assertFalse(result, "value is true");

    instance = new LanguageQuality("hu_HU", 0.9);
    other = new LanguageQuality("hu_HU", 0.9);

    result = instance.equals(other);
    assertTrue(result, "value is false");

    result = instance.equals((LanguageQuality) null);
    assertFalse(result, "value is true");
  }
}
