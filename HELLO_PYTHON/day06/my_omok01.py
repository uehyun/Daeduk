import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from PyQt5.Qt import QIcon
from PyQt5.QtCore import QSize

form_class = uic.loadUiType("./my_omok01.ui")[0]

class MyWindow(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.initUI()
        self.flag_black = True
        
    def myclick(self):
        
        if self.flag_black :
            self.sender().setIcon(QIcon("1.png"))
            self.flag_black = False
        else :
            self.sender().setIcon(QIcon("2.png"))
            self.flag_black = True
        
    def initUI(self):
        # self.statusBar()
        for i in range(10) :
            for j in range(10):
                pb = QPushButton("", self)
                pb.setIcon(QIcon("0.png"))
                pb.setIconSize(QSize(40,40))
                pb.setGeometry(40*j,40*i,40,40)
                pb.clicked.connect(self.myclick)
        
app = QApplication(sys.argv)
myWindow = MyWindow()
myWindow.show()
app.exec_()