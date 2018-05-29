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
                "x2, y2, z2, x3, y3, z3, ix1, iy1, iz1, ix2, iy2, iz2, cx1, cy1, cx2, cy2, my1, mz1, my2, mz2," +
                "w11, w12, w13, w21, w22, w23, w31, w32, w33, gamma1, alfa1, fi1, gamma2, alfa2, fi2, gamma3, alfa3, fi3," +
                " v, tetta, h) VALUES " +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            preparedStatement.setDouble(12, inputParametrs.getX3());
            preparedStatement.setDouble(13, inputParametrs.getY3());
            preparedStatement.setDouble(14, inputParametrs.getZ3());
            preparedStatement.setDouble(15, inputParametrs.getIx1());
            preparedStatement.setDouble(16, inputParametrs.getIy1());
            preparedStatement.setDouble(17, inputParametrs.getIz1());
            preparedStatement.setDouble(18, inputParametrs.getIx2());
            preparedStatement.setDouble(19, inputParametrs.getIy2());
            preparedStatement.setDouble(20, inputParametrs.getIz2());
            preparedStatement.setDouble(21, inputParametrs.getCx1());
            preparedStatement.setDouble(22, inputParametrs.getCy1());
            preparedStatement.setDouble(23, inputParametrs.getCx2());
            preparedStatement.setDouble(24, inputParametrs.getCy2());
            preparedStatement.setDouble(25, inputParametrs.getMy1());
            preparedStatement.setDouble(26, inputParametrs.getMz1());
            preparedStatement.setDouble(27, inputParametrs.getMy2());
            preparedStatement.setDouble(28, inputParametrs.getMz2());
            preparedStatement.setDouble(29, inputParametrs.getW11());
            preparedStatement.setDouble(30, inputParametrs.getW12());
            preparedStatement.setDouble(31, inputParametrs.getW13());
            preparedStatement.setDouble(32, inputParametrs.getW21());
            preparedStatement.setDouble(33, inputParametrs.getW22());
            preparedStatement.setDouble(34, inputParametrs.getW23());
            preparedStatement.setDouble(35, inputParametrs.getW31());
            preparedStatement.setDouble(36, inputParametrs.getW32());
            preparedStatement.setDouble(37, inputParametrs.getW33());
            preparedStatement.setDouble(38, inputParametrs.getGamma1());
            preparedStatement.setDouble(39, inputParametrs.getAlfa1());
            preparedStatement.setDouble(40, inputParametrs.getFi1());
            preparedStatement.setDouble(41, inputParametrs.getGamma2());
            preparedStatement.setDouble(42, inputParametrs.getAlfa2());
            preparedStatement.setDouble(43, inputParametrs.getFi2());
            preparedStatement.setDouble(44, inputParametrs.getGamma3());
            preparedStatement.setDouble(45, inputParametrs.getAlfa3());
            preparedStatement.setDouble(46, inputParametrs.getFi3());
            preparedStatement.setDouble(47, inputParametrs.getV());
            preparedStatement.setDouble(48, inputParametrs.getTetta());
            preparedStatement.setDouble(49, inputParametrs.getH());
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
                double x3 = resultSet.getDouble(X3);
                double y3 = resultSet.getDouble(Y3);
                double z3 = resultSet.getDouble(Z3);
                double Ix1 = resultSet.getDouble(IX1);
                double Iy1 = resultSet.getDouble(IY1);
                double Iz1 = resultSet.getDouble(IZ1);
                double Ix2 = resultSet.getDouble(IX2);
                double Iy2 = resultSet.getDouble(IY2);
                double Iz2 = resultSet.getDouble(IZ2);
                double cx1 = resultSet.getDouble(CX1);
                double cy1 = resultSet.getDouble(CY1);
                double cx2 = resultSet.getDouble(CX2);
                double cy2 = resultSet.getDouble(CY2);
                double my1 = resultSet.getDouble(MY1);
                double mz1 = resultSet.getDouble(MZ1);
                double my2 = resultSet.getDouble(MY2);
                double mz2 = resultSet.getDouble(MZ2);
                double w11 = resultSet.getDouble(W11);
                double w12 = resultSet.getDouble(W12);
                double w13 = resultSet.getDouble(W13);
                double w21 = resultSet.getDouble(W21);
                double w22 = resultSet.getDouble(W22);
                double w23 = resultSet.getDouble(W23);
                double w31 = resultSet.getDouble(W31);
                double w32 = resultSet.getDouble(W32);
                double w33 = resultSet.getDouble(W33);
                double gamma1 = resultSet.getDouble(GAMMA1);
                double alfa1 = resultSet.getDouble(ALFA1);
                double fi1 = resultSet.getDouble(FI1);
                double gamma2 = resultSet.getDouble(GAMMA2);
                double alfa2 = resultSet.getDouble(ALFA2);
                double fi2 = resultSet.getDouble(FI2);
                double gamma3 = resultSet.getDouble(GAMMA3);
                double alfa3 = resultSet.getDouble(ALFA3);
                double fi3 = resultSet.getDouble(FI3);
                double v = resultSet.getDouble(V);
                double tetta = resultSet.getDouble(TETTA);
                double h = resultSet.getDouble(H);

                InputParametrs inputParametrs1 = new InputParametrs(parametrs_id, mass1, mass2, s1, s2, x1, y1, z1,
                        x2, y2, z2, x3, y3, z3, Ix1, Iy1, Iz1, Ix2, Iy2, Iz2, cx1, cy1, cx2, cy2, my1, mz1, my2, mz2,
                        w11, w12, w13, w21, w22, w23, w31, w32, w33, gamma1, alfa1, fi1, gamma2, alfa2, fi2,
                        gamma3, alfa3, fi3, v, tetta, h);
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
                double x3 = resultSet.getDouble(X3);
                double y3 = resultSet.getDouble(Y3);
                double z3 = resultSet.getDouble(Z3);
                double Ix1 = resultSet.getDouble(IX1);
                double Iy1 = resultSet.getDouble(IY1);
                double Iz1 = resultSet.getDouble(IZ1);
                double Ix2 = resultSet.getDouble(IX2);
                double Iy2 = resultSet.getDouble(IY2);
                double Iz2 = resultSet.getDouble(IZ2);
                double cx1 = resultSet.getDouble(CX1);
                double cy1 = resultSet.getDouble(CY1);
                double cx2 = resultSet.getDouble(CX2);
                double cy2 = resultSet.getDouble(CY2);
                double my1 = resultSet.getDouble(MY1);
                double mz1 = resultSet.getDouble(MZ1);
                double my2 = resultSet.getDouble(MY2);
                double mz2 = resultSet.getDouble(MZ2);
                double w11 = resultSet.getDouble(W11);
                double w12 = resultSet.getDouble(W12);
                double w13 = resultSet.getDouble(W13);
                double w21 = resultSet.getDouble(W21);
                double w22 = resultSet.getDouble(W22);
                double w23 = resultSet.getDouble(W23);
                double w31 = resultSet.getDouble(W31);
                double w32 = resultSet.getDouble(W32);
                double w33 = resultSet.getDouble(W33);
                double gamma1 = resultSet.getDouble(GAMMA1);
                double alfa1 = resultSet.getDouble(ALFA1);
                double fi1 = resultSet.getDouble(FI1);
                double gamma2 = resultSet.getDouble(GAMMA2);
                double alfa2 = resultSet.getDouble(ALFA2);
                double fi2 = resultSet.getDouble(FI2);
                double gamma3 = resultSet.getDouble(GAMMA3);
                double alfa3 = resultSet.getDouble(ALFA3);
                double fi3 = resultSet.getDouble(FI3);
                double v = resultSet.getDouble(V);
                double tetta = resultSet.getDouble(TETTA);
                double h = resultSet.getDouble(H);

                inputParametrs = new InputParametrs(parametrs_id, mass1, mass2, s1, s2, x1, y1, z1,
                        x2, y2, z2, x3, y3, z3, Ix1, Iy1, Iz1, Ix2, Iy2, Iz2, cx1, cy1, cx2, cy2, my1, mz1, my2, mz2,
                        w11, w12, w13, w21, w22, w23, w31, w32, w33, gamma1, alfa1, fi1, gamma2, alfa2, fi2,
                        gamma3, alfa3, fi3, v, tetta, h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inputParametrs;
    }

    @Override
    public void updateInputParametrs(InputParametrs inputParametrs) {
        String query = "UPDATE InputParametrs SET mass1 = ? , mass2 = ?, s1 = ?, s2 = ?, x1 = ?, y1 = ?, z1 = ?," +
                "x2 = ?, y2 = ?, z2 = ?, x3 = ?, y3 = ?, z3 = ?, ix1 = ?, iy1 = ?, iz1 = ?, ix2 = ?, iy2 = ?, iz2 = ?," +
                "cx1 = ?, cy1 = ?, cx2 = ?, cy2 = ?, my1 = ?, mz1 = ?, my2 = ?, mz2 = ?, w11 = ?, w12 = ?, w13 = ?," +
                "w21 = ?, w22 = ?, w23 = ?, w31 = ?, w32 = ?, w33 = ?, gamma1 = ?, alfa1 = ?, fi1 = ?," +
                "gamma2 = ?, alfa2 = ?, fi2 = ?, gamma3 = ?, alfa3 = ?, fi3 = ?, v = ?, tetta = ?, h = ? " +
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
            preparedStatement.setDouble(11, inputParametrs.getX3());
            preparedStatement.setDouble(12, inputParametrs.getY3());
            preparedStatement.setDouble(13, inputParametrs.getZ3());
            preparedStatement.setDouble(14, inputParametrs.getIx1());
            preparedStatement.setDouble(15, inputParametrs.getIy1());
            preparedStatement.setDouble(16, inputParametrs.getIz1());
            preparedStatement.setDouble(17, inputParametrs.getIx2());
            preparedStatement.setDouble(18, inputParametrs.getIy2());
            preparedStatement.setDouble(19, inputParametrs.getIz2());
            preparedStatement.setDouble(20, inputParametrs.getCx1());
            preparedStatement.setDouble(21, inputParametrs.getCy1());
            preparedStatement.setDouble(22, inputParametrs.getCx2());
            preparedStatement.setDouble(23, inputParametrs.getCy2());
            preparedStatement.setDouble(24, inputParametrs.getMy1());
            preparedStatement.setDouble(25, inputParametrs.getMz1());
            preparedStatement.setDouble(26, inputParametrs.getMy2());
            preparedStatement.setDouble(27, inputParametrs.getMz2());
            preparedStatement.setDouble(28, inputParametrs.getW11());
            preparedStatement.setDouble(29, inputParametrs.getW12());
            preparedStatement.setDouble(30, inputParametrs.getW13());
            preparedStatement.setDouble(31, inputParametrs.getW21());
            preparedStatement.setDouble(32, inputParametrs.getW22());
            preparedStatement.setDouble(33, inputParametrs.getW23());
            preparedStatement.setDouble(34, inputParametrs.getW31());
            preparedStatement.setDouble(35, inputParametrs.getW32());
            preparedStatement.setDouble(36, inputParametrs.getW33());
            preparedStatement.setDouble(37, inputParametrs.getGamma1());
            preparedStatement.setDouble(38, inputParametrs.getAlfa1());
            preparedStatement.setDouble(39, inputParametrs.getFi1());
            preparedStatement.setDouble(40, inputParametrs.getGamma2());
            preparedStatement.setDouble(41, inputParametrs.getAlfa2());
            preparedStatement.setDouble(42, inputParametrs.getFi2());
            preparedStatement.setDouble(43, inputParametrs.getGamma3());
            preparedStatement.setDouble(44, inputParametrs.getAlfa3());
            preparedStatement.setDouble(45, inputParametrs.getFi3());
            preparedStatement.setDouble(46, inputParametrs.getV());
            preparedStatement.setDouble(47, inputParametrs.getTetta());
            preparedStatement.setDouble(48, inputParametrs.getH());
            preparedStatement.setDouble(49, inputParametrs.getParametrsId());
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
