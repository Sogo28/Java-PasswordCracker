import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class DictionaryAttack {
  private static void dictionarySimple(Password password, long startTime) {
    // Exploitation du fichier csv
    String cheminFichier = "../assets/dictionnaires/dictionnaire.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ";";

    try {
      br = new BufferedReader(new FileReader(cheminFichier));
      while ((line = br.readLine()) != null) {
        String[] mot = line.split(cvsSplitBy);
        if (mot[0].equals(password.getPassword())) {
          long endtime = System.currentTimeMillis();
          long tempsMis = endtime - startTime;
          System.out.println("Le mot de passe a été trouvé ! Il s'agissait de : " + mot[0]);
          System.out.println("Temps mis : " + tempsMis + " Milliseconde(s)");
          return;
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println("Le mot de passe n'a pas été trouvé.");
  }

  private static void dictionaryHashed(Password password, long startTime) {
    // Exploitation du fichier csv
    String cheminFichier = "../assets/dictionnaires/dictionnaire.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ";";

    try {
      br = new BufferedReader(new FileReader(cheminFichier));
      while ((line = br.readLine()) != null) {
        String[] mot = line.split(cvsSplitBy);
        if (mot[1].equals(password.getPassword()) == true) {
          long endtime = System.currentTimeMillis();
          long tempsMis = endtime - startTime;
          System.out.println("Le mot de passe a été trouvé ! Il s'agissait de : " +
              mot[0]);
          System.out.println("Temps mis : " + tempsMis + " Milliseconde(s)");
          return;
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println("Le mot de passe n'a pas été trouvé.");
  }

  public static void dictionary(Password password) throws IOException {
    long startTime = System.currentTimeMillis();
    switch (password.getType()) {
      case 1:
        dictionarySimple(password, startTime);
        break;
      case 2:
        dictionaryHashed(password, startTime);
        break;
      default:
        System.out.println(password.getType());
        System.out.println("Erreur sur le type de mot de passe.");
        break;
    }
  }

}
