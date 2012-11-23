/**
 * 
 */
package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * @author David
 * 家教登记单
 */
@Entity
public class Ticket extends Model {

	/**
     * 
     */
    private static final long serialVersionUID = -41748942147988960L;

    @Id
	public String id;

	@OneToOne
	public Tutor tutor;
	
	public Integer subjectId;
	public Integer gradeId;

	public String city;
	public String district;
	public String zone;

	@Constraints.Required
	public String contact;
	
	@Constraints.Required
	public String phone;
	
	public String email;
	public String comments;

	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date createDate;
	
	// 家教登记单来自这个ip地址
	public String ipAddress;
	
	// 家教登记单当前状态
	public String status;
	// 家教登记单下一步处理人
	public String nextDealer;
	
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date closeDate;

}
