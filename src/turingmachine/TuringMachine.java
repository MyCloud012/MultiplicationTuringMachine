/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmachine;

import java.util.ArrayList;

/**
 *
 * @author Mycloud012
 */
public class TuringMachine {

    // The tape which will hold the data.
    public static ArrayList<Character> tape = new ArrayList<Character>();

    /*
     * Method to find the transition from a certain state based on the read char by the turing machine
     * @param state object which represnt the current state the machine is within.
     * @param readLetter char representing the current letter the turing machine is looking at.
     * @return State object contains the new state the machine will traverse to ,the direction it will take,
     * and the letter it will write before moving.
     */
    public static State getTransition(State state, char readLetter) {
        State x = new State();
        x.setName(state.getName());

        if (state.getName().equals("q0")) {
            // If read # and in q0, write # and move R.
            if (readLetter == '#') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState(state.getName());
                return x;
                // If read 1 and in q0, replace the 1 with X, move the pointer to next character on the right
                // and update the state to q1
            } else if (readLetter == '1') {
                x.setToWrite('X');
                x.setDirection(State.Directions.RIGHT);
                x.setNextState("q1");
                return x;
            }

        }
        // If the turing machine is currently at state q1
        else if (state.getName().equals("q1")) {
            // If the read letter is 1, write 1 (basically do not change the 1), move the pointer to the right,
            // and remain in the same state.
            if (readLetter == '1') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState(state.getName());
                return x;
            } 
            // If the read letter is '*', move the machine pointer to the right, and move to q2.
            else if (readLetter == '*') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState("q2");
                return x;
            }
        }
        // If the turing machine is currently at q2
        else if (state.getName().equals("q2")) {
            // If the read letter is 'Y' , keep it y, move the pointer to the right, and remain in the same state.
            if (readLetter == 'Y') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState(state.getName());
                return x;
            }
            // If the read letter is '1' , change it to Y, move the pointer to the right, and go to q3.
            else if (readLetter == '1') {
                x.setToWrite('Y');
                x.setDirection(State.Directions.RIGHT);
                x.setNextState("q3");
                return x;
            }
            
            // If the read letter is '#' , keep it #, move the pointer to the left, and go to q6.
            else if (readLetter == '#') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.LEFT);
                x.setNextState("q6");
                return x;
            }

        }
        
        // If the machine is in state q3
        else if (state.getName().equals("q3")) {
            // If the read letter is '1' , keep it 1, move the pointer to the right, and remain in the same state.
            if (readLetter == '1') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState(state.getName());
                return x;
            }
            // If the read letter is '#' , keep it, move the pointer to the right, and go to q4.
            else if (readLetter == '#') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState("q4");
                return x;
            }
        }
        // If the machine is currently in q4
        else if (state.getName().equals("q4")) {
            // If the read letter is '0' , keep it, move the pointer to the right, remain in the same state.
            if (readLetter == '0') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState(state.getName());
                return x;
            } 
            // If the read letter is '$' which means empty , change it to 0, move the pointer to the right, and go to q5.
            else if (readLetter == '$') {
                x.setToWrite('0');
                x.setDirection(State.Directions.LEFT);
                x.setNextState("q5");

                return x;
            }


        } 
        
        // If the machine is in state q5
        else if (state.getName().equals("q5")) {
            // If the read letter is 0,#,1,Y , do not change it, and keep moving towarding the left
            // Looking for the '*'.
            if (readLetter == '0' || readLetter == '#' || readLetter == '1' || readLetter == 'Y') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.LEFT);
                x.setNextState(state.getName());
                return x;
            }
            // If the read letter is '*' , keep it, move the pointer to the right, and go to q2.
            else if (readLetter == '*') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState("q2");
                return x;
            }
        }
        // IF the machine is in state q6
        else if (state.getName().equals("q6")) {
            // If the read letter is 'Y' , change it to 1, move the pointer to the left looking for other Ys.
            // to update them as 1. This is basically happening after a whole multiplication iteration have occured
            // and its time to reset and do 1 more iteration.
            if (readLetter == 'Y') {
                x.setToWrite('1');
                x.setDirection(State.Directions.LEFT);
                x.setNextState(state.getName());
                return x;
            }
            // If the read letter is '*' , keep it, move the pointer to the left, and go to q7.
            else if (readLetter == '*') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.LEFT);
                x.setNextState("q7");
                return x;
            }

        } 
        else if (state.getName().equals(("q7"))) {
            if (readLetter == '1') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.LEFT);
                x.setNextState(state.getName());
                return x;
            } else if (readLetter == 'X') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState("q8");
                return x;
            }
        } else if (state.getName().equals("q8")) {

            if (readLetter == '1') {
                x.setToWrite(readLetter);
                x.setDirection(state.getDirection());
                x.setNextState("q0");
                System.out.println("\nfrom q8 returning state: " + x.getNextState());
                return x;
            } else if (readLetter == '*') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState("q9");
                return x;
            }





        } else if (state.getName().equals("q9")) {

            if (readLetter == '0' || readLetter == '#' || readLetter == '1') {
                x.setToWrite(readLetter);
                x.setDirection(State.Directions.RIGHT);
                x.setNextState(state.getName());
                return x;
            } else if (readLetter == '$') {
                x.setToWrite('0');
                x.setDirection(State.Directions.NULL);
                x.setNextState("q10");
                return x;
            }



        } else if (state.getName().equals("q10")) {
            System.out.println("Accepted" + " and result: " + showResult());
            System.exit(0);
        }
        return x;
    }

    /*
     * Method to initialize the tape with the multiplicant and multiplier
     * Along with initializing extra blank space for the answer.
     */
    public static void initializeTape(int multiplicant) {
        int resultSize = 7 * multiplicant;
        tape.add('#'); // Start of input
        tape.add('1');
        tape.add('1');
        tape.add('1');
        tape.add('1');
        tape.add('1');
        tape.add('1');
        tape.add('1');
        tape.add('*'); // Multiplication Symbol

        // Inserting multiplicant into the tape
        for (int i = 0; i < multiplicant; i++) {
            tape.add('1');
        }

        tape.add('#'); // End of input

        // Initializing free space for the answer in the tape.
        for (int i = 0; i < resultSize; i++) {
            tape.add('$');
        }

        tape.add('$'); // for + 1
    }

    public static int showResult() {
        int result = 0;
        for (int i = 0; i < tape.size(); i++) {
            if (tape.get(i) == '0') {
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // The parameter is the multiplier, change it to whatever multiplier you wish to test.
        initializeTape(2);


        // Initially, the machine assume that it is standing at state q0
        State temp = new State();
        temp.setName("q0");

        // This prints the tape for preview in console
        for (int i = 0; i < tape.size();) {
            for (Character x : tape) {
                System.out.print(x + "  ");
            }

            // getTransition method returns a state object which contains info about 
            // Direction the machine will take.
            System.out.println("\nTransition: " + temp.getName() + " at " + i);
            temp = getTransition(temp, tape.get(i));

            // If no state was returned, then something wrong have occured.
            // This is a halt (might not even happen).
            if (temp.getName().equals("")) {
                System.out.println("\nRejected");
                System.exit(0);
            }

            System.out.println("\nState: " + temp.getName() + " Read Letter:" + tape.get(i) + "\n");

            //System.out.println("Writing: " + tape.get(i) + " , " + temp.getToWrite());
            tape.set(i, temp.getToWrite());

            /*
             * The idea behind this procedure is that it for every letter in the tape
             * it calls the getTransition method which return a state object containing information
             * about the direction which the machine will take. If the machine is going right
             * then the index of "i" is incremented by one, if the machine is going left, then the 
             * index of "i" is decremented by one. Otherwise, the "i" remains the same.
             * This procedure is repeated until the tape content has been iterated, paractically
             * until the getTransition method returns the final answer.
             */
            try {
                if (temp.getDirection() == State.Directions.RIGHT) {
                    i += 1;
                    //System.out.println("Moving Right " + "i = " + i + " letter: " + tape.get(i));
                    //System.out.println();
                } else if (temp.getDirection() == State.Directions.LEFT) {
                    i = i - 1;
                    //System.out.println("Moving Left");
                    //System.out.println();
                } else {
                    System.out.println("Staying in place");
                    for (Character x : tape) {
                        System.out.print(x + "  ");
                    }
                    // i = 0;
                    System.out.println();
                }

            } catch (Exception e) {
                i = 0;
                System.out.println("Throwing an exception: " + e.getLocalizedMessage());
                System.out.println();
            }

            State next   = new State();
            next.setName(temp.getNextState());
            //System.out.println("next state: " + temp.getNextState());

            temp = next;

        }
    }
}
