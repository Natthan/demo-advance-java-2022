package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RegisterFeeBusinessTest {

	@ParameterizedTest
	@CsvSource({
		"0,500",
		"1,500",
		"2,250",
		"5,100",
		"9,50",
		"10,0",
	})
	void getFee(int expYear, int expectedFee) {
		RegisterBusiness buiBusiness = new RegisterBusiness();
		int actualFee = buiBusiness.getFee(expYear);
		assertEquals(expectedFee, actualFee);
	}
	
}
