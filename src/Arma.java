//Se crea la clase Arma, la cual es es "hija" de la clase Objeto
//Para ello se usa la palabra reservada "extends"
public class Arma extends Objeto{

    //Se crean los atributos que serán propios solamente del arma.
    double poder;
    double valentia;

    /*Se crea un constructor de Arma que permite crear una instancia de esta clase con
    los parámetros que se ven a continuación.*/
    public Arma(String nombre, String descripcion, double poder, double valentia) {
        super(nombre, descripcion); //Sirve para llamar al constructor de la clase padre
        this.poder = poder;
        this.valentia = valentia;
    }


    //Se encapsulan los atributos:
    public double getPoder() {
        return poder;
    }

    public void setPoder(double poder) {
        this.poder = poder;
    }

    public double getValentia() {
        return valentia;
    }

    public void setValentia(double valentia) {
        this.valentia = valentia;
    }
}
