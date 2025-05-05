package br.com.fintech.dao;

import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.modules.TrilhaInvestimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrilhaInvestimentoDAO {
    private TrilhaInvestimento trilha;

    public TrilhaInvestimentoDAO(TrilhaInvestimento trilha) {
        this.trilha = trilha;
    }

    public TrilhaInvestimentoDAO() {

    }


    public void insert() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO T_TRILHA_INVESTIMENTOS (cd_trilha, T_METAS_cd_meta, vl_investido, tipo_investimento, vl_aplicado, rentabilidade, prazo, risco, T_METAS_T_CONTA_nm_conta, T_METAS_T_CONTA_cd_usuario, transacao) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, trilha.getCdTrilha());
        stmt.setInt(2, trilha.getCdMeta());
        stmt.setFloat(3, trilha.getVlInvestido());
        stmt.setString(4, trilha.getTipoInvestimento());
        stmt.setFloat(5, trilha.getVlAplicado());
        stmt.setFloat(6, trilha.getRentabilidade());
        stmt.setString(7, trilha.getPrazo());
        stmt.setString(8, trilha.getRisco());
        stmt.setInt(9, trilha.getNmConta());
        stmt.setInt(10, trilha.getCdUsuario());
        stmt.setString(11, trilha.getTransacao());

        stmt.executeUpdate();

    }

    public List<TrilhaInvestimento> getAll() throws SQLException {

        Connection conn = ConnectionFactory.getConnection();

        List<TrilhaInvestimento> lista = new ArrayList<>();

        String sql = "SELECT * FROM T_TRILHA_INVESTIMENTOS";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            TrilhaInvestimento t = new TrilhaInvestimento(
                    rs.getInt("cd_trilha"),
                    rs.getInt("T_METAS_cd_meta"),
                    rs.getInt("T_METAS_T_CONTA_nm_conta"),
                    rs.getInt("T_METAS_T_CONTA_cd_usuario"),
                    rs.getFloat("vl_investido"),
                    rs.getString("tipo_investimento"),
                    rs.getFloat("vl_aplicado"),
                    rs.getFloat("rentabilidade"),
                    rs.getString("prazo"),
                    rs.getString("risco"),
                    rs.getString("transacao")
                    );
                    lista.add(t);
        }
        return lista;
    }

}


