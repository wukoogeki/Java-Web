package Response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

@WebServlet("/loginForm")
public class loginPost extends HttpServlet {
    private String name="admin";
    private String password="12345678";
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String inputCaptcha =request.getParameter("captcha");
        HttpSession session = request.getSession();
        String captcha= (String) session.getAttribute("captcha");
        String username =new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        String pass =new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        //out.println(username+" "+pass+" "+inputCaptcha+" "+captcha);
        if (captcha.equalsIgnoreCase(inputCaptcha)){
            if (name.equals(username) && password.equals(pass)){
                out.println("success");
            }else out.println("name or password error");
        }else out.println("captcha error");
    }
}
