import java.util.Scanner;

public class Password {
  // Attributs du mot de passe :
  // Le type permet de dire si c'est un mot de passe simple ou hashe
  private int type = 0;

  // Cette chaine stockera le mot de passe
  private String password = "";

  // Constructeur sans paramètres
  Password() {
  };

  // Guetters et setters
  public String getPassword() {
    return password;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  // Methode utilisée par la méthode "passwordSettings" pour définir la valeur du
  // mot de passe.
  private void setPassword(String password) {
    this.password = password;
  }

  public void passwordSettings(int passwordType, int attackType) {
    boolean isOk = false;
    String password = "";
    Scanner input = new Scanner(System.in);
    if (passwordType == 1 && attackType == 1) {
      do {
        System.out.println(
            "Veuillez entrer le mot de passe que vous souhaitez craquer.\nRemarque : Vous ne pouvez saisir que 5 caractères alphabétiques.");
        password = input.nextLine();
        if (password.length() != 5) {
          System.out.println("Erreur, mot de passe invalide ! (La taille du mot de passe n'est pas de 5 caractères.)");
        } else if (password.matches(".*[0-9].*") == true) {
          System.out.println("Erreur, mot de passe invalide (Les chiffres ne sont pas supportés.)");
        } else {
          isOk = true;
        }
      } while (isOk == false);
    } else if (passwordType == 1 && attackType == 2) {
      do {
        System.out.println(
            "Veuillez entrer le mot de passe que vous souhaitez craquer.\nRemarque** : Vous ne pouvez saisir que 8 caractères alphanumériques.");
        password = input.nextLine();
        if (password.length() > 8) {
          System.out.println("Erreur, mot de passe invalide (Vous ne devez pas dépasser 8 caractères alphanumériques)");
        } else {
          isOk = true;
        }
      } while (isOk == false);
    } else if (passwordType == 2 && attackType == 1) {
      System.out.println(
          "Veuillez entrer le mot de passe que vous souhaitez craquer.\nNote** : Nous ne prenons en charge que les mots de passe MD5, et les mots de passe hachés doivent avoir une longueur de 5 caractères.");
      password = input.nextLine();
    } else if (passwordType == 2 && attackType == 2) {
      System.out.println(
          "Veuillez entrer le mot de passe que vous souhaitez craquer.\nNote** : Nous ne prenons en charge que les mots de passe MD5, et les mots de passe hachés doivent avoir une longueur maximale de 8 caractères.");
      password = input.nextLine();
    }

    this.setPassword(password);
  }

}
