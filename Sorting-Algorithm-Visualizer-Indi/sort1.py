import time
import winsound
class sort1:
    def bubble_sort(self, data, drawData, timeTick):
        for _ in range(len(data) - 1):
            for j in range(len(data) - 1):
                if data[j] < data[j + 1]:  # Change the comparison operator
                    data[j], data[j + 1] = data[j + 1], data[j]
                    drawData(data, ['green' if x == j or x == j + 1 else 'white' for x in range(len(data))])
                    time.sleep(timeTick)
        for i in range(2):
            winsound.Beep(2500, 300)
            time.sleep(0.05)
        drawData(data, ['green' for x in range(len(data))])
def selection_sort(self, data, drawData, timeTick):
    for i in range(len(data) - 1):
        max_idx = i  # Change the variable name for clarity
        for j in range(i + 1, len(data)):
            if data[max_idx] < data[j]:  # Change the comparison operator
                max_idx = j
        data[i], data[max_idx] = data[max_idx], data[i]
        drawData(data, ['green' if x == max_idx or x == i else 'red' for x in range(len(data))])
        time.sleep(timeTick)
    for i in range(2):
        winsound.Beep(2500, 300)
        time.sleep(0.05)
    drawData(data, ['green' for x in range(len(data))])
def partition(self, data, left, right, drawData, timeTick):
    border = left
    pivot = data[right]

    drawData(data, self.getColorArray(len(data), left, right, border, border))
    time.sleep(timeTick)

    for j in range(left, right):
        if data[j] > pivot:  # Change the comparison operator
            drawData(data, self.getColorArray(len(data), left, right, border, j, True))
            time.sleep(timeTick)

            data[border], data[j] = data[j], data[border]
            border += 1

        drawData(data, self.getColorArray(len(data), left, right, border, j))
        time.sleep(timeTick)

    # swap pivot with border value
    drawData(data, self.getColorArray(len(data), left, right, border, right, True))
    time.sleep(timeTick)

    data[border], data[right] = data[right], data[border]

    return border

def quick_sort(self, data, left, right, drawData, timeTick):
    if left < right:
        partitionIdx = self.partition(data, left, right, drawData, timeTick)

        # LEFT PARTITION
        self.quick_sort(data, left, partitionIdx - 1, drawData, timeTick)

        # RIGHT PARTITION
        self.quick_sort(data, partitionIdx + 1, right, drawData, timeTick)
def merge(self, data, left, middle, right, drawData, timeTick):
    drawData(data, self.getColorArrayMerge(len(data), left, middle, right))
    time.sleep(timeTick)

    leftPart = data[left:middle + 1]
    rightPart = data[middle + 1: right + 1]

    leftIdx = rightIdx = 0

    for dataIdx in range(left, right + 1):
        if leftIdx < len(leftPart) and rightIdx < len(rightPart):
            if leftPart[leftIdx] >= rightPart[rightIdx]:  # Change the comparison operator
                data[dataIdx] = leftPart[leftIdx]
                leftIdx += 1
            else:
                data[dataIdx] = rightPart[rightIdx]
                rightIdx += 1

        elif leftIdx < len(leftPart):
            data[dataIdx] = leftPart[leftIdx]
            leftIdx += 1
        else:
            data[dataIdx] = rightPart[rightIdx]
            rightIdx += 1

    drawData(data, ["green" if x >= left and x <= right else "white" for x in range(len(data))])
    time.sleep(timeTick)
