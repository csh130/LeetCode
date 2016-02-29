package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ImplementingQueue {

}

class MyQueue {
	List<Integer> s = new ArrayList<Integer>();
	int first = 0;

	// Push element x to the back of queue.
	public void push(int x) {
		s.add(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		s.remove(first);
		first++;
	}

	// Get the front element.
	public int peek() {
		return s.get(first);
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return s.isEmpty();
	}
}

/**
 * 用两个 stack 来倒序存储, push 一个 颠倒顺序再存.
 * */
class MyQueue2 {
	Stack<Integer> queue = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		Stack<Integer> temp = new Stack<Integer>();
		while (!queue.empty()) {
			temp.push(queue.pop());
		}
		queue.push(x);
		while (!temp.empty()) {
			queue.push(temp.pop());
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		queue.pop();
	}

	// Get the front element.
	public int peek() {
		return queue.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return queue.empty();
	}
}