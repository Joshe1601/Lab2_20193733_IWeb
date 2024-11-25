import java.util.*; //Se importa la clase para el uso de distintos métodos (Math, Collections, Scanner, etc).

//Se crea la clase AppController que será la encargada de controlar casi todo el funcionamiento del programa.
public class AppController {

    Scanner sc = new Scanner(System.in); //Sirve para recibir entradas por el teclado

    //Se crea un método que permita agregar objetos.
    public void agregarObjeto(ArrayList<Objeto> lista)
    {
        //El programa pide que se ingrese el nombre, uso y tipo de objeto mediante el siguiente código:
        System.out.print("Indique el nombre del objeto: ");
        String name = sc.nextLine();
        System.out.print("Indique el uso del objeto: ");

        String use = sc.nextLine();
        System.out.println("Elija el tipo de objeto:");



        System.out.println("1. Arma");
        System.out.println("2. Objeto curativo");
        System.out.println("3. Otro");
        String opt = sc.nextLine();

        //Como debemos elegir una opción, usamos "switch" para variar entre casos y acciones.
        switch (opt) {
            case "1" -> {//En este caso añadimos un arma
                while (true) { //Establecemos un bucle while que solo finalizará si cumplimos una determinada condición.
                    System.out.println("Indique el poder del arma");
                    String powerStr = sc.nextLine();
                    int power = Integer.parseInt(powerStr); //Ingresamos el poder del arma y lo convertimos a entero.

                    if (power > 0 && power < 1000) { //La condición mencionada es que el poder ingresado debe ser mayor que 0 y menor que 1000
                        double valentia = 0f;
                        Arma arma = new Arma(name, use, power, valentia); //Se crea la instancia de la clase con el constructor
                        lista.add(arma); //Se añade el arma a la lista de objetos.
                        break; //Se finaliza el bucle while
                    } else {
                        //Si en caso no ingresamos un valor de poder entre 0 y 1000, nos lo avisará y volveremos a reptir el bucle.
                        System.out.println("Debe ingresar un poder mayor a 0 y menor a 1000");
                    }
                }
            }
            case "2" -> { //En este caso añadimos un objeto curativo
                System.out.println("Indique la vida que restaura el objeto:");
                String vidaStr = sc.nextLine();
                int vida = Integer.parseInt(vidaStr); //Ingresamos los PS de restauración, aunque en este caso no se validan.
                ObjetoCurativo objCur = new ObjetoCurativo(name, use, vida); //Se crea la instancia de la clase con el constructor
                lista.add(objCur); //Se añade el objeto curativo a la lista de objetos.
            }
            case "3" -> { //En este caso añadimos cualquier otro objeto directamente a la lista de objetos.
                Objeto obj = new Objeto(name, use);
                lista.add(obj);
            }
        }




    }

    //Se crea un método que permite agregar zombies
    public void agregarZombie(ArrayList<Ente> lista)
    {
        Zombie zomb = new Zombie(); //Se crea un nuevo objeto del tipo "Zombie" (instancia de la clase).

        //Se solicita y se ingresa en la consola cada uno de los atributos requeridos:
        System.out.println("Indique el nombre del zombie");
        String name = sc.nextLine();
        zomb.setNombre(name); //Se establece el atributo nombre del objeto creado

        System.out.println("Indique la fuerza del zombie");
        String forceStr = sc.nextLine();
        double force = Double.parseDouble(forceStr); //En este caso la fuerza ingresada debe convertirse a double y no a int.
        zomb.setFuerza(force); //Se establece el atributo fuerza del objeto creado

        System.out.println("Indique la defensa del zombie");
        String defenseStr = sc.nextLine();
        double defense = Double.parseDouble(defenseStr); //Debe convertirse a double.
        zomb.setDefensa(defense); //Se establece el atributo defensa del objeto creado

        System.out.println("Indique la velocidad del zombie");
        String speedStr = sc.nextLine();
        double speed = Double.parseDouble(speedStr);
        zomb.setVelocidad(speed); //Se establece el atributo velocidad del objeto creado

        System.out.println("Indique la vida del zombie");
        String lifeStr = sc.nextLine();
        double life = Double.parseDouble(lifeStr);
        zomb.setVida(life); //Se establece el atributo vida del objeto creado

        System.out.println("Indique una frase de victoria que diría:");
        String phrase = sc.nextLine();
        zomb.setFraseVictoria(phrase); //Se establece la frase de victoria del objeto creado

        lista.add(zomb); //Se añade el objeto zombie creado a la lista de entes.
    }

