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
    private boolean uniqueID = false;
    
    
    public TownsFolk(){
    
        monkeys = new ArrayList<Monkey>();
         transactionHistory = new ArrayList<Transaction>();
        //ssn = id;
        ssn = 0;
}
    
     public TownsFolk(int id, boolean unique){
         
         uniqueID = unique;
    
        monkeys = new ArrayList<Monkey>();
         transactionHistory = new ArrayList<Transaction>();
         // i think i want hash numbers for ssn number, not sure, so ther is a variable to show town id or unique ssn
         if(uniqueID){
             ssn = setSSN(); 
         }else{
            ssn = id + 1;
         }
       
       
        
}
    
    
 private int setSSN(){
    int tempssn = (int)( Math.random()*1000000) + 1;
    
     return tempssn;
 }
    
     public void recordTransaction(Transaction t){
      
      
       transactionHistory.add(t);
     
       
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
   if(transactionHistory.size() > -1){
     String temp1;
     String temp11;
       if(uniqueID){
             temp1 = "//////////////ssn #" + ssn + " has bought " + transactionHistory.size() + " monkeys....////////////////";
         temp11 = "//////////////ssn #" + ssn + " has " + monkeys.size() + " monkeys....////////////////";
         }else{
            temp1 = "//////////////villager #" + ssn + " has bought " + transactionHistory.size() + " monkeys....////////////////";
         temp11 = "//////////////villager #" + ssn + " has " + monkeys.size() + " monkeys....////////////////";
         }
        ;
       System.out.println(temp1); 
       transactionList.add(temp1);
       
     for(int i = 0; i <  transactionHistory.size(); i++){
          String temp2 = transactionHistory.get(i).printTransactionRecord();
         // System.out.println(temp2); 
          transactionList.add(temp2);
           
     }
     transactionList.add(temp11);
     for(int i = 0; i <  monkeys.size(); i++){
          String temp22 =  monkeys.get(i).getName();
         // System.out.println(temp2); 
          transactionList.add(temp22);
           
     }
   }          
 
      
      return transactionList;
       
   }  // end transaction array 
    
    
    
    
       public void buyMonkey(Monkey m){
      
        m.newHome(this);
        monkeys.add(m);
        
    }
  
       public void sellMonkey(Monkey m){
      
        
        m.freeAgent();
        monkeys.remove(m);
        
    }
    
    
    
    
    
    
    
    
    
}  // end class
