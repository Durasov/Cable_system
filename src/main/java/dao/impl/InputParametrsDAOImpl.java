package dao.impl;

import dao.DAO;
import dao.InputParametrsDAO;
import model.InputParametrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InputParametrsDAOImpl implements InputParametrsDAO {
    private DAO dao;

    public InputParametrsDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addInputParametrs(InputParametrs inputParametrs) {
        String query = "INSERT INTO InputParametrs (parametrs_id, mass1, mass2, s1, s2, x1, y1, z1," +
                "x2, y2, z2, ra11, ra12, ra13, ra21, ra22, ra23, ix1, iy1, iz1, ix2, iy2, iz2) VALUES " +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, inputParametrs.getParametrsId());
            preparedStatement.setDouble(2, inputParametrs.getMassFirst());
            preparedStatement.setDouble(3, inputParametrs.getMassSecond());
            preparedStatement.setDouble(4, inputParametrs.getS1());
            preparedStatement.setDouble(5, inputParametrs.getS2());
            preparedStatement.setDouble(6, inputParametrs.getX1());
            preparedStatement.setDouble(7, inputParametrs.getY1());
            preparedStatement.setDouble(8, inputParametrs.getZ1());
            preparedStatement.setDouble(9, inputParametrs.getX2());
            preparedStatement.setDouble(10, inputParametrs.getY2());
            preparedStatement.setDouble(11, inputParametrs.getZ2());
            preparedStatement.setDouble(12, inputParametrs.getRA11());
            preparedStatement.setDouble(13, inputParametrs.getRA12());
            preparedStatement.setDouble(14, inputParametrs.getRA13());
            preparedStatement.setDouble(15, inputParametrs.getRA21());
            preparedStatement.setDouble(16, inputParametrs.getRA22());
            preparedStatement.setDouble(17, inputParametrs.getRA23());
            preparedStatement.setDouble(18, inputParametrs.getIx1());
            preparedStatement.setDouble(19, inputParametrs.getIy1());
            preparedStatement.setDouble(20, inputParametrs.getIz1());
            preparedStatement.setDouble(21, inputParametrs.getIx2());
            preparedStatement.setDouble(22, inputParametrs.getIy2());
            preparedStatement.setDouble(23, inputParametrs.getIz2());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<InputParametrs> getInputParametrs() {
        String query = "SELECT * FROM InputParametrs ORDER BY parametrs_id";
        List<InputParametrs> inputParametrs = new ArrayList<>();
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int parametrs_id = resultSet.getInt(PARAMETRS_ID);
                double mass1 = resultSet.getDouble(MASS1);
                double mass2 = resultSet.getDouble(MASS2);
                double s1 = resultSet.getDouble(S1);
                double s2 = resultSet.getDouble(S2);
                double x1 = resultSet.getDouble(X1);
                double y1 = resultSet.getDouble(Y1);
                double z1 = resultSet.getDouble(Z1);
                double x2 = resultSet.getDouble(X2);
                double y2 = resultSet.getDouble(Y2);
                double z2 = resultSet.getDouble(Z2);
                double ra11 = resultSet.getDouble(RA11);
                double ra12 = resultSet.getDouble(RA12);
                double ra13 = resultSet.getDouble(RA13);
                double ra21 = resultSet.getDouble(RA21);
                double ra22 = resultSet.getDouble(RA22);
                double ra23 = resultSet.getDouble(RA23);
                double Ix1 = resultSet.getDouble(IX1);
                double Iy1 = resultSet.getDouble(IY1);
                double Iz1 = resultSet.getDouble(IZ1);
                double Ix2 = resultSet.getDouble(IX2);
                double Iy2 = resultSet.getDouble(IY2);
                double Iz2 = resultSet.getDouble(IZ2);

                InputParametrs inputParametrs1 = new InputParametrs(parametrs_id, mass1, mass2, s1, s2, x1, y1, z1,
                        x2, y2, z2, ra11, ra12, ra13, ra21, ra22, ra23, Ix1, Iy1, Iz1, Ix2, Iy2, Iz2);
                inputParametrs.add(inputParametrs1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inputParametrs;
    }

    @Override
    public List<InputParametrs> getInputParametrs(InputParametrs result) {
        return null;
    }

    @Override
    public InputParametrs getInputParametrs(int id) {
        String query = "SELECT * FROM InputParametrs WHERE parametrs_id = ?";
        InputParametrs inputParametrs = null;
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int parametrs_id = resultSet.getInt(PARAMETRS_ID);
                double mass1 = resultSet.getDouble(MASS1);
                double mass2 = resultSet.getDouble(MASS2);
                double s1 = resultSet.getDouble(S1);
                double s2 = resultSet.getDouble(S2);
                double x1 = resultSet.getDouble(X1);
                double y1 = resultSet.getDouble(Y1);
                double z1 = resultSet.getDouble(Z1);
                double x2 = resultSet.getDouble(X2);
                double y2 = resultSet.getDouble(Y2);
                double z2 = resultSet.getDouble(Z2);
                double ra11 = resultSet.getDouble(RA11);
                double ra12 = resultSet.getDouble(RA12);
                double ra13 = resultSet.getDouble(RA13);
                double ra21 = resultSet.getDouble(RA21);
                double ra22 = resultSet.getDouble(RA22);
                double ra23 = resultSet.getDouble(RA23);
                double Ix1 = resultSet.getDouble(IX1);
                double Iy1 = resultSet.getDouble(IY1);
                double Iz1 = resultSet.getDouble(IZ1);
                double Ix2 = resultSet.getDouble(IX2);
                double Iy2 = resultSet.getDouble(IY2);
                double Iz2 = resultSet.getDouble(IZ2);

                inputParametrs = new InputParametrs(parametrs_id, mass1, mass2, s1, s2, x1, y1, z1,
                        x2, y2, z2, ra11, ra12, ra13, ra21, ra22, ra23, Ix1, Iy1, Iz1, Ix2, Iy2, Iz2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inputParametrs;
    }

    @Override
    public void updateInputParametrs(InputParametrs inputParametrs) {
        String query = "UPDATE InputParametrs SET mass1 = ? , mass2 = ?, s1 = ?, s2 = ?, x1 = ?, y1 = ?, z1 = ?," +
                "x2 = ?, y2 = ?, z2 = ?, ra11 = ?, ra12 = ?, ra13 = ?, ra21 = ?, ra22 = ?, ra23 = ?, ix1 = ?," +
                " iy1 = ?, iz1 = ?, ix2 = ?, iy2 = ?, iz2 = ? " +
                "WHERE parametrs_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, inputParametrs.getMassFirst());
            preparedStatement.setDouble(2, inputParametrs.getMassSecond());
            preparedStatement.setDouble(3, inputParametrs.getS1());
            preparedStatement.setDouble(4, inputParametrs.getS2());
            preparedStatement.setDouble(5, inputParametrs.getX1());
            preparedStatement.setDouble(6, inputParametrs.getY1());
            preparedStatement.setDouble(7, inputParametrs.getZ1());
            preparedStatement.setDouble(8, inputParametrs.getX2());
            preparedStatement.setDouble(9, inputParametrs.getY2());
            preparedStatement.setDouble(10, inputParametrs.getZ2());
            preparedStatement.setDouble(11, inputParametrs.getRA11());
            preparedStatement.setDouble(12, inputParametrs.getRA12());
            preparedStatement.setDouble(13, inputParametrs.getRA13());
            preparedStatement.setDouble(14, inputParametrs.getRA21());
            preparedStatement.setDouble(15, inputParametrs.getRA22());
            preparedStatement.setDouble(16, inputParametrs.getRA23());
            preparedStatement.setDouble(17, inputParametrs.getIx1());
            preparedStatement.setDouble(18, inputParametrs.getIy1());
            preparedStatement.setDouble(19, inputParametrs.getIz1());
            preparedStatement.setDouble(20, inputParametrs.getIx2());
            preparedStatement.setDouble(21, inputParametrs.getIy2());
            preparedStatement.setDouble(22, inputParametrs.getIz2());
            preparedStatement.setDouble(23, inputParametrs.getParametrsId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInputParametrs(int parametrs_id) {
        String deleteResult = "DELETE FROM InputParametrs WHERE parametrs_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteResult);
            preparedStatement.setInt(1, parametrs_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
