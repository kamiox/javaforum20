/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

import hu.javaforum.services.CommonEntity;
import hu.javaforum.services.CommonRequest;
import hu.javaforum.services.CommonResponse;

/**
 * Logs the entry and exit events.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-03-20)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class PerfTracer extends PerfLoggerEngine
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constructor stores the logger instance of the caller class.
   *
   * @param tracer The tracer instance
   */
  public PerfTracer(final Tracer tracer)
  {
    super(tracer);
  }

  /**
   * Logs the entry in TRACE level.
   */
  public final void entry()
  {
    this.doLog(Level.TRACE, "Entry", null, null);
  }

  /**
   * Logs the entry in TRACE level.
   *
   * @param entity The entity
   */
  public final void entry(final CommonEntity entity)
  {
    this.doLog(Level.TRACE, "Entry", entity, null);
  }

  /**
   * Logs the entry in TRACE level.
   *
   * @param request The request
   */
  public final void entry(final CommonRequest request)
  {
    this.doLog(Level.TRACE, "Entry", request, null);
  }

  /**
   * Logs the exit in TRACE level.
   */
  public final void exit()
  {
    this.doLog(Level.TRACE, "Exit", null, null);
  }

  /**
   * Logs the exit in TRACE level.
   *
   * @param entity The entity
   */
  public final void exit(final CommonEntity entity)
  {
    this.doLog(Level.TRACE, "Exit", entity, null);
  }

  /**
   * Logs the exit in TRACE level.
   *
   * @param response The response
   */
  public final void exit(final CommonResponse response)
  {
    this.doLog(Level.TRACE, "Exit", response, null);
  }
}
