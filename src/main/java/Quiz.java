import java.io.FileNotFoundException;

public abstract class Quiz{

    protected Integer nivel;
    protected String contenido;
    protected String opcion1;
    protected String opcion2;
    protected String opcion3;
    protected String opcion4;
    protected String respuesta;

    abstract String[] getRandomArrayPreguntaNivel(int nivel) throws FileNotFoundException;
}
