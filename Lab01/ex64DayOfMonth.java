import java.util.Scanner;
public class ex64DayOfMonth {

	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		Scanner keyboard = new Scanner(System.in);
		int day = 0;
		while (true) {
			System.out.println("Enter a month:");
			String strMonth = keyboard.nextLine();
			System.out.println("Enter a year:");
			//String strYear = keyboard.nextLine();
			int iYear;
            try {
                iYear = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, please try again");
                continue;
            }
			//keyboard.nextLine();
			int month = 0;
            if (strMonth.equalsIgnoreCase("january") || strMonth.equalsIgnoreCase("jan.")
                    || strMonth.equalsIgnoreCase("jan") || strMonth.equals("1")) {
                month = 1;
            } else if (strMonth.equalsIgnoreCase("february") || strMonth.equalsIgnoreCase("feb.")
                    || strMonth.equalsIgnoreCase("feb") || strMonth.equals("2")) {
                month = 2;
            } else if (strMonth.equalsIgnoreCase("march") || strMonth.equalsIgnoreCase("mar.")
                    || strMonth.equalsIgnoreCase("mar") || strMonth.equals("3")) {
                month = 3;
            } else if (strMonth.equalsIgnoreCase("april") || strMonth.equalsIgnoreCase("apr.")
                    || strMonth.equalsIgnoreCase("apr") || strMonth.equals("4")) {
                month = 4;
            } else if (strMonth.equalsIgnoreCase("may") || strMonth.equals("5")) {
                month = 5;
            } else if (strMonth.equalsIgnoreCase("june") || strMonth.equals("6")) {
                month = 6;
            } else if (strMonth.equalsIgnoreCase("july") || strMonth.equals("7")) {
                month = 7;
            } else if (strMonth.equalsIgnoreCase("august") || strMonth.equalsIgnoreCase("aug.")
                    || strMonth.equalsIgnoreCase("aug") || strMonth.equals("8")) {
                month = 8;
            } else if (strMonth.equalsIgnoreCase("september") || strMonth.equalsIgnoreCase("sept.")
                    || strMonth.equalsIgnoreCase("sep") || strMonth.equals("9")) {
                month = 9;
            } else if (strMonth.equalsIgnoreCase("october") || strMonth.equalsIgnoreCase("oct.")
                    || strMonth.equalsIgnoreCase("oct") || strMonth.equals("10")) {
                month = 10;
            } else if (strMonth.equalsIgnoreCase("november") || strMonth.equalsIgnoreCase("nov.")
                    || strMonth.equalsIgnoreCase("nov") || strMonth.equals("11")) {
                month = 11;
            } else if (strMonth.equalsIgnoreCase("december") || strMonth.equalsIgnoreCase("dec.")
                    || strMonth.equalsIgnoreCase("dec") || strMonth.equals("12")) {
                month = 12;
            }
            
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            	day = 31;
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
            	day =30;
            }
            else {
            	
            	if (iYear % 4 == 0 && iYear % 100  == 0) {
            		day = 29;
            	}
            	else { day = 28;
            }
           }
            
            if (month < 1 || month > 12 || iYear < 0) {
                System.out.println("Wrong input, please try again");
                continue;
            }
            System.out.println("The number of days in " + strMonth + "/" + iYear + " is " + day);
            break;
		
	}
 }
}
