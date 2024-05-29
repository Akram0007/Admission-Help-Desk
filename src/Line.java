import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Line {
    public int box(int x) {
        Path file=null;
        if(x==1){
        file = Paths.get("E:\\Versity\\SEm 5 Assign\\Oop\\AHD\\science.txt");
        }
        if(x==2){
        file = Paths.get("E:\\Versity\\SEm 5 Assign\\Oop\\AHD\\commerce.txt");
        }
        int count=0;
        try {
            count = (int) Files.lines(file).count();
        } catch (IOException ex) {
            Logger.getLogger(Line.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
}

//
//try {
//            fr.close();
//        } catch (IOException ex) {
//            Logger.getLogger(body.class.getName()).log(Level.SEVERE, null, ex);
//        }