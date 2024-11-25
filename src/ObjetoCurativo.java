//Se crea la clase ObjetoCurativo, la cual es es "hija" de la clase Objeto
//Para ello se usa la palabra reservada "extends"
public class ObjetoCurativo extends Objeto{

    //Se crea el atributo que será propio solamente del objeto curativo
    //El atributo de vidaRestaurada almacenará los PS que añadirá a la vida del superviviente.
    int vidaRestaurada;

    /*Se crea un constructor de ObjetoCurativo que permite crear una instancia de esta clase con
    los parámetros que se ven a continuación.*/
    public ObjetoCurativo(String nombre, String descripcion, int vidaRestaurada) {
        super(nombre, descripcion); //Sirve para llamar al constructor de la clase padre
        this.vidaRestaurada = vidaRestaurada;
    }

    //Se encapsulan los atributos:
    public int getVidaRestaurada() {
        return vidaRestaurada;
    }

    public void setVidaRestaurada(int vidaRestaurada) {
        this.vidaRestaurada = vidaRestaurada;
    }
}
