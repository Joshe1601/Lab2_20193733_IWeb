//Se crea la clase Ente, la cual será una de las dos clases "Padres"
public class Ente {
    //Se crean los atributos y se encapsulan en getters y setters para cada uno, respectivamente.
    private String nombre;
    private double fuerza;
    private double defensa;
    private double velocidad;
    private double vida;
    private String fraseVictoria;

    //Se define el método declararVictoria el cual será heredado a las clases hijas "Superviviente" y "Zombie"
    public void declararVictoria(){
        System.out.println(nombre + ": " + fraseVictoria);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public String getFraseVictoria() {
        return fraseVictoria;
    }

    public void setFraseVictoria(String fraseVictoria) {
        this.fraseVictoria = fraseVictoria;
    }
}
