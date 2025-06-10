package com.uniclinica.service;

import com.uniclinica.dao.AnimalDao;
import com.uniclinica.model.Animal;
import java.util.List;

public class AnimalService {
    private final AnimalDao dao = new AnimalDao();

    public List<Animal> listarPorTutor(int tutorId) {
        return dao.findByTutor(tutorId);
    }

    public void cadastrarAnimal(Animal animal) {
        dao.save(animal);
    }

    public void atualizarAnimal(Animal animal) {
        dao.update(animal);
    }

    public void removerAnimal(int id) {
        dao.delete(id);
    }
}
