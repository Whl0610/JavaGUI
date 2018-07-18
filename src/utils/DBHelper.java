package utils;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Dao.Goods;
import Dao.User;

/**
 * �������ר�������ݿ�������ӵ�
 * @author Whl0610
 *
 */

public class DBHelper {
	
	Connection connection = null; //���ݿ�����Ӷ���
	Statement stmt = null;   //SQL�����������
	ResultSet rs = null;  //���������

	//mysql���ݿ�url 
	String userMySql="root"; 
	String passwordMySql="";
	String urlMySql = "jdbc:mysql://localhost:3306/onlylady?user="
			+userMySql+"&password="+passwordMySql + "&useUnicode=true&characterEncoding=gbk";
	private String sql1;
	
	public boolean connectMysql() {
		boolean b = false;
		try {
			//mysql���ݿ�����������������
			Class.forName("com.mysql.jdbc.Driver"); 
			connection = DriverManager.getConnection(urlMySql);  
			if(connection!=null){
	            b = true;
	        }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return b;
	}
	
	public boolean isExist(String username){
		boolean isExist = false;
		if(connectMysql()) {
			String sql = "select * from user where username='"+username+"'";			
			this.query(sql);
			if(next()) {
				isExist = true;
			}	
			
		}
		return isExist;
	}
	
	// �������ܣ� ����sql����ѯ���ݿ�  ����Ϊ�� ����ȷ�������Ƿ���ڵĲ�ѯ����   �� isEXIST�����е���
	private void query(String sql) {
		try {
			stmt = (Statement) connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void closeConn() {
		try {
			if(connection!=null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void closeStmt() {
		try {
			if(stmt!=null) {
				stmt.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void closeRs() {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean next() {
		boolean b = false;
		try {
			if(rs.next())b=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	
	// ������ѯuser������ĳ���ֶ� ���ص�һ��User����
	public User query1(String sql){
		try {
			
			stmt = (Statement) connection.createStatement();
			rs = stmt.executeQuery(sql);
			User user = new User();
			if(rs.next()) {
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getInt("role"));
			   }
			return user;
		 } catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
	}
	
	//��ѯgoodsquery����������ֶβ�ѯ������һ��Goods���͵��б�
	public ArrayList<Goods> query2(String sql){
		//��ѯ���ݿ�����
		try {
			ArrayList<Goods> good_list = new ArrayList<Goods>();
			if(connectMysql()) {
			stmt = (Statement) connection.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Goods good = new Goods();
				good.setId(rs.getString("goodsID"));
				good.setPrice(rs.getFloat("goodsPrice"));
				good.setGoodsName(rs.getString("goodsBrand"));
				good.setCategory(rs.getString("goodsCategory"));
				good.setStorage(rs.getShort("goodsStorage"));
				good.setSell(rs.getInt("goodsSell"));
				good_list.add(good);
			   }
			return good_list;
			}else {
				return null;
			}
		 } catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
	}
	
	// ������ѯgoodsquery������ĳ���ֶ� ���ص�һ��Goods����
	public Goods query3(String sql){
		//��ѯ���ݿ�����
		
			try {
			 if(this.connectMysql()) {
				stmt = (Statement) connection.createStatement();
				rs = stmt.executeQuery(sql);
				Goods good = new Goods();
				if(rs.next()) {
					good.setId(rs.getString("goodsID"));
					good.setGoodsName(rs.getString("goodsBrand"));
					good.setSell(rs.getShort("goodsSell"));
					good.setStorage(rs.getInt("goodsStorage"));
					good.setPrice(rs.getFloat("goodsPrice"));
				   }
			return good;
			 }else {
				return null;
			}
		 } catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				// �ͷ����ݼ�����
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// �ͷ�������
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
	}

	//�����û�ע�ᣬ��user���������
	public void insert(String username, String password){
		if(this.connectMysql()) {
			int role = 0;
			String sql = "insert into user(username, password, role) values('"+username+"','"+password+"','"+role+"')";
			this.update(sql);
			this.closeStmt();
			this.closeConn();
		}
	}
	
	//����ɾ����Ʒ�����Ʒ
	public void deleteGoods(String id) {
		
		try {
			if(this.connectMysql()) {
				String sql = "delete from goodsquery where goodsID='"+id+"'";
				System.out.println(sql);
				stmt = (Statement) connection.createStatement();
				stmt.execute(sql);
				
			}
			
		} catch (Exception e) {
			
		}finally {
			try {
//				stmt.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	//���ڸ�������
	public boolean update(String sql) {
		boolean b = false;
		try {
			stmt = (Statement) connection.createStatement();
			stmt.execute(sql);
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	
	//������ɽ��� �ۻ��Ĺ��� ��goodsquery����и���
	public void updateGoods(int storage, int sell, String id) {
		PreparedStatement statement = null;
		try {
			if(this.connectMysql()) {
				String sql = "UPDATE goodsquery SET goodsStorage=?,goodsSell=? where goodsID = "+id+"";
				statement = (PreparedStatement) connection.prepareStatement(sql);
				statement.setInt(1, storage);
				statement.setInt(2, sell);
				statement.execute();
				connection.commit();
				
			}
		} catch (Exception e) {
			
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	//��������Ʒ���ϼܣ���goodsquery���в�������
	public void insertgoods(String goodsID, String goodsBrand,String goodsCategory, String goodsPrice, int goodsSell, int goodsStorage){
		if(this.connectMysql()) {
			
			String sql = "insert into goodsquery(goodsID ,goodsBrand, goodsCategory, goodsPrice, goodsSell, goodsStorage) values('"+goodsID+"','"+goodsBrand+"','"+goodsCategory+"','"+goodsPrice+"','"+goodsSell+"','"+goodsStorage+"')";
			this.update(sql);
			this.closeStmt();
			this.closeConn();
		}
	}
	

}