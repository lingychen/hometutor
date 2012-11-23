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

import com.avaje.ebean.Page;

/**
 * @author David
 * 教员基本信息表
 */
@Entity
public class Tutor extends Model {

	@Id
	public String id;

	@OneToOne
	public Syslogin syslogin;

	@Constraints.Required
	public String name;

	// M for man, F for woman
	public String gender;

	@Constraints.Required
	public String phone;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date birthday;

	public String homeTown;
	public String highSchool;
	public String college;
	public String diploma;
	public String major;
	public String occupation;
	public String employer;
	public String credential;
	public String workplace;
	public String houseplace;
	
	/// 家教信息描述
	// 自我评价
	public String selfAssessment;
	// 教授科目
	public String subjects;
	// 授课区域
	public String availableAreas;
	// 所获证书
	public String certificates;
	// 授课方式
	public String means;
	// 家教经验
	public String experiences;
	// 薪水要求
	public String salary;

	public static Finder<String, Tutor> find = new Finder<String, Tutor>(
			String.class, Tutor.class);

	public static Page<Tutor> page(int page, int pageSize, String tutorId,
			String tutorName) {
		return find.where().ilike("name", tutorName + "%").orderBy(
				"name asc").fetch("syslogin").findPagingList(pageSize)
				.getPage(page);
	}
}
