/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services.test;

/**
 * Test EJB interface for the ServiceLocator's tests.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * First implementation (2011-07-30)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public interface EJBBeanRemote
{

  /**
   * Simple echo-reply method.
   *
   * @param text The text
   * @return The text as echo
   */
  String echo(String text);
}
