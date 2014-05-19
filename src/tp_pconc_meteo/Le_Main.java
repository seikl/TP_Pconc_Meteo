/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_pconc_meteo;

/**
 *
 * @author skl
 */
public class Le_Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("heleo world! V2");
        
            Phenomene temperature = new Ecriture("a ", 10, 05);
    Ecriture e2 = new Ecriture("Z ", 12, 10);
    Ecriture e3 = new Ecriture("\n", 05, 15); // Texte : saut de ligne !
    
    Thread thr1 = new Thread(e1); // e1 est devenu un Thread sour le nom thr1. 
    thr1.start();
    
    }
    
}
