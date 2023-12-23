package com.tbp.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tbp.crud.entity.Train;

import java.util.List;

@Repository
public class TrainRepositoryImpl implements TrainRepository {

    private static final String INSERT_USER_QUERY = "INSERT INTO TRAIN(id,tname,platform,toa) values(?,?,?,?)";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE TRAIN SET tname=? WHERE ID=?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM TRAIN WHERE ID=?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM TRAIN WHERE ID=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM TRAIN";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Train saveTrain(Train train) {
        jdbcTemplate.update(INSERT_USER_QUERY, train.getId(),train.getTname(),train.getPlatform(),train.getToa());
        return train;
    }

    @Override
    public Train updateTrain(Train train) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, train.getTname(),train.getId());
        return train;
    }

    @Override
    public Train getById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {

            return new Train(rs.getInt("id"), rs.getString("tname"), rs.getString("platform"), rs.getString("toa"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "Train got deleted with id " + id;
    }

    @Override
    public List<Train> allTrains() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new Train(rs.getInt("id"), rs.getString("tname"), rs.getString("platform"), rs.getString("toa"));
        });
    }
}
