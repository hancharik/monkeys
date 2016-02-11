/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Mark
 */
public class MonkeyFrame extends JFrame{
    
   // public GalaxyMapPanel galaxyPanel = new GalaxyMapPanel(21,21);
     public MonkeyPanel buttonPanel;// = new GameJPanel();
    // public MainPanel main = new MainPanel();
    private int bPanelSize;
    public MonkeyFrame(){
        super ("100 Monkeys");
        
        
                getContentPane().setLayout(new BorderLayout());
                //galaxyPanel = new GalaxyMapPanel(0,0);
                buttonPanel = new MonkeyPanel();
                //getContentPane().add(galaxyPanel,"Center");
                getContentPane().add(buttonPanel,"Center");
               //getContentPane().add(main,"Center");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (1366, 768);//setSize (1920, 1000);1366x768
		setVisible(true);
    }
    
}
