package Response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.HelloServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Response1")
public class ResponseDemo1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取user-agent
        String userAgent = request.getHeader("user-agent");
        //out.println("0");
        if (userAgent != null) {
            if (userAgent.contains("Windows") || userAgent.contains("Linux")) {
                response.setStatus(302);
                //out.println("1");
                request.setAttribute("msg","PC");
                request.getRequestDispatcher("/Demo").forward(request,response);
                //response.sendRedirect("/Request1");
            } else if (userAgent.contains("AppleWebKit") && !userAgent.contains("Windows")) {
                //out.println("2");
                request.setAttribute("msg","IOS");
                request.getRequestDispatcher("/Demo").forward(request,response);
                //response.sendRedirect("/Request2");

            } else if (userAgent.contains("Android") && userAgent.contains("Linux")) {
                //out.println("3");
                request.setAttribute("msg","Android");
                request.getRequestDispatcher("/Demo").forward(request,response);
                //response.sendRedirect("/Request1");
            } else out.println("0");
        }
    }
}