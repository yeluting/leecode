

/**
 * Created by YLT on 2018/3/26.
 */


class Myrunnable implements Runnable{
    private String name;
    public Myrunnable(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 0; i <= 5; i ++){
            System.out.println(name + ":" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Runnable1Test {
    public static void main(String[] args){
        Myrunnable r1 = new Myrunnable("A");
        Myrunnable r2 = new Myrunnable("B");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

}
