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
import javax.imageio.ImageIO;
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
    JLabel resultLabel;
    JLabel titleLabel;
    
    ArrayList<TownsFolk> peopleWhoOwnMonkeys;
    ArrayList<TownsFolk> peopleButtons;
    ArrayList<MonkeyMerchant> experiencedSellers;
    ArrayList<MonkeyMerchant> merchantButtons;
    ArrayList<Monkey> monkeyButtons;
    ArrayList<Transaction> transactions;
    
    JButton quickSimButton;
    JButton runTimerButton;
    JButton quickSimButton2;
    JButton startButton;
    JButton showTransButton;
    JButton showPeopleButton;
    JButton showMonkeyNamesButton;
    JButton showHumanNamesButton;
    JButton marketButton;
    
    SliderPanel sliderPanel;
    
    JPanel monkeyPanel;
    JPanel monkeyMerchantPanel;
    JPanel peopleWithMonkeysPanel;
    
    private String htmlstart;
    private String htmlend;
    
    int numberOfMerchants = 10;
    int numberOfTownsPeople = 100;
    int numberOfTransactions = 1;
    int theme = 4;
    int growthRate = 100;
    int saleCount = 0;
    int numMonkeyz = 0;
    int monkeyOwners = 0;
    
    JTextArea showText;
    JScrollPane scroll;
    int scrollx = 694;
    int rowx = 300;
           
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
    

    
    
    
    
    
    
       ///////////////////////////////////////////////////////  
    ///////////////////////////////////////////////////////
    ///////// this is a group
    
    
    startButton = new JButton("start");
    startButton.setBounds(888,244,120,40);
    startButton.setBackground(Color.yellow);//.setBackground(randomColor(theme));
    startButton.setVisible(false);
    startButton.addActionListener(this);
    add(startButton);
      
     runTimerButton = new JButton("run timer");
     runTimerButton.setBounds(1040,244,120,40);
     runTimerButton.setBackground(Color.yellow);
     runTimerButton.setVisible(false);
     runTimerButton.addActionListener(this);
    add( runTimerButton);
    
    
     
    ///////// this is a group
       ///////////////////////////////////////////////////////
 ///////////////////////////////////////////////////////
    
    
    
    
  
     makeMonkeyPanels();
 
    

    
    numberOfMonkeysLabel = new JLabel("");
    numberOfMonkeysLabel.setBounds(920,84,420,42);
    add(numberOfMonkeysLabel);
    
    
    
    
    
   ///////////////////////////////////////////////////////  
    ///////////////////////////////////////////////////////
    ///////// this is a group
    
    resultLabel = new JLabel("<html><h1><font color='black' >" +  "100 monkeys"  + "</font></h1></html>");
    resultLabel.setBounds(scrollx + 8,rowx,420,42);
    add(resultLabel);
    
    quickSimButton = new JButton("new quick sim");
    //quickSimButton.setIcon(new ImageIcon("images/monkey.jpg"));
    quickSimButton.setBounds(scrollx,rowx + 40,160,40);
    quickSimButton.setBackground(Color.yellow);
   //quickSimButton.setBackground(randomColor(theme));
    quickSimButton.addActionListener(this);
    add(quickSimButton);

 
   
         marketButton = new JButton(  monkeysInTheMarket() +" market monkeys" );
    //quickSimButton.setIcon(new ImageIcon("images/monkey.jpg"));
    marketButton.setBounds(scrollx,rowx + 80,160,40);
    marketButton.setBackground(Color.yellow);
   //quickSimButton.setBackground(randomColor(theme));
    marketButton.addActionListener(this);
    add(marketButton);
    
        showPeopleButton = new JButton("show people");
    showPeopleButton.setBounds(scrollx,rowx + 280,160,40);
    showPeopleButton.setBackground(Color.yellow);
    showPeopleButton.setVisible(false);
    showPeopleButton.addActionListener(this);
    add(showPeopleButton);
    
    showTransButton = new JButton("show transactions");
    showTransButton.setBounds(scrollx,rowx + 160,160,40);
    showTransButton.setBackground(Color.yellow);
    //showTransButton.setVisible(false);
    showTransButton.addActionListener(this);
    add(showTransButton);
    
    showMonkeyNamesButton = new JButton("show monkey names");
    showMonkeyNamesButton.setBounds(scrollx,rowx + 200,160,40);
    showMonkeyNamesButton.setBackground(Color.yellow);
    //showTransButton.setVisible(false);
    showMonkeyNamesButton.addActionListener(this);
    add(showMonkeyNamesButton);
    
    showHumanNamesButton = new JButton("show human names");
    showHumanNamesButton.setBounds(scrollx,rowx + 240,160,40);
    showHumanNamesButton.setBackground(Color.yellow);
    //showTransButton.setVisible(false);
    showHumanNamesButton.addActionListener(this);
    add(showHumanNamesButton);
    ///////// this is a group
       ///////////////////////////////////////////////////////
 ///////////////////////////////////////////////////////
 

 
 
 
   ///////////////////////////////////////////////////////  
    ///////////////////////////////////////////////////////
    ///////// this is a group
 
    titleLabel = new JLabel("<html><h1><font color='black' >" +  "100 monkeys"  + "</font></h1></html>");
    titleLabel.setBounds(940,14,180,40);
    titleLabel.setBackground(Color.yellow);
    add(titleLabel);
    
      quickSimButton2 = new JButton("monkey pic 2");
      String picname = "images/monkey.jpg"; 
     // ImageIcon monkeyPic = new ImageIcon(getClass().getResource("images/monkey.jpg"));
                // ImageIcon monkeyPic = new ImageIcon(this.getClass().getClassLoader().getResource("images/monkey.jpg"));
                ImageIcon monkeyPic = new ImageIcon(picname);
      
      //monkeyPic = ImageIO.read(getClass().getResource("images/monkey.jpg"));
      System.out.println("YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n"
             +  "YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n"
                +  "YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n"
                +  "YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n"
              + this.getClass().getClassLoader().getResourceAsStream("images/monkey.jpg").toString() + "\n"
//               + this.getClass().getResource("images/monkey.jpg").toString() + "\n"
                +  "YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n"
                +  "YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n"
              + "YAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
       //ImageIcon monkeyPic = new ImageIcon(this.getClass().getClassLoader().getResourceAsStream("images/monkey.jpg").toString());       
              
    quickSimButton2.setIcon(monkeyPic);
    //quickSimButton2.setIcon(this.getClass().getClassLoader().getResourceAsStream("images/monkey.jpg"));
    quickSimButton2.setBounds(958,64,120,120);
   quickSimButton2.setBackground(randomColor(theme));
    quickSimButton2.addActionListener(this);
    add(quickSimButton2);
 
    ///////// this is a group
       ///////////////////////////////////////////////////////
 ///////////////////////////////////////////////////////
 
    
 
 
 
 
 
 
    
       ///////////////////////////////////////////////////////  
    ///////////////////////////////////////////////////////
    ///////// this is a group
    
    showText = new JTextArea();
    //showText.setBounds(840,0,520,220);
    showText.setBackground(Color.yellow);
    scroll = new JScrollPane (showText, 
   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setBounds(scrollx,6,640,220);
    add(scroll);
    
       ///////// this is a group
       ///////////////////////////////////////////////////////
 /////////////////////////////////////////////////////// 
   






 
}   // end create UI 
 


















private int monkeysInTheMarket(){
    
    int tempInt = monkeyTown.freeMarketMonkeys();
    int result = 100 - tempInt;
    return monkeyTown.freeMarketMonkeys();
}



private void makeMonkeyPanels(){
    
    
  
    
    
    monkeyTown = new MonkeyMarket(numberOfMerchants, numberOfTownsPeople, numberOfTransactions, growthRate);  // this generates the data in the game
    
    
    
    
       ///////////////////////////////////////////////////////  
    ///////////////////////////////////////////////////////
    ///////// this is a group
    
    
    monkeyPanel = monkeyPanel();
    monkeyPanel.setBounds(6,6,680,580);
    
    peopleWithMonkeysPanel = peopleWithMonkeysPanel();
    peopleWithMonkeysPanel.setBounds(920,280,420,420);
    
    monkeyMerchantPanel = merchantPanel();
    monkeyMerchantPanel.setBounds(6,640,680,60);
    
    
     add(monkeyPanel);
     add(peopleWithMonkeysPanel);
     add(monkeyMerchantPanel);
     
     ///////// this is a group
       ///////////////////////////////////////////////////////
 ///////////////////////////////////////////////////////
 
 
      sliderPanel.setVisible(false);
     
    repaint();
    
    
    
}// end make monkey panels








private void removeMonkeyPanels(){
    runTimerButton.setVisible(true);
    quickSimButton.setVisible(false);
    marketButton.setVisible(false);
    resultLabel.setVisible(false);
    showMonkeyNamesButton.setVisible(false);
    showHumanNamesButton.setVisible(false);
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
    for(int i = 0; i < 100; i++){
        monkeyButtons.get(i).setRateOfGrowth(growthRate);
       monkeyButtons.get(i).addActionListener(this);
        monkeyButtons.get(i).setText("" + monkeyButtons.get(i).getId()); // monkeyButtons.get(i).setText("" + monkeyButtons.get(i).getPrice());
         monkeyButtons.get(i).setColor(randomColor(theme));
        monkeyButtons.get(i).setBackground(monkeyButtons.get(i).getColor());
       monkPan.add( monkeyButtons.get(i));
    }
    colorSoldMonkeys();
   return monkPan;
} // end monkey panel

private void colorSoldMonkeys(){
   for(int i = 0; i < 100; i++){
        if(monkeyButtons.get(i).openMarketMonkey()){
         monkeyButtons.get(i).setColor(Color.YELLOW);
        monkeyButtons.get(i).setBackground(monkeyButtons.get(i).getColor());   
        }
    } 
    
}






private void colorMarket(){
    
    
    // i was going to have people.get(0) be the market, but that's wrong...
    // so i'm going to make a market button, it can display market information
    
                marketButton.setBackground(Color.YELLOW);
    
    //this is a very inefficient way, left it here for testing purposes 
  // for(int i = 0; i < monkeyButtons.size(); i++){
  //        peopleButtons.get(i).setBackground(Color.YELLOW);
         //this is a better way, 
            //if(peopleWhoOwnMonkeys.size() > 0){
            //    peopleButtons.get(0).setBackground(Color.YELLOW);

          //  }
    //} 
    
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
         peopleButtons.get(i).addActionListener(this);
       }
      
    }
  
} // end color buttons of people with monkeys panel
  
  
  
  
  
  
  private JPanel merchantPanel(){
    
     JPanel mercPanel = new JPanel();
       mercPanel.setLayout(new GridLayout(1 ,10));
         merchantButtons = monkeyTown.merchants();
    colorMerchantsWithTransactions();
    for(int i = 0; i < 10 ; i++){   
        
        int numberShowing = merchantButtons.get(i).transactionArray().size()-1;//b.setText("" + a.get(i).getPrice());
       merchantButtons.get(i).setText("" + numberShowing);//b.setText("" + a.get(i).getPrice());
      // merchantButtons.get(i).setBackground(randomColor(theme));
        
        
       merchantButtons.get(i).addActionListener(this);
      mercPanel.add(merchantButtons.get(i));
      
    }
      /*
     
     mercPanel.setLayout(new GridLayout(1 ,10));//mercPanel.setLayout(new GridLayout(1 ,numberOfMerchants));
         
         merchantButtons = new ArrayList();
    // String bannre = peopleWhoOwnMonkeys.size() + " people own " + numMonkeyz + " monkeys";
     //numberOfMonkeysLabel.setText(bannre);
   
       
       /////////////////////////////////////////////////////////////////////
       ///////////////////////////////////////////////////////////////////////////////
       
       
       
       
       
       
       
       
       
       
       
        mercPanel.add(merchantButtons.get(i));
       
        
    }  // end for loop
    
   
     */
    
    return mercPanel;
} // end merchant panel 
  
  
   
   private void colorMerchantsWithTransactions(){
    
       saleCount = 0;
       experiencedSellers = monkeyTown.merchantsWithSales();
       
   for(int i = 0; i < 10 ; i++){
       
              
       if(merchantButtons.get(i).numberOfTransactions() > 0){
           
        //   merchantButtons.get(i).addActionListener(this);
       // saleCount = saleCount + merchantButtons.get(i).getNumberOfReceipts(); 
      //  int numberShowing = merchantButtons.get(i).transactionArray().size()-1;//b.setText("" + a.get(i).getPrice());
      // merchantButtons.get(i).setText("" + numberShowing);//b.setText("" + a.get(i).getPrice());
       merchantButtons.get(i).setBackground(randomColor(theme));
       
      
       }else{
           
         merchantButtons.get(i).setBackground(Color.black);
      //   merchantButtons.get(i).addActionListener(this);
        
       }
      
    }
  
} // end color buttons of people with monkeys panel
   
  
  
  
  
  
  
  
  
  
  
 public void setLabel1(){
     
     // String bannre = monkeyOwners + " people own " + numMonkeyz + " monkeys";
      // String bannre2 = "<html><h2><font color='blue'>" + monkeyOwners + " people own "  + "</font><font color='red'>" + numMonkeyz + " monkeys" + "</font><h2></html>";
       String bannre3 = "<html><h2><font color='blue'>" +  "trust me!"  + "</font><font color='red'>" +  " ... just kidding, this needs afixin'" + "</font><h1></html>";
       String bannre4 = "<html><h1><font color='black' >" +  "100 monkeys"  + "</font></h1></html>";
       String bannre5 = "<html><h2><font color='black' >" +  "transaction count is good"  + "</font></h2></html>";
      // String bannre6 = "<html><h3><font color='black' >" +  "transaction count is NOT good\n"  + "</font><font color='red'>" + "(returned " + saleCount + ", expected:" + numberOfTransactions +  ")" + "</font><h3></html>";
    numberOfMonkeysLabel.setText(bannre4); 
      if(saleCount==numberOfTransactions){
        resultLabel.setText(bannre4);
    }else{
        resultLabel.setText(bannre4);
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
                     quickSimButton2.setVisible(true);
                   quickSimButton.setVisible(true);
                   marketButton.setVisible(true);
                   runTimerButton.setVisible(false);
                   resultLabel.setVisible(true);
                   startButton.setVisible(false);
                   showPeopleButton.setVisible(false);
                   showTransButton.setVisible(true);
                   showMonkeyNamesButton.setVisible(true);
                   showHumanNamesButton.setVisible(true);
                    makeMonkeyPanels();
                    scroll.setBounds(658,6,520,220);
                    String bannre3 = "<html><h2><font color='blue'>" +  "start time!"  + "</font><font color='red'>" +  "  start game event" + "</font><h1></html>";
                   numberOfMonkeysLabel.setText(""); 
                  marketButton.setText( monkeysInTheMarket() + " market monkeys");
                    colorSoldMonkeys();
                    resultLabel.setText("<html><h2><font color='black' >" +  numberOfTransactions + " transactions"  + "</font></h2></html>");
                    
                }
                
                if (obj == showTransButton){
                    scroll.setBounds(scrollx,6,640,420);
                    titleLabel.setVisible(false);
                    peopleWithMonkeysPanel.setVisible(false);
                   // showTransButton.setVisible(false);
                    showPeopleButton.setVisible(true);
                     quickSimButton2.setVisible(false);
                     printTransactions();
                  

                }
                 if (obj == showPeopleButton){
                   
                     showPeople();
                     
                     titleLabel.setVisible(true);
                     quickSimButton2.setVisible(true);
                     showPeopleButton.setVisible(false);

                }
                  if (obj == showMonkeyNamesButton){
                    
                      scroll.setBounds(scrollx,6,640,420);
                    titleLabel.setVisible(false);
                    peopleWithMonkeysPanel.setVisible(false);
                    //showTransButton.setVisible(false);
                    showPeopleButton.setVisible(true);
                     quickSimButton2.setVisible(false);
                     printMonkeyNames();

                }
                  if (obj == showHumanNamesButton){
                    
                      scroll.setBounds(scrollx,6,640,420);
                    titleLabel.setVisible(false);
                    peopleWithMonkeysPanel.setVisible(false);
                    //showTransButton.setVisible(false);
                    showPeopleButton.setVisible(true);
                     quickSimButton2.setVisible(false);
                     printHumanNames();

                }
                if (obj == quickSimButton){

                    showPeople();
                    showTransButton.setVisible(false);
                     startButton.setVisible(true);
                     showPeopleButton.setVisible(false);
                    removeMonkeyPanels();
                    String bannre3 = "<html><h2><font color='blue'>" +  "monkey time!"  + "</font><font color='red'>" +  "   monkey monkey!" + "</font><h1></html>";
                   numberOfMonkeysLabel.setText(bannre3); 
                    marketButton.setText("market :" + monkeysInTheMarket());
                }
                
                if (obj == marketButton){

                    

                }
                
                
                 if (obj == runTimerButton){

                    
                     // run the monkey economy on a timer

                }
                for(int i = 0; i < monkeyButtons.size(); i++){
    
             
                 if (obj ==  monkeyButtons.get(i)){
                     
                     showPeople();
                     
                      showText.setBackground(monkeyButtons.get(i).getColor());
                      if(monkeyButtons.get(i).getBackground().equals(Color.BLACK)){
                     showText.setBackground(Color.YELLOW);
                     titleLabel.setVisible(true);
                     quickSimButton2.setVisible(true);
                     }
                     printResults(monkeyButtons.get(i).transactionArray());
                    break;  
                    }
       
                }
                
                 for(int i = 0; i < merchantButtons.size(); i++){
    
             
                 if (obj ==  merchantButtons.get(i)){
                     
                     showPeople();
                     
                     showText.setBackground(merchantButtons.get(i).getBackground());
                     if(merchantButtons.get(i).getBackground().equals(Color.BLACK)){
                     showText.setBackground(Color.YELLOW); 
                     //titleLabel.setVisible(true);
                     //quickSimButton2.setVisible(true);
                     }
                     printResults(merchantButtons.get(i).transactionArray());
                    break;  
                    }
       
                }
                 
                         
                 for(int i = 0; i < peopleButtons.size(); i++){
    
             
                 if (obj ==  peopleButtons.get(i)){
                     
                       showPeople();
                     
                     showText.setBackground(peopleButtons.get(i).getBackground());
                     
                     /*
                     if(peopleButtons.get(i).getBackground().equals(Color.BLACK)){
                     showText.setBackground(Color.YELLOW); 
                     showText.setText(null);
                     titleLabel.setVisible(true);
                     quickSimButton2.setVisible(true);
                     }
                     */
                     // deja vu alt if statement
                     if(peopleButtons.get(i).getBackground().equals(Color.BLACK)){
                     showText.setBackground(Color.YELLOW); 
                     //showText.setText(null);
                     //titleLabel.setVisible(true);
                     //quickSimButton2.setVisible(true);
                     }
                     printResults(peopleButtons.get(i).transactionArray());
                     
                    break;  
                    
                    
                    }
       
                }
                        
    }  //  end action listener
 
