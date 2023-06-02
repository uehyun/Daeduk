import pymysql
conn = pymysql.connect(host='127.0.0.1',port=3305,user='root',password='python',db='python',charset='utf8')

sql = "select * from emp"

with conn:
    with conn.cursor() as cur:
        cur.execute(sql)
        result = cur.fetchall()
        for data in result:
            print(data)

cur.close()
conn.close()