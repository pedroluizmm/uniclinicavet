package com.uniclinica.dao;

import com.uniclinica.model.Exame;
import com.uniclinica.util.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ExameDao {

    public List<Exame> findByConsulta(int consultaId) {
        List<Exame> list = new ArrayList<>();
        String sql = "SELECT id, consulta_id, tipo, status, data_entrega FROM exame WHERE consulta_id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, consultaId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar exames", e);
        }
        return list;
    }

    public List<Exame> findAll() {
        List<Exame> list = new ArrayList<>();
        String sql = "SELECT id, consulta_id, tipo, status, data_entrega FROM exame";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar exames", e);
        }
        return list;
    }

    public void save(Exame exame) {
        String sql = "INSERT INTO exame (consulta_id, tipo, status, data_entrega) VALUES (?,?,?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, exame.getConsultaId());
            ps.setString(2, exame.getTipo());
            ps.setString(3, exame.getStatus());
            if (exame.getDataEntrega() != null)
                ps.setDate(4, Date.valueOf(exame.getDataEntrega()));
            else
                ps.setNull(4, Types.DATE);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) exame.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar exame", e);
        }
    }

    public void update(Exame exame) {
        String sql = "UPDATE exame SET consulta_id=?, tipo=?, status=?, data_entrega=? WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, exame.getConsultaId());
            ps.setString(2, exame.getTipo());
            ps.setString(3, exame.getStatus());
            if (exame.getDataEntrega() != null)
                ps.setDate(4, Date.valueOf(exame.getDataEntrega()));
            else
                ps.setNull(4, Types.DATE);
            ps.setInt(5, exame.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar exame", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM exame WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover exame", e);
        }
    }

    private Exame map(ResultSet rs) throws SQLException {
        Exame e = new Exame();
        e.setId(rs.getInt("id"));
        e.setConsultaId(rs.getInt("consulta_id"));
        e.setTipo(rs.getString("tipo"));
        e.setStatus(rs.getString("status"));
        Date d = rs.getDate("data_entrega");
        if (d != null) e.setDataEntrega(d.toLocalDate());
        return e;
    }
}
