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
    private TownsFolk buyer;
    private TownsFolk seller;
    private int transactionId;
    private String record;
    private int increaseAmount;
    private MonkeyMarket market;
    
    public Transaction(Monkey m, MonkeyMerchant mm, TownsFolk buyer, TownsFolk seller,int id, MonkeyMarket market){
     increaseAmount =  m.increasePrice(mm.getMarket().getGrowthRate());
      this.market = market;
    monkey = m;
    monkeyMerchant = mm;
    this.buyer = buyer;
    this.seller = seller;
    transactionId = id; 
    
   // generateTransaction();
    
    }
    
    
    
    ////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    
  public void generateTransaction(){
      
        if(monkey.openMarketMonkey()){
            
  
        buyFromMarketTransaction();
  
      
        }else{
          
        int  percentage  = (int)(Math.random( )*100)+1;   
         if(percentage < 34){
            sellToMarketTransaction(); 
         }else{
            p2pTransaction();   
         }   
            
            
       
          
        }
    
      
  } // end generate transaction 
 
  
  //////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////
  
  
  
  
    private void recordTransaction(Monkey m, MonkeyMerchant mm, TownsFolk buyer, TownsFolk seller, int id){
      
        String space = " ";// String space = "\t";
       String whatDoWeCallBuyer = "";
       String whatDoWeCallSeller = "";
       
       if(market.weRespectYourPrivacy()){
             whatDoWeCallBuyer = "ssn #" + buyer.getSSN();
             whatDoWeCallSeller = "ssn #" + seller.getSSN();
         }else{
           whatDoWeCallBuyer = "villager #" + buyer.getSSN();
            whatDoWeCallSeller = "villager #" + seller.getSSN();
         }
       
       String pseudonym = "Samuel Clemens";
        if(m.thisMonkeyHasAName()){
          pseudonym = m.getName();
       }else{
         pseudonym = "monkey #" + m.getId();  
       }
        
                String temp = space+"trans #" + id + ":" +   " merchant # " + mm.getMerchantId() + " helped " + whatDoWeCallSeller
                        + " sell " + pseudonym + " to " + whatDoWeCallBuyer +" for $" + m.getPrice() + " (+" + increaseAmount%100 + "%)";
        record = temp;
     
  } 
    public String printTransactionRecord(){
        
        return record;
    }

    
    
     public int getTransactionID(){
        
        return transactionId;
    }
     
     
     
     
     @Override
    public void run() {
       generateTransaction();
    }


    
    private void buyFromMarketTransaction(){
        
        
        monkeyMerchant.marketSale(market,  buyer, monkey, this);
        recordTransaction(monkey, monkeyMerchant, buyer, market.mainMarketAuction, transactionId); 
   
      
    }  // end buy from market transaction
    
    
    private void sellToMarketTransaction(){
        
         
        monkeyMerchant.marketReturn(market, buyer, monkey, this);
        recordTransaction(monkey, monkeyMerchant, market.mainMarketAuction, buyer, transactionId); 
    
      
    }  // end sell to market transaction
    
    
    private void p2pTransaction() {
        
     
        monkeyMerchant.p2pTransaction(seller, buyer, monkey, this);
        recordTransaction(monkey, monkeyMerchant, buyer, seller, transactionId); 
      
    } // end merchant p2p transaction

    
    

    
    
} // end class
