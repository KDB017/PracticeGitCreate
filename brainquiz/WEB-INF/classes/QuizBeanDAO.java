import java.sql.*;
import bean.BrainChoiceDTO;
import bean.BrainTestBean;
import bean.BrainTestDTO;
import bean.QuizBean;
import bean.QuizBeanDTO;


public class QuizBeanDAO extends Object {
    private final String URL = "jdbc:mysql://localhost/brainquizdb";
    private final String USER = "root";
    //private final String PASS = "";
    private Connection con = null;

    // データベースに接続
    public void connect() {
        try {
            // DBに接続
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    // データベースにある問題を全てとってくる
    public static BrainTestDTO selectAllQuestions()
    {
        BrainTest bdao=new BrainTest();
        return bdao.select();
    }

    // 全ての問題と選択肢とを紐づけた、クイズの形にしたデータを作る
    public QuizBeanDTO selectAllQuiz() {
        QuizBeanDTO qdto = new QuizBeanDTO();
        BrainTestDTO bdto=QuizBeanDAO.selectAllQuestions();

        for(int i=0;i<bdto.size();i++)
        {
            BrainTestBean btb= bdto.get(i);
            BrainChoiceDAO bcdao=new BrainChoiceDAO();
            
            QuizBean qb=new QuizBean();
            qb.setQuizQuestionBean(btb);
            qb.setQuizChoicesBeanDTO(bcdao.getChoicesToQID(btb.getNo()));
            qdto.add(qb);
        }
        
        return qdto;
    }

    public void disconnect() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(int id, String choice, Boolean is_answer, int question_id) {
        String sql = "INSERT INTO choices VALUES(" + id + ",'" + choice + "'," + is_answer + "," + question_id + ")";
        return executeSql(sql);
    }


    public int update(int id, String choice, Boolean is_answer, int questionID) {
        String sql = "UPDATE choices SET id=" + id + ",choise='" + choice + "',is_answer=" + is_answer + ",question_id="
                + questionID + " WHERE id=" + id;
        return executeSql(sql);
    }

    public int delete(int id) {
        String sql = "DELETE FROM choices WHERE id=" + id;
        return executeSql(sql);
    }

    public int executeSql(String sql) {
        Statement stmt = null;
        int result = 0;
        try {
            connect();
            // ステートメント生成
            stmt = con.createStatement();
            // SQL実行
            result = stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // リソースを解放
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        disconnect();
        return result;
    }
}