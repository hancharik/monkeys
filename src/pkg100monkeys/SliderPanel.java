/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author mark
 */
public class SliderPanel  extends JPanel implements ChangeListener{

    
    JSlider sliderOfMerchants;
    JSlider sliderOfTownsPeople;
    JSlider sliderOfTransactions;
    JSlider sliderOfGrowthRate;
    JSlider sliderOfTheme;
    
    JLabel labelOfTheme;
    JLabel labelOfMerchants;
    JLabel labelOfGrowthRate;
    JLabel labelOfTownsPeople;
    JLabel labelOfTransactions;
    JPanel themeDemonstrator;
    
    ArrayList<JButton> themeDemoButtons;
    ArrayList<JSlider> sliders;
    
    MonkeyPanel monkeyPanel;
    
    public SliderPanel(MonkeyPanel mp){
        
        super();
       
        monkeyPanel = mp;
        
        setLayout(new GridLayout(11, 1));
        setBackground(monkeyPanel.randomColor(monkeyPanel.theme));
         
         
        createPanel();
        
    }
    
    
    
    
    
   
     @Override
        public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
       
        if (source == sliderOfMerchants) {
            monkeyPanel.numberOfMerchants = source.getValue();
            labelOfMerchants.setText("<html><h2><font color='black'>Merchants: </font><font color='red'>" + monkeyPanel.numberOfMerchants + "</font><h2></html>");
            //monkeyPanel.trustTheMonkeysLabel.setText("<html><h2><font color='black'>Merchants: </font><font color='red'>" + valueReturned + "</font><h2></html>");
            monkeyPanel.startButton.setVisible(true);
        }
        if (source == sliderOfTownsPeople) {
            monkeyPanel.numberOfTownsPeople = source.getValue();
            labelOfTownsPeople.setText("<html><h2><font color='black'>Townspeople: </font><font color='red'>" + monkeyPanel.numberOfTownsPeople + "</font><h2></html>");
            monkeyPanel.startButton.setVisible(true);
        }
        if (source == sliderOfTransactions) {
            monkeyPanel.numberOfTransactions = source.getValue();
            labelOfTransactions.setText("<html><h2><font color='black'>Transactions: </font><font color='red'>" + monkeyPanel.numberOfTransactions + "</font><h2></html>");
            monkeyPanel.startButton.setVisible(true);
        }
        if (source == sliderOfGrowthRate) {
            monkeyPanel.growthRate = source.getValue();
            labelOfGrowthRate.setText("<html><h2><font color='black'>Growth Rate of price: </font><font color='red'>" + monkeyPanel.growthRate + "</font><h2></html>");
            monkeyPanel.startButton.setVisible(true);
        }
        if (source == sliderOfTheme) {
            monkeyPanel.theme = source.getValue();
            labelOfTheme.setText("<html><h2><font color='black'>   Theme: </font><font color='black'>       " + translateTheme(monkeyPanel.theme) + "</font><h2></html>");
            colorButtons();
            setBackground(monkeyPanel.randomColor(monkeyPanel.theme));
            monkeyPanel.setBackground(monkeyPanel.randomColor(monkeyPanel.theme));
            monkeyPanel.startButton.setBackground(monkeyPanel.randomColor(monkeyPanel.theme));
            monkeyPanel.startButton.setVisible(true);
        }
    }

        
   private String translateTheme(int t){
       String temporarilyThis = "pure random colors";
       switch(t){
           case 1: temporarilyThis = "100 monkeys"; break;
           case 2: temporarilyThis = "hot pink"; break;
           case 3: temporarilyThis = "purples and blues"; break;
           case 4: temporarilyThis = "cool blue"; break;
           case 5: temporarilyThis = "soft earth"; break;
           case 6: temporarilyThis = "smart fella"; break;
           case 7: temporarilyThis = "THEME 88"; break;
           case 8: temporarilyThis = "electric avenue"; break;
           case 9: temporarilyThis = "dark ages"; break;
           case 10: temporarilyThis = "easy gray"; break;
           case 11: temporarilyThis = "BLUES AGAIN"; break;
           case 12: temporarilyThis = "MOSTLY PURPLES"; break;
           case 13: temporarilyThis = "TRY NUMBER ONE"; break;
           case 14: temporarilyThis = "Graduate"; break;
       }
       //String gapSpacer = "\t" + temporarilyThis;
       
       return temporarilyThis;
   }     
        
        
    private void createPanel() {
     
    themeDemoButtons = new ArrayList();
    sliders = new ArrayList();
    themeDemonstrator = createThemeDemoButtons();
        
        
    sliderOfMerchants = new JSlider(JSlider.HORIZONTAL, 1, 10, monkeyPanel.numberOfMerchants);
    sliderOfTownsPeople = new JSlider(JSlider.HORIZONTAL, 1, 100, monkeyPanel.numberOfTownsPeople);
    sliderOfTransactions = new JSlider(JSlider.HORIZONTAL, 1, 1000, monkeyPanel.numberOfTransactions);
    sliderOfGrowthRate = new JSlider(JSlider.HORIZONTAL, 0, 100, monkeyPanel.growthRate);
    sliderOfTheme = new JSlider(JSlider.HORIZONTAL, 0, 15, monkeyPanel.theme);
    
    
   
    sliderOfTheme.setBackground(monkeyPanel.randomColor(monkeyPanel.theme));
    sliderOfGrowthRate.setBackground(monkeyPanel.randomColor(monkeyPanel.theme));
    sliderOfMerchants.setBackground(monkeyPanel.randomColor(monkeyPanel.theme));
    sliderOfTownsPeople.setBackground(monkeyPanel.randomColor(monkeyPanel.theme));
    sliderOfTransactions.setBackground(monkeyPanel.randomColor(monkeyPanel.theme));
    
    
    sliderOfTheme.addChangeListener(this);
    sliderOfGrowthRate.addChangeListener(this);
    sliderOfMerchants.addChangeListener(this);
    sliderOfTownsPeople.addChangeListener(this);
    sliderOfTransactions.addChangeListener(this);
    
    
    
    
    labelOfTheme = new JLabel("<html><h2><font color='black'>Theme: </font><font color='red'> " + translateTheme(monkeyPanel.theme) + "</font><h2></html>");
    labelOfGrowthRate = new JLabel("<html><h2><font color='black'>Growth Rate: </font><font color='red'>" + monkeyPanel.growthRate + "</font><h2></html>");
    labelOfMerchants = new JLabel("<html><h2><font color='black'>Merchants: </font><font color='red'>" + monkeyPanel.numberOfMerchants + "</font><h2></html>");
    labelOfTownsPeople = new JLabel("<html><h2><font color='black'>Townspeople: </font><font color='red'>" + monkeyPanel.numberOfTownsPeople + "</font><h2></html>");
    labelOfTransactions = new JLabel("<html><h2><font color='black'>Transactions: </font><font color='red'>" + monkeyPanel.numberOfTransactions + "</font><h2></html>");
        
    
    sliders.add(sliderOfTheme);
    sliders.add(sliderOfTransactions);
    sliders.add(sliderOfTownsPeople);
    sliders.add(sliderOfMerchants);
    sliders.add(sliderOfGrowthRate);
    
    
    
      add(themeDemonstrator);
      add(labelOfTheme);
      add(sliderOfTheme);
      add(labelOfGrowthRate);
      add(sliderOfGrowthRate);
      add(labelOfMerchants);
      add(sliderOfMerchants);
      add(labelOfTownsPeople);
      add(sliderOfTownsPeople);
      add(labelOfTransactions);
      add(sliderOfTransactions);
        
        
        
    } // end create panel
 
    
    private JPanel createThemeDemoButtons(){
        
        JPanel yoyo = new JPanel();
        yoyo.setLayout(new GridLayout(1, 10));
        for(int yy = 0; yy < 10; yy++){
            JButton jb = new JButton();
            themeDemoButtons.add(jb);
            yoyo.add(themeDemoButtons.get(yy));
        }
        colorButtons();
        return yoyo;
    }
    
public void colorButtons(){
    
    for(int y = 0; y < themeDemoButtons.size(); y++){
            themeDemoButtons.get(y).setBackground(monkeyPanel.randomColor(monkeyPanel.theme)); 
        }
   
    for(int y = 0; y < sliders.size(); y++){
            sliders.get(y).setBackground(monkeyPanel.randomColor(monkeyPanel.theme)); 
        }
    
    
}    
    
    
}  // end class
