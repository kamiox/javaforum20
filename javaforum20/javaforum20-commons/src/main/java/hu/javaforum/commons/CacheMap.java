/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import hu.javaforum.annotations.PrintField;
import hu.javaforum.logger.Logger;
import hu.javaforum.logger.PerfLogger;
import hu.javaforum.logger.PerfTracer;
import hu.javaforum.logger.Tracer;
import hu.javaforum.services.CommonBean;
import java.util.ArrayList;
import java.util.List;

/**
 * The CacheMap provides a simple cache layer in the JVM, it is not clustered
 * (or distributed) cache. The cache stores key-value pairs with lifetime.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * JFPORTAL-76 (2009-08-15)
 * JFPORTAL-74 (2009-07-26)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class CacheMap extends CommonBean
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * Default cache size.
   */
  private static final int DEFAULT_SIZE = 16;
  /**
   * One billion constant (millisecond multiplier).
   */
  private static final long MS_MULTIPLIER = 1000000L;
  /**
   * Default time to live value.
   */
  private static final long DEFAULT_TTL = 60L;
  /**
   * The static trace logger instance.
   */
  private static final Logger LOGGER = new Logger(CacheMap.class);
  /**
   * The static trace logger instance.
   */
  private static final Tracer TRACER = new Tracer(CacheMap.class);
  /**
   * The cache container.
   */
  @PrintField(maximumItemDump = Integer.MAX_VALUE)
  private final List<CacheEntry> container = new ArrayList<CacheEntry>();
  /**
   * The time-to-live value of this cache instance.
   */
  @PrintField
  private Long timeToLive;
  /**
   * The maximum size of the cache.
   */
  @PrintField
  private Integer size;

  /**
   * Creates a new cache instance.
   *
   * @param timeToLive Object lifetime in milliseconds
   * @param size The maximum size of the cache
   */
  public CacheMap(final Integer timeToLive, final Integer size)
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    tracer.entry();

    try
    {
      PerfLogger logger = new PerfLogger(LOGGER);

      if (timeToLive == null)
      {
        logger.debug("The timeToLive parameter is null, the value is defaulted to $1%d milliseconds", DEFAULT_TTL);
        this.timeToLive = DEFAULT_TTL * MS_MULTIPLIER;
      } else
      {
        this.timeToLive = timeToLive * MS_MULTIPLIER;
      }

      if (size == null)
      {
        logger.debug("The size parameter is null, the value is defaulted to $1%d items", DEFAULT_SIZE);
        this.size = DEFAULT_SIZE;
      } else
      {
        this.size = size;
      }
    } finally
    {
      tracer.exit();
    }
  }

  /**
   * Puts the object into the cache with the key. If the key already
   * exists in the cache, the old value is replaced with the new one.
   *
   * @param key The key
   * @param object The object
   */
  public final void put(final Object key, final Object object)
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    tracer.entry();

    try
    {
      PerfLogger logger = new PerfLogger(LOGGER);
      logger.debug("put('%1$s', '%2$s')", key, object);

      synchronized (this)
      {
        if (key != null && object != null)
        {
          CacheEntry element = null;
          for (CacheEntry entry : this.container)
          {
            if (key.equals(entry.getKey()))
            {
              element = entry;
              break;
            }
          }

          if (element == null)
          {
            if (this.container.size() >= this.size)
            {
              this.container.remove(0);
            }

            element = new CacheEntry(key, object);
            this.container.add(element);
          } else
          {
            element.setContent(object);
            this.container.remove(element);
            this.container.add(element);
          }
        }
      }
    } finally
    {
      tracer.exit();
    }
  }

  /**
   * Gets object from cache, if the key not found in the cache, this method
   * returns with null.
   *
   * @param key The key
   * @return The object
   */
  public final Object get(final Object key)
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    tracer.entry();

    try
    {
      PerfLogger logger = new PerfLogger(LOGGER);
      logger.debug("get('%1$s')", key);

      if (key != null)
      {
        CacheEntry element = null;
        for (CacheEntry entry : this.container)
        {
          if (key.equals(entry.getKey()))
          {
            element = entry;
            break;
          }
        }

        if (element != null)
        {
          if (element.getCreated() + this.timeToLive < System.nanoTime())
          {
            this.container.remove(element);
          }

          return element.getContent();
        }
      }

      return null;
    } finally
    {
      tracer.exit();
    }
  }
}
