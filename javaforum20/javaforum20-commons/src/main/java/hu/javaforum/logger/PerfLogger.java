/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

/**
 * Logs the execution times with the messages and provides formatted prints
 * with java.util.Formatter syntax, it is based on the PerfLoggerEngine class.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-03-20)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * JFPORTAL-69 (2009-09-02)
 * JFPORTAL-68 (2009-07-25)
 * Refactoring (2009-06-12)
 * The first implementation (2008-05-03)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public final class PerfLogger extends PerfLoggerEngine
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The constructor stores the logger instance of the caller class.
   *
   * @param logger The logger instance
   */
  public PerfLogger(final Logger logger)
  {
    super(logger);
  }

  /**
   * Logs simple message in DEBUG level.
   *
   * @param message The message
   * @param args The arguments
   */
  public void debug(final String message, final Object... args)
  {
    formatMessage(Level.DEBUG, message, args);
  }

  /**
   * Logs simple message in INFO level.
   *
   * @param message The message
   * @param args The arguments
   */
  public void info(final String message, final Object... args)
  {
    formatMessage(Level.INFO, message, args);
  }

  /**
   * Logs simple message in WARN level.
   *
   * @param message The message
   * @param args The arguments
   */
  public void warn(final String message, final Object... args)
  {
    formatMessage(Level.WARN, message, args);
  }

  /**
   * Logs simple message in ERROR level.
   *
   * @param message The message
   * @param args The arguments
   */
  public void error(final String message, final Object... args)
  {
    formatMessage(Level.ERROR, message, args);
  }

  /**
   * Formats a message, uses the args array.
   *
   * @param level The logging level
   * @param message The message
   * @param args The argumentums
   */
  private void formatMessage(final Level level, final String message, final Object[] args)
  {
    if (isLevel(level))
    {
      if (args.length > 0)
      {
        if (args[0] instanceof Throwable)
        {
          Throwable throwable = (Throwable) args[0];
          Object[] copyOfArgs = new Object[args.length - 1];
          if (args.length > 1)
          {
            System.arraycopy(args, 1, copyOfArgs, 0, args.length - 1);
            this.doLog(level, PerfLogger.format(message, copyOfArgs),
                    null, throwable);
          } else
          {
            this.doLog(level, message, null, throwable);
          }
        } else
        {
          this.doLog(level, PerfLogger.format(message, args), null, null);
        }
      } else
      {
        this.doLog(level, message, null, null);
      }
    }
  }
}
