import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
// import bean.BrainChoiceDTO;
// import bean.BrainTestDTO;
import bean.QuizBeanDTO;

/*
 *  javaのサーブレットです。
 *  データベースから全ての問題を取り出し、表示します
 *
 */

@WebServlet("/settingQuiz")
public class SettingServlet extends HttpServlet {
    /*
     *  
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        // クライアントに、なんの画面がを伝える
        String msg = "問題の一覧を表示します";

        req.setCharacterEncoding("utf-8");
       
        // 全ての問題をデータベースから取り出す
        QuizBeanDAO qdao=new QuizBeanDAO();
        QuizBeanDTO qdto=qdao.selectAllQuiz();

        
        req.setAttribute("msg", msg);
        req.setAttribute("qdto", qdto);

        RequestDispatcher rd = req.getRequestDispatcher("/jsp/SettingTest.jsp");
        rd.forward(req, res);

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req, res);
    }
}
