/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

/**
 *
 * @author mark
 */
public class Transaction implements Runnable{
    
    public Monkey monkey;
    private MonkeyMerchant monkeyMerchant;
    private TownsFolk townsFolk;
    private int transactionId;
    private String record;
    private int increaseAmount;
    private MonkeyMarket market;
    
    public Transaction(Monkey m, MonkeyMerchant mm, TownsFolk t, int id, MonkeyMarket market){
     increaseAmount =  m.increasePrice(mm.getMarket().getGrowthRate());
      this.market = market;
    monkey = m;
    monkeyMerchant = mm;
    townsFolk = t;
    transactionId = id; 
    
   // generateTransaction();
    
    }
    
    
    
    ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    
  public void generateTransaction(){
      
      if(monkey.openMarketMonkey()){
     monkeyMerchant.sellMonkey(monkey, townsFolk, transactionId);
     townsFolk.buyMonkey(monkey);
     monkeyMerchant.recordTransaction(this);
     monkey.newHome(townsFolk);
     monkey.recordTransaction(this);
     townsFolk.recordTransaction(this);
      System.out.println("transaction id#" + transactionId + " generated");
      //monkey.increasePrice();
      // monkeyMerchant.printReceiptBook();
      recordTransaction(monkey, monkeyMerchant, townsFolk, transactionId);
      }else{
       monkeyMerchant.p2pTransaction(monkey.thisMonkeysOwner(), townsFolk, monkey);
     monkeyMerchant.recordTransaction(this);
     monkey.newHome(townsFolk);
     monkey.recordTransaction(this);
     townsFolk.recordTransaction(this);
      System.out.println("transaction id#" + transactionId + " generated");
      //monkey.increasePrice();
      // monkeyMerchant.printReceiptBook();
      recordTransaction(monkey, monkeyMerchant, townsFolk, transactionId);   
      }
      //market.reportTransToTheKing(this);
      
  } // end generate transaction 
 
  
  //////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////
  
  
  
  
    private void recordTransaction(Monkey m, MonkeyMerchant mm, TownsFolk t, int id){
      
        String space = "     ";// String space = "\t";
       String whatDoWeCallPeople = "";
       
       if(market.weRespectYourPrivacy()){
             whatDoWeCallPeople = "ssn #" + t.getSSN();
         }else{
           whatDoWeCallPeople = "villager #" + t.getSSN();
         }
       
       String pseudonym = "Samuel Clemens";
        if(m.thisMonkeyHasAName()){
          pseudonym = m.getName();
       }else{
         pseudonym = "monkey #" + m.getId();  
       }
       
                String temp1 = space + "transaction id #" + id + ":  " + pseudonym + "\nsold by merchant #" + mm.getMerchantId() 
                    + whatDoWeCallPeople + "\nfor $" + m.getPrice() + ", an increase of " + increaseAmount%100 + "%";
                String temp2 = space + "transaction id #" + id + ":  " + pseudonym +  "sold by merchant #" + mm.getMerchantId() 
                + whatDoWeCallPeople + "for $" + m.getPrice() + ", an increase of " + increaseAmount%100 + "%";
                String temp3 = space + "trans id #" + id + "  " + pseudonym + " merchant #" + mm.getMerchantId() 
                + whatDoWeCallPeople + " for $" + m.getPrice() + "( + " + increaseAmount%100 + "%)";
                String temp4 = space + "trans id # " + id + "\t" + pseudonym +   "\tmerchant # " + mm.getMerchantId() 
                + "\t" + whatDoWeCallPeople +"\t$" + m.getPrice() + "  ( + " + increaseAmount%100 + "%)";
        record = temp4;
     
  } 
    public String printTransactionRecord(){
        
        return record;
    }

    
    
     public int getTransactionID(){
        
        return transactionId;
    }
     
     
     
     
     @Override
    public void run() {
       
    }

} // end class
