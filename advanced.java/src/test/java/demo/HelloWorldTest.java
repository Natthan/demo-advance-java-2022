package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
	
	@Test
	public void hi() {
		
	}
	
	@Test 
	@DisplayName("เรากำลังทดสอบเรื่องอะไร อย่างไร ต้องได้อะไร") //เป็น Annocation เพื่อเขียนอธิบาย โครงสร้างแต่ละ Test Cae เป็นอย่างไร
	public void case01() {
		// Arrange, Given
		HelloWorld helloWorld = new HelloWorld();
		// Act
		String actualResult = helloWorld.hi("Boat");
		// Assert / verify, Then
		assertEquals("Hello Boat", actualResult);
	}
}
