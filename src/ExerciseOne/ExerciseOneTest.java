package ExerciseOne;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class ExerciseOneTest {
	ExerciseOneValidation validation = new ExerciseOneValidation();
	
	@Test(enabled=true)
	private void testIsValidCity() {
		assertTrue(validation.isValidCity("abcdd"), "Not a valid city");
		assertFalse(validation.isValidCity(""), "city name is empty");
	}
	
	@Test(enabled=true)
	private void testIsValidNOT() {
		assertTrue(validation.isValidCity("abcdd"), "NOT is empty");
		assertFalse(validation.isValidCity(""), "should return false");
	}
	
	@Test(enabled=true)
	private void testIsCorrectTAN() {
		assertEquals(validation.isCorrectTAN("T12345678"), true);
		//logger.debug()
		assertEquals(validation.isCorrectTAN("1234567"), false);
		assertNotEquals(validation.isCorrectTAN("12345678"), false);
	}
	
	@Test(enabled=true)
	private void testIsValidTAN() {
		ArrayList<TrustReturn> myList = new ArrayList<TrustReturn>();
		myList.add(new TrustReturn("12345678", 432, 3234, "scar", "kdfdk", "SK"));
		assertEquals(validation.isValidTAN("T12345678", myList), false);
		assertEquals(validation.isValidTAN("12345678", myList), false);
		assertEquals(validation.isValidTAN("T12345679", myList), true);
	}
	
	@Test(enabled=true)
	private void testIsValidPI() {
		assertTrue(validation.isValidPensionIncome("1234"));
		//System.out.println();
		assertFalse(validation.isValidPensionIncome("-1234"));
		assertFalse(validation.isValidPensionIncome("-t123"));
		assertFalse(validation.isValidPensionIncome("-12er34"));
	}
	
	@Test(enabled=true)
	private void testIsValidRI() {
		assertNull(validation.isValidRentalIncome("aff"));
	}
		
}
