/**
 * Created by YLT on 2018/3/26.
 */
abstract class A{//定义一个抽象类

    public void fun(){//普通方法
        System.out.println("存在方法体的方法");
    }

    public abstract void print();//抽象方法，没有方法体，有abstract关键字做修饰

}
//单继承
class B extends A{//B类是抽象类的子类，是一个普通类

    @Override
    public void print() {//强制要求覆写
        System.out.println("Hello World !");
    }

}
public class TestDemo {

    public static void main(String[] args) {
        A a = new B();//向上转型

        a.print();//被子类所覆写的过的方法
    }
}
