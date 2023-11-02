package cat.iesesteveterradas.mp06;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
    while (running) {
      String menu = "Escull una opció:";
      menu = menu + "\n 0) PR120ReadFile";
      // Adapta aquí les altres classes de l’exercici (PR122cat…)
      menu = menu + "\n 100) Sortir";
      System.out.println(menu);

      int opcio = Integer.valueOf(llegirLinia("Opció:"));
      try {
        switch (opcio) {
          case 0: PR143GestioLlibreriaMain.main(args); break;
          // Adapta aquí les altres classes de l’exercici (PR122cat…)
          case 100: running = false; break;
          default: break;
        }
      } catch (Exception e) {
          System.out.println(e);
      }
    }
    in.close();
  }

  static public String llegirLinia (String text) {
    System.out.print(text);
    return in.nextLine();
  }
    }
}