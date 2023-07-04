import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import bean.EditStudentDTO;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet
{
    public  void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        String msg="生徒全員の情報を表示します";
        req.setCharacterEncoding("utf-8");
        String btn=req.getParameter("btn");
        EditStudentDAO sdao=new EditStudentDAO();
        if(btn.equals("追加"))
        {
            int no=Integer.parseInt(req.getParameter("no"));
            String name=req.getParameter("name");
            int score=Integer.parseInt(req.getParameter("score"));
            sdao.insert(no, name, score);
            msg="番号"+no+"の生徒を追加しました。";

        }else if(btn.equals("修正"))
        {
            int no=Integer.parseInt(req.getParameter("no"));
            String name=req.getParameter("name");
            int score=Integer.parseInt(req.getParameter("score"));
            sdao.update(no, name, score);
            msg="番号"+no+"の生徒を修正しました。";

        }else if(btn.equals("削除"))
        {
            int no=Integer.parseInt(req.getParameter("no"));
            sdao.delete(no);
            msg="番号"+no+"の生徒を削除しました。";

        }
        EditStudentDTO sdto=sdao.select();
        req.setAttribute("sdto",sdto);
        req.setAttribute("msg",msg);
        RequestDispatcher rd=req.getRequestDispatcher("/editstudent.jsp");
        rd.forward(req,res);
            
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        doPost(req,res);
    }
}
