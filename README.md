# MultiplicationTuringMachine
This repository simulates a code for Turing Machine which perform multiplication operation followed by addition of one.
<em>f(x) = 7x + 1</em>

# Problem Analysis
For the given problem 𝑓 (𝑥) = 7𝑥 + 1 𝑓𝑜𝑟 𝑒𝑣𝑒𝑟𝑦 𝑥 ≥ 0, it is required to essentially create a Turing Machine for multiplying two number such that 𝑓 (𝑥, y) = XY , finally at the end of the multiplication , an addition operation shall be performed to the output such that 𝑓 (𝑥,y) = 𝑥 + y. 

# Problem Solution
In order to perform multiplication of two numbers, initially the numbers will be converted into unary system and then inserted into the tape. In the given problem, the tape alphabet will consist of {#, 0, 1, *, X, Y}. 

Initially “#” will be inserted into the tape indicating start of an input, followed by 7 ones, followed by “*” sign.

<img src="http://i.imglobby.com/SphOkbJ.png"/>

On the right hand of the tape (after the “*” symbol) the multiplier will be inserted followed by “#” indicating end of input, assuming the multiplier is 2, then the tape will look like this:

<img src="http://i.imglobby.com/SphOkbJ.png"/>

The machine which performs the multiplication procedure followed by the addition is shown below:
<img src = "http://i.imglobby.com/7qG0A1O.png"/>

## The Turing Machine procedure works as below:<br>
1.	In q0, if the read symbol is “#”, head to the right. If “1” was read, then change it to “X” and move right, change state to q1.
<img src= "http://i.imglobby.com/qY9u3dJ.png"/><br>
2. In q1, if the read symbol is “1” keep moving right (basically escaping all the ones) until the “*” is reached, head to state q2 and move right.
3. In state q2 (now the reading hand is standing after the “*” symbol), if the read symbol is “1”, change it to “Y” and head toward state q3, and move right.
<img src ="http://i.imglobby.com/1mJYmIe.png"/><br>
4. In q3, for every read “1” move right (basically escaping all the ones on the RHS) until “#” is reached, change state to q4 and move right.
5. In q4, if read input is “blank” then insert “0” , move right, and head to state q5.
<img src="http://i.imglobby.com/dHUQCPh.png"/><br>
6. In q5, on reading either {0, #, 1, Y} keep heading to the left side of the tape until the multiplication symbol is reached, head to q2 and repeat the procedure of replacing every “1” with “Y” and adding “0”to the end of tape, until all the ones on the right side after the “*” changed to “Y”. 

7. A rest procedure shall be applied to transform the “Y” into “1” again as long as there still “1”s on the LHS of the multiplication tape. This is performed during the transitions from state q6 to q8. 
8. Eventually, when all the “1”s on the LHS of the multiplication symbol have turned into “X”, this indicates that the multiplication procedure is completed and it is time to sum an extra 1 to the output of the multiplication left on the most RHS of tape, this is done by adding an extra “1” to the tape.

## The complete version of the Turing Machine which simulates 𝑓 (𝑥) = 7𝑥 + 1 𝑓𝑜𝑟 𝑒𝑣𝑒𝑟𝑦 𝑥 ≥ 0
The first part of the machine (RHS) is basically inserting the 7 ones followed by #. Then the machine explained above takes the wheel to compute the multiplication and addition operations.

<img src="http://i.imglobby.com/rtB9szm.png"/><br>

Complete run output for the function in Java program: https://gist.github.com/MyCloud012/ccfdf8e6e99a50c8834b

If you are interested in this kind of science, I recommend textbook "the Introcuction to Theory of computation by Micheal Sipser Ist Ed".

PS: The implementation is not following any of the principles for code modularity, its more like a handy implementation for simulation purposes.
