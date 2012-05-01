/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

/**
 * Wrapper class to the internal trace logging implementation, it uses SFL4J.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-13)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public final class Tracer extends AbstractLogger
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constructor creates a trace logger from the class.
   *
   * @param cls The class
   */
  public Tracer(final Class cls)
  {
    super("TRACE", cls);
  }

  /**
   * The constructor creates a trace logger from the name of the class.
   *
   * @param className The name of the class
   */
  public Tracer(final String className)
  {
    super("TRACE", className);
  }
}
