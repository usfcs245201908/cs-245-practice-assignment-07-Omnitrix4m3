public class LinkedList<T> implements List<T>
{
	Node<T> head;
	int size;

	class Node<T>
	{
		private T data;
        private Node<T> next;
        
        public Node(T item)
        {
            data = item;
            next = null;
        }

        //Returns the data for that node
		public T getData()
        {
            return data;
        }

		//Assigns an item as the data
        public void setData(T item)
        {
            data = item;
        }

        //Returns the size
		public int getSize()
        {
            return size;
        }

        //Returns what follows the Node
		public Node<T> getNext()
        {
            return next;
        }

        //Sets the following Node
		public void setNext(Node<T> n)
        {
            next = n;
        }
	}

	//Creates a new LinkedList using the constructor
	public LinkedList()
	{
		head = null;
		size = 0; //Sets the size to 0
	}
	
	//Adds an item to the LinkedList
	public void add(T item)
	{
		Node<T> n = new Node<T>(item);
        
		//Adds the item to the head if the LinkedList is null
		if (head == null)
        {
            head = n;
        }
		
        else
        {
            Node<T> previousNode = head;

			//Goes through the entire list until it reaches the end
            while (previousNode.getNext() != null)
            {
                previousNode = previousNode.getNext();
            }
			
			//Sets the next Node to n
            previousNode.setNext(n);
        }
        
		++size;
	}

	//Adds an item to the LinkedList at a specific position
	public void add(int pos, T item)
	{
		Node<T> n = new Node<T>(item);

		//Sets the next Node as the head based on the position
        if (pos == 0)
        {
            n.setNext(head);
            head = n;
        }

        else
        {
            //Sets the previous Node as the head
			Node<T> previousNode = head;
            
			//Goes through the LinkedList until it reaches the specified position
			for (int i = 0; i < pos - 1; i++)
            {
                previousNode = previousNode.getNext();
            }

			//Node arithmetic so that the previous Node's next Node is the current Node's next Node
            n.setNext(previousNode.getNext());
            previousNode.setNext(n);
        }

        ++size;
	}

	//Returns the value at the specified position
	public T get(int pos)
	{
		//Returns if located at the head
		if (pos == 0)
        {
            return head.getData();
        }
		
        else
        {
            Node<T> previousNode = head;
			
			//Goes through the LinkedList to find the anterior node
            for (int i = 0; i < pos - 1; i++)
            {
                previousNode = previousNode.getNext();
            }
            
			//Uses Node arithmetic to return the next item of the anterior Node
			return previousNode.getNext().getData();
        }
	}

	//Removes an item from the LinkedList and returns it
	public T remove(int pos)
	{
		//Returns if located at the head and then sets the next item as the head
		if (pos == 0)
        {
            Node<T> n = head;
            head = head.getNext();
            
			--size;
            
			return n.getData();
        }
		
        else
        {
            Node<T> previousNode = head;

			//Goes through the LinkedList to to find the anterior node
            for (int i = 0; i < pos - 1; i++)
            {	
                previousNode = previousNode.getNext();
            }
            
			//Uses Node arithmetic to set the next as the next item's next
			Node<T> n = previousNode.getNext();
			previousNode.setNext(n.getNext());
            
			--size;
            
			return n.getData();
        }
	}

	//Returns the size
	public int size()
	{
		return size;
	}
}