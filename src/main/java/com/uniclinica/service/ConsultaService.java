package com.uniclinica.service;

import com.uniclinica.dao.ConsultaDao;
import com.uniclinica.model.Consulta;
import java.util.List;

public class ConsultaService {
    private final ConsultaDao dao = new ConsultaDao();

    public List<Consulta> listarConsultas() {
        return dao.findAll();
    }

    public List<Consulta> listarPorAnimal(int animalId) {
        return dao.findByAnimal(animalId);
    }

    public void agendarConsulta(Consulta consulta) {
        dao.save(consulta);
    }

    public void atualizarConsulta(Consulta consulta) {
        dao.update(consulta);
    }

    public void cancelarConsulta(int id) {
        dao.delete(id);
    }
}
