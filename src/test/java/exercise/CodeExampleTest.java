package exercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeExampleTest {

    ByteArrayOutputStream outputStream;
    ByteArrayInputStream inputStream;

    @BeforeEach
    void setup(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void teardown(){
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    void hashMapOutput() throws IOException {
        String expectedOutput = """
Map size: 3
While Loop:
Key is 2 Value is Two
Key is 25 Value is Twenty Five
Key is 12 Value is Twelve
Advanced For Loop:
Key is 2 value is Two
Key is 25 value is Twenty Five
Key is 12 value is Twelve
Stream:
Key is 2 value is Two
Key is 25 value is Twenty Five
Key is 12 value is Twelve
""";
        CodeExample.hashMapOutput();
        outputStream.flush();
        String output = outputStream.toString();
        assertEquals(expectedOutput, sanitiseOutput(output));
    }

    @Test
    void pallindrome_not() throws IOException {
        String expectedOutput = """
Enter the number or String
reverse is: gralb
The number or String is not a palindrome
""";
        String input = "blarg";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        CodeExample.palindrome();
        outputStream.flush();
        String output = outputStream.toString();
        assertEquals(expectedOutput, sanitiseOutput(output));
    }

    @Test
    void pallindrome_true() throws IOException {
        String expectedOutput = """
Enter the number or String
reverse is: tacocat
The number or String is a palindrome
""";
        String input = "tacocat";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        CodeExample.palindrome();
        outputStream.flush();
        String output = outputStream.toString();
        assertEquals(expectedOutput, sanitiseOutput(output));
    }

    String sanitiseOutput(String output){
        return output.replaceAll("\r\n", "\n");
    }
}