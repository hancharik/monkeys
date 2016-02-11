/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author mah537
 */
public class TownsFolk extends JButton{
   
    private int ssn;
    private ArrayList<Transaction> transactionHistory;
    private ArrayList<Monkey> monkeys;
    
    public TownsFolk(){
    
        monkeys = new ArrayList<Monkey>();
         transactionHistory = new ArrayList<Transaction>();
        //ssn = id;
        ssn = 0;
}
    
     public TownsFolk(int id){
    
        monkeys = new ArrayList<Monkey>();
         transactionHistory = new ArrayList<Transaction>();
        //ssn = id;
        ssn = setSSN();
}
    
    
 private int setSSN(){
    int tempssn = (int)( Math.random()*1000) + 1;
    
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
                  System.out.println("//////////////ssn #" + ssn + " has bought " + transactionHistory.size() + " monkeys....////////////////"); 
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
    
    
         public ArrayList<String> transactionArray(){
         
       ArrayList<String> transactionList = new ArrayList();
   // if there is at least one transaction, generate visible banner
   if(transactionHistory.size() > 0){
     for(int i = 0; i < 1; i++){
         String temp1 = "//////////////ssn #" + ssn + " has bought " + transactionHistory.size() + " monkeys....////////////////";
         String temp11 = "//////////////ssn #" + ssn + " has " + monkeys.size() + " monkeys....////////////////";
       System.out.println(temp1); 
       transactionList.add(temp1);
       transactionList.add(temp11);
     }
   }          
        
            
      for(int i = 0; i <  transactionHistory.size(); i++){
          String temp2 = transactionHistory.get(i).printTransactionRecord();
          System.out.println(temp2); 
          transactionList.add(temp2);
           
     }
      
      return transactionList;
       
   }  // end transaction array 
    
    
    
    
       public void buyMonkey(Monkey m){
      
        monkeys.add(m);
        
    }
  
       public void sellMonkey(Monkey m){
      
        monkeys.remove(m);
        
    }
    
    
    
    
    
    
    
    
    
}  // end class
