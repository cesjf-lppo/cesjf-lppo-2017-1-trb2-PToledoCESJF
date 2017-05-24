package br.cesjf.lppo.Servlet;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.DAO.PesquisaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ColetaServlet", urlPatterns = {"/coleta.html"})
public class ListaColetaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Coleta> coletas;
        
        try {
            PesquisaDAO dao = new PesquisaDAO();
            coletas = dao.listarTodasColetas();
        } catch (Exception ex) {
            Logger.getLogger(ListaColetaServlet.class.getName()).log(Level.SEVERE, null, ex);
            coletas = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        request.setAttribute("listColetas", coletas);
        request.getRequestDispatcher("/WEB-INF/lista-coletas.jsp").forward(request, response);
    }

}
