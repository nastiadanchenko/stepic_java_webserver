package servlets;

import accounts.AccountService;
import dbService.dataSets.UsersDataSet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nastiadanchenko
 */

public class SingInServlet extends HttpServlet {
    private final AccountService accountService;

    public SingInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    // sing in
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        if (login == null || pass == null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UsersDataSet profile = accountService.getUserByLogin(login);
        if (profile == null || !profile.getName().equals(login)) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Unauthorized");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("Authorized: "+profile.getName());
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
