# 첫 수를 입력하시오.
# 끝 수를 입력하시오.
# 배수를 입력하시오.
# 1에서 10 까지의 5의 배수 합은 15입니다.

a = input("첫 수를 입력하시오.")
b = input("끝 수를 입력하시오.")
c = input("배수를 입력하시오.")
aa = int(a)
bb = int(b)
cc = int(c)
res = 0;
for i in range(aa, bb+1):
    if i%cc == 0 :
        res += i
        
print("{}에서 {}까지의 {}의 배수 합은 {}입니다.".format(a,b,c,res))