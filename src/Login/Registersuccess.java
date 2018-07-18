package Login;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registersuccess extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registersuccess dialog = new Registersuccess();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocation(650, 320);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registersuccess() {
		setTitle("\u7F8E\u5986\u5546\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(100, 100, 397, 257);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\u6CE8\u518C\u6210\u529F\uFF01");
			label.setFont(new Font("ËÎÌו", Font.PLAIN, 25));
			label.setBounds(137, 95, 125, 44);
			contentPanel.add(label);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\logo - \u526F\u672C (2).png"));
		lblNewLabel.setBounds(88, 13, 200, 69);
		contentPanel.add(lblNewLabel);
		JButton returnButton = new JButton("\u8FD4\u56DE\u767B\u5F55\u754C\u9762");
		returnButton.setBounds(137, 152, 123, 27);
		contentPanel.add(returnButton);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				dispose();
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setLocation(600,300);
				loginFrame.setSize(730, 500);
				loginFrame.setVisible(true);
			}
		});
		returnButton.setActionCommand("OK");
		getRootPane().setDefaultButton(returnButton);
	}
}
