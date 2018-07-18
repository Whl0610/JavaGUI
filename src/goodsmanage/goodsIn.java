package goodsmanage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.JLabel;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class goodsIn extends JDialog {
	private static final Object[] DefaultTableCellRenderer = null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			goodsIn dialog = new goodsIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocation(650, 200);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public goodsIn() {
		setTitle("\u7F8E\u5986\u5546\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(100, 100, 590, 673);
		getContentPane().setLayout(null);
				
		JPanel panel = new JPanel();//表单
		//contentPanel.add(table);

		Object[] columnNames = new Object[]{"商品ID", "品牌", "品类", "数量"};//列名
		Object[][] rowData = new Object[30][4];			
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);		
		
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(137, 13, 272, 99);
			getContentPane().add(lblNewLabel);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Whl0610\\Desktop\\\u300A\u6570\u636E\u5E93\u7CFB\u7EDF\u300B\u8BFE\u7A0B\u8BBE\u8BA1\\\u7CFB\u7EDF\u7528\u56FE\\logo.png"));
		}
		
		JLabel label = new JLabel("\u5546\u54C1\u8FDB\u8D27\u5355");
		label.setBounds(217, 100, 136, 55);
		getContentPane().add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		//JTable table = null;
		
		JScrollPane jscrollpane = new JScrollPane();
		jscrollpane.setBounds(0, 156, 572, 382);
		getContentPane().add(jscrollpane);
		table = new JTable(rowData, columnNames);
		jscrollpane.setViewportView(table);
		table.setRowHeight(35);
		table.setFont(new Font("宋体", Font.PLAIN, 30));
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				goodsInSubmit gIS = new goodsInSubmit();
				gIS.setLocation(750,350);
				gIS.setVisible(true);
			}
		});
		button.setActionCommand("OK");
		button.setBounds(429, 588, 63, 27);
		getContentPane().add(button);
		{
			JButton cancelButton = new JButton("\u53D6\u6D88");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					managerchoose mc = new managerchoose();
					mc.setLocation(500, 300);
					mc.setVisible(true);
				}
			});
			cancelButton.setBounds(495, 588, 63, 27);
			getContentPane().add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		table.setDefaultRenderer(Object.class, r);
	}

private TableColumn getColumn(int i) {
		// TODO Auto-generated method stub
		return null;
	}

public class MyComboBoxRenderer extends JComboBox implements TableCellRenderer {
    public MyComboBoxRenderer(String[] items) {
        super(items);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            super.setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }

        // Select the current value
        setSelectedItem(value);
        return this;
    }
}

public class MyComboBoxEditor extends DefaultCellEditor {
    public MyComboBoxEditor(String[] items) {
        super(new JComboBox(items));
    }
}
}


	