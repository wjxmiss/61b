/**
 * Created by jingxin on 12/27/17.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    @Test
    public void Test1() {
        OperationSequence fs = new OperationSequence();
        StudentArrayDeque<Integer> sadt = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sade = new ArrayDequeSolution<>();

        while(true){
            int key = StdRandom.uniform(7);
            if (key == 1) {
                sadt.addLast(1);
                DequeOperation dequeOp1 = new DequeOperation("addLast", 1);
                fs.addOperation(dequeOp1);
                sade.addLast(1);
            } else if(key == 2){
                if(!sade.isEmpty() && !sadt.isEmpty()) {
                    Integer expected = sade.removeLast();
                    Integer actual = sadt.removeLast();
                    DequeOperation dequeOp2 = new DequeOperation("removeLast");
                    fs.addOperation(dequeOp2);
                    assertEquals(fs.toString(), expected, actual);
                }
            } else if(key == 3){
                sadt.addFirst(2);
                DequeOperation dequeOp1 = new DequeOperation("addFirst", 2);
                fs.addOperation(dequeOp1);
                sade.addFirst(2);
            } else if(key == 4){
                if(!sade.isEmpty() && !sadt.isEmpty()){
                    Integer expected = sade.removeFirst();
                    Integer actual = sadt.removeFirst();
                    DequeOperation dequeOp2 = new DequeOperation("removeFirst");
                    fs.addOperation(dequeOp2);
                    assertEquals(fs.toString(), expected, actual);
                }
            } else if(key == 5){
                DequeOperation dequeOp = new DequeOperation("isEmpty");
                fs.addOperation(dequeOp);
                Boolean expected = sade.isEmpty();
                Boolean actual = sadt.isEmpty();
                assertEquals(fs.toString(), expected, actual);
                //fs.removeOperation();
            } else if(key == 6){
                DequeOperation dequeOp = new DequeOperation("size");
                fs.addOperation(dequeOp);
                Integer expected = sade.size();
                Integer actual = sadt.size();
                assertEquals(fs.toString(), expected, actual);
                //fs.removeOperation();
            } else{
                if(!sade.isEmpty() && !sadt.isEmpty()){
                    DequeOperation dequeOp = new DequeOperation("get", 0);
                    fs.addOperation(dequeOp);
                    Integer expected = sade.get(0);
                    Integer actual = sadt.get(0);
                    assertEquals(fs.toString(), expected, actual);
                }
            }

        }
    }

    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", TestArrayDeque1B.class);
    }
}
