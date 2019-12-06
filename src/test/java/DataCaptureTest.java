import model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import utils.DataCapture;
import java.time.LocalDateTime;

public class DataCaptureTest {

    @BeforeAll
    static void generateThreeUsers(){
        new User("1", LocalDateTime.of(2019,11,1,12,30),10005,960,640 );
        new User("2", LocalDateTime.of(2019,11,2,12,30),10005,960,640 );
        new User("3", LocalDateTime.of(2019,11,3,12,30),5005,900,600 );
        System.out.println("Test data seeded.");
    }

    @AfterAll
    static void resetData(){


    }

    @Test
    @DisplayName("Testing total count all users")
    void testCountAllUsers(){
       long actual = DataCapture.getUserCount();
        assertEquals(3,actual);
    }

    @Test
    @DisplayName("Testing number users with device resolution 640 * 969")
    void testNumberUsersResolution640_960(){
        long actual = DataCapture.getDeviceResolutionCount();
        assertEquals(2,actual);
    }

    @Test
    @DisplayName("Testing total spend all users")
    void testTotalSpendAllUsers(){
        long actual = DataCapture.getTotalSpend();
        assertEquals(25015,actual);
    }

    @Test
    @DisplayName("Testing user id of first joined")
    void testUserIdOfFirstJoined(){
        String actual = DataCapture.getFirstUserId();
        assertEquals("1",actual);
    }

}
