package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nastiadanchenko
 *
 */
public class SignUpServlet extends HttpServlet {

    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    //sign up
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        //check if login is available
        UserProfile profile = accountService.getUserByLogin(login);
        if (profile != null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("This login is already taken, please choose another");
            return;
        }

        UserProfile newProfile = new UserProfile(login, pass, login);
        accountService.addNewUser(newProfile);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Successful registration!");
    }

}
