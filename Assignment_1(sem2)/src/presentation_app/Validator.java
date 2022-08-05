package presentation_app;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class Validator {
	//City
	public static boolean isCityPresent(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage1(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	
	private static void showMessage1(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	//NumberCases
	public static boolean isNumberCases(JTextComponent c, String title ) {
		if (c.getText().length() == 0 || Integer.parseInt(c.getText())<0 )  {
			showMessage2(c, title + " should be 0 or above. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage2(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
	//number of Deaths
	public static boolean isNumberDeaths(JTextComponent c, String title) {
		if (c.getText().length() == 0 || Integer.parseInt(c.getText())<0 )  {
			showMessage3(c, title + " should be 0 or above. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage3(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
	//Number of cases recovered 
	public static boolean isNumberCasesRecovered(JTextComponent c, String title) {
		if (c.getText().length() == 0 || Integer.parseInt(c.getText())<0 )  {
			showMessage4(c, title + " should be 0 or above. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage4(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
	public static boolean isOptionCity(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage1(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	
	static void showMessage5(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
	public static boolean isOptionDate(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage1(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	
	static void showMessage6(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
}
