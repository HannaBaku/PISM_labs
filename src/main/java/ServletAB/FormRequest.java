package ServletAB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormRequest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String header = request.getParameter("header");
        String rowCount = request.getParameter("rowCount");
        String columnCount = request.getParameter("columnCount");
        String backColor = request.getParameter("backColor");

        PrintWriter out = null;
        try {
            int rowC = 0, colC = 0;
            String error = "";
            try {
                rowC = Integer.parseInt(rowCount);
                colC = Integer.parseInt(columnCount);
            } catch (NumberFormatException ex) {
                error = ex.toString();
            }
            out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Таблица</title>");
            out.println("</head>");
            out.println("<style> body{background-color: appworkspace;}</style>");
            out.println("<body>");
            out.println("<p style=\"text-align:center\"><strong><span style=\"font-family:Verdana,Geneva,sans-serif\"><span style=\"font-size:24px\">Таблица:</span></span></strong></p>\n\n");
            if (!error.equals("")) {
                out.println("Ошибка: " + error);
            } else {
                out.println("<table bgcolor = \"" + backColor + "\" align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:500px\"><caption>" + header + "</caption><tbody>");
                for (int i = 0; i < rowC; i++) {
                    out.println("<tr>");
                    for (int j = 0; j < colC; j++) {
                        out.println("<td>&nbsp;</td>");
                    }
                    out.println("</tr>");
                }
            }
            out.println("</tbody></table>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ignored) {
        } finally {
            out.close();
        }
    }
}


