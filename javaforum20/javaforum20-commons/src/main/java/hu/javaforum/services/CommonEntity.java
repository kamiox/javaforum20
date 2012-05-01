/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.annotations.PrintField;
import hu.javaforum.services.exceptions.ServiceException;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 * The superclass of the entity's common fields.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * The first implementation (2011-02-09)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
@MappedSuperclass
public abstract class CommonEntity extends CommonBean
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * Created.
   */
  @Past
  @NotNull
  @PrintField
  private Date created;
  /**
   * Approved.
   */
  @PrintField
  private Date approved;
  /**
   * Expired.
   */
  @PrintField
  private Date expired;
  /**
   * Modified.
   */
  @Past
  @PrintField
  private Date modified;
  /**
   * Deleted.
   */
  @PrintField
  private Date deleted;

  /**
   * Gets the value of the 'created'.
   *
   * @return The value
   */
  @Column(name = "CREATED", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  public final Date getCreated()
  {
    return created == null ? null : new Date(created.getTime());
  }

  /**
   * Sets the value of the 'created'.
   *
   * @param created The value
   */
  public final void setCreated(final Date created)
  {
    this.created = created == null ? null : new Date(created.getTime());
  }

  /**
   * Gets the value of the 'approved'.
   *
   * @return The value
   */
  @Column(name = "APPROVED")
  @Temporal(TemporalType.TIMESTAMP)
  public final Date getApproved()
  {
    return approved == null ? null : new Date(approved.getTime());
  }

  /**
   * Sets the value of the 'approved'.
   *
   * @param approved The value
   */
  public final void setApproved(final Date approved)
  {
    this.approved = approved == null ? null : new Date(approved.getTime());
  }

  /**
   * Gets the value of the 'expired'.
   *
   * @return The value
   */
  @Column(name = "EXPIRED")
  @Temporal(TemporalType.TIMESTAMP)
  public final Date getExpired()
  {
    return expired == null ? null : new Date(expired.getTime());
  }

  /**
   * Sets the value of the 'expired'.
   *
   * @param expired The value
   */
  public final void setExpired(final Date expired)
  {
    this.expired = expired == null ? null : new Date(expired.getTime());
  }

  /**
   * Gets the value of the 'modified'.
   *
   * @return The value
   */
  @Column(name = "MODIFIED")
  @Temporal(TemporalType.TIMESTAMP)
  public final Date getModified()
  {
    return modified == null ? null : new Date(modified.getTime());
  }

  /**
   * Sets the value of the 'modified'.
   *
   * @param modified The value
   */
  public final void setModified(final Date modified)
  {
    this.modified = modified == null ? null : new Date(modified.getTime());
  }

  /**
   * Gets the value of the 'deleted'.
   *
   * @return The value
   */
  @Column(name = "DELETED")
  @Temporal(TemporalType.TIMESTAMP)
  public final Date getDeleted()
  {
    return deleted == null ? null : new Date(deleted.getTime());
  }

  /**
   * Sets the value of the 'deleted'.
   *
   * @param deleted The value
   */
  public final void setDeleted(final Date deleted)
  {
    this.deleted = deleted == null ? null : new Date(deleted.getTime());
  }

  /**
   * Validates the fields.
   *
   * @param create True, if the validate is called from create (or persist)
   *
   * @throws ServiceException Throws when error
   */
  public abstract void validate(final boolean create) throws ServiceException;
}
