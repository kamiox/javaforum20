/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import hu.javaforum.util.Params;
import java.util.Map;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test of the StaticData class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class StaticDataTest
{

  /**
   * The default constructor.
   */
  public StaticDataTest()
  {
    Map<String, String> map = new Params();
    map.put("a", "b");
    StaticData.INSTANCE.setConfigData(map);
  }

  /**
   * Test of setConfigData method, of class StaticData.
   */
  @Test
  public final void testSetConfigData()
  {
    Map<String, String> map = new Params();
    map.put("a", "b");
    StaticData.INSTANCE.setConfigData(map);
    assertNotNull(map, "value is null");
  }

  /**
   * Test of getConfigData method, of class StaticData.
   */
  @Test
  public final void testGetConfigData()
  {
    String key = "a";
    String expResult = "b";
    Map<String, String> configData = StaticData.INSTANCE.getConfigData();
    assertNotNull(configData, "value is null");
    String result = configData.get(key);
    assertEquals(expResult, result, "values are not equal");
  }

  /**
   * Test of getConfigValue method, of class StaticData.
   */
  @Test
  public final void testGetConfigValue()
  {
    String key = "a";
    String expResult = "b";
    String result = StaticData.INSTANCE.getConfigValue(key);
    assertEquals(expResult, result, "values are not equal");
  }
}
