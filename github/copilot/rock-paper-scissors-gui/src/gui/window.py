import tkinter as tk
from tkinter import ttk
import random

class GameWindow(tk.Frame):
    def __init__(self, master):
        super().__init__(master)
        self.master = master
        self.choices = ['rock', 'paper', 'scissors']
        self.user_score = 0
        self.computer_score = 0
        self.max_score = 5  # Puntuación máxima para la barra de progreso
        self.create_widgets()
        self.pack(padx=20, pady=20)

    def create_widgets(self):
        # Título
        title = tk.Label(self, text="Rock Paper Scissors", font=("Helvetica", 16, "bold"))
        title.grid(row=0, column=0, columnspan=3, pady=10)

        # Botones de elección
        tk.Button(self, text="Rock", command=lambda: self.play("rock")).grid(row=1, column=0, padx=5)
        tk.Button(self, text="Paper", command=lambda: self.play("paper")).grid(row=1, column=1, padx=5)
        tk.Button(self, text="Scissors", command=lambda: self.play("scissors")).grid(row=1, column=2, padx=5)

        # Resultados
        self.result_var = tk.StringVar()
        self.result_var.set("Make your choice!")
        result_label = tk.Label(self, textvariable=self.result_var, font=("Helvetica", 12))
        result_label.grid(row=2, column=0, columnspan=3, pady=10)

        # Puntuación
        self.score_var = tk.StringVar()
        self.score_var.set(f"Score - You: {self.user_score}, Computer: {self.computer_score}")
        score_label = tk.Label(self, textvariable=self.score_var, font=("Helvetica", 12))
        score_label.grid(row=3, column=0, columnspan=3)

        # Agregar barras de progreso para el marcador
        self.progress_frame = tk.Frame(self)
        self.progress_frame.grid(row=4, column=0, columnspan=3, pady=10)

        # Barra de progreso del jugador
        tk.Label(self.progress_frame, text="Jugador:", font=("Helvetica", 10)).grid(row=0, column=0, padx=5)
        self.user_progress = ttk.Progressbar(
            self.progress_frame, 
            length=100, 
            mode='determinate',
            maximum=self.max_score
        )
        self.user_progress.grid(row=0, column=1, padx=5)

        # Barra de progreso de la computadora
        tk.Label(self.progress_frame, text="Computadora:", font=("Helvetica", 10)).grid(row=1, column=0, padx=5)
        self.computer_progress = ttk.Progressbar(
            self.progress_frame, 
            length=100, 
            mode='determinate',
            maximum=self.max_score
        )
        self.computer_progress.grid(row=1, column=1, padx=5)

    def play(self, user_choice):
        computer_choice = random.choice(self.choices)
        result = self.determine_winner(user_choice, computer_choice)
        
        self.result_var.set(f"Computer chose: {computer_choice}\n{result}")
        self.update_score()

    def determine_winner(self, user_choice, computer_choice):
        if user_choice == computer_choice:
            return "It's a tie!"
        elif ((user_choice == 'rock' and computer_choice == 'scissors') or 
              (user_choice == 'paper' and computer_choice == 'rock') or 
              (user_choice == 'scissors' and computer_choice == 'paper')):
            self.user_score += 1
            return "You win!"
        else:
            self.computer_score += 1
            return "Computer wins!"

    def update_score(self):
        self.score_var.set(f"Score - You: {self.user_score}, Computer: {self.computer_score}")
        # Actualizar barras de progreso
        self.user_progress['value'] = self.user_score
        self.computer_progress['value'] = self.computer_score

def main():
    root = tk.Tk()
    game_window = GameWindow(root)
    root.mainloop()

if __name__ == "__main__":
    main()