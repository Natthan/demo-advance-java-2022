package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.reporting.ReportEntry;

public class RegisterBusinessTest {
	
	@Test
	@DisplayName("ข้อมูล speaker = null จะโยน runtime exception กลับมา " +
            "พร้อมกับ message Speaker is null")
	public void case01() {
		RegisterBusiness business = new RegisterBusiness();
		
		// Assert exception with JUnit 5 ?
        Exception exception = assertThrows(RuntimeException.class, () -> {
            business.register(null, null);
        });
        assertEquals("Speaker is null", exception.getMessage());
	}
	
	@Test
    @DisplayName("First name = null ดังนั้นจะโยน ArgumentNullException ออกมา " +
            "พร้อมกับคำว่า First name is required.")
    public void case02() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, new Speaker());
        });
        assertEquals("First name is required.", exception.getMessage());
    }
	
	@Test
    @DisplayName("Last name = null ดังนั้นจะโยน ArgumentNullException ออกมา " +
            "พร้อมกับคำว่า Last name is required.")
    public void case03() {
        RegisterBusiness business = new RegisterBusiness();
        
        Speaker speaker = new Speaker();
    	speaker.setFirstName("Natthan");
        
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Last name is required.", exception.getMessage());
    }
	
	@Test
    @DisplayName("Email = null ดังนั้นจะโยน ArgumentNullException ออกมา " +
            "พร้อมกับคำว่า Email is required.")
    public void case04() {
        RegisterBusiness business = new RegisterBusiness();
        
        Speaker speaker = new Speaker();
    	speaker.setFirstName("Natthan");
    	speaker.setLastName("Thiraphap");
        
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Email is required.", exception.getMessage());
    }
	
	@Test
    @DisplayName("กรอกรูปแบบ Email ไม่ถูกต้อง ดังนั้นจะโยน SpeakerDoesntMeetRequirementsException ออกมา " +
            "พร้อมกับคำว่า Speaker doesn't meet our standard rules.")
    public void case05() {
        RegisterBusiness business = new RegisterBusiness();
        
        Speaker speaker = new Speaker();
    	speaker.setFirstName("Natthan");
    	speaker.setLastName("Thiraphap");
    	speaker.setEmail("natthan.t@example.com");
        
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }
	
	@Test
    @DisplayName("")
    public void case06() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Somkiat");
        speaker.setLastName("Pui");
        speaker.setEmail("somkiat@xyz.com");
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    @DisplayName("")
    public void case07() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Somkiat");
        speaker.setLastName("Pui");
        speaker.setEmail("somkiat@gmail.com");
        Exception exception = assertThrows(SaveSpeakerException.class, () -> {
            business.register(null, speaker);
        });
        assertEquals("Can't save a speaker.", exception.getMessage());
    }
}
