package goodsmanage;
import Login.LoginFrame;
import utils.DBHelper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Goods;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class goodsQuery extends JFrame {

	private JPanel contentPane;
	//用于存放查询后的
	ArrayList<Goods> temp_list = new ArrayList<Goods>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					goodsQuery frame = new goodsQuery();
					frame.setLocation(600, 200);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void updateList(ArrayList<Goods> good_list) {
		temp_list.clear();
		for(int i=0; i<good_list.size(); i++) {
//			System.out.println(good_list.get(i).getGoodsName());
			temp_list.add(good_list.get(i));
		}
	}

	/**
	 * Create the frame.
	 */
	public goodsQuery() {
		setTitle("\u7F8E\u5986\u5546\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5546\u54C1\u67E5\u8BE2");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(235, 82, 165, 53);
		contentPane.add(label);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 41, 21);
		contentPane.add(menuBar);
	
		JMenu menu = new JMenu("\u9000\u51FA");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				dispose();
				LoginFrame lg = new LoginFrame();
				lg.setLocation(600,300);
				lg.setVisible(true);
			}
		});
		menu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menu);
		
		JLabel label_1 = new JLabel("\u59AE\u7EF4\u96C5\u4E1D\u6DA6\u723D\u80A4\u6C34 ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(70, 370, 510, 38);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u54C1\u7C7B\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(358, 427, 80, 23);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("/");
		label_3.setBounds(595, 561, 8, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("20");
		label_4.setBounds(617, 561, 29, 18);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u5546\u54C1\u4EF7\u683C\uFF1A");
		label_5.setBounds(358, 481, 80, 27);
		contentPane.add(label_5);
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_6 = new JLabel("\u5143");
		label_6.setFont(new Font("宋体", Font.PLAIN, 17));
		label_6.setBounds(519, 486, 72, 18);
		contentPane.add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u9762\u971C", "\u4E73\u6DB2", "\u6D01\u9762", "\u9762\u819C", "\u7CBE\u534E", "\u5316\u5986\u6C34", "\u9632\u6652\u971C", "\u53BB\u89D2\u8D28"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(452, 428, 80, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u59AE\u7EF4\u96C5", "OLAY", "\u9999\u5948\u513F", "\u96C5\u8BD7\u5170\u9EDB"}));
		comboBox_1.setBounds(154, 428, 88, 23);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\519ee552cc09e (1).jpg"));
		lblNewLabel.setBounds(210, 136, 220, 233);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u54C1\u724C\uFF1A");
		lblNewLabel_1.setBounds(79, 429, 80, 19);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\logo.png"));
		lblNewLabel_2.setBounds(180, 13, 304, 80);
		contentPane.add(lblNewLabel_2);		
		
		JLabel lblNewLabel_3 = new JLabel("001");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(139, 486, 103, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("1000");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(440, 486, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("1");
		lblNewLabel_5.setBounds(579, 561, 24, 18);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblid = new JLabel("\u5546\u54C1ID\uFF1A");
		lblid.setBounds(79, 484, 76, 20);
		contentPane.add(lblid);
		lblid.setFont(new Font("宋体", Font.PLAIN, 16));	
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\\u8D2D\u7269\u8F66.jpg"));
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(611, 13, 35, 27);
		contentPane.add(button_1);
						
		//进入商品界面默认展示   妮维雅  +  面霜 的查询结果 
		String category = (String) comboBox.getSelectedItem();
		String  brand = (String) comboBox_1.getSelectedItem();
		String sql = "select * from goodsQuery where goodsBrand like '%妮维雅%' and goodsCategory like '%面霜%'";
		DBHelper dbHelper = new DBHelper();
		ArrayList good_list = dbHelper.query2(sql);	
		int page_total = good_list.size();
		float price = ((Goods) good_list.get(0)).getPrice();
		String id = ((Goods) good_list.get(0)).getId();
		String name = ((Goods) good_list.get(0)).getGoodsName();
		String categories = ((Goods) good_list.get(0)).getCategory();
		DecimalFormat df = new DecimalFormat();
		String style = "0.00";
		df.applyPattern(style);
		lblNewLabel_3.setText(id);
		lblNewLabel_4.setText(df.format(price));
		label_1.setText(name);
		String image = "D:\\PyCharm\\untitled17\\images\\" + id + ".jpg";
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(210, 136, 220, 233);
		contentPane.add(lblNewLabel);
		DecimalFormat df1 = new DecimalFormat();
		String style1 = "0";
		df1.applyPattern(style1);
		label_4.setText(df1.format(page_total));
		
		//更新temp_list
		this.updateList(good_list);
		
		// 查询按钮	
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = (String) comboBox.getSelectedItem();
				String  brand = (String) comboBox_1.getSelectedItem();
				String sql = "select * from goodsQuery where goodsBrand like '%"+brand+"%' and goodsCategory like '%"+category+"%'";
				DBHelper dbHelper = new DBHelper();
				ArrayList good_list = dbHelper.query2(sql);	
				//将列表的第一个商品展示在 页面中
				float price = ((Goods) good_list.get(0)).getPrice();
				String id = ((Goods) good_list.get(0)).getId();
				String name = ((Goods) good_list.get(0)).getGoodsName();
				String categories = ((Goods) good_list.get(0)).getCategory();
				DecimalFormat df = new DecimalFormat();
				String style = "0.00";
				df.applyPattern(style);
				lblNewLabel_3.setText(id);
				lblNewLabel_4.setText(df.format(price));
				label_1.setText(name);
				String image = "D:\\PyCharm\\untitled17\\images\\" + id + ".jpg";
				lblNewLabel.setIcon(new ImageIcon(image));
				lblNewLabel.setBounds(210, 136, 220, 233);
				contentPane.add(lblNewLabel);
				DecimalFormat df1 = new DecimalFormat();
				String style1 = "0";
				df1.applyPattern(style1);
				//调用更新列表的函数，将查询的结果更新至temp_list中
				updateList(good_list);
				label_4.setText(df1.format(good_list.size()));
				//每执行一次查询操作，修改当前页面为1
				lblNewLabel_5.setText(df1.format(1));
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 17));
		button.setBounds(289, 537, 88, 28);
		contentPane.add(button);
				
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				buyGoods bG = new buyGoods();
				bG.setLocation(700, 400);
				bG.setVisible(true);
			}
		});
		
		//下一个
		JButton button_2 = new JButton("\u4E0B\u4E00\u4E2A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int current_page = Integer.parseInt(lblNewLabel_5.getText());
				int page_total = Integer.parseInt(label_4.getText());
				if(current_page<page_total) {			
					float price = ((Goods) temp_list.get(current_page)).getPrice();
					String id = ((Goods) temp_list.get(current_page)).getId();
					String name = ((Goods) temp_list.get(current_page)).getGoodsName();
					String categories = ((Goods) temp_list.get(current_page)).getCategory();
					DecimalFormat df = new DecimalFormat();
					String style = "0.00";
					df.applyPattern(style);
					lblNewLabel_3.setText(id);
					lblNewLabel_4.setText(df.format(price));
					label_1.setText(name);
					String image = "D:\\PyCharm\\untitled17\\images\\" + id + ".jpg";
					lblNewLabel.setIcon(new ImageIcon(image));
					lblNewLabel.setBounds(210, 136, 220, 233);
					contentPane.add(lblNewLabel);
					DecimalFormat df1 = new DecimalFormat();
					String style1 = "0";
					df1.applyPattern(style1);
					label_4.setText(df1.format(temp_list.size()));
					//当前页码+1
				    current_page +=1;
					lblNewLabel_5.setText(df1.format(current_page));
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		button_2.setBounds(427, 538, 85, 27);
		contentPane.add(button_2);
		
		//上一个
		JButton button_3 = new JButton("\u4E0A\u4E00\u4E2A");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int current_page = Integer.parseInt(lblNewLabel_5.getText());
				int page_total = Integer.parseInt(label_4.getText());
				if(current_page>1) {
					String category = (String) comboBox.getSelectedItem();
					String  brand = (String) comboBox_1.getSelectedItem();
					String sql = "select * from goodsQuery where goodsBrand like '%"+brand+"%' and goodsCategory like '%"+category+"%'";
					DBHelper dbHelper = new DBHelper();
					ArrayList good_list = dbHelper.query2(sql);	
					//当前页码-1
					current_page -=1;
					float price = ((Goods) temp_list.get(current_page)).getPrice();
					String id = ((Goods) temp_list.get(current_page)).getId();
					String name = ((Goods) temp_list.get(current_page)).getGoodsName();
					String categories = ((Goods) temp_list.get(0)).getCategory();
					DecimalFormat df = new DecimalFormat();
					String style = "0.00";
					df.applyPattern(style);
					lblNewLabel_3.setText(id);
					lblNewLabel_4.setText(df.format(price));
					label_1.setText(name);
					String image = "D:\\PyCharm\\untitled17\\images\\" + id + ".jpg";
					lblNewLabel.setIcon(new ImageIcon(image));
					lblNewLabel.setBounds(210, 136, 220, 233);
					contentPane.add(lblNewLabel);
					DecimalFormat df1 = new DecimalFormat();
					String style1 = "0";
					df1.applyPattern(style1);
					label_4.setText(df1.format(temp_list.size()));
					lblNewLabel_5.setText(df1.format(current_page));
				}								
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 15));
		button_3.setBounds(154, 537, 88, 27);
		contentPane.add(button_3);
	}
}
