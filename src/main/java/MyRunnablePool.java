public class MyRunnablePool implements Runnable{
    private String command;

    public MyRunnablePool(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start Time = "+System.currentTimeMillis());
        processCommand();
        System.out.println(Thread.currentThread().getName()+"Start Time = "+System.currentTimeMillis());
    }

    private void processCommand(){
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyRunnablePool{" +
                "command='" + command + '\'' +
                '}';
    }
}
