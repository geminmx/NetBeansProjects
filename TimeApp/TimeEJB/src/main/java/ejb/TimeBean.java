package ejb;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TimeBean implements TimeBeanLocal {
    
    @PersistenceContext(unitName = "TimeDB")
    private EntityManager em;

    @Override
    public void addToDB(String userAgent, String ipAdress, Date curDate) {
        Visits visit = new Visits();
        visit.setUserAgent(userAgent);
        visit.setIpAdress(ipAdress);
        visit.setCurDate(curDate);
        em.persist(visit);
    }
    
}