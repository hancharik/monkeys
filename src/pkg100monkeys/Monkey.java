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
     
      public ArrayList<String> transactionArray(){
         
       ArrayList<String> transactionList = new ArrayList();
   // if there is at least one transaction, generate visible banner
   if(transactionHistory.size() > 0){
     for(int i = 0; i < 1; i++){
         String temp1 = "//////////////monkey #" + monkeyId + " has " + transactionHistory.size() + " transactions....////////////////";
       System.out.println(temp1); 
       transactionList.add(temp1);
     }
   }          
        
            
      for(int i = 0; i <  transactionHistory.size(); i++){
          String temp2 = transactionHistory.get(i).printTransactionRecord();
          System.out.println(temp2); 
          transactionList.add(temp2);
           
     }
      
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
      owner.buyMonkey(this);
      openMarketMonkey = false;
  }
  
  public void freeAgent(){
      
      owner.sellMonkey(this);
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
  
}  // end class
