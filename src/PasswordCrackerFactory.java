import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class PasswordCrackerFactory {
  public static void crack(Password password, int attackType) throws NoSuchAlgorithmException, IOException {
    switch (attackType) {
      case 1:
        System.out.println("*** Brute force attack en cours ***");
        BruteForceAttack.BruteForce(password);
        break;
      case 2:
        System.out.println("*** Dictionary attack en cours ***");
        DictionaryAttack.dictionary(password);
        break;
      default:
        System.out.println("Erreur sur le type d'attaque !");
        break;
    }
  }

}
