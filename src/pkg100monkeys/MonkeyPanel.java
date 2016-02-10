/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author mark
 */
public class MonkeyPanel extends JPanel implements ActionListener{
    
    MonkeyMarket monkeyTown;
    int numMonkeyz = 0;
    JLabel numberOfMonkeysLabel;
    JLabel trustTheMonkeysLabel;
    JLabel titleLabel;
    ArrayList<TownsFolk> peopleWhoOwnMonkeys;
    ArrayList<MonkeyMerchant> experiencedSellers;
    JButton monkeyPictureButton;
    JButton startButton;
    SliderPanel sliderPanel;
    JPanel monkeyPanel;
    JPanel monkeyMerchantPanel;
    JPanel peopleWithMonkeysPanel;
    int numberOfMerchants = 10;
    int numberOfTownsPeople = 100;
    int numberOfTransactions = 100;
    int saleCount = 0;
    ArrayList<Monkey> monkeyButtons;
    JTextArea showText;
    
    
            
    public MonkeyPanel(){
        
        super();
        
        
        //monkeyTown = new MonkeyMarket(); // moved to the make monkey panels method
        
        
        createUI();
        
        setLabel();
        
    }  // end constructor
    
private void createUI(){
    
    
    setLayout(null);
    monkeyButtons = new ArrayList();
    sliderPanel = new SliderPanel(this);
    sliderPanel.setBounds(608,220,360,300);
    //sliderPanel.setVisible(false);
    add(sliderPanel);
    monkeyPictureButton = new JButton("new");
    //monkeyPictureButton.setIcon(new ImageIcon("images/monkey.jpg"));
    monkeyPictureButton.setBounds(688,84,80,40);
    monkeyPictureButton.addActionListener(this);
    add(monkeyPictureButton);
    startButton = new JButton("start");
    startButton.setBounds(788,84,80,40);
    startButton.setVisible(false);
    startButton.addActionListener(this);
    add(startButton);
      
      
  
     makeMonkeyPanels();
 
    

    
    numberOfMonkeysLabel = new JLabel("numberOfMonkeysLabel");
    numberOfMonkeysLabel.setBounds(588,590,420,42);
    add(numberOfMonkeysLabel);
    trustTheMonkeysLabel = new JLabel("trustTheMonkeysLabel");
    trustTheMonkeysLabel.setBounds(588,640,420,42);
    add(trustTheMonkeysLabel);
    titleLabel = new JLabel("100 monkeys");
    titleLabel.setBounds(688,14,420,42);
    titleLabel.setBackground(Color.yellow);
    add(titleLabel);
   showText = new JTextArea();
    showText.setBounds(560,580,420,420);
    showText.setBackground(Color.yellow);
    add(showText);
    
    
    
}   // end create UI 
 

private void makeMonkeyPanels(){
    
    
    sliderPanel.setVisible(false);
    
    
    monkeyTown = new MonkeyMarket(numberOfMerchants, numberOfTownsPeople, numberOfTransactions);  // this generates the data in the game
    
    monkeyPanel = monkeyPanel();
    monkeyPanel.setBounds(0,0,680,580);
    
    peopleWithMonkeysPanel = peopleWithMonkeysPanel();
    peopleWithMonkeysPanel.setBounds(70,590,490,360);
    
    monkeyMerchantPanel = merchantPanel();
    monkeyMerchantPanel.setBounds(0,590,60,360);
    
    
     add(monkeyPanel);
     add(peopleWithMonkeysPanel);
     add(monkeyMerchantPanel);
    repaint();
}// end make monkey panels

private void removeMonkeyPanels(){
    monkeyPictureButton.setVisible(false);
      remove(monkeyMerchantPanel);
     remove(monkeyPanel);
     remove(peopleWithMonkeysPanel);
     sliderPanel.setVisible(true);
     repaint();
}// end make monkey panels

private JPanel monkeyPanel(){
      JPanel monkPan = new JPanel();
      monkPan.setLayout(new GridLayout(10 ,10));
    monkeyButtons = monkeyTown.monkeys();
    for(int i = 0; i < monkeyButtons.size(); i++){
       monkeyButtons.get(i).addActionListener(this);
        monkeyButtons.get(i).setText("" + monkeyButtons.get(i).getPrice());
       monkPan.add( monkeyButtons.get(i));
    }
   return monkPan;
} // end monkey panel



