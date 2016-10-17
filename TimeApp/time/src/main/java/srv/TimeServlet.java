package srv;

import ejb.TimeBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
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
        request.setAttribute("time", sdf.format(timeBean.getTime()));
        request.getRequestDispatcher("/time.jsp").forward(request,response);
        
    }

}