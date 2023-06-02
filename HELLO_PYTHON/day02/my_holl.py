# 홀/짝을 입력하시오. 홀
# 나 : 홀
# 컴 : 홀
# 결과 : 승리
import random
a = input("홀/짝을 입력하시오.")
rnd = random.choice('홀짝')
if a == rnd :
    print(rnd)
    print("승리")
else :
    print(rnd)
    print("패배")



mine = ""
com = ""
result = ""

mine = input("홀/짝을 입력하시오.")
rnd = random.random();
if rnd> 0.5 :
    com = "홀"
else :
    com = "짝"

if mine == com :
    result = "승리"
else :
    result = "패배"

print("나:",mine)
print("컴:",com)
print("결과:",result)
    
print("바보",end="\t")
print("천재")