package goodsmanage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class alterSuccess extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			alterSuccess dialog = new alterSuccess();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public alterSuccess() {
		setTitle("\u7528\u6237\u63D0\u793A");
		setBounds(100, 100, 269, 203);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("\u786E\u8BA4");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					managerchoose mc = new managerchoose();
					mc.setLocation(600, 300);
					mc.setVisible(true);
				}
			});
			okButton.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
			okButton.setBounds(87, 108, 86, 27);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel label = new JLabel("\u5546\u54C1\u5E93\u5B58\u4FE1\u606F\u4FEE\u6539\u6210\u529F\uFF01");
		label.setFont(new Font("ÐÂËÎÌå", Font.PLAIN, 17));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(14, 44, 223, 50);
		contentPanel.add(label);
	}
}
