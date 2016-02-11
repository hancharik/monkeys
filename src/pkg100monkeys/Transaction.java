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
public class Transaction {
    
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
      market.reportTransToTheKing(this);
  }  
 
    private void recordTransaction(Monkey m, MonkeyMerchant mm, TownsFolk t, int id){
      
        String space = "";// String space = "\t";
       String whatDoWeCallPeople = "";
       
       if(market.weRespectYourPrivacy()){
             whatDoWeCallPeople = " to ssn #" + t.getSSN();
         }else{
           whatDoWeCallPeople = " to villager #" + t.getSSN();
         }
       
       
                String temp1 = space + "transaction id #" + id + ":  " + m.getName() + "\nsold by merchant #" + mm.getMerchantId() 
                    + whatDoWeCallPeople + "\nfor $" + m.getPrice() + ", an increase of " + increaseAmount%100 + "%";
                String temp2 = space + "transaction id #" + id + ":  " + m.getName() +  "sold by merchant #" + mm.getMerchantId() 
                + whatDoWeCallPeople + "for $" + m.getPrice() + ", an increase of " + increaseAmount%100 + "%";
                String temp3 = space + "trans id #" + id + "  " + m.getName() + " merchant #" + mm.getMerchantId() 
                + whatDoWeCallPeople + " for $" + m.getPrice() + " ( + " + increaseAmount%100 + "%)";
                String temp4 = space + "trans id # " + id + "\t" + m.getName() +   "\tmerchant # " + mm.getMerchantId() 
                + "\t" + whatDoWeCallPeople +"\t$" + m.getPrice() + "  ( + " + increaseAmount%100 + "%)";
        record = temp4;
     
  } 
    public String printTransactionRecord(){
        
        return record;
    }

} // end class
