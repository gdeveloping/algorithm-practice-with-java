package tech.gdev.algorithmpractice.codesegment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gdev
 * @date 2022/5/2 20:45
 */
public class ListQueueStackCodeSegment {

    public static void main(String[] args) {
        codeSegment1();
        codeSegment2();
    }

    private static void codeSegment1() {
        System.out.println("\ncodeSegment1");
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        // push 5, 4, 3, 2
        path.push(5);
        path.push(4);
        path.push(3);
        path.push(2);
        path.push(1);

        path.pop();

        List<Integer> list1 = new ArrayList<>(path.size());
        for (int i = path.size()-1; i >= 0; i--) {
            list1.add(path.get(i).intValue());
        }
        // 5, 4, 3, 2
        System.out.println(list1);
        res.add(list1);

        List<Integer> list2 = new ArrayList<>(path);
        // 2, 3, 4, 5
        System.out.println(list2);
        res.add(list2);

//        System.out.println();
//        System.out.println(res);
    }

    private static void codeSegment2() {
        System.out.println("\ncodeSegment2");
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // push 5, 4, 3, 2
        path.add(5);
        path.add(4);
        path.add(3);
        path.add(2);
        path.add(1);

        path.remove(path.size()-1);

        List<Integer> list = new ArrayList<>(path);
        System.out.println(list);
        res.add(list);
    }

}
