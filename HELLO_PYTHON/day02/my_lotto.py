from random import random

lotto = list(range(1,45+1))

for i in lotto:
    rnd = int(random()*45)
    a = lotto[rnd]
    b = lotto[0]
    lotto[0]=a
    lotto[rnd]=b

# print(lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5])
print(lotto[0:6])