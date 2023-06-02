import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from PyQt5.Qt import QIcon
from PyQt5.QtCore import QSize
from Cython.Compiler.Naming import self_cname

form_class = uic.loadUiType("./my_omok02.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.arr2D=[
            [0,0,0,0,0, 0,0,0,0,0],
            [0,0,0,0,0, 0,0,0,0,0],
            [0,0,0,0,0, 0,0,0,0,0],
            [0,0,0,0,0, 0,0,0,0,0],
            [0,0,0,0,0, 0,0,0,0,0],
            
            [0,0,0,0,0, 0,0,0,0,0],
            [0,0,0,0,0, 0,0,0,0,0],
            [0,0,0,0,0, 0,0,0,0,0],
            [0,0,0,0,0, 0,0,0,0,0],
            [0,0,0,0,0, 0,0,0,0,0]
            
        ]
        self.pbs = []
        # self.pb2D = []
        self.initUI()
        self.flag_over = False
        self.flag_black = True
        self.resetPb.clicked.connect(self.reset)
        self.myrender()
        
    def myclick(self):
        if self.flag_over :
            return
        
        a = self.sender().toolTip().split(",")[0]
        b = self.sender().toolTip().split(",")[1]
        i = int(a)
        j = int(b)
        
        if self.arr2D[int(a)][int(b)] != 0 :
            return
        
        stone = -1
        
        if self.flag_black :
            self.arr2D[i][j] = 1
            stone = 1
        else :
            self.arr2D[i][j] = 2
            stone = 2
            
        up = self.checkUP(i,j,stone)
        dw = self.checkDown(i,j,stone)
        le = self.checkLE(i,j,stone)
        ri = self.checkRI(i,j,stone)
        ul = self.checkUL(i,j,stone)
        dr = self.checkDR(i,j,stone)
        ur = self.checkUR(i,j,stone)
        dl = self.checkDL(i,j,stone)
        
        if self.flag_black :
            stone = "흑돌"
        else : 
            stone = "백돌"
            
        self.myrender()
        
         
        if up + dw == 4 or le + ri == 4 or ul + dr == 4 or ur + dl == 4 :
            self.flag_over = True
            QMessageBox.about(self,'오목', stone +' 승리')
            # self.reset()
            
        self.flag_black = not self.flag_black
        
    def checkDL(self,i,j,stone):
        cnt = 0
        try:
            while True:
                j -= 1
                i += 1
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :  
                    cnt += 1
                else :
                    return cnt
        except:
            return cnt
        
    def checkUR(self,i,j,stone):
        cnt = 0
        try:
            while True:
                j += 1
                i -= 1
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :  
                    cnt += 1
                else :
                    return cnt
        except:
            return cnt
        
    def checkDR(self,i,j,stone):
        cnt = 0
        try:
            while True:
                j += 1
                i += 1
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :  
                    cnt += 1
                else :
                    return cnt
        except:
            return cnt
        
    def checkUL(self,i,j,stone):
        cnt = 0
        try:
            while True:
                j -= 1
                i -= 1
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :  
                    cnt += 1
                else :
                    return cnt
        except:
            return cnt
        
    def checkRI(self,i,j,stone):
        cnt = 0
        try:
            while True:
                j += 1
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :  
                    cnt += 1
                else :
                    return cnt
        except:
            return cnt
        
    def checkLE(self,i,j,stone):
        cnt = 0
        try:
            while True:
                j -= 1
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :  
                    cnt += 1
                else :
                    return cnt
        except:
            return cnt
        
    def checkUP(self,i,j,stone):
        cnt = 0
        try:
            while True:
                i -= 1
                if i < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :  
                    cnt += 1
                else :
                    return cnt
        except:
            return cnt
        
    def checkDown(self,i,j,stone):
        cnt = 0
        try:
            while True:
                i += 1
                if i < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :  
                    cnt += 1
                else :
                    return cnt
        except:
            return cnt
    
    def myrender(self):
        for i in range(10):
            for j in range(10):
                if self.arr2D[i][j] == 1:
                    self.pbs[10*i+j].setIcon(QIcon("1.png"))
                elif self.arr2D[i][j] == 2:
                    self.pbs[10*i+j].setIcon(QIcon("2.png"))
                else : 
                    self.pbs[10*i+j].setIcon(QIcon("0.png"))
        
        
    def initUI(self):
        # self.statusBar()
        for i in range(10) :
            # line = []
            for j in range(10):
                pb = QPushButton("", self)
                pb.setToolTip("{},{}".format(i,j))
                pb.setIcon(QIcon("0.png"))
                pb.setIconSize(QSize(40,40))
                pb.setGeometry(40*j,40*i,40,40)
                pb.clicked.connect(self.myclick)
                self.pbs.append(pb)
                # line.append(pb)
            # self.pb2D.append(line)
            
    def reset(self):
        for i in range(10) :
            for j in range(10) :
                self.arr2D[i][j] = 0
        self.myrender()
        self.flag_over = False
        self.flag_black = True
        
        
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()