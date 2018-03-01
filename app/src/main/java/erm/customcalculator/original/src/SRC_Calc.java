package erm.customcalculator.original.src;

/**
 * Created by Logan on 1/31/2016.
 */

import java.util.*;

public class SRC_Calc {

    SRC_Calc_Type functions = new SRC_Calc_Type();

        boolean running = true;

        Double PH, CV, N, x, y, factn, factr, c, answer, p, answer1, answer2, answer3, answer4;

        Double sine, cosine, tangent, asine, acosine, atangent, asine1, acosine1, atangent1, degree, radian;

        int M, A, Z, Std, mass1, mass2;



            Scanner input = new Scanner(System.in);

            String which = "A: Normal Math \n" +
                    "B: Probability \n" +
                    "C: Shapes \n" +
                    "D: Trig \n" +
                    "E: Newton Stuff \n" +
                    "F: Quadratic Formula \n";

//            System.out.println(which);
//            which = input.nextLine();
//
//            switch (which){
//
//////////CASE A////////////////////CASE A////////////////////CASE A////////////////////////CASE A/////////////CASE A
//                case "A"://CASE A MATH
//                    System.out.println("Enter a number: ");
//                    x = input.nextDouble();
//
//                    System.out.println("Enter an operation: ");
//                    String ops = "+ - * /";
//                    System.out.println(ops);
//                    ops = input.next();
//
//                    System.out.println("Enter second number:");
//                    y = input.nextDouble();
//
//                    switch (ops){
//                        case "+":
//                            System.out.println(x + y);
//                            break;
//                        case "-":
//                            System.out.println(x - y);
//                            break;
//                        case "*":
//                            System.out.println(x * y);
//                            break;
//                        case "/":
//                            System.out.println(x / y);
//                            break;
//
//                    }//End of switch ops
//
//                    break;
/////////CASE B////////////////////CASE B////////////////////CASE B////////////////////////CASE B/////////////CASE B
//                case "B": //CASE B PROBABILITY
//                    String op = "A: Combination \n" +
//                            "B: Permutation \n" +
//                            "C: Binomial Probability \n" +
//                            "D: Geometric Probability \n" +
//                            "E: Standard deviation of a Sampling Distro.\n" +
//                            "F: Z-Score \n" +
//                            "G: Confidence Interval";
//
//                    System.out.println(op);
//                    op = input.nextLine();
//
//                    switch (op){
//
//                        case "A":
//                            System.out.print("Enter n: ");
//                            Double n = input.nextDouble();
//
//                            System.out.print("Enter r: ");
//                            Double r = input.nextDouble();
//
//                            answer1 = SRC_Calc_Type.Combination(n, r);
//                            break;//End of case A
//
//                        case "B":
//                            System.out.print("Enter n: ");
//                            n = input.nextDouble();
//
//                            System.out.print("Enter r: ");
//                            r = input.nextDouble();
//
//                            factn = SRC_Calc_Type.factorial(n);
//                            factr = SRC_Calc_Type.factorial(r);
//
//                            if (n > r){
//                                c = SRC_Calc_Type.factorial(n - r);
//                                answer = factn / c;
//                                System.out.printf("(%s :P: %s) == %s \n", n, r,answer);
//                            }
//                            if (n < r){
//                                System.out.println("n must be larger than r \n");
//                            }
//                            break;//End of case B
//
//                        case "C":
//                            System.out.print("Enter n: ");
//                            factn = input.nextDouble();
//
//                            System.out.print("Enter r: ");
//                            factr = input.nextDouble();
//
//                            System.out.print("Enter The Probability of Success: ");
//                            p = input.nextDouble();
//
//                            if (factn > factr){
//                                c = SRC_Calc_Type.factorial(factn - factr);
//                                answer = factn / (factr * c);
//
//                            }
//                            if (factn < factr){
//                                System.out.println("n must be larger than r");
//                            }
//                            break; //End of case C
//
//
//                        case "D":
//                            System.out.print("Enter P: ");
//                            p = input.nextDouble();
//
//                            System.out.print("Enter X: ");
//                            x = input.nextDouble();
//
//                            answer = p * Math.pow((1 - p), (x - 1));
//                            System.out.printf("P(X == %s) Is %s\n", x, answer);
//                            break;
//                        //End of case D
//
//                        case "E":
//                            System.out.print("Enter n: ");
//                            n = input.nextDouble();
//
//                            System.out.print("Enter The Probability of Success: ");
//                            p = input.nextDouble();
//
//                            answer = Math.sqrt(p * (1 - p) / n);
//
//                            if (n * p >= 10 && answer >= 10){
//                                System.out.printf("This is a Normal Approximation, and answer == %s \n", answer);
//                            }
//                            if (n * p <= 10){
//                                System.out.println("This is not a Normal Approximation \n");
//                            }//End of case E
//
//                            if (answer < 10){
//                                System.out.println("This is not a Sampling distrobution \n");
//                            }
//                            break;
//
//                        case "F":
//                            System.out.print("Enter X: ");
//                            int X = input.nextInt();
//
//                            System.out.print("Enter the Mean: ");
//                            M = input.nextInt();
//
//                            System.out.print("Enter the Std Dev: ");
//                            Std = input.nextInt();
//
//                            //Double tableA1 = (1 / (Std * Math.sqrt(2 * Math.PI))) * Math.E;
//                            Z = (X - M) / Std;
//
//                            System.out.printf("Z-Score: %s \n", Z);
//                            break;
//
//                        case "G":
//                            System.out.print("Enter Sample Proportion: ");
//                            PH = input.nextDouble();
//
//                            System.out.print("Enter the Critical Value: ");
//                            CV = input.nextDouble();
//
//                            System.out.println("Enter the Sample Size: ");
//                            N = input.nextDouble();
//
//                            answer = functions.CI(PH, CV, N);
//                            answer1 = functions.CII(PH, CV, N);
//                    }//Switch through ALL CASE B:
//                    break;
//////////CASE C////////////////////CASE C////////////////////CASE C////////////////////////CASE C/////////////CASE C
//                case "C": //CASE C SHAPES
//                    op = "A: Cylinder SURFACE AREA \n" +
//                            "B: Cone SURFACE AREA \n" +
//                            "C: Cone VOLUME \n" +
//                            "D: Sphere SURFACE AREA \n" +
//                            "E: Sphere VOLUME \n" +
//                            "F: Prism VOLUME \n" +
//                            "G: Cylinder VOLUME \n" +
//                            "H: Pyramid VOLUME \n" +
//                            "I: Right Rectangular Pyramid SURFACE AREA \n";
//
//                    System.out.println(op);
//                    op = input.nextLine();
//
//
/////////CASE D////////////////////CASE D////////////////////CASE D////////////////////////CASE D/////////////CASE D
//                case "D": //CASE D TRIG
//
//                    op = "A: Sine: Opposite / Hypotenuse \n" +
//                            "B: Cosine: Adjacent / Hypotenuse \n" +
//                            "C: Tangent: Opposite / Adjacent \n" +
//                            "D: Arc Sine \n" +
//                            "E: Arc Cosine \n" +
//                            "F: Arc Tangent \n" +
//                            "G: Convert angle to radians \n" +
//                            "H: Convert angle to degrees \n";
//
//
//                    System.out.println(op);
//                    op = input.nextLine();
//
//                    switch (op){
//
//                        case "A":
//                            System.out.print("Enter the angle: ");
//                            sine = input.nextDouble();
//
//                            answer = Math.sin(sine);
//
//                            System.out.printf("Sine: %s \n", answer);
//                            break;
//
//                        case "B":
//                            System.out.print("Enter the angle: ");
//                            cosine = input.nextDouble();
//
//                            answer = Math.cos(cosine);
//
//                            System.out.printf("Cosine: %s \n", answer);
//
//                            break;
//
//                        case "C":
//                            System.out.print("Enter the angle: ");
//                            tangent = input.nextDouble();
//
//                            answer = Math.tan(tangent);
//
//                            System.out.printf("Tangent: %s \n", answer);
//
//                            break;
//
//                        case "D": //ARC
//                            System.out.print("Enter the first number: ");
//                            asine = input.nextDouble();
//
//                            System.out.print("Enter the second number: ");
//                            asine1 = input.nextDouble();
//
//                            answer = Math.asin(asine / asine1);
//                            System.out.printf("Arc sine: %s \n", answer);
//
//                            break;
//
//                        case "E"://ARC
//                            System.out.print("Enter the first number: ");
//                            acosine = input.nextDouble();
//
//                            System.out.print("Enter the second number: ");
//                            acosine1 = input.nextDouble();
//
//                            answer = Math.acos(acosine / acosine1);
//
//                            System.out.printf("Arc Cosine: %s \n", answer);
//                            break;
//
//                        case "F": //ARC
//                            System.out.print("Enter the first number: ");
//                            atangent = input.nextDouble();
//
//                            System.out.print("Enter the second number: ");
//                            atangent1 = input.nextDouble();
//
//                            answer = Math.atan(atangent / atangent1);
//
//                            System.out.printf("Arc Tangent: %s \n", answer);
//                            break;
//
//                        case "G":
//                            System.out.print("Enter the angle to be converted to radians: ");
//                            degree = input.nextDouble();
//                            answer = Math.toRadians(degree);
//
//                            System.out.printf("Your angle in Radians: %s \n", answer);
//
//                            break;
//
//                        case "H":
//                            System.out.print("Enter the angle to be converted to Degrees: ");
//                            radian = input.nextDouble();
//
//                            answer = Math.toDegrees(radian);
//                            System.out.printf("Your Angle in Degrees: %s \n", answer);
//
//                            break;
//                    }//End of switch op for TRIG
//                    break;
//
//
//////////CASE E////////////////////CASE E////////////////////CASE E////////////////////////CASE E/////////////CASE E
//                case "E": //CASE E NEWTONS
//                    String newt_op = "A: Net Force \n" +
//                            "B: Gravitational Force \n" +
//                            "C: Mass of Object \n" +
//                            "D: Distance between objects \n";
//
//                    System.out.print(newt_op);
//                    newt_op = input.nextLine();
//
//                    switch (newt_op){
//
//                        case "A":
//                            System.out.print("What is the Mass? ");
//                            M = input.nextInt();
//
//                            System.out.print("What is the Acceleration? ");
//                            A = input.nextInt();
//
//                            System.out.printf("Net Force: %d \n \n", A * M );
//                            input.nextLine();
//
//                            break;
//
//                        case "B":
//                            Double newt_grav_constant = 6.674 * (Math.pow(10, -11));
//                            System.out.print("What is mass1? ");
//                            mass1 = input.nextInt();
//
//                            System.out.print("What is mass2? ");
//                            mass2 = input.nextInt();
//
//                            System.out.print("What is the distance between the objects? ");
//                            int dist = input.nextInt();
//
//                            answer1 = (newt_grav_constant * mass1) * mass2;
//                            answer2 = answer1 / (Math.pow(dist, 2));
//                            System.out.printf("The GF == %s \n", answer2);
//                            break;
//
//                        case "C":
//                            newt_grav_constant = 6.674 * (Math.pow(10, -11));
//                            System.out.print("GF:  ");
//                            Double GF = input.nextDouble();
//
//                            System.out.print("What is mass2? ");
//                            mass2 = input.nextInt();
//
//                            System.out.print("What is the distance between the objects? ");
//                            dist = input.nextInt();
//
//                            answer1 = (newt_grav_constant * GF) * mass2;
//                            answer2 = answer1 / (Math.pow(dist, 2));
//                            answer3 = answer2 * Math.pow(dist, 2);
//                            answer4 = answer3 / (newt_grav_constant * mass2);
//
//                            System.out.printf("The Mass1 == %s \n", answer4);
//                            break;
//
//                        case "D":
//                            newt_grav_constant = 6.674 * (Math.pow(10, -11));
//                            System.out.print("Mass1:  ");
//                            Double Mass1 = input.nextDouble();
//
//                            System.out.print("What is Mass2? ");
//                            Double Mass2 = input.nextDouble();
//
//                            System.out.print("What is the distance between the objects? ");
//                            dist = input.nextInt();
//
//                            Double Answer1 = (newt_grav_constant * Mass1) * Mass2;
//                            answer2 = Answer1 / (Math.pow(dist, 2));
//                            Double Answer2 = Answer1 / answer2;
//                            Double Answer3 = Math.sqrt(Answer2);
//
//                            System.out.printf("The Distance == %s \n", Answer3);
//                            break;
//                    }//END OF NEWT_OP
//                    break;
//
//////////CASE F////////////////////CASE F////////////////////CASE F////////////////////////CASE F/////////////CASE F
//                case "F": //CASE F QUADRATIC
//
//            }//Switch through "WHICH"
}//Class
