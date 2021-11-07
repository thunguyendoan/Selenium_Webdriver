import javax.print.DocFlavor.STRING;

// bai 1: get start
// a class name which must match the filename, 
// and that every program must contain the main() method.

public class Main{
    public static void main(String[] args) {    //the main menthod
        System.out.println("trung thu nguyen");   // execute here
    }
}

// Bai 2: Java Variable

// Systax:  type variable = value;
int myNum3 = 3;                 // integer (whole number)
byte muNum4 = 100;        // byte instead of int to save memory -128 to 127
short myNum5 = 5000;    //short can store whole number from -32768 to 32767
float myFloatNum = 4.7f;         // Float (end the value with an "f")
char myLetter = "d";            // character
boolean myBool = true;          // Boolean
String myText = "Hello";        // String
double myNum6 = 12.2d;   // double (for float point numbers), and "d"



//String
String name = "Thu";
System.out.println(name);


//integer
int myNum = 15;
System.out.println(myNum);

int myNum1;
myMum1 = 1;
System.out.println(myMum1);

//Boolean
boolean isTrue = true;
boolean isFalse = false;
System.out.println(isTrue);
System.out.println(isFalse);


//Char
char myGrade = "B";
System.out.println(myGrade);



//Change value
int myNum2 = 15;
myNum2 = 20;
System.out.println(myNum2);

/* + characters */

//String
String name1 = "Thu";
System.out.println("hello" + name1);

String firstName = "nguyen";
String lastName = "Thu";
String fullName = firstName + lastName;
System.out.println(fullName);

//number
int x = 5;
int y = 5;
System.out.println(x + y);



//Bai 3: 

public class Main{
    public static void main(String[] args) {
        int myInt = 2;
        double myDouble = myInt; //Auto casting: int to double

        System.out.println(myInt);     //Output  9
        System.out.println(myDouble);  //Output 9.0
    }
}


public class Main{
    public static void main(String[] args) {
        double myDouble1 = 2.3d;
        int myInt1 = (int) myDouble1; //Manual casting: double to int

        System.out.println(myDouble);  //Output 2.3
        System.out.println(myInt);     //Output 9
    }
}


//Bai 4: Operator
int x1 = 2;
x1 += 2;  // x = x + 2


//Bai 5: String

String name3 = "trung thu";

//length
String carName = "ABCD";
System.out.println(carName.length());


String txt = "Hello World";
System.out.println(txt.toUpperCase()); //Output: "HELLO WORLD"
System.out.println(txt.toLowerCase()); //Outputs "hello world"


// Finding a characters in a String
String txt1 = "Please locate where";
System.out.println(txt1.indexOf("locate"));  //Output  7



//Special characters
String txt2 = "We are the so-called \'abc from the north";
// \' : single quote  '
// \" : double quote   "
// \\ : Backclash      \



//Bai 6: Math

// find highest value
Math.max(5,10);

// find lowest value
Math.min(5,10);

// square root
Math.sqrt(64);

// return positive value
Math.abs(-4.2);   //Output 4.2

//ramdom
Math.ramdom();

// ramdom from 0 to 100
int ramdomNum = (int)(Math.random() * 100);  // 0 to 100

//Boolean
int x = 1;
int y = 2;
System.out.println(x > y);  // return False, bz x is lower y

//
int z = 10;
System.out.println(z == 10); // return true, bs z = 10



// Bai 7: If...Else
int time = 12;
if (time < 10) {
    System.out.println("good morning");
} else if (time < 20) {
    System.out.println("good day");
} else {
    System.out.println("goo evening");
}

// Short hand If...Else
int time = 12;
if (time < 10) {
    System.out.println("good night");
} else {
    System.out.println(("good afternoon"));
}
// Simple write
int time = 12;
String result = (time < 18) ? "good day" : "good evening";
System.out.println(result);



// Bai 8: Switch
//break
int day = 4; 
switch (day) {
    case 1:
        System.out.println("monday");
        break;
    case 4:
        System.out.println("tuesday");
        break;
}

//default
int day1 = 3;
switch (day1) {
    case 1:
        System.out.println("monday");
        break;

    default:
        System.out.println("looking forward to the weekend");

}


// Bai 9: Loop
int i = 0;
while (i < 5) {    //true
    System.out.println(i);
    i++;
}

int ii = 0;
do {
    System.out.println(ii);
    ii++;
}
while (ii < 5);


for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

String[] cars = {"Volvo", "BMW", "Ford", "Mazada"};
for (String i : cars) {
    System.out.println(i);
}


// Bai 10: Break and Continue
// Break
for (int i = 0; i < 10; i++) {
    if (i == 4) {
        break;
    }
    System.out.println(i);  //output: 0 1 2 3
}

// Countinue
for (int i = 0; i < 10; i++) {
    if (i == 4) {
        continue;
    }
    System.out.println(i); //output: 0 1 2 3 5 6 7 8 9
}

// break and continue in While Loop
//break
int i = 0;
while (i < 10) {
    System.out.println(i);  //output: 0 1 2 3 
    i++;
    if (i == 4) {
        break;
    }
}

//continue
int i = 0;
while (i < 10) {
    if (i == 4) {
        i++;
        continue;
    }
    System.out.println(i);
    i++;
}

// Bai 9: Array
String[] car;
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
String[] myNum = {1, 2, 3, 4};

//access the element of an Array
String[] cars = {"Volvo", "BMW", "Ford"};
System.out.println(cars[0]);  //Output: Volvo

//change an array element
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
cars[0] = "thu";
System.out.println(cars[0]); //Output: thu

//array length
String[] cars = {"Volvo", "BMW", "Ford"};
System.out.println(cars.length()); //output: 3

//Loop through an Array
String[] cars = {"Volvo", "BMW", "Ford"};
for (int i = 0; i < cars.length; i++) {
    System.out.println(cars[i]);
}

//Multi Array
int[][] myNumber = {{1, 2, 3, 4}, {5, 6, 7}};
int x = myNumber[1][2];
System.out.println(x); //output: 7

//for loop
int[][] myNumber = { {1, 2, 3, 4}, {5, 6, 7} };
for (int i = 0; i < myNumber.lenght; i++) {
    for(int j = 0; j < j.lenght; j++) {
        System.out.println([i][j]);
    }
}

