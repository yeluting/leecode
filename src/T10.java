/**
 * Created by YLT on 2018/6/13.
 */
public class T10 {
    public boolean isMatch(String s, String p) {
        int length1 = s.length(),length2 = p.length();
        return match(s,0,length1,p,0,length2);
    }

    public boolean match(String s, int begin1, int end1, String p, int begin2, int end2){
        if (begin2 == end2 && begin1 != end1){
            return false;
        }
        if (begin2 == end2 && begin1 == end1){
            return true;
        }

        if (begin2 + 1 < end2 && p.charAt(begin2 + 1) == '*'){
            if (s.charAt(begin1) == p.charAt(begin2) || p.charAt(begin2) == '.'){
                return match(s,begin1,end1,p,begin2 + 2, end2) || match(s,begin1 + 1,end1,p,begin2 +2,end2)||match(s,begin1+1,end1,p,begin2,end2);
            }else {
                return match(s,begin1,end1,p,begin2+2,end2);
            }
        }

        if (begin1 < end1 && (s.charAt(begin1)== '.'||s.charAt(begin1) == p.charAt(begin2))){
            return match(s,begin1+1,end1,p,begin2+1,end2);
        }else {
            return false;
        }
    }

}
