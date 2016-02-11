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
    
    public Transaction(Monkey m, MonkeyMerchant mm, TownsFolk t, int id){
     increaseAmount =  m.increasePrice(); 
    monkey = m;
    monkeyMerchant = mm;
    townsFolk = t;
    transactionId = id; 
    
   // generateTransaction();
    
    }
    
    
  public void generateTransaction(){
      
     monkeyMerchant.sellMonkey(monkey, townsFolk, transactionId);
     monkeyMerchant.recordTransaction(this);
     monkey.recordTransaction(this);
     townsFolk.recordTransaction(this);
      System.out.println("transaction id#" + transactionId + " generated");
      //monkey.increasePrice();
      // monkeyMerchant.printReceiptBook();
      recordTransaction(monkey, monkeyMerchant, townsFolk, transactionId);
  }  
 
    private void recordTransaction(Monkey m, MonkeyMerchant mm, TownsFolk t, int id){
      
       
                String temp1 = "transaction id #" + id + ":  monkey #" + m.getId() + "\nsold by merchant #" + mm.getMerchantId() 
                    + " to ssn #" + t.getSSN() + "\nfor $" + m.getPrice() + ", an increase of " + increaseAmount%100 + "%";
                String temp2 = "transaction id #" + id + ":  monkey #" + m.getId() + "sold by merchant #" + mm.getMerchantId() 
                + " to ssn #" + t.getSSN() + "for $" + m.getPrice() + ", an increase of " + increaseAmount%100 + "%";
                String temp3 = "trans id #" + id + "  monkey #" + m.getId() + " merchant #" + mm.getMerchantId() 
                + "   ssn #" + t.getSSN() + " for $" + m.getPrice() + " ( + " + increaseAmount%100 + "%)";
                String temp4 = "trans id # " + id + "\tmonkey # " + m.getId() + "\tmerchant # " + mm.getMerchantId() 
                + "\tssn # " + t.getSSN() + "\t$" + m.getPrice() + "  ( + " + increaseAmount%100 + "%)";
        record = temp4;
     
  } 
    public String printTransactionRecord(){
        
        return record;
    }

} // end class
