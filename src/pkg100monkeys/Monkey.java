/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author mah537
 */
public class Monkey extends JButton{
    
    private int monkeyId;
    private int price;
    private int rateOfGrowth;
    private int levelOfDisease;
    private TownsFolk owner;
    private Boolean openMarketMonkey;
    private int mojo;
    private ArrayList<Transaction> transactionHistory;
    private Color color;
    private String fullName;
    
    
    public Monkey(int number){
       
        monkeyId = number + 1; 
        makeMonkey();
    
    }  // end constructor
 
    
    
    private void makeMonkey(){
        
        rateOfGrowth = 100;
        levelOfDisease = 0;
        owner = null;
        openMarketMonkey = true;
        mojo = 0;
        transactionHistory = new ArrayList<Transaction>();
        price = 100;
        fullName = nameMonkey(true);
        
        
        
        
        
        
        
    } // end make money
    
    
    
    
 public int increasePrice(int rg){
     setRateOfGrowth(rg);
     int increase = (int)(Math.random()*rateOfGrowth) + 100;
     int newprice = (price * increase)/100;
     
     System.out.print("monkey #" + monkeyId + " was $" + price );
     
     price = newprice;
     
     System.out.println( ", new price is $" + price);
     return increase;
 } 
 
 public void setRateOfGrowth(int r){
     int rateCap = 100;
     if(r > -1 && r < rateCap){  // -1 to allow for zero growth
     rateOfGrowth = r;
     System.out.println("rate of growth is " + rateOfGrowth);
     }
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
        public String getName(){
       
       return fullName;
   } 
   public void recordTransaction(Transaction t){
      
       transactionHistory.add(t);
       
   }
    
     public void printTransactions(){
         
   // if there is at least one transaction, generate visible banner
   if(transactionHistory.size() > 0){
     for(int i = 0; i < 2; i++){
       System.out.println("//////////////  monkey #" + price + " has " + transactionHistory.size() + " transactions....////////////////"); 
     }
   }          
        
            
      for(int i = 0; i <  transactionHistory.size(); i++){
          
          System.out.println(transactionHistory.get(i).printTransactionRecord()); 
           
     }
       
   }  // end print transaction
     
      public ArrayList<String> transactionArray(){
         
       ArrayList<String> transactionList = new ArrayList();
   // if there is at least one transaction, generate visible banner
   if(transactionHistory.size() > 0){
     for(int i = 0; i < 1; i++){
         String temp1 = "//////////////   monkey #" + monkeyId + " has " + transactionHistory.size() + " transactions....////////////////";
         String temp12 = "//////////////  " + fullName + " has " + transactionHistory.size() + " transactions....////////////////";
       System.out.println(temp12); 
       transactionList.add(temp12);
     }
   }          
        
            
      for(int i = 0; i <  transactionHistory.size(); i++){
          String temp2 = transactionHistory.get(i).printTransactionRecord();
          System.out.println(temp2); 
          transactionList.add(temp2);
           
     }
      
      
       
       
      
      String temp11;
      if(owner!=null){
      temp11 = "" + fullName + " is worth $"  + price + ", owned by ssn #" + owner.getSSN() + ".    " ;
      }else{
       temp11 = "" + fullName + " is worth $"  + price + ", owned by NO ONE" ; 
      }
      transactionList.add(temp11);
      return transactionList;
       
      
      
      
      
   }  // end transaction array
      
      
  public boolean hasPapers(){
      
    boolean paper = false;  
      
    if(transactionHistory.size() > 0){
        paper = true;
    }
    
     return paper; 
  }   
 
    public void newHome(TownsFolk o){
      
      owner = o;
      //owner.buyMonkey(this);
      openMarketMonkey = false;
  }
  
  public void freeAgent(){
      
      //owner.sellMonkey(this);
      owner = null;
      openMarketMonkey = true;
  }
  
  public boolean openMarketMonkey(){
      
      return openMarketMonkey;
  } 
  
  public void setColor(Color c){
      
      color = c;
  }
  public Color getColor(){
      
      return color;
  } 
  
  public TownsFolk thisMonkeysOwner(){
      
      
      return owner;
  }
  
 
  private String nameMonkey(Boolean isMonkey){
      
      String title = "";
      String fName = "";
      String mName = "";
      String lName = "";
      String fullName = "";
      
      fullName = title + fName + mName + lName;
      
      int titleChoice = (int)(Math.random( )*20)+1;
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
          case 7: title = ""; break;
          case 8: title = "Dr."; break;  
          case 9: title = ""; break;
          case 10: title = ""; break;  
          case 11: title = ""; break;
          case 12: title = ""; break;  
          case 13: title = ""; break;  
          case 15: title = ""; break;  
          case 16: title = ""; break;  
          case 17: title = ""; break;
          case 18: title = "Dr."; break;  
          case 19: title = ""; break;
          case 20: title = ""; break;  
          case 21: title = "Little Missy"; break;
      }
      switch(firstNameChoice){
          case 1: fName = ""; break;  // monkeys usually don't have first names
          case 2: fName = "Johhny"; break;  
          case 3: fName = "Walter"; break;  
          case 4: fName = "Skippy"; break;  
          case 5: fName = "Molly"; break;
          case 6: fName = "Magilicuddy"; break;  
          case 7: fName = "Mopsy"; break;
          case 8: fName = "Dr. of Hugs"; break;  
          case 9: fName = "Peabody"; break;
          case 10: fName = ""; break;  
          case 11: fName = ""; break;
          case 12: fName = "Harry"; break;  
          case 13: fName = "Miss"; break;  
          case 14: fName = "Mr."; break;  
          case 15: fName = "Ms."; break;  
          case 16: fName = ""; break;  
          case 17: fName = "Rene"; break;
          case 18: fName = "Dr."; break;  
          case 19: fName = ""; break;
          case 20: fName = ""; break;  
          case 21: fName = ""; break;
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
          case 1: lName = "Squiggles"; break;
          case 2: lName = "Pinky"; break;  
          case 3: lName = "Martin"; break;  
          case 4: lName = "Monroe"; break;  
          case 5: lName = "Murphy"; break;  
          case 6: lName = "Magilicuddy"; break;  
          case 7: lName = "Mopsy"; break;
          case 8: lName = "Dr. of Hugs"; break;  
          case 9: lName = "Peabody"; break;
          case 10: lName = "Einstein"; break;  
          case 11: lName = "Baldwin"; break;
          case 12: lName = "O'Keafe"; break;  
          case 13: lName = "Twain"; break;  
          case 14: lName = "Bush"; break;  
          case 15: lName = "Peepers"; break;  
          case 16: lName = "Cronkite"; break;  
          case 17: lName = "Potter"; break;
          case 18: lName = "Oppenheimer"; break;  
          case 19: lName = "Lord of the Dance"; break;
          case 20: lName = "Jenkins"; break;  
          case 21: lName = "Baldwin"; break;
      }
      
 
      checkForDuplicateNames();
      fullName = title  + " " +fName + " " + mName + " " + lName;
      checkForDuplicateNames();
      return fullName;
  } // end nameMonkey
  
  
  private void checkForDuplicateNames(){
      
    // check to see if the name is unique
    
}
  
  
  
  
  
}  // end class
