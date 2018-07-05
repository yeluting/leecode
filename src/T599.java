import java.util.*;

/**
 * Created by YLT on 2017/8/31.
 */
public class T599 {
    public static void main(String[] args) {
        T599 t599 = new T599();
        t599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> res = new HashMap<>();
        HashMap<String,Integer> end = new HashMap<>();
        for (int i = 0;i < list1.length;i++ ) {
            res.put(list1[i],i);
        }
        for (int i = 0;i < list2.length;i++ ) {
            if(res.containsKey(list2[i])){
                end.put(list2[i],i + res.get(list2[i]));
            }
        }

        //根据hashmap的value进行排序！！！！从小到大排序
        List<Map.Entry<String, Integer>> list_Data = new ArrayList<Map.Entry<String, Integer>>(end.entrySet());
        Collections.sort(list_Data, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                if(o2.getValue()!=null&&o1.getValue()!=null&&o2.getValue().compareTo(o1.getValue())<0){
                    return 1;
                }else{
                    return -1;
                }

            }
        });

        int min = list_Data.get(0).getValue();
        ArrayList<String> ends = new ArrayList<>();
        Iterator iterator = end.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            int value = (int) entry.getValue();
            if(value == min){
                ends.add((String) entry.getKey());
            }
        }
        return ends.toArray(new String[ends.size()]);
    }

    public String[] findRestaurant1(String[] list1, String[] list2) {
        ArrayList<String> strList = new ArrayList<String>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int min_dis = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            hm.put(list1[i], i);
        }
        for (int i = 0; i < list2.length && i <= min_dis; i++) {
            if (hm.containsKey(list2[i])) {
                int temp_dis = hm.get(list2[i]) + i;
                if (temp_dis < min_dis) {
                    strList.clear();
                    strList.add(list2[i]);
                    min_dis = temp_dis;
                } else if (temp_dis == min_dis) {
                    strList.add(list2[i]);
                }
            }
        }
        return strList.toArray(new String[strList.size()]);
    }
    }
