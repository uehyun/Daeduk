def showDan(a):
    res = 0
    print("*** {}단 ***".format(a))

    for i in range(1,9+1):
        res = int(a)* i
        print("{} * {} = {}".format(a,i,res))


a = input("출력할 단을 입력하세요.")
showDan(a)