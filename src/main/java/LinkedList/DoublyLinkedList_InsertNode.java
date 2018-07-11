package LinkedList;


public class DoublyLinkedList_InsertNode {
	
	Node Insert(Node head,int data) {  
		if(head == null) {
			head = new Node();
			head.data = data;
			head.prev = null;
			head.next = null;
		} else {
			Node itr = new Node();
			itr = head;
			Node before = new Node();
			Node after = new Node();
			
			while(itr != null && itr.data < data) {
				itr = itr.next;
			}
			if(itr != null) {
				before = itr.prev;
				after = itr;
				Node inserted = new Node();
				inserted.data = data;
				before.next = inserted;
				inserted.next = after;
				inserted.prev = before;
				after.prev = inserted;
			} else {
				Node inserted = new Node();
				inserted.data = data;
				
				Node itr2 = new Node();
				itr2 = head;
				Node lastNode = new Node();
				while(itr2 != null && itr2.next != null) {
					lastNode = itr2.next;
					itr2 = itr2.next;
				}
				if(itr2.prev ==null && itr2.next == null) {
					lastNode = head;
				}
				lastNode.next = inserted;
				inserted.prev = lastNode;
				inserted.next = null;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		DoublyLinkedList_InsertNode ex = new DoublyLinkedList_InsertNode();
		Node n1 = new Node();
		n1.data = 1;
		Node n2 = new Node();
		n2.data = 2;
		Node n3 = new Node();
		n3.data = 5;
		n1.prev = null;
		n1.next = n2;
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		n3.next = null;
		
		Node m1 = new Node();
		m1.data = 1;
		m1.prev = null;
		m1.next = null;
		
		Node print = ex.Insert(m1, 6);
		while(print.next != null) {
			System.out.print(print.data+"--> ");
			print = print.next;
		}
		System.out.print(print.data+ " --> null") ;
	}

}

class Node {
    int data;
    Node next;
    Node prev;
 }
