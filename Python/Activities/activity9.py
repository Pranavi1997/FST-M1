list1 = [2,3,14,54,100,23]
list2 = [15,29,14,144,25,2]
print("First list: ", list1)
print("Second list: ", list2)
list3 = [[x for x in list1 if x % 2 != 0] + [y for y in list2 if y % 2 == 0]]
print("Third list: ", list3)