# filepath: rock-paper-scissors-gui/src/main.py
import tkinter as tk
from gui.window import GameWindow

def main():
    root = tk.Tk()
    root.title("Rock Paper Scissors")
    app = GameWindow(root)
    root.mainloop()

if __name__ == "__main__":
    main()