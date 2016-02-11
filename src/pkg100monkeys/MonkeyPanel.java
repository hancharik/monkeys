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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author mark
 */
public class MonkeyPanel extends JPanel implements ActionListener{
    
    MonkeyMarket monkeyTown;
    
    JLabel numberOfMonkeysLabel;
    JLabel trustTheMonkeysLabel;
    JLabel titleLabel;
    
    ArrayList<TownsFolk> peopleWhoOwnMonkeys;
    ArrayList<TownsFolk> peopleButtons;
    ArrayList<MonkeyMerchant> experiencedSellers;
    ArrayList<Monkey> monkeyButtons;
    ArrayList<Transaction> transactions;
    
    JButton monkeyPictureButton;
    JButton startButton;
    JButton showTransButton;
    JButton showPeopleButton;
    
    SliderPanel sliderPanel;
    
    JPanel monkeyPanel;
    JPanel monkeyMerchantPanel;
    JPanel peopleWithMonkeysPanel;
    
    int numberOfMerchants = 10;
    int numberOfTownsPeople = 100;
    int numberOfTransactions = 1;
    int theme = 1;
    int growthRate = 100;
    int saleCount = 0;
    int numMonkeyz = 0;
    int monkeyOwners = 0;
    
    JTextArea showText;
    JScrollPane scroll;
    
            
    public MonkeyPanel(){
        
        super();
        
        setBackground(randomColor(theme));
        //monkeyTown = new MonkeyMarket(); // moved to the make monkey panels method
        
        
        createUI();
        
        //setLabel();
        
    }  // end constructor
    
private void createUI(){
    
    
    setLayout(null);
    monkeyButtons = new ArrayList();
    peopleWhoOwnMonkeys = new ArrayList();
    transactions = new ArrayList();
    
    sliderPanel = new SliderPanel(this);
    sliderPanel.setBounds(828,300,420,360);
    //sliderPanel.setVisible(false);
    add(sliderPanel);
    
    showPeopleButton = new JButton("show people");
    showPeopleButton.setBounds(696,244,160,40);
    showPeopleButton.setBackground(Color.yellow);
    showPeopleButton.setVisible(false);
    showPeopleButton.addActionListener(this);
    add(showPeopleButton);
    
    showTransButton = new JButton("show transactions");
    showTransButton.setBounds(696,244,160,40);
    showTransButton.setBackground(Color.yellow);
    //showTransButton.setVisible(false);
    showTransButton.addActionListener(this);
    add(showTransButton);
    
    monkeyPictureButton = new JButton("new");
    monkeyPictureButton.setIcon(new ImageIcon("images/monkey.jpg"));
    monkeyPictureButton.setBounds(712,364,120,120);
   monkeyPictureButton.setBackground(randomColor(theme));
    monkeyPictureButton.addActionListener(this);
    add(monkeyPictureButton);
    
    startButton = new JButton("start");
    startButton.setBounds(948,244,80,40);
    startButton.setVisible(false);
    startButton.addActionListener(this);
    add(startButton);
      
      
  
     makeMonkeyPanels();
 
    

    
    numberOfMonkeysLabel = new JLabel("");
    numberOfMonkeysLabel.setBounds(920,84,420,42);
    add(numberOfMonkeysLabel);
    trustTheMonkeysLabel = new JLabel("<html><h1><font color='black' >" +  "100 monkeys"  + "</font></h1></html>");
    trustTheMonkeysLabel.setBounds(694,304,420,42);
    add(trustTheMonkeysLabel);
    titleLabel = new JLabel("<html><h1><font color='black' >" +  "100 monkeys"  + "</font></h1></html>");
    titleLabel.setBounds(1014,14,180,40);
    titleLabel.setBackground(Color.yellow);
    add(titleLabel);
    
    
    showText = new JTextArea();
    //showText.setBounds(840,0,520,220);
    showText.setBackground(Color.yellow);
    scroll = new JScrollPane (showText, 
   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setBounds(824,6,520,220);
    add(scroll);
    
    
    
}   // end create UI 
 





private void makeMonkeyPanels(){
    
    
    sliderPanel.setVisible(false);
    
    
    monkeyTown = new MonkeyMarket(numberOfMerchants, numberOfTownsPeople, numberOfTransactions, growthRate);  // this generates the data in the game
    
    monkeyPanel = monkeyPanel();
    monkeyPanel.setBounds(6,6,680,580);
    
    peopleWithMonkeysPanel = peopleWithMonkeysPanel();
    peopleWithMonkeysPanel.setBounds(900,240,420,420);
    
    monkeyMerchantPanel = merchantPanel();
    monkeyMerchantPanel.setBounds(6,640,680,60);
    
    
     add(monkeyPanel);
     add(peopleWithMonkeysPanel);
     add(monkeyMerchantPanel);
     
  
     
    repaint();
    
    
    
}// end make monkey panels








private void removeMonkeyPanels(){
    monkeyPictureButton.setVisible(false);
    trustTheMonkeysLabel.setVisible(false);
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
        monkeyButtons.get(i).setRateOfGrowth(growthRate);
       monkeyButtons.get(i).addActionListener(this);
        monkeyButtons.get(i).setText("" + monkeyButtons.get(i).getPrice());
         monkeyButtons.get(i).setColor(randomColor(theme));
        monkeyButtons.get(i).setBackground(monkeyButtons.get(i).getColor());
       monkPan.add( monkeyButtons.get(i));
    }
    colorSoldMonkeys();
   return monkPan;
} // end monkey panel

private void colorSoldMonkeys(){
   for(int i = 0; i < monkeyButtons.size(); i++){
        if(monkeyButtons.get(i).openMarketMonkey()){
         monkeyButtons.get(i).setColor(Color.BLACK);
        monkeyButtons.get(i).setBackground(monkeyButtons.get(i).getColor());   
        }
    } 
    
}

