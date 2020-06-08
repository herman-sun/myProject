import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroTest {
    public static void main(String[] args) {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        subject.getSession().setAttribute("hello", "wocao");
        System.out.println(subject.getSession().getAttribute("hello") + "欢迎你");

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("aaa","bbb");
        String uname = null;

        try {
            subject.login(usernamePasswordToken);
            System.out.println("登陆成功");
            uname = subject.getPrincipal().toString();
            System.out.println(subject.getPrincipal().toString() + "欢迎" + uname + "是否是master" + subject.hasRole("master") +
                    "是不是Watcher" + subject.hasRole("Watcher"));

        } catch (UnknownAccountException e) {
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
        }

        if (subject.isAuthenticated()) {
            System.out.println(uname + "master:control" + subject.isPermitted("master:control"));
            System.out.println(uname + "Watcher:control" + subject.isPermitted("Watcher:control"));
            System.out.println(uname + "sb:control" + subject.isPermitted("sb:control"));
        }
        System.out.println(subject.getSession().getAttribute("hello"));
        System.out.println(subject.getPrincipal().toString());
        subject.logout();
        System.out.println(subject.getSession().getAttribute("hello"));

        System.out.println(subject.getPrincipal().toString());
    }
}
