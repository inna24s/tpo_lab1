package main;
import java.util.*;

public class GraphBFS {
    private boolean[] used; //массив для хранения информации о пройденных и не пройденных вершинах
    private Queue queue; //очередь для добавления вершин при обходе в ширину
    private ArrayList<Integer> ret;

    //процедура обхода в ширину
    public ArrayList<Integer> bfs(int v, ArrayList<ArrayList<Integer>> adj) {
        queue = new LinkedList();
        used = new boolean[adj.size()];
        ret=new ArrayList<>();
        if (used[v])  //если вершина является пройденной, то не производим из нее вызов процедуры
            return ret;

        queue.add(v); //начинаем обход из вершины v
        used[v] = true; //помечаем вершину как пройденную
        ret.add(v);
        while (!queue.isEmpty()) {
            v = (int) queue.poll(); //извлекаем вершину из очереди
            //запускаем обход из всех вершин, смежных с вершиной v
            for (int i = 0; i < adj.get(v).size(); ++i) {
                int w = (int) adj.get(v).get(i);
                //если вершина уже была посещена, то пропускаем ее
                if (used[w]) continue;
                queue.add(w); //добавляем вершину в очередь обхода
                used[w] = true; //помечаем вершину как пройденную
                ret.add(w);
            }
        }
        return ret;
    }
}
