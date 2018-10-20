import java.io.*;

class heap1
{
	public static void main(String args[]) throws IOException
	{
		
		File file = new File("stringsin.txt");
 
 		BufferedReader in = new BufferedReader(new FileReader(file));
		String st=in.readLine();
		

		String A[] = st.split(" ");

		heap1 ob =new heap1();
		ob.BuildMinHeap(A);
		int i;
		
		FileWriter out = new FileWriter(new File("stringsout.txt"));
		for(i=0;i<A.length;i++)
		{
			out.write(A[i]+" ");
		}
		out.close();
	}
	int left(int i)
	{
		return (2*i+1);
	}
	int right(int i)
	{
		return (2*i+2);
	}
	int parent(int i)
	{
		return (2*i);
	}
	void BuildMinHeap(String A[])
	{

		for(int i=(A.length)/2-1;i>=0;i--)
		{
			minHeapify(A,i);
		}
	}
	void minHeapify(String A[], int i)
	{
		int l,r,small;
		l=left(i);
		r=right(i);
		if(l<A.length && A[l].compareTo(A[i])<0)
			small = l;
		else
			small=i;
		if(r<A.length && A[r].compareTo(A[small])<0)
			small = r;
		if(small!=i)
		{
			 String temp = A[i];
    	A[i]= A[small];
    	A[small] = temp;
			
			minHeapify(A,small);
		}
	}
}
