package cl.unab.inf.tarea2.backend;

// Subclase PreguntaVerdaderoFalso con método sobrescrito
public class PreguntaVerdaderoFalso extends Pregunta {

    // Constructor de la clase que recibe los datos básicos de la pregunta:
    // enunciado, nivel taxonómico y el tiempo estimado de respuesta.
    public PreguntaVerdaderoFalso(String enunciado, String nivelTaxonomico, int tiempoEstimado) {
        // Llama al constructor de la clase base (super) con el tipo fijo "Verdadero/Falso"
        super(enunciado, nivelTaxonomico, "Verdadero/Falso", tiempoEstimado);
    }

    // Sobrescribe el método mostrarPregunta() de la clase base
    @Override
    public void mostrarPregunta() {
        // Llama a la versión original del método en la clase Pregunta
        super.mostrarPregunta();

        // Agrega información específica para este tipo de pregunta
        System.out.println("Respuesta: Verdadero o Falso");
    }
}