/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import hu.javaforum.services.CommonBean;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class contains static data.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * Refactoring (2009-07-13)
 * Refactoring (2008-07-19)
 * The first implementation (2008-06-01)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public final class StaticData extends CommonBean
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * The static instance (singleton pattern).
   */
  public static final StaticData INSTANCE = new StaticData();
  /**
   * The version number.
   */
  public static final String VERSION = "1.0.0-SNAPSHOT";
  /**
   * The configuration data of the portal.
   */
  private final Map<String, String> configData;

  /**
   * The private constructor, because all methods are static.
   */
  private StaticData()
  {
    super();

    configData = new HashMap<String, String>();
  }

  /**
   * Returns the map of configuration.
   *
   * @return The map
   */
  public Map<String, String> getConfigData()
  {
    return Collections.unmodifiableMap(configData);
  }

  /**
   * Loads the map of configuration.
   *
   * @param map The map
   */
  public void setConfigData(final Map<String, String> map)
  {
    configData.clear();
    configData.putAll(map);
  }

  /**
   * Gets the value of the key.
   *
   * @param key The key
   * @return The value
   */
  public String getConfigValue(final String key)
  {
    return configData.get(key);
  }
}
