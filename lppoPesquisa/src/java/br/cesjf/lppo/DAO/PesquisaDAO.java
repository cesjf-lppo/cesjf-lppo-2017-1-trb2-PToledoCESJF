package br.cesjf.lppo.DAO;

import br.cesjf.lppo.Coleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PesquisaDAO {
    private final PreparedStatement opListarColetas;

    public PesquisaDAO() throws Exception {
        Connection conexao = ConnectionFactory.criaConexao();
        opListarColetas = conexao.prepareStatement("SELECT * FROM coleta");
        
    }
    
    public List<Coleta> listarTodasColetas() throws Exception{
        List<Coleta> coletas = new ArrayList<>();
        Connection conexao = ConnectionFactory.criaConexao();
        Statement operacao = conexao.createStatement();
        ResultSet resultado = opListarColetas.executeQuery();
        while(resultado.next()){
            Coleta coletaAtual = new Coleta();
            coletaAtual.setIdColeta(resultado.getInt("id"));
            coletaAtual.setDescricao(resultado.getString("descricao"));
            coletaAtual.setData(resultado.getDate("data"));
        }
        return coletas;
    }
   
    
}
