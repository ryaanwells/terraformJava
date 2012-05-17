import java.util.Random;
import java.lang.StringBuilder;

public class map{
    private int[][] terrain;
    private int size = 10;
    map(){
	Random randomGenerator = new Random();
	terrain = new int[size][size];
	for(int i=0; i<size; i++){
	    for(int j=0; j<size; j++){
		terrain[i][j] =(int) randomGenerator.nextInt(5);
	    }
	}
    }
    map(String p){
	terrain = new int[size][size];
	for(int i=0; i<size; i++){
	    for(int j=0; j<size; j++){
		terrain[i][j] = 1;
	    }
	}
    }
    map(int n){
	size = n;
	terrain = new int[n][n];
	for(int i=0; i<n; i++){
	    for(int j=0; j<n; j++){
		terrain[i][j]=0;
	    }
	}
    }		

    public int get(int x, int y){
	return terrain[x][y];
    }
    public void set(int x, int y, int n){
	terrain[x][y] = n;
    }

    public String toString(){
	StringBuilder output = new StringBuilder();
	int temp;
	for(int i = 0; i<size; i++){
	    output.append("[ ");
	    for(int j=0; j<size; j++){
		temp = get(i,j);
		if(temp==0){output.append("#");}
		if(temp!=0){output.append("+");}
		output.append(" ");
	    }
	    output.append("]\n");
	}
	return output.toString();
    }
}
