//Se crea la clase Objeto, la cual será una de las dos clases "Padres"
public class Objeto {

    String nombre;
    String descripcion;
    /*Se crea un constructor de Objeto que permite crear una instancia de esta clase con
    los parámetros que se ven a continuación.*/
    public Objeto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    //Se encapsulan los atributos:
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
