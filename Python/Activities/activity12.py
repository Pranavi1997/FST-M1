def sum_res(n):
    if n:
        return n + sum_res(n-1)
    else:
        return 0
num = sum_res(10)
print("Sum of 0 t0 10 is : " ,num)
