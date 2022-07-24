package app.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("Method GET from TestServlet");

        HttpSession httpSession = req.getSession();

        writer.println("Session id: " + httpSession.getId());
        writer.println("Time creation: " + (new Date(httpSession.getCreationTime())));
        writer.close();

    }
}