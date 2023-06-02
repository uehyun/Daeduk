from random import random

def getHollJJak():
    rnd = random()
    result = ""
    if rnd > 0.5 :
        result = "홀"
    else :
        result = "짝"
    
    return result

com = getHollJJak()
print("com",com)