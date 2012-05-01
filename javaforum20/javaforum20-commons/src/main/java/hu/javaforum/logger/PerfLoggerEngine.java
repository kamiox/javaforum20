/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

import java.util.Formatter;

/**
 * The core component of the PerfLogger, this is the "engine". :)
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-02-13)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class PerfLoggerEngine
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * Base number of nanosecond to millisecond conversion.
   */
  private static final double NANO_TO_MILLISECOND = 1000000.0;
  /**
   * The instance of the logger.
   */
  private final AbstractLogger logger;
  /**
   * Gets the actual nanoTime value.
   */
  private final Long startTime = System.nanoTime();

  /**
   * The constructor stores the logger instance of the caller class.
   *
   * @param logger The logger instance
   */
  protected PerfLoggerEngine(final AbstractLogger logger)
  {
    this.logger = logger;
  }

  /**
   * Creates a performance log with execution time. Logs stack trace and
   * message in the specified log level.
   *
   * @param level The log level
   * @param message The message
   * @param additional The additional object to log
   * @param exception The exception
   */
  protected final void doLog(final Level level, final String message,
          final Object additional, final Throwable exception)
  {
    if (isLevel(level))
    {
      StackTraceElement pointOfCall = getPointOfCall(Thread.currentThread().getStackTrace());

      StringBuilder sb = new StringBuilder();
      sb.append(pointOfCall.getClassName());
      sb.append(".");
      sb.append(pointOfCall.getMethodName());
      sb.append("[");
      sb.append(pointOfCall.getLineNumber());
      sb.append("]: ");
      sb.append(message);
      sb.append(" (");
      sb.append(new Formatter().format("%.2f", this.getTime()));
      sb.append("ms)");

      if (additional != null)
      {
        sb.append("\n");
        sb.append(additional);
      }

      if (exception == null)
      {
        logger.doLog(level, sb.toString());
      } else
      {
        logger.doLog(level, sb.toString(), exception);
      }
    }
  }

  /**
   * Returns with the point of call in the stacktrace array.
   *
   * @param stackTraces Array of StackTraceElement instances
   * @return The point of call
   */
  protected final StackTraceElement getPointOfCall(final StackTraceElement[] stackTraces)
  {
    for (int traceOffset = 2; traceOffset < stackTraces.length; traceOffset++)
    {
      if (stackTraces[traceOffset].getClassName().startsWith("java.lang."))
      {
        continue;
      }

      if (!stackTraces[traceOffset].getClassName().startsWith("hu.javaforum.logger"))
      {
        return stackTraces[traceOffset];
      }
    }

    return stackTraces[0];
  }

  /**
   * Returns the elapsed time with xxx.xx precision.
   *
   * @return The elapsed time in milliseconds
   */
  protected final double getTime()
  {
    return getTime(this.startTime);
  }

  /**
   * Returns the elapsed time in millisecond.
   *
   * @param startTime The start time from System.nanoTime()
   * @return The elapsed time in milliseconds
   */
  protected static double getTime(final Long startTime)
  {
    if (startTime == null)
    {
      return 0.0d;
    }

    return ((double) System.nanoTime() - startTime) / NANO_TO_MILLISECOND;
  }

  /**
   * Returns true, if the logging level in the 'logger' parameter is equal or
   * grater than the 'level' parameter.
   *
   * @param level The level
   * @return True, if the level is greater of equal
   */
  public final boolean isLevel(final Level level)
  {
    return logger.isLevel(level);
  }

  /**
   * Formats the pattern with the specified arguments.
   *
   * @param pattern A standard format pattern
   * @param args An arguments
   * @return The formatted message
   */
  protected static String format(final String pattern, final Object... args)
  {
    return new Formatter().format(pattern, args).toString();
  }

  /**
   * Gets the cause of the exception. It is a recursive method!
   *
   * @param exception The exception
   * @return The cause
   */
  public static Exception getCause(final Exception exception)
  {
    return exception.getCause() == null ? exception : (Exception) exception.getCause();
  }
}
