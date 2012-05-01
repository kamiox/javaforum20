/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.logger.Logger;
import hu.javaforum.logger.PerfLogger;
import hu.javaforum.logger.PerfTracer;
import hu.javaforum.logger.Tracer;
import hu.javaforum.services.test.ComplexClass;
import hu.javaforum.services.test.EJBBean;
import hu.javaforum.services.test.EJBBeanRemote;
import java.io.File;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;
import static org.testng.Assert.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Test of the ServiceLocator class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-07-06)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class ServiceLocatorTest
{

  /**
   * The static instance of the logger.
   */
  private static final Logger LOGGER = new Logger(ServiceLocatorTest.class);
  /**
   * The static trace logger instance.
   */
  private static final Tracer TRACER = new Tracer(ServiceLocatorTest.class);
  /**
   * The glassfish instance.
   */
  private static GlassFish glassfish;

  /**
   * Sets up the embedded EJB container.
   */
  public ServiceLocatorTest()
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    tracer.entry();

    try
    {
      PerfLogger logger = new PerfLogger(LOGGER);
      logger.debug("Do nothing... :)");
    } finally
    {
      tracer.exit();
    }
  }

  /**
   * Sets up and starts the embedded EJB container.
   */
  @BeforeSuite
  public static void setupAndStart()
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    PerfLogger logger = new PerfLogger(LOGGER);
    tracer.entry();

    try
    {
      GlassFishProperties glassfishProperties = new GlassFishProperties();
      glassfishProperties.setPort("http-listener", 18080);
      glassfishProperties.setPort("https-listener", 18181);
      glassfish = GlassFishRuntime.bootstrap().newGlassFish(glassfishProperties);
      glassfish.start();

      ScatteredArchive archive = new ScatteredArchive("simple", ScatteredArchive.Type.WAR);
      archive.addClassPath(new File("target" + File.separator + "test-classes"));
      archive.addClassPath(new File("target" + File.separator + "classes"));
      archive.addMetadata(new File("src" + File.separator + "test" + File.separator
              + "resources" + File.separator + "web.xml"));

      glassfish.getDeployer().deploy(archive.toURI(), "--name=simple", "--contextroot=simple", "--force=true");
    } catch (Exception except)
    {
      logger.error(except.getMessage(), except);
    } finally
    {
      tracer.exit();
    }
  }

  /**
   * Undeploys the application and stops the server.
   */
  @AfterSuite
  public static void stopServer()
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    PerfLogger logger = new PerfLogger(LOGGER);
    tracer.entry();

    try
    {

      if (glassfish != null)
      {
        glassfish.getDeployer().undeploy("simple", "--droptables=true", "--cascade=true");
        glassfish.stop();
        glassfish.dispose();
      }
    } catch (Throwable except)
    {
      logger.error(except.getMessage());
    } finally
    {
      tracer.exit();
    }
  }

  /**
   * Test of locate method, of class ServiceLocator.
   *
   * @throws Exception Exception
   */
  @Test
  public final void testLocateClass() throws Exception
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    PerfLogger logger = new PerfLogger(LOGGER);
    tracer.entry();

    try
    {
      EJBBeanRemote result = ServiceLocator.locate(EJBBeanRemote.class);
      assertNotNull(result, "value is null");
      assertEquals(result.echo("result"), "result", "values are not equal");
    } catch (Exception except)
    {
      logger.error(except.getMessage(), except);
      fail("illegal state");
    } finally
    {
      tracer.exit();
    }
  }

  /**
   * Test of locate method, of class ServiceLocator.
   *
   * @throws Exception Exception
   */
  @Test
  public final void testLocateClassClass() throws Exception
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    PerfLogger logger = new PerfLogger(LOGGER);
    tracer.entry();

    try
    {
      try
      {
        EJBBeanRemote result = ServiceLocator.locate(EJBBeanRemote.class, EJBBeanRemote.class);
        assertNotNull(result, "value is null");
        assertEquals(result.echo("result"), "result", "values are not equal");
      } catch (Exception except)
      {
        logger.error(except.getMessage(), except);
        fail("illegal state");
      }

      try
      {
        EJBBeanRemote result = ServiceLocator.locate(EJBBean.class, EJBBeanRemote.class);
        assertNotNull(result, "value is null");
        assertEquals(result.echo("result"), "result", "values are not null");
      } catch (Exception except)
      {
        logger.error(except.getMessage(), except);
        fail("illegal state");
      }

      try
      {
        ServiceLocator.locate(EJBBean.class, ComplexClass.class);
        fail("illegal state");
      } catch (Exception except)
      {
        logger.error(except.getMessage(), except);
      }
    } finally
    {
      tracer.exit();
    }
  }
}
