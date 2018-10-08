import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "/Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    protected Map<String, String> memory = new TreeMap<>();

    public Login(){
        System.out.println("Hey! Something got created!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
//        if(name.isEmpty() || pass.)
        System.out.println("This is the method: " + request.getMethod());
        memory.put(name, pass);
        System.out.println(memory);

        // printing the map (TreeMap is already ordered by key)
        Iterator it = memory.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        response.sendRedirect("result.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
