package cl.unab.inf.tarea2.backend;

import java.util.ArrayList;
import java.util.List;

// Clase Prueba que administra preguntas
public class Prueba {
    private List<Pregunta> preguntas;

    public Prueba() {
        this.preguntas = new ArrayList<>();
    }

    // Agrega una pregunta a la lista
    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
        System.out.println("Pregunta agregada correctamente\n");
    }

    // Muestra todas las preguntas en la lista
    public void mostrarPreguntas() {
        if (preguntas.isEmpty()) {
            System.out.println("No hay preguntas actualmente\n");
            return;
        }
        for (int i = 0; i < preguntas.size(); i++) {
            System.out.println("\nPregunta " + (i + 1) + ":\n");
            preguntas.get(i).mostrarPregunta();
        }
    }

    // Busca preguntas por nivel taxonómico
    public void buscarPorNivelTaxonomico(String nivel) {
        boolean encontrado = false;
        for (Pregunta pregunta : preguntas) {
            if (pregunta.getNivelTaxonomico().equalsIgnoreCase(nivel)) {
                pregunta.mostrarPregunta();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron preguntas con ese nivel taxonómico\n");
        }
    }

    // Elimina pregunta por índice
    public void eliminarPregunta(int indice) {
        if (indice < 0 || indice >= preguntas.size()) {
            System.out.println("Índice inválido\n");
            return;
        }
        preguntas.remove(indice);
        System.out.println("Pregunta eliminada correctamente\n");
    }

    // Actualiza pregunta por índice
    public void actualizarPregunta(int indice, Pregunta nuevaPregunta) {
        if (indice < 0 || indice >= preguntas.size()) {
            System.out.println("Índice inválido\n");
            return;
        }
        preguntas.set(indice, nuevaPregunta);
        System.out.println("Pregunta actualizada correctamente\n");
    }

    // Calcula tiempo total estimado de todas las preguntas
    public int calcularTiempoTotal() {
        int total = 0;
        for (Pregunta pregunta : preguntas) {
            total += pregunta.getTiempoEstimado();
        }
        return total;
    }

    // Método que falta - cantidad de preguntas
    public int getCantidadPreguntas() {
        return preguntas.size();
    }

    // Método que falta - obtener pregunta en índice
    public Pregunta getPreguntaEn(int index) {
        if (index < 0 || index >= preguntas.size()) {
            return null;
        }
        return preguntas.get(index);
    }
}