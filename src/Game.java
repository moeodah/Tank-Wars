import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.sound.sampled.*;
import java.io.File;  // Import the File class

public class Game extends JFrame {
    private Image img = Toolkit.getDefaultToolkit().getImage("Images/GameBackground.png");
    private String team1;
    private String team2;
    private String team3;
    private String team4;
    private static int team1score = 7;
    private static int team2score = 7;
    private static int team3score = 7;
    private static int team4score = 7;
    private static boolean [] protect = {false,false,false,false};
    static List<JButton> kList = new ArrayList<JButton>();
    static List<JButton> rList = new ArrayList<JButton>();
    static List<JButton> nList = new ArrayList<JButton>();
    static List<JButton> sList = new ArrayList<JButton>();
    int turn = 1;
    public Game(){
        this.team1 = "Team 1";
        this.team2 = "Team 2";
        this.team3 = "Team 3";
        this.team4 = "Team 4";
        addComponants(team1,team2,team3,team4);
    }
    public Game(String team1,String team2,String team3,String team4){
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
        this.team4 = team4;
        addComponants(team1,team2,team3,team4);

    }

    public void addComponants(String team1,String team2,String team3,String team4){
        Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());

        this.setContentPane(new JPanel() {

            // Setting the Background Image for the JFrame
            @Override
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
         });
        //------------------- Adding the componants -------------------//
        //----Tanks----//
        // Team 1 Panel
        ArrayList<JPanel> panels = new ArrayList<JPanel>();
        JPanel team1Panel = new JPanel();
        setLayout(null);
        team1Panel.setBounds(10,100,1000,75);
        team1Panel.setOpaque(true);
        this.add(team1Panel);
        panels.add(team1Panel);
        // Team 2 Panel
        JPanel team2Panel = new JPanel();
        setLayout(null);
        team2Panel.setBounds(10,225,1000,75);
        team2Panel.setOpaque(true);
        this.add(team2Panel);
        panels.add(team2Panel);
        // Team 1 Panel
        JPanel team3Panel = new JPanel();
        setLayout(null);
        team3Panel.setBounds(10,350,1000,75);
        team3Panel.setOpaque(true);
        this.add(team3Panel);
        panels.add(team3Panel);
        // Team 1 Panel
        JPanel team4Panel = new JPanel();
        setLayout(null);
        team4Panel.setBounds(10,475,1000,75);
        team4Panel.setOpaque(true);
        this.add(team4Panel);
        panels.add(team4Panel);
        //----Strike Buttons----//
        rList = new ArrayList<JButton>();
        kList = new ArrayList<JButton>();
        nList = new ArrayList<JButton>();
        sList = new ArrayList<JButton>();
        ImageIcon rocketIcon = new ImageIcon("Images/Rocket.png");
        ImageIcon shieldIcon = new ImageIcon("Images/shield.png");
        ImageIcon nukeIcon = new ImageIcon("Images/nuke.png");
        ImageIcon killTankIcon = new ImageIcon("Images/kill Tank.png");
        //--Team1--//
        JButton rocketTeam1 = new JButton();
        rocketTeam1.setBounds(1030,100,75,75);
        rocketTeam1.setIcon(rocketIcon);
        this.add(rocketTeam1);
        rList.add(rocketTeam1);
        JButton shieldTeam1 = new JButton();
        shieldTeam1.setBounds(1135,100,75,75);
        shieldTeam1.setIcon(shieldIcon);
        sList.add(shieldTeam1);
        this.add(shieldTeam1);
        JButton nuclearTeam1 = new JButton();
        nuclearTeam1.setBounds(1240,100,75,75);
        nuclearTeam1.setIcon(nukeIcon);
        nList.add(nuclearTeam1);
        this.add(nuclearTeam1);
        JButton killTeam1 = new JButton();
        killTeam1.setBounds(1345,100,75,75);
        killTeam1.setIcon(killTankIcon);
        this.add(killTeam1);
        kList.add(killTeam1);
        //--Team2--//
        JButton rocketTeam2 = new JButton();
        rocketTeam2.setBounds(1030,225,75,75);
        rocketTeam2.setIcon(rocketIcon);
        this.add(rocketTeam2);
        rList.add(rocketTeam2);
        JButton shieldTeam2 = new JButton();
        shieldTeam2.setBounds(1135,225,75,75);
        shieldTeam2.setIcon(shieldIcon);
        sList.add(shieldTeam2);
        this.add(shieldTeam2);
        JButton nuclearTeam2 = new JButton();
        nuclearTeam2.setBounds(1240,225,75,75);
        nuclearTeam2.setIcon(nukeIcon);
        nList.add(nuclearTeam2);
        this.add(nuclearTeam2);
        JButton killTeam2 = new JButton();
        killTeam2.setBounds(1345,225,75,75);
        killTeam2.setIcon(killTankIcon);
        this.add(killTeam2);
        kList.add(killTeam2);
        //--Team3--//
        JButton rocketTeam3 = new JButton();
        rocketTeam3.setIcon(rocketIcon);
        rocketTeam3.setBounds(1030,350,75,75);
        this.add(rocketTeam3);
        rList.add(rocketTeam3);
        JButton shieldTeam3 = new JButton();
        shieldTeam3.setBounds(1135,350,75,75);
        shieldTeam3.setIcon(shieldIcon);
        sList.add(shieldTeam3);
        this.add(shieldTeam3);
        JButton nuclearTeam3 = new JButton();
        nuclearTeam3.setBounds(1240,350,75,75   );
        nuclearTeam3.setIcon(nukeIcon);
        nList.add(nuclearTeam3);
        this.add(nuclearTeam3);
        JButton killTeam3 = new JButton();
        killTeam3.setBounds(1345,350,75,75);
        killTeam3.setIcon(killTankIcon);
        this.add(killTeam3);
        kList.add(killTeam3);
        //--Team4--//
        JButton rocketTeam4 = new JButton();
        rocketTeam4.setIcon(rocketIcon);
        rocketTeam4.setBounds(1030,475,75,75);
        this.add(rocketTeam4);
        rList.add(rocketTeam4);
        JButton shieldTeam4 = new JButton();
        shieldTeam4.setBounds(1135,475,75,75);
        shieldTeam4.setIcon(shieldIcon);
        sList.add(shieldTeam4);
        this.add(shieldTeam4);
        JButton nuclearTeam4 = new JButton();
        nuclearTeam4.setBounds(1230,475,75,75);
        nuclearTeam4.setIcon(nukeIcon);
        nList.add(nuclearTeam4);
        this.add(nuclearTeam4);
        JButton killTeam4 = new JButton();
        killTeam4.setBounds(1345,475,75,75);
        killTeam4.setIcon(killTankIcon);
        this.add(killTeam4);
        kList.add(killTeam4);