 private JPanel peopleWithMonkeysPanel(){
     JPanel peepsWithMonkPan = new JPanel();
     peepsWithMonkPan.setLayout(new GridLayout(10 ,10));
         peopleButtons = monkeyTown.town();
    colorButtonsOfPeopleWithMonkeys();
    for(int i = 0; i < 100 ; i++){   
       peopleButtons.get(i).addActionListener(this);
      peepsWithMonkPan.add(peopleButtons.get(i));
      
    }
    return peepsWithMonkPan;
} // end people with monkeys panel   
 
 
 
 
  private void colorButtonsOfPeopleWithMonkeys(){
    
    for(int i = 0; i < 100 ; i++){   
       
       if(peopleButtons.get(i).getNumberOfMonkeys()>0){
           monkeyOwners = monkeyOwners++;
           peopleButtons.get(i).addActionListener(this);
           numMonkeyz =  numMonkeyz + peopleButtons.get(i).getNumberOfMonkeys();
       peopleButtons.get(i).setText("" + peopleButtons.get(i).getNumberOfMonkeys());//b.setText("" + a.get(i).getPrice());
       peopleButtons.get(i).setBackground(randomColor(theme));
      
       }else{
          
         peopleButtons.get(i).setBackground(Color.black);
         
       }
      
    }
  
} // end people with monkeys panel
  
  
  
  
  
  
  private JPanel merchantPanel(){
     JPanel mercPanel = new JPanel();
     saleCount = 0;
     mercPanel.setLayout(new GridLayout(1 ,10));//mercPanel.setLayout(new GridLayout(1 ,numberOfMerchants));
         experiencedSellers = monkeyTown.merchantsWithSales();
    // String bannre = peopleWhoOwnMonkeys.size() + " people own " + numMonkeyz + " monkeys";
     //numberOfMonkeysLabel.setText(bannre);
    for(int i = 0; i < 10 ; i++){
       
       
       
       if(i < experiencedSellers.size()){
           experiencedSellers.get(i).addActionListener(this);
        saleCount = saleCount + experiencedSellers.get(i).getNumberOfReceipts(); 
       experiencedSellers.get(i).setText("" + experiencedSellers.get(i).getNumberOfReceipts());//b.setText("" + a.get(i).getPrice());
       experiencedSellers.get(i).setBackground(randomColor(theme));
       mercPanel.add(experiencedSellers.get(i));
       }else{
           MonkeyMerchant blank = new MonkeyMerchant();
          blank.setBackground(Color.black);
          mercPanel.add(blank);
       }
       
    }
    
   
    
    
    return mercPanel;
} // end merchant panel 
  
  
 public void setLabel1(){
     
     // String bannre = monkeyOwners + " people own " + numMonkeyz + " monkeys";
      // String bannre2 = "<html><h2><font color='blue'>" + monkeyOwners + " people own "  + "</font><font color='red'>" + numMonkeyz + " monkeys" + "</font><h2></html>";
       String bannre3 = "<html><h2><font color='blue'>" +  "trust me!"  + "</font><font color='red'>" +  " ... just kidding, this needs afixin'" + "</font><h1></html>";
       String bannre4 = "<html><h1><font color='black' >" +  "100 monkeys"  + "</font></h1></html>";
       String bannre5 = "<html><h2><font color='black' >" +  "transaction count is good"  + "</font></h2></html>";
      // String bannre6 = "<html><h3><font color='black' >" +  "transaction count is NOT good\n"  + "</font><font color='red'>" + "(returned " + saleCount + ", expected:" + numberOfTransactions +  ")" + "</font><h3></html>";
    numberOfMonkeysLabel.setText(bannre4); 
      if(saleCount==numberOfTransactions){
        trustTheMonkeysLabel.setText(bannre4);
    }else{
        trustTheMonkeysLabel.setText(bannre4);
    }
     titleLabel.setText(bannre4); 
 }

