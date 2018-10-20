class MinHeap
{
    
    int size;
    int[] Heap;
    int maxsize;
 
     MinHeap(int maxsize)
    {
        
        size = 0;
        Heap = new int[maxsize + 1];
        Heap[0] = 0;
    }
 
   int parent(int i)
    {
        return i;
    }
 
   int left(int i)
    {
        return (2 * i)+1;
    }
 
    int right(int i)
    {
        return (2 * i) + 2;
    }
 
 
    void swap(int f, int s)
    {
        int tmp;
        tmp = Heap[f];
        Heap[f] = Heap[s];
        Heap[s] = tmp;
    }
    void minHeapify( int i)
    {
        int l,r,small;
        l=left(i);
        r=right(i);
        if(l<size && Heap[l]<Heap[i])
            small = l;
        else
            small=i;
        if(r<size && Heap[r]<Heap[small])
            small = r;
        if(small!=i)
        {
             int temp = Heap[i];
        Heap[i]= Heap[small];
        Heap[small] = temp;
            
            minHeapify(small);
        }
    }
 
    public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)])
        {
            swap(current,parent(current));
            current = parent(current);
        }	
    }
 
    public void print()
    {
        for (int i = 1; i <= (size / 2); i++ )
        {
            System.out.print(" PARENT : " + parent(i) + " LEFT CHILD : " + Heap[left(i)]
                + " RIGHT CHILD :" + Heap[right(i)]);
            System.out.println();
        } 
    }
 
    public void BuildminHeap()
    {
        for (int i= (size / 2); i >= 0 ; i--)
        {
            minHeapify(i);
        }
    }
 
    public static void main(String...arg)
    {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.BuildminHeap();
 
        minHeap.print();
    }
}