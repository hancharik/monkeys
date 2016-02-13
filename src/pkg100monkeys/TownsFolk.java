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
    private ArrayList<Transaction> buyTransactions;
    private ArrayList<Transaction> sellTransactions;
    private ArrayList<Monkey> monkeys;
    private boolean uniqueID = false;
    private String name = "no name yet";
    
    
    public TownsFolk(){  // no int in the constructor means this is a robot
    
        initArrays();
        //ssn = id;
        ssn = -1;  // should we use -1? we had this to zero, -1 lets us count the number of robots
    }  // end robot constructor
    
    
    
     public TownsFolk(int id, boolean unique){
         // set unique to "false" if you want to use the id number
         // setting to "true" creates an anonymous ssn number, not sure what we can use it for yet
         uniqueID = unique;
    
        initArrays();
         // i think i want hash numbers for ssn number, not sure, so ther is a variable to show town id or unique ssn
         if(uniqueID){
             ssn = setSSN(); 
         }else{
            ssn = id + 1;
         }
       
       
        
    }  // end human constructor
 
     
  private void initArrays(){
      
      monkeys = new ArrayList<Monkey>();
         transactionHistory = new ArrayList<Transaction>();
         buyTransactions = new ArrayList<Transaction>();
        sellTransactions = new ArrayList<Transaction>();
      
  }   
     
    
 private int setSSN(){
    int tempssn = (int)( Math.random()*1000000) + 1;
    
     return tempssn;
 }
    
 
 
     public void recordTransaction(Transaction t, int choice){ // 1 for buy, 2 for sell
      
         if(choice == 1){
             buyTransactions.add(t);
            transactionHistory.add(t); 
         }else{
           // we don't add to transactionHistory here, as we only record the  buy transactions
           //this is just a courtesy receipt for their records...
           sellTransactions.add(t);
         }
      
       
     
       
   }  // end record transaction
     
     
     
     
     
     
     
    
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
       
         
     
         
    public void setName(String n) {

        name = n;

    }

    public String getName() {

        return name;
    }

    public int getNumberOfMonkeys() {

        return monkeys.size();
    }

    public int getSSN() {

        return ssn;
    }

public void setSSN(int n) {

        ssn = n;
    }
    
    
    
    
    
    
    
    
    
         public ArrayList<String> transactionArray(){
         
       ArrayList<String> transactionList = new ArrayList();
   // if there is at least one transaction, generate visible banner
   if(transactionHistory.size() >= 0){
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
