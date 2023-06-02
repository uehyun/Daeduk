import pymysql
conn = pymysql.connect(host='127.0.0.1',port=3305,user='root',password='python',db='python',charset='utf8')

cur = conn.cursor()

sql = """
        delete from emp where e_id = '3'
    """
cur.execute(sql)
print("cnt", cur.rowcount)

cur.close()
conn.commit()
conn.close()