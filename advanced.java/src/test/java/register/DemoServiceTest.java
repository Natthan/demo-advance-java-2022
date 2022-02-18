package register;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DemoServiceTest {
	
	@Test
	void case_1_shoud_get_2( ) {
		DB db = new DBX();
		DemoService demoService = new DemoService(db); // Constructor inject
		String actualResult = demoService.compute(1);
		assertEquals("Result = 2", actualResult);
	}
}

class DBX extends DB {
	@Override
    int increaseOne(int id) {
        return 2;
    }
}
