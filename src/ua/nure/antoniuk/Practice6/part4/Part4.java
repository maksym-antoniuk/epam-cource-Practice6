package ua.nure.antoniuk.Practice6.part4;

public class Part4 {
	
	public static void main(String[] args) {
		Graph graph = new Graph(10);
        System.out.println(graph.addRebro(5,7));
        System.out.println(graph.addRebro(7,5));
        System.out.println(graph.removeRebro(7,5));


    }

}
