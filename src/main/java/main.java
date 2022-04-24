import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Boolean estadoTotal = true;
        while (estadoTotal){
            System.out.println("Hola jugador, deseas:\n1. Entrar como registrado\n2. Entrar como invitado\n3. Salir");
            Scanner s = new Scanner(System.in);
            Integer menu1 = Integer.parseInt(s.nextLine());
            System.out.println("-------------------------------------------");
            switch (menu1) {
                case 1:
                    System.out.println("username: ");
                    String username = s.nextLine();
                    System.out.println("-------------------------------------------");
                    JugadorRegistrado jugadorR = new JugadorRegistrado(username,0);
                    Boolean estadoR = true;
                    while (estadoR) {
                        System.out.println(jugadorR.mensajeBienvenida() + "\n1. Jugar\n2. Mis puntajes\n3. Salir");
                        Integer menu2 = Integer.parseInt(s.nextLine());
                        System.out.println("-------------------------------------------");
                        switch (menu2) {
                            case 1:
                                Juego juego = new Juego();
                                juego.iniciarJuegoR(jugadorR);
                                break;
                            case 2:
                                jugadorR.misPuntajes();
                                break;
                            case 3:
                                estadoR = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    JugadorInvitado jugadorI = new JugadorInvitado(0);
                    Boolean estadoI = true;
                    while (estadoI) {
                        System.out.println(jugadorI.mensajeBienvenida() + "\n1. Jugar\n2. Mis puntajes\n3. Salir");
                        Integer menu2 = Integer.parseInt(s.nextLine());
                        System.out.println("-------------------------------------------");
                        switch (menu2) {
                            case 1:
                                Juego juego = new Juego();
                                juego.iniciarJuegoI(jugadorI);
                                break;
                            case 2:
                                jugadorI.misPuntajes();
                                break;
                            case 3:
                                estadoI = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    estadoTotal = false;
                    System.out.println("Vuelve pronto!!");
            }
        }
    }
}
