# filepath: rock-paper-scissors-gui/src/gui/components.py

import tkinter as tk

def create_button(master, text, command):
    button = tk.Button(master, text=text, command=command)
    button.pack(pady=10)
    return button

def create_label(master, text):
    label = tk.Label(master, text=text)
    label.pack(pady=10)
    return label

def create_entry(master):
    entry = tk.Entry(master)
    entry.pack(pady=10)
    return entry