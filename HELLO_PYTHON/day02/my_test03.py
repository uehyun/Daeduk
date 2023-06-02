# 출력할 단수를 입력하시오
# 4*1=4
# 4*2=8
# 4*9 = 36

a = input("출력할 단수를 입력하시오.")

res = 0
print("*** {}단 ***".format(a))

for i in range(1,9+1):
    res = int(a)* i
    print("{} * {} = {}".format(a,i,res))