package kim.christopher.stack;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringStackTest {

    StringStack myStack;

    @Before
    public void initialize() {
        myStack = new StringStack();
    }

    @Test
    public void pushTest(){
        //Given
        String expected = "Chris";

        //When
        myStack.push("Anthony");
        myStack.push("Chris");
        String actual = myStack.peek();

        //Then
        assertEquals("Chris should have been pushed", expected, actual);
    }

    @Test
    public void popTest(){
        //Given
        String expected = "Stephen";

        //When
        myStack.push("Ziggy");
        myStack.push("Stephen");
        String actual = myStack.pop();

        //Then
        assertEquals("Stephen should have been popped", expected, actual);
    }

    @Test
    public void peekTest(){
        //Given
        String expected = "Dennis";
        String expected1 = "Paco";

        //When
        myStack.push("Dennis");
        String actual = myStack.peek();
        myStack.push("Paco");
        String actual1 = myStack.peek();

        //Then
        assertEquals("Dennis should be on top", expected, actual);
        assertEquals("Dennis should be on top", expected1, actual1);
    }
}
