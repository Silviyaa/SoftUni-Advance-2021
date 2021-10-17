
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\SoftUni\\Java Advanced\\Java Advanced - september 2021\\" +
                "04.Streams, Files and Directories\\Exercise" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;
        for(byte value : Files.readAllBytes(Path.of(path))){
            if (value != 10 && value != 13){
                sum += value;
            }
        }

        System.out.println(sum);
    }
}