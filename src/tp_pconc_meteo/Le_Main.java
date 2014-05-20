package tp_pconc_meteo;

/**
 *
 * @author S.Kleber et J.Ithurbide
 */
public class Le_Main {

    public static void main(String[] args) {
        System.out.println("hello world!");

        //création phénomène température (amplitude, offset, rang, dephasage et periode[minutes])  
        Temperature temperature = new Temperature (30, 1, 1, 2, 24);
              
        
        //démarrage du phénomène température
        System.out.println("Démarrage du phénomène température: ");
        temperature.start();
    }
    
}
