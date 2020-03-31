import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Product_Discount", urlPatterns = "/display_discount")
public class Product_Discount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount_percent = Float.parseFloat(request.getParameter("discount_percent"));
        float discount_amount=price*discount_percent/100;
        float total=price-discount_amount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description: " + product_description+ "</h1>");
        writer.println("<h1>List Price: " + price+ "</h1>");
        writer.println("<h1>Discount Percent: " + discount_percent+ "</h1>");
        writer.println("<h1>Discount Amount: " + discount_amount+ "</h1>");
        writer.println("<h1>Total: " + total+ "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
