package cl.unab.inf.tarea2.backend;

import java.util.List;

public class PreguntaOpcionMultiple extends Pregunta {
    private List<String> opciones;

    public PreguntaOpcionMultiple(String enunciado, String nivelTaxonomico, int tiempoEstimado, List<String> opciones) {
        super(enunciado, nivelTaxonomico, "Opción Múltiple", tiempoEstimado);
        this.opciones = opciones;
    }

    public List<String> getOpciones() { return opciones; }
    public void setOpciones(List<String> opciones) { this.opciones = opciones; }

    @Override
    public void mostrarPregunta() {
        super.mostrarPregunta(); // Muestra atributos comunes
        System.out.println("Opciones:");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i+1) + ". " + opciones.get(i));
        }
    }
}