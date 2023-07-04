import java.sql.*;
import bean.*;
public class BrainChoiceDAO extends Object
{
    //private final String URL = "jdbc:mysql://localhost/brainquizdb";
    //private final String USER="root";
    //private final String PASS ="";
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

     public BrainChoiceDTO select()
     {
        Statement stmt=null;
        ResultSet rs=null;
        BrainChoiceDTO sdto=new BrainChoiceDTO();
        String sql="SELECT * FROM choices";
        try{
            connect();
            // ステートメント生成
            stmt=con.createStatement();
            // SQL実行
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                BrainChoiceBean sb=new BrainChoiceBean();
                sb.setID(rs.getInt("id"));
                sb.setChoice(rs.getString("choise"));
                sb.setIsAnswer(rs.getBoolean("is_answer"));
                sb.setQuestionID(rs.getInt("question_id"));
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

    
      public int insert(int id,String choice,Boolean is_answer,int question_id)
     {
        String sql="INSERT INTO choices VALUES("+id+",'"+choice+"',"+is_answer+","+question_id+")";
         return executeSql(sql);
    }

    public BrainChoiceDTO getChoicesToQID(int id)
    {
        Statement stmt=null;
        ResultSet rs=null;
        BrainChoiceDTO bdto=new BrainChoiceDTO();
        String sql="SELECT * FROM choices WHERE question_id="+id;
        try{
            connect();
            // ステートメント生成
            stmt=con.createStatement();
            // SQL実行
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                BrainChoiceBean sb=new BrainChoiceBean();
                sb.setID(rs.getInt("id"));
                sb.setChoice(rs.getString("choise"));
                sb.setIsAnswer(rs.getBoolean("is_answer"));
                sb.setQuestionID(rs.getInt("question_id"));
                bdto.add(sb);

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
        return bdto;
    }

     public int update(int id,String choice,Boolean is_answer,int questionID)
     {
        String sql="UPDATE choices SET id="+id+",choise='"+choice+"',is_answer="+is_answer+",question_id="+questionID+" WHERE id="+id;
        return executeSql(sql);
     }

     public int delete(int id)
     {
        String sql = "DELETE FROM choices WHERE id=" + id;
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