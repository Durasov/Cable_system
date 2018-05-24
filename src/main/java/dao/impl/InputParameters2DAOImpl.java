package dao.impl;

import dao.DAO;
import dao.InputParameters2DAO;
import model.InputParameters2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InputParameters2DAOImpl implements InputParameters2DAO {
    private DAO dao;

    public InputParameters2DAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addInputParameters2(InputParameters2 inputParameters2) {
        String query = "INSERT INTO InputParametrs2 (parametrs_id2, parametrs_id, w1, w2, w3, w4, w5, w6," +
                "gamma1, alfa1, fi1, gamma2, alfa2, fi2, v, tetta, h, cx01, cx02, cy01, cy02) VALUES " +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, inputParameters2.getParametrsId2());
            preparedStatement.setInt(2, inputParameters2.getParametrsId());
            preparedStatement.setDouble(3, inputParameters2.getW1());
            preparedStatement.setDouble(4, inputParameters2.getW2());
            preparedStatement.setDouble(5, inputParameters2.getW3());
            preparedStatement.setDouble(6, inputParameters2.getW4());
            preparedStatement.setDouble(7, inputParameters2.getW5());
            preparedStatement.setDouble(8, inputParameters2.getW6());
            preparedStatement.setDouble(9, inputParameters2.getGamma1());
            preparedStatement.setDouble(10, inputParameters2.getAlfa1());
            preparedStatement.setDouble(11, inputParameters2.getFi1());
            preparedStatement.setDouble(12, inputParameters2.getGamma2());
            preparedStatement.setDouble(13, inputParameters2.getAlfa2());
            preparedStatement.setDouble(14, inputParameters2.getFi2());
            preparedStatement.setDouble(15, inputParameters2.getV());
            preparedStatement.setDouble(16, inputParameters2.getTetta());
            preparedStatement.setDouble(17, inputParameters2.getH());
            preparedStatement.setDouble(18, inputParameters2.getCx01());
            preparedStatement.setDouble(19, inputParameters2.getCx02());
            preparedStatement.setDouble(20, inputParameters2.getCy01());
            preparedStatement.setDouble(21, inputParameters2.getCy02());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<InputParameters2> getInputParameters2() {
        String query = "SELECT * FROM InputParametrs2 ORDER BY parametrs_id";
        List<InputParameters2> inputParameters2 = new ArrayList<>();
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int parametrs_id2 = resultSet.getInt(PARAMETRS_ID2);
                int parametrs_id = resultSet.getInt(PARAMETRS_ID);
                double w1 = resultSet.getDouble(W1);
                double w2 = resultSet.getDouble(W2);
                double w3 = resultSet.getDouble(W3);
                double w4 = resultSet.getDouble(W4);
                double w5 = resultSet.getDouble(W5);
                double w6 = resultSet.getDouble(W6);
                double gamma1 = resultSet.getDouble(GAMMA1);
                double alfa1 = resultSet.getDouble(ALFA1);
                double fi1 = resultSet.getDouble(FI1);
                double gamma2 = resultSet.getDouble(GAMMA2);
                double alfa2 = resultSet.getDouble(ALFA2);
                double fi2 = resultSet.getDouble(FI2);
                double v = resultSet.getDouble(V);
                double tetta = resultSet.getDouble(TETTA);
                double h = resultSet.getDouble(H);
                double cx01 = resultSet.getDouble(CX01);
                double cx02 = resultSet.getDouble(CX02);
                double cy01 = resultSet.getDouble(CY01);
                double cy02 = resultSet.getDouble(CY02);

                InputParameters2 inputParameters21 = new InputParameters2(parametrs_id2, parametrs_id, w1, w2, w3, w4, w5, w6,
                        gamma1, alfa1, fi1, gamma2, alfa2, fi2, v, tetta, h, cx01, cx02, cy01, cy02);
                inputParameters2.add(inputParameters21);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inputParameters2;
    }

    @Override
    public List<InputParameters2> getInputParameters2(InputParameters2 result) {
        return null;
    }

    @Override
    public InputParameters2 getInputParameters2(int id) {
        String query = "SELECT * FROM InputParametrs WHERE parametrs_id = ?";
        InputParameters2 inputParameters2 = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int parametrs_id2 = resultSet.getInt(PARAMETRS_ID2);
                int parametrs_id = resultSet.getInt(PARAMETRS_ID);
                double w1 = resultSet.getDouble(W1);
                double w2 = resultSet.getDouble(W2);
                double w3 = resultSet.getDouble(W3);
                double w4 = resultSet.getDouble(W4);
                double w5 = resultSet.getDouble(W5);
                double w6 = resultSet.getDouble(W6);
                double gamma1 = resultSet.getDouble(GAMMA1);
                double alfa1 = resultSet.getDouble(ALFA1);
                double fi1 = resultSet.getDouble(FI1);
                double gamma2 = resultSet.getDouble(GAMMA2);
                double alfa2 = resultSet.getDouble(ALFA2);
                double fi2 = resultSet.getDouble(FI2);
                double v = resultSet.getDouble(V);
                double tetta = resultSet.getDouble(TETTA);
                double h = resultSet.getDouble(H);
                double cx01 = resultSet.getDouble(CX01);
                double cx02 = resultSet.getDouble(CX02);
                double cy01 = resultSet.getDouble(CY01);
                double cy02 = resultSet.getDouble(CY02);

                inputParameters2 = new InputParameters2(parametrs_id2, parametrs_id, w1, w2, w3, w4, w5, w6,
                        gamma1, alfa1, fi1, gamma2, alfa2, fi2, v, tetta, h, cx01, cx02, cy01, cy02);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inputParameters2;
    }

    @Override
    public void updateInputParameters2(InputParameters2 inputParameters2) {
        String query = "UPDATE InputParametrs2 SET parametrs_id2 = ? , w1 = ?, w2 = ?, w3 = ?, w4 = ?, w5 = ?, w6 = ?," +
                "gamma1 = ?, alfa1 = ?, fi1 = ?, gamma2 = ?, alfa2 = ?, fi2 = ?, v = ?, tetta = ?, h = ?, cx01 = ?," +
                " cx02 = ?, cy01 = ?, cy02 = ?" +
                "WHERE parametrs_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, inputParameters2.getParametrsId2());
            preparedStatement.setDouble(2, inputParameters2.getW1());
            preparedStatement.setDouble(3, inputParameters2.getW2());
            preparedStatement.setDouble(4, inputParameters2.getW3());
            preparedStatement.setDouble(5, inputParameters2.getW4());
            preparedStatement.setDouble(6, inputParameters2.getW5());
            preparedStatement.setDouble(7, inputParameters2.getW6());
            preparedStatement.setDouble(8, inputParameters2.getGamma1());
            preparedStatement.setDouble(9, inputParameters2.getAlfa1());
            preparedStatement.setDouble(10, inputParameters2.getFi1());
            preparedStatement.setDouble(11, inputParameters2.getGamma2());
            preparedStatement.setDouble(12, inputParameters2.getAlfa2());
            preparedStatement.setDouble(13, inputParameters2.getFi2());
            preparedStatement.setDouble(14, inputParameters2.getV());
            preparedStatement.setDouble(15, inputParameters2.getTetta());
            preparedStatement.setDouble(16, inputParameters2.getH());
            preparedStatement.setDouble(17, inputParameters2.getCx01());
            preparedStatement.setDouble(18, inputParameters2.getCx02());
            preparedStatement.setDouble(19, inputParameters2.getCy01());
            preparedStatement.setDouble(20, inputParameters2.getCy02());
            preparedStatement.setInt(21, inputParameters2.getParametrsId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInputParameters2(int parametrs_id) {
        String deleteResult = "DELETE FROM inputparametrs2 WHERE parametrs_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteResult);
            preparedStatement.setInt(1, parametrs_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

