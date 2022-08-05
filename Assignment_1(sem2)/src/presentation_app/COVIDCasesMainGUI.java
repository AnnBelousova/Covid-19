package presentation_app;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class COVIDCasesMainGUI extends JFrame {
	
	public COVIDCasesMainGUI() {
		getContentPane().setBackground(new Color(240, 255, 255));
		setBackground(new Color(220, 220, 220));
		setFont(new Font("Dialog", Font.BOLD, 25));
		this.initialize();
	}
	
	public void initialize() {
		this.setTitle("Daily Info COVID-19 in Ontario Main GUI");
		this.setBounds(100, 100, 692, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		JMenuBar mnuBar = new JMenuBar();
		mnuBar.setBorder(null);
		mnuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		mnuBar.setMargin(new Insets(20, 15, 20, 15));
		mnuBar.setBackground(new Color(51, 153, 153));
		setJMenuBar(mnuBar);
		
		JMenu mnuStatistics = new JMenu("Statistics");
		mnuStatistics.setPreferredSize(new Dimension(135, 40));
		mnuStatistics.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		mnuStatistics.setBorderPainted(true);
		mnuStatistics.setBackground(new Color(0, 153, 153));
		mnuStatistics.setFont(new Font("Times New Roman", Font.BOLD, 30));
		mnuBar.add(mnuStatistics);
		
		JMenuItem mnuStatItemNew = new JMenuItem("Add New");
		mnuStatItemNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				COVIDCasesAddNew covcan = new COVIDCasesAddNew();
				covcan.setVisible(true);
			}
		});
		
		mnuStatItemNew.setPreferredSize(new Dimension(135, 26));
		mnuStatItemNew.setBackground(SystemColor.activeCaption);
		mnuStatItemNew.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		mnuStatistics.add(mnuStatItemNew);
		
		JMenuItem mnuStatItemReports = new JMenuItem("Reports");
		mnuStatItemReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				COVIDCasesReports covcrep = new COVIDCasesReports();
				covcrep.setVisible(true);
			}
		});
		
		mnuStatItemReports.setBackground(SystemColor.activeCaption);
		mnuStatItemReports.setPreferredSize(new Dimension(135, 26));
		mnuStatItemReports.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		mnuStatistics.add(mnuStatItemReports);
		
		JMenu mnuHelp = new JMenu("Help");
		mnuHelp.setPreferredSize(new Dimension(90, 35));
		mnuHelp.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		mnuHelp.setBorderPainted(true);
		mnuHelp.setBackground(new Color(0, 153, 153));
		mnuHelp.setFont(new Font("Times New Roman", Font.BOLD, 30));
		mnuBar.add(mnuHelp);
		
		JMenuItem mnuHelpInstruction = new JMenuItem("Instruction");
		mnuHelpInstruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				COVIDCasesHelp help = new COVIDCasesHelp();
				help.setVisible(true);
			}
		});
		mnuHelpInstruction.setPreferredSize(new Dimension(135, 26));
		mnuHelpInstruction.setBackground(SystemColor.activeCaption);
		mnuHelpInstruction.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		mnuHelp.add(mnuHelpInstruction);
		
		JMenuBar menuBar = new JMenuBar();
		mnuBar.add(menuBar);
		getContentPane().setLayout(null);
		
		JLabel lblCaption1 = new JLabel("COVID - 19");
		lblCaption1.setForeground(Color.RED);
		lblCaption1.setFont(new Font("Times New Roman", Font.BOLD, 55));
		lblCaption1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaption1.setBounds(10, 75, 666, 79);
		getContentPane().add(lblCaption1);
		
		JLabel lblCaption2 = new JLabel("Ontario COVID-19 Data Tool");
		lblCaption2.setForeground(new Color(0, 139, 139));
		lblCaption2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblCaption2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaption2.setBounds(10, 147, 666, 97);
		getContentPane().add(lblCaption2, BorderLayout.CENTER);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(COVIDCasesMainGUI.this, "Do you want to close the app?",  "Confirmation window", JOptionPane.YES_NO_OPTION, EXIT_ON_CLOSE);
				if(option == JOptionPane.YES_OPTION) {
				System.exit(0);
				}
			}
		});
		
		btnExit.setBackground(SystemColor.scrollbar);
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnExit.setBounds(268, 262, 122, 39);
		getContentPane().add(btnExit);
	}
}
