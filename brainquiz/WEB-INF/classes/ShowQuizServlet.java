import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import bean.BrainTestDTO;
/*
 *  javaのサーブレットです。
 *  htmlの入力を受け取リ、処理をした後jspに任せます。
 *  このプログラムではDBに登録されている問題文を全て
 *  取得する処理をします。
 *
 */

@WebServlet("/settingShow")
public class ShowQuizServlet extends HttpServlet {
    /*
     * htmlからの入力を受け取り、jspに処理結果を返す。
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // 表示したいメッセージ
        String msg = "すべての問題を表示します";
        // エンコーディング形式の指定
        req.setCharacterEncoding("utf-8");

        //  全ての問題文をデータベースから取ってくる
        BrainTest bdao=new BrainTest();
        BrainTestDTO bdto=bdao.select();

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

        RequestDispatcher rd = req.getRequestDispatcher("/BrainShowSetting.jsp");
        rd.forward(req, res);

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req, res);
    }
}
