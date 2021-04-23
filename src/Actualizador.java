
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emiliano
 */
public class Actualizador extends Thread {

    Consola consola;
    String texto = "";
    LinkedList lista;
    JTextField textcola;
    JTextField textrobot;
    Semaphore sem;
    Robot robot;

    public Actualizador(LinkedList lista, JTextField textcola, Semaphore sem, Robot robot, JTextField textrobot) {
        this.lista = lista;

        this.textcola = textcola;
        this.sem = sem;
        this.robot = robot;
        this.textrobot = textrobot;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                sem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Actualizador.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (textrobot.getText() != null) {
                textrobot.setText(Integer.toString(robot.revision));
            }
            sem.release();

            if (!lista.isEmpty()) {
                for (int i = 0; i < lista.size(); i++) {
                    consola = (Consola) lista.get(i);
                    texto += Integer.toString(consola.idConsola) + ",";

                }

//                System.out.println("cola: " + texto);
                textcola.setText(texto);
            } else {
                textcola.setText("");
            }
            texto = "";

        }
    }
}
