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
   * Red�finition de la m�thode run().
   */ 
  public void run()
  { 
    try
    {
      for (int i = 1; i <= nbre; i++)
      {
        Thread.sleep(attente); // Il faut n�cessairement pr�ciser ici que sleep()
      }                        // est une m�thode (statique) de Thread.
    }                          
    catch(InterruptedException e) {}
    System.out.println();
  }
    
    
}
