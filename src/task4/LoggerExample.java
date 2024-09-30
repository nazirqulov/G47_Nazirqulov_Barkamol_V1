package task4;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger("a.txt");
        CustomHandler customHandler=new CustomHandler();
        CustomFormatter customFormatter=new CustomFormatter();
        customHandler.setFormatter(customFormatter);
        logger.addHandler(customHandler);
        try {
            throw new Exception("Bu xato!!!");
        }catch (Exception e){
            logger.log(Level.INFO,"Xatolik yuz berdi",e);
        }
    }
}

