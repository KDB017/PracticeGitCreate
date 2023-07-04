import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import bean.BrainChoiceDTO;
/*
 *  javaのサーブレットです。
 *  htmlの入力を受け取り、jspでクイズを表示するための下準備を行います。
 *
 */

@WebServlet("/settingShowChoice")
public class ShowChoiceServlet extends HttpServlet {
    /*
     * htmlからの入力を受け取り、jspに処理結果を返す。
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String msg = "選択肢を表示します";
        req.setCharacterEncoding("utf-8");
        BrainChoiceDAO bdao=new BrainChoiceDAO();
        BrainChoiceDTO bdto=bdao.select();

        // BrainTest brainQuestionDAO = new BrainTest();
        // BrainChoiceDAO sdao = new BrainChoiceDAO();

        // int questionNumInDB = brainQuestionDAO.questionNumInDB();
        // Random random = new Random();
        // int selectedQID = random.nextInt(questionNumInDB) + 1;
        // BrainTestDTO questionDT = brainQuestionDAO.selectQuestion(selectedQID);
        // String question = questionDT.get(0).getName();
        // BrainChoiceDTO choices = sdao.getChoicesToQID(selectedQID);
        // if(btn.equals("追加"))
        // {
        // int no=Integer.parseInt(req.getParameter("no"));
        // String name=req.getParameter("name");
        // int score=Integer.parseInt(req.getParameter("score"));
        // sdao.insert(no, name, score);
        // msg="番号"+no+"の生徒を追加しました。";

        // }else if(btn.equals("修正"))
        // {
        // int no=Integer.parseInt(req.getParameter("no"));
        // String name=req.getParameter("name");
        // int score=Integer.parseInt(req.getParameter("score"));
        // sdao.update(no, name, score);
        // msg="番号"+no+"の生徒を修正しました。";

        // }else if(btn.equals("削除"))
        // {
        // int no=Integer.parseInt(req.getParameter("no"));
        // sdao.delete(no);
        // msg="番号"+no+"の生徒を削除しました。";

        // }
        // req.setAttribute("question", question);
        // req.setAttribute("choices", choices);
        req.setAttribute("msg", msg);
        req.setAttribute("bdto", bdto);

        RequestDispatcher rd = req.getRequestDispatcher("/BrainShowChoiceSetting.jsp");
        rd.forward(req, res);

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req, res);
    }
}
