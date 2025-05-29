package cl.unab.inf.tarea2.frontend;

import cl.unab.inf.tarea2.backend.Prueba;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);

            // Aquí carga la prueba desde archivo o crea manualmente y pásala
            Prueba prueba = new Prueba();
            // Carga o crea preguntas aquí en prueba
            ventana.cargarPrueba(prueba);
        });
    }
}