public void printResults(ArrayList<String> s){
     
    showText.setText(null);
     scroll.setBounds(scrollx,6,640,260);
     htmlstart = "";//"<html><h2><font color='blue'>";
        htmlend = "\n";//"</font><h1></html>";
       for(int i = 0; i < s.size(); i++){
          
          showText.append(htmlstart +s.get(i) + htmlend); 
       }
     
 }
 
private void showPeople(){
    
                    showText.setText(null);
                    scroll.setBounds(758,6,520,220);
                   // titleLabel.setVisible(true);
                    peopleWithMonkeysPanel.setVisible(true);
                   // showPeopleButton.setVisible(false);
                    showTransButton.setVisible(true);
                    quickSimButton2.setVisible(false);
                    titleLabel.setVisible(false);
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






private void printMonkeyNames(){
    ArrayList<String> strings = new ArrayList();
   String header = "Array index:\tName:"; 
    
        strings.add(header);
                
   String space = "\t";
                for(int i = 0; i < monkeyButtons.size(); i++){
                 
                    strings.add(  i + space + monkeyButtons.get(i).getName());
               
                }
     printResults(strings);
} // end print transactions

private void printHumanNames(){
    ArrayList<String> strings = new ArrayList();
    String header = "Array index:\tName:"; 
    
        strings.add(header);
                
   String space = "\t";
                for(int i = 0; i < peopleButtons.size(); i++){
                 
                    strings.add(  i + space + peopleButtons.get(i).getName());
               
                }
     printResults(strings);
} // end print transactions



}// end class
