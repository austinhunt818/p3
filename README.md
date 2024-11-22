# Project 3

* Authors: Austin Hunt, Carson Magee
* Class: CS361 Section 001
* Semester: Fall 2024

## Overview

This program implements and simulates a single tape Turing Machine in Java.

## Reflections

### Austin
This project was the most interesting and challenging that we have done in this class. Setting up the states and basic
information for the turing machine wasn't bad. Carson got the simulation working, and from there I was able to optimize it.
I optimized his implementation using a hashmap to represent the tape rather than an array list. This allowed for constant
time reads and writes of the tape's contents, vastly improving the run time. It was very rewarding and fun to figure out how
to make the program run faster. I knew that hashmaps are ideal for reading and writing a lot, so I started with that and it
worked pretty well.

### Carson


## Compiling and Using

To compile the project, navigate to the top level directory and run the following command:

```javac tm/*.java```

Then, run the main method by running the command:

```java tm/TMSimulator [file]```

Where file is the input file that you want to run.

The input format of a file is as follows:

```
num_states

num_input_symbols

to_state, write_symbol, move_direction

...

input_string
```
Lines 3 until the last line represent transitions. There are (_num_states_ - 1 * _num_symbols_ + 1) transitions.

The last line represents the input string, and may be left blank for a blank input.


## Sources used

N/A