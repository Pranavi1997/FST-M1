def sum(n):
    sum = 0
    for num in n:
        sum += num
    return sum
sumlist = [20.10,45,67.18,87,90]
result = sum(sumlist)
print("Sum of elemnts in the list is : " ,result)