import winsound
import time
from tkinter import *
from tkinter import ttk
import random
from sort1 import sort1

sort1=sort1()

root = Tk()
root.title('Sorting Algorithm Visualiser')
root.maxsize(900, 600)
root.config(bg='black')

#variables
selected_alg = StringVar()
data = []

#function
def drawData(data, colorArray):
    canvas.delete("all")
    c_height = 380
    c_width = 600
    x_width = c_width / (len(data) + 1)
    offset = 30
    spacing = 10
    normalizedData = [ i / max(data) for i in data]
    for i, height in enumerate(normalizedData):
        #top left
        x0 = i * x_width + offset + spacing
        y0 = c_height - height * 340
        #bottom right
        x1 = (i + 1) * x_width + offset
        y1 = c_height

        canvas.create_rectangle(x0, y0, x1, y1, fill=colorArray[i])
        canvas.create_text(x0+2, y0, anchor=SW, text=str(data[i]),fill='white')
    
    root.update_idletasks()


def Generate():
    global data

    minVal = int(minEntry.get())
    maxVal = int(maxEntry.get())
    size = int(sizeEntry.get())

    data = []
    for _ in range(size):
        data.append(random.randrange(minVal+1, maxVal+1))

    drawData(data, ['white' for x in range(len(data))]) #['red', 'red' ,....]

def StartAlgorithm():
    global data
    if not data: return

    if algMenu.get() == 'Quick Sort':
        sort1.quick_sort(data, 0, len(data)-1, drawData, speedScale.get())
    
    elif algMenu.get() == 'Bubble Sort':
        sort1.bubble_sort(data, drawData, speedScale.get())

    elif algMenu.get() == 'Selection Sort':
        sort1.selection_sort(data, drawData, speedScale.get())

    elif algMenu.get() == 'Merge Sort':
        sort1.merge_sort(data, drawData, speedScale.get())
    
    drawData(data, ['green' for x in range(len(data))])


#frame / base lauout
UI_frame = Frame(root, width= 700, height=300, bg='black')
UI_frame.grid(row=0, column=0, padx=0, pady=0)

canvas = Canvas(root, width=700, height=380, bg='black')
canvas.grid(row=1, column=0, padx=0, pady=0)

#User Interface Area
#Row[0]
Label(UI_frame, text="Algorithm: ", bg='black',fg='white').grid(row=0, column=0, padx=5, pady=5, sticky=W)
algMenu = ttk.Combobox(UI_frame, textvariable=selected_alg, values=['Bubble Sort','Selection Sort' ,'Quick Sort', 'Merge Sort'])
algMenu.grid(row=0, column=1, padx=5, pady=5)
algMenu.current(0)

speedScale = Scale(UI_frame, from_=0.1, to=5.0, length=200, digits=2, resolution=0.2, orient=HORIZONTAL,bg='white', label="Select Speed [s]")
speedScale.grid(row=0, column=2, padx=5, pady=5)
Button(UI_frame, text="Start", command=StartAlgorithm, bg='green').grid(row=1, column=3, padx=5, pady=5)

#Row[1]
sizeEntry = Scale(UI_frame, from_=3, to=25, resolution=1, orient=HORIZONTAL, bg='white',label="Data Size")
sizeEntry.grid(row=1, column=0, padx=5, pady=5)

minEntry = Scale(UI_frame, from_=0, to=10, resolution=1, orient=HORIZONTAL, label="Min Value",bg='white')
minEntry.grid(row=1, column=1, padx=5, pady=5)

maxEntry = Scale(UI_frame, from_=10, to=100, resolution=1, orient=HORIZONTAL, label="Max Value",bg='white')
maxEntry.grid(row=1, column=2, padx=5, pady=5)

Button(UI_frame, text="Generate", command=Generate, bg='grey').grid(row=0, column=3, padx=5, pady=5)

root.mainloop()