    @Override
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
                if (obj == startButton){

                    setBackground(randomColor(theme));
                    showText.setText(null);
                    showText.setBackground(Color.yellow);
                    titleLabel.setVisible(true);
                   monkeyPictureButton.setVisible(true);
                   trustTheMonkeysLabel.setVisible(true);
                   startButton.setVisible(false);
                    makeMonkeyPanels();
                    String bannre3 = "<html><h2><font color='blue'>" +  "start time!"  + "</font><font color='red'>" +  "  start game event" + "</font><h1></html>";
                   numberOfMonkeysLabel.setText(""); 
                  

                }
                
                if (obj == showTransButton){
                    scroll.setBounds(866,6,480,620);
                    titleLabel.setVisible(false);
                    peopleWithMonkeysPanel.setVisible(false);
                    showTransButton.setVisible(false);
                    showPeopleButton.setVisible(true);
                     printTransactions();
                  

                }
                 if (obj == showPeopleButton){
                     showText.setText(null);
                    scroll.setBounds(824,6,520,220);
                    titleLabel.setVisible(true);
                    peopleWithMonkeysPanel.setVisible(true);
                    showPeopleButton.setVisible(false);
                    showTransButton.setVisible(true);
                     
                  

                }
                 
                
                if (obj == monkeyPictureButton){

                    showText.setText(null);
                    startButton.setVisible(true);
                    removeMonkeyPanels();
                    String bannre3 = "<html><h2><font color='blue'>" +  "monkey time!"  + "</font><font color='red'>" +  "   monkey monkey!" + "</font><h1></html>";
                   numberOfMonkeysLabel.setText(bannre3); 

                }
                
                for(int i = 0; i < monkeyButtons.size(); i++){
    
             
                 if (obj ==  monkeyButtons.get(i)){
                     
                      showText.setBackground(monkeyButtons.get(i).getColor());
                     printResults(monkeyButtons.get(i).transactionArray());
                    break;  
                    }
       
                }
                
