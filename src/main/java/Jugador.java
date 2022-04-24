public class Jugador {

    private String username;
    private Integer puntaje;

    public Jugador(String username, Integer puntaje) {
        this.username = username;
        this.puntaje = puntaje;
    }

    public Jugador() {
    }

    public String mensajeBienvenida() {
        return "Bienvenido " + username;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
}
