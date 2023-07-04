import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/register3")
public class RegisterServlet3 extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        req.setCharacterEncoding("utf-8");
        String age=req.getParameter("age");
        if(age.equals("child"))
        {
            age="18歳未満";

        }else
        {
            age="18歳以上";
        }
        req.setAttribute("age",age);

        String langs="";
        String[] lang=req.getParameterValues("lang");
        for(String langData:lang)
        {
            langs=langs+langData+" ";
        }
        req.setAttribute("langs",langs);
        RequestDispatcher rd=req.getRequestDispatcher("/register3.jsp");
        rd.forward(req,res);


    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        doPost(req,res);
    }
}