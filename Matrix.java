

public class Matrix extends Thread { 

    private static int [][] a; 
    private static int [][] b; 
    
    private static int [][] c; 
    

    /* You might need other variables as well */
private int row;
    public Matrix(int row) {
		// need to change this, might need some information
this.row=row;		
    }
public Matrix (int a[][],int b[][]){
	this.a=a;
	this.b=b;
	 int x=a.length;
    int  y=b[0].length;
   
    //Create an array for depending on the given input matrices
    c=new int [x][y];
}
/*Question 3.
 * The work that should be done by each and every thread is that
 * Each thread should calculate one raw  
 * in the output matrix namely c*/

public void run(){
		for (int i=0;i<b[0].length;i++){
			for(int j=0;j<a.length;j++){
		                   //System.out.println("loop");
		c[row][i] = c[row][i] + a[row][j] * b[j][i]; 
	}
	}
}

    public static int [][] multiply(int [][] a, int [][] b) {

	/* check if multipication can be done, if not 
	 * return null 
	 * allocate required memory 
	 * return a * b
	 */
Matrix aa=new Matrix(a,b);
	int x = a.length; 
	int y = b[0].length; 

	int z1 = a[0].length; 
	int z2 = b.length; 

	if(z1 != z2) { 
	    System.out.println("Cannnot multiply");
	    return null;
	}

	
	/*Question 1.Create  array of Matrix.
	 * For each raw in the Answer matrix we should create a thread.
	 * And then find each raw in the answer matrix.
	 * After finding the each raw join the threads and call the print function.
	 * */
	
	Matrix [] threads = new Matrix[x]; 
	
	/*
	 * Question 2. In lab task we have given 3*3 and a 3*1 matrix.
	 * Therefore there are Threads created for each and every raw that
	 * should be in the Output matrix.
	 * */
	
	for(int i=0; i < x; i++) {
	    threads[i] = new Matrix(i); 
	    threads[i].start();
	}
/*
Question 4.
Synchronization is done by joining the threads.
That means wating till all the threds have completed there tasks.
*/
	for(int i=0; i < x; i++) { 
	    try { 
		threads[i].join();
	    } catch (InterruptedException e) { 
		System.out.println("Not good");
	    }
	}

	return c; 
    }

}