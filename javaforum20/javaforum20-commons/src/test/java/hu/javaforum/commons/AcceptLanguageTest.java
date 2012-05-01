/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import java.util.Locale;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test of the AcceptLanguage class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class AcceptLanguageTest
{

  /**
   * The default constructor.
   */
  public AcceptLanguageTest()
  {
    super();
  }

  /**
   * Test of getInstance method, of class AcceptLanguage.
   */
  @Test
  public final void testGetInstance()
  {
    AcceptLanguage al = AcceptLanguage.INSTANCE;
    assertNotNull(al, "value is null");
  }

  /**
   * Test of getLocale method, of class AcceptLanguage.
   */
  @Test
  public final void testGetLocale()
  {
    /**
     * Test null input.
     */
    String acceptLanguages = null;
    AcceptLanguage al = AcceptLanguage.INSTANCE;
    Locale result = al.getLocale(acceptLanguages);
    assertNotNull(result, "value is null");

    /**
     * Test null input.
     */
    acceptLanguages = null;
    result = al.getLocale(acceptLanguages);
    assertNotNull(result, "value is null");

    /**
     * Test empty input.
     */
    acceptLanguages = "";
    result = al.getLocale(acceptLanguages);
    assertNotNull(result, "value is null");

    /**
     * Test short input.
     */
    acceptLanguages = "hu-HU";
    Locale expResult = new Locale("hu", "hu");
    result = al.getLocale(acceptLanguages);
    assertEquals(expResult, result, "values are not equal");

    /**
     * Test short input with wrong quality.
     */
    acceptLanguages = "hu-HU;q";
    expResult = new Locale("hu", "hu");
    result = al.getLocale(acceptLanguages);
    assertEquals(expResult, result, "values are not equal");

    /**
     * Test short input with wildcard language.
     */
    acceptLanguages = "hu-HU;q=0.8, *;q=0.5";
    expResult = new Locale("hu", "hu");
    result = al.getLocale(acceptLanguages);
    assertEquals(expResult, result, "values are not equal");

    /**
     * Test wrong country name.
     */
    acceptLanguages = "hu-BLA;q=0.8";
    expResult = new Locale("hu", "BLA");
    result = al.getLocale(acceptLanguages);
    assertEquals(expResult, result, "values are not equal");

    /**
     * Test a normal input.
     */
    acceptLanguages = "en;q=0.6, hu-HU;q=0.8, en;q=0.7";
    expResult = new Locale("hu", "hu");
    result = al.getLocale(acceptLanguages);
    assertEquals(expResult, result, "values are not equal");

    /**
     * Test another normal input.
     */
    acceptLanguages = "en;q=0.9, hu-HU;q=0.8, en;q=0.7";
    expResult = new Locale("en", "EN");
    result = al.getLocale(acceptLanguages);
    assertEquals(expResult, result, "values are not equal");
  }
}
