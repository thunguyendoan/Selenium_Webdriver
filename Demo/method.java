
// public class Main {
//     static void myMethod() {
//         System.out.println("trung thu nguyen");
//     }

//     public static void main(String[] args) {
//         myMethod();
//         myMethod();
//         myMethod();
//     }
// }

// parameter and Argument
// public class Main {
//     static void myMethod(String fname) {
//         System.out.println(fname + " " + "dep");
//     }

//     public static void main(String[] args) {
//         myMethod("thu");
//         myMethod("trung");
//         myMethod("nguyen");
//     }
// }


// Multi parameter
// public class Main {
//     static void myMethod(String fname, int age) {
//         System.out.println(fname + " is " + age);
//     }

//     public static void main(String[] args) {
//         myMethod("thu", 1);
//         myMethod("trung", 2);
//         myMethod("nguyen", 3);
//     }
// }


//Return value
// public class Main {
//     static int myMethod(int x) {
//         return 5 + x;
//     }

//     static int myMethod1(int x, int y) {
//         return x + y;
//     }

//     public static void main(String[] args) {
//         int z = myMethod(3);
//         int v = myMethod1(1, 2);
//         System.out.println(z);
//         System.out.println(v);
//     }
// }


// If..else
// public class Main {
//     static void checkAge(int age) {
//         if (age < 18) {
//             System.out.println("Access denied - you're not enought!");
//         } else {
//             System.out.println("Access granted - you're old enough!");
//         }
//     }

//     public static void main(String[] args) {
//         checkAge(33);
//     }
// }


// Method Overloading: muiti method have same name with different parameters
// public class Main {
//     static int plusMethod(int x, int y) {
//         return x + y;
//     }

//     static double plusMetod(double x, double y) {
//         return x + y;
//     }

//     public static void main(String[] args) {
//         int myNum1 = plusMethod(1, 2);
//         double myNum2 = plusMetod(1.1, 2.2);
//         System.out.println(myNum1);
//         System.out.println(myNum2);
//     }
// }


//Recursion
// public class Main {
//     public static void main(String[] args) {
//         int result = sum(10);
//         System.out.println(result);
//     }

//     static int sum(int k) {
//         if (k > 0) {
//             return k + sum(k - 1);
//         } else {
//             return 0;
//         }
//     }
// }