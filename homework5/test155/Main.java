package test155;

import java.util.ArrayList;
import java.util.Stack;

// solution 1  动态数组
class MinStack {
	ArrayList<Integer> stack = new ArrayList<>();

    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
    	int min = Integer.MAX_VALUE;
    	for(int i =0;i<stack.size();++i){
    		if(stack.get(i)<min) min = stack.get(i);
    	}
        return min;
    }
}
// solution 2  栈 错误版，溢出改变
class MinStack1{
	int min;
	Stack<Integer> stack;
	
	public MinStack1(){
		stack = new Stack<>();
	}
	
	public void push(int x){
		if(stack.isEmpty()){
			stack.push(0);
			min = x;
		}
		else{
			stack.push(x-min);
			if(x<min) min=x;
		}
	}
	
	public void pop(){		
		int pop = stack.pop();
		if(pop<0) min = min-pop;
	}
	
	public int top(){
		int top = stack.peek();
		return top>0? top+min:min;
	}
	
	public int getMin(){
		return min;
	}
}
// solution 2 栈 正确版
class MinStack2 {
    long min;
    Stack<Long> stack;

    public MinStack2(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();

        if (pop<0)  min=min-pop;

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}
// solution 2 做死版
class MinStack2_1 {
    private Stack<Long> stack = new Stack<Long>();
    private long min = 0l;
    public void Push(int x){
        stack.push((long)x - (min = stack.size() == 0 ? (long)x : min));
        if ((long)x < min) min = (long)x;
    }
    public void Pop(){
        if(stack.peek() < 0) min -= stack.peek();
        stack.pop();
    }
    public int Top(){
        return stack.peek() < 0 ? (int)min : (int)(min + stack.peek());
    }
    public int GetMin(){
        return (int)min;
    }
}
// solution 3		no AC   time exceeded
class minStack3{
	private Stack<Integer> mStack = new Stack<Integer>();
	private Stack<Integer> mMinStack = new Stack<Integer>();

	public void push(int x) {
	    mStack.push(x);
	    if (mMinStack.size() != 0) {
	        int min = mMinStack.peek();
	        if (x <= min) {
	            mMinStack.push(x);
	        }
	    } else {
	        mMinStack.push(x);
	    }
	}

	public void pop() {
	    int x = mStack.pop();
	    if (mMinStack.size() != 0) {
	        if (x == mMinStack.peek()) {
	            mMinStack.pop();
	        }
	    }
	}

	public int top() {
	    return mStack.peek();
	}

	public int getMin() {
	    return mMinStack.peek();
	}
}
//  solution 4
class minStack4{
	Stack<Integer> Data, Min;

	void push(int x) {
	    Data.push(x);
	    if(Min.empty()||x<Min.peek()) Min.push(x);
	    else Min.push(Min.peek());
	}

	void pop() {
	    if(Data.empty()) return;
	    Data.pop();
	    Min.pop();
	}

	int top() {
	    return Data.peek();
	}

	int getMin() {
	    if(!Min.empty());
	        return Min.peek();
	}
}

//  solution 5 链表
class MinStack5 {
    class Node{
        int value;
        int min;
        Node next;

        Node(int x, int min){
            this.value=x;
            this.min=min;
            next = null;
        }
    }
    Node head;
    public void push(int x) {
        if(null==head){
            head = new Node(x,x);
        }else{
            Node n = new Node(x, Math.min(x,head.min));
            n.next=head;
            head=n;
        }
    }

    public void pop() {
        if(head!=null)
            head =head.next;
    }

    public int top() {
        if(head!=null)
            return head.value;
        return -1;
    }

    public int getMin() {
        if(null!=head)
            return head.min;
        return -1;
    }
}