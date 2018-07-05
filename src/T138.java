import java.util.HashMap;
import java.util.Vector;

/**
 * Created by YLT on 2018/3/23.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class T138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode,Integer> node_map = new HashMap<>();
        Vector<RandomListNode> new_nodes = new Vector<>();

        RandomListNode temp = head;

        int count = 0;
        while (temp!=null){
            node_map.put(temp,count);
            new_nodes.add(new RandomListNode(temp.label));
            temp = temp.next;
            count ++;
        }


        //attention!!!
        new_nodes.add(null);

        temp = head;
        count = 0;
        while (temp!=null){
            new_nodes.get(count).next = new_nodes.get(count + 1);
            if (temp.random!=null){
                new_nodes.get(count).random = new_nodes.get(node_map.get(temp.random));
            }
            count++;
            temp = temp.next;
        }
        return new_nodes.get(0);
    }
}
