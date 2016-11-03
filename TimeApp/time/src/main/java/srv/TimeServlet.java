package srv;

import ejb.TimeBeanLocal;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TimeServlet", urlPatterns = {"/current", ""})
public class TimeServlet extends HttpServlet {

    @EJB
    private TimeBeanLocal timeBean;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date utilDate = new Date();
        Calendar cal = Calendar.getInstance();
        Date curDate = cal.getTime();
        cal.setTime(utilDate);
        cal.set(Calendar.MILLISECOND, 0);
        Timestamp ts = new Timestamp(cal.getTimeInMillis());
        request.setAttribute("time", sdf.format(curDate));
        String userAgent = request.getHeader("user-agent");
        String ipAdress = request.getRemoteAddr();
        timeBean.addToDB(userAgent, ipAdress, ts);
        request.getRequestDispatcher("/time.jsp").forward(request,response);        
    }
    
}