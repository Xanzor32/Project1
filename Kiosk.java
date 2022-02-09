import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * This class is where all of the commands will be run! This is where the user may type 
 * a command to access their appointments and such
 */

/**
 * @author Alexander Reyes
 *
 */
public class Kiosk {

	private String input = "";
	private String command = "";
	private String[] appointmentInfo = new String[7];
	private int day;
	private int month;
	private int year;

	/**
	 * This method runs the kiosk and starts the process of getting input from the user.
	 * If the input becomes Q then the kiosk stops running and the program is finished.
	 */
	public void run() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Kiosk running. Ready to process transactions./n/n");
		while(!command.equals("Q")){
			input = scan.nextLine();
			command = input.substring(0,1);
			appointmentInfo = splitString(input);
			commandCheck(command);
		}
		System.out.print("Kiosk session ended");
		
	}
	
	/**
	 * This method will check to make sure the command that was inputed is a correct command.
	 * If it is not correct it will give back that this command was invalid
	 * @param commandGiven This is the command given by the user in the console.
	 */
	public void commandCheck(String commandGiven) {
		switch(commandGiven) {
		case "B": //BOOK an appointment
			Patient person = new Patient(appointmentInfo[2], appointmentInfo[1], new Date(appointmentInfo[1]));
			Location location = new Location(appointmentInfo[6]);
			Time timePicked = new Time(appointmentInfo[5]);
			Date appointDate = new Date(appointmentInfo[4]);
			break;
		case "C": //Cancels an appointment
			break;
		case "CP": //Cancels all appointments by a given patient
			Patient person = new Patient(appointmentInfo[2],appointmentInfo[2],new Date(appointmentInfo[1]));
			break;
		case "P": //Prints all the appointments in current order
			Schedule.print();
			break;
		case "PZ": //Prints appointments by zip code
			Schedule.printByZip();
			break;
		case "PP": //Prints appointments by patient name
			Schedule.printByPatient();
			break;
		case "Q": //The Kiosk ends session
			break;
		default: System.out.print("Invalid command!/n");
		}
	}
	
	/**
	 * This method takes the input given from the user and splits it to its parts.
	 * This will be done using the string tokenizer library.
	 * @param inputGiven This is the input given from the user in the console
	 * @return an array of strings that is the input from the console split into singular Strings
	 */
	private String[] splitString(String inputGiven) {
		StringTokenizer st = new StringTokenizer(inputGiven);
		String[] details = new String[st.countTokens()];
		int arrPos = 0;
	    while (arrPos<details.length){
	    	details[arrPos] = st.nextToken();
	    	arrPos++;
	    }
	    return details;
	}
	
	/**
	 * This method will convert the string of the date to the int values
	 * @param date this is the string version of the date
	 */
	/*private void convertDate(String date) {
		int count = 0;
		int firstSlash;
		while(!(date.substring(count,count++).equals("//"))){
			count++;
		}
		firstSlash = count;
		month = Integer.parseInt(date.substring(0,count));
		while(!(date.substring(count,count++).equals("//"))){
			count++;
		}
		day = Integer.parseInt(date.substring(firstSlash+1,count));
		year = Integer.parseInt(date.substring(date.length()-4,date.length()));
	}*/
}
