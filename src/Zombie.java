//Se crea la clase Superviviente, la cual es es "hija" de la clase Ente
//Para ello se usa la palabra reservada "extends"
public class Zombie extends Ente{
    //Se establece el método getPoder para poder obtener el poder del zombie, el cuál consideramos que será su fuerza
    public double getPoder(){
        double poder = this.getFuerza();
        return poder;
    }

    //Creamos el método declararVictoria, el cual se usará para imprimir la frase de victoria en "lenguaje zombie"
    public void declararVictoria(){
        //Declaramos un n igual a la longitud de la frase
        int n = this.getFraseVictoria().length();
        //Declaramos un String vacío, el cual iremos "llenando" de letras "Raw" según la longitud (n) de la frase de victoria
        StringBuilder s = new StringBuilder();
        //Procederemos a iterar sobre la longitud de la frase de victoria, de modo que:
        for(int i = 0; i < n; i++){
            //Para cada letra en un espacio múltiplo de 3, le corresponde una R
            if(i%3 == 0){
                s.append("R"); //Luego se añade la letra al String que hemos creado
            }
            //Para cada letra en un espacio consecutivo al del múltiplo de 3, le corresponde una a
            if(i%3 == 1){
                s.append("a");
            }
            //Para cada letra en un espacio consecutivo al anterior, le corresponde una w
            if(i%3 == 2){
                s.append("w");
            }
        }

        System.out.println(s); //Despues de un determinado número de iteraciones, se imprimira el String en "lenguaje zombie" (Raw)
    }

}
