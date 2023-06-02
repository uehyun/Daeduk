import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("./pyqt09.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb1.clicked.connect(self.myclick)
        self.pb2.clicked.connect(self.myclick)
        self.pb3.clicked.connect(self.myclick)
        self.pb4.clicked.connect(self.myclick)
        self.pb5.clicked.connect(self.myclick)
        self.pb6.clicked.connect(self.myclick)
        self.pb7.clicked.connect(self.myclick)
        self.pb8.clicked.connect(self.myclick)
        self.pb9.clicked.connect(self.myclick)
        self.pb0.clicked.connect(self.myclick)
        self.pbCall.clicked.connect(self.callclick)
    
        
    def myclick(self):
        a = self.sender().text()
        b = self.le.text()
        
        self.le.setText(b + a)

    def callclick(self):
        a = self.le.text()
        res = "CALLING\n" + a
        QMessageBox.about(self,'전화왔어용', res)
        # QCloseEvent.accept()


            
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()