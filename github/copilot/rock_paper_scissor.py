'''
Create a simple rock-paper-scissors game where the user can play against the computer that randomly chooses between rock, paper, and scissors.
With the game showing who won, the score of the user and the computer, and the option to play again or exit.
Add a score counter that keeps track of the number of games won by the user and the computer.
'''

import random

def play_game():
    choices = ['rock', 'paper', 'scissors']
    user_score = 0
    computer_score = 0

    while True:
        user_input = input("Enter r (rock), p (paper), or s (scissors) (or 'exit' to quit): ").lower()
        if user_input == 'r':
            user_choice = 'rock'
        elif user_input == 'p':
            user_choice = 'paper'
        elif user_input == 's':
            user_choice = 'scissors'
        else:
            user_choice = user_input
        if user_choice == 'exit':
            print("Thanks for playing!")
            break
        if user_choice not in choices:
            print("Invalid choice. Please try again.")
            continue
        
        computer_choice = random.choice(choices)
        print(f"Computer chose: {computer_choice}")

        if user_choice == computer_choice:
            print("It's a tie!")
        elif (user_choice == 'rock' and computer_choice == 'scissors') or \
             (user_choice == 'paper' and computer_choice == 'rock') or \
             (user_choice == 'scissors' and computer_choice == 'paper'):
            print("You win!")
            user_score += 1
        else:
            print("Computer wins!")
            computer_score += 1

        print(f"Score - You: {user_score}, Computer: {computer_score}")

play_game()
# The game will continue until the user types 'exit', keeping track of the scores throughout the session.