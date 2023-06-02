import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from random import random

form_class = uic.loadUiType("./pyqt11.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.com = self.shuffle()
        self.pb.clicked.connect(self.myclick)
        
        
    def myclick(self):
        a = self.le.text()
        aa = int(a)
        strike = 0
        ball = 0
        arr = []
        arr.append(int(aa/100))
        arr.append(int(aa%100/10))
        arr.append(aa%10)
        if(aa>999 or arr[0] == arr[1] or arr[0] == arr[2] or arr[1] == arr[2]) :
            QMessageBox.about(self,'경고', '다시 입력해주세요')
            self.le.setText("")
            return
            
        if arr[0] == self.com[0]:
            strike = strike + 1
        if arr[1] == self.com[1]:
            strike = strike + 1
        if arr[2] == self.com[2]:
            strike = strike + 1
            
        if(arr[0] == self.com[1] or arr[0] == self.com[2]) :
            ball = ball + 1
        if(arr[1] == self.com[0] or arr[1] == self.com[2]) :
            ball = ball + 1
        if(arr[2] == self.com[1] or arr[2] == self.com[0]) :
            ball = ball + 1
        
        res = "{}S  {}B\n".format(strike,ball)
        b = self.pte.toPlainText()
        self.pte.setPlainText(b+res)
        self.le.setText("")
        if(strike == 3):
            QMessageBox.about(self,'승리', res + '맞췄습니다.')
            # return
    
    def shuffle(self):
        com = [1,2,3,4,5,6,7,8,9]
        for i in range(1,40):
            rnd = int(random()*9)
            a = com[rnd]
            b = com[0]
            com[0]=a
            com[rnd]=b
    
        return com
    
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()