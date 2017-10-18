package detectcycle;

/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

/*

A linked list is said to contain a cycle if any node is visited more than once while traversing the list.

Complete the function provided in the editor below. It has one parameter: a pointer to a Node object named that points to the head of a linked list. Your function must return a boolean denoting whether or not there is a cycle in the list. If there is a cycle, return true; otherwise, return false.

Note: If the list is empty, will be null.

Input Format

Our hidden code checker passes the appropriate argument to your function. You are not responsible for reading any input from stdin.

Output Format

If the list contains a cycle, your function must return true. If the list does not contain a cycle, it must return false. The binary integer corresponding to the boolean value returned by your function is printed to stdout by our hidden code checker.

Explanation

    1.The first list has no cycle, so we return false and the hidden code checker prints to stdout.
    2.The second list has a cycle, so we return true and the hidden code checker prints to stdout.


*/

public class DetectCycle {
	
    static Node head;
    
    static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
   
    public static void push(int newData)
    {
        Node newNode = new Node(newData);
   
        newNode.next = head;
        head = newNode;
    }
	
	public static void main(String[] args) {
	
		DetectCycle.push(1);
		DetectCycle.push(2);
		DetectCycle.push(3);
          
		DetectCycle.head.next.next.next = DetectCycle.head;
  
        if (hasCycle(head))
        {
            System.out.println("Loop found");
        }
        else
        {
            System.out.println("No Loop");
        }
	}
	
	static boolean hasCycle(Node head) {
	
	    if( head == null) {
	        return false;
	    }
	    
	    Node slow;
	    Node fast;
	    
	    slow = fast = head;
	    
	    while (slow != null && fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	        
	        if(slow == fast) {
	            return true;
	        }
	    }
	    
	    return false;
	}
}
