import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
                    
public class XOgame extends JFrame implements ActionListener{
    JTextField input_box1 = new JTextField(10);                              // player1 Name Input TextField
    JTextField input_box2 = new JTextField(10);                              // player2 Name Input TextField
    JLabel player_name1 = new JLabel("Player-1  Name");                         // player1 Name Label
    JLabel player_name2 = new JLabel("Player-2  Name");                         // player2 Name Label
    JButton play_button=new JButton("PLAY");                                    // Play button to start the play
    Font font1 = new Font("Comic Sans",Font.BOLD,25);
    Font font2 = new Font("Comic Sans",Font.BOLD,35);
    ImageIcon image = new ImageIcon("D:\\Projects\\image.jpg");            // For BackGround Image we use ImageIcon Class to set it in background1 and background2   
    XOgame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                              // To Exite on Close Button
        setLayout(null);                                                     // Set Layout Null
        setBounds(350,50,550,450);                                // Set Frame Position x,y,width,height
        setVisible(true);                                                          // Set visible True to view Frame 
        setResizable(false);                                               // Set Resizable False to OFF the Maximize the Frame
        setTitle("XO Game");                                                   // Set Title to XO Game

        JLabel background1 = new JLabel();                                            // We use background1 Label to Set Background 
        background1.setSize(550,450);                                   // Set Label Size
        background1.setLayout(new FlowLayout(1,20,73));             // Set Layout For background1 Label

        player_name1.setFont(font1);                                                  // Set Font1 to player Name1 Label 
        player_name1.setForeground(Color.WHITE);                                      // Set Font Color to White for player_name1
        player_name2.setFont(font1);                                                  // Set Font1 to player Name2 Label
        player_name2.setForeground(Color.WHITE);                                      // Set Font Color to White for player_name2
        input_box1.setFont(font1);                                                    // player1 Name Input TextField
        input_box2.setFont(font1);                                                    // player2 Name Input TextField
        play_button.setFont(font1);                                                   // Set Font to Play Button
        play_button.setBackground(Color.WHITE);                                       // Set Background to Play Button
        play_button.setForeground(Color.BLACK);                                       // Set Font Color to Play Button
        play_button.addActionListener(this);                                          // Add ActionListener to the Play Button

