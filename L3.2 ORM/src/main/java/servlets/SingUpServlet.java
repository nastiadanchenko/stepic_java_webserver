package servlets;

import accounts.AccountService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nastiadanchenko
 */

public class SingUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SingUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }
    // sing up
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        if (login == null || pass == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        accountService.addNewUser(login);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("Registered: " + login);
        resp.setStatus(HttpServletResponse.SC_OK);

    }
}
