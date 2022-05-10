public class Dajiang1 {

    public static void main(String[] args) {
        Animal b = new Dog();
        Dog d = new Dog();
        b.move();
        d.move();
    }
}
class Animal{
    public void move(){
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal{
    public void move(){
        System.out.println("狗可以走和跑");
    }
}
