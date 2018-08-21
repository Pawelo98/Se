
import java.util.*;
import java.lang.*;

class Graph {
    class Laczenie implements Comparable<Laczenie> {
        int src, dest, weight;

        public int compareTo(Laczenie compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class podzbior {
        int parent, rank;
    }

    int V, E;
    Laczenie laczenie[];

    Graph(int v, int e) {
        V = v;
        E = e;
        laczenie = new Laczenie[E];
        for (int i = 0; i < e; ++i)
            laczenie[i] = new Laczenie();
    }

    int find(podzbior podzbior[], int i) {
        if (podzbior[i].parent != i)
            podzbior[i].parent = find(podzbior, podzbior[i].parent);

        return podzbior[i].parent;
    }

    void Union(podzbior podzbior[], int x, int y) {
        int xroot = find(podzbior, x);
        int yroot = find(podzbior, y);

        if (podzbior[xroot].rank < podzbior[yroot].rank)
            podzbior[xroot].parent = yroot;
        else if (podzbior[xroot].rank > podzbior[yroot].rank)
            podzbior[yroot].parent = xroot;

        else {
            podzbior[yroot].parent = xroot;
            podzbior[xroot].rank++;
        }
    }
    int kruskal() {
        int addWeight = 0;
        Laczenie result[] = new Laczenie[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Laczenie();

        Arrays.sort(laczenie);

        podzbior podzbior[] = new podzbior[V+1];
        for (i = 0; i < V+1; ++i)
            podzbior[i] = new podzbior();

        for (int v = 0; v < V; ++v) {
            podzbior[v].parent = v;
            podzbior[v].rank = 0;
        }

        i = 0;

        while (e < V - 1) {
            Laczenie next_edge = laczenie[i++];

            int x = find(podzbior, next_edge.src);
            int y = find(podzbior, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(podzbior, x, y);
            }
        }

        for (i = 0; i < e; ++i) {
            addWeight += result[i].weight;
        }
        return addWeight;
    }
}
