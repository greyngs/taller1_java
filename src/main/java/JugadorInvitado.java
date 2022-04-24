public class JugadorInvitado extends Jugador{

    public JugadorInvitado(Integer puntaje) {
        super("Invitado", puntaje);
    }

    public JugadorInvitado() {
    }

    @Override
    public String mensajeBienvenida() {
        return "Bienvenido " + super.getUsername();
    }

    public static void misPuntajes() {
        System.out.println("Eres jugador invitado y por tanto no tienes un registro de puntajes");
        System.out.println("-------------------------------------------");
    }
}
