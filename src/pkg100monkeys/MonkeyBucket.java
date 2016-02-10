/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

import java.util.ArrayList;

/**
 *
 * @author mah537
 */
public class MonkeyBucket {
    
    
    ArrayList<Monkey> bucket;// = new Monkey[100];
    
    
    
    public MonkeyBucket(){
    
    makeThemMonkeys(100);
    showThemMonkeys();
} // end constructor
                 
    
    
  private void makeThemMonkeys(int num){
     
      bucket = new ArrayList<Monkey>();
      for(int m = 0; m < num; m++){
        
           bucket.add( new Monkey(m));
          
      }
      
      
  } // end make them Monkeys 
    
    
    
  private void showThemMonkeys(){
     
      
      for(int m = 0; m < bucket.size(); m++){
        
           System.out.println("Monkey #" + bucket.get(m).getId());
          
      }
      
      
  } // end make them Monkeys     
    
    
    
    
    
} // end class
