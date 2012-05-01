/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test of the AbstractLogger class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class AbstractLoggerTest
{

  /**
   * The default constructor.
   */
  public AbstractLoggerTest()
  {
    super();
  }

  /**
   * Test of getClassName method, of class AbstractLogger.
   */
  @Test
  public final void testGetClassName()
  {
    AbstractLogger instance = new Logger(String.class);
    assertEquals("java.lang.String", instance.getClassName(), "values are not equal");

    instance = new Logger("java.lang.String");
    assertEquals("java.lang.String", instance.getClassName(), "values are not equal");

    try
    {
      Class cls = null;
      Logger logger = new Logger(cls);
      fail("illegal state");
      logger.doLog(Level.TRACE, "illegal state");
    } catch (IllegalArgumentException except)
    {
      assertNotNull(except, "value is null");
    }

    try
    {
      String className = null;
      Logger logger = new Logger(className);
      fail("illegal state");
      logger.doLog(Level.TRACE, "illegal state");
    } catch (IllegalArgumentException except)
    {
      assertNotNull(except, "value is null");
    }
  }

  /**
   * Test of doLog method, of class AbstractLogger.
   */
  @Test
  public final void testDoLogLevelString()
  {
    Level level = Level.INFO;
    String message = "testDoLog_Level_String";
    AbstractLogger instance = new Logger(Level.class);
    instance.doLog(level, message);
    assertNotNull(instance, "value is null");
  }

  /**
   * Test of doLog method, of class AbstractLogger.
   */
  @Test
  public final void testDoLogLevelStringThrowable()
  {
    Level level = Level.INFO;
    String message = "testDoLog_Level_String_Throwable";
    Throwable cause = null;
    AbstractLogger instance = new Logger(Level.class);
    instance.doLog(level, message, cause);
    assertNotNull(instance, "value is null");
  }

  /**
   * Test of isLevel method, of class AbstractLogger.
   */
  @Test
  public final void testIsLevel()
  {
    Level level = Level.INFO;
    AbstractLogger instance = new Logger(Level.class);
    assertTrue(instance.isLevel(level), "value is false");
  }
}