        //----Team Names----//
        //--team1--//
        JLabel team1label = new JLabel(team1);
        team1label.setFont(new Font("Lucida Grande", 0, 36));
        team1label.setBounds(10,52,300,36);
        this.add(team1label);
        //--team2--//
        JLabel team2label = new JLabel(team2);
        team2label.setFont(new Font("Lucida Grande", 0, 36));
        team2label.setBounds(10,182,300,36);
        this.add(team2label);
        //--team1--//
        JLabel team3label = new JLabel(team3);
        team3label.setFont(new Font("Lucida Grande", 0, 36));
        team3label.setBounds(10,307,300,36);
        this.add(team3label);
        //--team1--//
        JLabel team4label = new JLabel(team4);
        team4label.setFont(new Font("Lucida Grande", 0, 36));
        team4label.setBounds(10,432,300,36);
        this.add(team4label);
        
        //---- Adding Tanks ----//
        ImageIcon tankIcon = new ImageIcon("Images/Tank.png");
        List<List<JLabel>> tt = new ArrayList<List<JLabel>>();
        List<JLabel> team1Tanks = new ArrayList<>();
        tt.add(team1Tanks);
        ArrayList<JLabel> team2Tanks = new ArrayList<>();
        tt.add(team2Tanks); 
        ArrayList<JLabel> team3Tanks = new ArrayList<>();
        tt.add(team3Tanks);
        ArrayList<JLabel> team4Tanks = new ArrayList<>();
        tt.add(team4Tanks);
        populateTanks(tt);

        //---- populating the Tanks Panels ----//
        // }
        populate(panels, tt);




