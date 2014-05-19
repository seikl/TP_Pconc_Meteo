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
public abstract class Phenomenes implements Runnable {
    
  private int    valVecteur;
  private long   tpsAttente;     
    
  abstract void Calcul();
    
    
  /**
   * Redéfinition de la méthode run().
   */ 
  public void run()
  { 
    try
    {
      for (int i = 1; i <= nbre; i++)
      {
        Thread.sleep(attente); // Il faut nécessairement préciser ici que sleep()
      }                        // est une méthode (statique) de Thread.
    }                          
    catch(InterruptedException e) {}
    System.out.println();
  }
    
    
}
