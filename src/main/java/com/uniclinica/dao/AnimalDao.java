package com.uniclinica.dao;

import com.uniclinica.model.Animal;
import com.uniclinica.util.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class AnimalDao {

    public List<Animal> findByTutor(int tutorId) {
        List<Animal> list = new ArrayList<>();
        String sql = "SELECT id, tutor_id, nome, especie, raca, data_nascimento FROM animal WHERE tutor_id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, tutorId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar animais", e);
        }
        return list;
    }

    public List<Animal> findAll() {
        List<Animal> list = new ArrayList<>();
        String sql = "SELECT id, tutor_id, nome, especie, raca, data_nascimento FROM animal";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar animais", e);
        }
        return list;
    }

    public void save(Animal animal) {
        String sql = "INSERT INTO animal (tutor_id, nome, especie, raca, data_nascimento) VALUES (?,?,?,?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, animal.getTutorId());
            ps.setString(2, animal.getNome());
            ps.setString(3, animal.getEspecie());
            ps.setString(4, animal.getRaca());
            ps.setDate(5, Date.valueOf(animal.getDataNascimento()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    animal.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar animal", e);
        }
    }

    public void update(Animal animal) {
        String sql = "UPDATE animal SET tutor_id=?, nome=?, especie=?, raca=?, data_nascimento=? WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, animal.getTutorId());
            ps.setString(2, animal.getNome());
            ps.setString(3, animal.getEspecie());
            ps.setString(4, animal.getRaca());
            ps.setDate(5, Date.valueOf(animal.getDataNascimento()));
            ps.setInt(6, animal.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar animal", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM animal WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover animal", e);
        }
    }

    private Animal map(ResultSet rs) throws SQLException {
        Animal a = new Animal();
        a.setId(rs.getInt("id"));
        a.setTutorId(rs.getInt("tutor_id"));
        a.setNome(rs.getString("nome"));
        a.setEspecie(rs.getString("especie"));
        a.setRaca(rs.getString("raca"));
        Date d = rs.getDate("data_nascimento");
        if (d != null) a.setDataNascimento(d.toLocalDate());
        return a;
    }
}
