import java.io.File;
import java.io.FileNotFoundException;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Scanner;

public class Pregunta extends Quiz{

    public Pregunta(Integer nivel, String contenido, String opcion1, String opcion2, String opcion3, String opcion4, String respuesta) {
        this.nivel = nivel;
        this.contenido = contenido;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.respuesta = respuesta;
    }

    public Pregunta() {
    }

    public static ArrayList<Pregunta> importarPreguntas() throws FileNotFoundException{
        String path = "src/main/resources/preguntas.csv";

        Integer nivel;
        String pregunta;
        String opcion1;
        String opcion2;
        String opcion3;
        String opcion4;
        String respuesta;


        Scanner input = new Scanner(new File(path));
        ArrayList<Pregunta> questions = new ArrayList<>();

        input.useDelimiter(",|\n");

        while (input.hasNext()){
            nivel = input.nextInt();
            pregunta = input.next();
            opcion1 = input.next();
            opcion2 = input.next();
            opcion3 = input.next();
            opcion4 = input.next();
            respuesta = input.next();

            questions.add(new Pregunta(nivel,pregunta,opcion1,opcion2,opcion3,opcion4,respuesta));
        }
        return questions;
    }

    public static ArrayList<Pregunta> importarPreguntasNivel(int nivel) throws FileNotFoundException {

        ArrayList<Pregunta> allQuestions = importarPreguntas();
        ArrayList<Pregunta> nivelQuestions = new ArrayList<>();;

        for (int i=0; i<allQuestions.size(); i++){
            if (allQuestions.get(i).nivel == nivel){
                nivelQuestions.add(allQuestions.get(i));
            }
        }
        return nivelQuestions;
    }

    @Override
    public String[] getRandomArrayPreguntaNivel(int nivel) throws FileNotFoundException {
        String[] pregunta = new String[6];
        ArrayList<Pregunta> nivelQuestions = importarPreguntasNivel(nivel);
        int r = (int) (Math.random() * 5);

        pregunta[0] = nivelQuestions.get(r).contenido;
        pregunta[1] = nivelQuestions.get(r).opcion1;
        pregunta[2] = nivelQuestions.get(r).opcion2;
        pregunta[3] = nivelQuestions.get(r).opcion3;
        pregunta[4] = nivelQuestions.get(r).opcion4;
        pregunta[5] = nivelQuestions.get(r).respuesta;

        return pregunta;
    }
}
