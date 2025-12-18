package com.example.game;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/saveScore")
public class GameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        String score = req.getParameter("score");
        System.out.println("Score saved: " + score);
        res.getWriter().print("OK");
    }
}
