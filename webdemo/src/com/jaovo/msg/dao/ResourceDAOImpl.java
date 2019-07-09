package com.jaovo.msg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jaovo.msg.Util.DBUtil;
//import com.jaovo.msg.Util.UserException;
import com.jaovo.msg.model.Resource;
import com.sun.crypto.provider.RSACipher;

public class ResourceDAOImpl implements IResourceDAO {
	public void add(Resource resource) {
		// 获得连接的对象
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String sql = "insert into t_resource(resName,resLoc,resAuthor,resType,resTitle,describe,resDate) values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, resource.getResoceName());
			preparedStatement.setString(2, resource.getResoceLoc());
			preparedStatement.setString(3, resource.getResoceAuthor());
			preparedStatement.setString(4, resource.getType());
			preparedStatement.setString(5, resource.getTitle());
			preparedStatement.setString(6, resource.getDescribe());
			preparedStatement.setString(7, resource.getDate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭JDBC对象
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}

	public void delete(int id) {
		// 获得连接的对象
		Connection connection = DBUtil.getConnection();
		// 准备sql语句
		String sql = "delete from t_user where id=?";
		// 创建语句传输对象
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}

	public void update(Resource resource) {
		// 获得连接的对象
		Connection connection = DBUtil.getConnection();
		// 准备sql语句
		String sql = "delete from t_user where id=?";
		// 创建语句传输对象
		PreparedStatement preparedStatement = null;
		/*
		 * try { preparedStatement=connection.prepareStatement(sql);
		 * preparedStatement.setString(1, user.getUsername());
		 * preparedStatement.setString(2, user.getEmail()); preparedStatement.setInt(3,
		 * user.getId()); preparedStatement.executeUpdate(); } catch(SQLException e) {
		 * e.printStackTrace(); } finally { DBUtil.close(preparedStatement);
		 * DBUtil.close(connection); }
		 */
	}

	public Resource load(int id) {
		// 获得连接的对象
		Connection connection = DBUtil.getConnection();
		// 准备sql语句
		String sql = "select * from t_user where id=?";
		// 创建语句传输对象
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Resource resource = null;
		/*
		 * User user=null; try { preparedStatement=connection.prepareStatement(sql);
		 * preparedStatement.setInt(1, id); resultSet=preparedStatement.executeQuery();
		 * while(resultSet.next()) { user=new User(); user.setId(id);
		 * user.setUsername(resultSet.getString("username"));
		 * user.setPassword(resultSet.getString("password"));
		 * user.setEmail(resultSet.getString("nickname")); } } catch(SQLException e) {
		 * e.printStackTrace(); } finally { DBUtil.close(resultSet);
		 * DBUtil.close(preparedStatement); DBUtil.close(connection); }
		 */
		return resource;
	}

	public Resource loadByResname(String resname) {
		// 获得连接的对象
		Connection connection = DBUtil.getConnection();
		// 准备sql语句
		String sql = "select * from t_resource where resName=?";
		// 创建语句传输对象
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Resource res = null;
		try { 
			preparedStatement=connection.prepareStatement(sql);
		    preparedStatement.setString(1, resname);
		    resultSet=preparedStatement.executeQuery(); 
		    while(resultSet.next()) {
		    	res=new Resource(); 
		    	res.setResoceName(resname);
		    	res.setResoceLoc(resultSet.getString("resLoc"));
		    	res.setResoceAuthor(resultSet.getString("resAuthor"));
		    	res.setType(resultSet.getString("resType"));
		    	res.setTitle(resultSet.getString("resTitle"));
		    	res.setDescribe(resultSet.getString("describe"));
		    	res.setDate(resultSet.getString("resDate"));
		    	}
		    } 
		catch(SQLException e) {  
			e.printStackTrace(); 
		} finally { 
			DBUtil.close(resultSet);
		    DBUtil.close(preparedStatement); 
		    DBUtil.close(connection); 
		}		 
		return res;
	}
    //列出所有上传的文件
	public List<Resource> loadAll() {
		// 获得连接的对象
		Connection connection = DBUtil.getConnection();
		// 准备sql语句
		String sql = "select * from t_resource";
		// 创建语句传输对象
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Resource> resources = new ArrayList<Resource>();
		
		Resource res=null; 
		try { 
			preparedStatement=connection.prepareStatement(sql);
		    resultSet=preparedStatement.executeQuery(); 
		    while(resultSet.next()) {
		    	res=new Resource(); 
		    	res.setResoceName(resultSet.getString("resName"));
		    	res.setResoceLoc(resultSet.getString("resLoc"));
		    	res.setResoceAuthor(resultSet.getString("resAuthor"));
		    	res.setType(resultSet.getString("resType"));
		    	res.setTitle(resultSet.getString("resTitle"));
		    	res.setDescribe(resultSet.getString("describe"));
		    	res.setDate(resultSet.getString("resDate"));
		    	resources.add(res);
		    	}
		} 
		catch(SQLException e) { 
			e.printStackTrace(); 
		} 
		finally{
		  DBUtil.close(resultSet); DBUtil.close(preparedStatement);
		  DBUtil.close(connection); 
		}
		return resources;
	}
}