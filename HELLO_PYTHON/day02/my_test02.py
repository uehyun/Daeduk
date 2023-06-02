# 첫 수를 입력하시오.
# 끝 수를 입력하시오.
# 5에서 7까지 합은 18입니다.
a = input("첫 수를 입력하시오.")
b = input("끝 수를 입력하시오.")
mylist = list(range(int(a),int(b)+1))

res = 0
for i in mylist:
    res += i
    
print("합계: ",res)
    