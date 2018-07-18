package Login;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import goodsmanage.managerchoose;
import goodsmanage.goodsQuery;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Logindefault extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Logindefault dialog = new Logindefault();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocation(650,350);
			//dialog.setSize(500,300);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Logindefault() {				
		setTitle("\u7528\u6237\u63D0\u793A");
		setBounds(100, 100, 396, 223);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText("\u767B\u9646\u6210\u529F\uFF01");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton button = new JButton("\u786E\u5B9A");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    LoginFrame LF = new LoginFrame();
					LF.setLocation(600,200);	
					LF.setVisible(true);
					button.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e) {
							dispose();
						}
					});
				}
			});
			button.setBounds(305, 143, 63, 27);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel("\u767B\u9646\u5931\u8D25\uFF01\u8BF7\u91CD\u65B0\u767B\u9646\u6216\u6CE8\u518C\u5E76\u9009\u5B9A\u767B\u9646\u8EAB\u4EFD!");
			label.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
			label.setBounds(28, 30, 340, 114);
			contentPanel.add(label);
		}
	}
}
