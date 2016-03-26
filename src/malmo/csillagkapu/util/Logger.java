package malmo.csillagkapu.util;

/**
 * Created by Győző on 2016. 03. 26..
 */
public class Logger{
    private int numOfSpace;
    private static Logger logger;

    private Logger(){
        numOfSpace = 0;
    }

    public static Logger getInstanceOf(){
        if(logger == null){
            logger = new Logger();
        }

        return logger;
    }

    public static void log(String text){
        for(int i = 0; i < getInstanceOf().numOfSpace; i++){
            System.out.print(' ');
        }
        System.out.println(text);
    }

    public static void  beginFunction(Object... additionalTexts){
        StackTraceElement element = Thread.currentThread().getStackTrace()[2];
        String className = element.getClassName();
        String[] packages = className.split("\\.");
        className = packages[packages.length -1];
        String extras = "";
        for(Object o: additionalTexts)
        {
            if(!extras.isEmpty())
            {
                extras += ", ";
            }
            extras += o;
        }
        log("-->[" + className + "]:" + element.getMethodName() + "(" + extras + ")");
        getInstanceOf().numOfSpace += 2;
    }
    public static void  endFunction(String text){
        getInstanceOf().numOfSpace -= 2;
        if(getInstanceOf().numOfSpace < 0){
            getInstanceOf().numOfSpace = 0;
            throw new RuntimeException("Van egy olyan sanda gyanum hogy kihagytál egy beginFunctiont()");
        }
        log("<--"+text);
    }

    public static <T> T ret(T obj)
    {
        endFunction(obj.toString());
        return obj;
    }


    public static void main(String [ ] args)
    {
        Door door = new Door();
        Scale scale = new Scale(door);
        door.close();
        door.open();
    }
}
