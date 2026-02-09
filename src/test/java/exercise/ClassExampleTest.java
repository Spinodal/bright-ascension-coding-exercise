package exercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static exercise.TestUtils.sanitiseOutput;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassExampleTest {

    ByteArrayOutputStream outputStream;

    @BeforeEach
    void setup(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void teardown(){
        System.setOut(System.out);
    }

    @Test
    void testUser() throws IOException {
        String expectedOutput = """
Person: Peter
Person: Mark
Person: Sam
""";
        ClassExample.main(new String[0]);
        outputStream.flush();
        String actual = outputStream.toString();
        assertEquals(expectedOutput, sanitiseOutput(actual));
    }

}