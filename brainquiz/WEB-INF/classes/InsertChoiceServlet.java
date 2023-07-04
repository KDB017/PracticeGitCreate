import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import bean.BrainChoiceDTO;
import bean.BrainTestDTO;
/*
 *  javaのサーブレットです。
 *  htmlの入力を受け取り、jspでクイズを表示するための下準備を行います。
 *
 */

@WebServlet("/settingInsertChoice")
public class InsertChoiceServlet extends HttpServlet {
    /*
     * htmlからの入力を受け取り、jspに処理結果を返す。
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String msg = "選択肢を追加しました";
        req.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(req.getParameter("id"));
        String choice = req.getParameter("choice");
        Boolean is_answer=Boolean.valueOf(req.getParameter("is_answer"));
        int question_id=Integer.parseInt(req.getParameter("question_id"));
        BrainChoiceDAO bdao=new BrainChoiceDAO();
        int result=bdao.insert(id,choice,is_answer,question_id);
        BrainChoiceDTO bdto=bdao.select();

        req.setAttribute("msg", msg);
        req.setAttribute("bdto", bdto);

        RequestDispatcher rd = req.getRequestDispatcher("/BrainInsertChoiceSetting.jsp");
        rd.forward(req, res);

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req, res);
    }
}
