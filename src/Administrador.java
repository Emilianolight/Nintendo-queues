
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import javax.swing.JTextField;

public class Administrador {

    int contadorAux = 0;
    Robot robot;
    Cola cola;
    Consola consola;
    JTextField textCola1;
    String texto = "";
    int p;
    Semaphore mutex = new Semaphore(1);

    public Administrador(Robot robot, Cola cola) {
        this.robot = robot;
        this.cola = cola;
        this.textCola1 = textCola1;

    }

    public void encolar(Consola consola) {

        switch (consola.nivel) {
            case 1:
                cola.nivel1.offer(consola);
                break;

            case 2:
                cola.nivel2.offer(consola);
                break;

            case 3:
                cola.nivel3.offer(consola);
                break;
        }
    }

    public void consolaNueva() {
        contadorAux++;
        p = (int) Math.floor(Math.random() * (101 - 1) + 1);
        if (contadorAux % 2 == 0 && p <= 70) {
            encolar(new Consola());
            contadorAux = 0;
        }
    }


    
    public void aumentarContador() {
        if (!cola.nivel2.isEmpty()) {

            for (int i = 0; i < cola.nivel2.size(); i++) {
                consola = (Consola) cola.nivel2.get(i);
                consola.contador++;
                if (consola.contador == 15) {

                    consola = (Consola) cola.nivel2.remove(i);
                    consola.nivel = 1;
                    System.out.println("id " + consola.idConsola + " pasó a cola 1");
                    cola.nivel1.offer(consola);
                } else {
                    cola.nivel2.set(i, consola);
                }
            }
        }
        if (!cola.nivel2.isEmpty()) {
            for (int i = 0; i < cola.nivel3.size(); i++) {
                consola = (Consola) cola.nivel3.get(i);
                consola.contador++;
                if (consola.contador == 15) {
                    consola = (Consola) cola.nivel3.remove(i);
                    consola.nivel = 2;
                    System.out.println("id " + consola.idConsola + " pasó a cola 2");
                    cola.nivel2.offer(consola);
                } else {
                    cola.nivel3.set(i, consola);
                }

            }
        }

    }

    public void pasarAlRobot() {
        consolaNueva();
        colaMejoras();

        aumentarContador();
        if (cola.nivel1.peek() != null) {

            consola = (Consola) cola.nivel1.poll();

            robot.Revision(consola);
        } else if (cola.nivel2.peek() != null) {

            consola = (Consola) cola.nivel2.poll();

            robot.Revision(consola);
        } else if (cola.nivel3.peek() != null) {

            consola = (Consola) cola.nivel3.poll();

            robot.Revision(consola);
        }

    }

    public void colaMejoras() {
        p = (int) Math.floor(Math.random() * (101 - 1) + 1);
        if (p <= 45 && !cola.mejoras.isEmpty()) {
            consola = (Consola) cola.mejoras.poll();
            encolar(consola);
        }

    }
    
    //    public void mostrarCola() {
//        if (!cola.nivel1.isEmpty()) {
//            for (int i = 0; i < cola.nivel1.size(); i++) {
//                consola = (Consola) cola.nivel1.get(i);
//                texto += Integer.toString(consola.idConsola) + ",";
//
//            }
////            System.out.println("Cola 1: " + texto);
//            texto = "";
//        }
//        if (!cola.nivel2.isEmpty()) {
//            for (int i = 0; i < cola.nivel2.size(); i++) {
//                consola = (Consola) cola.nivel2.get(i);
//                texto += Integer.toString(consola.idConsola) + ",";
//
//            }
////            System.out.println("Cola 2: " + texto);
//            texto = "";
//        }
//        if (!cola.nivel3.isEmpty()) {
//            for (int i = 0; i < cola.nivel3.size(); i++) {
//                consola = (Consola) cola.nivel3.get(i);
//                texto += Integer.toString(consola.idConsola) + ",";
//
//            }
////            System.out.println("Cola 3: " + texto);
//            texto = "";
//        }
//        if (!cola.mejoras.isEmpty()) {
//            for (int i = 0; i < cola.mejoras.size(); i++) {
//                consola = (Consola) cola.mejoras.get(i);
//                texto += Integer.toString(consola.idConsola) + ",";
//
//            }
////            System.out.println("Cola mejoras: " + texto);
//            texto = "";
//        }
//        texto = "";
//    }
    
}
