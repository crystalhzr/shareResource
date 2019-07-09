package com.jaovo.msg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jaovo.msg.Util.DBUtil;
import com.jaovo.msg.Util.UserException;
import com.jaovo.msg.model.User;

public class UserDaoImpl implements IUserDao
{
    public void add(User user) 
    {
        //������ӵĶ���
        Connection connection=DBUtil.getConnection();
        //׼��sql���
        String sql="select count(*) from t_user where username=?";
        //������䴫�����
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try 
        {
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        //���ս����
        resultSet=preparedStatement.executeQuery();    
        //���������
        while(resultSet.next()) 
        {
            if(resultSet.getInt(1)>0) 
            {
                throw new UserException("�û��Ѵ��ڣ�");
            }
        }
        sql="insert into t_user(username,password,email,school,college,profession) values(?,?,?,?,?,?)";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.school);
        preparedStatement.setString(5, user.college);
        preparedStatement.setString(6, user.profession);
        preparedStatement.executeUpdate();
        //��д�ײ���룺
        /*
        sql="insert into t_user(id,username,userpassword,nickname)values('"+user.getId()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getNickname()+"')";
        Statement stmt;
        Connection con=DBUtil.getConnection();
        stmt=con.createStatement();
        stmt.executeUpdate(sql);
        */
        //��д����
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            //�ر�JDBC����
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);    
        }
    }

    public void delete(int id)
    {
        //������ӵĶ���
        Connection connection=DBUtil.getConnection();
        //׼��sql���
        String sql="delete from t_user where id=?";
        //������䴫�����
        PreparedStatement preparedStatement=null;
        try 
        {
            
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        }
        catch(SQLException e) 
        {
            e.printStackTrace();
            
        }
        finally 
        {
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
    }

    public void update(User user) 
    {
        //������ӵĶ���
        Connection connection=DBUtil.getConnection();
        //׼��sql���
        String sql="delete from t_user where id=?";
        //������䴫�����
        PreparedStatement preparedStatement=null;
        try 
        {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
    }

    public User load(int id) 
    {
        //������ӵĶ���
        Connection connection=DBUtil.getConnection();
        //׼��sql���
        String sql="select * from t_user where id=?";
        //������䴫�����
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        User user=null;
        try 
        {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) 
            {
                user=new User();
                user.setId(id);
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("nickname"));
            }        
        }
        catch(SQLException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);        
        }
            return user;
    }

    public User load(String username) 
    {
        //������ӵĶ���
        Connection connection=DBUtil.getConnection();
        //׼��sql���
        String sql="select * from t_user where username=?";
        //������䴫�����
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        User user=null;
        try 
        {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) 
            {
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(username);
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
            }
        }
        catch(SQLException e) 
        {
        e.printStackTrace();
        }
        finally 
        {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);        
        }
        return user;
    }

    public List<User> load() 
    {
        //������ӵĶ���
        Connection connection=DBUtil.getConnection();
        //׼��sql���
        String sql="delete from t_user where id=?";
        //������䴫�����
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<User> users=new ArrayList<User>();
        User user=null;
        try 
        {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) 
            {
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("nickname"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            
        }
        catch(SQLException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
        return users;
    }
  //��������ǲ��Ǵ���
    public boolean check(User user) 
    {
        boolean flag=false;
        Connection connection=DBUtil.getConnection();
        String sql="select * from t_user where username=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try 
        {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) 
            {
                if(resultSet.getString("password").equals(user.getPassword().toString().trim())) 
                {
                    flag=true;
                    break;
                }
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return flag;
    }
}