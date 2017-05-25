package br.cesjf.lppo.DAO;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.Leitura;
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
    private final PreparedStatement opNovoPontoLeitura;
    private final PreparedStatement opListaLeituras;

    public PesquisaDAO() throws Exception {
        Connection conexao = ConnectionFactory.criaConexao();
        opListaColetas = conexao.prepareStatement("SELECT * FROM coleta");
        opNovaColeta = conexao.prepareStatement("INSERT INTO coleta(descricao, dataColeta) VALUES(?, ?)");
        opNovoPontoLeitura = conexao.prepareStatement("INSERT INTO leitura(unidade, localLeitura, coleta) VALUES(?, ?, ?)");
        opListaLeituras = conexao.prepareStatement("SELECT * FROM leitura");
    }

    public List<Coleta> listarTodasColetas() throws Exception {
        List<Coleta> coletas = new ArrayList<>();
        Connection conexao = ConnectionFactory.criaConexao();
        Statement operacao = conexao.createStatement();
        ResultSet resultado = opListaColetas.executeQuery();
        while (resultado.next()) {
            Coleta coletaAtual = new Coleta();
            coletaAtual.setIdColeta(resultado.getInt("idColeta"));
            coletaAtual.setDescricao(resultado.getString("descricao"));
            coletaAtual.setData(resultado.getDate("dataColeta"));
            coletas.add(coletaAtual);
        }
        return coletas;
    }

    public void criarColeta(Coleta coleta) throws Exception {
        try {
            opNovaColeta.clearParameters();
            opNovaColeta.setString(1, coleta.getDescricao());
            opNovaColeta.setDate(2, new Date(coleta.getDataColeta().getTime()));
            opNovaColeta.executeUpdate();

        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir nova Coleta!", ex);

        }
    }

    public void criarPontoLeitura(Leitura leitura) throws Exception {
        try {
            opNovoPontoLeitura.clearParameters();
            opNovoPontoLeitura.setString(1, leitura.getUnidade());
            opNovoPontoLeitura.setString(2, leitura.getLocalLeitura());
            opNovoPontoLeitura.setInt(3, leitura.getColeta());
            opNovoPontoLeitura.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Erro ao criar novo Ponto de Leitura!", ex);
        }
    }
    
    public List<Leitura> listarTodasLeituras() throws Exception{
        List<Leitura> leituras = new ArrayList<>();
        Leitura leituraAtual;
        opListaLeituras.clearParameters();
        ResultSet resultado = opListaLeituras.executeQuery();
        while(resultado.next()){
            leituraAtual = new Leitura();
            leituraAtual.setIdLeitura(resultado.getInt("idLeitura"));
            leituraAtual.setColeta(resultado.getInt("coleta"));
            leituraAtual.setLocalLeitura(resultado.getString("localLeitura"));
            leituraAtual.setLeitura(resultado.getFloat("leitura"));
            leituraAtual.setUnidade(resultado.getString("unidade"));
            leituraAtual.setAtualizacao(resultado.getTimestamp("atualizacao"));
            leituras.add(leituraAtual);
        }
        
        return leituras;
    }
    
    
}
