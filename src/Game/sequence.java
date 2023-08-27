package Game;

import java.util.ArrayList;

/**
 * @author arnaranjo
 * java foundations Project.
 */
public class sequence {

    private int value; 
    private ArrayList<Integer> gameSequence; 
    private ArrayList<Integer> playerSequence; 

    public sequence() {
        gameSequence = new ArrayList<>();
        playerSequence = new ArrayList<>();
        value = 0;
    }

    public int getValor() {
        return value;
    }

    public void ExeGame() {              
        this.value = (int) (Math.random() * 8 + 1);        
        gameSequence.add(this.value);
    }

    public void ExePlayer(int btPressed) {
        playerSequence.add(btPressed);
    }
    
    public int PlayerSequenceSize() {
        return playerSequence.size();
    }
    
    public int GameSequenceSize() {
        return gameSequence.size();
    }

    public boolean SameSize(){
        return gameSequence.equals(playerSequence);
    }
    
    public void ClearSequences() {
        gameSequence.clear();
        playerSequence.clear();
    }
}