                 for(int i = 0; i < experiencedSellers.size(); i++){
    
             
                 if (obj ==  experiencedSellers.get(i)){
                     showText.setBackground(experiencedSellers.get(i).getBackground());
                     printResults(experiencedSellers.get(i).transactionArray());
                    break;  
                    }
       
                }
                 
                         
                 for(int i = 0; i < peopleButtons.size(); i++){
    
             
                 if (obj ==  peopleButtons.get(i)){
                     showText.setBackground(peopleButtons.get(i).getBackground());
                     printResults(peopleButtons.get(i).transactionArray());
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
 
private void matchTextAreaColor(){
    
    
    
    
}

public Color randomColor(int themeChoice){

                        int same;
    
                        int R = (int) (Math.random( )*256);
                        int G = (int)(Math.random( )*256);
                        int B= (int)(Math.random( )*256);
                                
                        Color randomColor = new Color(R, G, B);
    
    
    switch(themeChoice){
        // original monkey yellows, browns, and greens
                        case 1: R = (int) (Math.random( )*156)+100;
                                G = (int)(Math.random( )*56)+200;
                                B= (int)(Math.random( )*56);break; 
                        case 2: B = (int) (Math.random( )*156)+100;
                                R = (int)(Math.random( )*56)+200;
                                G= (int)(Math.random( )*56); break; 
                        case 3: R = (int) (Math.random( )*156)+100;
                                B = (int)(Math.random( )*56)+200;
                                G= (int)(Math.random( )*56); break; 
                        case 4: G = (int) (Math.random( )*156)+100;
                                B = (int)(Math.random( )*56)+200;
                                R= (int)(Math.random( )*56); break; 
                        case 5: G = (int) (Math.random( )*56)+200;
                                R = (int)(Math.random( )*56)+200;
                                B= (int)(Math.random( )*56)+200;break;
                        case 6: R = (int) (Math.random( )*56)+100;
                                G = (int)(Math.random( )*56)+100;
                                B= (int)(Math.random( )*56)+100; break;
                       // grayscale if you set them all to same value...
                        case 7: R = (int) (Math.random( )*88)+88;
                                G = (int)(Math.random( )*88)+88;
                                B= (int)(Math.random( )*88)+88; break;
                      // reduce the range for subtle greyscale...
                        case 8: R = (int) (Math.random( )*60)+160;
                                G = (int)(Math.random( )*60)+160;
                                B= (int)(Math.random( )*60)+160; break;
                          // this is nice...
                        case 9: R = (int) (Math.random( )*56)+100;
                                G = (int)(Math.random( )*56)+100;
                                B= (int)(Math.random( )*56)+100; break; 
                                   // really pull back...
                        case 10: same = (int) (Math.random( )*66) + 180;
                                R = same; 
                                G = same;
                                B= same; break;
                                case 11: G = (int) (Math.random( )*156)+100;
                                B = (int)(Math.random( )*56)+200;
                                R= (int)(Math.random( )*56); break;
                                case 12: R = (int) (Math.random( )*156)+100;
                                B = (int)(Math.random( )*56)+200;
                                G= (int)(Math.random( )*56); break;
                                case 13: R = (int) (Math.random( )*20)+160;
                                G = (int)(Math.random( )*20)+160;
                                B= (int)(Math.random( )*20)+160; break;
                                case 14: R = (int) (Math.random( )*120)+60;
                                G = (int)(Math.random( )*20)+160;
                                B= (int)(Math.random( )*90)+150; break;
                        default:R = (int) (Math.random( )*256);
                                G = (int)(Math.random( )*256);
                                B= (int)(Math.random( )*256); break;
                        
    }
                     randomColor = new Color(R, G, B);  

                return randomColor;

} // end random color

private void printTransactions(){
    ArrayList<String> strings = new ArrayList();
                for(int i = 0; i < monkeyTown.transactions().size(); i++){
                 
                    strings.add(monkeyTown.transactions().get(i).printTransactionRecord());
               
                }
     printResults(strings);
} // end print transactions

}// end class
