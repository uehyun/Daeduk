def gugu(cnt):
    res = "*** {}단 ***\n".format(cnt)
    for i in range(1,9+1):
        res += "{} * {} = {}\n".format(cnt,i,cnt*i)
    
    res += "\n"
    return res


# if __name__ == "__main__":
res = ""
for i in reversed(range(1,9+1)):
    if i == 9 or i==7 or i ==3 or i==2:
        res += gugu(i)

print(res)
        
