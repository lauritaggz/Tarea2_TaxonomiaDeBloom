package cl.unab.inf.tarea2.frontend;

// Importa la clase Prueba desde el paquete backend
import cl.unab.inf.tarea2.backend.Prueba;

public class Main {
    public static void main(String[] args) {
        // Esta línea asegura que el código de la interfaz gráfica (Swing)
        // se ejecute en el hilo correcto (Event Dispatch Thread).
        javax.swing.SwingUtilities.invokeLater(() -> {

            // Crea una instancia de la ventana principal del programa
            VentanaPrincipal ventana = new VentanaPrincipal();

            // Hace visible la ventana para que el usuario la vea
            ventana.setVisible(true);

            // Crea una nueva prueba vacía (puede llenarse desde archivo o manualmente)
            Prueba prueba = new Prueba();

            // Carga la prueba vacía a la interfaz (esto puede ser útil para pruebas manuales)
            // En la práctica, esta línea se puede omitir si se carga desde archivo
            ventana.cargarPrueba(prueba);
        });
    }
}
