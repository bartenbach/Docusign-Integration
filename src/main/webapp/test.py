#!/usr/bin/python3

x = input("Please enter a value for x: ")
i = 1
j = 1
while i < 10:
    j = j * i
    i = i + 1
    if i == x:
        exit(0)

print("values are:")
print(" x = " + str(x))
print(" y = " + str(i))
print(" j = " + str(j))
