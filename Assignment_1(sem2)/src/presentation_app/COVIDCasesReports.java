package presentation_app;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;

import data.TextFileIO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class COVIDCasesReports extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtEnteringText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtTotalCases;
	private JTextField txtTotalDeaths;
	private JTextField txtTotalRecovered;
	
	public COVIDCasesReports() {
		setResizable(false);
		setFont(new Font("Dialog", Font.BOLD, 25));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 300, 800, 600);
		getContentPane().setBackground(new Color(240, 255, 255));
		setTitle("Generation Reports COVID-19");	
		getContentPane().setLayout(null);
		
	
		JRadioButton rdbAllRecords = new JRadioButton("All Records");
		rdbAllRecords.setSelected(true);
		buttonGroup.add(rdbAllRecords);
		rdbAllRecords.setBackground(new Color(240, 255, 255));
		rdbAllRecords.setForeground(new Color(0, 139, 139));
		rdbAllRecords.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbAllRecords.setBounds(34, 65, 164, 23);
		getContentPane().add(rdbAllRecords);
		
		JRadioButton rdbRecordsCity = new JRadioButton("City Name");
		rdbRecordsCity.setSelected(true);
		buttonGroup.add(rdbRecordsCity);
		rdbRecordsCity.setForeground(new Color(0, 139, 139));
		rdbRecordsCity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbRecordsCity.setBackground(new Color(240, 255, 255));
		rdbRecordsCity.setBounds(34, 104, 164, 23);
		getContentPane().add(rdbRecordsCity);
		
		JRadioButton rdbDate = new JRadioButton("Date");
		rdbDate.setSelected(true);
		buttonGroup.add(rdbDate);
		rdbDate.setForeground(new Color(0, 139, 139));
		rdbDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbDate.setBackground(new Color(240, 255, 255));
		rdbDate.setBounds(34, 146, 164, 23);
		getContentPane().add(rdbDate);
		
		txtEnteringText = new JTextField();
		txtEnteringText.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		txtEnteringText.setBounds(276, 65, 483, 34);
		getContentPane().add(txtEnteringText);
		txtEnteringText.setColumns(10);
		
		
		JLabel lblText = new JLabel("COVID-19 Cases Reports:");
		lblText.setForeground(new Color(105, 105, 105));
		lblText.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblText.setBounds(34, 11, 699, 43);
		getContentPane().add(lblText);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtArea.setBounds(10, 176, 764, 268);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		panel.setBounds(10, 176, 764, 268);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrpane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrpane);
		getContentPane().add(panel);
		
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbAllRecords.isSelected()) {
					TextFileIO file = new TextFileIO();
					try {
						txtArea.setText(TextFileIO.readCases());
						txtTotalCases.setText(TextFileIO.displayCasesTotal("cases.txt"));
						txtTotalDeaths.setText(TextFileIO.displayCasesDeaths("cases.txt"));
						txtTotalRecovered.setText(TextFileIO.displayCasesRecovered("cases.txt"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
				if(rdbRecordsCity.isSelected()) {
					txtArea.setText("");
					if(Validator.isOptionCity(txtEnteringText, "City ")) {
					TextFileIO file = new TextFileIO();
					try {
						String name = txtEnteringText.getText().toString();					
						txtArea.setText(TextFileIO.findCasesCity("cases.txt", name));
						txtTotalCases.setText(TextFileIO.findCasesCityTotal("cases.txt", name));
						txtTotalDeaths.setText(TextFileIO.findCasesCityDeaths("cases.txt", name));
						txtTotalRecovered.setText(TextFileIO.findCasesCityRecovered("cases.txt", name));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
   
					}			
				}
				
				if(rdbDate.isSelected()) {
					txtArea.setText("");
					if(Validator.isOptionDate(txtEnteringText, "Date ")) {
					TextFileIO file = new TextFileIO();
				    try {
				    	String date = txtEnteringText.getText().toString();
				    	txtArea.setText(file.findCasesDate("cases.txt", date));
						txtTotalCases.setText(TextFileIO.findCasesDateTotal("cases.txt", date));
						txtTotalDeaths.setText(TextFileIO.findCasesDateDeaths("cases.txt", date));
						txtTotalRecovered.setText(TextFileIO.findCasesDateRecovered("cases.txt", date));
				    	
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		 
					}
				}	
			}
		
		});
		
		btnGenerate.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnGenerate.setBounds(430, 124, 153, 41);
		getContentPane().add(btnGenerate);
		
		JLabel lblTotalCases = new JLabel("Total Number of Cases: ");
		lblTotalCases.setForeground(new Color(0, 128, 128));
		lblTotalCases.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotalCases.setBounds(146, 455, 227, 23);
		getContentPane().add(lblTotalCases);
		
		JLabel lblTotalDeaths = new JLabel("Total Number of Deaths: ");
		lblTotalDeaths.setForeground(new Color(0, 128, 128));
		lblTotalDeaths.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotalDeaths.setBounds(146, 489, 240, 23);
		getContentPane().add(lblTotalDeaths);
		
		JLabel lblTotalRecovered = new JLabel("Total Number of Recovered: ");
		lblTotalRecovered.setForeground(new Color(0, 128, 128));
		lblTotalRecovered.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotalRecovered.setBounds(146, 523, 267, 23);
		getContentPane().add(lblTotalRecovered);
			
		txtTotalCases = new JTextField();
		txtTotalCases.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTotalCases.setBackground(new Color(224, 255, 255));
		txtTotalCases.setEditable(false);
		txtTotalCases.setBounds(469, 452, 127, 23);
		getContentPane().add(txtTotalCases);
		txtTotalCases.setColumns(10);
		
		txtTotalDeaths = new JTextField();
		txtTotalDeaths.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTotalDeaths.setBackground(new Color(224, 255, 255));
		txtTotalDeaths.setEditable(false);
		txtTotalDeaths.setColumns(10);
		txtTotalDeaths.setBounds(469, 489, 127, 23);
		getContentPane().add(txtTotalDeaths);
		
		txtTotalRecovered = new JTextField();
		txtTotalRecovered.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTotalRecovered.setBackground(new Color(224, 255, 255));
		txtTotalRecovered.setEditable(false);
		txtTotalRecovered.setColumns(10);
		txtTotalRecovered.setBounds(469, 523, 127, 23);
		getContentPane().add(txtTotalRecovered);
	}
}
