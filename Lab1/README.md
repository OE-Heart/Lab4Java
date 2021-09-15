# Lab1

## 1 分数

设计一个表示分数的类Fraction。这个类用两个int类型的变量分别表示分子和分母。注意，在创建和做完运算后应该化简分数为最简形式。如2/4应该被化简为1/2。

### 函数接口定义：

这个类的构造函数是：

```
Fraction(int a, int b)
```

构造一个a/b的分数。

这个类要提供以下的功能：

```
double toDouble();
```

将分数转换为double

```
Fraction plus(Fraction r);
```

将自己的分数和r的分数相加，产生一个新的Fraction的对象。

```
Fraction multiply(Fraction r);
```

将自己的分数和r的分数相乘，产生一个新的Fraction的对象。

```
String toString();
```

将自己以“分子/分母”的形式产生一个字符串。如果分数是1/1，应该输出`"1"`。当分子大于分母时，不需要提出整数部分，即`"31/30"`是一个正确的输出。

### 裁判测试程序样例：

```Java
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.plus(b));
        System.out.println(a.multiply(b).plus(new Fraction(5,6)));
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.toDouble());
        in.close();
    }
}

/* 请在这里填写答案 */
```

注意，你的类的定义应该这样开始：

```
class Fraction {
```

也就是说，在你的类的class前面不要有public。

### 输入样例：

```in
2 4 1 3
```

### 输出样例：

```out
1/2
1/3
5/6
1
1/2
1/3
0.5
```

---



## 2 矩形

设计一个表示矩形的类Rectangle，这个类用一个表示坐标点的类Point的对象来表达它的左上角坐标，用一个表示尺寸的类Dimension的对象来表示它的大小。 你的程序要严格按照所给的类和函数的声明来实现。

### 函数接口定义：

```Java
/**
 * Represents a point in 2D, with x and y, like (x,y).
 */
class Point {
    private int x;
    private int y;

    /**
     * Creates a point with coordinate at (x,y)
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(int x, int y) {

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * The generated string as: "(x,y)
     */
    @Override
    public String toString() {

    }

    /**
     * Moves the point with dx and dy.
     * @param dx the distance to be moved at x-axis
     * @param dy the distance to be moved at y-axis
     */
    public void move(int dx, int dy) {

    }

    /**
     * Calculate the distance between this and p.
     * @param p the other point.
     * @return the distance between this and p.
     */
    public double distance(Point p) {

    }
}

/**
 * A dimension in 2D, with width and height.
 */
class Dimension {
    private int width;
    private int height;

    /**
     * Creates a dimension with specified width and height.
     * @param width the width of the dimension
     * @param height the height of the dimension
     */
    public Dimension(int width, int height) {

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * The generated string as: "width by height"
     */
    @Override
    public String toString() {

    }

    /**
     * Resizes the dimension with scales at width and height.
     * Although the scales are in double, the result should be integers as well.
     * @param widthScale the scale at width
     * @param heightScale the scale at height
     */
    public void resize(double widthScale, double heightScale) {

    }

    /**
     * Calculate the area of this dimension.
     * @return the area of this dimension.
     */
    public int area() {

    }
}

/**
 * Represents a rectangle, with a point at its top-left and a dimension.
 *
 */
class Rectangle {
    private Point topleft;
    private Dimension size;

    /**
     * Creates a rectangle.
     * @param topleft the coordinate of its top-left 
     * @param size the dimension of its size
     */
    public Rectangle(Point topleft, Dimension size) {

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * The generated string as: "Rectangle at (x,y):width by height"
     */
    public String toString() {

    }

    /**
     * Moves the rectangle some distance.
     * @param dx the distance to be moved at x-axis
     * @param dy the distance to be moved at y-axis
     */
    public void move(int dx, int dy) {

    }

    /**
     * Resizes the rectangle at both width and height
     * @param widthScale the scale at width
     * @param heightScale the scale at height
     */
    public void resize(double widthScale, double heightScale) {

    }

    /**
     * Calculates the area of this rectangle.
     * @return the area of this rectangle.
     */
    public double area() {

    }

    /**
     * Calculates the distance between this rectangle and r.
     * @param r the other rectangle
     * @return the distance between this rectangle and r.
     */
    public double distance(Rectangle r) {

    }
}
```

### 裁判测试程序样例：

```Java
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int width = in.nextInt();
        int height = in.nextInt();
        Rectangle r = new Rectangle(
            new Point(x,y), new Dimension(width, height));
        Rectangle r2 = new Rectangle(
            new Point(x,y), new Dimension(width, height));
        int dx = in.nextInt();
        int dy = in.nextInt();
        r.move(dx, dy);
        double widthScale = in.nextDouble();
        double heightScale = in.nextDouble();
        r.resize(widthScale, heightScale);
        System.out.println(r);
        System.out.printf("%.2f\n", r.area());
        System.out.printf("%.2f\n", r.distance(r2));
        in.close();
    }
}

/* 请在这里填写答案 */
```

