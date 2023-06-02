# 1~9 사이의 숫자 중 중복없이 3개의 숫자를 선택하세요.
from random import random

arr=[1,2,3,4,5,6,7,8,9]

for i in range(9):
    rnd = int(random()*9)
    a = arr[rnd]
    b = arr[0]
    arr[0]=a
    arr[rnd]=b

for i in arr:
    if i<4 :
        print(arr[i])
        
    