
package modelo;

/**
 *
 * @author Oscar
 */
public class Cuestionario {

    private long PIN;
    private String titulo;
    private String descripcion;
    private String estado;

    private String pregunta;
    private int tiempo;
    private int punteo;

    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;

    private String respuestaCorrecta;
    
 

    public Cuestionario(String titulo, String descripcion, String estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Cuestionario(String pregunta, int tiempo, int punteo, String respuesta1, String respuesta2, String respuesta3, String respuesta4, String respuestaCorrecta) {
        this.pregunta = pregunta;
        this.tiempo = tiempo;
        this.punteo = punteo;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Cuestionario(String titulo, String descripcion, String estado, String pregunta, int tiempo, int punteo, String respuesta1, String respuesta2, String respuesta3, String respuesta4, String respuestaCorrecta) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.pregunta = pregunta;
        this.tiempo = tiempo;
        this.punteo = punteo;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    

    public long getPIN() {
        return PIN;
    }

    public void setPIN(long PIN) {
        this.PIN = PIN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    
    
    
    

}
