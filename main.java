//import all nessesacry modules
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.time.*;
import java.awt.*;
/**
 * MyHealth
 * This program is a 3 in 1 health app that teaches users about their heart, tracks and logs heart informaation, calculates BMI, monitors your screentime, and also serves as a posture checker.
 * It serves a s a convenient and ellegant way to keep all your logs of your heart rate, blood pressure, weight and height stats and also act as a tool to help with your digittal literacy. 
 * @author Luthira Abeykonn
 * @version 1.0
 * @since 2023-11-04
 * 
 */



 /**
 * The class Main
 */ 
public class main {
    public static final String ANSI_BLUE = "\u001B[34m";


/** 
 *
 * It is a constructor. 
 *
 * @param args[]  the args []. 
 */
    public static void main(String args[]) { 

        final int timer = 10; //constant for timer
        //initialize and get current date stor in current date variable
        LocalDate currentDate = LocalDate.now();
        //convert date to a string
        String dateString = currentDate.toString();
        // Welcome text to describe application/purpose of program
        String text = "Health Data Logger program is an innovative tool designed to help individuals keep track of their health information and monitor their progress towards achieving their wellness goals.\nWith the increasing prevalence of chronic diseases and the need for preventative care, it has become essential for people to take an active role in managing their health.\nThe Health Data Logger program is a user-friendly application that allows users to record and analyze data related to their health, such as their weight, blood pressure, and physical activity, among others.\nThe program's features enable users to gain insights into their health status, identify potential health risks, and make informed decisions to improve their overall well-being.\nThis program is an excellent resource for individuals who are seeking to take control of their health and make positive lifestyle changes.";
        //initilzie counter
        int i;
        //for loop used to print each characater after a 0.005 second delay.
        for (i = 0; i < text.length(); i++) {
            //prints a formatted string
            System.out.printf("%c", text.charAt(i));
            // Try and catch function used to catch exceptions that might occur
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        // initilize scanner object
        Scanner scan = new Scanner(System.in);
        // set option  equal to 0, which will be used to get the choice that the user picks to naviaget menu
        int option = 0;
        // do while loop to repeat the menu 
        do {
            clearScreen();
            //main menu string
            String mainMenu = "*************************************************\n" +
                              "*                    Main Menu                  *\n" +
                              "*                                               *\n" +
                              "*  1) My Health Metrics                         *\n" +
                              "*  2) My Screen Time                            *\n" +
                              "*  3) My Posture                                *\n" +
                              "*  4) Exit                                      *\n"+
                              "*                                               *\n" +
                              "*  Enter choice:                                *\n" +
                              "*                                               *\n" +
                              "*************************************************";
            //for loop used to print each characater after a 0.005 second delay.
            for (i = 0; i < mainMenu.length(); i++) {
                System.out.print(mainMenu.charAt(i));
                try {
                    Thread.sleep(1); // Adjust the speed of typing here
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // get user input
            System.out.println("");
            option = scan.nextInt();
            //switch case for all cases of menu that user might input
            switch (option) {
                //case 1
                case 1: 
                do {
                    //print 2nd menu
                    System.out.println("");
                    clearScreen();
                    String myHealthMenu = "*************************************************\n" +
                                          "*                 Heart Health                  *\n" +
                                          "*                                               *\n" +
                                          "*  1) My Heart Health                           *\n" +
                                          "*  2) Blood Pressure                            *\n" +
                                          "*  3) Calculate BMI                             *\n" +
                                          "*  4) Back To Main Menu                         *\n"+
                                          "*                                               *\n" +
                                          "*  Enter choice:                                *\n" +
                                          "*                                               *\n" +
                                          "*************************************************";
                    //for loop used to print each characater after a 0.005 second delay.
                    for (i = 0; i < myHealthMenu.length(); i++) {
                        System.out.print(myHealthMenu.charAt(i));
                        try {
                            Thread.sleep(1); // Adjust the speed of typing here
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //get user input
                    option = scan.nextInt();
                    switch (option){
                        case 1:
                        heartHealth(scan, dateString);
                        break;
                        case 2:
                        bloodPressureFunction(scan, dateString);
                        break;        
                        case 3:
                        //call bmi function for case 3
                        BMI();
                        //sleep for 2 seconds
                        sleep(2000);
                        //wait for user input to clear screen and display menu again
                        System.out.println("Press Enter To Continue...");
                        scan.nextLine();
                        scan.nextLine();

                        break;       
                    }

                }while(option!=4);
                case 2:
                    ScreenTime(dateString); // call screentime function
                    System.out.println("Press enter to continue: ");
                    scan.nextLine();
                    scan.nextLine();
                    System.out.println("Would you like to see your screen time for a specific date? Enter y or n: ");
                    String yOrN = scan.nextLine(); // yorN 
                    if (yOrN.equals("y"))  // check if the user entered y for yes and n for no, if they enter y it execute the code in the if statement
                        binarySearch();
                        sleep(1000);
                        System.out.println("Press enter to continue: ");
                        scan.nextLine();
                        scan.nextLine();
                    break;        
                case 3:
                MyPosture(scan, dateString);                          
                }
        }while (option!=4);}
    }

    // open source clear screen code from
    // https://stackoverflow.com/questions/2979383/how-to-clear-the-console

/** 
 *
 * Clear screen
 *
 */
    public static void clearScreen() { 

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


/** 
 *
 * Sleep
 *
 * @param interval  the interval. 
 */
    public static void sleep(int interval) { 

        try {
            Thread.sleep(interval);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

/** 
 *
 * Sleep
 *
 * @param interval  the interval. 
 */
    public static void sleep(long interval) { 

        try {
            Thread.sleep(interval);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    //recursive method for countdown timer

/** 
 *
 * Count down
 *
 * @param num  the time. 
 */
    public static void countDown(int num) { 

        System.out.println(num);
        if (num > 0) {
            sleep(1000);
            clearScreen();
            countDown(num - 1);
        }
        
    }

/** 
 *
 * Type writer
 *
 * @param x  the x. 
 */
    public static void typeWriter(String x){ 

        for (int y = 0; y < x.length(); y++) {
            System.out.print(x.charAt(y));
            try {
                Thread.sleep(5); // Adjust the speed of typing here
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

/** 
 *
 * Image
 *
 * @param path  the path. 
 */
    public static void image(String path) { 

        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        // Create a new JFrame object
        JFrame frame = new JFrame("Heat Rate Monitor");
        // Create a new JLabel object and set its icon to the image
        JLabel label = new JLabel();
        label.setIcon(icon);
        // Add the label to the frame
        frame.getContentPane().add(label);
        // Configure the frame
        frame.pack();
        frame.setVisible(true);
        System.out.println("Once you found your pulse close this window :)");
        while (frame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Ignore interruptions
            }
        }
    }



/** 
 *
 * Heart health
 *
 * @param scan  the scan. 
 * @param dateString  the date string. 
 */
public static void heartHealth(Scanner scan,String dateString){ 

    String heartRateMonitor = "The Heart Rate Monitor allows you to measure your heart rate and record it for future reference.\nMaintaining a good heart rate is crucial for overall health and well-being.\nYour heart rate is the number of times your heart beats per minute (bpm), and it can vary depending on your activity level, stress, and other factors.\nInorder to record your heart rate, follow the following instructions.";
    int i =0;
    
    for (i = 0; i < heartRateMonitor.length(); i++) {
        System.out.printf("%c", heartRateMonitor.charAt(i));
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    System.out.println("\nType \"yes\" if you understand.");
    scan.nextLine();
    //y string for yes input
    String y = "";
    //convert to lowercase
    y=y.toLowerCase();
    while (true) {
        y = scan.nextLine();
        if (y.equals("yes")) { // check if input contains only alphabetic characters
            break; // exit the loop if input is valid
        } else {
            System.out.println("Invalid input, please try again."); // prompt the user to enter a valid input
        }
    }
    //call sleep function with 1 s
    sleep(1000);
    //call clear screen function
    clearScreen();
    //call image function and reference heartbeat.jpg to display on a seperate window
    image("images/heartbeat.jpg");
    String timerText = "The timer will start when you press enter. Make sure you count the number of beats that you feel at your point of contact.\n";
    //standard
    for (i = 0; i < timerText.length(); i++) {
        System.out.printf("%c", timerText.charAt(i));
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    //press enter
    scan.nextLine();
    scan.nextLine();
    clearScreen();
    countDown(10);
    clearScreen();
    sleep(2000);
    System.out.println("Enter how many beats you counted:");
    int beats = scan.nextInt();
    System.out.println("Calculating your heartrate...");
    sleep(1000);
    clearScreen();
    int bpm = beats *6;
    System.out.println("Your heartrate is " + bpm +" beats per minute");
    sleep(1000);
    System.out.println("Press enter to continue...");
    scan.nextLine();
    clearScreen();
    try {
        //writing onto a file
        // initilzie filewriter object
        FileWriter writer = new FileWriter(new File("heartinfo.csv"), true);
        //initilize scanner object for files
        Scanner fileInput = new Scanner(new File("heartinfo.csv"));
        //set delimeter as comma for csv file
        fileInput.useDelimiter(",");
        System.out.println("Enter name as follows: LastName,FirstName ");
        String name = scan.nextLine();
        writer.write("\n"+name);
        System.out.println("Enter age:");
        String age = scan.nextLine();
        writer.write(","+age+","+bpm+",");
        System.out.println("Were you performing any physical activities before you measured your heart rate? Please enter either \"y\" or \"n\"");
        String active = scan.nextLine();
        active.toUpperCase();
        writer.write(active+",");
        writer.write(dateString);
        writer.close();
    }catch(Exception e){
        System.out.println("Exception occured! Please try again.");
    }
    averageCalcHeartBPM();
}

/** 
 *
 * Average calc heart BPM
 *
 */
public static void averageCalcHeartBPM(){ 

 // Define the CSV file path and the column index to calculate the average for
 String csvFilePath = "heartinfo.csv";
 int columnIndex = 3; // Replace with the index of the column you want to calculate the average for

 // Initialize the Scanner to read the CSV file
 try (Scanner scanner = new Scanner(new File(csvFilePath))) {
     String line;
     int rowCount = 0;
     double sum = 0;

     // Skip the first row
     if (scanner.hasNextLine()) {
         scanner.nextLine();
     }

     // Iterate through each line in the CSV file
     while (scanner.hasNextLine()) {
         line = scanner.nextLine();
         String[] columns = line.split(",");

         // Get the value of the specified column for the current row
         String columnValue = columns[columnIndex];

         // Convert the column value to a double and add it to the sum
         sum += Double.parseDouble(columnValue);
         rowCount++;
     }

     // Calculate the average
     double average = sum / rowCount;

     // Print the result
     System.out.println("Your average heartrate with the currect stored data is" + average);
     sleep(1000);
     System.out.println("Press enter to continue: ");

 } catch (FileNotFoundException e) {
     e.printStackTrace();
 }
}


/** 
 *
 * My posture
 *
 * @param scan  the scan. 
 * @param dateString  the date string. 
 */
public static void MyPosture(Scanner scan, String dateString){ 

    clearScreen();
    String postureString = "";
    System.out.println("Press Enter To Continue...");
    scan.nextLine();
    scan.nextLine();
    clearScreen();
    System.out.println("Please type \"yes\" if you would like to start the posture checker... Else type \"no\".");
    String choice = scan.nextLine();
    choice = choice.toLowerCase();
    sleep(500);
    clearScreen();
    System.out.println("In order for you to mainitan and healthy posture, you will be reminded at a set interval.");
    sleep(100);
    System.out.println("To set this interval please enter an integer value (minutes) in which you would like to be reminded to fix your posture.");
    sleep(500);
    int interval = scan.nextInt();
    while (true){
        if (choice.equals("yes")){ 
            ImageIcon icon = new ImageIcon("images/posture.gif");
            Image image = icon.getImage();
            // Create a new JFrame object
            JFrame frame = new JFrame("Your Posture Reminder");
            // Create a new JLabel object and set its icon to the image
            JLabel label = new JLabel("You will be reminded every " + interval+" minutes to fix your posture.");
            label.setIcon(icon);
            // Add the label to the frame
            frame.getContentPane().add(label);
            // Configure the frame
            frame.pack();
            frame.setVisible(true);
            long minutes = (interval*60000);
            if (frame.isVisible()){ // if frame is viible
                sleep(minutes);
                clearScreen();
            }
            if (!frame.isVisible()){ // frame not visible
                try {
                    System.out.println("Exit the program to end this process.");
                    String escape = scan.nextLine();
                    if (escape.toLowerCase().equals("stop")){
                    }
                } catch (Exception e) {
                   System.out.println("Exception Occured!"); // Ignore interruptions
                }
            }
        }else{
        }
    }
    
}

/** 
 *
 * Binary search
 *
 */
    public static void binarySearch(){ 

        try{
            Scanner scan = new Scanner(System.in);
            Scanner fileInput = new Scanner(new File("screentime.csv"));
        
            fileInput.useDelimiter(",");
            System.out.println("Enter the date you would like to see your screentime for in the format: YYYY-MM-DD :");
            String searchStr = scan.nextLine();
            String[] fileContents = new String[99999999]; // assume max lines (could change)
            int i = 0;
            while (fileInput.hasNextLine()) {
                fileContents[i] = fileInput.nextLine();
                i++;
            }
            int low = 0;
            int high = i - 1;
            boolean found = false;
            while (low <= high) {
                int mid = (low + high) / 2;
                // Checks if it is true, if it is found the loop breaks and exits the statement
                if (fileContents[mid].equals(searchStr)) {
                    System.out.println("Found at line " + (mid+1));
                    found = true;
                    break;
                // .compareTo(searchStr) is a method that compares the retrieved string value with the search string value. 
                // < 0 checks whether the comparison result is less than zero, indicating that the retrieved value is less than the search value.
                } else if (fileContents[mid].compareTo(searchStr) < 0) {
                    low = mid + 1;// if search string is greater than current line, move to right half
                } else {
                    high = mid - 1;// if search string is less than current line, move to left half
                }
            }
                // If the search string was not found, print a message
            if (!found) {   
                System.out.println("String not found in the text file");
            }
            // close file
            fileInput.close();
        }catch(Exception e){
            System.out.println("Error Occured!");
        }
}

/** 
 *
 *  BMI
 *
 */
// This function prompts the user to enter the weight and height of multiple people and calculates their BMI (Body Mass Index)
public static void BMI(){

    // Initialize Scanner object for reading user input
    Scanner scan = new Scanner(System.in);

    // Prompt the user to enter the number of people
    System.out.print("Enter the number of people: ");
    int numPeople = scan.nextInt();

    // Create a 2D array to store the weight and height data for each person
    double[][] data = new double[numPeople][2];

    // Prompt the user to enter the weight and height for each person and store the data in the 2D array
    for (int i = 0; i < numPeople; i++) {
        System.out.println("Enter weight and height for person " + (i + 1) + ":");
        System.out.print("Weight (in kg): ");
        data[i][0] = scan.nextDouble();
        System.out.print("Height (in m): ");
        data[i][1] = scan.nextDouble();
    }

    // Print a header for the BMI results
    System.out.println("\nBMI Results:");

    // Calculate the BMI for each person and print it to the terminal
    for (int i = 0; i < numPeople; i++) {
        double weight = data[i][0];
        double height = data[i][1];
        double bmi = weight / (height * height);
        System.out.printf("Person %d: %.2f\n", (i + 1), bmi);
    }
}
// This function takes a dateString as an argument and records the user's screen time for a session.
public static void ScreenTime(String dateString){

    // clears the terminal screen
    clearScreen();

    // initialize Scanner object for reading user input
    Scanner scan = new Scanner(System.in);

    // record the start time of the screen time session in milliseconds
    long startTime = System.currentTimeMillis();

    // Prompt the user to press enter when the session is finished
    System.out.println("Press enter once you are finished your session...");
    scan.nextLine();

    // record the end time of the screen time session in milliseconds
    long endTime = System.currentTimeMillis();

    // calculate the total screen time by subtracting start time from end time
    long screenTime = endTime - startTime;

    try{
        // create a FileWriter object to write data to a file named "screentime.csv"
        FileWriter writer = new FileWriter(new File("screentime.csv"), true);

        // initialize Scanner object for reading data from the "screentime.csv" file and set delimiter as comma
        Scanner fileInput = new Scanner(new File("screentime.csv"));
        fileInput.useDelimiter(",");

        // write the date and screen time data to the file, separated by a comma
        writer.write("\n"+dateString+","+screenTime);

        // close the FileWriter object
        writer.close();

    } catch(Exception e) {

        // if an exception occurs, print an error message and prompt the user to restart
        System.out.println("Exception occured please restart.");
    }

    // Print the total screen time in hours to the terminal
    System.out.println("Your screentime for this session is:" + millisecondsToHours(screenTime));
}

/** 
 *
 * It is a constructor. 
 *
 * @param milliseconds  the milliseconds. 
 * @return hours that are converted
 */
public static double millisecondsToHours(long milliseconds) { 

    double hours = (double) milliseconds / (1000 * 60 * 60);
    return hours;
}

/** 
 *
 * Blood pressure function
 *
 * @param scan  the scan. 
 * @param dateString  the date string. 
 */
public static void bloodPressureFunction(Scanner scan, String dateString) { 

    String bloodPressure = "Exposure to blue light from electronic devices, such as smartphones and tablets, " +
            "can disrupt circadian rhythms and lead to a decrease in melatonin production, which can contribute " +
            "to the development of hypertension. According to a study in the journal Chronobiology International, " +
            "exposure to blue light at night was associated with higher systolic blood pressure. As such, " +
            "it is important to keep accurate logs of your blood pressure for your personal health.";

    for (int i = 0; i < bloodPressure.length(); i++) {
        System.out.print(bloodPressure.charAt(i));
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    System.out.println("\nPress Enter To Continue...");
    scan.nextLine();
    scan.nextLine();
    clearScreen();

    String bPMenu = 
            "*************************************************\n" +
            "*                 Blood Pressure                *\n" +
            "*                                               *\n" +
            "*  1) Enter and compare                         *\n" +
            "*  2) Learn more...                             *\n" +
            "*  3) Return to main menu                       *\n" +
            "*                                               *\n" +
            "*  Enter choice:                                *\n" +
            "*                                               *\n" +
            "*************************************************";

    for (int i = 0; i < bPMenu.length(); i++) {
        System.out.print(bPMenu.charAt(i));
        try {
            Thread.sleep(5); // Adjust the speed of typing here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    int option = scan.nextInt();
    switch (option) {
        case 1:
            clearScreen();

            String enterBP = "In order to get accurate results, we must gather more information about you. " +
                    "As you will not be able to perform this at home (without the use of a blood pressure machine " +
                    "(manometer)), you must perform it elsewhere and record your information here. " +
                    "See the following instructions for more information...";

            typeWriter(enterBP);
            System.out.println("Press enter to continue....");
            scan.nextLine();
            clearScreen();
            System.out.println("Read the following instructions if you have a manometer... Close the tab to continue....");
            image("images/bp.jpg");
            System.out.println("Press enter to continue...");
            scan.nextLine();
            clearScreen();
            System.out.println("If you are able to enter your blood pressure, enter it below in the form XXX/YY."+
                    "If not, please enter 0.");

            String bloodPressureInt = scan.nextLine();

            if (bloodPressureInt.equals("0")) {
                break;
            } else {
                try {
                    FileWriter writer = new FileWriter(new File("heartinfo.csv"), true);
                    Scanner fileInput = new Scanner(new File("heartinfo.csv"));
                    fileInput.useDelimiter(",");
                    System.out.println("Enter name as follows: LastName,FirstName ");
                    String name = scan.nextLine();
                    writer.write("\n" + name);
                    System.out.println("Enter age:");
                    String age = scan.nextLine();
                    writer.write("," + age + "," + bloodPressureInt + ",");
                    System.out.println("Were you performing any physical activities before you measured your heart rate? " +
                            "Please enter either \"y\" or \"n\"");
                    String active = scan.nextLine().toUpperCase();
                    writer.write(active + ",");
                    writer.write(dateString);
                    writer.close();
                } catch (Exception e) {
                    System.out.println("Exception occured! Please try again.");
                }
                break;
            }
        case 2:
        try {
            // Open the file using a Scanner object
            Scanner scanner = new Scanner(new File("heartfacts.txt"));

            // Create an ArrayList to hold all the lines in the file
            ArrayList<String> lines = new ArrayList<>();

            // Read each line from the file and add it to the ArrayList
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }

            // Close the file
            scanner.close();

            // Create a Random object to generate random numbers
            Random random = new Random();

            // Loop until the user types "q" or "Q"
            Scanner inputScanner = new Scanner(System.in);
            String input = "";
            while (!input.equalsIgnoreCase("q")) {
                // Select a random line from the ArrayList
                int index = random.nextInt(lines.size());
                String randomLine = lines.get(index);

                // Print the random line to the console
                System.out.println(randomLine);

                // Prompt the user to continue or quit
                System.out.print("Press Enter to continue or type Q to quit: ");
                input = inputScanner.nextLine();
            }

            // Close the input scanner
            inputScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    case 3:
    break;
    } 
}
}