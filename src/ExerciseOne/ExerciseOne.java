package ExerciseOne;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class ExerciseOne {

	private JFrame frame;
	private JTextField txtTan;
	private JTextField txtPi;
	private JTextField txtRi;
	private JTextField txtCity;
	private JTextField txtNot;
	private JComboBox<String> cmbProvience;
	private ArrayList<TrustReturn> myList = new ArrayList<TrustReturn>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExerciseOne window = new ExerciseOne();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExerciseOne() {
		readFile();
		initialize();
	}

	private void readFile() {
		File outputFile = new File("output.txt");
		boolean exists = outputFile.exists();
		if (!exists) {
			return;
		} 
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("No such file exist");
		}
		try {
			String line = br.readLine();

			while (line != null) {
				loadIntoList(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("No such element in file");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("No file found");
			}
		}
		File backupFile = new File("output_bak.txt");
		outputFile.renameTo(backupFile);
	}
	
	private void loadIntoList(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		String tan = null;
		double pi = 0.0;
		double ri = 0.0;
		String city = null;
		String not = null;
		String provience = null;
		while (st.hasMoreTokens()) {
			String tmpStr = st.nextToken();
			if (tmpStr.startsWith("tan=")) {
				tan = tmpStr.substring(4);
			} else if (tmpStr.startsWith(" pi=")) {
				pi = Double.parseDouble(tmpStr.substring(4));
			} else if (tmpStr.startsWith(" ri=")) {
				ri = Double.parseDouble(tmpStr.substring(4));
			} else if (tmpStr.startsWith(" city=")) {
				city = tmpStr.substring(6);
			} else if (tmpStr.startsWith(" not=")) {
				not = tmpStr.substring(5);
			} else if (tmpStr.startsWith(" provience=")) {
				provience = tmpStr.substring(11);
			}
		}
		myList.add(new TrustReturn(tan,pi,ri,city,not,provience));
		System.out.println(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTan = new JLabel("TAN");
		lblTan.setBounds(31, 65, 46, 14);
		frame.getContentPane().add(lblTan);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(31, 90, 46, 14);
		frame.getContentPane().add(lblCity);

		JLabel lblPi = new JLabel("PI");
		lblPi.setBounds(31, 122, 46, 14);
		frame.getContentPane().add(lblPi);

		JLabel lblRi = new JLabel("RI");
		lblRi.setBounds(31, 147, 46, 14);
		frame.getContentPane().add(lblRi);

		txtTan = new JTextField();
		txtTan.setBounds(78, 62, 117, 20);
		frame.getContentPane().add(txtTan);
		txtTan.setColumns(10);

		txtPi = new JTextField();
		txtPi.setBounds(78, 119, 117, 20);
		frame.getContentPane().add(txtPi);
		txtPi.setColumns(10);

		txtRi = new JTextField();
		txtRi.setBounds(78, 147, 117, 20);
		frame.getContentPane().add(txtRi);
		txtRi.setColumns(10);

		txtCity = new JTextField();
		txtCity.setBounds(78, 90, 117, 20);
		frame.getContentPane().add(txtCity);
		txtCity.setColumns(10);

		JLabel lblNot = new JLabel("NOT");
		lblNot.setBounds(230, 65, 46, 14);
		frame.getContentPane().add(lblNot);

		txtNot = new JTextField();
		txtNot.setBounds(296, 62, 111, 20);
		frame.getContentPane().add(txtNot);
		txtNot.setColumns(10);

		JLabel lblProvince = new JLabel("Province");
		lblProvince.setBounds(230, 93, 67, 14);
		frame.getContentPane().add(lblProvince);

		cmbProvience = new JComboBox<String>();
		cmbProvience.setBounds(296, 86, 111, 22);

		cmbProvience.addItem("Select");
		cmbProvience.addItem("ON");
		cmbProvience.addItem("BC");
		cmbProvience.addItem("SK");
		cmbProvience.addItem("AB");
		cmbProvience.addItem("MB");
		cmbProvience.addItem("QB");
		cmbProvience.addItem("NS");
		cmbProvience.addItem("PEI");
		cmbProvience.addItem("NB");
		cmbProvience.addItem("NL");
		frame.getContentPane().add(cmbProvience);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String tan = txtTan.getText();
				String pi = txtPi.getText();
				String ri = txtRi.getText();
				String city = txtCity.getText();
				String not = txtNot.getText();
				String provience = cmbProvience.getSelectedItem().toString();
				if (processReturn(tan, pi, ri, city, not, provience)) {
					System.out.println("Return processed successfully for TAN:" + tan);
					showResult();
				} else {
					System.out.println("Return  cannot be processed (validation error) for TAN:" + tan);
				}
			}
		});

		btnSubmit.setBounds(78, 198, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					saveToFile();
					System.exit(0);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(208, 198, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

	private boolean processReturn(String tan, String pi, String ri, String city, String not, String provience) {
		ExerciseOneValidation validation = new ExerciseOneValidation();

		if (validation.isValidProvience(provience)
				&& validation.isValidTAN(tan, myList) && validation.isValidPensionIncome(pi)
				&& validation.isValidRentalIncome(ri) && !validation.isEmpty(city) && !validation.isEmpty(not)) {
			System.out.println("All validation passed");
			JOptionPane.showMessageDialog(null, "validation passed");

			TrustReturn trustAccount = new TrustReturn(tan, Double.parseDouble(pi), Double.parseDouble(ri), city, not,
					provience);
			myList.add(trustAccount);
			return true;
		} else {
			System.out.println("Validation Failed");
			JOptionPane.showMessageDialog(null, "validation failed");
			return false;
		}
	}

	private void showResult() {
		for (TrustReturn p : myList) {
			System.out.println(p);
		}
	}
	
	private void saveToFile() throws IOException {
		
		FileWriter writer = new FileWriter("output.txt"); 
		for (TrustReturn p : myList) {
		  writer.write(p.toWriteFile() + System.lineSeparator());
		}
		writer.close();
		File needToDelete = new File("output_bak.txt");
		if(needToDelete.delete()) {
			System.out.println("Cleaned up");
		}
	}
}
