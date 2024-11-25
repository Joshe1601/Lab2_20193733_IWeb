//Se crea la clase Superviviente, la cual es es "hija" de la clase Ente
//Para ello se usa la palabra reservada "extends"
import java.util.ArrayList;

public class Superviviente extends Ente{
    //Se crean sus atributos y se procede a encapsularlos
    private ArrayList<Objeto> inventario = new ArrayList<>();
    private int kills = 0;
    private int sanidad;
    private int valentia;
    private boolean trauma = false;

    //Se usa el método declararVictoria donde se definen dos casos:
    public void declararVictoria(){
        //Si el superviviente está traumado (trauma = true), se procederá a indicar al final una frase adicional y se bajará la mitad de la vida.
        if(trauma){
            super.declararVictoria(); //Sirve para llamar al método heredado la clase padre
            System.out.println("Pero igual este mundo no tiene esperanza");
            double newLife = 0.5*this.getVida(); //Se calcula la mitad de la vida del superviviente
            this.setVida(newLife); //Se coloca la nueva vida del superviviente
        }else{
            super.declararVictoria(); //Si no está traumado simplemente se llama al método heredado para declarar la victoria.
        }
    }

    //Se define el método getPoder para poder obtener el poder del superviviente
    public double getPoder(){

        double suma = 0f; //Se define la variable suma en double
        for (Objeto o: inventario) { //Se hace un "for-each" que recorra los objetos del inventario

            if(o instanceof Arma){ //Se verifica que el objeto es un arma porque solo necesitamos el poder de las armas.
                System.out.println(this.getNombre() + " usa " + o.getNombre()); //Se muestran las armas usadas.
                suma = suma + ((Arma) o).getPoder(); //Se calcula la suma de todos los poderes de las armas.
            }
        }
        double poder = this.getFuerza() + suma; //Se halla el poder total del superviviente sumando su fuerza con el poder de las armas.
        return poder; //El método retorna ese "poder"
    }

    //Se define el método curarse que añadirá puntos de salud al superviviente en caso posea algún ObjetoCurativo.
    public void curarse() {
        int numObjCur = 0; //Se establece una variable auxiliar que indica el número de objetos curativos encontrados.
        for (Objeto o : inventario) { //Se hace un for-each que reccorra nuevamente los objetos del inventario

            if (o instanceof ObjetoCurativo) {//Se verifica que sea un objeto curativo, ya que solo estos añaden PS.
                //Se imprime el nombre del objeto curativo y cuánto PS restaura:
                System.out.println(this.getNombre() + " se ha curado " + ((ObjetoCurativo) o).getVidaRestaurada() + " usando " + o.getNombre());
                double antiguaVida = this.getVida(); //Se crea una variable que almacene la vida del superviviente antes de usar el objeto.
                this.setVida(antiguaVida + ((ObjetoCurativo) o).getVidaRestaurada()); //Se añade los PS que da el objeto al superviviente.
                //Se imprime los nuevos PS del superviviente junto a su nombre:
                System.out.println(this.getNombre() + " superviviente le queda " + this.getVida() + " puntos de vida");
                numObjCur++; //El número de objetos curativos aumenta en 1
                inventario.remove(o); //Se elimina el objeto curativo del inventario del superviviente.
                break; //Si se han encontrado un objeto curativo se usa y se finaliza el for-each loop.

                 /* NOTA: numObjCur no pretende aumentar en un número mayor que uno ya que su aumento se ve interrumpido
                por la instrucción "break". Esto se hace solo con el fin de que detecte que se ha encontrado al menos un
                objeto curativo. Si quisiéramos contar cuantos objetos curativos se ha usado, tendríamos que hacerlo
                de otra forma*/
            }
        }
        if (numObjCur == 0) {
            //Si en caso no haya ningún objeto curativo, se procede a imprimir la sentencia:
            System.out.println("No posee objetos curativos para restablecer su salud");
        }
    }

    //Se encapsulan los atributos con getters y setters:
    public ArrayList<Objeto> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Objeto> inventario) {
        this.inventario = inventario;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getSanidad() {
        return sanidad;
    }

    public void setSanidad(int sanidad) {
        this.sanidad = sanidad;
    }

    public int getValentia() {
        return valentia;
    }

    public void setValentia(int valentia) {
        this.valentia = valentia;
    }

    public boolean isTrauma() {
        return trauma;
    }

    public void setTrauma(boolean trauma) {
        this.trauma = trauma;
    }
}
