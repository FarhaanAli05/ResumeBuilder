
  public class LinkedList {
    private int size;
	  private Node head;

	public LinkedList() {
		this.size = 0;
		this.head = null;
	}

/**
 * Inserting new node at the end of the linked list
 * 
 * @param item - represent the node item to be added to the linked list
 */
	public void insertNode(Custom item) {
		Node node = new Node();
		node.item = item;
		Node current = this.head;

		if (this.head == null) {
			this.head = node;
			this.head.next = null;
			this.size = 1;
			System.out.println(this.head.toString());
		} else {

			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
			node.next = null;
			this.size += 1;
		}
	}
	
	/**
	 * Adding node at the first location of the linked list
	 * 
	 * @param item - represent item of the node to be added to LL
	 */
	public void insertFirst(Custom item){
		Node node = new Node();
		node.item = item;
		node.next = this.head;
		this.head = node;
		this.size++;
	}
	
	/**
	 * Adding node at the nth location of the linked list
	 * 
	 * @param item - represent the item of the node to be added to the list
	 * @param position - position at which the node is to be added
	 */
	public void insertNth(Custom item, int position) {
		Node node = new Node();
		node.item = item;
		Node current = this.head;
		if (this.head != null && position <= this.size) {
			for (int i = 1; i < position; i++) {
				current = current.next;
			}
			node.next = current.next;
			current.next = node;
			this.size += 1;
		}else{
			System.out.println("Exceeded the linked list size. Current Size: "+size);
		}
	}

	/**
	 * Deleting the first node from the list
	 */
	public void deleteFirstNode() {
		if(head != null){
			this.head = this.head.next;
			this.size--;
		}else{
			System.out.println("Linked list is empty");
		}
	}

	/**
	 * Deleting the last node from the list
	 */
	public void deleteLastNode() {
		Node currentNode = this.head;
		if(size == 1){
			head = null;
			size = 0;
		}else{
			Node prevNode = null;
			while (currentNode.next != null) {
				prevNode = currentNode;
				currentNode = currentNode.next;
			}
			prevNode.next = null;
			this.size--;
		}
	}

	/**
	 * Deleting the node from the nth location in the list
	 * 
	 * @param position - location of the node to be deleted
	 */
	public void deleteNthNode(int position) {
		if (position <= this.size && this.head != null) {
			Node currentNode = this.head;
			Node prevNode = null;
			for (int i = 0; i < position; i++) {
				prevNode = currentNode;
				currentNode = currentNode.next;
			}
			prevNode.next = currentNode.next;
			this.size--;
		}else{
			System.out.println("No node exist at location: "+position);
		}
	}

	/**
	 * Find if the node exist in the list
	 * 
	 * @param item - item to be found in the list
	 * 
	 */
	public void findNode(String item) {
		Node node = this.head;
		boolean found = false;
		for(int i=0;i<size; i++){
			if(node.item.equals(item)){
				System.out.println("Item "+item+" was found at location "+i+" in the linked list");
				found = true;
			}
			node = node.next;
		}
		
		if(!found)
			System.out.println("Item "+item+" was not found in the Linked list");
	}

	/**
	 * Find the node item located at a specific location
	 * 
	 * @param location - Find item at location
	 * 
	 */
	public void findNodeAt(int location) {
		Node node = this.head;
		if(head !=null && location<= size){
			for(int i=0;i<location;i++){
				node = node.next;
			}
			System.out.println("Node item at location "+location+" is "+node.item);
		}
	}

	/**
	 * Find the item at the last location
	 * 
	 */
	public void findLastNode() {
		Node node = this.head;
		if(head != null){
			for(int i=0;i<size-1;i++){
				node = node.next;
			}
			System.out.println("Node item at last location is "+node.item);
		}
	}


	/**
	 * Printing all the items in the list
	 */
	public void printNodes() {
		if (this.size < 1)
			System.out.println("There are no nodes in the linked list");
		else {
			Node current = this.head;
			for (int i = 0; i < this.size; i++) {
				System.out.println("Node " + current.item + " is at location " + i);
				current = current.next;
			}
		}
	}
	
	/**
	 * Obtain the current size of the list
	 * @return
	 */
	public int getListSize(){
		return size;
	}
	  public class Node {
		  	public Custom item;
		  	public Node next;
		  }
}