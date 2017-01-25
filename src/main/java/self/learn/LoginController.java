package self.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import service.RedisServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cq on 2017/1/24.
 */
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    final Jedis jedis = RedisServer.getJedis();


    public Map<String,String> userLogin(String userName, String password) {

        Map<String, String> loginErrorResult = new HashMap<>();
        if (userName.equalsIgnoreCase("tom") &&
                password.equalsIgnoreCase("jerry")) {
            logger.info("登录成功");
        }
        else {
            logger.error("登录失败");
            loginErrorResult.put("loginResult", "用户名或者密码失败");

        }

        return loginErrorResult;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userNmae = req.getParameter("userNmae");
        String password = req.getParameter("password");

        Map<String, String> loginErrorResult = userLogin(userNmae, password);


        if (loginErrorResult.size()==0) {
            req.setAttribute("userName",userNmae);
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        }else {
            req.setAttribute("errorMap",loginErrorResult);
            req.getRequestDispatcher("/").forward(req, resp);
        }

    }
}
