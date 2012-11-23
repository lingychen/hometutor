/**
 * 
 */
package models;

/**
 * @author David
 * 系统常量
 */
public final class Status {
	
	// 登录(syslogin，也可以理解为用户)类型
	public static final String USER_ADMIN = "ADMIN";
	public static final String USER_TUTOR = "TUTOR";
	public static final String USER_STUDENT = "STUDENT";
	
	// 登录(syslogin，也可以理解为用户)状态
	public static final String STATUS_INIT = "INIT";
	public static final String STATUS_LIVE = "LIVE";
	public static final String STATUS_LOCK = "LOCK";
	public static final String STATUS_RESET = "RESET";
	
	// 家教登记单状态
	// 刚刚创建
	public static final String TICKET_INIT = "INIT";
	// 废弃该单
	public static final String TICKET_DISCARDED = "DISCARDED";
	// 已分派给某个教员
	public static final String TICKET_ASSIGNED = "ASSIGNED";
	// 教员接受该单
	public static final String TICKET_ACCEPTED = "ASSIGNED";
	// 教员拒绝该单
	public static final String TICKET_REJECTED = "REJECTED";
	// 教员完成家教
	public static final String TICKET_FINISHED = "FINISHED";
	// 该单成功归档
	public static final String TICKET_ARCHIVED = "ARCHIVED";

}
