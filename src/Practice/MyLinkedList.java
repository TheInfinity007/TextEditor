package Practice;

public class MyLinkedList <E>{

	private ListNode <E> head;
	private ListNode <E> tail;
	private int size;
	
	MyLinkedList(){
		size = 0;
		head = new ListNode<E>(null);
		tail = new ListNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}
	
	public int size() {
		return this.size;
	}
	
	public void get() {
//		return head;
	}
	
	public void set() {
		
	}
	
	public void add(E data) {				//Add at front
		ListNode<E> node = new ListNode<E>(data);
		node.next = head.next;
		node.prev = head;
		node.next.prev = node;
		head.next = node;
		this.size++;
	}
	
	public void remove() {
		
	}

	public static void main(String[] args) {
		MyLinkedList<Integer> mylist = new MyLinkedList<Integer>();
		System.out.println(mylist);
		System.out.println(mylist.head + " | " + mylist.tail + " | " + mylist.size());
		mylist.add(2);
		System.out.println(mylist);
		System.out.println(mylist.head.next.data + " | " + mylist.tail + " | " + mylist.size());
		mylist.add(1);
		System.out.println(mylist.head.next.data + " | " + mylist.tail + " | " + mylist.size());
		System.out.println(mylist.head.next.next.data + " | " + mylist.tail + " | " + mylist.size());
	}

}
