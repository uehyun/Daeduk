# 가위/바위/보를 선택하세요. 가위
# 나: 가위
# 컴: 바위
# 결과: 패배
from random import random

me = input("가위/바위/보를 선택하세요.")
com = ""
result = ""

rnd = random();

if rnd>0.66:
    com="가위"
elif rnd>0.33:
    com="바위"
else:
    com="보"
    
if me == com :
    result="비겼습니다."
elif (me == "가위" and com == "바위") or (me == "바위" and com == "보") or (me == "보" and com == "가위"):
    result="졌습니다."
else :
    result="이겼습니다."
    
print("나: ",me)
print("컴퓨터: ",com)
print("결과: ",result)