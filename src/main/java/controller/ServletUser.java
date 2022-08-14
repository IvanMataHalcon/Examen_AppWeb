package controller;


import model.BeanUser;
import service.ServiceUser;
import utils.ResultAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletUser",
    urlPatterns = {
            "/get-users",
            "/get-user",
            "/add-user",
            "/create-user",
            "/delete-user",
            "/save-user"


    })

public class ServletUser extends HttpServlet {
    String action;
    Logger logger = Logger.getLogger("ServletUser");
    ServiceUser serviceUser = new ServiceUser();

    String urlRedirect = "/get-users";


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);

        switch (action) {
            case "/get-users":
                List<BeanUser> users = serviceUser.getAll();
                System.out.println(users.size());
                request.setAttribute("users", users);
                urlRedirect = "/views/index.jsp";
                break;
            case "/get-user":
                String id = request.getParameter("id");
                id = (id == null) ? "0":id;
                try{
                    BeanUser user = serviceUser.getUser(Integer.parseInt(id));
                    request.setAttribute("user",user);
                    urlRedirect = "/views/update.jsp";
                }catch (Exception e){
                    urlRedirect = "/get-users";
                }
                break;

            case "/create-user":
                urlRedirect = "/views/create.jsp";
                break;
            default:
                request.setAttribute("users", serviceUser.getAll());
                urlRedirect = "/get-users";
                break;

        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        action = request.getServletPath();
        switch (action) {
            case "/add-user":
                String username = request.getParameter("username");
                String curp = request.getParameter("curp");
                String birthday = request.getParameter("birthday");
                System.out.println(username);
                System.out.println(curp);
                System.out.println(birthday);
                BeanUser user = new BeanUser();
                user.setUsername(username);
                user.setCurp(curp);
                user.setBirthday(birthday);
                ResultAction result = serviceUser.save(user);
                urlRedirect = "/get-users?result=" +
                        result.isResult() + "&message=" +
                        URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result.getStatus();
                break;
            case "/save-user":
                String username2 = request.getParameter("username");
                String curp2 = request.getParameter("curp");
                String birthday2 = request.getParameter("birthday");
                BeanUser user2 = new BeanUser();
                user2.setUsername(username2);
                user2.setCurp(curp2);
                user2.setBirthday(birthday2);
                ResultAction result2 = serviceUser.save(user2);
                urlRedirect = "/get-users?result="+
                        result2.isResult()+"&message="+result2.getMessage()
                        +"&status="+result2.getStatus();
                break;
            case "/delete-user":
                String id = request.getParameter("id");
                System.out.println(id);
                ResultAction deleteResult = serviceUser.delete(id);
                urlRedirect = "/get-users?result="+
                        deleteResult.isResult()+"&message="+
                        URLEncoder.encode(deleteResult.getMessage(), StandardCharsets.UTF_8.name())
                        +"&status="+deleteResult.getStatus();
                break;
            default:
                urlRedirect = "/get-users";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
