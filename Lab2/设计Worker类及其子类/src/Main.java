import  java.util.Scanner;

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
      int h = input.nextInt();     
      w3.pay(h);      
  }
}

class Worker {
    static String name;
    static double rate;
    public Worker(String n, double r) {
        name = n;
        rate = r;
    } 
    public static double getRate() {
      return rate;
    }
    public static void setRate(double r) {
      rate = r;
    }
    public void pay() {
      System.out.println("Not Implemented");
    }
    public void pay(int hour) {
      System.out.println("Not Implemented");
    }
}

class HourlyWorker extends Worker {
    public HourlyWorker(String name, double rate) {
      super(name, rate);
    }

    public void pay(int hour) {
      double all = 0;
      if (hour <= 40) {
        all = hour*super.getRate();
      }
      else {
        all = (40+(hour-40)*2)*super.getRate();
      }
      System.out.println(all);
    }
}
class SalariedWorker extends Worker {
  public SalariedWorker(String name, double rate) {
    super(name, rate);
  }

  @Override
    public void pay() {
      System.out.println(40*super.getRate());
    }

    @Override
    public void pay(int hour) {
      System.out.println(40*super.getRate());
    }
}