        //-----Choose Team and Play Again Buttons -----//
        JButton chooseTeams = new JButton("Choose Teams");
        chooseTeams.setBounds((screenSize.width/4)-100, 600, 200, 75);
        this.add(chooseTeams);
        chooseTeams.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            newGame();

           }
        });
        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds((screenSize.width/4 + screenSize.width/ 2) -100, 600, 200, 75);
        this.add(playAgain);
        playAgain.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            // display/center the jdialog when the button is pressed
            newGameSameTeam(team1,team2,team3,team4);

           }
        });
        //ImageIcon boom = new ImageIcon("Images/expo.gif");
        //---- Play Game ----//        
        //----Tank kill ----//
            for(int i = 0; i < 4 ; i++){
                kills(kList.get(i),panels.get(i),tt.get(i),i+1);
                shield(sList.get(i),panels.get(i),tt.get(i),i);
            }
        //----Rocket----//
        for (int i = 0 ; i < 4 ; i ++){
            switch (i){
                case 0 : {
                    String [] teamChoice = {team2,team3,team4};
                    List<JPanel> enemyPanels = new ArrayList<JPanel>();
                    enemyPanels.add(team2Panel);
                    enemyPanels.add(team3Panel);
                    enemyPanels.add(team4Panel);
                    List<List<JLabel>> enemyTanks = new ArrayList<List<JLabel>>();
                    enemyTanks.add(team2Tanks);
                    enemyTanks.add(team3Tanks);
                    enemyTanks.add(team4Tanks);
                    rockets(rList.get(i), enemyPanels, enemyTanks, i+1,teamChoice);
                    nuclear(nList.get(i), enemyPanels, enemyTanks, i+1,teamChoice);   
                }break;
                case 1 : {
                    String [] teamChoice = {team1,team3,team4};
                    List<JPanel> enemyPanels = new ArrayList<JPanel>();
                    enemyPanels.add(team1Panel);
                    enemyPanels.add(team3Panel);
                    enemyPanels.add(team4Panel);
                    List<List<JLabel>> enemyTanks = new ArrayList<List<JLabel>>();
                    enemyTanks.add(team1Tanks);
                    enemyTanks.add(team3Tanks);
                    enemyTanks.add(team4Tanks);
                    rockets(rList.get(i), enemyPanels, enemyTanks, i+1,teamChoice);   
                    nuclear(nList.get(i), enemyPanels, enemyTanks, i+1,teamChoice);   
                }break;
                case 2 : {
                    String [] teamChoice = {team1,team2,team4};
                    List<JPanel> enemyPanels = new ArrayList<JPanel>();
                    enemyPanels.add(team1Panel);
                    enemyPanels.add(team2Panel);
                    enemyPanels.add(team4Panel);
                    List<List<JLabel>> enemyTanks = new ArrayList<List<JLabel>>();
                    enemyTanks.add(team1Tanks);
                    enemyTanks.add(team2Tanks);
                    enemyTanks.add(team4Tanks);
                    rockets(rList.get(i), enemyPanels, enemyTanks, i+1,teamChoice);   
                    nuclear(nList.get(i), enemyPanels, enemyTanks, i+1,teamChoice);   
                }break;
                case 3 : {
                    String [] teamChoice = {team1,team2,team3};
                    List<JPanel> enemyPanels = new ArrayList<JPanel>();
                    enemyPanels.add(team1Panel);
                    enemyPanels.add(team2Panel);
                    enemyPanels.add(team3Panel);
                    List<List<JLabel>> enemyTanks = new ArrayList<List<JLabel>>();
                    enemyTanks.add(team1Tanks);
                    enemyTanks.add(team2Tanks);
                    enemyTanks.add(team3Tanks);
                    rockets(rList.get(i), enemyPanels, enemyTanks, i+1,teamChoice);   
                    nuclear(nList.get(i), enemyPanels, enemyTanks, i+1,teamChoice);        
                }
            }
        }        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
