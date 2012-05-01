/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.logger;

/**
 * Abstract class for common logging.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-05-01)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class AbstractLogger
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * The name of the class.
   */
  private final String className;
  /**
   * The forced level.
   */
  private Level forcedLevel;
  /**
   * The SLF4J instance.
   */
  private transient org.slf4j.Logger logger = null;

  /**
   * The constructor creates an instance with the class name and the prefix.
   *
   * @param prefix The name of the prefix
   * @param cls The class
   */
  protected AbstractLogger(final String prefix, final Class cls)
  {
    if (cls == null)
    {
      throw new IllegalArgumentException("cls is null");
    }

    this.className = cls.getName();

    if (prefix == null)
    {
      this.logger = org.slf4j.LoggerFactory.getLogger(this.getClassName());
    } else
    {
      this.logger = org.slf4j.LoggerFactory.getLogger(prefix + "." + this.getClassName());
    }
  }

  /**
   * The constructor creates an instance with the given name and the prefix.
   *
   * @param prefix The name of the prefix
   * @param className The name of the class
   */
  protected AbstractLogger(final String prefix, final String className)
  {
    if (className == null)
    {
      throw new IllegalArgumentException("the className parameter is null");
    }

    this.className = className;

    if (prefix == null)
    {
      this.logger = org.slf4j.LoggerFactory.getLogger(this.getClassName());
    } else
    {
      this.logger = org.slf4j.LoggerFactory.getLogger(prefix + "." + this.getClassName());
    }
  }

  /**
   * Returns with the name of the class.
   *
   * @return The name of the class
   */
  protected final String getClassName()
  {
    return className;
  }

  /**
   * Sets the forced level.
   *
   * @param forcedLevel The forced level
   */
  public final void setForcedLevel(final Level forcedLevel)
  {
    this.forcedLevel = forcedLevel;
  }

  /**
   * Does a log entry.
   *
   * @param level The level of the entry
   * @param message The message
   */
  protected final void doLog(final Level level, final String message)
  {
    if (level == null)
    {
      this.logger.trace(message);
    } else
    {
      switch (level)
      {
        case DEBUG:
          this.logger.debug(message);
          break;
        case INFO:
          this.logger.info(message);
          break;
        case WARN:
          this.logger.warn(message);
          break;
        case ERROR:
          this.logger.error(message);
          break;
        default:
          this.logger.trace(message);
      }
    }
  }

  /**
   * Does a log entry with throwable.
   *
   * @param level The level of the entry
   * @param message The message
   * @param cause The cause
   */
  protected final void doLog(final Level level, final String message, final Throwable cause)
  {
    if (level == null)
    {
      this.logger.trace(message, cause);
    } else
    {
      switch (level)
      {
        case DEBUG:
          this.logger.debug(message, cause);
          break;
        case INFO:
          this.logger.info(message, cause);
          break;
        case WARN:
          this.logger.warn(message, cause);
          break;
        case ERROR:
          this.logger.error(message, cause);
          break;
        default:
          this.logger.trace(message, cause);
      }
    }
  }

  /**
   * Returns with true, if the level is enabled to write a log.
   *
   * @param level The level
   * @return True, if the level is enabled
   */
  protected final boolean isLevel(final Level level)
  {
    if (this.forcedLevel != null)
    {
      return forcedLevel.compareTo(level) <= 0;
    }

    if (level == null)
    {
      return this.logger.isTraceEnabled();
    }

    switch (level)
    {
      case DEBUG:
        return this.logger.isDebugEnabled();
      case INFO:
        return this.logger.isInfoEnabled();
      case WARN:
        return this.logger.isWarnEnabled();
      case ERROR:
        return this.logger.isErrorEnabled();
      default:
        return this.logger.isTraceEnabled();
    }
  }
}
