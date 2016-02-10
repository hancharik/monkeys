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
public class Monkey {
    
    private int monkeyId;
    private int price;
    private ArrayList<Transaction> transactionHistory;
    
    public Monkey(int number){
       
        transactionHistory = new ArrayList<Transaction>();
       monkeyId = number + 1; 
       // we could set this as a variable, right now we just start at 100 dollars
       price = 100;
       
    
    }  // end constructor
    
    
 public int increasePrice(){
     
     int increase = (int)(Math.random()*100) + 100;
     int newprice = (price * increase)/100;
     
     System.out.print("monkey #" + monkeyId + " was $" + price );
     
     price = newprice;
     System.out.println( ", new price is $" + price);
     return increase;
 } 
 
 
 
 
     public void increasePriceOldWay(){
     
     int newprice = (price * 120)/100;
     
     System.out.print("monkey #" + monkeyId + " was $" + price );
     
     price = newprice;
     System.out.println( ", new price is $" + price);
 } 
   public int getPrice(){
       
       return price;
   } 
     public int getId(){
       
       return monkeyId;
   } 
   public void recordTransaction(Transaction t){
      
       transactionHistory.add(t);
       
   }
    
     public void printTransactions(){
         
   // if there is at least one transaction, generate visible banner
   if(transactionHistory.size() > 0){
     for(int i = 0; i < 2; i++){
       System.out.println("//////////////monkey #" + monkeyId + " has " + transactionHistory.size() + " transactions....////////////////"); 
     }
   }          
        
            
      for(int i = 0; i <  transactionHistory.size(); i++){
          
          System.out.println(transactionHistory.get(i).printTransactionRecord()); 
           
     }
       
   }  // end print transaction
     
   
  public boolean hasPapers(){
      
    boolean paper = false;  
      
    if(transactionHistory.size() > 0){
        paper = true;
    }
    
     return paper; 
  }   
     
}  // end class
