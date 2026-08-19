"""
Lab 00: Hello, World!

Description: This program prints "Hello, world!" to the console and then prints any command line arguments provided.

Author: Jasmine Williams
Date/Version: 2026-08-18
"""
#enables the use of command line arguments
import sys

def main():
    #entry point; then initiates the command line input
    print("Hello, world!")
    #loop runs everything after the first command line argument
    for arg in sys.argv[1:]:
        print(arg)


#function that runs the main function
if __name__ == "__main__":
    main()
