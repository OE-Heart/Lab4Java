# Lab2

## 1 租车服务

某租车公司提供租车服务，针对不同的车辆类型，日租金的计算方式不同，具体地，对于货车而言，根据载重量load（单位是吨）计算，公式为loadx  1000；对于大型客车而言，根据车内座位数seats计算，公式为seatsx50；对于小型汽车而言，根据车辆等级和折旧年数计算，公式为200*level/sqrt(year)，其中sqrt表示平方根。设计合适的类继承结构实现上述功能，构造租车公司类CarRentCompany，提供静态函数rentVehicles，能够给定一组待租车辆，计算日租金总额。 在main函数中，读入多个车辆数据，并计算总的日租金。

### 输入描述：

汽车数量 汽车种类 该类汽车相关属性 其中1表示货车，2表示大型客车，3表示小型汽车

### 输出描述：

总的日租金，保留两位小数

### 裁判测试程序样例：

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        Vehicle[] vs = new Vehicle[c];
        for (int i=0;i<c;i++) {
            int type = sc.nextInt();
            Vehicle v = null;
            if (type == 1) {//货车
                vs[i] = new Truck (sc.nextDouble());
            } else if (type == 2) {
                vs[i] = new Keche(sc.nextInt());
            } else if (type == 3) {
                vs[i] = new Car(sc.nextInt(), sc.nextInt());
            }
        }

        System.out.printf("%.2f",CarRentCompany.rentVehicles(vs));

    }
}

/* 你的代码被嵌在这里 */
```

### 输入样例：

在这里给出一组输入。例如：

```in
3
1 3
2 50
3 5 5
```

### 输出样例：

在这里给出相应的输出。例如：

```out
5947.21
```

---

## 2 形状继承

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

---

## 3 设计Worker类及其子类

设计一个Worker类，有以下方法：
（1）构造方法：带两个输入参数：工人的姓名和小时工资。
（2）小时工资的get/set方法
（3）pay()方法：带一个工作时长输入参数，输出："Not Implemented"。
接下来设计Worker的子类：HourlyWorker和SalariedWorker。两个子类都重写继承的方法pay()来计算工人的周薪。计时工按实际工时支付每小时工资，超过40小时的超出部分为双倍工资。计薪工人的工资是40小时的工资，不管工作时间是多少。因为与工作时长无关，故SalariedWorker的方法pay()可以不带参数调用。

### 类框架定义：

```
设计的类如下框架所示，完成后将该三类提交。
class Worker {
    ……
}

class HourlyWorker extends Worker {
        ……
}
class SalariedWorker extends Worker {
        ……
}
```

### 裁判测试程序样例：

```java
import  java.util.Scanner;

//Main测试类
public class Main{
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
       Worker w1 = new Worker("Joe",15);
      w1.pay(35);
      SalariedWorker w2 = new SalariedWorker("Sue",14.5);
      w2.pay();
      w2.pay(60);
      HourlyWorker w3 = new HourlyWorker("Dana", 20);
      w3.pay(25);
      w3.setRate(35);   
            int h = input.nextInt();     # 输入小时工的工作时长
      w3.pay(h);      
  }
}

/* 请在这里填写答案 */
```

### 输入样例：

在这里给出一组输入。例如：

```in
 25
```

### 输出样例：

在这里给出相应的输出。例如：

```out
Not Implemented
580.0
580.0
500.0
875.0
```