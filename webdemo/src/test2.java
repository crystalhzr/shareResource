import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test2 {

    public static void main(String[] args) {
    	try 
        {
            //��������
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("�������سɹ���");
        }
        catch(ClassNotFoundException e) 
        {            
            System.out.println("��������ʧ�ܣ�");
            e.printStackTrace();
        }
        String user="test";
        String password="123456";
        String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=User_DB";
        try {
   
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("���ݿ����ӳɹ�");
            Statement stmt=conn.createStatement();//����һ��Statement����
            String sql="select * from t_user";//����һ��sql���
            ResultSet rs=stmt.executeQuery(sql);//ִ�в�ѯ���Ѳ�ѯ�����ֵ�����������
            String callingPartyNumber;//����2�������ֱ�Ϊ�û���������
            while(rs.next()){//���������
                callingPartyNumber=rs.getString("callingPartyNumber");//
                System.out.println(callingPartyNumber);
            }
            System.out.println("��ò�ѯ�����");
            conn.close();
            System.out.println("�ر����ݿ����Ӷ���");
         } 
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}