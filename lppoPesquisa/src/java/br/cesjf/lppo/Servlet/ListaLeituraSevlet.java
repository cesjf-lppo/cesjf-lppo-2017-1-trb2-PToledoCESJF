package br.cesjf.lppo.Servlet;

import br.cesjf.lppo.DAO.PesquisaDAO;
import br.cesjf.lppo.Leitura;
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

@WebServlet(name = "ListaLeituraSevlet", urlPatterns = {"/leitura.html"})
public class ListaLeituraSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Leitura> leituras;
        
        try {
            PesquisaDAO dao = new PesquisaDAO();
            leituras = dao.listarTodasLeituras();
        } catch (Exception ex) {
            Logger.getLogger(ListaLeituraSevlet.class.getName()).log(Level.SEVERE, null, ex);
            leituras = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        request.setAttribute("listLeituras", leituras);
        request.getRequestDispatcher("WEB-INF/lista-leitura.jsp").forward(request, response);
        
    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         //response.sendRedirect("leitura.html");
         request.getRequestDispatcher("/WEB-INF/lista-leitura.jsp").forward(request, response);
     }

}
