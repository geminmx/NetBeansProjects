package ejb;

import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;

@Stateless
public class TimeBean implements TimeBeanLocal {

    @Override
    public Date getTime() {
        return Calendar.getInstance().getTime();
    }
}
