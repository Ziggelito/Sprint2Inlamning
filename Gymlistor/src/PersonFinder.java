import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class PersonFinder {

    Path inPath = Paths.get("Gymlistor/src/Memberlist.txt");

    public void memberOrNot() {
        LocalDate today = LocalDate.now();
        String input = JOptionPane.showInputDialog("Mata in gästens namn eller personnummer");

        try (BufferedReader buf = Files.newBufferedReader(inPath);) {
            String row1;
            String row2 = null;
            while ((row1 = buf.readLine()) != null) {
                if(row1.contains(input)){
                    row2 = buf.readLine();
                    break;
                }
            }
            if(input.length() < 2) {
                JOptionPane.showMessageDialog(null, "Vänligen skriv in hela namnet eller personnumret.");
                return;
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
                    try(PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter("Gymlistor/src/Visits.txt", true)));){
                        out.append(row1 + " " + LocalDate.now() + System.lineSeparator());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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

