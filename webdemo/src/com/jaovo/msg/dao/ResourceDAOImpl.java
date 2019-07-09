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
		// ������ӵĶ���
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
			// �ر�JDBC����
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}

	public void delete(int id) {
		// ������ӵĶ���
		Connection connection = DBUtil.getConnection();
		// ׼��sql���
		String sql = "delete from t_user where id=?";
		// ������䴫�����
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
		// ������ӵĶ���
		Connection connection = DBUtil.getConnection();
		// ׼��sql���
		String sql = "delete from t_user where id=?";
		// ������䴫�����
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
		// ������ӵĶ���
		Connection connection = DBUtil.getConnection();
		// ׼��sql���
		String sql = "select * from t_user where id=?";
		// ������䴫�����
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
		// ������ӵĶ���
		Connection connection = DBUtil.getConnection();
		// ׼��sql���
		String sql = "select * from t_resource where resName=?";
		// ������䴫�����
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
    //�г������ϴ����ļ�
	public List<Resource> loadAll() {
		// ������ӵĶ���
		Connection connection = DBUtil.getConnection();
		// ׼��sql���
		String sql = "select * from t_resource";
		// ������䴫�����
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