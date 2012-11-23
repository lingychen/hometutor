/**
 * 
 */
package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.data.format.Formats;
import play.db.ebean.Model;

/**
 * @author David
 * 
 */
@Entity
public class Systemlog extends Model {

	@Id
	public String id;

	@OneToOne
	public Syslogin syslogin;
	
	public String action;

	@Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date actionDate;

	public String ipAddress;
	public String faultCode;
	public String faultDetail;
	
	// 参考事件
	public String reference;
}
