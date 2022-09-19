import java.lang.reflect.Constructor;
import java.util.Scanner;

class Car
{
    int Sno;
    String model;
    String color;

    public Car(int Sno, String model , String color)
    {
        this.Sno = Sno;
        this.model = model;
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public String getModel() {
        return model;
    }
    public int getSno() {
        return Sno;
    }
    public void setter(int Sno, String model , String color)
    {
        this.Sno = Sno;
        this.model = model;
        this.color = color;
    }
}



interface parking 
{
     public void parkCar(Car car);
     public void findCar(int sNo);
     public Car unParkCar(int sNO);
}

class luckyOneParking implements parking
{
    int index = 0;
    int size;
    Car[] cars;
    public luckyOneParking(int size)
    {
        this.size = size;
        cars = new Car[size];
    }

    public void parkCar(Car car)
    {
        boolean carParked = false;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] == null)
            {
                carParked = true;
                cars[i] = car;
                break;
            }
        }
        if(!carParked)
        {
            System.out.println("Sorry, No slots left");
        }
    }
    public void findCar(int sNo)
    {
        boolean carFound = false;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].Sno == sNo)
            {
                carFound = true;
                System.out.println("Your car is in Block" + i);
                break;
            }
        }
        if(!carFound)
        {
            System.out.println("Sorry, Car not Found");

        }
    }
    public Car unParkCar(int sNo)
    {
        Car car = null;
        boolean carFound = false;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].Sno == sNo)
            {
                carFound = true;
                car = cars[i];
                cars[i] = null;
                break;
            }
        }
        if(!carFound)
        {
            System.out.println("Sorry, Car not Found ");

        }
        return car;

    }
}


class UbitParking implements parking
{
    int index = 0;
    int size;
    Car[] cars;
    public UbitParking(int size)
    {
        this.size = size;
        cars = new Car[size];
    }

    public void parkCar(Car car)
    {
        boolean carParked = false;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] == null)
            {
                carParked = true;
                cars[i] = car;
                break;
            }
        }
        if(!carParked)
        {
            System.out.println("Sorry, No slots left");
        }
    }
    public void findCar(int sNo)
    {
        boolean carFound = false;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].Sno == sNo)
            {
                carFound = true;
                System.out.println("Your car is in Block " + i);
                break;
            }
        }
        if(!carFound)
        {
            System.out.println("Sorry, Car not Found");

        }
    }
    public Car unParkCar(int sNo)
    {
        Car car = null;
        boolean carFound = false;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i].Sno == sNo)
            {
                carFound = true;
                car = cars[i];
                cars[i] = null;
                break;
            }
        }
        if(!carFound)
        {
            System.out.println("Sorry, Car not Found");

        }
        return car;

    }
}

public class ParkingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner newscan = new Scanner(System.in);
        System.out.println("Enter \n1.Lucky One Mall Parking \t 2.UBIT Marking");
        int ans = scanner.nextInt();
        if(ans == 1)
        {
            System.out.println("Enter the size of the parking area");
            int size = scanner.nextInt();
            luckyOneParking newParking = new luckyOneParking(size);

            int ans2 = -1;
            while(ans2 != 0)
            {
                System.out.println("Enter \n1.Park your Car \n2.Find Your Car \n3.To Unpark the Car \n0.To exit");
                ans2 = scanner.nextInt();
                if(ans2 ==1)
                {
                    System.out.println("Enter the serial number of your car");
                    int Sno = scanner.nextInt();

                    System.out.println("Enter the model of your car");
                    String model = newscan.nextLine();
                    System.out.println("Enter the color of your car");
                    String color = newscan.nextLine();

                    Car car = new Car(Sno , model , color);
                    newParking.parkCar(car);
                   
                }
                if(ans2 == 2)
                {
                    System.out.println("Enter the serial number of your car");
                    int Sno = scanner.nextInt();
                    newParking.findCar(Sno);
                }
                if(ans2 == 3)
                {
                    System.out.println("Enter the serial number of your car");
                    int Sno = scanner.nextInt();
                    Car unParkedCar = newParking.unParkCar(Sno);
                    if(unParkedCar!=null)
                    {
                        System.out.println("Your car with serial number "  + unParkedCar.Sno + " has been removed"); 
                    }
                }
            }
        }
        if(ans == 2)
        {
            System.out.println("Enter the size of the parking area");
            int size = scanner.nextInt();
            UbitParking newParking = new UbitParking(size);

            int ans2 = -1;
            while(ans2 != 0)
            {
                System.out.println("Enter \n1.Park your Car \n2.Find Your Car \n3.To Unpark the Car \n0.To exit");
                ans2 = scanner.nextInt();
                if(ans2 ==1)
                {
                    System.out.println("Enter the serial number of your car");
                    int Sno = scanner.nextInt();

                    System.out.println("Enter the model of your car");
                    String model = newscan.nextLine();
                    System.out.println("Enter the color of your car");
                    String color = newscan.nextLine();

                    Car car = new Car(Sno , model , color);
                    newParking.parkCar(car);
                   
                }
                if(ans2 == 2)
                {
                    System.out.println("Enter the serial number of your car");
                    int Sno = scanner.nextInt();
                    newParking.findCar(Sno);
                }
                if(ans2 == 3)
                {
                    System.out.println("Enter the serial number of your car");
                    int Sno = scanner.nextInt();
                    Car unParkedCar = newParking.unParkCar(Sno);
                    if(unParkedCar!=null)
                    {
                        System.out.println("Your car with serial number "  + unParkedCar.Sno + " has been removed"); 
                    }
                }
            }
        }
    }
}
