package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import presentation_app.COVIDCasesReports;

public class TextFileIO {
	
	static java.io.File myFile = new java.io.File("cases.txt");

	//Write to file
	public static void writeCases(Date date, String city, int numbCases, int numbDeaths, int numbRecovered) throws IOException {
		try(PrintWriter writer = new PrintWriter(new FileWriter(myFile,true))) {		
			Date dateNew = date;
			SimpleDateFormat dateFormat = new SimpleDateFormat ("MM/dd/yyyy");	
			writer.print("Date:" + dateFormat.format(dateNew)+"; ");
			writer.print("City:" + city + "; ");
			writer.print("Cases:" + numbCases + "; ");
			writer.print("Death:" + numbDeaths + "; ");
			writer.println("Recovered:" + numbRecovered);			
		} 
	}
	
	//Read from file
	public  static String readCases() throws IOException {			 
		 FileReader fr = new FileReader(myFile);
		 BufferedReader br = new BufferedReader(fr);
		 StringBuilder outputTextArea = new StringBuilder();
		 String line;
		 	while ((line = br.readLine()) != null) {
		 		outputTextArea.append(line + "\n");
		    }		
		 br.close();
	     fr.close();
		 return outputTextArea.toString();
	}
		
	//FINDING CASES (City)
	public static String findCasesCity(String myFile, String city) throws FileNotFoundException {			
		Scanner scan = new Scanner(new File(myFile));
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();
		if(line.contains(city)) {		
			output += line + "\n";
		}		
	}
		return output;
	}
			
	//FINDING CASES(Date)
	public static String findCasesCityTotal(String myFile, String city) throws FileNotFoundException {			
		Scanner scan = new Scanner(new File(myFile));
		int total = 0;
		String str = "";
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();	
		if(line.contains(city)) {
			 String[] words = line.split(";");
   				output = words[2];
   			    String[] numCases = output.split(":");
				total += Integer.parseInt(numCases[1]);
				str = String.valueOf(total);	
		 }	
	}
		return str;		
    }
	
	//DISPLAY Total cases, deaths, recovered(City)
	public static String findCasesCityDeaths(String myFile, String city) throws FileNotFoundException {			
		Scanner scan = new Scanner(new File(myFile));
		int total = 0;
		String str = "";
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();	
		if(line.contains(city)) {
			 String[] words = line.split(";");
   				output = words[3];
   			    String[] numCases = output.split(":");
				total += Integer.parseInt(numCases[1]);
				str = String.valueOf(total);	
		}	
	}
		return str;		
	}
	public static String findCasesCityRecovered(String myFile, String city) throws FileNotFoundException {			
		Scanner scan = new Scanner(new File(myFile));
		int total = 0;
		String str = "";
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();	
		if(line.contains(city)) {
			 String[] words = line.split(";");
   				output = words[4];
   			    String[] numCases = output.split(":");
				total += Integer.parseInt(numCases[1]);
				str = String.valueOf(total);	
		}	
	}
		return str;		
	}
	
	public static String findCasesDate(String myFile, String date) throws FileNotFoundException {			
		Scanner scan = new Scanner(new File(myFile));
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();
		if(line.contains(date)) {		
			output += line + "\n";
		}		
	}
		return output;
    }
	
	//DISPLAY Total cases, deaths, recovered(Date)
	public static String findCasesDateTotal(String myFile, String date) throws FileNotFoundException {			
		Scanner scan = new Scanner(new File(myFile));
		int total = 0;
		String str = "";
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();	
		if(line.contains(date)) {
			 String[] words = line.split(";");
   				output = words[2];
   			    String[] numCases = output.split(":");
				total += Integer.parseInt(numCases[1]);
				str = String.valueOf(total);	
		}	
	}
		return str;	
	}
	public static String findCasesDateDeaths(String myFile, String date) throws FileNotFoundException {			
		Scanner scan = new Scanner(new File(myFile));
		int total = 0;
		String str = "";
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();	
		if(line.contains(date)) {
			 String[] words = line.split(";");
   				output = words[3];
   			    String[] numCases = output.split(":");
				total += Integer.parseInt(numCases[1]);
				str = String.valueOf(total);	
		}	
	}
		return str;	
	}
	
	public static String findCasesDateRecovered(String myFile, String date) throws FileNotFoundException {			
		Scanner scan = new Scanner(new File(myFile));
		int total = 0;
		String str = "";
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();	
		if(line.contains(date)) {
			 String[] words = line.split(";");
   				output = words[4];
   			    String[] numCases = output.split(":");
				total += Integer.parseInt(numCases[1]);
				str = String.valueOf(total);	
		}	
	}
		return str;	
	}
	
	public  static String displayCasesTotal(String myFile) throws FileNotFoundException {			 
		Scanner scan = new Scanner(new File(myFile));
		int total = 0;
		String str = "";
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();	
			 String[] words = line.split(";");
   				output = words[2];
   			    String[] numCases = output.split(":");
				total += Integer.parseInt(numCases[1]);
				str = String.valueOf(total);			
		}
		return str;
	}	
	
	public  static String displayCasesDeaths(String myFile) throws FileNotFoundException {			 
		Scanner scan = new Scanner(new File(myFile));
		int total = 0;
		String str = "";
		String output = "";
		while(scan.hasNext()) {
		String line = scan.nextLine();	
			 String[] words = line.split(";");
   				output = words[3];
   			    String[] numCases = output.split(":");
						total += Integer.parseInt(numCases[1]);
						str = String.valueOf(total);					
		}
		return str;
	}
	
	public  static String displayCasesRecovered(String myFile) throws FileNotFoundException {			 
		Scanner scan = new Scanner(new File(myFile));
		int total = 0;
		String str = "";
	String output = "";
	while(scan.hasNext()) {
	String line = scan.nextLine();	
		 String[] words = line.split(";");
			output = words[4];
		    String[] numCases = output.split(":");
					total += Integer.parseInt(numCases[1]);
					str = String.valueOf(total);				
		}
		return str;
	}
}