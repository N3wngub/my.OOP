package RectangleAndBox;

public class Box extends Rectangle {
    double depth;

    public Box() {
        super();
        length = 0.0;
        width = 0.0;
    }
    public Box(double length, double width) {
        super(length, width);
        this.length = length;
        this.width = width;
    }
    public void setDimention(double length, double width, double depth) {
        super.setDimention(length, width);
        this.depth = depth;
    }
    public double getDepth() {
        return depth;
    }
    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double volumn (){
        return width * length * depth;
    }
    public double surface(){
        return (2 * width * length) + (2 * length * depth) + ( 2 * width * depth);
    }
    public String toString(){
        return "Box width : " + width + " length : " + length + " depth : " + depth;
    }


}
