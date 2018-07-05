import java.util.*;

/**
 * Created by YLT on 2018/5/24.
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class swore {

    public boolean Find_t4(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return false;
        }
        int height = array.length;
        int length = array[0].length;

        int row = 0,column = length - 1;
        while (row < height && column >= 0){
            if (array[row][column] == target){
                return true;
            }else if (array[row][column] > target){
                column --;
            }else {
                row ++;
            }
        }
        return false;
    }

    public String replaceSpace_t5(StringBuffer str) {
        int length = str.length();
        int count = 0;
        for (int i = 0; i < length; i ++){
            if (str.charAt(i)==' '){
                count ++;
            }
        }
        str.append(new char[count * 2]);
        int font1 = length - 1;
        int font2 = font1 + count*2;

        while (font1 != font2){
            if (str.charAt(font1) != ' '){
                str.setCharAt(font2,str.charAt(font1));
                font1--;
                font2--;
            }else {
                font1--;
                str.replace(font2 - 2,font2+1,"%20");
                font2 = font2 - 3;
            }
        }
        return String.valueOf(str);
    }

    public ArrayList<Integer> printListFromTailToHead_t6(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.empty()){
            result.add(stack.pop());
        }
        return result;
    }

    public TreeNode reConstructBinaryTree_t7(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length){
            return null;
        }
        return constructCore(pre,0,pre.length - 1,in,0,in.length-1);
    }
    public TreeNode constructCore(int [] pre, int begin_pre, int end_pre, int [] in, int begin_in, int end_in){
        int rootValue = pre[begin_pre];
        TreeNode root = new TreeNode(rootValue);

        if (begin_pre == end_pre && begin_in == end_in){
            return root;
        }else {
            int i;
            for (i = begin_in; i <= end_in; i ++){
                if (in[i] == rootValue){
                    break;
                }
            }
            int deltaLen = i - begin_in;
            if (deltaLen > 0){
                root.left = constructCore(pre, begin_pre + 1, begin_pre + deltaLen, in, begin_in, i-1);
            }
            if (begin_pre + deltaLen < end_pre){
                root.right = constructCore(pre,begin_pre + deltaLen + 1, end_pre,in, i + 1, end_in);
            }
            return root;
        }
    }

    public TreeLinkNode GetNext_t8(TreeLinkNode pNode)
    {
        if (pNode == null){
            return null;
        }
        TreeLinkNode result = null;
        if (pNode.right != null){
            TreeLinkNode temp = pNode.right;
            while (temp.left != null){
                temp=temp.left;
            }
            return temp;
        }else if (pNode.next != null){
            TreeLinkNode parent = pNode.next;
            while (parent != null && parent.left!= pNode){
                pNode = parent;
                parent = parent.next;
            }
            result = parent;
        }
        return result;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push_t9(int node) {
        stack1.push(node);
    }
    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public int Fibonacci_t10(int n) {
        int [] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        if (n < 2){
            return result[n];
        }
        for (int i = 2; i <= n; i ++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

    public int minNumberInRotateArray_t11(int [] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = 0;
        while (array[index1] >= array[index2]){
            if (index2 == index1 + 1){
                mid = index2;
                break;
            }

            mid = (index1 + index2)/2;
            if (array[index1] == array[mid] && array[index2] == array[mid]){
                return minInOrder(array,index1,index2);
            }
            if (array[mid] >= array[index1]){
                index1 = mid;
            }else if (array[mid] <= array[index2]){
                index2 = mid;
            }
        }
        return array[mid];
    }
    public int minInOrder(int [] array,int index1,int index2){
        int result = Integer.MAX_VALUE;
        for (int i = index1; i <= index2; i ++){
            if (array[i] < result){
                result = array[i];
            }
        }
        return result;
    }

    public boolean hasPath_t12(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null || rows < 1 || cols < 1|| str == null){
            return false;
        }

        boolean [][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row ++){
            for (int col = 0; col < cols; col ++){
                if (hasPathCore(matrix,rows,cols,visited,str,0,row,col)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasPathCore(char [] matrix, int rows, int cols, boolean [][]visited, char[] str, int pathLength, int row, int col){
        if (str.length == pathLength){
            return true;
        }
        boolean hasPath = false;

        if (col >= 0 && col < cols && row >= 0 && row < rows && matrix[row * cols + col] == str[pathLength] && !visited[row][col]) {
            ++pathLength;
            visited[row][col] = true;

            hasPath = hasPathCore(matrix, rows, cols, visited, str, pathLength, row, col - 1) ||
                    hasPathCore(matrix, rows, cols, visited, str, pathLength, row, col + 1) ||
                    hasPathCore(matrix, rows, cols, visited, str, pathLength, row - 1, col) ||
                    hasPathCore(matrix, rows, cols, visited, str, pathLength, row + 1, col);

            if (!hasPath) {
                --pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public int movingCount_t13(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows < 0|| cols < 0){
            return 0;
        }
        boolean [][] visited = new boolean[rows][cols];

        int count = movingCountCore(threshold,rows,cols,0,0,visited);
        return count;
    }
    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean [][]visited){
        int count = 0;
        if (check(threshold,rows,cols,row,col,visited)){
            visited[row][col] = true;

            count = 1 + movingCountCore(threshold,rows,cols,row+1,col,visited) +
                    movingCountCore(threshold,rows,cols,row-1,col,visited) +
                    movingCountCore(threshold,rows,cols,row,col+1,visited) +
                    movingCountCore(threshold,rows,cols,row,col-1,visited);
        }
        return count;
    }
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean [][]visited){
        if (row < rows&&row >=0 && col < cols && col >= 0 && !visited[row][col] && getDigit(row) + getDigit(col) <= threshold){
            return true;
        }
        return false;
    }
    public int getDigit(int number){
        int result = 0;
        while (number %10 > 0){
            result += number%10;
            number = number/10;
        }
        return result;
    }

    public int NumberOf1_t15(int n) {
       /* int count = 0;
        int flag = 1;
        while ((flag & 0xFFFF) != 0){
            if ((n & flag) != 0){
                count ++;
            }
            flag = flag << 1;
        }
        return count;*/
       int count = 0;
        while (n != 0){
            n = (n-1)&n;
            count++;
        }
        return count;
    }

    public double Power_t16(double base, int exponent) {
        boolean flag = false;
        if (exponent < 0){
            flag = true;
            exponent = -exponent;
        }
        double result = powerWithUnsigned(base,exponent);
        if (flag == true){
            result = 1/result;
        }
        return result;
    }
    double powerWithUnsigned(double base, int exponent){
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        double result = powerWithUnsigned(base,exponent>>1);
        result = result * result;
        if ((exponent&0x1) == 1){
            result = result * base;
        }
        return result;
    }

    public ListNode deleteDuplication_t18(ListNode pHead)
    {
        /*if (pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode prenode = null;
        ListNode nownode = pHead;
        while (nownode != null){
            ListNode next = nownode.next;
            boolean needDelete = false;
            if (next!=null && next.val == nownode.val){
                needDelete = true;
            }

            if (!needDelete){
                prenode = nownode;
                nownode = next;
            }else {
                int value = nownode.val;
                while (nownode != null && nownode.val == value){
                    nownode = nownode.next;
                }
                if (prenode != null) {
                    prenode.next = nownode;
                }else {
                    pHead = nownode;
                }
            }
        }
        return pHead;*/
        //新加头节点
        /*ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode pre = first;
        while (pHead != null && pHead.next!=null){
            if (pHead.val == pHead.next.val){
                int value = pHead.val;
                while (pHead!=null && pHead.val == value){
                    pHead = pHead.next;
                }
                pre.next = pHead;
            }else {
                pre = pHead;
                pHead = pHead.next;
            }
        }
        return first.next;*/
        //递归实现
        if (pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode current;
        if (pHead.next.val == pHead.val){
            current = pHead.next.next;
            while (current!=null && current.val == pHead.val){
                current = current.next;
            }
            return deleteDuplication_t18(current);
        }else {
            current = pHead.next;
            pHead.next = deleteDuplication_t18(current);
            return pHead;
        }
    }


    public boolean match_t19(char[] str, char[] pattern)
    {
        if (str == null || pattern == null){
            return false;
        }
        return match(str,0,str.length,pattern,0,pattern.length);
    }
    public boolean match(char[]str, int begin1,int end1, char[] pattern, int begin2, int end2){
        if (begin1 == end1 && begin2 == end2){
            return true;
        }
        if (begin1 != end1 && begin2 == end2){
            return false;
        }

        if (begin2 + 1 < end2 && pattern[begin2 + 1] == '*'){
            if ((begin1 < end1 && str[begin1] == pattern[begin2]) || (pattern[begin2] == '.'&&begin1 < end1)){
                return match(str, begin1 + 1, end1, pattern, begin2 + 2,end2)||
                        match(str,begin1 + 1,end1,pattern,begin2,end2)||
                        match(str,begin1,end1,pattern,begin2+2,end2);
            }else {
                return match(str,begin1,end1,pattern,begin2 + 2,end2);
            }
        }

        if ((pattern[begin2] =='.' && begin1 < end1) || (begin1 < end1&&pattern[begin2] == str[begin1])){
            return match(str,begin1+1,end1,pattern,begin2 + 1, end2);
        }
        return false;
    }

    private int index = 0;
    public boolean isNumeric_t20(char[] str) {
        if (str==null || str.length == 0){
            return false;
        }
        boolean numornot = scanInteger(str);

        if (index < str.length &&str[index] == '.'){
            index++;
            numornot = scanUnsignedInteger(str) || numornot;
        }
        if (index < str.length &&(str[index] == 'e' || str[index] == 'E')){
            index ++;
            numornot = numornot && scanInteger(str);
        }
        return numornot && index == str.length;
    }
    public boolean scanInteger(char[] str){
        if (index < str.length &&(str[index] == '+' || str[index] == '-')){
            index ++;
        }
        return scanUnsignedInteger(str);
    }
    public boolean scanUnsignedInteger(char[] str){
        int  start = index;
        while (index < str.length && str[index] >='0' && str[index] <= '9'){
            index ++;
        }
        return start < index;
    }

    public void reOrderArray_t21(int [] array) {
        //保持原始顺序不变
        if (array == null || array.length == 0){
            return;
        }
        int length = array.length;
        for (int i = 0; i < length -1; i ++){
            for (int j = 0; j < length - 1 - i; j ++){
                if (array[j]%2==0 && array[j+1]%2==1){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        //对原始顺序无要求
        /*if (array == null || array.length == 0){
            return;
        }
        int length = array.length;

        int i = 0, j = length - 1;

        while (i < j){
            while (i < j && array[i]%2 ==1){
                i++;
            }

            while (i <j && array[j]%2 ==0){
                j--;
            }
            if (i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }*/
    }

    public ListNode FindKthToTail_t22(ListNode head,int k) {
        if (head == null ||k ==0){
            return null;
        }

        int length = 0;
        ListNode nownode = head;
        while (nownode != null){
            length ++;
            nownode = nownode.next;
        }
        if (k > length){
            return null;
        }

        ListNode first = head;
        for (int i = 1; i < k; i ++){
            first = first.next;
        }

        ListNode second = head;
        while (first.next!=null){
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public ListNode EntryNodeOfLoop_t23(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return null;
        }

        ListNode meeting = cycleOrNot(pHead);
        if (meeting == null){
            return null;
        }

        int count = 0;
        ListNode now = meeting;
        while (now.next != meeting){
            count++;
            now = now.next;
        }

        ListNode first = pHead;
        for (int i = 0; i < count; i ++){
            first = first.next;
        }

        ListNode second = pHead;
        while (first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
    public ListNode cycleOrNot(ListNode head){
        ListNode first = head;
        ListNode second = head;

        while (first.next != null){
            first = first.next;
            second = second.next;
            if (first.next != null){
                first = first.next;
            }

            if (first == second){
                return first;
            }
        }
        return null;
    }

    public ListNode ReverseList_t24(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode Merge_t25(ListNode list1,ListNode list2) {
        //循环实现
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = null;
        ListNode nownode = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (result == null) {
                    result = new ListNode(list1.val);
                    nownode = result;
                } else {
                    nownode.next = new ListNode(list1.val);
                    nownode = nownode.next;
                }
                list1 = list1.next;
            } else {
                if (result == null) {
                    result = new ListNode(list2.val);
                    nownode = result;
                } else {
                    nownode.next = new ListNode(list2.val);
                    nownode = nownode.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null){
            nownode.next = list2;
        }else {
            nownode.next = list1;
        }
        return result;
    }
    //递归实现
      /*  if (list1 == null){
            return list2;
        }
        if (list2 ==null){
            return list1;
        }

        ListNode result = new ListNode(-1);
        if (list1.val < list2.val){
            result.val = list1.val;
            result.next = Merge_t25(list1.next,list2);
        }else {
            result.val = list2.val;
            result.next = Merge_t25(list1,list2.next);
        }
        return result;*/

    public boolean HasSubtree_t26(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                result = hasTree(root1,root2);
            }
            if (!result){
                result = HasSubtree_t26(root1.left,root2);
            }
            if (!result){
                result = HasSubtree_t26(root1.right,root2);
            }
        }
        return result;
    }
    public boolean hasTree(TreeNode root1,TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            return hasTree(root1.left,root2.left)&&hasTree(root1.right,root2.right);
        }else {
            return false;
        }
    }

    public void Mirror_t27(TreeNode root) {
        if (root==null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror_t27(root.left);
        Mirror_t27(root.right);
    }

    boolean isSymmetrical_t28(TreeNode pRoot)
    {
        if (pRoot==null){
            return true;
        }
        return isMirror(pRoot.left,pRoot.right);
    }
    public boolean isMirror(TreeNode root1, TreeNode root2){
        if (root1==null && root2==null){
            return true;
        }
        if (root1==null||root2==null){
            return false;
        }
        if (root1.val == root2.val){
            return isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left);
        }else {
            return false;
        }
    }

    public ArrayList<Integer> printMatrix_t29(int [][] matrix) {
        if (matrix == null || matrix.length <=0 || matrix[0].length <=0){
            return null;
        }
        int start = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        while (row > start * 2 && column > start *2){
            toPrint(matrix,row,column,start,result);
            start++;
        }
        return result;
    }
    public void toPrint(int [][] matrix,int row, int column, int start, ArrayList<Integer> result){
        int endX = column - 1 - start;
        int endY = row - 1 - start;
        for (int i = start; i <= endX; i ++){
            result.add(matrix[start][i]);
        }
        if (start < endY){
            for (int j = start + 1; j <= endY; j++){
                result.add(matrix[j][endX]);
            }
        }
        if (start < endY && start < endX){
            for (int i = endX - 1; i >= start; i --){
                result.add(matrix[endY][i]);
            }
        }
        if (start < endY - 1 && start < endX){
            for (int j = endY - 1; j > start ; j --){
                result.add(matrix[j][start]);
            }
        }
    }

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> number = new Stack<>();
    public void push(int node) {
        number.push(node);
        if (minStack.empty()){
            minStack.push(node);
        }else {
            if (minStack.peek() < node){
                minStack.push(minStack.peek());
            }else {
                minStack.push(node);
            }
        }
    }

    public void pop1() {
        minStack.pop();
        number.pop();
    }

    public int top() {
        return number.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public boolean IsPopOrder_t31(int [] pushA,int [] popA) {
        if (pushA == null && popA == null){
            return true;
        }
        if (pushA == null || popA == null || popA.length != pushA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int length = popA.length;
        int index = 0;
        for(int i = 0; i < length; i++){
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[index]){
                stack.pop();
                index ++;
            }
        }
        if (index == length){
            return true;
        }else {
            return false;
        }
        /*if (pushA == null && popA == null){
            return true;
        }
        if (pushA == null || popA == null || popA.length != pushA.length){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int length = popA.length;
        int index_pop = 0;
        int index_push = 0;
        while (index_pop < length){
            while ((stack.empty() || stack.peek() != popA[index_pop])){
                if (index_push >= length){
                    return false;
                }else {
                    stack.push(pushA[index_push++]);
                }
            }
            if (stack.peek() == popA[index_pop]) {
                index_pop++;
                stack.pop();
            }
        }
        return true;*/
    }

    public ArrayList<Integer> PrintFromTopToBottom_t32(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode nownode = queue.poll();
            result.add(nownode.val);
            if (nownode.left!= null) {
                queue.offer(nownode.left);
            }
            if (nownode.right!=null) {
                queue.offer(nownode.right);
            }
        }
        return result;
    }
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null){
            return result;
        }
        queue.offer(pRoot);
        int nowlevel = 1,nextlevel = 0;
        ArrayList<Integer> each = new ArrayList<>();
        while (!queue.isEmpty()){
            if (nowlevel == 0){
                result.add(each);
                each = new ArrayList<>();
                nowlevel = nextlevel;
                nextlevel = 0;
            }
            nowlevel --;
            TreeNode node = queue.poll();
            each.add(node.val);
            if (node.left != null){
                queue.offer(node.left);
                nextlevel ++;
            }
            if (node.right != null){
                queue.offer(node.right);
                nextlevel++;
            }
        }
        result.add(each);
        return result;
    }
    public ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> each = new ArrayList<>();
        Stack<TreeNode> [] stack = new Stack[2];
        stack[0] = new Stack<TreeNode>();
        stack[1] = new Stack<TreeNode>();
        stack[0].push(pRoot);
        int current = 0;
        while (!stack[0].empty() || !stack[1].empty()){
            TreeNode now = stack[current].pop();
            each.add(now.val);
            if (current == 0){
                if (now.left != null) {
                    stack[1 - current].push(now.left);
                }
                if (now.right!= null){
                    stack[1-current].push(now.right);
                }
            }else {
                if (now.right!= null){
                    stack[1-current].push(now.right);
                }
                if (now.left != null) {
                    stack[1 - current].push(now.left);
                }
            }

            if (stack[current].empty()){
                result.add(each);
                each = new ArrayList<>();
                current = 1 - current;
            }
        }
        return result;
    }

    public boolean VerifySquenceOfBST_t33(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        if (sequence.length < 2){
            return true;
        }
        return verify(sequence,0,sequence.length - 1);
    }
    public boolean verify(int [] sequence, int begin, int end){
        if (begin == end){
            return true;
        }
        int root = sequence[end];
        int i = begin;
        for (i = begin; i < end; i ++){
            if (sequence[i] > root){
                break;
            }
        }
        for (int j = i; j < end; j ++){
            if (sequence[j] < root){
                return false;
            }
        }

        boolean left = true;
        if (i > begin) {
            left = verify(sequence, begin, i - 1);
        }
        boolean right = true;
        if (i < end){
            right = verify(sequence,i,end - 1);
        }
        return left && right;
    }

    public ArrayList<ArrayList<Integer>> FindPath_t34(TreeNode root,int target) {
        if (root == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        findpath(root,target,0,new ArrayList<Integer>(),result);
        return result;
    }
    public void findpath(TreeNode root,int target, int now, ArrayList<Integer> nowpath, ArrayList<ArrayList<Integer>> result){
        now = now + root.val;
        nowpath.add(root.val);

        if (root.left == null && root.right == null){
            if (target == now){
                result.add(new ArrayList<Integer>(nowpath));
            }
        }

        if (root.left!=null){
            findpath(root.left,target,now,nowpath,result);
        }
        if (root.right!=null){
            findpath(root.right,target,now,nowpath,result);
        }
        //now -= root.val;
        nowpath.remove(nowpath.size()-1);
    }

    public RandomListNode Clone_t35(RandomListNode pHead) {
        clone(pHead);
        randomPtr(pHead);
        return reconnect(pHead);
    }
    public void clone(RandomListNode pHead) {
        RandomListNode now = pHead;
        while (now != null) {
            RandomListNode temp = new RandomListNode(now.label);
            temp.next = now.next;
            now.next = temp;
            now = now.next.next;
        }
    }

    public void randomPtr(RandomListNode pHead) {
        RandomListNode now = pHead;
        while (now != null) {
            if (now.random != null) {
                now.next.random = now.random.next;
            }
            now = now.next;
        }
    }

    public RandomListNode reconnect(RandomListNode pHead) {
        RandomListNode result = null;
        RandomListNode now = null;
        if (pHead != null) {
            result = pHead.next;
            now = result;
            pHead = pHead.next.next;
        }
        while (pHead != null) {
            now.next = pHead.next;
            now.random = pHead.random.next;
            pHead = pHead.next.next;
        }
        return result;
    }






    public int MoreThanHalfNum_Solution_t39(int [] array) {
        int shu = array[0];
        int count = 1;
        int length = array.length;

        for (int i = 1;i < length; i ++){
            if (array[i] == shu){
                count ++;
            }else if (count > 1){
                count --;
            }else {
                count = 0;
                shu = array[i];
            }
        }
        return shu;
    }


    public int GetNumberOfK_t53(int [] array , int k) {
        if (array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]){
            return 0;
        }
        int first = getFirstK(array,0,array.length - 1, k);
        int last = getLastK(array,0,array.length - 1,k);
        if (first != -1 && last != -1) {
            return last - first + 1;
        }else
            return 0;
    }
    public int getFirstK(int [] array, int begin, int end, int k){
        if (begin > end){
            return -1;
        }
        int mid = (begin + end) / 2;
        if (array[mid] > k){
            end = mid - 1;
        }else if (array[mid] < k){
            begin = mid + 1;

        }else {
            if (mid - 1 < 0 || array[mid - 1] < k){
                return mid;
            }else {
                end = mid - 1;
            }
        }
        return getFirstK(array,begin,end,k);
    }
    public int getLastK(int [] array, int begin, int end, int k){
        if (begin > end){
            return -1;
        }
        int mid = (begin + end)/2;
        if (array[mid] > k){
            end = mid - 1;
        }else if (array[mid] < k){
            begin = mid + 1;
        }else {
            if (mid + 1 > end || array[mid + 1] > k){
                return mid;
            }else {
                begin = mid + 1;
            }
        }
        return getLastK(array,begin,end,k);
    }

    /*TreeNode KthNode_t54(TreeNode pRoot, int k)
    {
        if (pRoot == null || k < 1){
            return null;
        }
        return getKth(pRoot,k);
    }
    public TreeNode getKth(TreeNode pRoot, int k){
        TreeNode result = null;
        if (pRoot.left != null){
            result = getKth(pRoot.left,k);
        }
        if (result == null) {
            if (k == 1) {
                result = pRoot;
            }
            k--;
        }
        if (result == null && pRoot.right != null){
            result = getKth(pRoot.right,k);
        }
        return result;
    }*/

    int index = 0;
    TreeNode KthNode_t54(TreeNode pRoot, int k)
    {
        if (pRoot == null || k < 1){
            return null;
        }

        TreeNode left = KthNode_t54(pRoot.left,k);
        if (left != null){
            return left;
        }
        index ++;
        if (k == index){
            return pRoot;
        }
        TreeNode right = KthNode_t54(pRoot.right,k);
        return right;

    }

    public int TreeDepth_t55(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return Math.max(TreeDepth_t55(root.left),TreeDepth_t55(root.right)) + 1;
    }

    boolean balance = true;
    public boolean IsBalanced_Solution_t55(TreeNode root) {
        getLength(root);
        return balance;
    }
    public int getLength(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getLength(root.left);
        int right = getLength(root.right);
        if (Math.abs(left - right) > 1){
            balance = false;
        }
        return Math.max(left,right) + 1;
    }

    public void FindNumsAppearOnce_t56(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        int mux = 0;
        for (int i = 0; i < length; i ++){
            mux = mux ^ array[i];
        }
        num1[0] = 0;
        num2[0] = 0;
        int firstBit = findFirstBitOf1(mux);
        for (int i = 0; i < length; i ++){
            if (isBit1(array[i], firstBit)){
                num1[0]=num1[0] ^ array[i];
            }else {
                num2[0]=num2[0] ^ array[i];
            }
        }
    }
    public int findFirstBitOf1(int number){
        int index = 0;
        while ((number & 1 )== 0){
            number = number >> 1;
            index ++;
        }
        return index;
    }
    public boolean isBit1(int number, int index){
        number = number >> (index);
        int num = (number & 1)%2;
        if (num == 0){
            return false;
        }else
            return true;
    }

    public ArrayList<Integer> FindNumbersWithSum_t57(int [] array,int sum) {
        int result = Integer.MAX_VALUE;
        ArrayList<Integer> result_index = new ArrayList<>();
        if (array== null || array.length <2){
            return result_index;
        }
        int i =0 , j = array.length - 1;
        while (i < j){
            if (array[i] + array[j] == sum){
                if (result > array[i]*array[j]){
                    result = array[i]*array[j];
                    result_index.clear();
                    result_index.add(array[i]);
                    result_index.add(array[j]);
                }
                i++;
                j--;
            }else if (array[i] + array[j] > sum){
                j--;
            }else {
                i++;
            }
        }
        return result_index;
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence_t57(int sum) {
        int mid = (sum + 1)/2;
        int begin = 1,end = 2;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (sum < 3){
            return result;
        }
        int curSum = 3;
        while (begin < mid){
            if (curSum == sum){
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i =begin; i <= end; i ++){
                    temp.add(i);
                }
                result.add(temp);
                end ++;
                curSum += end;
            }else if (curSum > sum){
                curSum -= begin;
                begin ++;
            }else {
                end ++;
                curSum +=end;
            }
        }
        return result;
    }

    public String ReverseSentence_t58(String str)  {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        reverse(charArray,0,length - 1);
        int begin = 0;
        int end = 0;
        while (begin < length){
            if (charArray[begin] == ' '){
                begin ++;
                end ++;
            }else if (charArray[end] == ' '){
                reverse(charArray,begin,end - 1);
                begin = ++end;
            }else if (end == length - 1){
                reverse(charArray,begin,end);
                begin = ++end;
            }else {
                end ++;
            }
        }
        return String.valueOf(charArray);
    }
    public void  reverse(char[] charArray, int begin,int end){
        while (begin < end){
            char temp = charArray[begin];
            charArray[begin] = charArray[end];
            charArray[end] = temp;
            begin++;end--;
        }
    }

    public String LeftRotateString_t58(String str,int n) {
        if (str == null||n <=0 ||n >= str.length()){
            return str;
        }
        char []charArray = str.toCharArray();
        reverse(charArray,0,n-1);
        reverse(charArray,n,charArray.length-1);
        reverse(charArray,0,charArray.length - 1);
        return String.valueOf(charArray);
    }

    public ArrayList<Integer> maxInWindows_t59(int [] num, int size)
    {

    }

    public boolean isContinuous_t61(int [] numbers) {
        if (numbers == null || numbers.length < 5){
            return false;
        }
        int length = numbers.length;
        Arrays.sort(numbers);

        int countOfZero = 0;
        for (int i = 0; i < length; i ++){
            if (numbers[i] == 0){
                countOfZero ++;
            }
        }

        int delta = 0;

        for (int i = countOfZero; i < length - 1; i ++){
            if (numbers[i+1] - numbers[i] ==0){
                return false;
            }else if (numbers[i+1] - numbers[i] == 1){
                continue;
            }else {
                delta += numbers[i+1] - numbers[i] - 1;
            }
        }

        if (delta > countOfZero){
            return false;
        }else
            return true;
    }

    public int LastRemaining_Solution_t62(int n, int m) {
        /*if (n ==0 || m ==0){
            return -1;
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i ++){
            numbers.add(i);
        }

        int index = 0;
        int count = 1;
        while (numbers.size() > 1){
            if (count == m){
                numbers.remove(index);
                count = 1;
            }else {
                index = (index + 1)%numbers.size();
                count++;
            }
        }
        return numbers.get(0);*/


    }

    public int Sum_Solution_t64(int n) {
        /*Temp[] array = new Temp[n];
        return Temp.getSum();*/

        int result = 0;
        int a = 1;
        boolean value = (n!=0)&&a==(result = Sum_Solution_t64(n-1));
        result += n;
        return result;
    }

    public int Add_t65(int num1,int num2) {
        int sum = 0;
        int carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (num2!=0);
        return num1;
    }

    public int[] multiply_t66(int[] A) {
        if (A== null || A.length == 0){
            return null;
        }
        int length = A.length;
        int [] B = new int[length];
        int [] C = new int[length];
        B[0] = 1;
        C[length - 1] = 1;
        for (int i = 1; i < length; i ++){
            B[i] = B[i-1] * A[i-1];
        }
        for (int i = length - 2; i >= 0; i --){
            C[i] = C[i+1] * A[i+1];
        }
        for (int i =0; i < length; i ++){
            B[i] *= C[i];
        }
        return B;
    }

    public int StrToInt_t67(String str) {
        if (str == null || str.equals("")){
            return 0;
        }
        boolean flag = true;
        int length = str.length();
        int result = 0;
        int index = 0;
        if (str.charAt(index) == '-'){
            flag = false;
            index ++;
        }else if (str.charAt(index) == '+'){
            index ++;
        }

        if (index == length){
            return 0;
        }

        for (;index < length; index++){
            if (str.charAt(index) < '0' || str.charAt(index) > '9'){
                return 0;
            }
            result = result * 10 + str.charAt(index) - '0';
        }
        if (flag == false){
            result = -result;
        }
        return result;
    }





}

class Temp{
    public static int N = 0;
    public static int sum = 0;
    public Temp(){
        ++N;
        sum +=N;
    }
    public static int getSum(){
        return sum;
    }
}
