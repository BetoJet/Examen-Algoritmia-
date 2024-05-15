public class AlgoritmoDijkstra {

    static final int V = 9;

    private static int distanciaMinima(int[] dist, boolean[] verticeYaProcesado) {
        int min = Integer.MAX_VALUE;
        int min_indice = 0;

        for (int v = 0; v < V; v++)
            if (!verticeYaProcesado[v] && dist[v] <= min) {
                min = dist[v];
                min_indice = v;
            }

        return min_indice;
    }
    private static void imprimirSolucion(int[] dist, int n) {
        System.out.println("Distancia del vértice desde el origen\n");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    private static void dijkstra(int[][] grafo, int src) {
        int[] dist = new int[V];
        boolean[] verticeYaProcesado = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            verticeYaProcesado[i] = false;
        }
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = distanciaMinima(dist, verticeYaProcesado);
            verticeYaProcesado[u] = true;

            for (int v = 0; v < V; v++)
                if (!verticeYaProcesado[v] && grafo[u][v] > 0 && dist[u] != Integer.MAX_VALUE &&
                        dist[u] + grafo[u][v] < dist[v])
                    dist[v] = dist[u] + grafo[u][v];
        }

        imprimirSolucion(dist, V);
    }

    public static void main(String[] args) {
        int[][] grafo = {
            {0, 4, 0, 0, 0, 0, 0, 3, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 5},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 0, 10, 0, 2, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 1, 6},
            {3, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 5, 0, 0, 0, 6, 7, 0}
        };
        
        dijkstra(grafo, 0);
    }
}
