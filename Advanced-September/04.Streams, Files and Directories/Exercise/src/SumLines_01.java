
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\SoftUni\\Java Advanced\\Java Advanced - september 2021\\" +
        "04.Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        Files.readAllLines(Path.of(path)).stream()
                .map(String :: toCharArray)  //str -> str.toCharArray
                .forEach(charArray ->
                {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });
    }
}