package cl.unab.inf.tarea2.backend;

import java.util.List;

// Hereda de la clase base Pregunta
public class PreguntaOpcionMultiple extends Pregunta {
    private List<String> opciones; // Lista que almacena las opciones posibles de respuesta

    // Constructor que recibe los datos básicos más la lista de opciones
    public PreguntaOpcionMultiple(String enunciado, String nivelTaxonomico, int tiempoEstimado, List<String> opciones) {
        // Llama al constructor de la clase base con tipo "Opción Múltiple"
        super(enunciado, nivelTaxonomico, "Opción Múltiple", tiempoEstimado);
        this.opciones = opciones;
    }

    // Getter para obtener las opciones
    public List<String> getOpciones() {
        return opciones;
    }

    // Setter para modificar las opciones
    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    // Método sobrescrito que muestra la pregunta con sus opciones
    @Override
    public void mostrarPregunta() {
        super.mostrarPregunta(); // Llama al método original para mostrar enunciado, tipo, etc.

        // Imprime las opciones numeradas
        System.out.println("Opciones:");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
    }
}