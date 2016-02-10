/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

import java.awt.GridLayout;
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
    
    JLabel labelOfMerchants;
    JLabel labelOfTownsPeople;
    JLabel labelOfTransactions;
    
    
    MonkeyPanel monkeyPanel;
    
    public SliderPanel(MonkeyPanel mp){
        
        super();
        monkeyPanel = mp;
        setLayout(new GridLayout(6, 1));
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
    }

        
        
        
        
    private void createPanel() {
        
    sliderOfMerchants = new JSlider();
    sliderOfTownsPeople = new JSlider();
    sliderOfTransactions = new JSlider();
    
    sliderOfMerchants.addChangeListener(this);
    sliderOfTownsPeople.addChangeListener(this);
    sliderOfTransactions.addChangeListener(this);
    
    labelOfMerchants = new JLabel("<html><h2><font color='black'>Merchants: </font><font color='red'></font><h2></html>");
    labelOfTownsPeople = new JLabel("<html><h2><font color='black'>Townspeople: </font><font color='red'></font><h2></html>");
    labelOfTransactions = new JLabel("<html><h2><font color='black'>Transactions: </font><font color='red'></font><h2></html>");
        
      
      add(labelOfMerchants);
      add(sliderOfMerchants);
      add(labelOfTownsPeople);
      add(sliderOfTownsPeople);
      add(labelOfTransactions);
      add(sliderOfTransactions);
        
        
        
    } // end create panel
 
    
    
    
    
    
    
}  // end class
