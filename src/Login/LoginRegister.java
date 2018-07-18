package Login;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import goodsmanage.registerDefault;
import goodsmanage.registerWaring;
import utils.DBHelper;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginRegister extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginRegister dialog = new LoginRegister();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocation(600, 300);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginRegister() {
		setTitle("\u7F8E\u5986\u5546\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(100, 100, 615, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(162, 13, 272, 72);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\logo.png"));
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u65B0\u7528\u6237\u6CE8\u518C");
			lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
			lblNewLabel_1.setBounds(223, 95, 150, 51);
			contentPanel.add(lblNewLabel_1);
		}
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(254, 159, 160, 31);
		contentPanel.add(textField);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(173, 159, 80, 31);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(190, 219, 60, 18);
		contentPanel.add(label_1);
	
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(153, 267, 100, 24);
		contentPanel.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 215, 160, 31);
		contentPanel.add(passwordField);
				
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(254, 269, 160, 31);
		contentPanel.add(passwordField_1);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String registerName = textField.getText();
				String registerPwd = passwordField.getText();
				String repeatPwd = passwordField_1.getText();
				DBHelper dbHelper = new DBHelper();
				if(!dbHelper.isExist(registerName)) {
					if(registerPwd.equals(repeatPwd)) {
						dbHelper.insert(registerName, registerPwd);
						//注册成功后，点击返回登录界面，然后关闭掉其他不必要的窗口
						Registersuccess Rs = new Registersuccess();
						Rs.setLocation(650,400);
						Rs.setVisible(true);
						dispose();
					}else{						
						//弹出警示框
						dispose();
						registerWaring rW = new registerWaring();
						rW.setLocation(700, 400);
						rW.setVisible(true);
					}
				}else {
					dispose();
					registerDefault rD = new registerDefault();
					rD.setLocation(700, 400);
					rD.setVisible(true);
				}				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(248, 325, 125, 31);
		contentPanel.add(button);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 39, 26);
		contentPanel.add(menuBar);
		
		JMenu menu = new JMenu("\u8FD4\u56DE");
		menu.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LoginFrame LF = new LoginFrame();
				LF.setLocation(600, 300);
				LF.setVisible(true);
			}
		});
		menuBar.add(menu);
	}
}
