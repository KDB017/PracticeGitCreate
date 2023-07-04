import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;

@WebServlet("/session")
public class SessionServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        HttpSession session=req.getSession(true);
        ArrayList<String>booklist=(ArrayList<String>)session.getAttribute("cart");
        if(booklist==null)
        {
            booklist=new ArrayList<String>();
        }else
        {
        req.setCharacterEncoding("utf-8");
        String book=req.getParameter("book");
        booklist.add(book);
        }
        session.setAttribute("cart",booklist);
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out=res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>注文画面</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>商品を選択してください</h2>");
        out.println("<form action=\"/brainquiz/session\" method=\"post\">");
        out.println("<select name=\"book\" size=\"1\">");
        out.println("<option value=\"超絶わかるJava\">超絶わかるJava</option>");
        out.println("<option value=\"小学生から始めるJava\">小学生から始めるJava</option>");
        out.println("<option value=\"Olacle\">Oracle</option>");
        out.println("</select>");
        out.println("<input type=\"submit\" value=\"追加\" />");
        out.println("</form>");
        out.println("<h2>カートの中身</h2>");   
        
        for(String book:booklist)
        {
            out.println(book+"<p></p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        doPost(req,res);
    }
}