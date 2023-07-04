import java.sql.*;
import bean.*;

public class BrainTest extends Object {
    private final String URL = "jdbc:mysql://localhost/brainquizdb";
    private final String USER = "root";
    private final String PASS = "GhiiJl14jgd";
    private Connection con = null;

    public void connect() {
        try {
            // DBに接続
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public BrainTestDTO select() {
        Statement stmt = null;
        ResultSet rs = null;
        BrainTestDTO sdto = new BrainTestDTO();
        String sql = "SELECT * FROM questions";
        try {
            connect();
            // ステートメント生成
            stmt = con.createStatement();
            // SQL実行
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                BrainTestBean sb = new BrainTestBean();
                sb.setNo(rs.getInt("id"));
                sb.setName(rs.getString("question"));
                sdto.add(sb);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // リソースを解放
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        disconnect();
        return sdto;
    }

    public BrainTestDTO selectQuestion(int id) {
        Statement stmt = null;
        ResultSet rs = null;
        BrainTestDTO bdto = new BrainTestDTO();
        String sql = "SELECT * FROM questions WHERE id="+String.valueOf(id);
        try {
            connect();
            // ステートメント生成
            stmt = con.createStatement();
            // SQL実行
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                BrainTestBean sb = new BrainTestBean();
                sb.setNo(rs.getInt("id"));
                sb.setName(rs.getString("question"));
                bdto.add(sb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // リソースを解放
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        disconnect();
        return bdto;
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

    public  int insert(int id, String question) {
        String sql = "INSERT INTO questions VALUES ("
        + id + ", '" + question + "')";
        return executeSql(sql);
    }

    public int update(int id, String question) {
        String sql = "UPDATE questions SET id=" + id + ",question='" + question + "' WHERE id=" + id;
        return executeSql(sql);
    }

    public int delete(int id) {
        String sql = "DELETE FROM questions WHERE id=" + id;
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

    // データベースにあるクイズの問題数を答える
    public int questionNumInDB() {
        String sql = "SELECT COUNT(*) FROM questions";
        Statement stmt = null;
        ResultSet rs = null;
        int questionNum=0;
        try {
            connect();
            // ステートメント生成
            stmt = con.createStatement();
            // SQL実行
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                questionNum= rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // リソースを解放
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        disconnect();

        return questionNum;
    }


}