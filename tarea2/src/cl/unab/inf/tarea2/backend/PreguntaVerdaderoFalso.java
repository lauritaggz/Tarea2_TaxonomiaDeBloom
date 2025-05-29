package cl.unab.inf.tarea2.backend;

// Subclase PreguntaVerdaderoFalso con método sobrescrito
public class PreguntaVerdaderoFalso extends Pregunta {

    public PreguntaVerdaderoFalso(String enunciado, String nivelTaxonomico, int tiempoEstimado) {
        super(enunciado, nivelTaxonomico, "Verdadero/Falso", tiempoEstimado);
    }

    @Override
    public void mostrarPregunta() {
        super.mostrarPregunta();
        System.out.println("Respuesta: Verdadero o Falso");
    }
}