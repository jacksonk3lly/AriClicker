import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class AriClicker{

   static JPanel upgradePanel=new JPanel();
   static JPanel upgradePanel2=new JPanel();

   static JPanel millypanel=new JPanel();
   static JPanel millypanel2=new JPanel();

   static JFrame window = new JFrame("Ari Clicker");

   static double count=0,aps;
   static int apc=1;
   static JLabel countLabel,apsLabel,apcLabel,unlockLabel;
   static Font font1,font2, font3;
   static Timer timer;
   static int ariPicCount=0;
   
   static int MCost=1000000;
   static int MCost2=5000000;

   static int cost6=100000;
   static int cost5=1000;
   static int cost4=15;
   static int cost3=10000;
   static int cost2=1000;
   static int cost1=15;
   
   static int arisUnlocked=0;
   static int unlockPrice=10;
   
      
   

   public static void main(String[]Args){
   
      createFont();
      
   
      createUi();
      
      setTimer();
   
      
      
      
   }
   
   public static void setTimer(){
   
      timer=new Timer();
   
      TimerTask task=
         new TimerTask(){
         
            public void run(){
            
               count+=(aps/100);
               countLabel.setText(Math.round(count)+" Aris");
               
               if(count>=1000000){
               
               
                  upgradePanel.setVisible(false);
               
                  millypanel.setVisible(true);
                  
                  
                  upgradePanel2.setVisible(false);
               
                  millypanel2.setVisible(true);

               
               }
            
            }
         
         };
         
         
      timer.scheduleAtFixedRate(task,0,10);
     
   }
   
   public static void createFont(){
      font1= new Font("Cascadia Code",Font.BOLD,25);
      font2= new Font("Cascadia Code",Font.PLAIN,13);
      font3= new Font("Cascadia Code",Font.PLAIN,9);
   
   }
   
   
   
   

   public static void createUi(){
   
   
      
   
      window.setSize(350,600);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.getContentPane().setBackground(Color.black);
      window.setLayout(null);
      window.setLocation(1060,0);
   
      JPanel ariPanel=new JPanel();
      ariPanel.setBounds(45,35,260,260);
      ariPanel.setBackground(Color.black);
      window.add(ariPanel);
   
      ImageIcon ari0 = new ImageIcon("Aripic0.jpg");
      ImageIcon ari1 = new ImageIcon("Aripic1.jpg");
      ImageIcon ari2 = new ImageIcon("Aripic2.jpg");
      ImageIcon ari3 = new ImageIcon("Aripic3.jpg");
      ImageIcon ari4 = new ImageIcon("Aripic4.jpg");
      ImageIcon ari5 = new ImageIcon("Aripic5.jpg");
      ImageIcon ari6 = new ImageIcon("Aripic6.jpg");
      ImageIcon ari7 = new ImageIcon("Aripic7.jpg");
      ImageIcon ari8 = new ImageIcon("Aripic8.jpg");
      ImageIcon ari9 = new ImageIcon("Aripic9.jpg");
      ImageIcon ari10 = new ImageIcon("Aripic10.jpg");

      
      JButton unlock = new JButton("Unlock new Ari $"+unlockPrice);
      unlock.setBounds(10, 510, 335, 40);
   
      window.add(unlock);
      unlock.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent b){  
               if(count>=unlockPrice){
                  
                  count=count-unlockPrice;
                  unlockPrice*=10;
                  arisUnlocked++;
                  unlock.setText("Unlock new Ari $"+unlockPrice);
                  unlockLabel.setText((arisUnlocked+1)+"/11"+" unique Aris unlocked");

               }
                     
            }  
         });  
   
      
   
   
   
      JButton ariButton=new JButton();
      ariButton.setIcon(ari0);
      ariButton.setBorder(null);
      ariButton.setBackground(Color.black);
      ariButton.setBorderPainted(false);
      ariButton.setContentAreaFilled(false);
   
      ariPanel.add(ariButton);
      ariButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               count=count+apc; 
            
               countLabel.setText(Math.round(count)+" Aris");
               
               ariPicCount++;
               
               if(ariPicCount>arisUnlocked){
                  ariPicCount=0;
               }
            
                           
               switch (ariPicCount) {
                  case 0:
                     ariButton.setIcon(ari0);
                     break;
                  case 2:
                     ariButton.setIcon(ari1);
                     break;
                  case 1:
                     ariButton.setIcon(ari2);
                     break;
                  case 3:
                     ariButton.setIcon(ari3);
                     break;
                  case 4:
                     ariButton.setIcon(ari4);
                     break;
                  case 5:
                     ariButton.setIcon(ari5);
                     break;
                  case 6:
                     ariButton.setIcon(ari6);
                     break;
                  case 7:
                     ariButton.setIcon(ari7);
                     break;
                  case 8:
                     ariButton.setIcon(ari8);
                     break;
                     
                      case 9:
                     ariButton.setIcon(ari9);
                     break;
                     case 10:
                     ariButton.setIcon(ari10);
                     break;
                   

               }
                           
               if(ariPicCount>arisUnlocked){
                  ariPicCount=-1;
               
               
                          
               }
               
            }  
         });   
      
   
      JPanel countPanel = new JPanel();
      countPanel.setBounds(70,315,300,85);
      countPanel.setBackground(Color.black);
      countPanel.setLayout(new GridLayout(4,1));
      
      countLabel=new JLabel(Math.round(count)+" Aris");
      countLabel.setForeground(Color.green);
      countLabel.setFont(font1);
      
      apsLabel=new JLabel(aps+" Aris per second");
      apsLabel.setForeground(Color.green);
      apsLabel.setFont(font2);
      
      apcLabel=new JLabel(apc+" Aris per click");
      apcLabel.setForeground(Color.green);
      apcLabel.setFont(font2);
      
      unlockLabel=new JLabel((arisUnlocked+1)+" unique Ari unlocked");
      unlockLabel.setForeground(Color.green);
      unlockLabel.setFont(font2);
   

   
   
      
      countPanel.add(countLabel);
      countPanel.add(apsLabel);
      countPanel.add(apcLabel);
      countPanel.add(unlockLabel);
      
   
   
      window.add(countPanel);
      
      millypanel.setVisible(false);
   
      millypanel.setBounds(10,405,335,45);
      millypanel.setBackground(Color.black);
      window.add(millypanel);
   
      JButton upgrademilly=new JButton("+50k Ari/s  $"+MCost);
      millypanel.add(upgrademilly);
      upgrademilly.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent b){  
               if(count>=MCost){
                  count=count-MCost;
                  countLabel.setText(Math. round(count)+" Aris");
                  aps+=1000000;
                  apsLabel.setText(aps+" Aris per second");
                  MCost*=1.5;
                  upgrademilly.setText("+1 Ari/s  $"+MCost);
               }
                     
            }  
         });   
         
         
         
         
         
     millypanel2.setVisible(false);
   
      millypanel2.setBounds(10,455,335,45);
      millypanel2.setBackground(Color.black);
      window.add(millypanel2);
   
      JButton upgrademilly2=new JButton("+50 Ari/c $"+(MCost2)+"k");
      millypanel2.add(upgrademilly2);
      upgrademilly2.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent b){  
               if(count>=MCost2){
                  count=count-MCost2;
                  countLabel.setText(Math. round(count)+" Aris");
                  apc+=50000;
                  apcLabel.setText(apc+" Aris per click");
                  MCost2*=1.5;
                  upgrademilly2.setText("+50 Ari/c $"+(MCost2)+"k");
               }
                     
            }  
         });   

   
         
      
      upgradePanel.setVisible(true);
   
      upgradePanel.setBounds(10,405,335,45);
      upgradePanel.setBackground(Color.black);
      upgradePanel.setLayout(new GridLayout(1,4));
      window.add(upgradePanel);
   
      
      JButton upgrade1=new JButton("+1 Ari/s  $"+cost1);
      upgrade1.setFont(font3);
      upgradePanel.add(upgrade1);
      upgrade1.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent b){  
               if(count>=cost1){
                  count=count-cost1;
                  countLabel.setText(Math. round(count)+" Aris");
                  aps+=1;
                  apsLabel.setText(aps+" Aris per second");
                  cost1*=1.8;
                  upgrade1.setText("+1 Ari/s  $"+cost1);
               }
                     
            }  
         });   
         
         
      JButton upgrade2=new JButton("+25 Ari/s  $"+cost2);
      upgrade2.setFont(font3);
   
      upgradePanel.add(upgrade2);
      upgrade2.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent b){  
               if(count>=cost2){
                  count=count-cost2;
                  countLabel.setText(Math. round(count)+" Aris");
                  aps+=25;
                  apsLabel.setText(aps+" Aris per second");
                  cost2*=1.8;
                  upgrade2.setText("+25 Ari/s  $"+cost2);
               }
                     
            }  
         });   
   
      JButton upgrade3=new JButton("+500 Ari/s  $"+(cost3/1000)+"k");
      upgrade3.setFont(font3);
   
      upgradePanel.add(upgrade3);
      upgrade3.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent b){  
               if(count>=cost3){
                  count=count-cost3;
                  countLabel.setText(Math. round(count)+" Aris");
                  aps+=500;
                  apsLabel.setText(aps+" Aris per second");
                  cost3*=1.6;
                  upgrade3.setText("+500 Ari/s  $"+(cost3/1000)+"k");
               }
                     
            }  
         });   
   
   
              
         
         
         
      upgradePanel2=new JPanel();
      upgradePanel2.setBounds(10,455,335,45);
      upgradePanel2.setBackground(Color.black);
      upgradePanel2.setLayout(new GridLayout(1,4));
      window.add(upgradePanel2);
   
      JButton upgrade4=new JButton("+1 Ari/c  $"+cost4);
      upgrade4.setFont(font3);
      upgradePanel2.add(upgrade4);
      upgrade4.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent b){  
               if(count>=cost4){
                  count=count-cost4;
                  countLabel.setText(Math. round(count)+" Aris");
                  apc+=1;
                  apcLabel.setText(apc+" Aris per click");
                  cost4*=2.5;
                  upgrade4.setText("+1 Ari/c  $"+cost4);
               }
                     
            }  
         });  
         
   
      JButton upgrade5=new JButton("+15 Ari/c  $"+cost5);
      upgrade5.setFont(font3);
   
      upgradePanel2.add(upgrade5);
      upgrade5.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent b){  
               if(count>=cost5){
                  count=count-cost5;
                  countLabel.setText(Math. round(count)+" Aris");
                  apc+=15;
                  apcLabel.setText(apc+" Aris per click");
                  cost5*=1.7;
                  upgrade5.setText("+20 Ari/c $"+cost5);
               }
                     
            }  
         });  
   
      
      
      JButton upgrade6=new JButton("+300 Ari/c $"+(cost6/1000)+"k");
      upgrade6.setFont(font3);   
      upgradePanel2.add(upgrade6);
      upgrade6.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent b){  
               if(count>=cost6){
                  count=count-cost6;
                  countLabel.setText(Math. round(count)+" Aris");
                  apc+=300;
                  apcLabel.setText(apc+" Aris per click");
                  cost6*=1.35;
                  upgrade6.setText("+300 Ari/c $"+(cost6/1000)+"k");
               }
                     
            }  
         });  
   
   
         
    
   
      window.setVisible(true);
   
   }


}
