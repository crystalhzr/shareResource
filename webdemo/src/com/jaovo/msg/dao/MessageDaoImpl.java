package com.jaovo.msg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jaovo.msg.Util.DBUtil;
import com.jaovo.msg.model.Message;

public class MessageDaoImpl implements IMessageDao
{
    public void add(Message message) 
    {
        //获得连接的对象
        Connection connection=DBUtil.getConnection();
        //准备sql语句
        String sql="";
        //创建语句传输对象
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            sql="insert into t_message(msgPoster,msgTitle,msgContent,msgDate) values(?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            //preparedStatement.setInt(1, message.getId());
            preparedStatement.setString(1, message.getmsgPoster());
            preparedStatement.setString(2, message.getmsgTitle());
            preparedStatement.setString(3, message.getmsgContent());
            preparedStatement.setString(4, message.getmsgDate());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            //关闭JDBC对象
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);    
        }
    }

//    public void delete(int id)
//    {
//        //获得连接的对象
//        Connection connection=DBUtil.getConnection();
//        //准备sql语句
//        String sql="delete from t_user where id=?";
//        //创建语句传输对象
//        PreparedStatement preparedStatement=null;
//        try 
//        {
//            
//            preparedStatement=connection.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//            
//        }
//        catch(SQLException e) 
//        {
//            e.printStackTrace();
//            
//        }
//        finally 
//        {
//            DBUtil.close(preparedStatement);
//            DBUtil.close(connection);
//        }
//    }
//
//    public void update(User user) 
//    {
//        //获得连接的对象
//        Connection connection=DBUtil.getConnection();
//        //准备sql语句
//        String sql="delete from t_user where id=?";
//        //创建语句传输对象
//        PreparedStatement preparedStatement=null;
//        try 
//        {
//            preparedStatement=connection.prepareStatement(sql);
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setInt(3, user.getId());
//            preparedStatement.executeUpdate();
//        }
//        catch(SQLException e) 
//        {
//            e.printStackTrace();
//        }
//        finally 
//        {
//            DBUtil.close(preparedStatement);
//            DBUtil.close(connection);
//        }
//    }
//
//    public User load(int id) 
//    {
//        //获得连接的对象
//        Connection connection=DBUtil.getConnection();
//        //准备sql语句
//        String sql="select * from t_user where id=?";
//        //创建语句传输对象
//        PreparedStatement preparedStatement=null;
//        ResultSet resultSet=null;
//        User user=null;
//        try 
//        {
//            preparedStatement=connection.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            resultSet=preparedStatement.executeQuery();
//            while(resultSet.next()) 
//            {
//                user=new User();
//                user.setId(id);
//                user.setUsername(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
//                user.setEmail(resultSet.getString("nickname"));
//            }        
//        }
//        catch(SQLException e) 
//        {
//            e.printStackTrace();
//        }
//        finally 
//        {
//            DBUtil.close(resultSet);
//            DBUtil.close(preparedStatement);
//            DBUtil.close(connection);        
//        }
//            return user;
//    }
//
//    public User load(String username) 
//    {
//        //获得连接的对象
//        Connection connection=DBUtil.getConnection();
//        //准备sql语句
//        String sql="select * from t_user where username=?";
//        //创建语句传输对象
//        PreparedStatement preparedStatement=null;
//        ResultSet resultSet=null;
//        User user=null;
//        try 
//        {
//            preparedStatement=connection.prepareStatement(sql);
//            preparedStatement.setString(1, username);
//            resultSet=preparedStatement.executeQuery();
//            while(resultSet.next()) 
//            {
//                user=new User();
//                user.setId(resultSet.getInt("id"));
//                user.setUsername(username);
//                user.setPassword(resultSet.getString("password"));
//                user.setEmail(resultSet.getString("email"));
//            }
//        }
//        catch(SQLException e) 
//        {
//        e.printStackTrace();
//        }
//        finally 
//        {
//            DBUtil.close(resultSet);
//            DBUtil.close(preparedStatement);
//            DBUtil.close(connection);        
//        }
//        return user;
//    }

    public List<Message> loadAll() 
    {
        //获得连接的对象
        Connection connection=DBUtil.getConnection();
        //准备sql语句
        String sql="select * from t_message";
        //创建语句传输对象
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Message> messages=new ArrayList<Message>();
        Message message=null;
        try 
        {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) 
            {
            	message=new Message();
            	//message.setId(resultSet.getInt("id"));
            	message.setmsgPoster(resultSet.getString("msgPoster"));
            	message.setmsgTitle(resultSet.getString("msgTitle"));
            	message.setmsgContent(resultSet.getString("msgContent"));
            	message.setmsgDate(resultSet.getString("msgDate"));          	
            	messages.add(message);
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
        return messages;
    }
  
}