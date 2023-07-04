import java.sql.*;
import bean.*;
public class EditStudentDAO extends Object
{
    private final String URL = "jdbc:mysql://localhost/sampledb";
    private final String USER="root";
    private final String PASS ="GhiiJl14jgd";
    private Connection con=null;

    public void connect()
    {
        try{
            // DBに接続
            con=DriverManager.getConnection(URL,USER,PASS);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return;
    }

     public EditStudentDTO select()
     {
        Statement stmt=null;
        ResultSet rs=null;
        EditStudentDTO sdto=new EditStudentDTO();
        String sql="SELECT * FROM student";
        try{
            connect();
            // ステートメント生成
            stmt=con.createStatement();
            // SQL実行
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                EditStudentBean sb=new EditStudentBean();
                sb.setNo(rs.getInt("no"));
                sb.setName(rs.getString("name"));
                sb.setScore(rs.getInt("score"));
                sdto.add(sb);

            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                // リソースを解放
                if(rs!=null)
                {
                    rs.close();
                }
                if(stmt!=null)
                {
                    stmt.close();
                }
             } catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        disconnect();
        return sdto;
     }

     public void disconnect()
     {
        try
        {
            if(con!=null)
            {
                con.close();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
     }

     public int insert(int no,String name,int score)
     {
        String sql="INSERT INTO student VALUES("+no+",'"+name+"',"+score+")";
        return executeSql(sql);
     }

     public int update(int no,String name,int score)
     {
        String sql="UPDATE student SET no="+no+",name='"+name+"',score="+score+" WHERE no="+no;
        return executeSql(sql);
     }

     public int delete(int no)
     {
        String sql="DELETE FROM student WHERE no="+no;
        return executeSql(sql);
     }

     public int executeSql(String sql)
     {
        Statement stmt=null;
        int result=0;
        try{
            connect();
            // ステートメント生成
            stmt=con.createStatement();
            // SQL実行
            result=stmt.executeUpdate(sql);
            
        } catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                // リソースを解放
                if(stmt!=null)
                {
                    stmt.close();
                }
             } catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        disconnect();
        return result;

     }
}