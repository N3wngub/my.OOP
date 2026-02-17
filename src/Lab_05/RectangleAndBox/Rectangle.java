package RectangleAndBox;

    public class Rectangle {
    double length;
    double width;

    public Rectangle(){
        length = 0;
        width = 0;
    }

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public void setDimention(double length, double width){
        this.length = length;
        this.width = width;
    }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getArea() {
        return length * width;
        }

        public double surface() {
        return (length*2) + (2*width);
        }

        public String toString() {
        return "Ractangle : " + "width = " + width + ", length = " + length;
        }
    }

