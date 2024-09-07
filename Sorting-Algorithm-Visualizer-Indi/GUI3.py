import winsound
import time
from tkinter import *
from tkinter import ttk
import random
from sorting import Sortings  # Importing the sorting algorithms from a separate module

# Initialize Tkinter
root = Tk()
root.title('Sorting Algorithm Visualiser')
root.maxsize(900, 600)
root.config(bg='black')

# Variables
selected_alg = StringVar()  # Variable to store the selected algorithm
data = []  # List to store the data to be sorted

# Function to draw the data on the canvas
def drawData(data, colorArray):
    canvas.delete("all")
    c_height = 380
    c_width = 600
    x_width = c_width / (len(data) + 1)
    offset = 30
    spacing = 10
    normalizedData = [i / max(data) for i in data]  # Normalize data to fit within canvas
    for i, height in enumerate(normalizedData):
        # Top left coordinates
        x0 = i * x_width + offset + spacing
        y0 = c_height - height * 340
        # Bottom right coordinates
        x1 = (i + 1) * x_width + offset
        y1 = c_height

        # Draw a rectangle representing each data element
        canvas.create_rectangle(x0, y0, x1, y1, fill=colorArray[i])
        # Display the value of the data element on top of the rectangle
        canvas.create_text(x0 + 2, y0, anchor=SW, text=str(data[i]), fill='white')
    
    root.update_idletasks()

# Function to generate random data
def Generate():
    global data

    minVal = int(minEntry.get())
    maxVal = int(maxEntry.get())
    size = int(sizeEntry.get())

    # Generate random data within the specified range and size
    data = [random.randrange(minVal + 1, maxVal + 1) for _ in range(size)]

    # Draw the generated data on the canvas
    drawData(data, ['white' for _ in range(len(data))])  # Initialize all colors to white

# Function to start the selected sorting algorithm
def StartAlgorithm():
    global data
    if not data:  # If data is not generated, return
        return

    # Start the selected sorting algorithm based on the option chosen from the dropdown menu
    if algMenu.get() == 'Quick Sort':
        Sortings.quick_sort(data, 0, len(data) - 1, drawData, speedScale.get())
    
    elif algMenu.get() == 'Bubble Sort':
        Sortings.bubble_sort(data, drawData, speedScale.get())

    elif algMenu.get() == 'Selection Sort':
        Sortings.selection_sort(data, drawData, speedScale.get())

    elif algMenu.get() == 'Merge Sort':
        Sortings.merge_sort(data, drawData, speedScale.get())
    
    drawData(data, ['green' for _ in range(len(data))])  # After sorting, color all bars green

# Frame / base layout
UI_frame = Frame(root, width=700, height=300, bg='black')
UI_frame.grid(row=0, column=0, padx=0, pady=0)

canvas = Canvas(root, width=700, height=380, bg='black')
canvas.grid(row=1, column=0, padx=0, pady=0)

# User Interface Area
# Row[0]
Label(UI_frame, text="Algorithm: ", bg='black', fg='white').grid(row=0, column=0, padx=5, pady=5, sticky=W)
algMenu = ttk.Combobox(UI_frame, textvariable=selected_alg, values=['Bubble Sort', 'Selection Sort', 'Quick Sort', 'Merge Sort'])
algMenu.grid(row=0, column=1, padx=5, pady=5)
algMenu.current(0)

speedScale = Scale(UI_frame, from_=0.1, to=5.0, length=200, digits=2, resolution=0.2, orient=HORIZONTAL, bg='white', label="Select Speed [s]")
speedScale.grid(row=0, column=2, padx=5, pady=5)
Button(UI_frame, text="Start", command=StartAlgorithm, bg='green').grid(row=1, column=3, padx=5, pady=5)

# Row[1]
sizeEntry = Scale(UI_frame, from_=3, to=25, resolution=1, orient=HORIZONTAL, bg='white', label="Data Size")
sizeEntry.grid(row=1, column=0, padx=5, pady=5)

minEntry = Scale(UI_frame, from_=0, to=10, resolution=1, orient=HORIZONTAL, label="Min Value", bg='white')
minEntry.grid(row=1, column=1, padx=5, pady=5)

maxEntry = Scale(UI_frame, from_=10, to=100, resolution=1, orient=HORIZONTAL, label="Max Value", bg='white')
maxEntry.grid(row=1, column=2, padx=5, pady=5)

Button(UI_frame, text="Generate", command=Generate, bg='grey').grid(row=0, column=3, padx=5, pady=5)

root.mainloop()
