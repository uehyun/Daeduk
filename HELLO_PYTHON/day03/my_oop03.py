from day03.my_oop01 import Animal
class Human(Animal):
    
    def __init__(self):
        self.tools = []
        self.tools.append("반지")
        super().__init__()
        
    def farming(self, tool):
        self.tools.append(tool)
        
    def __str__(self):
        ret = str(self.tools)
        return ret
    
if __name__ == '__main__':
    human = Human()
    print(human.age)
    print(human.tools)
    human.birthHappy()
    human.farming("샷건")
    print(human.age)
    print(human.tools)
    