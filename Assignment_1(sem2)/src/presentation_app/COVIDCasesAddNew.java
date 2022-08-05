package presentation_app;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import data.TextFileIO;

import java.util.Date;
import java.util.Calendar;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;


public class COVIDCasesAddNew extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtNameCity;
	private JTextField txtNumberCases;
	private JTextField txtNumberDeaths;
	private JTextField txtNumberCasesRecovered;

	public COVIDCasesAddNew() {
		
		setResizable(false);		
		setFont(new Font("Dialog", Font.BOLD, 25));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Adding New Cases of COVID-19");
		setBounds(500, 300, 599, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblDateOfReported = new JLabel("Date of reported: ");
		lblDateOfReported.setForeground(new Color(0, 139, 139));
		lblDateOfReported.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblDateOfReported.setBounds(39, 135, 240, 30);
		getContentPane().add(lblDateOfReported);
		
		JSpinner spinDate=new JSpinner();
		spinDate.setModel(new SpinnerDateModel(new Date(1614331585698L), null, null, Calendar.DAY_OF_WEEK_IN_MONTH));
		spinDate.setEditor(new JSpinner.DateEditor(spinDate, "MM/dd/yyyy"));
		spinDate.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		spinDate.setModel(new SpinnerDateModel(new Date(1613941200000L), null, null, Calendar.DAY_OF_WEEK_IN_MONTH));
		spinDate.setBounds(337, 134, 235, 36);
		getContentPane().add(spinDate);
		
		JLabel lblNameCity = new JLabel("Name of City: ");
		lblNameCity.setForeground(new Color(0, 139, 139));
		lblNameCity.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNameCity.setBounds(39, 195, 200, 30);
		contentPane.add(lblNameCity);
		
		txtNameCity = new JTextField();
		txtNameCity.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		txtNameCity.setPreferredSize(new Dimension(30, 20));
		txtNameCity.setBounds(337, 197, 235, 35);
		contentPane.add(txtNameCity);
		txtNameCity.setColumns(10);
		
		JLabel lblNumberCases = new JLabel("Number of Cases: ");
		lblNumberCases.setForeground(new Color(0, 139, 139));
		lblNumberCases.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNumberCases.setBounds(39, 254, 240, 30);
		contentPane.add(lblNumberCases);
		
		txtNumberCases = new JTextField();
		txtNumberCases.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		txtNumberCases.setPreferredSize(new Dimension(30, 20));
		txtNumberCases.setColumns(10);
		txtNumberCases.setBounds(457, 256, 115, 35);
		contentPane.add(txtNumberCases);
		
		JLabel lblNumberDeaths = new JLabel("Number of Deaths: ");
		lblNumberDeaths.setForeground(new Color(0, 139, 139));
		lblNumberDeaths.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNumberDeaths.setBounds(39, 319, 240, 30);
		contentPane.add(lblNumberDeaths);
		
		txtNumberDeaths = new JTextField();
		txtNumberDeaths.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		txtNumberDeaths.setPreferredSize(new Dimension(30, 20));
		txtNumberDeaths.setColumns(10);
		txtNumberDeaths.setBounds(457, 319, 115, 35);
		contentPane.add(txtNumberDeaths);
		
		JLabel lblText = new JLabel("Please, fill out the information:");
		lblText.setForeground(new Color(105, 105, 105));
		lblText.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblText.setBounds(29, 46, 543, 33);
		contentPane.add(lblText);
		
		JLabel lblNumberCasesRecovered = new JLabel("Number of Cases Recovered: ");
		lblNumberCasesRecovered.setForeground(new Color(0, 139, 139));
		lblNumberCasesRecovered.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNumberCasesRecovered.setBounds(39, 381, 352, 30);
		
		contentPane.add(lblNumberCasesRecovered);
		
		txtNumberCasesRecovered = new JTextField();
		txtNumberCasesRecovered.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		txtNumberCasesRecovered.setPreferredSize(new Dimension(30, 20));
		txtNumberCasesRecovered.setColumns(10);
		txtNumberCasesRecovered.setBounds(457, 383, 115, 35);
		contentPane.add(txtNumberCasesRecovered);
		
		JButton btnSaveInfo = new JButton("Save Info");
		btnSaveInfo.addActionListener(new ActionListener() {
			int totalCases = 0;
			int totalDeaths = 0;
			int totalRecover = 0;
			
			public void actionPerformed(ActionEvent e) {
				Date date = (Date) spinDate.getValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat ("MM/dd/yyyy");
				
				if(Validator.isCityPresent(txtNameCity, "Name of City")) {
				String nameCity = txtNameCity.getText();
				
				if(Validator.isNumberCases(txtNumberCases, "Number of Cases ")) {
				int numberCases = Integer.parseInt(txtNumberCases.getText());
				
				if(Validator.isNumberDeaths(txtNumberDeaths, "Number of Deaths ")) {
				int numberDeaths = Integer.parseInt(txtNumberDeaths.getText());
				
				if(Validator.isNumberCasesRecovered(txtNumberCasesRecovered, "Number of Cases Recovered  ")) {
				int numberCasesRecovered = Integer.parseInt(txtNumberCasesRecovered.getText());
					
				JOptionPane.showMessageDialog(null, "You enter the following information:\n" + 
						"Date of reported      - " + dateFormat.format(date) + "\n"+ 
						"Name of the City      - " + nameCity + "\n" +  
						"Number of Cases       - " + numberCases + "\n" + 
						"Number of Deaths      - " + numberDeaths + "\n" + 
						"Number of Recovered - " + numberCasesRecovered, "Entering information", JOptionPane.INFORMATION_MESSAGE);
				
				totalCases = Integer.parseInt(txtNumberCases.getText());
				totalDeaths = Integer.parseInt(txtNumberDeaths.getText());
				totalRecover = Integer.parseInt(txtNumberCasesRecovered.getText());
				
			
			try {
				TextFileIO.writeCases(date, nameCity, numberCases, numberDeaths, numberCasesRecovered);				
				JOptionPane.showMessageDialog(null, "Data saved");
				}catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Error!" + e1.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
			}
			}
			}
			
		});
		
		btnSaveInfo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSaveInfo.setBounds(223, 487, 144, 41);
		contentPane.add(btnSaveInfo);
	}
}
