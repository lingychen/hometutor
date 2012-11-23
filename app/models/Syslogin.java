package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


/**
 * Syslogin entity managed by Ebean
 */
@Entity 
public class Syslogin extends Model {

	/**
     * 
     */
    private static final long serialVersionUID = 8358512642425327065L;

    @Id
    public String id;
    
    @Constraints.Required
    @Constraints.Email
    public String email;
    
    @Constraints.Required
    public String passwd;
    
    /**
     * A for administrator
     * <p>
     * T for tutor
     * <p>
     * S for student
     * <p>
     * values are defined in class <code>models.Status</code>
     */
    public String loginType;

    /**
     * values are defined in class <code>models.Status</code>
     */
    public String status;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date createDate;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date lastLogged;

    public String passwdHelper;
    
    /**
     * Generic query helper for entity Syslogins with id Long
     * TODO id到底是用long，还是用string呢？
     */
    public static Finder<Long,Syslogin> find = new Finder<Long,Syslogin>(Long.class, Syslogin.class);

    public static Map<String, String> options() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (Syslogin c : Syslogin.find.orderBy("email").findList()) {
            options.put(c.id.toString(), c.email);
        }
        return options;
    }

    /**
     * 根据email获取系统登录信息
     * @param email 不区分大小写
     * @return 查找不到时返回null
     */
    public static Syslogin queryByEmail(String email) {
        Syslogin login = null;
        List<Syslogin> logins = find.where().ieq("email", email).findList();
        if (logins != null && logins.size() > 0) {
            login = logins.get(0);
        }
        return login;
    }

}
