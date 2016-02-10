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
public class MonkeyMerchant{
   // public class MonkeyMerchant extends Thread{
    
    private ArrayList<String> receipts;
    private int merchantId;
    
    public MonkeyMerchant(int id){
    
        receipts = new ArrayList();
        String addTitle = " receipt log of Merchant #" + (id+1);
        receipts.add(addTitle);
        merchantId = id + 1;

    } // end constructor
  
    
  public synchronized void sellMonkey(Monkey m, TownsFolk tf, int trans){
     receipts.add("transaction #" + trans + ":  merchant #" + merchantId + " selling monkey #" + m.getId() + " to townsfolk (ssn #" + tf.getSSN() + ") for $" + m.getPrice());
  } 
    
   public synchronized void acceptMonkeyReturn(Monkey m, TownsFolk tf, int trans){
     receipts.add("transaction #" + trans + ":  merchant #" + merchantId + " accepting return of  monkey #" + m.getId() + " from townsfolk (ssn #" + tf.getSSN() + ") for $" + m.getPrice());
  }    
    
   public void printReceiptBook(){
         // if there is at least one transaction, generate visible banner
   if(receipts.size() > 1){  // has to be bigger than one, because one is title
     for(int i = 0; i < 2; i++){
       System.out.println("//////////////////merchant #" + merchantId + " sales log//////////////////////");
     }
   } 
   
   
        
    
        for(int s = 1; s < receipts.size(); s++){ // has to be bigger than one, because one is title
      System.out.println(receipts.get(s));
      }
       
   } // end print receipt book
  
   
  public int getMerchantId(){
      
      return merchantId;
      
  } 
   
   
   
   
} // end class
