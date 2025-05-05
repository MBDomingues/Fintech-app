package br.com.fintech.dao;

//IMPORTS
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.modules.Metas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASSE METASDAO DA TABELA METAS
public class MetasDao {

    private Metas metas;

    //CONSTRUTOR
    public MetasDao(Metas metas) {
        this.metas = metas;
    }

    //CONSTRUTOR PADRÃO
    public MetasDao () {}

    //GETTER AND SETTER
    public Metas getMetas() {
        return metas;
    }

    public void setMetas(Metas metas) {
        this.metas = metas;
    }

    //METODO PARA CADASTRAR DADOS NA TABELA META
    public void caadastarMeta () throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "insert into t_metas (cd_meta, vl_alvo, dt_alvo, descricao, vl_atual, t_conta_nm_conta, t_conta_t_usuario_cd_usuario) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, metas.getCd_meta());
        ps.setDouble(2, metas.getVl_alvo());
        ps.setString(3, metas.getDt_alvo());
        ps.setString(4, metas.getDescricao());
        ps.setDouble(5, metas.getVl_atual());
        ps.setInt(6, metas.getNm_conta());
        ps.setInt(7, metas.getCd_usuario());

        ps.executeUpdate();

    }

    //METODO PARA LISTAR OS DADOS DA TABELA META
    public List<Metas> listarMetas() throws SQLException {

        Connection connection = ConnectionFactory.getConnection();

        String sql = "select * from t_metas order by cd_meta";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<Metas> listarMetas = new ArrayList<>();

        while (rs.next()) {
            Metas meta = new Metas();
            meta.setCd_meta(rs.getInt("cd_meta"));
            meta.setVl_alvo(rs.getDouble("vl_alvo"));
            meta.setDt_alvo(rs.getString("dt_alvo"));
            meta.setDescricao(rs.getString("descricao"));
            meta.setVl_atual(rs.getDouble("vl_atual"));
            meta.setNm_conta(rs.getInt("t_conta_nm_conta"));
            meta.setCd_usuario(rs.getInt("t_conta_t_usuario_cd_usuario"));
            listarMetas.add(meta);

        }
        return listarMetas;
    }
}
