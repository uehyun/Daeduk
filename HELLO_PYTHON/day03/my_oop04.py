class LeeJY:
    def __init__(self):
        self.cnt_company = 20
        
    def seat(self):
        self.cnt_company += 1
        
class Bin:
    def __init__(self):
        self.amount_oil = 1000
    
    def dig(self):
        self.amount_oil *= 2
        
class KimJeungUn:
    def __init__(self):
        self.cnt_nuclear = 30
        
    def aoji(self):
        self.cnt_nuclear += 2
        
class KimJiWan(LeeJY, Bin, KimJeungUn):
    def __init__(self):
        LeeJY.__init__(self)
        Bin.__init__(self)
        KimJeungUn.__init__(self)
        
if __name__ == '__main__':
    kim = KimJiWan()
    print(kim.cnt_company)
    print(kim.amount_oil)
    print(kim.cnt_nuclear)
    kim.aoji()
    kim.dig()
    kim.seat()
    print(kim.cnt_company)
    print(kim.amount_oil)
    print(kim.cnt_nuclear)
