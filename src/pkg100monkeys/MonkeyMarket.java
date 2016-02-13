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
public class MonkeyMarket {
    
    
    private int numberOfMerchants = 10;
    private int numberOfTownsPeople = 100;
    private int numberOfTransactions = 100;
    private int growthRate = 100;
    
    private boolean respectForPrivacy = false;
    private boolean useTimer = false;
    
    public TownsFolk mainMarketAuction;
    
    private ArrayList<Monkey> oneHundredMonkeys;
    private ArrayList<Monkey> availableMonkeys;
    private ArrayList<MonkeyMerchant> monkeyMerchants;
    private ArrayList<TownsFolk>  town;
    private ArrayList<TownsFolk> monkeyOwners;
    private ArrayList<Transaction> transactions;
    
    
    public MonkeyMarket(){
    
       
        makeMarket();
        generateMonkeyEconomy(numberOfTransactions);
 
        generateSalesLogs();
    } // end constructor
   
    public MonkeyMarket(int numberOfMerchants, int numberOfTownsPeople, int numberOfTransactions, int growthRate){
    
        this.numberOfMerchants = numberOfMerchants;
        this.numberOfTownsPeople = numberOfTownsPeople;
        this.numberOfTransactions = numberOfTransactions;
        this.growthRate = growthRate;
       
        makeMarket();
        if(useTimer){
          timedOrders();  
        }else{
         generateMonkeyEconomy(numberOfTransactions);   
        }
        
 
        generateSalesLogs();
    } // end constructor
        
        
 private void makeMarket(){
     
     transactions = new ArrayList<Transaction>();
     mainMarketAuction = new TownsFolk(998, false);
     
        MonkeyBucket mobu = new MonkeyBucket();
        oneHundredMonkeys = mobu.bucket;
        availableMonkeys  = mobu.bucket;
        makeMonkeyMerchants(numberOfMerchants);
        makeTownsFolk(numberOfTownsPeople);
     
 }   // end make market
 
 private void makeMonkeyMerchants(int numberOfMerchants){
     
      monkeyMerchants = new ArrayList<MonkeyMerchant>();
      for(int s = 0; s < numberOfMerchants; s++){
       MonkeyMerchant mm = new MonkeyMerchant(s, this); 
       monkeyMerchants.add(mm);
       System.out.println("monkey merchant #" + mm.getMerchantId() + " created, vendor size :" + monkeyMerchants.size());
      }
     
 }
 
  private void makeTownsFolk(int numberOfTownies){
     
      town = new ArrayList();
      monkeyOwners = new ArrayList();
      for(int s = 0; s < numberOfTownies; s++){
       TownsFolk townie = new TownsFolk(s, respectForPrivacy); 
        town.add(townie);
       System.out.println("townsfolk #" + (s+1) + "(ssn #" + townie.getSSN() + ") created, town size :" + town.size());
      
      }
     
 }

  
   private void generateMonkeyEconomy(int numberOfTransactions){
     
       
       
       for(int i = 1; i <= numberOfTransactions; i++){
       
       int randomMonkey = (int)(Math.random()*oneHundredMonkeys.size());
       int randomMerchant = (int)(Math.random()*monkeyMerchants.size());
       int randomCustomer = (int)(Math.random()*town.size());
       Monkey tempMonkey = oneHundredMonkeys.get(randomMonkey);
       Transaction tempTrans = new Transaction(tempMonkey, monkeyMerchants.get(randomMerchant),town.get(randomCustomer),  tempMonkey.thisMonkeysOwner()  , i, this);
                                          //(Monkey m, MonkeyMerchant mm, TownsFolk buyer, TownsFolk seller,int id, MonkeyMarket market)
       tempTrans.generateTransaction();
      // transactions.add(tempTrans);
      System.out.println(" monkey transaction #" + i + " created.");
     
       } // end for loop
       
         System.out.println(" there should be " + transactions.size() + " transactions.");
       
 }   // end generate monkey economy
  
   
   
   
   
   
    private void sellOneMonkey(){
     
       
       
       
       
       int randomMonkey = (int)(Math.random()*oneHundredMonkeys.size());
       int randomMerchant = (int)(Math.random()*monkeyMerchants.size());
       int randomCustomer = (int)(Math.random()*town.size());
       int tempID = transactions.size()+1;
       Monkey tempMonkey = oneHundredMonkeys.get(randomMonkey);
       Transaction tempTrans = new Transaction(tempMonkey, monkeyMerchants.get(randomMerchant),town.get(randomCustomer),  tempMonkey.thisMonkeysOwner()  , tempID, this);
       tempTrans.generateTransaction();
       transactions.add(tempTrans);
      System.out.println(" monkey transaction #" + tempTrans.getTransactionID() + " created.");
     
       
       
         System.out.println(" there should be " + transactions.size() + " transactions.");
       
 }   // end generate monkey economy
    
    
    
    
   
