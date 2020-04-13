import java.util.*;
class Node{
	int data;
	Node next;
	Node prev;
	public Node(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}
public class DoublyLinked{
	public static void main(String[] arhs){
		Scanner sc=new Scanner(System.in);
		LinkedList list=new LinkedList();
		System.out.println("Enter the size of LinkedList");
		int n=sc.nextInt();
		for (int i=0;i<n;i++){
			list.create(sc.nextInt());
		}
		list.display();
		System.out.println("Enter the item what do u want to insert");
		list.insert(sc.nextInt(),sc.nextInt(),list.length());
		System.out.println("Enter the item what do u want to delete");
		list.delete(sc.nextInt());
		list.display();
	}
}
class LinkedList{
	Node head;
	Node temp;
	public void create(int data){
		Node node=new Node(data);
		if (head==null){
			head=node;
			temp=head;
		}
		else{
			node.prev=temp;
			temp.next=node;
			temp=node;
		}
	}
	public void display(){
		Node n=head;
		while(n!=null){
			// System.out.println(n.prev);
			System.out.println(n.data);
			// System.out.println(n.next);
			// System.out.println("--------");
			n=n.next;
		}
	}
	public int length(){
		Node n=head;
		int l=0;
		while (n!=null){
			l++;
			n=n.next;
		}
		return l;
	}
	public void insert(int pos,int data,int len){
		Node node=new Node(data);
		Node n=head;
		if (pos==0){
			head.prev=node;
			node.next=head;
			head=node;
		}
		// else if(pos==len){
			// for(int i=0;i<pos-1;i++){
				// n.next=node;
				// node.prev=n;
			// }
		// }
		else{
			for(int i=0;i<pos-1;i++){
				n=n.next;
			}
			node.next=n.next;
			node.prev=n;
			if (n.next!=null)
				n.next.prev=node;
			n.next=node;
		}
	}
	public void delete(int pos){
		Node n=head;
		if (pos==1){
			head=head.next;
			head.prev=null;
		}
		else{
			for(int i=0;i<pos-1;i++){
				n=n.next;
			}
			
			n.prev.next=n.next;
			if(n.next!=null){
			n.next.prev=n.prev;	
			}
		}
	}
}