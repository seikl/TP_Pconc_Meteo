package tp_pconc_meteo;

/**
 *
 * @author S.Kleber et J.Ithurbide
 */
public class Le_Main {

    public static void main(String[] args) {
        System.out.println("hello world!");

        //cr�ation ph�nom�ne temp�rature (amplitude, offset, rang, dephasage et periode[minutes])  
        Temperature temperature = new Temperature (30, 1, 1, 2, 24);
              
        
        //d�marrage du ph�nom�ne temp�rature
        System.out.println("D�marrage du ph�nom�ne temp�rature: ");
        temperature.start();
    }
    
}
