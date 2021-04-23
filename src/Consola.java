/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emiliano
 */
public class Consola {

    public static int id = 1;
    int nivel;
    int contador;
    int idConsola;

    public Consola() {
        this.nivel = (int) Math.floor(Math.random() * (4 - 1) + 1);
        this.contador = 0;
        this.idConsola = Consola.id++;
    }

}
