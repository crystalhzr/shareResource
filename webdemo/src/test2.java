import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test2 {

    public static void main(String[] args) {
    	try 
        {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("驱动加载成功！");
        }
        catch(ClassNotFoundException e) 
        {            
            System.out.println("驱动加载失败！");
            e.printStackTrace();
        }
        String user="test";
        String password="123456";
        String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=User_DB";
        try {
   
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接成功");
            Statement stmt=conn.createStatement();//创建一个Statement对象
            String sql="select * from t_user";//生成一条sql语句
            ResultSet rs=stmt.executeQuery(sql);//执行查询，把查询结果赋值给结果集对象
            String callingPartyNumber;//声明2个变量分别为用户名，密码
            while(rs.next()){//遍历结果集
                callingPartyNumber=rs.getString("callingPartyNumber");//
                System.out.println(callingPartyNumber);
            }
            System.out.println("获得查询结果集");
            conn.close();
            System.out.println("关闭数据库连接对象");
         } 
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}