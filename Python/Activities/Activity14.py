# Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.


def fib(n):
    if n <= 1:
        return n
    else:
        return fib(n-1) + fib(n-2)


fibn = int(input('Enter the how many Fibonnaci numbers to generate : '))

if fibn <= 0:
    print('enter the number greather than 0')
else:
    print('Fib series are :',end=' ')
    for i in range(fibn):
        print(fib(i),end=' ')