 private JPanel peopleWithMonkeysPanel(){
     JPanel peepsWithMonkPan = new JPanel();
     peepsWithMonkPan.setLayout(new GridLayout(10 ,10));
         peopleWhoOwnMonkeys = monkeyTown.peopleWhoOwnMonkeys();
    // String bannre = peopleWhoOwnMonkeys.size() + " people own " + numMonkeyz + " monkeys";
     //numberOfMonkeysLabel.setText(bannre);
    for(int i = 0; i < 100 ; i++){
       JButton pwm = new JButton();
       
       if(i<peopleWhoOwnMonkeys.size()){
           numMonkeyz =  numMonkeyz + peopleWhoOwnMonkeys.get(i).getNumberOfMonkeys();
       pwm.setText("" + peopleWhoOwnMonkeys.get(i).getNumberOfMonkeys());//b.setText("" + a.get(i).getPrice());
       }else{
          pwm.setBackground(Color.black);
       }
       peepsWithMonkPan.add(pwm);
    }
    return peepsWithMonkPan;
} // end people with monkeys panel   
 
 
  private JPanel merchantPanel(){
     JPanel mercPanel = new JPanel();
     saleCount = 0;
     mercPanel.setLayout(new GridLayout(10 ,1));//mercPanel.setLayout(new GridLayout(1 ,numberOfMerchants));
         experiencedSellers = monkeyTown.merchantsWithSales();
    // String bannre = peopleWhoOwnMonkeys.size() + " people own " + numMonkeyz + " monkeys";
     //numberOfMonkeysLabel.setText(bannre);
    for(int i = 0; i < 10 ; i++){
       JButton merc = new JButton();
       
       if(i<experiencedSellers.size()){
        saleCount = saleCount + experiencedSellers.get(i).getNumberOfReceipts(); 
       merc.setText("" + experiencedSellers.get(i).getNumberOfReceipts());//b.setText("" + a.get(i).getPrice());
       }else{
          merc.setBackground(Color.black);
       }
       mercPanel.add(merc);
    }
    
   
    
    
    return mercPanel;
} // end merchant panel 
  
  
 public void setLabel(){
     
      String bannre = peopleWhoOwnMonkeys.size() + " people own " + numMonkeyz + " monkeys";
       String bannre2 = "<html><h2><font color='blue'>" + peopleWhoOwnMonkeys.size() + " people own "  + "</font><font color='red'>" + numMonkeyz + " monkeys" + "</font><h2></html>";
       String bannre3 = "<html><h2><font color='blue'>" +  "trust me!"  + "</font><font color='red'>" +  " ... just kidding, this needs afixin'" + "</font><h1></html>";
       String bannre4 = "<html><h1><font color='black' >" +  "100 monkeys"  + "</font></h1></html>";
       String bannre5 = "<html><h2><font color='black' >" +  "transaction count is good"  + "</font></h2></html>";
       String bannre6 = "<html><h3><font color='black' >" +  "transaction count is NOT good\n"  + "</font><font color='red'>" + "(returned " + saleCount + ", expected:" + numberOfTransactions +  ")" + "</font><h3></html>";
     numberOfMonkeysLabel.setText(bannre2); 
      if(saleCount==numberOfTransactions){
        trustTheMonkeysLabel.setText(bannre5);
    }else{
        trustTheMonkeysLabel.setText(bannre6);
    }
     titleLabel.setText(bannre4); 
 }

    @Override
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
                if (obj == startButton){

                   monkeyPictureButton.setVisible(true);
                   startButton.setVisible(false);
                    makeMonkeyPanels();
                    String bannre3 = "<html><h2><font color='blue'>" +  "start time!"  + "</font><font color='red'>" +  "  start game event" + "</font><h1></html>";
                   numberOfMonkeysLabel.setText(bannre3); 

                }
                
                
                if (obj == monkeyPictureButton){

                    startButton.setVisible(true);
                    removeMonkeyPanels();
                    String bannre3 = "<html><h2><font color='blue'>" +  "monkey time!"  + "</font><font color='red'>" +  "   monkey monkey!" + "</font><h1></html>";
                   numberOfMonkeysLabel.setText(bannre3); 

                }
                
                for(int i = 0; i < monkeyButtons.size(); i++){
    
             
                 if (obj ==  monkeyButtons.get(i)){
                     
                     printResults(monkeyButtons.get(i).transactionArray());
                    break;  
                    }
       
                }
                        
    }  //  end action listener
 
public void printResults(ArrayList<String> s){
     
    showText.setText(null);
     
       for(int i = 0; i < s.size(); i++){
          
          showText.append(s.get(i) + "\n"); 
       }
     
 }
 
}// end class
