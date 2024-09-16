package Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.HelloServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/Request2")
public class RequestDmeo2 extends HelloServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取user-agent
        String userAgent = request.getHeader("user-agent");

        // 判断浏览器类型
        if (userAgent != null) {
            if (userAgent.contains("Chrome")) {
                out.println("浏览器是 Chrome");
            } else if (userAgent.contains("Firefox")) {
                out.println("浏览器是 Firefox");
            } else if (userAgent.contains("Safari") && !userAgent.contains("Chrome")) {
                // 注意：Chrome也包含Safari的字符串，所以要排除Chrome
                out.println("浏览器是 Safari");
            } else if (userAgent.contains("MSIE") || userAgent.contains("Trident/7.0")) {
                // MSIE 用于较旧的IE版本，Trident/7.0可能用于IE11
                out.println("浏览器是 Internet Explorer");
            } else if (userAgent.contains("Edge")) {
                out.println("浏览器是 Microsoft Edge");
            } else {
                out.println("无法识别的浏览器，user-agent: " + userAgent);
            }
        } else {
            out.println("user-agent为空");
        }
        //获取请求头信息
        /*Enumeration<String> headerNames = request.getHeaderNames();
        //使用循环遍历请求头，并通过getHeader()方法获取一个指定名称的头字段
        while (headerNames.hasMoreElements()){
            String headerName = (String) headerNames.nextElement();
            if (headerName.equals("user-agent")){

            }
            out.println(headerName + " : " + request.getHeader(headerName) + "<br/>");
        */
    }
}
