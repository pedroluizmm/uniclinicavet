package com.uniclinica.service;

import com.uniclinica.dao.ExameDao;
import com.uniclinica.model.Exame;
import java.util.List;

public class ExameService {
    private final ExameDao dao = new ExameDao();

    public List<Exame> listarExames() {
        return dao.findAll();
    }

    public List<Exame> listarPorConsulta(int consultaId) {
        return dao.findByConsulta(consultaId);
    }

    public void solicitarExame(Exame exame) {
        dao.save(exame);
    }

    public void atualizarExame(Exame exame) {
        dao.update(exame);
    }

    public void removerExame(int id) {
        dao.delete(id);
    }
}
