package br.cesjf.lppo.Servlet;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.DAO.PesquisaDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NovaColetaServlet", urlPatterns = {"/novacoleta.html"})
public class NovaColetaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/nova-coleta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Coleta coleta = new Coleta();
            coleta.setDescricao(request.getParameter("txtDescricao"));
            coleta.setData(formataData.parse(request.getParameter("txtDataColeta")));

            PesquisaDAO dao = new PesquisaDAO();
            dao.criarColeta(coleta);
        } catch (Exception ex) {
            Logger.getLogger(NovaColetaServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/nova-coleta.jsp");
        }

        response.sendRedirect("coleta.html");
    }

}