    //Se crea un método que permite agregar supervivientes
    public void agregarSuperviviente(ArrayList<Ente> lista,ArrayList<Objeto> objetos) {

        Superviviente sup = new Superviviente(); //Se crea un nuevo objeto del tipo "Superviviente"

        /*Al igual que en el método anterior, se solicita y se ingresa por consola los atributos respectivos para
        el superviviente, se realiza la conversión a double o int para los atributos que lo requieran y,
        se establecen cada uno de ellos al objeto superviviente creado mediante setters*/
        System.out.println("Indique el nombre del superviviente:");
        String name = sc.nextLine();
        sup.setNombre(name);

        System.out.println("Indique la fuerza del superviviente:");
        String forceStr = sc.nextLine();
        double force = Double.parseDouble(forceStr);
        sup.setFuerza(force);

        System.out.println("Indique la defensa del superviviente:");
        String defenseStr = sc.nextLine();
        double defense = Double.parseDouble(defenseStr);
        sup.setDefensa(defense);

        System.out.println("Indique la velocidad del superviviente:");
        String speedStr = sc.nextLine();
        double speed = Double.parseDouble(speedStr);
        sup.setVelocidad(speed);

        System.out.println("Indique la vida del superviviente:");
        String lifeStr = sc.nextLine();
        double life = Double.parseDouble(lifeStr);
        sup.setVida(life);

        System.out.println("Indique la valentía del superviviente:");
        String valStr = sc.nextLine();
        int val = Integer.parseInt(valStr);
        sup.setValentia(val);

        int sanidad = 255 - (int) force - (int) defense; //Casteo para volveros enteros.
        sup.setSanidad(sanidad);

        System.out.println("Indique una frase de victoria que diría:");
        String phrase = sc.nextLine();
        sup.setFraseVictoria(phrase);

        System.out.println("Indique la cantidad de objetos que tendrá:");
        String objtStr = sc.nextLine();
        int objt = Integer.parseInt(objtStr); //Se señala el número de objetos que tendrá el superviviente

        //Se crea un bucle while que finalizará cuando el inventario del superviviente tenga el tamaño de los objetos ingresados.
        while (sup.getInventario().size() < objt) {
            //Se define un índice aleatorio el cual señalará un lugar aleatorio de la lista "objetos":
            int randIn = (int) (Math.random() * objetos.size());
            Objeto armaRand = objetos.get(randIn); //Se "extrae" el objeto ubicado en ese lugar aleatorio y se almacena en una variable.
            /*Se verifica ( mediante contains() ) que el inventario no posea ese objeto, de lo contrario, no se añadirá
            y se volverá a solicitar un índice aleatorio:*/
            if (!sup.getInventario().contains(armaRand)) {
                System.out.println(objetos.get(randIn).getNombre() + " añadido"); //Se imprime que se añadió el objeto
                sup.getInventario().add(armaRand); //Se añade el objeto al inventario del superviviente (el cual es una lista).
            }
        }
        lista.add(sup); //Se añade el objeto superviviente creado a la lista de entes.
    }


    //Se crea un método que permita verificar que haya o no haya zombies y supervivientes.
    public int verificarListaPura(ArrayList<Ente> lista){
        if(lista.isEmpty()){ //Se verifica si la lista de entes está vacía
            return 0; //Si lo está, devuelve el número 0, el cuál será uno de nuestros casos en el "main".
        }
        int supEncontrado = 0; //Definimos con 0 a si hemos encontrado supervivientes
        int zombEncontrado = 0; //Definimos con 0 a si hemos encontrado zombies

        for(Ente e : lista) { //Usamos un for-each para recorrer la lista de entes
            if (e instanceof Superviviente) { //Verificamos que uno de esos entes sea un superviviente
                supEncontrado = 1; //En caso de serlo, el valor de la variable cambia a 1.
            }
            if(e instanceof Zombie){ //Verificamos que uno de esos entes sea un zombie
                zombEncontrado = 1; //En caso de serlo, el valor de la variable cambia a 1.
            }
            /*NOTA: Solo nos interesa saber si hay al menos un superviviente o un zombie, no nos pide conocer con
             exactitud cuántos de ellos hay, si quisieramos hacerlo así, tendríamos que usar un contador*/
        }

        //Ahora evaluamos los casos
        if(supEncontrado == 1 && zombEncontrado == 0){ //Si encontró al menos un superviviente pero ningún zombie:
            return 1; //Se retorna el número 1, el cual será otro caso en el "main".
        } else if(supEncontrado == 0 && zombEncontrado == 1){ //Si encontró al menos un zombie pero ningún superviviente:
            return 2; //Se retorna el valor 2, el cual será otro caso en el "main".
        } else if(supEncontrado == 1){ //Si encontró al menos un zombie y un superviviente:
            return 3; //Se retorna el valor 3, el cual será el útimo caso en el "main".
        }

        return 0;//De no cumplirse ninguno de los casos anteriores, retorna 0 porque no encontró ni zombies ni supervivientes.
    }

