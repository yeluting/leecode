/**
 * Created by YLT on 2018/3/26.
 */
class Thread1 extends Thread {
    private String name;
    public Thread1(String name){
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

public class Thread1Test{


    public static void main(String []args){
        Thread1 t1 = new Thread1("A");
        Thread1 t2 = new Thread1("B");
        t1.start();
        t2.start();
    }


}
