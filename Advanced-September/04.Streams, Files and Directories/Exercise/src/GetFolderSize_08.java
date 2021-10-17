import java.io.File;
import java.nio.file.Path;

public class GetFolderSize_08 {
    public static void main(String[] args) {
        String path = "C:\\SoftUni\\Java Advanced\\Java Advanced - september 2021\\04.Streams, Files and Directories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);

        int folderSize = 0;
        for (File file : folder.listFiles()) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);

    }
}
 