import java.io.*;
import java.util.Scanner;

public class JugadorRegistrado extends Jugador{

    public JugadorRegistrado(String username, Integer puntaje) {
        super(username, puntaje);
    }

    @Override
    public String mensajeBienvenida() {
        return "Bienvenido de nuevo " + super.getUsername() + " al jugar tus puntajes seran guardados.";
    }

    public void misPuntajes() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/resources/" + super.getUsername() + ".txt");
        Scanner in = new Scanner(fis);
        System.out.println("Mis puntajes son:");

        Integer count = 0;
        while (in.hasNext()) {
            System.out.println(count + ". " + in.nextInt());
            count++;
        }
    }

    public void guardarPuntaje() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("src/main/resources/" + super.getUsername() + ".txt", true);
        PrintWriter pw = new PrintWriter(fos);

        pw.println(super.getPuntaje());
        pw.close();
    }
}

