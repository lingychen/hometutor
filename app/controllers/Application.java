package controllers;

import java.util.*;

import play.mvc.*;
import play.data.*;
import play.*;

import views.html.*;

import models.*;

public class Application extends Controller {

    /**
     * 主页.
     */
    public static Result index() {
        return ok(index.render());
    }

    /**
     * 打开登录界面
     * @return
     */
    public static Result initLogin() {
        Form<Syslogin> loginForm = form(Syslogin.class);
        return ok(login.render(loginForm));
    }

    /**
     * 处理登录事件
     * @return
     */
    public static Result login() {
        Form<Syslogin> loginForm = form(Syslogin.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        }

        String email = loginForm.get().email;
        String password = loginForm.get().passwd;
        Syslogin syslogin = Syslogin.queryByEmail(email);
        // 用户不存在
        if (syslogin == null) {
            flash("errormsg", "msg.login.notexist");
            return badRequest(login.render(loginForm));
        } else if (syslogin.passwd.equals(password) == false) {
            flash("errormsg", "msg.login.wrongpasswd");
            return badRequest(login.render(loginForm));
        } else {
            return redirect(routes.Application.console());
        }
    }

    /**
     * 打开注册界面
     * @return
     */
    public static Result initReg() {
        Form<Syslogin> loginForm = form(Syslogin.class);
        return ok(register.render(loginForm));
    }

    /**
     * 处理注册事件
     * @return
     */
    public static Result register() {
        Form<Syslogin> loginForm = form(Syslogin.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(register.render(loginForm));
        }

        try {
            loginForm.get().save();
            flash("errormsg", "msg.login.register.completed");
            return redirect(routes.Application.console());
        }
        catch(Exception ex) {
            flash("errormsg", "msg.login.register.failed");
            return badRequest(register.render(loginForm));
        }
    }

    /**
     * 管理界面（教员或者系统管理员使用）
     * @return
     */
    public static Result console() {
        return TODO;
    }

    /**
     * 打开家教单界面
     * @return
     */
    public static Result initTicket() {
        return ok(ticket.render(form(Ticket.class)));
    }

    /**
     * 保存家教单
     * @return
     */
    public static Result saveTicket() {
        return TODO;
    }

    /**
     * 打开教员库界面
     * @return
     */
    public static Result initTutor() {
        return TODO;
    }

    /**
     * 查询教员
     * @return
     */
    public static Result queryTutor() {
        return TODO;
    }

}