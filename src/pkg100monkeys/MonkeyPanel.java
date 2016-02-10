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
    JButton monkeyPictureButton;
    JButton startButton;
    SliderPanel sliderPanel;
    JPanel monkeyPanel;
    JPanel peopleWithMonkeysPanel;
    int numberOfMerchants = 1;
    int numberOfTownsPeople = 1;
    int numberOfTransactions = 1;
     
    public MonkeyPanel(){
        
        super();
        
        
        //monkeyTown = new MonkeyMarket(); // moved to the make monkey panels method
        
        
        createUI();
        
        setLabel();
        
    }  // end constructor
    
private void createUI(){
    
    
    setLayout(null);
    
    sliderPanel = new SliderPanel(this);
    sliderPanel.setBounds(608,220,360,300);
    add(sliderPanel);
    monkeyPictureButton = new JButton();
    monkeyPictureButton.setIcon(new ImageIcon("images/monkey.jpg"));
    monkeyPictureButton.setBounds(688,84,130,127);
    monkeyPictureButton.addActionListener(this);
    add(monkeyPictureButton);
    startButton = new JButton("start");
    startButton.setBounds(588,700,80,42);
    startButton.setVisible(false);
    startButton.addActionListener(this);
    add(startButton);
      
      
  
     makeMonkeyPanels();
 
    

    
    numberOfMonkeysLabel = new JLabel("numberOfMonkeysLabel");
    numberOfMonkeysLabel.setBounds(538,590,420,42);
    add(numberOfMonkeysLabel);
    trustTheMonkeysLabel = new JLabel("trustTheMonkeysLabel");
    trustTheMonkeysLabel.setBounds(538,640,420,42);
    add(trustTheMonkeysLabel);
    titleLabel = new JLabel("100 monkeys");
    titleLabel.setBounds(688,14,420,42);
    titleLabel.setBackground(Color.yellow);
    add(titleLabel);
   
    
    
    
}   // end create UI 
 

private void makeMonkeyPanels(){
    
    monkeyTown = new MonkeyMarket(numberOfMerchants, numberOfTownsPeople, numberOfTransactions);  // this generates the data in the game
    
      monkeyPanel = monkeyPanel();
    
    monkeyPanel.setBounds(20,20,550,550);
    
    peopleWithMonkeysPanel = peopleWithMonkeysPanel();
    
    peopleWithMonkeysPanel.setBounds(80,590,420,360);
     add(monkeyPanel);
      add(peopleWithMonkeysPanel);
    repaint();
}// end make monkey panels

private void removeMonkeyPanels(){
    
      
     remove(monkeyPanel);
     remove(peopleWithMonkeysPanel);
     repaint();
}// end make monkey panels

private JPanel monkeyPanel(){
      JPanel monkPan = new JPanel();
      monkPan.setLayout(new GridLayout(10 ,10));
    ArrayList<Monkey> a = monkeyTown.monkeys();
    for(int i = 0; i < a.size(); i++){
       JButton m = new JButton();
       //m.setText("" + a.get(i).getId());
        m.setText("" + a.get(i).getPrice());
       monkPan.add(m);
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
 
 public void setLabel(){
     
      String bannre = peopleWhoOwnMonkeys.size() + " people own " + numMonkeyz + " monkeys";
       String bannre2 = "<html><h2><font color='blue'>" + peopleWhoOwnMonkeys.size() + " people own "  + "</font><font color='red'>" + numMonkeyz + " monkeys" + "</font><h2></html>";
       String bannre3 = "<html><h2><font color='blue'>" +  "trust me!"  + "</font><font color='red'>" +  " ... just kidding, this needs afixin'" + "</font><h1></html>";
       String bannre4 = "<html><h1><font color='black' >" +  "100 monkeys"  + "</font></h1></html>";
     numberOfMonkeysLabel.setText(bannre2); 
     trustTheMonkeysLabel.setText(bannre3); 
     titleLabel.setText(bannre4); 
 }

    @Override
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
                if (obj == startButton){


                    makeMonkeyPanels();
                    String bannre3 = "<html><h2><font color='blue'>" +  "start time!"  + "</font><font color='red'>" +  "  start game event" + "</font><h1></html>";
                   numberOfMonkeysLabel.setText(bannre3); 

                }
                
                
                if (obj == monkeyPictureButton){


                    removeMonkeyPanels();
                    String bannre3 = "<html><h2><font color='blue'>" +  "monkey time!"  + "</font><font color='red'>" +  "   monkey monkey!" + "</font><h1></html>";
                   numberOfMonkeysLabel.setText(bannre3); 

                }
                        
    }  //  end action listener
 
 
 
}// end class
