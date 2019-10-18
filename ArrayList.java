public class ArrayList<T> implements List<T>
{
	private T[] a;
	private int size;

	//Creates a new ArrayList using the constructor
	public ArrayList()
	{
		a = (T[]) new Object[10];
        size = 0; //Sets the size to 0
	}
	
	//Grows the ArrayList to allow for more values
	public void grow_array()
	{
		//"Grows" the ArrayList by two times the original size
		T[] arr = (T[]) new Object[a.length * 2];
		//Uses java.lang.System class to copy an array
        System.arraycopy(a, 0, arr, 0, a.length);
		a = arr;
	}
	
	//Adds an item to the ArrayList
	public void add(T item)
	{
		//Increases the ArrayList size using a method if it is full 
		if(size == a.length)
        {
            grow_array();
        }

        a[size++] = item;
	}

	//Adds an item to the ArrayList at a specific position
	public void add(int pos, T item)
	{
		if (size == a.length)
        {
            grow_array();
        }

		//Creates space by shifting elements to the right
        for(int i = size - 1; i > pos; i--)
        {
            a[i + 1] = a[i];
        }

        a[pos] = item;
        size++;
	}

	//Returns the value at the specified position
	public T get(int pos)
	{
		return a[pos];
	}

	//Removes an item from the ArrayList and returns it
	public T remove(int pos)
	{
		T temp = a[pos];

		//Does the opposite of add and shifts elements to the left
        for(int i = pos; i < size - 1; i++)
        {
            a[i] = a[i + 1];
        }

        --size;
        
		return temp;
	}

	//Returns the size
	public int size()
	{
		return size;	
	}
}