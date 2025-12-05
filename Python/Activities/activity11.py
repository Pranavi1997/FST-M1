fruits = {
    "apple" : 144 ,
    "mango" : 100 ,
    "grapes" : 90,
    "orange" : 60
}
print(fruits)
check = input("The item is looking for ? ").lower()
if (check in fruits):
    print(" The item is available")
else:
    print("The item is not available")