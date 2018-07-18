package goodsmanage;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Goods;
import utils.DBHelper;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;


public class goodsManager extends JDialog {
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {			
			managerchoose frame = new managerchoose();
			goodsManager dialog = new goodsManager(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocation(650,300);
			dialog.setSize(600,500);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public goodsManager(managerchoose frame) {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 17));
		setTitle("\u5546\u54C1\u5E93\u5B58\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 561, 496);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel(frame.name.toString());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(82, 92, 420, 37);
		getContentPane().add(label);
		
		String image = "D:\\PyCharm\\untitled17\\images\\" + frame.id.toString() + ".jpg";
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(164, 132, 231, 187);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\logo.png"));
		lblNewLabel_1.setBounds(145, 13, 282, 72);
		getContentPane().add(lblNewLabel_1);
		
		
		JLabel label_2 = new JLabel("\u552E\u51FA\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 17));
		label_2.setBounds(200, 332, 61, 28);
		getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("宋体", Font.PLAIN, 17));
		textField.setText("");
		textField.setBounds(259, 373, 51, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 17));
		textField_1.setText("");
		textField_1.setBounds(259, 335, 51, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8FDB\u8D27\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 17));
		label_4.setBounds(200, 373, 61, 20);
		getContentPane().add(label_4);
		
		ButtonGroup group = new ButtonGroup();
		
		JButton button = new JButton("\u786E\u8BA4");	
		button.setFont(new Font("宋体", Font.PLAIN, 17));
		button.setBounds(210, 413, 146, 23);
		getContentPane().add(button);		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 45, 26);
		getContentPane().add(menuBar);
		
		JMenu menu = new JMenu("\u8FD4\u56DE");
		menu.setFont(new Font("宋体", Font.PLAIN, 16));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4E3B\u83DC\u5355");
		menuItem.setFont(new Font("宋体", Font.PLAIN, 15));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				managerchoose mc = new managerchoose();
				mc.setLocation(600, 300);
				mc.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String new_sell_text = textField_1.getText();
				String new_storage_text = textField.getText();
				int new_out = Integer.parseInt(new_sell_text);
				int new_in = Integer.parseInt(new_storage_text);
				DBHelper dbHelper = new DBHelper();
				String sql = "select * from goodsquery where goodsID = '"+frame.id.toString()+"'";
				Goods good = dbHelper.query3(sql);
				//库存以及售出的计算
				int current_storage = good.getStorage();
				int current_sell = good.getSell();				
				int new_sell = current_sell + new_out;
				int new_storage = current_storage + new_in - new_out;							
				dbHelper.updateGoods(new_storage, new_sell, frame.id.toString());
				
				dispose();
				alterSuccess aS= new alterSuccess();
				aS.setLocation(750, 400);
				aS.setVisible(true);
			}
		});
	}
}