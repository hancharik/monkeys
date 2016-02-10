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
public class TownsFolk {
   
    private int ssn;
    private ArrayList<Transaction> transactionHistory;
    private ArrayList<Monkey> monkeys;
    
    public TownsFolk(int id){
    
        monkeys = new ArrayList<Monkey>();
         transactionHistory = new ArrayList<Transaction>();
        //ssn = id;
        ssn = setSSN();
}
    
 
    
    
 private int setSSN(){
    int tempssn = (int)( Math.random()*1000);
    
     return tempssn;
 }
    
     public void recordTransaction(Transaction t){
      
         Monkey m = t.monkey;
       transactionHistory.add(t);
       monkeys.add(m);
       
   }  
    
         public void printTransactions(){
         
   // if there is at least one transaction, generate visible banner
   if(transactionHistory.size() > 0){
       
                for(int i = 0; i < 2; i++){
                  System.out.println("//////////////ssn #" + ssn + " has " + transactionHistory.size() + " transactions....////////////////"); 
                }
                
                for(int i = 0; i <  transactionHistory.size(); i++){

                    System.out.println(transactionHistory.get(i).printTransactionRecord()); 

               }
         } // end if
   
   }  // end print transactions
         
       public int getNumberOfMonkeys(){
        
        return monkeys.size();
    }      
         
    public int getSSN(){
        
        return ssn;
    }
}
