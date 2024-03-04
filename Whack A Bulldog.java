
package whackabulldog_sourceonly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class WhackaBulldog_SourceOnly extends JFrame{

    private JPanel panel;
    private JLabel[] holes = new JLabel[16];
    private int[] board = new int[16];

    private int score = 0;
    private int timeLeft = 30;
    private int highscore = 0;

    private JLabel lblScore;
    private JLabel lblTimeLeft;
    private JLabel lblHighscore;

    private JButton btnStart;
    private Timer timer;

    private void gameOver(){
        btnStart.setEnabled(true);
        if(score > highscore){
            highscore = score;
            lblHighscore.setText("Highscore: " + highscore);
            JOptionPane.showMessageDialog(this, "Your final score is: " + score, "You beat the high score!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Your final score is: " + score, "Game Over!", JOptionPane.INFORMATION_MESSAGE);
        }
        score = 0;
        timeLeft = 30;
        lblScore.setText("Score: 0");
        lblTimeLeft.setText("30");

        clearBoard();
    }

    private void pressedButton(int id){
        int val = board[id];

        //if val is 1 = mole
        //if val is 0 = empty hole
        if(val==1){ 
            score++;
        }else{ //val==0
            score--;
        }

        lblScore.setText("Score: " + score); //update the score

        clearBoard();

        genRandMole();
    }

    private void initEvents(){
        for(int i = 0; i < holes.length; i++){
            holes[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    JLabel lbl = (JLabel)e.getSource();
                    int id = Integer.parseInt(lbl.getName());
                    pressedButton(id);
                }
            });
        }

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnStart.setEnabled(false);
                clearBoard();
                genRandMole();
                timer.start();
            }
        });

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(timeLeft == 0){
                    lblTimeLeft.setText("" + timeLeft);
                    timer.stop();
                    gameOver();
                }
                lblTimeLeft.setText("" + timeLeft);
                timeLeft--;
            }
        });
    }

    private void initGUI(){
        setTitle("Whack A Bulldog");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 608, 720);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 139)); // Setting dark blue color
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Whack A Bulldog");
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Consolas", Font.BOLD, 24));
        lblTitle.setBounds(0, 0, 602, 47);
        contentPane.add(lblTitle);

        panel = new JPanel();
        panel.setBackground(new Color(255, 215, 0)); // Setting golden yellow color
        panel.setBounds(32, 105, 535, 546);
        panel.setLayout(null);
        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                loadImage("/hammer.png").getImage(),
                new Point(0,0),"custom cursor1"));
        contentPane.add(panel);

        holes[0] = new JLabel("0");
        holes[0].setName("0");
        holes[0].setBounds(0, 396, 132, 132);
        panel.add(holes[0]);

        holes[1] = new JLabel("1");
        holes[1].setName("1");
        holes[1].setBounds(132, 396, 132, 132);
        panel.add(holes[1]);

        holes[2] = new JLabel("2");
        holes[2].setName("2");
        holes[2].setBounds(264, 396, 132, 132);
        panel.add(holes[2]);

        holes[3] = new JLabel("3");
        holes[3].setName("3");
        holes[3].setBounds(396, 396, 132, 132);
        panel.add(holes[3]);

        holes[4] = new JLabel("4");
        holes[4].setName("4");
        holes[4].setBounds(0, 264, 132, 132);
        panel.add(holes[4]);

        holes[5] = new JLabel("5");
        holes[5].setName("5");
        holes[5].setBounds(132, 264, 132, 132);
        panel.add(holes[5]);

        holes[6] = new JLabel("6");
        holes[6].setName("6");
        holes[6].setBounds(264, 264, 132, 132);
        panel.add(holes[6]);

        holes[7] = new JLabel("7");
        holes[7].setName("7");
        holes[7].setBounds(396, 264, 132, 132);
        panel.add(holes[7]);

        holes[8] = new JLabel("8");
        holes[8].setName("8");
        holes[8].setBounds(0, 132, 132, 132);
        panel.add(holes[8]);

        holes[9] = new JLabel("9");
        holes[9].setName("9");
        holes[9].setBounds(132, 132, 132, 132);
        panel.add(holes[9]);

        holes[10] = new JLabel("10");
        holes[10].setName("10");
        holes[10].setBounds(264, 132, 132, 132);
        panel.add(holes[10]);

        holes[11] = new JLabel("11");
        holes[11].setName("11");
        holes[11].setBounds(396, 132, 132, 132);
        panel.add(holes[11]);

        holes[12] = new JLabel("12");
        holes[12].setName("12");
        holes[12].setBounds(0, 0, 132, 132);
        panel.add(holes[12]);

        holes[13] = new JLabel("13");
        holes[13].setName("13");
        holes[13].setBounds(132, 0, 132, 132);
        panel.add(holes[13]);

        holes[14] = new JLabel("14");
        holes[14].setName("14");
        holes[14].setBounds(264, 0, 132, 132);
        panel.add(holes[14]);

        holes[15] = new JLabel("15");
        holes[15].setName("15");
        holes[15].setBounds(396, 0, 132, 132);
        panel.add(holes[15]);

        lblScore = new JLabel("Score: 0");
        lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblScore.setFont(new Font("Consolas", Font.BOLD, 18));
        lblScore.setForeground(new Color(255, 255, 255));
        lblScore.setBounds(423, 54, 144, 33);
        contentPane.add(lblScore);

        lblTimeLeft = new JLabel("30");
        lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeLeft.setForeground(new Color(255, 255, 255));
        lblTimeLeft.setFont(new Font("Consolas", Font.BOLD, 28));
        lblTimeLeft.setBounds(232, 54, 144, 33);
        contentPane.add(lblTimeLeft);

        lblHighscore = new JLabel("Highscore: 0");
        lblHighscore.setHorizontalAlignment(SwingConstants.TRAILING);
        lblHighscore.setForeground(new Color(255, 255, 255));
        lblHighscore.setFont(new Font("Consolas", Font.BOLD, 18));
        lblHighscore.setBounds(433, 18, 134, 33);
        contentPane.add(lblHighscore);

        btnStart = new JButton("Start");
        btnStart.setFont(new Font("Consolas", Font.PLAIN, 20)); // Set font size to 18
        btnStart.setBorderPainted(true); // Ensure button border is painted
        btnStart.setBackground(Color.WHITE); // Set background to null for classic style
        btnStart.setFocusPainted(false); // Remove the blue line around the button
        btnStart.setBounds(32, 60, 110, 33);
        contentPane.add(btnStart);

        setContentPane(contentPane);
    }

    private void clearBoard(){
        for(int i = 0; i < 16; i++){
            holes[i].setIcon(loadImage("/hole.png"));
            board[i] = 0;
        }
    }

    private void genRandMole(){
        Random rnd = new Random(System.currentTimeMillis()); //seeding random with current time
        int moleID = rnd.nextInt(16);
        board[moleID] = 1;
        holes[moleID].setIcon(loadImage("/bulldog.png"));
    }

    private ImageIcon loadImage(String path){
        Image image = new ImageIcon(this.getClass().getResource(path)).getImage();
        Image scaledImage = image.getScaledInstance(132, 132,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public WhackaBulldog_SourceOnly () {
        Image icon = new ImageIcon(this.getClass().getResource("/logoicon.png")).getImage();
        this.setIconImage(icon);
        initGUI();
        clearBoard();
        initEvents();
    }

    public static void main(String[] args) {
        WhackaBulldog_SourceOnly frame = new WhackaBulldog_SourceOnly();
        frame.setVisible(true);
    }
}
   
