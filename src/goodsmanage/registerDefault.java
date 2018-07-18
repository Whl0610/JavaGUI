package goodsmanage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginRegister;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registerDefault extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			registerDefault dialog = new registerDefault();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public registerDefault() {
		setTitle("\u7528\u6237\u63D0\u793A");
		setBounds(100, 100, 244, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setBounds(14, 13, 200, 52);
			label.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\logo - \u526F\u672C (2).png"));
			contentPanel.add(label);
		}
		{
			JButton okButton = new JButton("\u8FD4\u56DE\u91CD\u65B0\u6CE8\u518C");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					LoginRegister LR = new LoginRegister();
					LR.setLocation(600, 300);
					LR.setVisible(true);
				}
			});
			okButton.setBounds(49, 147, 123, 27);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JLabel label = new JLabel("\u7528\u6237\u540D\u5DF2\u88AB\u6CE8\u518C\uFF01");
			label.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
			label.setBounds(40, 94, 144, 18);
			contentPanel.add(label);
		}
	}

}