    //Se crea un método que permite obtener el superviviente más valiente de todos:
    public Superviviente obtenerSupervivienteMasValiente(ArrayList<Ente> lista){
        /*NOTA: Este es una resolución que se me ocurrió con la clase java.util.Collections, en particular con el
        * método Collections.max()*/
        HashSet<Integer> valent = new HashSet<>(); //Se crea una lista HashSet que almacene números enteros

        for (Ente e : lista) { // Usamos un for-each para recorrer la lista de entes
            if (e instanceof Superviviente) { //Verificamos que sea un ente tipo superviviente
                double s1D = ((Superviviente) e).getValentia();//Casteamos al ente como superviviente y obtenemos su valentía.
                int s1 = (int) s1D; //Convertimos esta valentía double a entero haciendo un casteo.
                valent.add(s1); //Finalmente añadimos esa valentía en forma de entero al HashSet
            } //Este proceso se repite con cada una de las valentias de los supervivientes
        }
        /*Ahora se usará el método Collections.max(), el cual devolverá el máximo valor de la lista,
        considerándola como una colección:*/
        int vSuper = Collections.max(valent);

        Superviviente superviv = null; //Definimos una variable del tipo Superviviente
        for (Ente e : lista) { //Utilizamos una vez más el for-each para recorrer la lista de entes
            if (e instanceof Superviviente) { //Verificamos que sea un superviviente
                //Ahora comparamos el valor máximo de la valentía obtenida con la valentía de cada uno de los supervivientes:
                if (vSuper == (int) ((Superviviente) e).getValentia()) {
                    superviv = (Superviviente) e; //Cuando ambos valores coincidan, habremos encontrado al más valiente.
                    //Luego actualizaremos la variable definida a este superviviente más valiente encontrado.
                }
            }
        }
        return superviv; //Finalmente, el método retornará el superviviente más valiente encontrado.
    }

    //Se crea un método que permite obtener el zombie más debil de todos:
    public Zombie obtenerZombieMasDebil(ArrayList<Ente> lista) {
        /*NOTA: Este es una resolución que se me ocurrió con la clase java.util.Collections, en particular con el
         método Collections.min(). El proceso es similar al visto anteriormente.*/
        HashSet<Integer> fuerza = new HashSet<>(); //Se crea una lista HashSet que almacene números enteros

        for (Ente e : lista) { // Usamos un for-each para recorrer la lista de entes
            if (e instanceof Zombie) { //Verificamos que sea un ente tipo zombie
                double z1D = e.getFuerza(); //Obtenemos la fuerza del zombie.
                int z1 = (int) z1D; //Convertimos esta fuerza double a entero haciendo un casteo.
                fuerza.add(z1); //Finalmente añadimos esa fuerza en forma de entero al HashSet
            }//Este proceso se repite con cada una de las fuerzas de los zombies
        }
        /*Ahora se usará el método Collections.min(), el cual devolverá el mínimo valor de la lista,
        considerándola como una colección:*/
        int fZombie = Collections.min(fuerza);

        Zombie zombie = null;//Definimos una variable del tipo Zombie
        for (Ente e : lista) {//Utilizamos una vez más el for-each para recorrer la lista de entes
            if (e instanceof Zombie) {//Verificamos que sea un zombie
                //Ahora comparamos el valor mínimo de la fuerza obtenida con la fuerza de cada uno de los zombies:
                if (fZombie == (int) e.getFuerza()) {
                    zombie = (Zombie) e; //Cuando ambos valores coincidan, habremos encontrado al más débil.
                    //Luego actualizaremos la variable definida a este zombie más débil encontrado.
                }
            }
        }
        return zombie; //Finalmente, el método retornará el zombie más débil encontrado.
    }

