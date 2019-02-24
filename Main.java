package ThreadMul;

class Main { 
    public static int [][] a = {{1, 1, 1},
				{1, 1, 1},
				{1, 1, 1}};
    
    public static int [][] b = {{1 ,1},
				{1,1 },
				{1 ,1}};
          public static int Nrows=a.length;
          public static int Ncols=b[0].length;

    public static void print_matrix(int [][] a) {
	for(int i=0; i < a.length; i++) {
	    for(int j=0; j< a[i].length; j++) 
		System.out.print(a[i][j] + " "); 
	    System.out.println();
	}
    }
    

    public static void main(String [] args) { 

	
	for(int i=0;i<a.length;i++){
	Thread thread=new Thread(new Matrix(a[i],b,i));
	thread.start();
	}
	
	
	//System.out.println(Matrix.c.length);
print_matrix(Matrix.c);
	
	}
}
