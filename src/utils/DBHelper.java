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
 * 这个类是专门与数据库进行连接的
 * @author Whl0610
 *
 */

public class DBHelper {
	
	Connection connection = null; //数据库的连接对象
	Statement stmt = null;   //SQL语句声明对象
	ResultSet rs = null;  //结果集对象

	//mysql数据库url 
	String userMySql="root"; 
	String passwordMySql="";
	String urlMySql = "jdbc:mysql://localhost:3306/onlylady?user="
			+userMySql+"&password="+passwordMySql + "&useUnicode=true&characterEncoding=gbk";
	private String sql1;
	
	public boolean connectMysql() {
		boolean b = false;
		try {
			//mysql数据库设置驱动程序类型
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
	
	// 函数功能： 根据sql语句查询数据库  返回为空 用来确定数据是否存在的查询操作   在 isEXIST函数中调用
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
	
	// 用来查询user表，根据某个字段 返回单一的User对象
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
				// 释放数据集对象
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 释放语句对象
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
	
	//查询goodsquery表，根据相关字段查询，返回一个Goods类型的列表
	public ArrayList<Goods> query2(String sql){
		//查询数据库内容
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
				// 释放数据集对象
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 释放语句对象
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
	
	// 用来查询goodsquery表，根据某个字段 返回单一的Goods对象
	public Goods query3(String sql){
		//查询数据库内容
		
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
				// 释放数据集对象
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 释放语句对象
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

	//用于用户注册，向user表插入数据
	public void insert(String username, String password){
		if(this.connectMysql()) {
			int role = 0;
			String sql = "insert into user(username, password, role) values('"+username+"','"+password+"','"+role+"')";
			this.update(sql);
			this.closeStmt();
			this.closeConn();
		}
	}
	
	//用于删除商品表的商品
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
	
	//用于更新数据
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
	
	//用于完成进货 售货的功能 对goodsquery表进行更新
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
	
	//用于新商品的上架，对goodsquery进行插入数据
	public void insertgoods(String goodsID, String goodsBrand,String goodsCategory, String goodsPrice, int goodsSell, int goodsStorage){
		if(this.connectMysql()) {
			
			String sql = "insert into goodsquery(goodsID ,goodsBrand, goodsCategory, goodsPrice, goodsSell, goodsStorage) values('"+goodsID+"','"+goodsBrand+"','"+goodsCategory+"','"+goodsPrice+"','"+goodsSell+"','"+goodsStorage+"')";
			this.update(sql);
			this.closeStmt();
			this.closeConn();
		}
	}
	

}