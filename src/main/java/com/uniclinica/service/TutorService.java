package com.uniclinica.service;

import com.uniclinica.dao.TutorDao;
import com.uniclinica.model.Tutor;
import java.util.List;

public class TutorService {
    private final TutorDao dao = new TutorDao();

    public List<Tutor> listarTutores() {
        return dao.findAll();
    }

    public void cadastrarTutor(Tutor tutor) {
        dao.save(tutor);
    }

    public void atualizarTutor(Tutor tutor) {
        dao.update(tutor);
    }

    public void removerTutor(int id) {
        dao.delete(id);
    }
}
