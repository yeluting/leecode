import java.util.ArrayList;
import java.util.List;

/**
 * Created by YLT on 2018/8/2.
 */
public class T57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            List<Interval> result = new ArrayList<Interval>();
            result.add(newInterval);
            return result;
        }

        int i;
        for (i = 0; i < intervals.size(); i ++){
            if (intervals.get(i).end >= newInterval.start){
                break;
            }
        }
        for (;i < intervals.size();){
            if (newInterval.end < intervals.get(i).start){
                break;
            }else {
                newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
                intervals.remove(i);
            }
        }
        intervals.add(i,newInterval);
        return intervals;
    }
}
