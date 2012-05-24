public class testMove{
    public static void main(String args[]){
	unit unitA = new unit(1,4,4);
	unit unitB = new unit(4,4,4);
	map Map = new map("");
	map MapA = new map();
	movement MA = new movement(Map,unitA);
	movement MAa = new movement(MapA,unitA);
	movement MB = new movement(Map,unitB);
	movement MBb = new movement(MapA,unitB);
	System.out.println(MA.toString());
	System.out.println(MB.toString());
	System.out.println(MAa.toString());
	System.out.println(MBb.toString());
    }
}	