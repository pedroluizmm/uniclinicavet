package com.uniclinica.model;

import java.time.LocalDate;

public class Exame {
    private int id;
    private int consultaId;
    private String tipo;
    private String status;
    private LocalDate dataEntrega;

    public Exame() {}

    public Exame(int id, int consultaId, String tipo, String status, LocalDate dataEntrega) {
        this.id = id;
        this.consultaId = consultaId;
        this.tipo = tipo;
        this.status = status;
        this.dataEntrega = dataEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(int consultaId) {
        this.consultaId = consultaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
