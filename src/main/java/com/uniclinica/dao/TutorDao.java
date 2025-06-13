package com.uniclinica.dao;

import com.uniclinica.model.Tutor;
import com.uniclinica.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO de Tutor - Implementação de acesso a dados será adicionada com JDBC.
 */
public class TutorDao {

    public List<Tutor> findAll() {
        List<Tutor> list = new ArrayList<>();
        String sql = "SELECT id, nome, telefone, email FROM tutor";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Tutor t = new Tutor();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setTelefone(rs.getString("telefone"));
                t.setEmail(rs.getString("email"));
                list.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar tutores", e);
        }
        return list;
    }

    public void save(Tutor tutor) {
        String sql = "INSERT INTO tutor (nome, telefone, email) VALUES (?, ?, ?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, tutor.getNome());
            ps.setString(2, tutor.getTelefone());
            ps.setString(3, tutor.getEmail());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    tutor.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar tutor", e);
        }
    }

    public void update(Tutor tutor) {
        String sql = "UPDATE tutor SET nome=?, telefone=?, email=? WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, tutor.getNome());
            ps.setString(2, tutor.getTelefone());
            ps.setString(3, tutor.getEmail());
            ps.setInt(4, tutor.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar tutor", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM tutor WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover tutor", e);
        }
    }
}
