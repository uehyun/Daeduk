class Animal :
    def __init__(self):
        self.age = 1
    
    def birthHappy(self) :
        self.age += 1 
    
if __name__ == '__main__':
    ani = Animal()
    print(ani.age)
    ani.birthHappy()
    print(ani.age)