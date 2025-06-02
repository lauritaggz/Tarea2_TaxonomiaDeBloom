package cl.unab.inf.tarea2.frontend;

import cl.unab.inf.tarea2.backend.Prueba;
import cl.unab.inf.tarea2.backend.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

// Clase principal que representa la ventana de la aplicación
public class VentanaPrincipal extends JFrame {

    // Componentes gráficos (botones, áreas de texto, etc.)
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnCargarArchivo;
    private JButton btnGuardarRespuesta;
    private JButton btnEnviarPrueba;
    private JTextArea txtPregunta;
    private JTextField txtRespuesta;
    private JScrollPane scrollPregunta;
    private JPanel panel1; // Panel principal generado desde el .form

    // Atributos para manejar la lógica del sistema
    private Prueba prueba; // Contiene la lista de preguntas
    private int indicePregunta; // Guarda el índice de la pregunta actual

    // Constructor: configura la ventana principal
    public VentanaPrincipal() {
        super("Sistema de Pruebas - Taxonomía de Bloom");
        setContentPane(panel1); // Vincula el panel diseñado en el .form
        setMinimumSize(new Dimension(700, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        inicializarEventos(); // Conecta los botones con sus acciones
    }

    // Método que asigna funcionalidad a los botones
    private void inicializarEventos() {
        btnCargarArchivo.addActionListener(e -> cargarArchivo());
        btnSiguiente.addActionListener(e -> siguientePregunta());
        btnAnterior.addActionListener(e -> preguntaAnterior());
        btnGuardarRespuesta.addActionListener(e -> guardarRespuesta());
        btnEnviarPrueba.addActionListener(e -> enviarPrueba());
    }

    // Método para cargar las preguntas desde un archivo .txt
    private void cargarArchivo() {
        JFileChooser fileChooser = new JFileChooser(); // Permite seleccionar archivos
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            prueba = new Prueba(); // Crea una nueva prueba

            try (BufferedReader br = new BufferedReader(new FileReader(archivoSeleccionado))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    // Espera un formato: enunciado;nivel;tipo;tiempo;solucionCorrecta
                    String[] partes = linea.split(";");
                    if (partes.length == 5) {
                        String enunciado = partes[0];
                        String nivel = partes[1];
                        String tipo = partes[2];
                        int tiempo = Integer.parseInt(partes[3]);
                        String solucion = partes[4];

                        Pregunta p = new Pregunta(enunciado, nivel, tipo, tiempo);
                        p.setSolucionCorrecta(solucion);
                        prueba.agregarPregunta(p); // Agrega la pregunta a la prueba
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al leer archivo: " + ex.getMessage());
            }

            indicePregunta = 0;
            mostrarPreguntaActual();
        }
    }

    // Muestra la siguiente pregunta si existe
    private void siguientePregunta() {
        if (indicePregunta < prueba.getCantidadPreguntas() - 1) {
            indicePregunta++;
            mostrarPreguntaActual();
        }
    }

    // Muestra la pregunta anterior si existe
    private void preguntaAnterior() {
        if (indicePregunta > 0) {
            indicePregunta--;
            mostrarPreguntaActual();
        }
    }

    // Guarda la respuesta ingresada por el usuario para la pregunta actual
    private void guardarRespuesta() {
        if (prueba.getCantidadPreguntas() > 0 &&
                indicePregunta >= 0 &&
                indicePregunta < prueba.getCantidadPreguntas()) {

            Pregunta pregunta = prueba.getPreguntaEn(indicePregunta);
            pregunta.setRespuestaUsuario(txtRespuesta.getText()); // Guarda lo escrito
            JOptionPane.showMessageDialog(this, "Respuesta guardada");
        }
    }

    // Muestra la pregunta actual en pantalla
    private void mostrarPreguntaActual() {
        if (prueba.getCantidadPreguntas() > 0 &&
                indicePregunta >= 0 &&
                indicePregunta < prueba.getCantidadPreguntas()) {

            Pregunta pregunta = prueba.getPreguntaEn(indicePregunta);
            txtPregunta.setText(pregunta.getEnunciado());
            txtRespuesta.setText(pregunta.getRespuestaUsuario() != null ? pregunta.getRespuestaUsuario() : "");
        } else {
            txtPregunta.setText("");
            txtRespuesta.setText("");
        }
    }

    // Evalúa la prueba y muestra los resultados
    private void enviarPrueba() {
        if (prueba.getCantidadPreguntas() == 0) {
            JOptionPane.showMessageDialog(this, "No hay preguntas cargadas.");
            return;
        }

        // Desactiva los botones e input
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnGuardarRespuesta.setEnabled(false);
        btnEnviarPrueba.setEnabled(false);
        txtRespuesta.setEditable(false);

        int correctas = 0;
        int total = prueba.getCantidadPreguntas();

        // Mapas para estadísticas por nivel y tipo
        Map<String, Integer> totalPorNivel = new HashMap<>();
        Map<String, Integer> correctasPorNivel = new HashMap<>();
        Map<String, Integer> totalPorTipo = new HashMap<>();
        Map<String, Integer> correctasPorTipo = new HashMap<>();

        // Recorre las preguntas para contar las correctas
        for (int i = 0; i < total; i++) {
            Pregunta p = prueba.getPreguntaEn(i);

            totalPorNivel.put(p.getNivelTaxonomico(), totalPorNivel.getOrDefault(p.getNivelTaxonomico(), 0) + 1);
            totalPorTipo.put(p.getTipo(), totalPorTipo.getOrDefault(p.getTipo(), 0) + 1);

            if (p.esRespuestaCorrecta()) {
                correctas++;
                correctasPorNivel.put(p.getNivelTaxonomico(), correctasPorNivel.getOrDefault(p.getNivelTaxonomico(), 0) + 1);
                correctasPorTipo.put(p.getTipo(), correctasPorTipo.getOrDefault(p.getTipo(), 0) + 1);
            }
        }

        // Arma el resumen en formato de texto
        StringBuilder resumen = new StringBuilder();
        resumen.append(String.format("Porcentaje total de respuestas correctas: %.2f%%\n\n", 100.0 * correctas / total));

        resumen.append("Porcentaje por nivel taxonómico:\n");
        for (String nivel : totalPorNivel.keySet()) {
            int c = correctasPorNivel.getOrDefault(nivel, 0);
            int t = totalPorNivel.get(nivel);
            resumen.append(String.format(" - %s: %.2f%% (%d/%d)\n", nivel, 100.0 * c / t, c, t));
        }

        resumen.append("\nPorcentaje por tipo de pregunta:\n");
        for (String tipo : totalPorTipo.keySet()) {
            int c = correctasPorTipo.getOrDefault(tipo, 0);
            int t = totalPorTipo.get(tipo);
            resumen.append(String.format(" - %s: %.2f%% (%d/%d)\n", tipo, 100.0 * c / t, c, t));
        }

        // Muestra el resumen al usuario
        JOptionPane.showMessageDialog(this, resumen.toString(), "Resumen de resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para cargar una prueba desde el código (por ejemplo, en Main.java)
    public void cargarPrueba(Prueba prueba) {
        this.prueba = prueba;
        this.indicePregunta = 0;
        mostrarPreguntaActual();
    }
}
