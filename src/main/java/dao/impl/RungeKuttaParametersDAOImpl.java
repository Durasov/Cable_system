package dao.impl;

import dao.DAO;
import dao.RungeKuttaParametersDAO;
import model.RungeKuttaParameters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RungeKuttaParametersDAOImpl implements RungeKuttaParametersDAO {
    private DAO dao;

    public RungeKuttaParametersDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public List<RungeKuttaParameters> getRungeKuttaParameters() {
        String query = "SELECT * FROM InputParametrs ORDER BY parametrs_id";
        List<RungeKuttaParameters> rungeKuttaParameters = new ArrayList<>();
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rkparameters_id = resultSet.getInt(RKPARAMETERS_ID);
                int parametrs_id = resultSet.getInt(PARAMETRS_ID);
                double h = resultSet.getDouble(H);
                double t0 = resultSet.getDouble(T0);
                double nmax = resultSet.getDouble(NMAX);

                RungeKuttaParameters rungeKuttaParameters1 = new RungeKuttaParameters(rkparameters_id ,parametrs_id,h, t0, nmax);
                rungeKuttaParameters.add(rungeKuttaParameters1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rungeKuttaParameters;
    }
}
