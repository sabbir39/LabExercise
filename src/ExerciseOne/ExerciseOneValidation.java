package ExerciseOne;

import java.util.ArrayList;

public class ExerciseOneValidation {
	public ExerciseOneValidation() {

	}

	public boolean isCorrectTAN(String tan) {
		if (tan.startsWith("T") || tan.startsWith("t")) {
			if (tan.length() == 9) {
				return true;
			} else {
				System.out.println("Please provide a valide TAN");
				return false;
			}
		} else {
			if (tan.length() == 8) {
				return true;
			} else {
				System.out.println("Please provide a valide TAN");
				return false;
			}
		}
	}

	public boolean isValidTAN(String tan, ArrayList<TrustReturn> list) {

		if (isCorrectTAN(tan)) {
			if ((tan.length() == 9)) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getTan().equalsIgnoreCase(tan)) {
						System.out.println("TAN is already exist in the list");
						return false;
					} else if ((list.get(i).getTan().length() == 8)
							&& (list.get(i).getTan().equalsIgnoreCase(tan.substring(1)))) {
						System.out.println("TAN is already exist in the list");
						return false;
					}
				}
				return true;
			} else {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getTan().equalsIgnoreCase(tan)) {
						System.out.println("TAN is already exist in the list");
						return false;
					} else if ((list.get(i).getTan().length() == 9)
							&& (list.get(i).getTan().equalsIgnoreCase("t" + tan))) {
						System.out.println("TAN is already exist in the list");
						return false;
					}
				}
				return true;
			}

		} else {
			System.out.println("Invalid tan");
			return false;
		}
	}

	public boolean isValidProvience(String provience) {
		if (provience.equalsIgnoreCase("select")) {
			// JOptionPane.showMessageDialog(null, "Please select a province");
			System.out.println("Please select a province");
			return false;
		}
		return true;
	}

	public boolean isEmpty(String str) {
		return str.isEmpty() ? true : false;
	}

	public boolean isValidCity(String city) {
		return city.isEmpty() ? false : true;
	}

	public boolean isValidNOT(String not) {
		return not.isEmpty() ? false : true;
	}

	public boolean isValidPensionIncome(String pensionIncome) {
		if (!pensionIncome.isEmpty() && isNumeric(pensionIncome) && !isNegative(pensionIncome)) {
			return true;
		}
		// JOptionPane.showMessageDialog(null,"Invalid pension income, it should be non
		// negative numeric only");
		System.out.println("Invalid pension income, it should be non negative numeric only");
		return false;
	}

	public boolean isValidRentalIncome(String rentalIncome) {
		if (!rentalIncome.isEmpty() && isNumeric(rentalIncome) && !isNeg(rentalIncome)) {
			return true;
		}
		// JOptionPane.showMessageDialog(null,"Invalid rental income, it should be non
		// negative numeric only");
		System.out.println("Invalid rental income, it should be non negative numeric only");
		return false;
	}

	private boolean isNegative(String str) {
		return str.startsWith("-") ? true : false;
	}

	private boolean isNeg(String str) {
		double res;
		try {
			res = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return true;
		}
		if (res < 0)
			return true;
		return false;
	}

	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
//if (list.stream().filter(p -> p.getTan().equalsIgnoreCase(tan)).findFirst().isPresent()) {
//JOptionPane.showMessageDialog(null, "Duplicate TAN");
//System.out.println("TAN is already exist in the list");
//return false;
//} else {
//return true;
//}
