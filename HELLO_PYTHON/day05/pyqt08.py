import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("./pyqt08.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
    
        
    def myclick(self):
        a = self.le.text()
        res = "*** {}단 ***\n".format(a)
        
        for i in range(1,9+1) :
            res += "{} * {} = {}\n".format(a,i,int(a)*i)
        
        self.pte.setPlainText(res)
        self.le.setText("")

            
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()