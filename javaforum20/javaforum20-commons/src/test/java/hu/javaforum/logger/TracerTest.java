/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 * Test of the Tracer class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-06-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class TracerTest
{

  /**
   * The default constructor.
   */
  public TracerTest()
  {
    super();
  }

  /**
   * Test of doLog method, of class Tracer.
   */
  @Test
  public final void testDoLogLevelString()
  {
    String message = "testDoLog_Level_String_DEBUG";
    Tracer instance = new Tracer(TracerTest.class);
    assertNotNull(instance, "value is null");
    instance.doLog(Level.DEBUG, message);

    message = "testDoLog_Level_String_INFO";
    instance = new Tracer(TracerTest.class.getName());
    assertNotNull(instance, "value is null");
    instance.doLog(Level.INFO, message);

    message = "testDoLog_Level_String_WARN";
    instance = new Tracer(TracerTest.class);
    assertNotNull(instance, "value is null");
    instance.doLog(Level.WARN, message);

    message = "testDoLog_Level_String_ERROR";
    instance = new Tracer(TracerTest.class.getName());
    assertNotNull(instance, "value is null");
    instance.doLog(Level.ERROR, message);

    message = "testDoLog_Level_String_TRACE";
    instance = new Tracer(TracerTest.class);
    assertNotNull(instance, "value is null");
    instance.doLog(Level.TRACE, message);

    message = "testDoLog_Level_String_null";
    instance = new Tracer(TracerTest.class.getName());
    assertNotNull(instance, "value is null");
    instance.doLog(null, message);
  }

  /**
   * Test of doLog method, of class Tracer.
   */
  @Test
  public final void testDoLogLevelStringThrowable()
  {
    String message = "testDoLog_Level_String_Throwable_DEBUG";
    Tracer instance = new Tracer(TracerTest.class);
    assertNotNull(instance, "value is null");
    instance.doLog(Level.DEBUG, message, null);

    message = "testDoLog_Level_String_Throwable_INFO";
    instance = new Tracer(TracerTest.class.getName());
    assertNotNull(instance, "value is null");
    instance.doLog(Level.INFO, message, null);

    message = "testDoLog_Level_String_Throwable_WARN";
    instance = new Tracer(TracerTest.class);
    assertNotNull(instance, "value is null");
    instance.doLog(Level.WARN, message, null);

    message = "testDoLog_Level_String_Throwable_ERROR";
    instance = new Tracer(TracerTest.class.getName());
    assertNotNull(instance, "value is null");
    instance.doLog(Level.ERROR, message, null);

    message = "testDoLog_Level_String_Throwable_TRACE";
    instance = new Tracer(TracerTest.class);
    assertNotNull(instance, "value is null");
    instance.doLog(Level.TRACE, message, null);

    message = "testDoLog_Level_String_Throwable_null";
    instance = new Tracer(TracerTest.class.getName());
    assertNotNull(instance, "value is null");
    instance.doLog(null, message, null);
  }

  /**
   * Test of isLevel method, of class Tracer.
   */
  @Test
  public final void testIsLevel()
  {
    Tracer instance = new Tracer(TracerTest.class);
    assertNotNull(instance, "value is null");

    instance.isLevel(Level.DEBUG);
    instance.isLevel(Level.INFO);
    instance.isLevel(Level.WARN);
    instance.isLevel(Level.ERROR);
    instance.isLevel(Level.TRACE);
    instance.isLevel(null);
  }
}
