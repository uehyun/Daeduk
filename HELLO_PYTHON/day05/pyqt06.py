import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from random import random

form_class = uic.loadUiType("./pyqt06.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.leMe.returnPressed.connect(self.myclick)
        
    def myclick(self):
        rnd = random();
        a = self.leMe.text()
        
        if rnd> 0.5 :
            com = "홀"
        else : 
            com = "짝"
            
        if com == a :
            res = "정답"
        else :
            res = "실패"
            
        
        self.leCom.setText(com)
        self.leResult.setText(res)


            
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()