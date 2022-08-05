package presentation_app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class COVIDCasesHelp extends JFrame {

	private JPanel contentPane;

	public COVIDCasesHelp() {
		
		setResizable(false);	
		setTitle("COVID Cases HELP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 481, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblText = new JLabel("COVID Cases Help");
		lblText.setForeground(new Color(105, 105, 105));
		lblText.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblText.setBounds(10, 11, 283, 28);
		contentPane.add(lblText);
		
		JTextPane txtpnMenuDriventier = new JTextPane();
		txtpnMenuDriventier.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnMenuDriventier.setBackground(new Color(240, 255, 255));
		txtpnMenuDriventier.setText("The program is the menu driven 3-tier GUI application, to manage record of daily covid-19 data for the province of Ontario using the text file.");
		txtpnMenuDriventier.setBounds(10, 61, 423, 58);
		contentPane.add(txtpnMenuDriventier);
		
		JTextPane txtpnDateOf = new JTextPane();
		txtpnDateOf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnDateOf.setBackground(new Color(240, 255, 255));
		txtpnDateOf.setText("Date of reporting \u2013 It is required field and should be in mm/dd/yyyy format. This refers to the date of the data reported by the city.");
		txtpnDateOf.setBounds(10, 130, 423, 58);
		contentPane.add(txtpnDateOf);
		
		JTextPane txtpnNameOfCity = new JTextPane();
		txtpnNameOfCity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnNameOfCity.setBackground(new Color(240, 255, 255));
		txtpnNameOfCity.setText("Name of city \u2013 This is also required field and is of string type.");
		txtpnNameOfCity.setBounds(10, 215, 423, 28);
		contentPane.add(txtpnNameOfCity);
		
		JTextPane txtpnNumberOfCases = new JTextPane();
		txtpnNumberOfCases.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnNumberOfCases.setBackground(new Color(240, 255, 255));
		txtpnNumberOfCases.setText("Number of cases \u2013 The value for this should be 0 or above.");
		txtpnNumberOfCases.setBounds(10, 257, 423, 28);
		contentPane.add(txtpnNumberOfCases);
		
		JTextPane txtpnNumberOfDeaths = new JTextPane();
		txtpnNumberOfDeaths.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnNumberOfDeaths.setBackground(new Color(240, 255, 255));
		txtpnNumberOfDeaths.setText("Number of deaths \u2013 The value for this should be 0 or above.");
		txtpnNumberOfDeaths.setBounds(10, 303, 423, 28);
		contentPane.add(txtpnNumberOfDeaths);
		
		JTextPane txtpnNumberOfCases_1 = new JTextPane();
		txtpnNumberOfCases_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnNumberOfCases_1.setBackground(new Color(240, 255, 255));
		txtpnNumberOfCases_1.setText("Number of cases recovered \u2013 The value for this should be 0 or above.");
		txtpnNumberOfCases_1.setBounds(10, 344, 423, 28);
		contentPane.add(txtpnNumberOfCases_1);
		
		JButton btnExitHelp = new JButton("Exit");
		btnExitHelp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnExitHelp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExitHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExitHelp.setBounds(315, 395, 99, 34);
		contentPane.add(btnExitHelp);
	}
}
