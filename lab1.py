"""
Lab 1: Basic Input and Output
Original Java Description: 
Step 1 -- Prepare a new BlueJ project for this lab:
1. Open BlueJ and create a new project and class.
2. Remove all code from the class.
3. Update the JavaDoc with your information.
4. Create a main method.
This step might seem like something that is not important, but in actuality
it is how you should start all your work.

Step 2 -- Create a loop in the main method that will read in multiple lines
from System.in using the scanner class. This will continue until a line
of no characters is entered, this is done by hitting the return key without
typing any characters.
1. A good loop to use is either the while loop or do-while loop.
2. Send the following information to “System.err”:
a. when the program enters the loop;
b. when the program leaves the loop;
c. the string that is entered using “System.in”.
3. Using “System.out” display each word in the entered string to a
separate line in the terminal.
4. You need to use two Scanner variables to do this work.

Step 3 – Add counters to track the number of lines, words and characters
entered. Then print this information at the end of the program.

Step 4 – Create a FileWriter object and a BufferedWriter object that will
write all the user input as well as the program output, but not the errors,
into a file named “Lab01.txt”. 

Author: Jasmine Williams
Date: 2026-08-18"""

import sys
def main():
    sys.stderr.write(f"entering loop\n")
    line_count = 0
    word_count = 0
    char_count = 0
    with open("Lab01.txt", "w") as output_file:
        #loop reads in multiple lines from standard input
        while True:
                try:
                    line = input()
                    # write lines to output_file here
                    output_file.write(line + "\n")
                    if line != "":
                        sys.stderr.write(f"continuing to loop >>{line}<<\n")
                        line_count += 1
                        char_count += len(line)
                        #separate the line into words and print each word on a new line
                        for word in line.split():
                            word_count += 1
                            print(word)
                    else:
                        sys.stderr.write(f"exiting loop\n")
                        break
                except EOFError:
                    sys.stderr.write(f"EOF reached\n")
                    break
        print("=======================")
        print("Line Count:", line_count)
        print("Word Count:", word_count)
        print("Char Count:", char_count)

        output_file.write("=======================\n")
        output_file.write(f"Line Count: {line_count}\n")
        output_file.write(f"Word Count: {word_count}\n")
        output_file.write(f"Char Count: {char_count}\n")

if __name__ == "__main__":
    main()