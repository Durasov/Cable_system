package dao;

import model.Graphics;

import java.util.List;

public interface GraphicsDAO {

    String GRAPHIC_ID = "graphic_id";

    String RESULT_ID = "result_id";

    String GRAPHIC_NAME = "graphic_name";

    String SRC = "src";

    List<Graphics> getGraphics();

    void deleteGraphic(int parametrs_id);
}
