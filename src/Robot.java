
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emiliano
 */
public class Robot {

    int p;
    Cola cola;
    int aux;
    Semaphore sem = new Semaphore(1);
    int revision;
//

    public Robot(Cola cola) {
        this.cola = cola;
    }

    public void Revision(Consola consola) {
        revision = consola.idConsola;
        try {
            Thread.sleep(7000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
        }
        p = (int) Math.floor(Math.random() * (101 - 1) + 1);
        aux = consola.nivel;
        consola.contador = 0;
        switch (aux) {

            case 1:
                if (p <= 30 && consola.contador == 0) {

                } else if (p <= 30 && consola.contador > 0) {

                } else if (p > 30 && p <= 80) {

                    cola.nivel1.offer(consola);

                } else if (p > 80) {

                    cola.mejoras.offer(consola);

                }

                break;

            case 2:
                if (p <= 30 && consola.contador == 0) {

                } else if (p <= 30 && consola.contador > 0) {

                } else if (p > 30 && p <= 80) {
                    cola.nivel2.offer(consola);
                } else if (p > 80) {
                    cola.mejoras.offer(consola);
                }
                break;
            case 3:
                if (p <= 30 && consola.contador == 0) {

                } else if (p <= 30 && consola.contador > 0) {

                } else if (p > 30 && p <= 80) {
                    cola.nivel3.offer(consola);
                } else if (p > 80) {
                    cola.mejoras.offer(consola);
                }
                break;
        }
    }
}