        background1.setIcon(image);                                                    // Set Image to background1 Label
        add(background1);                                                              // Add background1 to Frame (XOgame)
        background1.add(player_name1);                                                 // Add Player_name1 to Label (background1)
        background1.add(input_box1);                                                   // Add input_box1 to TextField (background1)
        background1.add(player_name2);                                                 // Add Player_name2 to Label (background1)
        background1.add(input_box2);                                                   // Add input_box2 to TextField (background1)
        background1.add(play_button);                                                  // Add play_button to Button (background1)
    }
    // ActionPeformed Function for play_button that Generate ActionEvent e
    public void actionPerformed(ActionEvent e){                                        
        if(e.getActionCommand()=="PLAY"){                                              // Get play_button Label
            setVisible(false);                                                       // Set XOgame Frame Visible False to Hide
            new Play();                                                                // Call Play Class Function
        }
    }
    class Play extends JFrame implements ActionListener{
        JButton buttons[] = new JButton[9];                                            // We Need 9 Buttons So we declare in Array button[]
        JButton replay = new JButton("Replay");                                   // Replay button used to Restart the Game   
        JPanel panel1= new JPanel(new GridLayout(3,3));                     // Set panel1 to GridLayout with 3X3 Matrix   
        String player1_alert = input_box1.getText();                                   // Holds Player1 Name from Frame(XOgame) input_box1
        String player2_alert = input_box2.getText();                                   // Holds Player2 Name from Frame(XOgame) input_box2
        String visited_button = "";                                                    // Holds Visited_button ActionCommand as String
        int space=9;                                                           
        String turn = ((int)(Math.random()*10)%2 == 0)? "X":"O";                       // Holds Player turn X/O Randomly initialize
        JLabel alert_label = new JLabel((turn=="X")?player1_alert+" Turn X" : player2_alert+" Turn O"); //Alert Players Turn with Message of respected to turn

        Play(){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                            // To Exite on Close Button
            setLayout(null);                                                  // Set Layout Null
            setBounds(400,50,450,500);                             // Set Frame Position x,y,width,height
            setVisible(true);                                                       // Set visible True to view Frame
            setResizable(false);                                            // Set Resizable False to OFF the Maximize the Frame
            setTitle("XO Game");                                                // Set Title to XO Game

            JLabel background2 = new JLabel();                                         // We use background1 Label to Set Background 
            background2.setSize(450,500);                                // Set Label Size

            alert_label.setFont(font1);                                                // Set Font to alert_label
            alert_label.setForeground(Color.RED);                                      // Set Font Color to alert_label
            alert_label.setBounds(0,0,450,70);                      // Set alert_label Position x,y,width,height
            alert_label.setHorizontalAlignment(JLabel.CENTER);                         // Set alert_label CENTER Horizontally respected to width
            alert_label.setVerticalAlignment(JLabel.CENTER);                           // Set alert_label CENTER Vertically respected to height

            panel1.setBounds(65, 100, 300, 300);                    // Set panel1 Positon x,y,width,height    
            Color color = new Color(254,254,254);                              // Set Mixing Colors to object color 
            for(int i=0;i<9;i++){
                buttons[i]=new JButton();                                              // Define Array buttons
                buttons[i].addActionListener(this);                                    // Add ActionListener to buttons[i]
                buttons[i].setActionCommand(i+"");                                     // Set Acton Command to each Button {0...8} with its index value
                buttons[i].setFont(font2);                                             // Set Font to button[i]
                buttons[i].setBackground(color);                                       // Set Background to button[i]
                buttons[i].setFocusable(false);                             // Set Focusable to false
                panel1.add(buttons[i]);                                               // Add All buttons[0-9] to thre panel1
            }
            
            replay.addActionListener(this);                                           // Add ActionListener to replay button
            replay.setBackground(color);                                              // Set Background to replay button
            replay.setFont(font1);                                                    // Set Font to replay button
            replay.setVisible(false);                                          // Set Focusable to false
            replay.setBounds(150,415 , 130, 35);                  // Set replay button Positon x,y,width,height    
            
            background2.add(replay);
            background2.add(alert_label);                                            // Add alert_label to background2
            background2.add(panel1);                                                 // Add panel1 to background2
            background2.setIcon(image);                                              // Set Image to the background2
            add(background2);                                                        // Finally Add that background2 to the Frame (Play)
        }
        
        // Actonperformed Function for each buttons[0-9] of Frame (play) that Generate ActionEvent ae
        public void actionPerformed(ActionEvent ae){                                 
            String action_button = ae.getActionCommand();                            // get ActionCommand of that particular button that user Clicked as String
            int pressed_button; 
            int check_visited = visited_button.indexOf(action_button);               // Compare  visited_button with action_button(Clicked button)...
            if(action_button != "Replay"){
                if(check_visited < 0){                                               // if Matched return its index positon otherwise return -1
                    pressed_button = Integer.parseInt(action_button);                // Convert action_button(Clicked button) to integer
                    buttons[pressed_button].setText(turn);                           // Set turn X/O to the Clicked Button Label
                    visited_button +=  action_button;                                // Add the Clicked button to Visited_button
                    space--;                                                         // Decrmented/one when the each Box is fulled

                    //There is no chance for win/drawn in first 3 move so we limite the function call inorder to call it unnecessarly
                    if( space < 6){                                                  // conditon True after first 4 Box fill 
                        compare(pressed_button,space);                               // compare Function call with 2 aruguments                                   
                    }
                    else{
                        update();                                                   // Call update() untill no space  
                    }
                } 
            }
            else{                                                                   // Execute Replay button pressed
                setVisible(false);                                               // Set Frame (PlAY) to HIDE
                new XOgame();                                                      // Call XOgame() to start again
            }            
        }

        //update the turn,alertlabel for next Player
        void update(){
            turn = (turn == "X")? "O":"X";                                          // Swap the turn after one move X->O , O->X
            alert_label.setText((turn=="X")?player1_alert+" Turn X" : player2_alert+" Turn O");  // Set Message according to turn
        }

        //Compare Function - Check the Current Turn Match of the Current Filled Box Position Horizontally,Vertically & Diagonally
        void compare(int current_change,int remaining_space){
            int vertical_start = 0,horizontal_start =current_change ,i;
            String matched_seq[] = {"","","",""};                                   // Hold MatchedSequence 0-diagnl1, 1-diagnl2, 2-Veritical, 3-Horizontal
            // Check Diagonal Macth
            if(current_change % 2 == 0){                                            // Check whether current change position is Even
                for(i = 0;i<3;i++){
                    if(buttons[i*4].getText() == turn)                              // Check (048)Diagonal text with turn
                        matched_seq[0] +=(i*4);                                     // Add to respected array position
                    if(buttons[i*2+2].getText() == turn)                            // Check (246)Diagonal text with turn
                        matched_seq[1] +=(i*2+2);                                   // Add to respected array position
                }
            }
            // Claculate Vertical Column, Horizontal Row
            while(current_change >= 0){
                vertical_start = current_change;
                current_change -= 3;                                                 // Decrementing Current_change by 3 untill 0/1/2
            }
            horizontal_start -= vertical_start;                                     // Subtracting vertical_start from Current_change we get Horizontal start

            // Check Horizontal,Veritical Match
            for( i=vertical_start;i<9; i+=3){
                if(buttons[i].getText() == turn)                                    // Check Vertical Match by incremment vertical_start by 3 so that we get (0,3,6) (1,4,7) (2,5,8) comination
                    matched_seq[2] += i;                                            // Add to respected array position
                if(buttons[horizontal_start].getText() == turn)                     // Incrementing hrizontal_start by 1 3times we get (0,1,2) (3,4,5) (6,7,8) comination
                    matched_seq[3] += horizontal_start++;                           // Add to respected array position
            }
            
            for(i=0;i<4;i++)
            {
                if(matched_seq[i].length() == 3){                                   // Check all Array matched_seq string length 3 which has 3 consecutive match  
                    for(int j=0; j<9; j++){
                        if(0 > matched_seq[i].indexOf(j+""))                        // check sequence with all button position !matched
                            buttons[j].setEnabled(false);                        // Set rescpective button Enable false to Disable it
                        else
                            buttons[j].setBackground(Color.green);                 // Sequence Matched Set respective button Background to green color
                    }
                    //And Update the alert_labl with winner name
                    alert_label.setText((turn=="X")?player1_alert+"  WINNER" : player2_alert+"  WINNER"); 
                    replay.setVisible(true);                                // Now game is concluded so we set replay button true to visible
                    return;
                }
            }
            if(remaining_space >0){
                update();                                                           // Call update() untill no space  
            }
            else{
                // if there is no match in match_seq and there is no space to play then the game is obviously Draw.
                for(int j=0; j<9; j++)
                    buttons[j].setEnabled(false);                                // Set All button Enable falsse to Disable it
                alert_label.setText("Match DRAWN");                          // Update the alert_label to Match DRAWN.
                replay.setVisible(true);                                    // Now game is Drawn so we set replay button true to visible
            }
        }
    }
    public static void main(String z[]){
        new XOgame();
    }
}