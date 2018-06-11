package dao.impl;

import dao.DAO;
import dao.ResultsDAO;
import model.Results;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultsDAOImpl implements ResultsDAO {
    private DAO dao;

    public ResultsDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addResults(Results results) {
        String query = "INSERT INTO result (result_id, parametrs_id, gamma1, alfa1, fi1, n) VALUES " +
                "(?,?,?,?,?,?)";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, results.getResult_id());
            preparedStatement.setDouble(2, results.getParametrsId());
            preparedStatement.setDouble(3, results.getGamma1());
            preparedStatement.setDouble(4, results.getAlfa1());
            preparedStatement.setDouble(5, results.getFi1());
            preparedStatement.setDouble(6, results.getN());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Results> getResults() {
        String query = "SELECT * FROM result ORDER BY parametrs_id";
        List<Results> results = new ArrayList<>();
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int result_id = resultSet.getInt(RESULT_ID);
                int parametrs_id = resultSet.getInt(PARAMETRS_ID);
                double gamma1 = resultSet.getDouble(GAMMA1);
                double alfa1 = resultSet.getDouble(ALFA1);
                double fi1 = resultSet.getDouble(FI1);
                double n = resultSet.getDouble(N);

                Results results1 = new Results(result_id ,parametrs_id,gamma1, alfa1, fi1, n);
                results.add(results1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public void deleteResults(int parametrs_id) {
        String deleteResult = "DELETE FROM result WHERE parametrs_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteResult);
            preparedStatement.setInt(1, parametrs_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
