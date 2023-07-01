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
            "Please, enter the password that you wanna crack.\nNote** : You can only type 5 alphabetical characters ");
        password = input.nextLine();
        if (password.length() != 5) {
          System.out.println("Error, invalid password ! (5 characters expected)");
        } else if (password.matches(".*[0-9].*") == true) {
          System.out.println("Error, invalid password ! (no digits are allowed)");
        } else {
          isOk = true;
        }
      } while (isOk == false);
    } else if (passwordType == 1 && attackType == 2) {
      do {
        System.out.println(
            "Please, enter the password that you wanna crack.\nNote** : You can only type maximum 8 alpha-numerical characters ");
        password = input.nextLine();
        if (password.length() > 8) {
          System.out.println("Error, invalid password ! (no more than 8 characters expected)");
        } else {
          isOk = true;
        }
      } while (isOk == false);
    } else if (passwordType == 2 && attackType == 1) {
      System.out.println(
          "Please, enter the password that you wanna crack.\nNote** : We only support md5 passwords, and hashed passwords should be 5 characters length. ");
      password = input.nextLine();
    } else if (passwordType == 2 && attackType == 2) {
      System.out.println(
          "Please, enter the password that you wanna crack.\nNote** : We only support md5 passwords, and hashed passwords should be max 8 characters length. ");
      password = input.nextLine();
    }

    this.setPassword(password);
  }

}
