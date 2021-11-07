//create a Object
// public class Main {
//     int x = 5;

//     public static void main(String[] args) {
//         Main myObj = new Main();
//         System.out.println(myObj.x);
//     }
// }

// Multiple Object
// public class Main {
//     int x = 2;

//     public static void main(String[] args) {
//         Main myObj1 = new Main();
//         Main myObj2 = new Main();
//         System.out.println(myObj1.x);
//         System.out.println(myObj2.x);
//     }
// }

// Modify Attributes
// public class Main {
//     int x;

//     public static void main(String[] args) {
//         Main myObj = new Main();
//         myObj.x = 40;
//         System.out.println(myObj.x);
//     }
// }

//Change value
// public class Main {
//     int x = 1;

//     public static void main(String[] args) {
//         Main myObj = new Main();
//         myObj.x = 23;
//         System.out.println(myObj.x);
//     }
// }

//Final
// public class Main {
//     final int x = 1;

//     public static void main(String[] args) {
//         Main myObj = new Main();
//         myObj.x = 23;
//         System.out.println(myObj.x);  //output: x = 1
//     }
// }

//Multi Object
// public class Main {
//     int x = 5;

//     public static void main(String[] args) {
//         Main myObj1 = new Main();
//         Main myObje2 = new Main();
//         myObje2.x = 22;
//         System.out.println(myObj1.x);
//         System.out.println(myObje2.x);
//     }
// }

//Multiple Attribute
// public class Main {
//     String fname = "Thu";
//     String lname = "trung";
//     int age = 12;

//     public static void main(String[] args) {
//         Main myObj = new Main();
//         System.out.println("Name: " + myObj.fname + " " + myObj.lname);
//         System.out.println(myObj.age);
//     }
// }


// Static vs Public
// public class Main {
//     //Static method
//     static void myStaticMetod() {
//         System.out.println("Static method can be called without creating objects");
//     }

//     //Public method
//     public void myPublicMethod() {
//         System.out.println("Public method must be called by creating objec");
//     }

//     public static void main(String[] args) {
//         myStaticMetod(); //call the static method

//         Main myObj = new Main(); //create an object of Main
//         myObj.myPublicMethod(); //call the public method on the object

//     }
// }


//Access method with an Object
//Create a Main class
// public class Main {

//     //Create a fullThrottle() method
//     public void fullThrottle() {
//         System.out.println("the car is going as fast as it can!");
//     }

//     //Create a speed() method and add a parameter
//     public void speed(int maxSpeed) {
//         System.out.println("Max speed is " + maxSpeed);
//     }

//     //Inside main, call the method on the myCar object
//     public static void main(String[] args) {
//         Main myCar = new Main();  //Create a myCar object
//         myCar.fullThrottle();    //call the fullThrotte() method
//         myCar.speed(23);        //call the speed() method

//     }
// }


// Contructor
//Create a Main class
// public class Main {
//     int x;

//     //Create a class contructor for the Main class
//     public Main() {
//         x = 5; //Set the initial value for the class attribute x
//     }

//     public static void main(String[] args) {
//         Main myObj = new Main();
//         System.out.println(myObj.x);
//     }
// }

//Contructor Parameters
// public class Main {
//     int x;

//     public Main(int y) {
//         x = y;
//     }

//     public static void main(String[] args) {
//         Main myObj = new Main(5);
//         System.out.println(myObj.x);
//     }
// }

//Many parameters
// public class Main {
//     int modelYear;
//     String modelName;

//     public Main(int year, String name) {
//         modelYear = year;
//         modelName = name;
//     }

//     public static void main(String[] args) {
//         Main myCar = new Main(1969, "Mustang");
//         System.out.println(myCar.modelYear + " " + myCar.modelName);
//     }
// }

//Exam
class Vehicle {
    protected String brand = "Ford"; //Vehicle attribute
    public void honk() {
        System.out.println("tuut, tuut!");
    }

}
class car extends Vehicle {
    private String modelName = "Mustang";
    public static void main(String[] args) {
        car myCar = new car();

        myCar.honk();

        System.out.println(myCar.brand + myCar.modelName);
    }
}
