import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class PersonFinder {

    Path inPath = Paths.get("Gymlistor/src/Memberlist.txt");
    Path outPath = Paths.get("Gymlistor/src/Visits.txt");
    /*public void hittaNamn(String output, Path outPath){
        try(BufferedWriter buf = Files.newBufferedWriter(outPath)){
            buf.write(output);
            buf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    public void memberOrNot() {
        LocalDate today = LocalDate.now();
        String input = JOptionPane.showInputDialog("Mata in namn eller personnummer");

        try (BufferedReader buf = Files.newBufferedReader(inPath);) {
            String row1;
            String row2 = null;




            while ((row1 = buf.readLine()) != null) {
                if(row1.contains(input)){
                    row2 = buf.readLine();
                    break;
                }




            }

            if(row2 == null){
                JOptionPane.showMessageDialog(null,"Gästen finns inte");
            }
            else {
                LocalDate date = LocalDate.parse(row2);

                if (date.isBefore(today.minusYears(1))) {
                    JOptionPane.showMessageDialog(null, "Gästens medlemskap har gått ut.");
                }
                if (date.isAfter(today.minusYears(1))) {
                    JOptionPane.showMessageDialog(null,"Gästens medlemskap är aktivt.");


                }
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }







    }
    }

