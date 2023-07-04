import java.sql.*;
import bean.*;
public class StuDAO extends Object
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

     public StuDTO select()
     {
        Statement stmt=null;
        ResultSet rs=null;
        StuDTO sdto=new StuDTO();
        String sql="SELECT * FROM student";
        try{
            connect();
            // ステートメント生成
            stmt=con.createStatement();
            // SQL実行
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                StuBean sb=new StuBean();
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

}