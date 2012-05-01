/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.logger.Logger;
import hu.javaforum.logger.PerfLogger;
import hu.javaforum.logger.PerfTracer;
import hu.javaforum.logger.Tracer;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Locates and loads the bean proxy which is specified in the parameter.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-03-23)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-29)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public final class ServiceLocator
{

  /**
   * The " lookup" constant.
   */
  public static final String CONSTANT_LOOKUP = " lookup";
  /**
   * The static instance (singleton pattern).
   */
  public static final ServiceLocator INSTANCE = new ServiceLocator();
  /**
   * The static instance of the logger.
   */
  private static final Logger LOGGER = new Logger(ServiceLocator.class);
  /**
   * The static trace logger instance.
   */
  private static final Tracer TRACER = new Tracer(ServiceLocator.class);
  /**
   * The default value of the factory of the initial context.
   */
  private static final String INITIAL_CONTEXT_FACTORY =
          System.getProperty("hu.javaforum.server.INITIAL_CONTEXT_FACTORY");
  /**
   * The default value of the provider URL.
   */
  private static final String PROVIDER_URL =
          System.getProperty("hu.javaforum.server.PROVIDER_URL");
  /**
   * The default value of the prefixes of the URL packages.
   */
  private static final String URL_PKG_PREFIXES =
          System.getProperty("hu.javaforum.server.URL_PKG_PREFIXES");

  /**
   * The private constructor, because all methods are static.
   */
  private ServiceLocator()
  {
    super();
  }

  /**
   * Locates and loads the bean proxy which is specified in the class from
   * the default context.
   *
   * @param <T> The generic class
   * @param local The class of the interface
   * @return The bean proxy
   * @throws NamingException Any error occurred
   */
  public static <T> T locate(final Class<T> local) throws NamingException
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    PerfLogger logger = new PerfLogger(LOGGER);
    tracer.entry();

    try
    {
      String className = local.getName();
      logger.debug("Before " + className + CONSTANT_LOOKUP);
      T instance = (T) new InitialContext().lookup(className);
      logger.debug("After " + className + CONSTANT_LOOKUP);

      return instance;
    } finally
    {
      tracer.exit();
    }
  }

  /**
   * Locates and loads the bean proxy which is specified in the parameters,
   * the local or the remote proxy will be load, it depends the configuration
   * of this ServiceLocator.
   *
   * @param <T> The generic class
   * @param local The class of the interface
   * @param remote The class of the interface
   * @return The bean proxy
   * @throws NamingException Any error occurred
   */
  public static <T> T locate(final Class<T> local, final Class remote) throws NamingException
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    PerfLogger logger = new PerfLogger(LOGGER);
    tracer.entry();

    try
    {
      try
      {
        return locate(local);
      } catch (Exception except)
      {
        logger.debug("Local interface not bound: %1$s", except.toString());
      }

      String className = remote.getName();
      logger.debug("Before " + className + CONSTANT_LOOKUP);

      String providerUrl = PROVIDER_URL;
      logger.debug("Default provider URL is %1$s", providerUrl);
      if (System.getProperty("providerUrl." + className) != null)
      {
        providerUrl = System.getProperty("providerUrl." + className);
        logger.debug("Got %1$s provider URL from property", providerUrl);
      }

      Properties properties = new Properties();
      properties.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
      properties.put(Context.URL_PKG_PREFIXES, URL_PKG_PREFIXES);
      properties.put(Context.PROVIDER_URL, providerUrl);
      InitialContext ic = new InitialContext(properties);

      T instance = (T) ic.lookup(className);
      logger.debug("After " + className + CONSTANT_LOOKUP);

      return instance;
    } finally
    {
      tracer.exit();
    }
  }
}
