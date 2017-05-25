package br.cesjf.lppo.Servlet;

import br.cesjf.lppo.DAO.PesquisaDAO;
import br.cesjf.lppo.Leitura;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NovoPontoLeituraServlet", urlPatterns = {"/novaleitura.html"})
public class NovoPontoLeituraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idColeta = Integer.parseInt(request.getParameter("idColeta"));

        request.setAttribute("coleta", idColeta);
        request.getRequestDispatcher("WEB-INF/nova-leitura.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Leitura leitura = new Leitura();

        try {
            leitura.setColeta(Integer.parseInt(request.getParameter("txtColeta")));
            leitura.setUnidade(request.getParameter("txtUnidade"));
            leitura.setLocalLeitura(request.getParameter("txtLocalLeitura"));

            PesquisaDAO dao = new PesquisaDAO();
            dao.criarPontoLeitura(leitura);
        } catch (Exception ex) {
            Logger.getLogger(NovoPontoLeituraServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/nova-leitura.jsp");
        }
        response.sendRedirect("leitura.html");

    }

}
