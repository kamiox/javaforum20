/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test of the Logger class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class LoggerTest
{

  /**
   * The default constructor.
   */
  public LoggerTest()
  {
    super();
  }

  /**
   * Test of doLog method, of class Logger.
   */
  @Test
  public final void testDoLogLevelString()
  {
    String message = "testDoLog_Level_String_DEBUG";
    Logger instance = new Logger(LoggerTest.class);
    instance.doLog(Level.DEBUG, message);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_INFO";
    instance = new Logger(LoggerTest.class.getName());
    instance.doLog(Level.INFO, message);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_WARN";
    instance = new Logger(LoggerTest.class);
    instance.doLog(Level.WARN, message);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_ERROR";
    instance = new Logger(LoggerTest.class.getName());
    instance.doLog(Level.ERROR, message);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_TRACE";
    instance = new Logger(LoggerTest.class);
    instance.doLog(Level.TRACE, message);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_null";
    instance = new Logger(LoggerTest.class.getName());
    instance.doLog(null, message);
    assertNotNull(instance, "value is null");
  }

  /**
   * Test of doLog method, of class Logger.
   */
  @Test
  public final void testDoLogLevelStringThrowable()
  {
    String message = "testDoLog_Level_String_Throwable_DEBUG";
    Logger instance = new Logger(LoggerTest.class);
    instance.doLog(Level.DEBUG, message, null);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_Throwable_INFO";
    instance = new Logger(LoggerTest.class.getName());
    instance.doLog(Level.INFO, message, null);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_Throwable_WARN";
    instance = new Logger(LoggerTest.class);
    instance.doLog(Level.WARN, message, null);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_Throwable_ERROR";
    instance = new Logger(LoggerTest.class.getName());
    instance.doLog(Level.ERROR, message, null);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_Throwable_TRACE";
    instance = new Logger(LoggerTest.class);
    instance.doLog(Level.TRACE, message, null);
    assertNotNull(instance, "value is null");

    message = "testDoLog_Level_String_Throwable_null";
    instance = new Logger(LoggerTest.class.getName());
    instance.doLog(null, message, null);
    assertNotNull(instance, "value is null");
  }

  /**
   * Test of isLevel method, of class Logger.
   */
  @Test
  public final void testIsLevel()
  {
    Logger instance = new Logger(LoggerTest.class);
    assertNotNull(instance, "value is null");

    instance.isLevel(Level.DEBUG);
    instance.isLevel(Level.INFO);
    instance.isLevel(Level.WARN);
    instance.isLevel(Level.ERROR);
    instance.isLevel(Level.TRACE);
    instance.isLevel(null);
  }
}
