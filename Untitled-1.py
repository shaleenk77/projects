from tkinter import *
from tkinter import ttk
import random
import time


def bubble_sort(data, drawData, colors, timeTick):
    for _ in range(len(data)-1):
        for j in range(len(data)-1):
            if data[j] > data[j+1]:
                data[j], data[j+1] = data[j+1], data[j]
                drawData(data, colors)
                root.update()
                time.sleep(timeTick)


def countingSort(data, drawData, colors, timeTick):
    M = max(data)
    count_array = [0] * (M + 1)
    for num in data:
        count_array[num] += 1

    for i in range(1, M + 1):
        count_array[i] += count_array[i - 1]

    output_array = [0] * len(data)

    for i in range(len(data) - 1, -1, -1):
        output_array[count_array[data[i]] - 1] = data[i]
        count_array[data[i]] -= 1
        drawData(output_array, colors)
        root.update()
        time.sleep(timeTick)

    drawData(output_array, colors)
    root.update()
    time.sleep(timeTick)


def insertionSort(data, drawData, colors, timeTick):
    n = len(data)
    if n <= 1:
        return
    for i in range(1, n):
        key = data[i]
        j = i-1
        while j >= 0 and key < data[j]:
            data[j+1] = data[j]
            j -= 1
            drawData(data, colors)
            root.update()
            time.sleep(timeTick)

        data[j+1] = key
        drawData(data, colors)
        root.update()
        time.sleep(timeTick)


def merge(data, l, m, r, drawData, colors, timeTick):
    n1 = m - l + 1
    n2 = r - m

    L = [0] * (n1)
    R = [0] * (n2)

    for i in range(0, n1):
        L[i] = data[l + i]

    for j in range(0, n2):
        R[j] = data[m + 1 + j]

    i = 0
    j = 0
    k = l

    while i < n1 and j < n2:
        if L[i] <= R[j]:
            data[k] = L[i]
            i += 1
            drawData(data, colors)
            root.update()
            time.sleep(timeTick)
        else:
            data[k] = R[j]
            j += 1
            drawData(data, colors)
            root.update()
            time.sleep(timeTick)
        k += 1

    while i < n1:
        data[k] = L[i]
        i += 1
        k += 1
        drawData(data, colors)
        root.update()
        time.sleep(timeTick)

    while j < n2:
        data[k] = R[j]
        j += 1
        k += 1
        drawData(data, colors)
        root.update()
        time.sleep(timeTick)


def mergeSort(data, l, r, drawData, colors, timeTick):
    if l < r:
        m = l+(r-l)//2

        mergeSort(data, l, m, drawData, colors, timeTick)
        mergeSort(data, m+1, r, drawData, colors, timeTick)
        merge(data, l, m, r, drawData, colors, timeTick)


def partition(data, head, tail, drawData, colors, timeTick):
    border = head
    pivot = data[tail]

    drawData(data, colors)
    root.update()
    time.sleep(timeTick)

    for j in range(head, tail):
        if(data[j] < pivot):
            drawData(data, colors)
            root.update()
            time.sleep(timeTick)
            data[border], data[j] = data[j], data[border]
            border += 1

    drawData(data, colors)
    root.update()
    time.sleep(timeTick)
    data[border], data[tail] = data[tail], data[border]
    return border


def quick_sort(data, head, tail, drawData, colors, timeTick):
    if head < tail:
        partitionIdx = partition(data, head, tail, drawData, colors, timeTick)

        quick_sort(data, head, partitionIdx-1, drawData, colors, timeTick)

        quick_sort(data, partitionIdx+1, tail, drawData, colors, timeTick)


def selectionSort(data, drawData, colors, timeTick):
    for ind in range(len(data)):
        min_index = ind
        for j in range(ind + 1, len(data)):
            if data[j] < data[min_index]:
                min_index = j
                drawData(data, colors)
                root.update()
                time.sleep(timeTick)

        (data[ind], data[min_index]) = (data[min_index], data[ind])
        drawData(data, colors)
        root.update()
        time.sleep(timeTick)


root = Tk()
root.title('Sorting Algorithm Visualiser')
root.geometry('900x600+200+80')
root.config(bg='#242424')
data = []



def drawData(data, colors):
    canvas.delete('all')
    canvas_height = 450
    canvas_width = 870
    x_width = canvas_width / (len(data) + 1)
    offset = 10
    spacing_bet_rect = 10
    normalized_data = [i / max(data) for i in data]

    for i, height in enumerate(normalized_data):
        x0 = i * x_width + offset + spacing_bet_rect
        y0 = canvas_height - height * 400
        x1 = (i + 1) * x_width
        y1 = canvas_height
        bar_color = colors[i]

        # Draw shadow
        shadow_offset = 5
        canvas.create_rectangle(x0 + shadow_offset, y0 + shadow_offset, x1 + shadow_offset, y1 + shadow_offset, fill='gray20', outline='', width=0)
        
        # Draw rounded rectangle with bar color
        canvas.create_rectangle(x0, y0, x1, y1, fill=bar_color, outline='', width=0, tags='bars')
        canvas.create_text(x0 + 2, y0, anchor=SW, text=str(data[i]), font=('Sans', 10, 'bold'), fill='white')

    root.update_idletasks()


