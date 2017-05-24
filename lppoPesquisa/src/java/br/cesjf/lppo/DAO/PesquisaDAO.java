package br.cesjf.lppo.DAO;

import br.cesjf.lppo.Coleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class PesquisaDAO {
    private final PreparedStatement opListaColetas;
    private final PreparedStatement opNovaColeta;
    
    public PesquisaDAO() throws Exception {
        Connection conexao = ConnectionFactory.criaConexao();
        opListaColetas = conexao.prepareStatement("SELECT * FROM coleta");
        opNovaColeta = conexao.prepareStatement("INSERT INTO coleta(descricao, data) VALUES(?, ?)");
        
    }
    
    public List<Coleta> listarTodasColetas() throws Exception{
        List<Coleta> coletas = new ArrayList<>();
        Connection conexao = ConnectionFactory.criaConexao();
        Statement operacao = conexao.createStatement();
        ResultSet resultado = opListaColetas.executeQuery();
        while(resultado.next()){
            Coleta coletaAtual = new Coleta();
            coletaAtual.setIdColeta(resultado.getInt("idColeta"));
            coletaAtual.setDescricao(resultado.getString("descricao"));
            coletaAtual.setData(resultado.getDate("data"));
            coletas.add(coletaAtual);
        }
        return coletas;
    }
    
    public void criarColeta(Coleta coleta) throws Exception{
        try{
            opNovaColeta.clearParameters();
            opNovaColeta.setString(1, coleta.getDescricao());
            opNovaColeta.setDate(2, new Date(coleta.getData().getTime()));
            opNovaColeta.executeUpdate();
        }catch(SQLException ex){
            throw new Exception("Erro ao inserir nova Coleta!", ex);
            
        }
    }
   
    
}
