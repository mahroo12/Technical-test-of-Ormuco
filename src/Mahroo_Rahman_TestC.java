
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Mahroo_Rahman_TestC {
	
	/*
	 * A Node contains a key and a value. That is why there is a 
	 * constructor of node that takes a value and key.
	 * A Node is linked to its previous node and next node.
	 */
	class Node
	{
		int key;
		int val;
		Node previous;
		Node next;
		Date currentTime;
		
		public Node (int k, int v)
		{
			key = k;
			val = v;
		}
	}
	
	Node head; // This node is the first node in our linked list
	Node tail;// This node is last node in our linked list
	
	Map<Integer, Node> map; // the hash map which is our cache
	

	
	int capacity; // this is the capacity of our cache. i.e how many elements it can store
	int size;// this is the current size of the cache. size<= capacity
	
	public Mahroo_Rahman_TestC(int capacity){
		
		//so our cache is empty
		head = new Node(0,0);
		tail = new Node(0,0);
		
		head.currentTime = new Date();
		tail.currentTime = new Date();
		
		map = new HashMap<>();
		
		//initially the head points only to its next node i.e tail
		head.next= tail; 
		
		
		//initially the tail points only to its previous node i.e head
		tail.previous = head;
		
		this.capacity= capacity;
	
		
		//initially the size is 0
		this.size = 0;
		
	}
	
	/*
	 * if the map contains the key we want then it is
	 * used more than others so we remove it and 
	 * then put it at the front so that
	 * it can be accessed more easily
	 */
	
	public int get(int key)
	{
		if(map.containsKey(key)) 
		{
			Node node = map.get(key);
			removeNode(key);
			addToHead(key, node.val);
			return node.val;
		}
		else 
		{
			return -1;
		}
			
	}

	/*
	 * we want to add a new key so we check if the cache contains
	 * the key already, if it contains the key then we remove it from the list 
	 * and put it at the head.
	 * if 
	 */
	public void put(int key, int value)
	{
		if(map.containsKey(key))
		{
			removeNode(key);
			addToHead(key, value);
			
			
		}
		else
		{
			addToHead(key, value);
		}
	}
	
	
	/*
	 * This function creates a new node then assigns the values of the key and value of the node 
	 * that was most recently used at the head of the list  by making the the next node of this new node
	 * to the head of the current node. Then we update the size of this cache after addition of new node.
	 * We also check if the size while adding this new node has exceeded the cache capacity.
	 * If exceeded the cache capacity then we delete the least recently used key which is the tail of the 
	 * list before adding the  new node. 
	 * 
	 */
	private void addToHead(int key, int val) {
		Node node = new Node(key, val);
		Node next = head.next;
		head.next = node;
		node.next= next;
		node.previous = head;
		size++;
		if(size > capacity)
		{
			Node tail_before_adding_new_node = tail.previous;
			removeNode(tail_before_adding_new_node .key);
		}
		
	}

	/*
	 * this function takes a key and removes it from the list and map and sets 
	 * the next node of current node's previous to its next node.
	 * so that next node basically replace it.
	 */
	public void removeNode(int key)
	{
		Node curr = map.get(key);
		Node prev = curr.previous;
		Node next = curr.next;
		prev.next = next;
		next.previous= prev;
		size--;
		map.remove(key);
	}
	
	/*
	 * We take in a map and time. Time here is time after which the element should expire
	 * So, the difference between the current time and time is the the expired time.
	 * If the element's current time is greater than the expired time then we should remove that element
	 */
	public void removeExpiredElement(Map<Integer, Node> map, int time)
	{
	Date currTime = new Date();	
	Date actualExpiredTime = new Date();
	
	actualExpiredTime.setTime(currTime.getTime()-time);
	
	Iterator<Entry<Integer, Node>> iterator = map.entrySet().iterator();
	while (iterator.hasNext()) {
		Entry<Integer, Node> entry = iterator.next();
		Node expiredElement = entry.getValue();
		if(expiredElement.currentTime.compareTo(actualExpiredTime)<0)
		{
			map.remove(expiredElement.key);
		}



	}
	}
}
