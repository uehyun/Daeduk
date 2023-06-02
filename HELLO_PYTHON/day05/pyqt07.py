import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("./pyqt07.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
    
        
    def myclick(self):
        a = self.le1.text()
        b = self.le2.text()
        c = self.le3.text()
        res = 0
        
        for i in range(int(a),int(b)+1) :
            if i%int(c) == 0 :
                res += i
        
        self.le4.setText(str(res))

            
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()