    //Se crea un método donde se realiza el proceso de ataque del superviviente al zombie
    public void atacarZombie(double poder, Zombie zombie)
    {
        double vidaZombieAnterior = zombie.getVida(); //Obtenemos la vida del zombie antes de que lo ataquen
        /*Debido a que la defensa puede o no puede ser demasiado grande, se usa el método Math.max() para que devuelva
         el resultado de restar el poder del superviviente menos la defensa del zombie en caso de ser positivo, y 0 en
         caso de que lo anterior sea negativo. esto siginifica que ante una defensa grande, el zombie puede que no
         reciba mucho daño: */
        double vidaZombie = vidaZombieAnterior - Math.max(poder - zombie.getDefensa(), 0); //Obtenemos su vida después del ataque
        zombie.setVida(vidaZombie); //Cambiamos la vida anterior del zombie por la vida reciente
        double danho = vidaZombieAnterior - vidaZombie; //Calculamos el daño que le hizo el superviviente

        double variacion = ((vidaZombieAnterior-vidaZombie)/vidaZombieAnterior)*100; //Calculamos el porcentaje de variación de su vida
        System.out.println("El daño que el zombie recibió es " + danho); //Imprime el daño ocasionado al zombie
        if(variacion < 10){ //Verificamos si el porcentaje de variación es menor al 10%
            double newDefense = 0.75*zombie.getDefensa(); //En caso de ser así, la defensa del zombie se reduce en un 25% (1 - 0.25)
            zombie.setDefensa(newDefense); //Cambiamos la defensa anterior por la nueva defensa del zombie
            System.out.println("El superviviente ha roto la defensa"); //Se imprime la sentencia requerida.
        }


    }

    //Se crea un método donde se realiza el proceso de ataque del zombie al superviviente
    public void defenderseDeZombie(double poder, Superviviente superviviente)
    {
        double vidaSupervivienteAnterior = superviviente.getVida(); //Obtenemos la vida del superviviente antes de que lo ataquen
        /*Debido a que la defensa puede o no puede ser demasiado grande, se usa el método Math.max() para que devuelva
         el resultado de restar el poder del superviviente menos la defensa del zombie en caso de ser positivo, y 0 en
         caso de que lo anterior sea negativo. esto siginifica que ante una defensa grande, el superviviente puede que
         no reciba mucho daño: */
        double vidaSuperviviente = vidaSupervivienteAnterior - Math.max(poder - superviviente.getDefensa(),0);//Obtenemos su vida después del ataque
        superviviente.setVida(vidaSuperviviente);//Cambiamos la vida anterior del superviviente por la vida reciente
        double danho = vidaSupervivienteAnterior - vidaSuperviviente; //Calculamos el daño que le hizo el zombie

        System.out.println("El daño que el superviviente recibió es " + danho); //Imprime el daño ocasionado al superviviente
        //Se crea una condicional en el cual se evalúe si un número aleatorio entre [0;1] es mayor que 0.5
        //Esto debido a que hay un 50% de probabilidad de que el superviviente quede asustado
        if(Math.random() >= 0.5){
            int sanidadAnterior = superviviente.getSanidad(); // Obtenemos la sanidad del superviviente antes de asustarse
            double sanidadSup = sanidadAnterior - superviviente.getFuerza(); //Calculamos la nueva sanidad
            if(sanidadSup <= 0){ //Verificamos si la sanidad es 0 o negativa
                superviviente.setTrauma(true); //En caso de serlo, el superviviente quedará traumado para toda la partida
                //Se cambia el valor booleano del atributo trauma a "true".
                System.out.println("El superviviente quedó traumado"); //Se imprime la sentencia requerida
            }
        }
    }

    //Creamos un método que realice los procesos correspondientes si un zombie muere
    public void zombieMuerto(Zombie zombieActivo, Superviviente supervivienteActivo){
        //El superviviente declara su victoria sobre el zombie al mismo tiempo que se evalúa si quedó traumado (ver método declararVictoria):
        supervivienteActivo.declararVictoria();
        //Se imprime el nombre del zombie muerto:
        System.out.println("El zombie " + zombieActivo.getNombre() + " ha perecido, victoria para los sobrevivientes");
        //Se imprime el nombre del superviviente que lucha y los puntos de vida que le quedan:
        System.out.println("Superviviente " + supervivienteActivo.getNombre() + " le queda " + supervivienteActivo.getVida() + "puntos de vida");
        int i = supervivienteActivo.getKills(); //Se obtienen las kills actuales del superviviente
        supervivienteActivo.setKills(i+1); //Se aumentan sus kills en 1
        supervivienteActivo.curarse(); //El superviviente se cura en caso de que posea objetos curativos
    }

    //Creamos un método que realice los procesos correspondientes si un superviviente muere
    public void supervivienteMuerto(Zombie zombieActivo, Superviviente supervivienteActivo){
        //El zombie declara su victoria sobre el superviviente en su lenguaje (ver método declararVictoria):
        zombieActivo.declararVictoria();
        //Se imprime el nombre del superviviente muerto y sus kills:
        System.out.println("Superviviente " + supervivienteActivo.getNombre() + " ha muerto, habiendo aniquilado " + supervivienteActivo.getKills() + " zombies");
        //Se imprime el nombre del zombie que lucha y sus puntos de vida
        System.out.println("Zombie " + zombieActivo.getNombre() + " aun le queda " +  zombieActivo.getVida() + " puntos de vida");
    }

}
