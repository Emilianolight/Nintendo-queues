
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
public class Hilo extends Thread {

    Semaphore sem;
    Robot robot;
    Administrador admin;
    Cola cola;
    boolean seguir = true;

    public Hilo(Robot robot, Administrador admin, Semaphore sem) {
        this.robot = robot;
        this.admin = admin;
        this.sem = sem;
    }

    public void run() {
        robot.Revision(new Consola());
        while (seguir) {
            admin.aumentarContador();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }

            admin.pasarAlRobot();
        }

    }

}
