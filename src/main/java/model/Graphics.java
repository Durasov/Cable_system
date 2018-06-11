package model;

public class Graphics {
    private int graphic_id;
    private int result_id;
    private String graphic_name;
    private String src;

    public Graphics(){

    }

    public Graphics(int graphic_id,int result_id, String graphic_name, String src){
        this.graphic_id = graphic_id;
        this.result_id = result_id;
        this.graphic_name = graphic_name;
        this.src = src;
    }

    public int getGraphic_id() {
        return graphic_id;
    }

    public void setGraphic_id(int graphic_id) {
        this.graphic_id = graphic_id;
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public String getGraphic_name() {
        return graphic_name;
    }

    public void setGraphic_name(String graphic_name) {
        this.graphic_name = graphic_name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
