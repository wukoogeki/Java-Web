package Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Request1")
public class RequestDemo1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求行的相关信息
        out.println("getMethod:" + request.getMethod() + "<br/>");
        out.println("getQueryString:" + request.getQueryString() + "<br/>");
        out.println("getProtocol:" + request.getProtocol() + "<br/>");
        out.println("getContextPath" + request.getContextPath() + "<br/>");
        out.println("getPathInfo:" + request.getPathInfo() + "<br/>");
        out.println("getPathTranslated:" + request.getPathTranslated() + "<br/>");
        out.println("getServletPath:" + request.getServletPath() + "<br/>");
        out.println("getRemoteAddr:" + request.getRemoteAddr() + "<br/>");
        out.println("getRemoteHost:" + request.getRemoteHost() + "<br/>");
        out.println("getRemotePort:" + request.getRemotePort() + "<br/>");
        out.println("getLocalAddr:" + request.getLocalAddr() + "<br/>");
        out.println("getLocalName:" + request.getLocalName() + "<br/>");
        out.println("getLocalPort:" + request.getLocalPort() + "<br/>");
        out.println("getServerName:" + request.getServerName() + "<br/>");
        out.println("getServerPort:" + request.getServerPort() + "<br/>");
        out.println("getScheme:" + request.getScheme() + "<br/>");
        out.println("getRequestURL:" + request.getRequestURL() + "<br/>");
    }
}
