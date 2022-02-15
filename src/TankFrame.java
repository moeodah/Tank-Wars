import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.sound.sampled.*;
import java.io.File;  // Import the File class


public class TankFrame extends JFrame {
    private Image img = Toolkit.getDefaultToolkit().getImage("Images/Background.jpg");
    private JLabel imgHolder;
    private ImageIcon bgIcon;
    
    public TankFrame(){
        addComponants();
        play("Sounds/Main Theme.wav");
        


    }

    public void addComponants(){

        this.setContentPane(new JPanel() {

            // Setting the Background Image for the JFrame
            @Override
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
         });
         //------------------- Adding the componants -------------------//
         Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
         setLayout(null);

         
         //  Game Label
         ImageIcon Logo = new ImageIcon("Images/Tank Wars-2.png");
         JLabel gLabel = new JLabel(Logo);
         gLabel.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
         gLabel.setForeground(Color.WHITE);
         gLabel.setBounds(screenSize.width/2-(593/2),screenSize.height/2 - 350,593,131);
         this.add(gLabel);
        
        //  //mosque icon
        //  ImageIcon rocketIcon = new ImageIcon("Images/Mosque.png");
        //  JLabel mLabel = new JLabel();
        //  mLabel.setBounds(10,-10,300,300);
        //  mLabel.setIcon(rocketIcon);
        //  this.add(mLabel);

         // Team Name Labels
         JLabel teamLabel1 = new JLabel("Team 1 Name");
         teamLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
         teamLabel1.setForeground(Color.WHITE);

         teamLabel1.setBounds(screenSize.width/4 - 125 ,screenSize.height/2 - 200,250,40);
         this.add(teamLabel1);

         JLabel teamLabel2 = new JLabel("Team 2 Name");
         teamLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
         teamLabel2.setForeground(Color.WHITE);

         teamLabel2.setBounds(screenSize.width/4 + screenSize.width/2- 125 ,screenSize.height/2 - 200,250,40);
         this.add(teamLabel2);

         JLabel teamLabel3 = new JLabel("Team 3 Name");
         teamLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
         teamLabel3.setForeground(Color.WHITE);

         teamLabel3.setBounds(screenSize.width/4 - 125 ,screenSize.height/2,250,40);
         this.add(teamLabel3);

         JLabel teamLabel4 = new JLabel("Team 4 Name");
         teamLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
         teamLabel4.setForeground(Color.WHITE);

         teamLabel4.setBounds(screenSize.width/4 + screenSize.width/2 - 125 ,screenSize.height/2,250,40);
         this.add(teamLabel4);

         // Team Name Text Fields 

         JTextField teamTF1 = new JTextField();
         teamTF1.setBounds(screenSize.width/4 - 125 ,screenSize.height/2 - 140,250,40);
         this.add(teamTF1);

         JTextField teamTF2 = new JTextField();
         teamTF2.setBounds(screenSize.width/4 + screenSize.width/2 - 125 ,screenSize.height/2 - 140,250,40);
         this.add(teamTF2);

         JTextField teamTF3 = new JTextField();
         teamTF3.setBounds(screenSize.width/4 - 125 ,screenSize.height/2 +60,250,40);
         this.add(teamTF3);

         JTextField teamTF4 = new JTextField();
         teamTF4.setBounds(screenSize.width/4 + screenSize.width/2 - 125 ,screenSize.height/2 +60,250,40);
         this.add(teamTF4);


         // Play Button
         JButton play = new JButton("Play");
         play.setBounds(screenSize.width/2 - 100,screenSize.height/2 + 150,200,40);
         this.add(play);
         play.addActionListener(new ActionListener()
         {
           public void actionPerformed(ActionEvent e)
           {
             // display/center the jdialog when the button is pressed
             newGame(e,teamTF1,teamTF2,teamTF3,teamTF4);
            }
         });
         // Rules
         JButton rules = new JButton("Rules");
         rules.setBounds(screenSize.width/2 - 100,screenSize.height/2 + 230,200,40);
         this.add(rules);
         rules.addActionListener(new ActionListener()
         {
           public void actionPerformed(ActionEvent e)
           {
             // display/center the jdialog when the button is pressed
             newGame(e,teamTF1,teamTF2,teamTF3,teamTF4);
            }
         });



         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

public void newGame(ActionEvent e,JTextField team1,JTextField team2,JTextField team3,JTextField team4){
    Game newG = new Game(team1.getText(),team2.getText(),team3.getText(),team4.getText());
    this.setVisible(false);
    newG.run();
}
public static void play(String filename)
{
  try
  {
    Clip clip = AudioSystem.getClip();
    clip.open(AudioSystem.getAudioInputStream(new File(filename)));
    clip.start();
  }
  catch (Exception exc)
  {
    exc.printStackTrace(System.out);
  }
}
public static void main (String [] args){
    TankFrame mainFrame = new TankFrame();
    mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //mainFrame.addComponants();



    mainFrame.setVisible(true);


}
}