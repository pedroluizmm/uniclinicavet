package com.uniclinica.model;

import java.time.LocalDateTime;

public class Consulta {
    private int id;
    private int animalId;
    private LocalDateTime dataHora;
    private String veterinario;
    private String diagnostico;

    public Consulta() {}

    public Consulta(int id, int animalId, LocalDateTime dataHora, String veterinario, String diagnostico) {
        this.id = id;
        this.animalId = animalId;
        this.dataHora = dataHora;
        this.veterinario = veterinario;
        this.diagnostico = diagnostico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
