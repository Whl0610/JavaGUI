package Login;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.User;
import utils.DBHelper;
import goodsmanage.goodsQuery;
import goodsmanage.managerchoose;

import java.awt.Font;


import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction_1();
	private static Component frame;

	/**
	 * Launch the application.
	 */
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setSize(730, 500);
					frame.setLocation(550,250);
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
	public LoginFrame() {
		setFont(new Font("楷体", Font.BOLD, 17));
		setTitle("\u7F8E\u5986\u5546\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("\u7528\u6237\u540D\\\u7BA1\u7406\u5458ID\uFF1A");
		lblid.setFont(new Font("宋体", Font.PLAIN, 16));
		lblid.setBounds(172, 195, 140, 18);
		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblid);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u7F8E\u5986\u5546\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(172, 107, 432, 66);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 32));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(261, 253, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(326, 191, 122, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(326, 249, 122, 28);
		passwordField.setEchoChar('*');
		contentPane.add(passwordField);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7528\u6237");
		rdbtnNewRadioButton.setBounds(314, 299, 72, 27);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u7BA1\u7406\u5458");
		rdbtnNewRadioButton_1.setBounds(392, 299, 157, 27);
		contentPane.add(rdbtnNewRadioButton_1);
			
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			LoginRegister loginRegister = new LoginRegister();
			loginRegister.setLocation(650,300);	
			loginRegister.setVisible(true);
			dispose();
			}
		});

		
		JButton button = new JButton("\u767B\u9646");
		DBHelper dbHelper = new DBHelper();		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText().trim();//这两句是用户的用户名和密码
				String password = passwordField.getText().trim();
				String sql = "select password,role from user where username='"+username+"'";
				// 首先需要判断用户是否存在
				if(dbHelper.isExist(username)) {
					User user = dbHelper.query1(sql);
					// 选择普通用户的身份登录
					if(rdbtnNewRadioButton.isSelected()) {
						//判断按钮是否选中以及数据库中是否存在用户名						
						if(user.getPassword().equals(password)) {
							//进入商品购物界面
							dispose();
							goodsQuery gQ = new goodsQuery();
							gQ.setLocation(600, 200);
							gQ.setVisible(true);							
						}else {
							dispose();
							Logindefault Lf = new Logindefault();
							Lf.setLocation(700, 300);
							Lf.setVisible(true);	
						}
					}
					
					// 选择管理员的身份登录
					else if(rdbtnNewRadioButton_1.isSelected()&user.getRole()==1) {//判断其role是否为1,为1才能够进入管理员系统
						//进入管理员菜单
						dispose();
						managerchoose mc = new managerchoose();
						mc.setLocation(600, 300);
						mc.setVisible(true);					
						//System.out.println("您是管理员");
					}
					// 什么也没有选择或者权限不对 则弹出登录失败的警告
					else {
						dispose();
						Logindefault Lf = new Logindefault();
						Lf.setLocation(700, 300);
						Lf.setVisible(true);				
					}
				}
				// 用户不存在
				else {
					dispose();
					Logindefault Lf = new Logindefault();
					Lf.setLocation(700, 300);
					Lf.setVisible(true);	
				}								
			}							
		});
		
		
		button.setBounds(233, 350, 113, 27);
		contentPane.add(button);
		button_1.setBounds(385, 349, 113, 28);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\logo.png"));
		lblNewLabel_2.setBounds(225, 13, 292, 108);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("\u6743\u9650\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		label_1.setBounds(261, 302, 51, 18);
		contentPane.add(label_1);		
	}
		
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}