package test;

import main.GraphBFS;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphBFSTest {
    private int n; //количество вершин в орграфе
    private int m; //количество дуг в орграфе

    GraphBFS graphBFS;
    ArrayList<Integer> list1, list0, list2, list3, list4, list5, list6, list7, checkList;
    private ArrayList<ArrayList<Integer>> adj; //список смежности

    @BeforeEach
    public void setUp() {
        adj = new ArrayList<>();
        list0 = new ArrayList<>(Arrays.asList(1, 3, 6));
        list1 = new ArrayList<>(Collections.emptyList());
        list2 = new ArrayList<>(Collections.singletonList(3));
        list3 = new ArrayList<>(Arrays.asList(1, 4, 5, 7));
        list4 = new ArrayList<>(Collections.emptyList());
        list5 = new ArrayList<>(Collections.singletonList(2));
        list6 = new ArrayList<>(Arrays.asList(2,3,7));
        list7 = new ArrayList<>(Collections.singletonList(5));
        adj.add(list0);
        adj.add(list1);
        adj.add(list2);
        adj.add(list3);
        adj.add(list4);
        adj.add(list5);
        adj.add(list6);
        adj.add(list7);
    }

    @AfterEach
    public void tearDown() {
        adj = null;
    }

    @Test
    public void testBFS0() {
        graphBFS = new GraphBFS();
        System.out.println("Список смежности: ");
        for (int i = 0; i < adj.size(); i++)
            System.out.println(adj.get(i));
        checkList = new ArrayList<>(Arrays.asList(0, 1, 3, 6, 4, 5, 7, 2));
        assertEquals(graphBFS.bfs(0, adj), checkList);
        checkList = new ArrayList<>(Arrays.asList(6, 2, 3, 7, 1, 4, 5));
        assertEquals(graphBFS.bfs(6, adj), checkList);
        checkList = new ArrayList<>(Arrays.asList(5, 2, 3, 1, 4, 7));
        assertEquals(graphBFS.bfs(5, adj), checkList);
    }

    @Test
    public void testBFS1(){
        graphBFS = new GraphBFS();
        ArrayList<Integer> list8 = new ArrayList<>(Collections.emptyList());
        list4.add(8);
        list2.add(8);
        list8.add(5);
        adj.add(list8);
        System.out.println("Список смежности: ");
        for (int i = 0; i < adj.size(); i++)
            System.out.println(adj.get(i));
        checkList = new ArrayList<>(Arrays.asList(0, 1, 3, 6, 4, 5, 7, 2, 8));
        assertEquals(graphBFS.bfs(0, adj), checkList);
        checkList = new ArrayList<>(Arrays.asList(6, 2, 3, 7, 8, 1, 4, 5));
        assertEquals(graphBFS.bfs(6, adj), checkList);

        list2.remove(list4.size()-1);
        list4.remove(list4.size()-1);
        adj.remove(list8);
    }
}
