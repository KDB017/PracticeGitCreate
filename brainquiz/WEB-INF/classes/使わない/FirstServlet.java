import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/first")

public class FirstServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out=res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>初めてのサーブレット</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>サーブレットをはじめよう</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
