import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTheFile {
    public ReadTheFile() {
        String temp;
        try (BufferedReader BuR = new BufferedReader(new FileReader("src/Memberlist.txt"))) {
            while((temp = BuR.readLine()) !=null){
                System.out.println(temp);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }

    }
}