def StartAlgo():
    global data
    colors = ['#' + ''.join(random.choices('0123456789ABCDEF', k=6)) for _ in range(len(data))]
    if algo_menu.get() == 'Quick Sort':
        quick_sort(data, 0, len(data) - 1, drawData, colors, speedscale.get())
    elif algo_menu.get() == 'Bubble Sort':
        bubble_sort(data, drawData, colors, speedscale.get())
    elif algo_menu.get() == 'Selection Sort':
        selectionSort(data, drawData, colors, speedscale.get())
    elif algo_menu.get() == 'Insertion Sort':
        insertionSort(data, drawData, colors, speedscale.get())
    elif algo_menu.get() == 'Merge Sort':
        mergeSort(data, 0, len(data) - 1, drawData, colors, speedscale.get())


def Generate():
    global data
    minivalue = int(minvalue.get())
    maxivalue = int(maxvalue.get())
    sizeevalue = int(sizevalue.get())

    data = []
    for _ in range(sizeevalue):
        data.append(random.randrange(minivalue, maxivalue + 1))

    # Generate random colors for bars
    colors = ['#' + ''.join(random.choices('0123456789ABCDEF', k=6)) for _ in range(sizeevalue)]
    drawData(data, colors)


# Create GUI elements
mainlabel = Label(root, text='Algorithm : ', font=("Sans", 16, 'bold'), bg='#2C394B', width=10, fg='white',
                  relief=GROOVE, bd=5)
mainlabel.place(x=0, y=0)

algo_menu = ttk.Combobox(root, width=15, font=('Sans', 12, 'bold'),
                         values=['Bubble Sort', 'Selection Sort', 'Quick Sort', 'Insertion Sort', 'Merge Sort', 'Counting Sort'])
algo_menu.place(x=145, y=0)
algo_menu.current(0)

random_generate = Button(root, text='Generate', bg='#4CAF50', font=('Sans', 12, 'bold'), relief=SUNKEN,
                         activebackground='#4CAF50', activeforeground='white', bd=5, width=10, command=Generate)
random_generate.place(x=750, y=60)

sizevaluelabel = Label(root, text='Size : ', font=("Sans", 12, 'bold'), bg='#2C394B', width=10, fg='white', height=2,
                       relief=GROOVE, bd=5)
sizevaluelabel.place(x=0, y=60)
sizevalue = Scale(root, from_=0, to=30, resolution=1, orient=HORIZONTAL, font=('Sans', 14, 'bold'), relief=GROOVE, bd=2,
                  width=10)
sizevalue.place(x=120, y=60)

minvaluelabel = Label(root, text='Min Value : ', font=("Sans", 12, 'bold'), bg='#2C394B', width=10, fg='white', height=2,
                      relief=GROOVE, bd=5)
minvaluelabel.place(x=250, y=60)
minvalue = Scale(root, from_=0, to=20, resolution=1, orient=HORIZONTAL, font=('Sans', 14, 'bold'), relief=GROOVE, bd=2,
                 width=10)
minvalue.place(x=370, y=60)

maxvaluelabel = Label(root, text='Max Value : ', font=("Sans", 12, 'bold'), bg='#2C394B', width=10, fg='white', height=2,
                      relief=GROOVE, bd=5)
maxvaluelabel.place(x=500, y=60)
maxvalue = Scale(root, from_=20, to=100, resolution=1, orient=HORIZONTAL, font=('Sans', 14, 'bold'), relief=GROOVE, bd=2,
                 width=10)
maxvalue.place(x=620, y=60)

start = Button(root, text='Start', bg='#FF5733', font=('Sans', 12, 'bold'), relief=SUNKEN, activebackground='#FF5733',
               activeforeground='white', bd=5, width=10, command=StartAlgo)
start.place(x=750, y=0)

speedlabel = Label(root, text='Speed : ', font=("Sans", 12, 'bold'), bg='#2C394B', width=10, fg='white', height=2,
                   relief=GROOVE, bd=5)
speedlabel.place(x=400, y=0)
speedscale = Scale(root, from_=0.1, to=5.0, resolution=0.8, length=200, digits=2, orient=HORIZONTAL,
                   font=('Sans', 14, 'bold'), relief=GROOVE, bd=2, width=10)
speedscale.place(x=520, y=0)

canvas = Canvas(root, width=870, height=450, bg='pink')
canvas.place(x=10, y=130)

root.mainloop()