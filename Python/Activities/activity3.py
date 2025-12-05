p1=input("Enter player1 name: ")
p2=input("Enter player2 name: ")
p1_ans=input(p1+ " , Enter you choose (rock,paper,scissors): ").lower()
p2_ans=input(p2+ " , Enter you choose (rock,paper,scissors): ").lower()
if p1_ans==p2_ans:
    print("It's tie")
elif p1_ans=='rock':
    if p2_ans=='scissors':
        print(p1+ " Rock Wins")
    else:
        print(p2+ " Paper Wins")
elif p1_ans=='paper':
    if p2_ans=='rock':
        print(p1+ " Paper Wins")
    else:
        print(p2+ " Scissors Wins")
elif p1_ans=='scissors':
    if p2_ans=='paper':
        print(p1+ " Scissors Wins")
    else:
        print(p2+ " Rock Wins")        
else:
    print("Invalid input! You have not entered rock, paper or scissors, Please try again.")

