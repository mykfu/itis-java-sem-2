public class Point {
    int x;
    int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x) {
        this(x, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Point3D extends Point {
    int x;
    int z;

    public Point3D() {
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class Test {
    public static void main(String[] args) {
        Point point = new Point(3, 2);
        Point3D point3D = new Point3D();
        System.out.println(point3D.x);
    }
}