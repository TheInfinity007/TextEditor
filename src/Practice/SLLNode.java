package Practice;

class SLLNode <E> {
	SLLNode <E> next;
	E data;
	
	public SLLNode() {
		this.next = null;
		this.data = null;
	}
	
	public SLLNode(E data) {
		this.data = data;
	}
	
	public SLLNode(E data, SLLNode<E> prevNode) {
		this(data);
		this.next = prevNode.next;
		prevNode.next = this;
	}

	public static void main(String[] args) {
		SLLNode<Integer> n0 = new SLLNode<Integer>();
		SLLNode<Integer> n1 = new SLLNode<Integer>(1, n0);
		SLLNode<Integer> n2 = new SLLNode<Integer>(2, n0);
		

	}

}
