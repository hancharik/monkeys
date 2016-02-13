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
      name = namePerson(false);
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
     
     
     
     if(sellTransactions.size()>0){
        String salesLabel = "\tmonkeys sold by this individual";
         transactionList.add(salesLabel);

        for(int i = 0; i <  sellTransactions.size(); i++){
             String recordOfSale =  sellTransactions.get(i).printTransactionRecord();

             transactionList.add(recordOfSale);
        }     
     }
     
     
     
     
     
     
   }    
   
   
   
  
   
      
      return transactionList;
       
   }  // end transaction array 
    
    
    
    
       public void buyMonkey(Monkey m){
      
       // m.newHome(this);
        monkeys.add(m);
        
    }
  
       public void sellMonkey(Monkey m){
      
        
       // m.freeAgent();
        monkeys.remove(m);
        
    }
    
    
    
   private String namePerson(Boolean isMonkey){
      
      String title = "";
      String endTitle = "";
      String fName = "";
      String mName = "";
      String lName = "";
      String fullName = "";
      boolean hasTitle = false;
      fullName = title + fName + mName + lName;
      int percentage  = (int)(Math.random( )*100)+1;
      int titleChoice = (int)(Math.random( )*20)+1;
      int endTitleChoice = (int)(Math.random( )*20)+1;
      if(percentage < 30){
        hasTitle = true;  
      }
      percentage  = (int)(Math.random( )*100)+1;
      if(percentage < 30){
       endTitleChoice = 11; // 11 is blank  
      }
      int firstNameChoice = (int)(Math.random( )*20)+1;
      int lastNameChoice = (int)(Math.random( )*20)+1;
      int middleNameChoice = 1;
      if(isMonkey){
      int theChanceOfAMonkeyHavingAFirstName = (int)(Math.random( )*100)+1;
      // i'd give it about a 30% chance that a monkey is going to have a first name...
        if(theChanceOfAMonkeyHavingAFirstName > 30){
            // so anything higher than 30 on a 1-100 scale will set this choice to 1, which returns an empty string
            firstNameChoice = 1;
            
        }else{
            
            firstNameChoice = (int)(Math.random( )*20)+1;
             // but if it does have a first name, then the chances of it having a middle name are rather high
           int theChanceOfAMonkeyHavingAMiddleName = (int)(Math.random( )*100)+1;
           
            if(theChanceOfAMonkeyHavingAMiddleName > 30){
            middleNameChoice  = (int)(Math.random( )*20)+2;
            } 
        }
      }
      
      switch(titleChoice){
          case 1: title = "Emperor"; break;
          case 2: title = "Mr."; break;  
          case 3: title = "Miss"; break;  
          case 4: title = "Mr."; break;  
          case 5: title = "Ms."; break;  
          case 6: title = "Little"; break;  
          case 7: title = "Dr."; break;
          case 8: title = ""; break;  
          case 9: title = ""; break;
          case 10: title = ""; break;  
          case 11: title = ""; break;
          case 12: title = ""; break;
          case 13: title = "King of All Media"; break;  
          case 15: title = ""; break;  
          case 16: title = ""; break;  
          case 17: title = "World's Greatest Monkey"; break;
          case 18: title = ""; break;  
          case 19: title = ""; break;
          case 20: title = "King of Monsters"; break;   
          case 21: title = ""; break;
      }
      switch(firstNameChoice){
          case 1: fName = "Michael"; break;  // monkeys usually don't have first names
          case 2: fName = "John"; break;  
          case 3: fName = "Walter"; break;  
          case 4: fName = "Steve"; break;  
          case 5: fName = "Donovan"; break;
          case 6: fName = "Peter"; break;  
          case 7: fName = "David"; break;
          case 8: fName = "Daniel"; break;  
          case 9: fName = "Thomas"; break;
          case 10: fName = "Frank"; break;  
          case 11: fName = "Linda"; break;
          case 12: fName = "Stephanie"; break;  
          case 13: fName = "Amy"; break;  
          case 14: fName = "Joyce"; break;  
          case 15: fName = "Ruth"; break;  
          case 16: fName = "Esther"; break;  
          case 17: fName = "Anna"; break;
          case 18: fName = "Mary"; break;  
          case 19: fName = "Barbara"; break;
          case 20: fName = "May"; break;  
          case 21: fName = "Pat"; break;
      }
       switch(middleNameChoice){
          case 1: mName = ""; break;  // monkeys usually don't have first names
          case 2: mName = "Johhny"; break;  
          case 3: mName = "Walter"; break;  
          case 4: mName = "Skippy"; break;  
          case 5: mName = "Molly"; break;
          case 6: mName = "Magilicuddy"; break;  
          case 7: mName = "Mopsy"; break;
          case 8: mName = "Dr. of Hugs"; break;  
          case 9: mName = "Peabody"; break;
          case 10: mName = ""; break;  
          case 11: mName = ""; break;
          case 12: mName = "Harry"; break;  
          case 13: mName = "Miss"; break;  
          case 14: mName = "Mr."; break;  
          case 15: mName = "Ms."; break;  
          case 16: mName = ""; break;  
          case 17: mName = "Rene"; break;
          case 18: mName = "Dr."; break;  
          case 19: mName = ""; break;
          case 20: mName = ""; break;  
          case 21: mName = ""; break;
      }
      switch(lastNameChoice){
          case 1: lName = "Smith"; break;
          case 2: lName = "Frances"; break;  
          case 3: lName = "McKean"; break;  
          case 4: lName = "Monroe"; break;  
          case 5: lName = "Murphy"; break;  
          case 6: lName = "Cruise"; break;  
          case 7: lName = "Baldwin"; break;
          case 8: lName = "Obama"; break;  
          case 9: lName = "Benson"; break;
          case 10: lName = "Einstein"; break;  
          case 11: lName = "Baldwin"; break;
          case 12: lName = "O'Keafe"; break;  
          case 13: lName = "Twain"; break;  
          case 14: lName = "Bush"; break;  
          case 15: lName = "Peterson"; break;  
          case 16: lName = "Hoffman"; break;  
          case 17: lName = "Yoeder"; break;
          case 18: lName = "Franklin"; break;  
          case 19: lName = "Walken"; break;
          case 20: lName = "Jenkins"; break;  
          case 21: lName = "Baldwin"; break;
      }
      
   switch(endTitleChoice){
          case 1: endTitle = "Jr."; break;
          case 2: endTitle = "Sr."; break;  
          case 3: endTitle = "II"; break;  
          case 4: endTitle = ""; break;  
          case 5: endTitle = "III"; break;  
          case 6: endTitle = ""; break;  
          case 7: endTitle = "IV"; break;
          case 8: endTitle = ""; break;  
          case 9: endTitle = ""; break;
          case 10: endTitle = ""; break;  
          case 11: endTitle = ""; break;
          case 12: endTitle = ""; break;
          case 13: endTitle = ""; break;  
          case 15: endTitle = "IV"; break;  
          case 16: endTitle = "III"; break;  
          case 17: endTitle = "Esq."; break;
          case 18: endTitle = "Jr."; break;  
          case 19: endTitle = ""; break;
          case 20: endTitle = ""; break;   
          case 21: endTitle = ""; break;
      }
      
   
          
         fullName = fName + " "  + lName; 
     
      
      
      
      
      
      
      
      //checkForDuplicateNames();
      return fullName;
  } // end name person 
    
    
    
    
    
}  // end class
