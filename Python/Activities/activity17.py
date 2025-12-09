import pandas as pd
data ={
      "Usernames" : ["admin","Charles","Deku"],
      "Passwords" : ["password","Charl13","AllMight"]
 }
df = pd.DataFrame(data)
print(df)
df.to_csv("sampledata.csv",index=False)