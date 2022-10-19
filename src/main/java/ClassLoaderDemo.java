public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLoaderDemo's ClassLoader is "+ ClassLoaderDemo.class.getClassLoader());
        System.out.println("The parent of ClassLoader is "+ ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The Grandpa of ClassLoader is "+ ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
