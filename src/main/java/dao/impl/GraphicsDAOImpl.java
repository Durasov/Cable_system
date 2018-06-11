package dao.impl;

import dao.DAO;
import dao.GraphicsDAO;
import model.Graphics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraphicsDAOImpl implements GraphicsDAO {

    private DAO dao;

    public GraphicsDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Graphics> getGraphics() {
        String query = "SELECT * FROM result ORDER BY parametrs_id";
        List<Graphics> graphics = new ArrayList<>();
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int graphic_id = resultSet.getInt(GRAPHIC_ID);
                int result_id = resultSet.getInt(RESULT_ID);
                String graphic_name = resultSet.getString(GRAPHIC_NAME);
                String src = resultSet.getString(SRC);

                Graphics graphics1 = new Graphics(graphic_id,result_id ,graphic_name,src);
                graphics.add(graphics1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return graphics;
    }

    @Override
    public void deleteGraphic(int result_id) {
        String deleteResult = "DELETE FROM graphics WHERE result_id = ?";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteResult);
            preparedStatement.setInt(1, result_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
