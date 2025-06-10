package com.uniclinica.dao;

import com.uniclinica.model.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO de Animal - Implementação de acesso a dados será adicionada com JDBC.
 */
public class AnimalDao {

    public List<Animal> findByTutor(int tutorId) {
        // TODO implementar consulta ao banco
        return new ArrayList<>();
    }

    public void save(Animal animal) {
        // TODO inserir animal no banco
    }

    public void update(Animal animal) {
        // TODO atualizar animal no banco
    }

    public void delete(int id) {
        // TODO remover animal do banco
    }
}
