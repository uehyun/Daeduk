import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("./pyqt03.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        
    def myclick(self):
        a = self.le1.text()
        b = self.le2.text()
        res = int(a) - int(b)
        self.le3.setText(str(res))

            
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()