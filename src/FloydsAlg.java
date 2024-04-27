public class FloydsAlg {
    public static int[][] dist;
    public static int[][] prev;

    public FloydsAlg(int v){
        dist = new int[v][v];
        prev = new int[v][v];
        for (int x = 0; x < v; x++)
            for(int y = 0; y < v; y++){
                dist[x][y] = 100000;
                prev[x][y] = -1;
            }
    }

    public static void setPrev(int x, int y){
        prev[x][y] = x;
    }
    public static void setDist(int x, int y, int w){
        dist[x][y] = w;
    }

    public void floyd(int V){
        for(int v = 0; v < V; v++){
            dist[v][v] = 0;
            prev[v][v] = v;
        }
        for(int k = 0; k < V;k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        prev[i][j] = prev[k][j];
                    }
                }
            }
        }
    }

    public void Path(int u, int v){
        myStack S = new myStack();
        if(dist[u][v] != 100000){
            S.push(v);
        }

        System.out.printf("Distance from %d to %d is %d %n" , u,v,dist[u][v]);

        while(u != v){
            v = prev[u][v];
            S.push(v);
        }
        while(!S.isEmpty()){
            System.out.printf("%d --> " , S.pop());
        }
    }
}
