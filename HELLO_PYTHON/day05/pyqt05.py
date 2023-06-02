import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from random import random

form_class = uic.loadUiType("./pyqt05.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        
    def myclick(self):
        lotto = list(range(1,45+1))

        for i in lotto:
            rnd = int(random()*45)
            a = lotto[rnd]
            b = lotto[0]
            lotto[0]=a
            lotto[rnd]=b
            
        self.te1.setText(str(lotto[0]))
        self.te2.setText(str(lotto[1]))
        self.te3.setText(str(lotto[2]))
        self.te4.setText(str(lotto[3]))
        self.te5.setText(str(lotto[4]))
        self.te6.setText(str(lotto[5]))

            
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()