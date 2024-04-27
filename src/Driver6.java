import java.io.File;
import java.util.Scanner;

public class Driver6 {
    public static Scanner inp;
    public static File f;
    public static String fName;
    public static int x;
    public static int y;
    public static int a;
    public static int b;
    public static int c;
    public static FloydsAlg lloyd;

    public static void main(String[] args) {
        System.out.print("Please enter a file name/path : ");
        inp = new Scanner(System.in);
        fName = inp.nextLine();
        f = new File(fName);
        try {
            inp = new Scanner(f);
        } catch (Exception E) {
            System.out.println("File not found");
        }
        x = Integer.parseInt(inp.next());
        y = Integer.parseInt(inp.next());

        lloyd = new FloydsAlg(x); //creates new digraph object

        //reading each line of vertices and weights and inputting in to the digraphs matrix
        for(int i = 0; i < y; i++) {
            a = Integer.parseInt(inp.next()); //vertex 1 which points to vertex 2
            b = Integer.parseInt(inp.next()); //vertex 2
            c = Integer.parseInt(inp.next()); //weight of edge


            lloyd.setDist(a, b, c); //adds into matrix
            lloyd.setPrev(a,b);
        }
        lloyd.floyd(x);
        int a;
        int b;
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a pair of vertices for shortest path or -1 -1 to end : ");

        a = input.nextInt();
        b = input.nextInt();

        while(a != -1){
            lloyd.Path(a,b);
            System.out.printf("%nPlease enter a pair of vertices for shortest path or -1 -1 to end : ");
            a = input.nextInt();
            b = input.nextInt();
        }
    }
}