### 输入样例：

```in
0 0 100 100 20 20 2 2
```

### 输出样例：

```out
Rectangle at (20,20):200 by 200
40000.00
28.28
```

---



## 3 形状继承

设计一个表示形状的类Shape，以及从Shape继承的表示矩形的类Rectangle和表示椭圆的类Ellipse。Shape类用一个表示坐标点的类Point的对象来表达它的左上角坐标，用一个表示尺寸的类Dimension的对象来表示它的大小。 你的程序要严格按照所给的类和函数的声明来实现。

### 函数接口定义：

```Java
/**
 * Represents a point in 2D, with x and y, like (x,y).
 */
class Point {
    private int x;
    private int y;

    /**
     * Creates a point with coordinate at (x,y)
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(int x, int y) {

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * The generated string as: "(x,y)
     */
    @Override
    public String toString() {

    }

    /**
     * Moves the point with dx and dy.
     * @param dx the distance to be moved at x-axis
     * @param dy the distance to be moved at y-axis
     */
    public void move(int dx, int dy) {

    }

    /**
     * Calculate the distance between this and p.
     * @param p the other point.
     * @return the distance between this and p.
     */
    public double distance(Point p) {

    }
}

/**
 * A dimension in 2D, with width and height.
 */
class Dimension {
    private int width;
    private int height;

    /**
     * Creates a dimension with specified width and height.
     * @param width the width of the dimension
     * @param height the height of the dimension
     */
    public Dimension(int width, int height) {

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * The generated string as: "width by height"
     */
    @Override
    public String toString() {

    }

    /**
     * Resizes the dimension with scales at width and height.
     * Although the scales are in double, the result should be integers as well.
     * @param widthScale the scale at width
     * @param heightScale the scale at height
     */
    public void resize(double widthScale, double heightScale) {

    }

    /**
     * Calculate the area of this dimension.
     * @return the area of this dimension.
     */
    public int area() {

    }
}

class Shape {
    private Point center;
    private Dimension size;

    /**
     * Creates a shape.
     * @param topleft the coordinate of its center 
     * @param size the dimension of its size
     */
    public Shape(Point center, Dimension size) {
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return String.format("at %s:%s", center, size);
    }

    /**
     * Moves the shape some distance.
     * @param dx the distance to be moved at x-axis
     * @param dy the distance to be moved at y-axis
     */
    public void move(int dx, int dy) {
    }

    /**
     * Resizes the shape at both width and height
     * @param widthScale the scale at width
     * @param heightScale the scale at height
     */
    public void resize(double widthScale, double heightScale) {
    }

    /**
     * Calculates the distance between this shape and r.
     * @param r the other shape
     * @return the distance between this shape and r.
     */
    public double distance(Shape r) {
    }

    /**
     * Calculates the area of this shape.
     * @return the area of this shape.
     */
    public double area() {
    }
}

/**
 * Represents a rectangle, with a point at its top-left and a dimension.
 *
 */
class Rectangle extends Shape {
    /**
     * Creates a rectangle.
     * @param topleft the coordinate of its center 
     * @param size the dimension of its size
     */
    public Rectangle(Point center, Dimension size) {
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Rectangle " + super.toString();
    }
}

class Ellipse extends Shape {
    /**
     * Creates a ellipse.
     * @param topleft the coordinate of its center 
     * @param size the dimension of its size
     */
    public Ellipse(Point center, Dimension size) {
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Ellipse " + super.toString();
    }

    /**
     * Calculates the area of this ellipse.
     * @return the area of this ellipse.
     */
    @Override
    public double area() {
    }
}
```

### 裁判测试程序样例：

```Java
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int width = in.nextInt();
        int height = in.nextInt();
        Rectangle r = new Rectangle(
            new Point(x,y), new Dimension(width, height));
        Ellipse e = new Ellipse(
            new Point(x,y), new Dimension(width, height));
        int dx = in.nextInt();
        int dy = in.nextInt();
        r.move(dx, dy);
        double widthScale = in.nextDouble();
        double heightScale = in.nextDouble();
        r.resize(widthScale, heightScale);
        System.out.println(r);
        System.out.printf("%.2f\n", r.area());
        System.out.printf("%.2f\n", r.distance(e));
        in.close();
    }
}

/* 请在这里填写答案 */
```

### 输入样例：

```in
0 0 100 100 20 20 2 2
```

### 输出样例：

```out
Rectangle at (20,20):200 by 200
40000.00
28.28
```