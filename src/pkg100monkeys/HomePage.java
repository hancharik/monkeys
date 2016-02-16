/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg100monkeys;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
public class HomePage extends JPanel implements ActionListener{
    
    JTextArea readarea;
    JScrollPane readscroll;
    
    JTextArea writearea;
    
    JButton pic;
    JButton submitButton;
    JButton exitButton;
    JButton newButton;
    JLabel nametag;
    
    ArrayList<MonkeyMerchant> merchantButtons;
    
    
    
    
    public HomePage(){
        
        super();
        
        setLayout(null);
        
        initComponents();
        
        System.out.println(getDurationBreakdown(System.currentTimeMillis()));
        
        
    }// end constructor
    
    //scroll.setBounds(scrollx,6,640,420);
    private void initComponents(){
      
        pic = new JButton("pic");
        pic.setBounds(12,40, 110,120);
        String picname = "images/tf5.jpg"; 
        ImageIcon monkeyPic = new ImageIcon(picname);
        pic.setIcon(monkeyPic);
        add(pic);
        
        
        nametag = new JLabel("nametag");
        nametag.setBounds(40,168, 110,40);
        add(nametag);
        
        
        
            
       ///////////////////////////////////////////////////////  
    ///////////////////////////////////////////////////////
    ///////// this is a group
    
     
        readarea = new JTextArea();
        readarea.setBackground(Color.green);
    readscroll = new JScrollPane (readarea, 
   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    readscroll.setBounds(140, 40, 322,200);
    add(readscroll);
    
       ///////// this is a group
       ///////////////////////////////////////////////////////
 /////////////////////////////////////////////////////// 
   
         writearea = new JTextArea();
        writearea.setBackground(Color.red);
        writearea.setBounds(140, 260, 322,200);
        writearea.setEditable(true);
        add(writearea);
        
        
        
     submitButton = new JButton("submit");
    submitButton.setBounds(240,476,120,40);
    submitButton.setBackground(Color.ORANGE);//.setBackground(randomColor(theme));
    //pageButton.setVisible(false);
    submitButton.addActionListener(this);
    add(submitButton);
    exitButton = new JButton("exit");
    exitButton.setBounds(12,476,110,40);
    exitButton.setBackground(Color.yellow);//.setBackground(randomColor(theme));
    //pageButton.setVisible(false);
   //pageButton.addActionListener(this);
    add(exitButton);
        
     newButton = new JButton("new");
    newButton.setBounds(12,220,110,40);
    newButton.setBackground(Color.MAGENTA);//.setBackground(randomColor(theme));
    //pageButton.setVisible(false);
   //pageButton.addActionListener(this);
    add(newButton);    
        
        
        
        
        
        
        
        
        
        
    }  // end inint components
    
    
  
        @Override
         public void actionPerformed(ActionEvent event){

       	Object obj = event.getSource();
       
    
        
        
                if (obj == submitButton){
                    nametag.setText(millisToDate(System.currentTimeMillis()));
                   
                    writearea.append("\n"+properDate());
                }
     
         
         }
         
         
         private String properDate(){
             
             // http://www.xyzws.com/javafaq/how-to-use-simpledateformat-class-formating-parsing-date-and-time/142
             
              Date now = new Date();
        String datetimeStr = now.toString();
        System.out.println("1. " + datetimeStr);
        SimpleDateFormat format = new SimpleDateFormat(
                    "HH:mm:ss.SSSS EEE MMM dd");
        System.out.println("2. " + format.format(now));
            String result = format.format(now);
            return result;
             
             
         }
         
         
         
         
         
         
         
         
         
         
   private String millisToDate(long millis){

    return DateFormat.getDateInstance(DateFormat.FULL).format(millis);
    //You can use DateFormat.LONG instead of SHORT

} 
   
     public static String getDurationBreakdown(long millis)
    {
        if(millis < 0)
        {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        sb.append(days);
        sb.append(" Days ");
        sb.append(hours);
        sb.append(" Hours ");
        sb.append(minutes);
        sb.append(" Minutes ");
        sb.append(seconds);
        sb.append(" Seconds");

        return(sb.toString());
    }  
   
   
   
   
   
   
   
   
   
   
   
   
   
} // end class
