import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SliceTest  {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final Slice underTest = new Slice(0);

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        underTest.addRestaurant("{\"name\": \"Hesturan\", \"description\": \"luxury\", \"location\": {\"x\": 1, \"y\": 3}, \"menu\": [{\"name\": \"Gheime\", \"description\": \"it’s yummy!\", \"popularity\": 0.8, \"price\": 20000}, {\"name\": \"Kabab\", \"description\": \"it’s delicious!\", \"popularity\": 0.6, \"price\":30000}]}");
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    public void testAllRestaurants() {
        underTest.showAllRestaurants();
        assertEquals("Hesturan\n" , outContent.toString());
    }

    @Test
    public void testGetRestaurant() {
        underTest.showRestaurant("{\"name\" : \"Res\"}");
        assertEquals("Not Found\n" , outContent.toString());
    }
}