public void updateScore(int x){
    switch (x){
        case 1:team1score--;break;
        case 2:team2score--;break;
        case 3:team3score--;break;
        case 4:team4score--;break;
        default:break;
    }
    if ((team1score+team2score+team3score+team4score)==1){
        if(team1score>0){
            JOptionPane.showMessageDialog(this, "the winner is "+ team1);

        }else if(team1score>0){
            JOptionPane.showMessageDialog(this, "the winner is "+ team2);
        }else if(team1score>0){
            JOptionPane.showMessageDialog(this, "the winner is "+ team3);
        }else {
            JOptionPane.showMessageDialog(this, "the winner is "+ team4);
        }
    }

}
public void populate(List<JPanel> p , List<List<JLabel>> l){
    for(int i = 0 ; i < 4 ; i++){
        for(int j = 0; j < 7 ; j++){
            p.get(i).add(l.get(i).get(j));
            }
        }
}
public void populateTanks(List<List<JLabel>> l){
    ImageIcon tankIcon = new ImageIcon("Images/Tank.png");
    for (int i = 0 ; i < 4 ; i ++ ){
        for (int j = 0;j<7;j++){
            // l.add(new JLabel(tankIcon));
            l.get(i).add(new JLabel(tankIcon));
        }
    }
}
public void newGame(){
    this.dispose();    //this.setVisible(false);
    TankFrame mainFrame = new TankFrame();
    mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    mainFrame.setVisible(true);
}

public void newGameSameTeam(String team1,String team2,String team3,String team4){
    this.dispose();
    this.setVisible(false);
    Game game = new Game(team1,team2,team3,team4);
    game.setExtendedState(JFrame.MAXIMIZED_BOTH);
    game.setVisible(true);

}

public void kills(JButton k,JPanel p , List l,int score){
    k.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          play("sounds/boomsounds.wav");
        // display/center the jdialog when the button is pressed
        if (l.size()>0){
            //if (isProtected(score)){
        p.getComponent(l.size()-1).setVisible(false);
        l.remove(l.size()-1);
            //}
        }
        protect[score] = false;
        //undoshield(p);
        if (l.size()<= 0 ){
            killSwitch(score);
        }
       }
    });
   
    updateScore(score);
}

public void rockets(JButton k, List<JPanel> p , List<List<JLabel>> l,int score,String [] choice){
    k.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // display/center the jdialog when the button is pressed
        ImageIcon icon = new ImageIcon("Images/Rocket.png");
        int choices = JOptionPane.showOptionDialog(null, "Which team do you want to use Rocket on?", "Inane custom dialog",
        JOptionPane.WARNING_MESSAGE, 0, icon, choice, choice[2]);
        if (choices ==0 ){
            for(int i = 0;i < 2;i++){
            p.get(0).getComponent(l.get(0).size()-1).setVisible(false);
            l.get(0).remove(l.get(0).size()-1);
            }
        }
        if (choices ==1 ){
            for(int i = 0;i < 2;i++){
            p.get(1).getComponent(l.get(1).size()-1).setVisible(false);
            l.get(1).remove(l.get(1).size()-1);
            }
        }
        if (choices ==2 ){
            for(int i = 0;i < 2;i++){
            p.get(2).getComponent(l.get(2).size()-1).setVisible(false);
            l.get(2).remove(l.get(2).size()-1);
            }
        }
        if (l.size()<= 0 ){
            killSwitch(score);
        }
        k.setEnabled(false);
        }
    }); 
   

}
public void nuclear(JButton k, List<JPanel> p , List<List<JLabel>> l,int score,String [] choice){
    k.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        for(int i = 0 ; i < 3; i ++){
            if(l.get(i).size()>0){
            p.get(i).getComponent(l.get(i).size()-1).setVisible(false);
            l.get(i).remove(l.get(i).size()-1);
            }
        }
        if (l.size()<= 0 ){
            killSwitch(score);
        }
        k.setEnabled(false);
       }
       
    });
    
}
public void shield(JButton k,JPanel p, List l,int which){
k.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
    Border border = new LineBorder(Color.BLUE, 4, true);
    p.setBorder(border);
    protect[which]=true;
    if (l.size()<= 0 ){
        killSwitch(which+1);
    }
    k.setEnabled(false);
   }
});

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
public void undoshield(JPanel p){
    Border border = new LineBorder(null);
    p.setBorder(border);
}
public boolean isProtected(int x){
    return protect[x];
}
public void killSwitch(int x){
    kList.get(x-1).setEnabled(false);
    rList.get(x-1).setEnabled(false);
    nList.get(x-1).setEnabled(false);
    sList.get(x-1).setEnabled(false);
}
public static void playGame(){
    int game = 28;
    while (game > 0){

    }
}
public void run(){
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setVisible(true);
}
}
