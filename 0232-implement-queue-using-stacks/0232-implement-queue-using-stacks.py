class MyQueue:

    def __init__(self):
        self.fill = []
        self.mem = []

    def push(self, x: int) -> None:
        self.fill.append(x)

    def pop(self) -> int:
        self.peek()
        return self.mem.pop()

    def peek(self) -> int:
        if not self.mem:  # if empty has no elements
           while self.fill:
                self.mem.append(self.fill.pop())
        return self.mem[-1]

    def empty(self) -> bool:
        if not self.fill and not self.mem:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
