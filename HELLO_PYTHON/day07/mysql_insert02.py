import pymysql
conn = pymysql.connect(host='127.0.0.1',port=3305,user='root',password='python',db='python',charset='utf8')

cur = conn.cursor()
# f String
sql = """update emp set e_name = '6', sex = '6', addr = '6' 
            where e_id = 3
    """
cur.execute(sql)
print("cnt", cur.rowcount)

conn.commit()
cur.close()
conn.close()