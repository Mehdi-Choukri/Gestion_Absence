package sample.daoAPI;

import sample.daoAPI.api.Dao;
import sample.domainClasses.Administrateur;
import sample.domainClasses.Utilisateur;
import sample.helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class AdministrateurDao implements Dao<Administrateur> {
    @Override
    public Optional<Administrateur> get(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Administrateur> get(Calendar id) {
        return Optional.empty();
    }

    @Override
    public List<Administrateur> getAll() {
        return null;
    }

    @Override
    public void save(Administrateur administrateur) {

    }

    @Override
    public void update(Administrateur administrateur) {

    }

    @Override
    public void delete(Administrateur administrateur) {

    }
}