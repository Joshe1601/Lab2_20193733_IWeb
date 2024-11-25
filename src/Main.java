import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenido a Zombiweb, donde la mayor pesadilla esta por llegar");
        System.out.println("En la primera etapa vas a configurar tu partida y en la segunda los zombies van a ir a por ti buahaha");
        boolean finInicio = false;
        boolean finjuego = false;

        Scanner sc = new Scanner(System.in);
        ArrayList<Objeto> objetos = new ArrayList<>();
        ArrayList<Ente> entes = new ArrayList<>();
        AppController controller = new AppController();

        while (!finInicio) {
            System.out.println("Elige la opcion que desees: ");
            System.out.println("1. Añadir objetos a la lista");
            System.out.println("2. Añadir un superviviente");
            System.out.println("3. Añadir un zombie");
            System.out.println("5. Empezar el juego");

            String opcion = sc.nextLine(); //Se recibe la opción que uno escoja

            switch (opcion){ //Dependiendo a esa opción se ejecutan algunos de los métodos (ver métodos)
                case "1" -> controller.agregarObjeto(objetos);
                case "2" -> controller.agregarSuperviviente(entes,objetos);
                case "3" -> controller.agregarZombie(entes);
                case "5" -> {
                    int res = controller.verificarListaPura(entes);
                    switch (res) {
                        //En caso de que al verificar la lista, el método nos retorne 0, se imprimirá:
                        case 0 -> System.out.println("No se tienen elementos en la lista");//No se encontraron ninguno
                        //En caso nos retorne 1, se imprimirá:
                        case 1 -> System.out.println("No se tienen zombies");//No se encontraron zombies
                        //En caso nos retorne 2, se imprimirá:
                        case 2 -> System.out.println("No se tienen supervivientes");//No se encontraron supervivientes
                        //En caso nos retorne 3, se imprimirá:
                        case 3 -> {
                            System.out.println("Juego iniciado"); //Se encontraron ambos
                            /*Se procede a cambiar el valor booleano de la variable finInicio,
                            se romperá el ciclo while y se procederá a iniciar el juego*/
                            finInicio = true;
                        }
                    }

                }
            }
        }

        /*Con un bucle while se empieza el juego hasta que no queden o zombies o supervivientes, es decir, hasta que no
         se finalice el juego y la variable finJuego no tome un valor booleano igual a true*/
        while (!finjuego)
        {

            //Se obtiene el superviviente más valiente mediante el método y pasa a ser el superviviente activo en la partida:
            Superviviente supervivienteActivo = controller.obtenerSupervivienteMasValiente(entes);
            //Se imprime el nombre del superviviente activo:
            System.out.println(supervivienteActivo.getNombre() + " ha decidido pelear");
            //Se obtiene el zombie más debil mediante el método y pasa a ser el zombie activo en la partida:
            Zombie zombieActivo = controller.obtenerZombieMasDebil(entes);
            //Se imprime el nombre del zombie:
            System.out.println("Se realizará el combate contra el zombie " + zombieActivo.getNombre());
            //Se establece un valor booleano para la variable terminoBatalla, la cual cambiará si finaliza la batalla.
            boolean terminoBatalla = false;

            /*Se crea un bucle while para que esté activa mientras no finaliza la batalla, es decir, mientras
             el valor booleano de terminoBatalla no sea igual a true*/
            while(!terminoBatalla) {
                //Verificamos primero quien es más rápido:

                // En caso de que el superviviente sea más rápido:
                if (supervivienteActivo.getVelocidad() > zombieActivo.getVelocidad()) { //Comparamos velocidades
                    //Realizamos un bucle que mantenga en pelea a ambos hasta que uno tenga vida 0 o negativa:
                    while (true) {
                        controller.atacarZombie(supervivienteActivo.getPoder(), zombieActivo); //Superviviente ataca primero
                        if (zombieActivo.getVida() > 0) { //Si el zombie sigue vivo, va a defenderse
                            //Zombie se defiende y ataca:
                            controller.defenderseDeZombie(zombieActivo.getPoder(), supervivienteActivo);

                            //Verificamos si el superviviente sigue vivo o muere:

                            //Si en caso el superviviente muere:
                            if (supervivienteActivo.getVida() <= 0) {
                                //Se llama al métoo supervivienteMuerto, el cual ejecuta acciones si esto ocurre (Ver método)
                                controller.supervivienteMuerto(zombieActivo, supervivienteActivo);
                                entes.remove(supervivienteActivo); //Se elimina el superviviente de la lista
                                terminoBatalla = true; //El valor booleano cambia a true, por lo que la batalla termina
                                break; //Salimos del ciclo while true.
                            }
                        } else if (zombieActivo.getVida() <= 0) { //Si el zombie muere con el primer ataque del superviviente:
                            //Se llama al métoo zombieMuerto, el cual ejecuta acciones si esto ocurre (Ver método)
                            controller.zombieMuerto(zombieActivo, supervivienteActivo);
                            entes.remove(zombieActivo); //Se elimina el zombie de la lista
                            terminoBatalla = true; //El valor booleano cambia a true, por lo que la batalla termina
                            break; //Salimos del ciclo while true.
                        }
                    }

                // En caso de que el zombie sea más rápido:
                } else { //Ya no se compara porque se supone que la velocidad del zombie es mayor
                    //Realizamos un bucle que mantenga en pelea a ambos hasta que uno tenga vida 0 o negativa:
                    while (true) {
                        controller.defenderseDeZombie(zombieActivo.getPoder(), supervivienteActivo); //Zombie ataca primero
                        if (supervivienteActivo.getVida() > 0) { //Si el superviviente sigue vivo, va a defenderse
                            //Superviviente se defiende y ataca:
                            controller.atacarZombie(supervivienteActivo.getPoder(), zombieActivo);

                            //Verificamos si el zombie sigue vivo o muere:

                            //Si en caso el zombie muere:
                            if (zombieActivo.getVida() <= 0) {
                                //Se llama al métoo zombieMuerto, el cual ejecuta acciones si esto ocurre (Ver método)
                                controller.zombieMuerto(zombieActivo, supervivienteActivo);
                                entes.remove(zombieActivo); //Se elimina el zombie de la lista
                                terminoBatalla = true; //El valor booleano cambia a true, por lo que la batalla termina
                                break; //Salimos del ciclo while true.
                            }
                        } else if (supervivienteActivo.getVida() <= 0) { //Si el superviviente muere con el primer ataque del zombie:
                            //Se llama al métoo supervivienteMuerto, el cual ejecuta acciones si esto ocurre (Ver método)
                            controller.supervivienteMuerto(zombieActivo, supervivienteActivo);
                            entes.remove(supervivienteActivo); //Se elimina el superviviente de la lista
                            terminoBatalla = true; //El valor booleano cambia a true, por lo que la batalla termina
                            break; //Salimos del ciclo while true.
                        }
                    }
                }
            }

            //Definimos dos contadores que nos ayudarán a saber cuántos supervivientes o zombies quedan
            int count1 = 0; //Contador para supervivientes
            int count2 = 0; //Contador para zombies

            for(Ente e: entes){ //Usamos for-each para recorrer la lista entes
                if(e instanceof Superviviente){ //Verificamos que sea un superviviente
                    count1++; //En caso de serlo, el contador de supervivientes aumenta en 1;
                } else { //Si no es superviviente, entonces será un zombie
                    count2++; //En caso de serlo, el contador de zombies aumenta en 1
                }
            }

            //En caso de que alguno de los dos contadores sea 0 en algún momento:

            //Si el contador 1 es igual a 0, quiere decir que no hay más sobrevivientes
            if(count1 == 0){ //Comparamos
                //Si es cierto, se imprime las sentencias requeridas:
                System.out.println("No queda ningún superviviente vivo. Los Zombies arrasaron con el mundo.");
                System.out.println("--- GAME OVER ---");
                //Es el fin del juego, los zombies han ganado y el valor booleano de la variable cambia a true:
                finjuego = true;
                //Es el fin del programa.

            } else if(count2 == 0){//Si el contador 2 es igual a 0, quiere decir que no hay más zombies y comparamos.
                //Si es cierto, se imprime la sentencia requerida:
                System.out.println("No queda ningún zombie, el mundo se ha salvado de esta crisis, pero aún hay mucho que trabajar");
                //Es el fin del juego, los supervivientes han ganado y el valor booleano de la variable cambia a true:
                finjuego = true;
                //Es el fin del programa.
            }
        }
    }

}