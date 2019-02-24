package ThreadMul;

public class Matrix extends Thread { 

   
	public static int [][] c=new int [Main.Nrows][Main.Ncols];//answer

    /* You might need other variables as well */
	
    private int row[];//for keep each row sent from the matrix
    private int rowNum;
    private int SecondArray[][];
//lets take row and a column for this
    public  Matrix(int x[],int y[][] ,int z) { // need to change this, might need some information 
    	this.row=x;
    	this.rowNum=z;
    	this.SecondArray=y;
    	
    	
    	    }
    
    
    
    
    
    	public void run(){
    		int i, j;
        	for(i=0; i<SecondArray[0].length; i++) {
        		int s=0;
        	    for(j=0; j<row.length; j++) {
        		 
        		    s += row[j] * SecondArray[j][i];
        		c[rowNum][i] = s;
        	    }
        	}
    	}
    

}
