import java.io.FileNotFoundException;
import java.util.Scanner;

public class Juego {
    private Integer nivel;
    private Integer puntaje;
    private Boolean estado;

    public Juego() {
        this.nivel = 1;
        this.puntaje = 0;
        this.estado = true;
    }

    public static void iniciarJuegoR(JugadorRegistrado jugador) throws FileNotFoundException {
        Boolean estado = true;
        Integer nivel = 1;
        while (estado) {
            System.out.println(jugador.getUsername() + " estas en el nivel: " + nivel + "\nTu puntaje es: " + jugador.getPuntaje() + "\nRecuerda que tienes 10 segundos para responder!!");
            Pregunta pregunta = new Pregunta();
            String[] paquetePreguntaNivel = pregunta.getRandomArrayPreguntaNivel(nivel);
            System.out.println(paquetePreguntaNivel[0]);
            for (int i=1; i<paquetePreguntaNivel.length-1; i++) {
                System.out.println(i + ". " + paquetePreguntaNivel[i]);
            }

            long startTime = System.currentTimeMillis();
            Scanner s = new Scanner(System.in);
            Integer opcionMarcada = Integer.parseInt(s.nextLine());
            long stopTime = System.currentTimeMillis();
            long reactionTime = stopTime - startTime;
            System.out.println("-------------------------------------------");

            if (reactionTime > 10000) {
                System.out.println("Fin del juego te demoraste mas de 10 segundos en responder :c\nTu puntaje fue: " + jugador.getPuntaje());
                System.out.println("-------------------------------------------");
                jugador.guardarPuntaje();
                jugador.setPuntaje(0);
                estado = false;
            } else {
                if (paquetePreguntaNivel[5].equals(paquetePreguntaNivel[opcionMarcada])) {
                    jugador.setPuntaje(jugador.getPuntaje() + 100);
                    nivel++;
                } else {
                    System.out.println("Fin del juego tu respuesta fue incorrecta :c\nTu puntaje fue: " + jugador.getPuntaje());
                    System.out.println("-------------------------------------------");
                    jugador.guardarPuntaje();
                    jugador.setPuntaje(0);
                    estado = false;
                }
            }

            if (nivel == 6) {
                System.out.println("Fin del juego " + jugador.getUsername() + " obtuviste el puntaje maximo: " + jugador.getPuntaje());
                System.out.println("-------------------------------------------");
                jugador.guardarPuntaje();
                jugador.setPuntaje(0);
                estado = false;
            }
        }
    }

    public static void iniciarJuegoI(JugadorInvitado jugador) throws FileNotFoundException {
        Boolean estado = true;
        Integer nivel = 1;
        while (estado) {
            System.out.println(jugador.getUsername() + " estas en el nivel:" + nivel + "\nTu puntaje es: " + jugador.getPuntaje() + "\nRecuerda que tienes 10 segundos para responder!!");
            Pregunta pregunta = new Pregunta();
            String[] paquetePreguntaNivel = pregunta.getRandomArrayPreguntaNivel(nivel);
            System.out.println(paquetePreguntaNivel[0]);
            for (int i=1; i<paquetePreguntaNivel.length-1; i++) {
                System.out.println(i + ". " + paquetePreguntaNivel[i]);
            }
            long startTime = System.currentTimeMillis();
            Scanner s = new Scanner(System.in);
            Integer opcionMarcada = Integer.parseInt(s.nextLine());
            long stopTime = System.currentTimeMillis();
            long reactionTime = stopTime - startTime;
            System.out.println("-------------------------------------------");

            if (reactionTime > 10000) {
                System.out.println("Fin del juego te demoraste mas de 10 segundos en responder :c\nTu puntaje fue: " + jugador.getPuntaje());
                System.out.println("-------------------------------------------");
                estado = false;
            } else {
                if (paquetePreguntaNivel[5].equals(paquetePreguntaNivel[opcionMarcada])) {
                    jugador.setPuntaje(jugador.getPuntaje() + 100);
                    nivel++;
                } else {
                    System.out.println("Fin del juego tu respuesta fue incorrecta :c\nTu puntaje fue: " + jugador.getPuntaje());
                    System.out.println("-------------------------------------------");
                    estado = false;
                }
            }

            if (nivel == 6) {
                System.out.println("Fin del juego " + jugador.getUsername() + " obtuviste el puntaje maximo: " + jugador.getPuntaje());
                System.out.println("-------------------------------------------");
                estado = false;
            }
        }
    }
}
