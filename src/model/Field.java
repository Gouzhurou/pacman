package model;

public class Field {
    public static final int DEFAULT_FIELD_SIZE = 10;
    private Point startPacmanPoint;
    private Cell[][] field; //тут хранятся клетки
    private Point startGhostsPoint;
    private int width;
    private int height;
    public Field(Point startPacmanPoint, Point startGhostsPoint, int width, int height){
        this.startPacmanPoint = new Point(startPacmanPoint);
        this.startGhostsPoint = new Point(startGhostsPoint);

        if (height > 0) this.height = height; //нормализация высоты
        else this.height = DEFAULT_FIELD_SIZE;

        if (width > 0) this.width = width; //нормализация ширины
        else this.width = DEFAULT_FIELD_SIZE;

        field = new Cell[this.height][this.width];
    }
    public Point getStartGhostsPoint(){
        return startGhostsPoint;
    }
    public Cell getCell(int x, int y) {
        if (isPointCorrect(x, y)) return field[y][x];
        return null;
    }
    //добавляем клетку
    public void setCell(Cell cell, int x, int y) {
        field[y][x] = new Cell(cell);
    }
    //стоим с самого права и фигачим вправо => он не понял как получить клетку на 1 больше (не существует) => проблема
    private boolean isPointCorrect(int x, int y){
        return (x >= 0 && x < width && y >= 0 && y < height);
    }
    public Point getStartPacmanPoint() {
        return startPacmanPoint;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
