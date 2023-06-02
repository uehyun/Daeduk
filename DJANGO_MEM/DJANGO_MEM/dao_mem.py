import pymysql

class DaoMem :
    def __init__(self):
        self.conn = pymysql.connect(host='127.0.0.1',port=3305,user='root',password='python',db='python',charset='utf8')
        self.curs = self.conn.cursor(pymysql.cursors.DictCursor)
        
    def delete(self, m_id):
        sql = f"""
            delete from
                mem
            where
                m_id = '{m_id}'
        """
        
        self.curs.execute(sql)
        cnt = self.curs.rowcount
        self.conn.commit()
        return cnt
        
    def update(self, m_id, m_name, tel, address):
        sql = f"""
            update
                mem
            set
                m_name = '{m_name}', tel = '{tel}', address = '{address}'
            where
                m_id = '{m_id}'
        """
        
        self.curs.execute(sql)
        cnt = self.curs.rowcount
        self.conn.commit()
        return cnt
        
    def insert(self, m_id, m_name, tel, address):
        sql = f"""
            insert into 
                mem
            (m_id, m_name, tel, address)
                values
            ({m_id}, {m_name}, {tel}, {address})
        """
        self.curs.execute(sql)
        cnt = self.curs.rowcount
        self.conn.commit()
        return cnt
    
        
    def selectOne(self, cnt):
        m_id = cnt
        sql = f"""
            select 
                m_id, m_name, tel, address
            from 
                mem
            where 
                m_id = '{m_id}'
        """
        self.curs.execute(sql)
        
        obj = self.curs.fetchone()
        return obj
    
    def selectList(self) :
        sql = "select * from mem"
        self.curs.execute(sql)
        
        list = self.curs.fetchall()
        return list
    
    def __del__(self):
        self.curs.close()
        self.conn.close()
