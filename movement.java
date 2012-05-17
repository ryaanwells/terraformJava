
public class movement{
    private map workingMap;
    private map canMove;
    private unit workingUnit;
    private int offsetX;
    private int offsetY;

    movement(map M, unit U){
	workingMap = M;
	workingUnit = U;
	offsetX = workingUnit.getX()-workingUnit.getMovement();
	offsetY = workingUnit.getY()-workingUnit.getMovement();
	canMove = new map(2*(workingUnit.getMovement())+1);
	processAccessable();
    }

    public boolean canAccess(int x, int y, int movement){
	if(x<0 || y<0) return false;
	return ((workingMap.get(x,y)!=0)&&(movement-1>=0));
    }

    public void probeNext(int prevx, int prevy, int x, int y, int movement){
	if(movement >= 0){
	    canMove.set(x-offsetX,y-offsetY,1);
	    if(y!=prevy+1 && canAccess(x,y-1,movement)){probeNext(x,y,x,y-1,movement-1);}
	    if(y!=prevy-1 && canAccess(x,y+1,movement)){probeNext(x,y,x,y+1,movement-1);}
	    if(x!=prevx+1 && canAccess(x-1,y,movement)){probeNext(x,y,x-1,y,movement-1);}
	    if(x!=prevx-1 && canAccess(x+1,y,movement)){probeNext(x,y,x+1,y,movement-1);}
	}
	
    }

    public String toString(){
	return canMove.toString();
    }

    public void processAccessable(){
	if(canMove!=null){	
	    int movement = workingUnit.getMovement();
	    int startX = workingUnit.getX();
	    int startY = workingUnit.getY();
	    probeNext(startX,startY,startX,startY,movement);
	}
    }
}