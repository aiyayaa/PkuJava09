package test232;

import java.util.Stack;

//		solution 1 
class MyQueue {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}

//		solution 2 silly 
class MyQueue1 {

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    public void push(int x) {
      while (!s2.isEmpty())
        s1.push(s2.pop());

      s1.push(x);
    }

    public void pop() {
      while (!s1.isEmpty())
        s2.push(s1.pop());
      
      s2.pop();
    }

    public int peek() {
      while (!s1.isEmpty())
        s2.push(s1.pop());

      return s2.peek();
    }

    public boolean empty() {
      return s1.isEmpty() && s2.isEmpty();
    }
}