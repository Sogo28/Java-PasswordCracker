import java.security.*;

public class BruteForceAttack {

  private static boolean bruteForceSimple(String password, int taille, Password password2, long startTime)
      throws NoSuchAlgorithmException {
    if (taille == 0) {
      if (password.equals(password2.getPassword().toLowerCase())) {
        System.out.println("Trouvé");
        long endtime = System.currentTimeMillis();
        long tempsMis = endtime - startTime;
        System.out.println("Temps mis (en millisecondes) : " + tempsMis);
        return true;
      }
      return false;
    } else {
      for (char caractere = 'a'; caractere <= 'z'; caractere++) {
        if (bruteForceSimple(password + caractere, taille - 1, password2, startTime)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean bruteForceHashed(String password, int taille, Password password2, long startTime)
      throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    if (taille == 0) {
      byte[] hashBytes = md.digest(password.getBytes());
      StringBuilder sb = new StringBuilder();
      for (byte b : hashBytes) {
        sb.append(String.format("%02x", b));
      }
      if (sb.toString().equals(password2.getPassword())) {
        System.out.println("Trouvé ! Le mot de passe est : " + password);
        long endtime = System.currentTimeMillis();
        long tempsMis = endtime - startTime;
        System.out.println("Temps mis (en millisecondes) : " + tempsMis);
        return true;
      }
      return false;
    } else {
      for (char caractere = 'a'; caractere <= 'z'; caractere++) {
        if (bruteForceHashed(password + caractere, taille - 1, password2, startTime)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void BruteForce(Password password) throws NoSuchAlgorithmException {
    long startTime = System.currentTimeMillis();
    if (password.getType() == 1) {
      bruteForceSimple("", 5, password, startTime);
    } else if (password.getType() == 2) {
      bruteForceHashed("", 5, password, startTime);
    } else {
      System.out.println(password.getType());
      System.out.println("Erreur sur le type de mot de passe !");
    }
  }
}
