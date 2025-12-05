p1 = input("Enter player1 name: ")
p2 = input("Enter player2 name: ")
 
while True:
    p1_ans = input(p1 + ", Enter you choose (rock,paper,scissors): ").lower()
    p2_ans = input(p2 + ", Enter you choose (rock,paper,scissors ").lower()
    if p1_ans == p2_ans:
        print("It's a tie!")
    elif p1_ans == 'rock':
        if p2_ans == 'scissors':
            print(p1+ " Rock wins!")
        else:
            print(p2+ " Paper wins!")
    elif p1_ans == 'scissors':
        if p2_ans == 'paper':
            print(p1+ " Scissors win!")
        else:
            print(p2+ " Rock wins!")
    elif p1_ans == 'paper':
        if p2_ans == 'rock':
            print(p1+ " Paper wins!")
        else:
            print(p2+ " Scissors win!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")
    
    repeat = input("Do you want to play another round? Yes/No: ").lower()
    
    if(repeat == "yes"):
        pass
    elif(repeat == "no"):
        raise SystemExit
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit