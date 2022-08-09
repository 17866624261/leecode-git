import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class StreamTest {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("aaa","bbb","ccc","ddd","eee","fff","ggg","aaa2");
        stringList.stream().filter(s->s.startsWith("a")).forEach(System.out::println);
        System.out.println(stringList.stream());
        stringList.stream().map(String::toUpperCase).sorted((a,b)-> b.compareTo(a)).forEach(System.out::println);
        long size = stringList.stream().filter(s->s.startsWith("a")).count();
        System.out.println(size);
        Optional<String> reduced = stringList.stream().sorted((a,b)->b.compareTo(a)).reduce((a,b)->a+"#"+b);
        Zoo zoo = new Zoo();
        Optional.ofNullable(zoo).map(o->o.getDog()).map(o->o.getAge()).ifPresent(s -> System.out.println(s));

        reduced.ifPresent(System.out::println);
    }
}
class Zoo{
    private Dog2 dog;

    public Dog2 getDog() {
        return dog;
    }

    public void setDog(Dog2 dog) {
        this.dog = dog;
    }
}
class Dog2{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
