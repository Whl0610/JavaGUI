package goodsmanage;
import Login.LoginFrame;
import utils.DBHelper;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.RowData;
import Dao.Goods;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;


public class managerchoose extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	
	Vector rowData, columnNames;//rowData用来存放行数据，columnNames用来存放列名
	JTable jt = null;
	JScrollPane jsp = null;
	
	PreparedStatement ps = null;
	Connection ct = null;
	ResultSet rs = null;
	
	//这里的变量是用来 在两个窗体之间传值的 
	//当修改或者删除时 往往需要将本页面的商品信息传给另外一个窗体
	//所以需要将相关参数 存放在这些变量里
	int index = 0;
	Object id = "";
	Object deleteId = "";
	Object name = "";
	Object sell = 0;
	Object storage = 0;
	
	
	
	/**
	 * Launch the application.
	 */
	
	public void clearData(Object [][] data) {
		for (int i = 0; i <data.length ; i++) {
			for (int j = 0; j <data[i].length ; j++) {
				data[i][j] = null;
			} 
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerchoose frame = new managerchoose();
					frame.setLocation(550,300);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void updatetable() {
		
	}
		
	public managerchoose() {
		setTitle("\u7F8E\u5986\u5546\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(644, 0, 200, 48);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\logo - \u526F\u672C (2).png"));
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 213, 31);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("\u9996\u9875");
		menuBar.add(menu);
		menu.setHorizontalAlignment(SwingConstants.LEFT);
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(175, 44, 102, 27);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u59AE\u7EF4\u96C5", "OLAY", "\u9999\u5948\u513F", "\u96C5\u8BD7\u5170\u9EDB"}));
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u9762\u971C", "\u4E73\u6DB2", "\u6D01\u9762", "\u9762\u819C", "\u7CBE\u534E", "\u5316\u5986\u6C34", "\u9632\u6652\u971C", "\u53BB\u89D2\u8D28"}));
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox_1.setBounds(367, 44, 78, 27);
		contentPane.add(comboBox_1);
		
		JMenuItem menuItem_1_1 = new JMenuItem("\u8FD4\u56DE\u767B\u9646\u754C\u9762");
		menuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame LF = new LoginFrame();
				LF.setLocation(600, 300);
				LF.setVisible(true);
			}
		});
		menuItem_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		menu.add(menuItem_1_1);
		
		JMenu mnNewMenu = new JMenu("\u8FDB\u9500\u5B58\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		
		JMenuItem menuItem = new JMenuItem("\u8FDB\u8D27\u5355\u67E5\u8BE2");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				goodsIn gI = new goodsIn();
				gI.setLocation(650, 300);
				gI.setVisible(true);
			}
		});
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu.add(menuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		
		JMenuItem menuItem_1 = new JMenuItem("\u7528\u6237\u8D26\u53F7\u7BA1\u7406");
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		mnNewMenu_1.add(menuItem_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(0, 44, 27, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				managerchoose frame = new managerchoose();
				newGoodsInsert nGI = new newGoodsInsert(frame);
				nGI.setLocation(700, 300);
				nGI.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\\u52A0\u53F7.png"));
		contentPane.add(btnNewButton);	
		
		JLabel label = new JLabel("\u5546\u54C1\u54C1\u724C\uFF1A");
		label.setBounds(91, 44, 94, 31);
		contentPane.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u54C1\u7C7B\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(283, 50, 90, 21);
		contentPane.add(label_1);
		
		table_1 = new JTable();
		table_1.setBounds(95, 152, 1, 1);
		contentPane.add(table_1);
		
		// 从数据库读取商品信息
		String  brand = (String) comboBox.getSelectedItem();
		String  category = (String) comboBox_1.getSelectedItem();
		String sql0 = "select * from goodsQuery where goodsBrand like '%妮维雅%' and goodsCategory like '%面霜%'";
		DBHelper dbHelper = new DBHelper();
		ArrayList<Goods> goods_list0 =dbHelper.query2(sql0);
	
		
		table = new JTable();		
		JScrollPane pane = new JScrollPane();
		pane.setBounds(0, 89, 844, 382);		
		Object[] columnNames = new Object[]{"商品ID", "品牌", "品类", "库存", "已售"};//列名
		Object[][] rowData = new Object[80][5];
		for (int i = 0; i <goods_list0.size() ; i++) { 
		    
		    rowData[i][0]=goods_list0.get(i).getId();//这里赋值
		    rowData[i][1]=goods_list0.get(i).getGoodsName();//这里赋值
		    rowData[i][2]=goods_list0.get(i).getCategory();//这里赋值
		    rowData[i][3]=goods_list0.get(i).getStorage();//这里赋值
		    rowData[i][4]=goods_list0.get(i).getSell();//这里赋值
	  
		}

		table = new JTable(rowData, columnNames);
		getContentPane().add(pane);
		pane.setViewportView(table);
		table.setRowHeight(35); 
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();     
	    r.setHorizontalAlignment(JLabel.CENTER);     
	    table.setDefaultRenderer(Object.class, r); 
		
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//得到combobox里的内容后 通过sql语句调用query2进行goods_list的查询
				String  brand = (String) comboBox.getSelectedItem();
				String  category = (String) comboBox_1.getSelectedItem();
				String sql = "select * from goodsQuery where goodsBrand like '%"+brand+"%' and goodsCategory like '%"+category+"%'";
				DBHelper dbHelper = new DBHelper();
				ArrayList<Goods> goods_list =dbHelper.query2(sql);
				//清空
				clearData(rowData);
			   for (int i = 0; i <goods_list.size() ; i++) { 
				    
				    rowData[i][0]=goods_list.get(i).getId();//这里赋值
				    rowData[i][1]=goods_list.get(i).getGoodsName();//这里赋值
				    rowData[i][2]=goods_list.get(i).getCategory();//这里赋值
				    rowData[i][3]=goods_list.get(i).getStorage();//这里赋值
				    rowData[i][4]=goods_list.get(i).getSell();//这里赋值
			  
			   }

			   table = new JTable(rowData, columnNames);
				getContentPane().add(pane);
				pane.setViewportView(table);
				table.setRowHeight(35); 
				DefaultTableCellRenderer r = new DefaultTableCellRenderer();     
			    r.setHorizontalAlignment(JLabel.CENTER);     
			    table.setDefaultRenderer(Object.class, r); 

			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\\u67E5\u8BE2.png"));
		button.setBounds(459, 44, 27, 27);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(29, 44, 27, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			// 获取选中的table的行数，根据行数索引来获取被选中商品的ID等信息
			public void actionPerformed(ActionEvent e) {
				int num = table.getSelectedRow();
				if(num!=-1) {
					index = num;
				}	
				id = rowData[index][0];
				name = rowData[index][1];
				storage = rowData[index][3];
				sell = rowData[index][4];
				
				dispose();
				goodsManager gM = new goodsManager(managerchoose.this);
				gM.setLocation(650, 300);
				gM.setVisible(true);
				 
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\\u7F16\u8F91.png"));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(59, 44, 27, 27);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = table.getSelectedRow();
				if(num!=-1) {
					index = num;
				}	
				deleteId = rowData[index][0];
				
				goodsDelete gD = new goodsDelete(managerchoose.this);
				gD.setLocation(650, 450);
				gD.setVisible(true);				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\\u5220\u9664.png"));
		contentPane.add(btnNewButton_2);		
	}
}
