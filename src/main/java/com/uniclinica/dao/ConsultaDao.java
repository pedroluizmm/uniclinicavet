package com.uniclinica.dao;

import com.uniclinica.model.Consulta;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO de Consulta - Implementação de acesso a dados será adicionada com JDBC.
 */
public class ConsultaDao {

    public List<Consulta> findByAnimal(int animalId) {
        // TODO implementar consulta ao banco
        return new ArrayList<>();
    }

    public void save(Consulta consulta) {
        // TODO inserir consulta no banco
    }

    public void update(Consulta consulta) {
        // TODO atualizar consulta no banco
    }

    public void delete(int id) {
        // TODO remover consulta do banco
    }
}
