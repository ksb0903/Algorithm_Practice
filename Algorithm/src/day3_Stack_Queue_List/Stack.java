package day3_Stack_Queue_List;

public class Stack {
	private Node top;
	
	public void push(String data) {
		top = new Node(data, top);
	}
	
	public String pop() {
		if(isEmpty()) return null;
		
		Node popNode = top;
		top = popNode.link;
		
		popNode.link = null;
		return popNode.data;
	}
	
	public boolean isEmpty() {
		return top.link == null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Node cur=top; cur!=null; cur=cur.link) {
			sb.append(cur.data + " ");
		}
		if(!isEmpty()) sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
}
