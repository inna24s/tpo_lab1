package test;

import main.scene.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SceneTest {
    private Scene scene;
    private Action[] fordActions, firstBodyActions;

    @BeforeEach
    public void setUp() throws Exception {
        scene = new Scene();
        fordActions = new Action[scene.ACTIONS_NUM];
        fordActions[0] = new WalkTowardsAction();
        fordActions[1] = new ReachAction();
        fordActions[2] = new FootDownAction();
        firstBodyActions = new Action[scene.ACTIONS_NUM];
        firstBodyActions[0] = new LayAction();
        firstBodyActions[1] = new LayAction();
        firstBodyActions[2] = new HoldAction();
    }

    @Test
    public void initial() throws Exception {
        System.out.println("Initial test");
        assertEquals(scene.ford.getName(), PersonName.FORD);
        System.out.println("FordName: "+ scene.ford.getName());
        assertEquals(scene.firstBody.getName(), PersonName.FIRST_BODY);
        System.out.println("FirstBodyName: "+ scene.firstBody.getName());
        assertEquals(scene.ford.getActions().size(), scene.ACTIONS_NUM);
        assertEquals(scene.firstBody.getActions().size(), scene.ACTIONS_NUM);
    }

    @Test
    public void run() throws Exception {
        int i = 0;
        System.out.println("Run test");

        while(!scene.nextState()) {
            assertEquals(scene.ford.getState().getDescription(), fordActions[i].getDescription());
            System.out.println( scene.ford.getName()+ " " + scene.ford.getState().getDescription());
            assertEquals(scene.firstBody.getState().getDescription(), firstBodyActions[i].getDescription());
            System.out.println( scene.firstBody.getName()+ " " +  scene.firstBody.getState().getDescription());
            i++;
        }

    }
}
