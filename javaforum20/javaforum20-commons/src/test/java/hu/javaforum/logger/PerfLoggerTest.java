/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test of the PerfLogger class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class PerfLoggerTest
{

  /**
   * The default constructor.
   */
  public PerfLoggerTest()
  {
    super();
  }

  /**
   * Test of debug method, of class PerfLogger.
   */
  @Test
  public final void testDebugStringObjectArr()
  {
    try
    {
      String message = "message %1$s %2$s";
      Throwable cause = new Exception();
      String parameter = "nothing";
      Logger logger = new Logger(PerfLoggerTest.class);
      logger.setForcedLevel(Level.DEBUG);
      PerfLogger instance = new PerfLogger(logger);
      assertNotNull(instance, "value is null");

      instance.debug(message);
      instance.debug(message, cause);
      instance.debug(message, parameter);
      instance.debug(message, cause, parameter);
      instance.debug(message, cause, parameter, "");

      instance = new PerfLogger(logger);
      logger.setForcedLevel(Level.TRACE);
      instance.debug(message, parameter);
      instance.debug(message, cause, parameter);
      instance.debug(message, cause, parameter, "");
    } catch (Exception except)
    {
      assertNotNull(except, "value is null");
    }
  }

  /**
   * Test of info method, of class PerfLogger.
   */
  @Test
  public final void testInfoStringObjectArr()
  {
    String message = "message %1$s";
    Throwable cause = new Exception();
    String parameter = "nothing";
    Logger logger = new Logger(PerfLoggerTest.class);
    logger.setForcedLevel(Level.INFO);
    PerfLogger instance = new PerfLogger(logger);
    assertNotNull(instance, "value is null");

    instance.info(message);
    instance.info(message, cause);
    instance.info(message, parameter);
    instance.debug(message, cause, parameter);
    instance.debug(message, cause, parameter, "");

    instance = new PerfLogger(logger);
    logger.setForcedLevel(Level.DEBUG);
    instance.info(message, parameter);
    instance.debug(message, cause, parameter);
    instance.debug(message, cause, parameter, "");
  }

  /**
   * Test of warn method, of class PerfLogger.
   */
  @Test
  public final void testWarnStringObjectArr()
  {
    String message = "message %1$s";
    Throwable cause = new Exception();
    String parameter = "nothing";
    Logger logger = new Logger(PerfLoggerTest.class);
    logger.setForcedLevel(Level.WARN);
    PerfLogger instance = new PerfLogger(logger);
    assertNotNull(instance, "value is null");

    instance.warn(message);
    instance.warn(message, cause);
    instance.warn(message, parameter);
    instance.debug(message, cause, parameter);
    instance.debug(message, cause, parameter, "");

    instance = new PerfLogger(logger);
    logger.setForcedLevel(Level.INFO);
    instance.warn(message, parameter);
    instance.debug(message, cause, parameter);
    instance.debug(message, cause, parameter, "");
  }

  /**
   * Test of error method, of class PerfLogger.
   */
  @Test
  public final void testErrorStringObjectArr()
  {
    String message = "message %1$s";
    Throwable cause = new Exception();
    String parameter = "nothing";
    Logger logger = new Logger(PerfLoggerTest.class);
    logger.setForcedLevel(Level.ERROR);
    PerfLogger instance = new PerfLogger(logger);
    assertNotNull(instance, "value is null");

    instance.error(message);
    instance.error(message, cause);
    instance.error(message, parameter);
    instance.debug(message, cause, parameter);
    instance.debug(message, cause, parameter, "");

    instance = new PerfLogger(logger);
    logger.setForcedLevel(Level.WARN);
    instance.error(message, parameter);
    instance.debug(message, cause, parameter);
    instance.debug(message, cause, parameter, "");
  }
}
