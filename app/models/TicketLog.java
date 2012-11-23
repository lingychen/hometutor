/**
 * 
 */
package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.format.Formats;
import play.db.ebean.Model;

/**
 * @author David
 * 家教登记单处理记录
 */
@Entity
public class TicketLog extends Model {

	@Id
	public String id;
	
	@ManyToOne
	public Ticket ticket;
	
	@ManyToOne
	public Tutor tutor;
	
	public String action;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date actionDate;
	
	public String remark;
}
