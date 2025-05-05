package br.com.fintech.dao;

import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.modules.ResumoFinanceiro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResumoFinanceiroDAO {

    private ResumoFinanceiro resumo;

    public ResumoFinanceiroDAO() {}

    public ResumoFinanceiroDAO(ResumoFinanceiro resumo) {
        this.resumo = resumo;
    }

    public void insert() throws SQLException {

        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO T_RESUMO_FINANCEIRO (cd_resumo, mes_ano, total_renda, total_gasto, saldo_disponivel, vl_faltante_meta) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, resumo.getCdResumo());
            stmt.setString(2, resumo.getMesAno());
            stmt.setFloat(3, resumo.getTotalRenda());
            stmt.setFloat(4, resumo.getTotalGasto());
            stmt.setFloat(5, resumo.getSaldoDisponivel());
            stmt.setFloat(6, resumo.getVlFaltanteMeta());

            stmt.executeUpdate();
            System.out.println("Resumo financeiro inserido com sucesso.");
    }

    public List<ResumoFinanceiro> getAll() throws SQLException {

        Connection conn = ConnectionFactory.getConnection();
        List<ResumoFinanceiro> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_RESUMO_FINANCEIRO";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
                ResumoFinanceiro rf = new ResumoFinanceiro(
                        rs.getInt("cd_resumo"),
                        rs.getString("mes_ano"),
                        rs.getFloat("total_renda"),
                        rs.getFloat("total_gasto"),
                        rs.getFloat("saldo_disponivel"),
                        rs.getFloat("vl_faltante_meta")
                );
                lista.add(rf);
            }
        return lista;
    }
}