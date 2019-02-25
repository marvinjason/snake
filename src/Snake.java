
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake
{
    private int length;
    private int speed;
    private int xAxisHead;
    private int yAxisHead;
    private int xAxisTail;
    private int yAxisTail;
    private Direction direction;
    private List<Turn> turns;
    
    public Snake()
    {
        length = 80;
        speed = 100;
        xAxisHead = 90;
        yAxisHead = 240;
        xAxisTail = 10;
        yAxisTail = 240;
        direction = Direction.RIGHT;
        turns = new ArrayList();
    }
    
    public void queueTurn()
    {
        turns.add(new Turn(direction, new Point(xAxisHead, yAxisHead)));
    }
    
    public List<Turn> getTurns()
    {
        return turns;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public int getHeadX()
    {
        return xAxisHead;
    }
    
    public int getHeadY()
    {
        return yAxisHead;
    }
    
    public int getTailX()
    {
        return xAxisTail;
    }
    
    public int getTailY()
    {
        return yAxisTail;
    }
    
    public Direction getDirection()
    {
        return direction;
    }
    
    public void setLength(int length)
    {
        this.length = length;
    }
    
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    public void setHeadX(int xAxisHead)
    {
        this.xAxisHead = xAxisHead;
    }
    
    public void setHeadY(int yAxisHead)
    {
        this.yAxisHead = yAxisHead;
    }
    
    public void setTailX(int xAxisTail)
    {
        this.xAxisTail = xAxisTail;
    }
    
    public void setTailY(int yAxisTail)
    {
        this.yAxisTail = yAxisTail;
    }
    
    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }
}

enum Direction
{
    UP, DOWN, LEFT, RIGHT
}

class Turn
{
    Direction direction;
    Point point;
    
    public Turn(Direction direction, Point point)
    {
        this.direction = direction;
        this.point = point;
    }
    
    public Direction getDirection()
    {
        return direction;
    }
    
    public Point getPoint()
    {
        return point;
    }
}