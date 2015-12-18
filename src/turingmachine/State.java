package turingmachine;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mycloud012
 */
public class State {
    
    public enum Directions
    {
        RIGHT,
        LEFT,
        NULL
    }
    
    private String name;
    private String nextState;
    private char toWrite;
    private Directions direction;
    
    public State()
    {
        name = "";
        nextState = "";
        toWrite = '0';
        direction = direction.NULL;
    }
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setToWrite(char toWrite)
    {
        this.toWrite = toWrite;
    }
    
    public void setNextState(String nextState)
    {
        this.nextState = nextState;
    }
    
    public void setDirection(Directions direction)
    {
        this.direction = direction;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public char getToWrite()
    {
        return this.toWrite;
    }
    
    public String getNextState()
    {
        return this.nextState;
    }
    
    public Directions getDirection()
    {
        return this.direction;
    }
    
    
}
