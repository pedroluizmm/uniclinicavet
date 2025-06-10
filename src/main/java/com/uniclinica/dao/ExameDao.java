package com.uniclinica.dao;

import com.uniclinica.model.Exame;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO de Exame - Implementação de acesso a dados será adicionada com JDBC.
 */
public class ExameDao {

    public List<Exame> findByConsulta(int consultaId) {
        // TODO implementar consulta ao banco
        return new ArrayList<>();
    }

    public void save(Exame exame) {
        // TODO inserir exame no banco
    }

    public void update(Exame exame) {
        // TODO atualizar exame no banco
    }

    public void delete(int id) {
        // TODO remover exame do banco
    }
}
