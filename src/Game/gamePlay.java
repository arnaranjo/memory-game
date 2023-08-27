package Game;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author arnaranjo
 * java foundations Project.
 */
public class gamePlay implements Runnable {

    private int gameLevel; //The level of the match is equal to the length of the sequence.
    private boolean buttonControl; //Is used to enable and disable the buttons.
    private boolean stopGame; //Is used to control the game.
    private final long gameTime; //This variable set the time span.
    sequence matchSequences;
    JButton btA, btB, btC, btD, btE, btF, btG, btH, btI;
    JLabel mainScreen;
    
    public gamePlay(JButton bt1, 
            JButton bt2,
            JButton bt3, 
            JButton bt4,
            JButton bt5, 
            JButton bt6,
            JButton bt7, 
            JButton bt8,
            JButton bt9, 
            JLabel mainScreen) {

        this.buttonControl = false;
        this.stopGame = false;
        this.gameLevel = 1;
        this.gameTime = 500;

        matchSequences = new sequence();

        this.btA = bt1;
        this.btB = bt2;
        this.btC = bt3;
        this.btD = bt4;
        this.btE = bt5;
        this.btF = bt6;
        this.btG = bt7;
        this.btH = bt8;
        this.btI = bt9;
        
        this.mainScreen =  mainScreen;
    }

    public int getGameLevel() {
        return this.gameLevel;
    }

    public boolean getButtonControl() {
        return buttonControl;
    }

    public void setButtonControl(boolean buttonControl) {
        this.buttonControl = buttonControl;
    }

    /**
     * run() is the loop of the game.
     */
    @Override
    public void run() {
        while (EndMatch() == false && this.stopGame == false) {
            Pause();
            matchSequences.ExeGame();
            ShowColor();
            Pause();
            DeleteColor();
        }
    }
    
    public void DeleteColor() {
        btA.setBackground(Color.LIGHT_GRAY);
        btB.setBackground(Color.LIGHT_GRAY);
        btC.setBackground(Color.LIGHT_GRAY);
        btD.setBackground(Color.LIGHT_GRAY);
        btE.setBackground(Color.LIGHT_GRAY);
        btF.setBackground(Color.LIGHT_GRAY);
        btG.setBackground(Color.LIGHT_GRAY);
        btH.setBackground(Color.LIGHT_GRAY);
        btI.setBackground(Color.LIGHT_GRAY);
    }
    
    public void ShowColor() {
        switch (matchSequences.getValor()) {
            case 1:
                btA.setBackground(Color.BLUE);             
                break;
            case 2:                
                btB.setBackground(Color.BLUE);                
                break;
            case 3:                
                btC.setBackground(Color.BLUE);                
                break;
            case 4:                
                btD.setBackground(Color.BLUE);                
                break;
            case 5:                
                btE.setBackground(Color.BLUE);                
                break;
            case 6:
                btF.setBackground(Color.BLUE);
                break;
            case 7:
                btG.setBackground(Color.BLUE);
                break;
            case 8:
                btH.setBackground(Color.BLUE);
                break;
            case 9:           
                btI.setBackground(Color.BLUE);
                break;
        }
    }
    
    /**
     * Every loop check whether the player has achieved the size of the game sequence.
     * If EndMatch() == true, the loop will stop.
     * The level is equal to the length of the sequence.
     * @return
     */
    public boolean EndMatch() {
        boolean control = false;
        if (matchSequences.GameSequenceSize() == this.gameLevel) {
            control = true;
            this.buttonControl = true;
            mainScreen.setText("your turn!");
        }
        return control;
    }

    /**
     * This method check that the sequences are the same.
     * @return 
    **/
    public boolean Result() {
        boolean control;
        if (matchSequences.SameSize()) {

            this.mainScreen.setText("All right!");
            this.gameLevel++;
            this.buttonControl = false;            
            matchSequences.ClearSequences();

            btA.setBackground(Color.LIGHT_GRAY);
            btB.setBackground(Color.LIGHT_GRAY);
            btC.setBackground(Color.LIGHT_GRAY);
            btD.setBackground(Color.LIGHT_GRAY);
            btE.setBackground(Color.LIGHT_GRAY);
            btF.setBackground(Color.LIGHT_GRAY);
            btG.setBackground(Color.LIGHT_GRAY);
            btH.setBackground(Color.LIGHT_GRAY);
            btI.setBackground(Color.LIGHT_GRAY);

            control = true;

        } else {

            this.mainScreen.setText("You lose! Level reached: " + this.gameLevel);            
            this.gameLevel = 1;
            this.buttonControl = false;           
            matchSequences.ClearSequences();

            btA.setBackground(Color.LIGHT_GRAY);
            btB.setBackground(Color.LIGHT_GRAY);
            btC.setBackground(Color.LIGHT_GRAY);
            btD.setBackground(Color.LIGHT_GRAY);
            btE.setBackground(Color.LIGHT_GRAY);
            btF.setBackground(Color.LIGHT_GRAY);
            btG.setBackground(Color.LIGHT_GRAY);
            btH.setBackground(Color.LIGHT_GRAY);
            btI.setBackground(Color.LIGHT_GRAY);

            control = false;
        }
        return control;
    }
    
    public void Pause() {
        try {
            Thread.sleep(this.gameTime);
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void StopGame(boolean stopGame) {
        this.stopGame = stopGame;
        
        if (this.stopGame == true) {
            this.gameLevel = 1;
            matchSequences.ClearSequences();
        }
    }
}
