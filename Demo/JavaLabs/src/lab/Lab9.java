package lab;

public class Lab9 {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add("sfg");
		ll.add("hh");
		ll.add("nshr");
		ll.add("ewrwe");
		ll.add("gegas");
		
		System.out.println(ll);
		ll.del(3);
		System.out.println(ll);
		ll.del(3);
		System.out.println(ll);
		ll.del(3);
		System.out.println(ll);
		ll.del(3);
		System.out.println(ll);
		ll.add("test1");
		ll.add("test2");
		System.out.println(ll);
	
	}
}

class LinkedList {
	Node startNode;
	Node endNode;
	int length;
	public void add(String value) {
		if (startNode == null){
			startNode = endNode = new Node(value);
			length++;
		}
		else{
			Node newNode = new Node(value);
			endNode.setNext(newNode);
			endNode = newNode;
			length++;
		}
	}
	public String get(int i){
		if(i > length || i < 1){
			return null;
		}else{
			Node n = startNode;
			for(int j = 1; j < i; j++){
				n = n.getNext();
			}
			return n.getValue();
		}
	}
	public void del(int i){
		if(i > length || i < 1){
			return;
		}else{
			Node n = startNode;
			for(int j = 1; j < i - 1; j++){
				n = n.getNext();
			}
			if(n.getNext() == endNode){
				endNode = n;
			}
			n.setNext(n.getNext().getNext());
			length--;
		}
	}
	public String toString(){
		String str = "";
		Node n = startNode;
		while(n != null){
			str += n.getValue() + " -> ";
			n = n.getNext();
		}
		if(!"".equals(str)){
			str = str.substring(0, str.length() - 4);
		}
		return str;
	}
}

class Node {
	private String value;
	private Node next;
	public Node(){}
	public Node(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

}