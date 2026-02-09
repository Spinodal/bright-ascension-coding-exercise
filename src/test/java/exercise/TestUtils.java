package exercise;

public class TestUtils {
    public static String sanitiseOutput(String output){
        return output.replaceAll("\r\n", "\n");
    }

}