 private void generateSalesLogs(){
     
     // list merchants who sold a monkey or more
     for(int i = 0; i < monkeyMerchants.size(); i++){
         monkeyMerchants.get(i).printReceiptBook();
         monkeyMerchants.get(i).reportTransactionsToTheKing();
     }
     // generate visible banner
     for(int i = 0; i <6; i++){
        // System.out.println("//////////////////generating sales logs//////////////////////");
     }
  
     // list activities of monkeys who were sold at least once
      for(int i = 0; i < oneHundredMonkeys.size(); i++){
         oneHundredMonkeys.get(i).printTransactions();
     }
     
       // list activities of monkeys who were sold at least once
      for(int i = 0; i < town.size(); i++){
        town.get(i).printTransactions();
     }
 }  // end generate sales logs
   
 
 
 
 
 
 
 
 
 
 
  public ArrayList monkeys(){
      
      return oneHundredMonkeys;
  } 
 
  public ArrayList town(){
      
      return town;
  } 
   public ArrayList merchants(){
      
      return monkeyMerchants;
  } 
 
   
   
   
   
   
   
   
  public ArrayList<Transaction> transactions(){
      ArrayList<Transaction> tempTrans = new ArrayList<Transaction>();
      
      
      for(int i = 0; i < transactions.size(); i++){
        
           tempTrans.add(transactions.get(i));
     
      }
      
      
      
      return tempTrans;
  } 

 public int freeMarketMonkeys(){
     
     return availableMonkeys.size();
 }
  
   public ArrayList peopleWhoOwnMonkeys(){
      
       ArrayList<TownsFolk> peepsWithMonkeys = new ArrayList<TownsFolk>();
       
       for(int i = 0; i < town.size(); i++){
        if(town.get(i).getNumberOfMonkeys() > 0){
           peepsWithMonkeys.add(town.get(i));
        }
     }
       
       
       
      return peepsWithMonkeys;
  }   // end people who own monkeys
   
      public ArrayList merchantsWithSales(){
      
       ArrayList<MonkeyMerchant> mercsWithSales = new ArrayList<MonkeyMerchant>();
       
       for(int i = 0; i < monkeyMerchants.size(); i++){
        if(monkeyMerchants.get(i).getNumberOfReceipts() > 0){
           mercsWithSales.add(monkeyMerchants.get(i));
        }
     }
       
       
       
      return mercsWithSales;
  }   // end people who own monkeys

     
          public boolean weRespectYourPrivacy(){
          
          
          return respectForPrivacy;
      }  // end get growth rate
      
      
      public int getGrowthRate(){
          
          
          return growthRate;
      }  // end get growth rate
      
 public void reportTransToTheKing(Transaction t){
     // we need to hear about any transaction here. 
     //this is the main accounting ledger for the king
     transactions.add(t);
 }   // end report to the king  
  
 
public void removeMonkey(Monkey m){
   for (int i = 0; i < availableMonkeys.size(); i ++) {
     if(availableMonkeys.get(i).equals(m)){
        availableMonkeys.remove(availableMonkeys.get(i) );  
     }  
   }
} 
 
 public void addMonkey(Monkey m){
   availableMonkeys.add(m); 
}

    private void timedOrders() {
        // make timed orders
    }
 
 
 
}  // end class
