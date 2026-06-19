class SingletonPatternExample{
    static class Logger{

    private static Logger object;
    private String name;

    private Logger(String name){
        this.name = name;

    }
    public static Logger get(){
        if(object==null){
            object = new Logger("something");
        }
        return object;
    }

}
public static void main (String args[]){
    Logger g1 = Logger.get();
    Logger g2 = Logger.get();
    if(g1 == g2){
        System.out.println("same object");
    }else{
        System.out.println("different objects");
    }

}

}
