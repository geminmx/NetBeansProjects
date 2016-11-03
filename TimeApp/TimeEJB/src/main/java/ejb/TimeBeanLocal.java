package ejb;

import java.util.Date;
import javax.ejb.Local;

@Local
public interface TimeBeanLocal {
    
    public void addToDB(String userAgent, String ipAdress, Date curDate);

}