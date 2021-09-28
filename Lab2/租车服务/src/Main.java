import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        Vehicle[] vs = new Vehicle[c];
        for (int i=0;i<c;i++) {
            int type = sc.nextInt();
            Vehicle v = null;
            if (type == 1) {
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

abstract class Vehicle {
	abstract double getRent();
}

class Truck extends Vehicle {
	double load;
	public Truck(double load) {
		this.load=load;
	}
	
	public double getRent() {
		return 1000*this.load;
	}
	
}

class Keche extends Vehicle {
	int seat;
	public Keche(int seat) {
		this.seat=seat;
	}
	
	public double getRent() {
		return 50*this.seat;
	}
}

class Car extends Vehicle {
	int level;
	int year;
	
	public Car(int level,int year) {
		this.level=level;
		this.year=year;
	}
	
	public double getRent() {
		return 200*this.level/(Math.sqrt(this.year));
	}
}

class CarRentCompany {
	public static double rentVehicles(Vehicle[] vs) {
		double result = 0;
		for(int i = 0; i < vs.length; i++) {
			result += vs[i].getRent();
		}
		return result;
	}
}