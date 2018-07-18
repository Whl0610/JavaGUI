package goodsmanage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.DBHelper;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class goodsDelete extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String delete_id = "";


	/**
	 * Create the dialog.
	 */
	public goodsDelete(managerchoose frame) {
		delete_id = (String) frame.deleteId;
		setTitle("\u7528\u6237\u63D0\u793A");
		setBounds(100, 100, 383, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 129, 373, 37);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("\u662F");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						deleteSuccess dS = new deleteSuccess();
						dS.setLocation(700, 450);
						dS.setVisible(true);
						DBHelper dbHelper = new DBHelper();
						dbHelper.deleteGoods(delete_id);
						setVisible(false);
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u5426");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						managerchoose mc = new managerchoose();
						mc.setLocation(550, 300);
						mc.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel label = new JLabel("\u662F\u5426\u786E\u5B9A\u5220\u9664\uFF1F");
			label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
			label.setBounds(126, 47, 150, 53);
			contentPanel.add(label);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\t016f7ec69d09fabbf3.png"));
		lblNewLabel.setBounds(65, 47, 57, 53);
		contentPanel.add(lblNewLabel);
	}
}
