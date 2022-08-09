public class SingletonCreate {
    private static SingletonCreate INSTANCE = null;
    private static Object lock;

    public static SingletonCreate getInstance() {
        synchronized (lock){
            if (INSTANCE == null) {
                INSTANCE = new SingletonCreate();
            }
            return INSTANCE;
        }
    }

    private SingletonCreate() {
    }
}
//enum SingletonCreateEnum{
//    INSTANCE;
//    private String name = "zhangsan";
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
