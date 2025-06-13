package com.uniclinica.dao;

import com.uniclinica.model.Consulta;
import com.uniclinica.util.DBConnection;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ConsultaDao {

    public List<Consulta> findByAnimal(int animalId) {
        List<Consulta> list = new ArrayList<>();
        String sql = "SELECT id, animal_id, data_hora, veterinario, diagnostico FROM consulta WHERE animal_id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, animalId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar consultas", e);
        }
        return list;
    }

    public List<Consulta> findAll() {
        List<Consulta> list = new ArrayList<>();
        String sql = "SELECT id, animal_id, data_hora, veterinario, diagnostico FROM consulta";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar consultas", e);
        }
        return list;
    }

    public void save(Consulta consulta) {
        String sql = "INSERT INTO consulta (animal_id, data_hora, veterinario, diagnostico) VALUES (?,?,?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, consulta.getAnimalId());
            ps.setTimestamp(2, Timestamp.valueOf(consulta.getDataHora()));
            ps.setString(3, consulta.getVeterinario());
            ps.setString(4, consulta.getDiagnostico());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    consulta.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar consulta", e);
        }
    }

    public void update(Consulta consulta) {
        String sql = "UPDATE consulta SET animal_id=?, data_hora=?, veterinario=?, diagnostico=? WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, consulta.getAnimalId());
            ps.setTimestamp(2, Timestamp.valueOf(consulta.getDataHora()));
            ps.setString(3, consulta.getVeterinario());
            ps.setString(4, consulta.getDiagnostico());
            ps.setInt(5, consulta.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar consulta", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM consulta WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover consulta", e);
        }
    }

    private Consulta map(ResultSet rs) throws SQLException {
        Consulta c = new Consulta();
        c.setId(rs.getInt("id"));
        c.setAnimalId(rs.getInt("animal_id"));
        Timestamp ts = rs.getTimestamp("data_hora");
        if (ts != null) c.setDataHora(ts.toLocalDateTime());
        c.setVeterinario(rs.getString("veterinario"));
        c.setDiagnostico(rs.getString("diagnostico"));
        return c;
    }
}
