import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("./pyqt10.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        
    def getStar(self,cnt):
        res = ""
        for i in range(cnt) :
            res += "*"
        
        res += "\n"
        return res
        
    def myclick(self):
        a = self.le_first.text()
        b = self.le_last.text()
        res=""
        
        for i in range(int(a), int(b)+1) :
            res += self.getStar(i)
        
        self.te.setText(res)
        
    
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()