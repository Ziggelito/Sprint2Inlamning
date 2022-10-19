import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyText {
    public static String ReadTheFile() {
        Path list = Paths.get("Gymlistor/src/Memberlist.txt");
        Path list2 = Paths.get("Gymlistor/src/visits.txt");

        String temp = null;
        try (BufferedReader BuR = Files.newBufferedReader(list);
        BufferedWriter BuW = Files.newBufferedWriter(list2)) {
            while ((temp = BuR.readLine()) != null) {

                BuW.write(temp);
                BuW.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return temp;

    }
}
