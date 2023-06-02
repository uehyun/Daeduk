import pymysql
conn = pymysql.connect(host='127.0.0.1',port=3305,user='root',password='python',db='python',charset='utf8')

sql = "insert into emp values ('3','3','3','3')"

cur = conn.cursor()
cur.execute(sql)

cur.close()
conn.commit()
conn.close()