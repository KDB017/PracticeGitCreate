import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import bean.StuDTO;

@WebServlet("/showname")
public class ShowNameServlet extends HttpServlet
{
    public  void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        StuDAO sdao=new StuDAO();
        StuDTO sdto=sdao.select();
        req.setAttribute("sdto",sdto);
        RequestDispatcher rd=req.getRequestDispatcher("/showname.jsp");
        rd.forward(req,res);
            
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        doPost(req,res);
    }
}
