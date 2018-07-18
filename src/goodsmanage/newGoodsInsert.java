package goodsmanage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Goods;
import utils.DBHelper;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class newGoodsInsert extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			managerchoose frame = new managerchoose();
			newGoodsInsert dialog = new newGoodsInsert(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocation(650, 300);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public newGoodsInsert(managerchoose frame) {
		setTitle("\u65B0\u5546\u54C1\u4FE1\u606F\u8F93\u5165");
		setBounds(100, 100, 494, 563);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(100, 10, 272, 72);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\logo.png"));
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5546\u54C1\u4FE1\u606F\u8F93\u5165");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(142, 76, 207, 51);
		contentPanel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(61, 331, 90, 18);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u54C1\u7C7B\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(246, 331, 90, 18);
		contentPanel.add(label_1);
		
		JLabel label_3 = new JLabel("\u5546\u54C1\u5E93\u5B58\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(246, 384, 90, 18);
		contentPanel.add(label_3);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(142, 425, 72, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(328, 383, 90, 24);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_2.setBounds(142, 330, 90, 24);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(142, 379, 86, 24);
		contentPanel.add(textField_4);
		
		JLabel label_4 = new JLabel("\u5143");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(216, 426, 23, 23);
		contentPanel.add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u9762\u971C", "\u4E73\u6DB2", "\u6D01\u9762", "\u9762\u819C", "\u7CBE\u534E", "\u5316\u5986\u6C34", "\u9632\u6652\u971C", "\u53BB\u89D2\u8D28"}));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setBounds(328, 327, 78, 27);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 479, 479, 37);
			contentPanel.add(buttonPane);
			DBHelper dbHelper = new DBHelper();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton submitButton = new JButton("\u786E\u5B9A");
				submitButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
																		
						String category = (String) comboBox.getSelectedItem();
						String new_goodsID = (String) textField_4.getText();
						String new_goodsBrand = (String) textField_2.getText();						
						int new_goodsStorage = Integer.parseInt(textField_1.getText());
						int new_goodsSell = 0;
						String new_goodsPrice = textField.getText();
						DBHelper dbHelper = new DBHelper();
						dbHelper.insertgoods(new_goodsID, new_goodsBrand, category, new_goodsPrice, new_goodsSell, new_goodsStorage);
																	
						dispose();
						managerchoose mc = new managerchoose();
						mc.setLocation(600, 350);
						mc.setVisible(true);
					}
				});
				submitButton.setActionCommand("OK");
				buttonPane.add(submitButton);
				getRootPane().setDefaultButton(submitButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						managerchoose mc = new managerchoose();
						mc.setLocation(600, 300);
						mc.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u4EF7\u683C\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(61, 426, 90, 18);
		contentPanel.add(label_2);
		
		JLabel lblid = new JLabel("\u5546\u54C1ID:");
		lblid.setFont(new Font("宋体", Font.PLAIN, 16));
		lblid.setBounds(61, 384, 72, 18);
		contentPanel.add(lblid);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\519f164878fb6.jpg"));
		lblNewLabel_2.setBounds(127, 129, 224, 189);
		contentPanel.add(lblNewLabel_2);
		
	
		

	}
}
