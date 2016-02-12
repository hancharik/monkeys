/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author mah537
 */
public class MonkeyMerchant extends JButton implements Runnable, ActionListener {
   // public class MonkeyMerchant extends Thread{

    private ArrayList<String> receipts;
    private ArrayList<Transaction> transactionHistory;
    private int merchantId;
    private MonkeyMarket monkeyMarket;

    Timer t;// = new Timer(100, (ActionListener) this);
    
    
    public MonkeyMerchant(int id, MonkeyMarket mm) {

        monkeyMarket = mm;
        transactionHistory = new ArrayList();
        receipts = new ArrayList();
        String addTitle = " receipt log of Merchant #" + (id + 1);
        receipts.add(addTitle);
        merchantId = id + 1;
        t = new Timer(100, this);
        t.start();
        
    } // end constructor

    public MonkeyMerchant() {

        transactionHistory = new ArrayList();
        receipts = new ArrayList();
        String addTitle = " receipt log of Merchant #0";
        receipts.add(addTitle);
        merchantId = 0;

    } // end constructor

    public synchronized void sellMonkey(Monkey m, TownsFolk tf, int trans) {
        if (m.openMarketMonkey()) {
            receipts.add("transaction #" + trans + ":  merchant #" + merchantId + " selling monkey #" + m.getId() + " to townsfolk (ssn #" + tf.getSSN() + ") for $" + m.getPrice());
        } else {

            receipts.add("transaction #" + trans + ":  merchant #" + merchantId + " selling ssn #" + m.thisMonkeysOwner().getSSN() + "'s monkey #" + m.getId() + " to townsfolk (ssn #" + tf.getSSN() + ") for $" + m.getPrice());
        }
    }

    public synchronized void acceptMonkeyReturn(Monkey m, TownsFolk tf, int trans) {
        receipts.add("transaction #" + trans + ":  merchant #" + merchantId + " accepting return of  monkey #" + m.getId() + " from townsfolk (ssn #" + tf.getSSN() + ") for $" + m.getPrice());
    }

    public void printReceiptBook() {
        // if there is at least one transaction, generate visible banner
        if (receipts.size() > 1) {  // has to be bigger than one, because one is title
            for (int i = 0; i < 2; i++) {
                System.out.println("//////////////////merchant #" + merchantId + " sales log//////////////////////");
            }
        }

        for (int s = 1; s < receipts.size(); s++) { // has to be bigger than one, because one is title
            System.out.println(receipts.get(s));
        }

    } // end print receipt book

    public int getMerchantId() {

        return merchantId;

    }

    public MonkeyMarket getMarket() {

        return monkeyMarket;

    }

    public int getNumberOfReceipts() {

        int number = receipts.size() - 1; //you have to subtract one, as the first element is the header. we should change that

        return number;
    }

    public ArrayList<String> transactionArray() {

        ArrayList<String> transactionList = new ArrayList();
        // if there is at least one transaction, generate visible banner
        if (receipts.size() > 1) {
            for (int i = 0; i < 1; i++) {
                String temp1 = "//////////////monkey merchant #" + merchantId + " has " + transactionHistory.size() + " transactions....////////////////";
                System.out.println(temp1);
                transactionList.add(temp1);
            }
        }

        for (int i = 0; i < transactionHistory.size(); i++) {
            String temp2 = transactionHistory.get(i).printTransactionRecord();
            System.out.println(temp2);
            transactionList.add(temp2);

        }

        return transactionList;

    }  // end transaction array

    public void p2pTransaction(TownsFolk seller, TownsFolk buyer, Monkey monkee) {

        seller.sellMonkey(monkee);
        buyer.buyMonkey(monkee);

    // take percentage of sale here....
    }// end person to person transaction
    
    public void marketSale(MonkeyMarket monkeyMarket, TownsFolk buyer, Monkey monkee) {

        monkeyMarket.takeAMonkey(monkee);
        buyer.buyMonkey(monkee);

    // take percentage of sale here....
    }// end person to person transaction

    public void marketReturn(MonkeyMarket monkeyMarket, TownsFolk buyer, Monkey monkee) {

        monkeyMarket.addAMonkey(monkee);
        buyer.sellMonkey(monkee);

    // take percentage of sale here....
    }// end market return transaction
               
    public void recordTransaction(Transaction t) {

        monkeyMarket.reportTransToTheKing(t);
        transactionHistory.add(t);

    }

    public void reportTransactionsToTheKing() {

   // for(int i = 0; i <  transactionHistory.size(); i++){
          // monkeyMarket.reportTransToTheKing(transactionHistory.get(i));
        // }
    }  // end report transactions

    @Override
    public void run() {

        
        
       // what goes here? 
        
        
        
        
        
    }
    
    
     @Override
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
                if (obj == t){
                    this.setText("" + System.nanoTime()%1000);
                } 
    
         }
    
    

} // end class
