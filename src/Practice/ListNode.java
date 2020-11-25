package Practice;

class ListNode <E>{
	ListNode <E> prev;
	E data;
	ListNode <E> next;
		
	public ListNode(){
		data = null;
	}
	
	public ListNode(E data){
		this.data = data;
	}
	
	ListNode(E data, ListNode<E> prev, ListNode<E> next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	

}
