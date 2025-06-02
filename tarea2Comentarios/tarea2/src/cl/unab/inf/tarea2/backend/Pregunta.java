package cl.unab.inf.tarea2.backend;

public class Pregunta {
    private String enunciado;
    private String nivelTaxonomico;
    private String tipo;
    private int tiempoEstimado;
    private String respuestaUsuario;
    private String solucionCorrecta;

    public Pregunta(String enunciado, String nivelTaxonomico, String tipo, int tiempoEstimado) {
        this.enunciado = enunciado;
        this.nivelTaxonomico = nivelTaxonomico;
        this.tipo = tipo;
        this.tiempoEstimado = tiempoEstimado;
        this.respuestaUsuario = "";
        this.solucionCorrecta = "";
    }

    // Getters y setters
    public String getEnunciado() { return enunciado; }
    public void setEnunciado(String enunciado) { this.enunciado = enunciado; }

    public String getNivelTaxonomico() { return nivelTaxonomico; }
    public void setNivelTaxonomico(String nivelTaxonomico) { this.nivelTaxonomico = nivelTaxonomico; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getTiempoEstimado() { return tiempoEstimado; }
    public void setTiempoEstimado(int tiempoEstimado) { this.tiempoEstimado = tiempoEstimado; }

    public String getRespuestaUsuario() { return respuestaUsuario; }
    public void setRespuestaUsuario(String respuestaUsuario) { this.respuestaUsuario = respuestaUsuario; }

    public String getSolucionCorrecta() { return solucionCorrecta; }
    public void setSolucionCorrecta(String solucionCorrecta) { this.solucionCorrecta = solucionCorrecta; }

    // Método para validar si la respuesta del usuario es correcta
    public boolean esRespuestaCorrecta() {
        if (respuestaUsuario == null || solucionCorrecta == null) return false;
        return respuestaUsuario.trim().equalsIgnoreCase(solucionCorrecta.trim());
    }

    // Mostrar pregunta (puede usarse para debug)
    public void mostrarPregunta() {
        System.out.println("Enunciado: " + enunciado);
        System.out.println("Nivel Taxonómico: " + nivelTaxonomico);
        System.out.println("Tipo: " + tipo);
        System.out.println("Tiempo Estimado: " + tiempoEstimado + " minutos");
    }
}