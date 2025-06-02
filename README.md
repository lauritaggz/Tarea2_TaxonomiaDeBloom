				DESCRIPCION GENERAL

Este proyecto es un sistema desarrollado en Java Swing que permite administrar la aplicación de pruebas cuyos ítems están definidos según la Taxonomía de Bloom.
El programa permite cargar preguntas desde un archivo de texto, navegar entre las preguntas, ingresar respuestas, y finalmente enviar la prueba para obtener un resumen estadístico de aciertos.
_________________________________________________________________________________________

	FUNCIONALIDADES

1) Carga de ítems desde archivo

	-Se puede cargar un archivo .txt con las preguntas de la prueba.

	-El archivo debe respetar un formato específico (ver sección Formato de Archivo).

	-Tras la carga, la prueba se inicializa con los ítems y se muestra la primera 	pregunta.

	-No se muestra cantidad de preguntas ni tiempo total en la interfaz aún (mejora 	futura).

2) Aplicación de la prueba

	-Se muestra un ítem a la vez con su enunciado.

	-El usuario puede navegar entre preguntas con los botones "Anterior" y 	"Siguiente".

	-Se puede ingresar y guardar la respuesta en el campo de texto y presionando 	"Guardar respuesta".

	-Las respuestas se mantienen mientras se navega.

3) Envío y revisión de respuestas

	-Al presionar "Enviar prueba", el sistema bloquea la edición y navegación.

	-Se calcula y muestra un resumen con el porcentaje total de respuestas correctas, 	así como desglosado por nivel taxonómico y tipo de pregunta.

	-No existe interfaz para revisión detallada pregunta a pregunta (mejora futura).
_________________________________________________________________________________________

	INSTRUCCIONES PARA EJECUTAR EL PROGRAMA

A) Abrir el proyecto en IntelliJ IDEA Community Edition (versión 2024.1 usada para desarrollo, JDK ).

B) Ejecutar la clase principal Main.java ubicada en el paquete cl.unab.inf.tarea2.

C) En la ventana que aparece, presionar el botón "Cargar ítems desde archivo" y seleccionar un archivo .txt con las preguntas.

D) Navegar entre las preguntas con "Anterior" y "Siguiente".

E)Ingresar respuestas en el campo correspondiente y presionar "Guardar respuesta".

F)Cuando termines, presiona "Enviar prueba" para obtener un resumen de resultados.
_________________________________________________________________________________________

	FORMATO DEL ARCHIVO

-El archivo debe ser un archivo de texto plano .txt.

-Cada línea corresponde a una pregunta.

-Cada línea debe tener los campos separados por punto y coma ;.

-Los campos en orden y tipo son:

	enunciado;nivelTaxonomico;tipo;tiempoEstimado;solucionCorrecta

-enunciado: Texto de la pregunta (String).

-nivelTaxonomico: Nivel según taxonomía de Bloom (e.g., Recordar, Comprensión, Aplicar, Analizar, Evaluar, Crear).

-tipo: Tipo de pregunta, como "Opción Múltiple" o "Verdadero/Falso".

-tiempoEstimado: Tiempo estimado para responder en minutos (entero).

-solucionCorrecta: Respuesta correcta esperada (String).

-Ejemplo de archivo válido: Subido en la carpeta .zip
_________________________________________________________________________________________

	SUPUESTOS Y LIMITACIONES

-El programa asume que el archivo está correctamente formateado. Si una línea no tiene 5 campos, esa línea se ignora.

-No hay validación avanzada sobre el contenido de cada campo (p.ej. niveles o tipos no validados más allá del formato).

-No hay soporte para múltiples opciones en opción múltiple en la interfaz gráfica (solo texto simple para respuesta).

-No se implementa patrón formal de notificación-suscripción entre backend y frontend, comunicación directa mediante métodos.

-No se implementa revisión detallada pregunta a pregunta, sólo resumen estadístico final.

-El tiempo total de la prueba no se muestra actualmente en la interfaz gráfica.

-La interfaz puede ser mejorada para una experiencia de usuario más amigable.
_________________________________________________________________________________________

	EJECUCION

-Abrir IntelliJ, importar proyecto.

-Ejecutar Main.java.

-Cargar archivo .txt con preguntas.

-Navegar, responder, guardar, enviar prueba.
_________________________________________________________________________________________

Si tienes dudas o problemas con la carga o funcionamiento, revisa el formato del archivo y asegúrate de seguir las instrucciones.

Desarrollado por: Laura González y Lorenzo Figueroa
Fecha: Mayo 2025
