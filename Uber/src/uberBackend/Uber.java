package uberBackend;

import java.util.*;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import java.util.concurrent.TimeUnit;

class Data {

	Scanner sc = new Scanner(System.in);

	int day;

	ArrayList<String> bookdate = new ArrayList<>();

	ArrayList<String> returndate = new ArrayList<>();

	ArrayList<String> username = new ArrayList<>();

	ArrayList<String> mobileno = new ArrayList<>();
	ArrayList<String> vehno = new ArrayList<>();

	String user;

	int pass;

	// Method to create account

	void createAccount() {

		System.out.println("-----CREATE ACCOUNT-----");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter username:");

		user = scanner.nextLine();

		username.add(user);

		// System.out.println(username);

		System.out.println("Enter Password:");

		pass = scanner.nextInt();

		System.out.println("ACCOUNT CREATED SUCCESSFULLY");

	}

	// Method to login

	void login() {

		System.out.println("\n-----LOGIN PAGE-----");

		Scanner scanner = new Scanner(System.in);

		String userLg;

		int passLg;

		while (true) {

			System.out.println("Enter username:");

			userLg = scanner.nextLine();

			System.out.println("Enter Password:");

			passLg = scanner.nextInt();

			scanner.nextLine();

			if (userLg.equals(user) && passLg == pass) {

				System.out.println("\nLogged in successfully!!");

				break; // Exit the loop if login is successful

			} else {

				System.out.println("\nWrong password or username. Please login again!");

			}

		}

		// scanner.close();

	}

	String getFormattedDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println("\nRIDE BOOOKED ON: " + formattedDate);
		return currentDate.format(formatter);
	}

	// Phone number and otp

	String otp() {

		System.out.println("\nConfirm your Ride?");

		String ans = sc.next();

		if (ans.equals("yes")) {

			while (true) {

				System.out.println("Enter mobile number:");

				Long num = sc.nextLong();

				String numStr = Long.toString(num); // Convert number to string

				int count = numStr.length(); // Get the length of the number string

				if (count == 10) {

					mobileno.add(numStr); // Add the mobile number as a string

					System.out.println("OTP sent to your device");

					Random rand = new Random();

					int randno = rand.nextInt(90000) + 10000;

					System.out.println("OTP:" + randno + "\n\nYOUR RIDE IS CONFIRMED");

					break;

				} else {

					System.out.println("ENTER CORRECT MOBILE NUMBER");

				}

			}

		} else {

			System.out.println("OK, waiting for your next ride!^_^");

		}

		return ans;

	}

	void vehicleno() {
		Random rand1 = new Random();

		int randno1 = rand1.nextInt(9000) + 1000;
		vehno.add("MH12" + randno1);
	}
}

class transport extends Data

{

	ArrayList<String> bkDes = new ArrayList<>();

	String dest, des;

	int hr;

	Scanner ad = new Scanner(System.in);

	transport() {

	}

	transport(String dest, String des, int hr) {

		this.dest = dest;

		this.des = des;

		this.hr = hr;

	}

	ArrayList<String> location = new ArrayList<>();

	ArrayList<Integer> distance = new ArrayList<>();

	ArrayList<String> city = new ArrayList<>();

	ArrayList<Integer> cityDistance = new ArrayList<>();

	void destination() {

		if (location.isEmpty()) {

			location.add("Park");

			distance.add(5);

			location.add("Home");

			distance.add(7);

			location.add("Clinic");

			distance.add(10);

			location.add("Cafe");

			distance.add(3);

		}

		System.out.println("\nEnter destination name");

		dest = ad.next();

		int i = 0;

		for (i = 0; i < location.size(); i++) {

			if (dest.equals(location.get(i))) {

				bkDes.add(dest);

				break;

			}

		}

		while (i == location.size()) {

			System.out.println("Enter correct destination name");

			dest = ad.nextLine();

			for (i = 0; i < location.size(); i++) {

				if (dest.equals(location.get(i))) {

					break;

				}

			}

		}

	}

	void intercityDestination() {

		if (city.isEmpty()) {

			city.add("Mumbai");

			cityDistance.add(150);

			city.add("Nagpur");

			cityDistance.add(760);

			city.add("Nashik");

			cityDistance.add(214);

		}

		System.out.println("\nEnter city name:");

		des = ad.next();

		int i = 0;

		for (i = 0; i < city.size(); i++) {

			if (des.equals(city.get(i))) {

				bkDes.add(des);

				break;

			}

		}

		while (i == city.size()) {

			System.out.println("\nEnter correct city destination name");

			des = ad.next();

			for (i = 0; i < city.size(); i++) {

				if (des.equals(city.get(i))) {

					break;

				}

			}

		}

	}

}

//B extends transport

class B extends transport {

	void date() {

		int d, m, y;

		while (true) {

			System.out.println("\nEnter the date of pickup of vehicle:\nDAY:");

			d = sc.nextInt();
			System.out.println("MONTH:");

			m = sc.nextInt();
			System.out.println("YEAR:");

			y = sc.nextInt();

			bookdate.add(d + "/" + m + "/" + y); // Add booked date to the list

			if ((d < 31) && (d > 0) && (m == 4) && (y == 2024)) {

				break;

			} else {

				System.out.println("Enter valid date");

			}

		}

		System.out.println("Enter the number of days required:");

		day = sc.nextInt();

		System.out.println("\nDate of return of vehicle:" + (d + day) + "/" + m + "/" + y);

		returndate.add((d + day) + "/" + m + "/" + y); // Add return date to the list

	}

	void sedan() {

		for (int i = 0; i < location.size(); i++) {

			if (dest.equals(location.get(i))) {

				double price1 = (distance.get(i) * 25) + 50;

				System.out.println("Price=" + price1);

				System.out.println("GST=5%\nTotal Amount=Rs." + (price1 + (0.05 * price1)));

				break;

			}

		}

	}

	void suv() {

		for (int i = 0; i < location.size(); i++) {

			if (dest.equals(location.get(i))) {

				double price1 = (distance.get(i) * 25) + 70;

				System.out.println("Price=" + price1);

				System.out.println("GST=5%\nTotal Amount=Rs." + (price1 + (0.05 * price1)));

				break;

			}

		}

	}

	void hatchback() {

		for (int i = 0; i < location.size(); i++) {

			if (dest.equals(location.get(i))) {

				double price1 = (distance.get(i) * 25) + 40;

				System.out.println("Price=" + price1);

				System.out.println("GST=5%\nTotal Amount=Rs." + (price1 + (0.05 * price1)));

				break;

			}

		}

	}

	void intercitySedan() {

		for (int i = 0; i < city.size(); i++) {

			if (des.equals(city.get(i))) {

				double price1 = (cityDistance.get(i) * 25) + 50;

				System.out.println("Price=" + price1);

				System.out.println("GST=5%\nTotal Amount=Rs." + (price1 + (0.05 * price1)));

				break;

			}

		}

	}

	void intercityHatchback() {

		for (int i = 0; i < city.size(); i++) {

			if (des.equals(city.get(i))) {

				double price2 = (cityDistance.get(i) * 25) + 40;

				System.out.println("Price=Rs." + price2);

				System.out.println("GST=5%\nTotal Amount=Rs." + (price2 + (0.05 * price2)));

				break;

			}

		}

	}

	void intercitySuv() {

		for (int i = 0; i < city.size(); i++) {

			if (des.equals(city.get(i))) {

				double price3 = (cityDistance.get(i) * 25) + 70;

				System.out.println("Price=" + price3);

				System.out.println("GST=5%\nTotal Amount=Rs." + (price3 + (0.05 * price3)));

				break;

			}

		}

	}

	void carCal() {

		double rup = 3000 * 3;

		double finalp = (rup * 0.05) + rup;

		System.out.println("Amout=Rs." + rup + "\nGST=5%");

		System.out.println("\nTotal amount:Rs. " + finalp);

		System.out.println("\nPickup location will be:Cummins colllege of engineering for women");

	}

	void miniCal() {

		double rupp = 4500 * 3;

		double finalpp = (rupp * 0.05) + rupp;

		System.out.println("Amout=Rs." + rupp + "\nGST=5%");

		System.out.println("\nTotal amount:Rs. " + finalpp);

		System.out.println("\nPickup location will be:Cummins colllege of engineering for women");

	}

	void pack()

	{

		System.out.println(
				"Remember before sending a package:\n1)No alcohol or such illegal restricted items\n2)Parcel weight must be less than 5kg\n3)Item should fit into a backpack\n4)Avoid sending highly valuable or fragile items");

		for (int i = 0; i < location.size(); i++) {

			if (dest.equals(location.get(i))) {

				double price1 = (distance.get(i) * 20) + 10;

				System.out.println("\nPrice=" + price1);

				System.out.println("GST=5%\nTotal Amount=Rs." + (price1 + (0.05 * price1)));

				break;

			}

		}

	}

	void waiting()

	{

		System.out.println("ARRIVING IN 5 MINUTES");

		for (int i = 0; i < 5; i++)

		{

			try

			{

				System.out.print(". ");

				TimeUnit.SECONDS.sleep(1);

			}

			catch (InterruptedException e)

			{

			}

		}

		System.out.println("\nDRIVER HAS ARRIVED AT YOUR LOCATION!");

	}
}

public class Uber {

	public static void main(String[] args) {

		ArrayList<String> typeRd = new ArrayList<>();
		ArrayList<String> typecar = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		B b1 = new B();

		Data obj = new Data();

		int admin;

		do {

			System.out.println("Enter\n1.User\n2.Admin");

			admin = sc.nextInt();

			switch (admin) {

			case 1:

				int n;

				obj.createAccount();

				obj.login();

				System.out.println(

						"**********WELCOME TO UBER SERVICES**********\nENTER YOUR CHOICE NUMBER\n1.Rent a car\n2.Intercity\n3.Trip\n4.Send a package");

				n = sc.nextInt();

				switch (n)

				{

				// rent a car

				case 1:

					typeRd.add("Car rent");
					b1.bkDes.add("-");

					b1.date();

					System.out.println("Enter number for your choice of vehicleS:\n1.Car \n2.Mini traveller");

					int trip = sc.nextInt();

					switch (trip) {

					case 1:

						System.out.println("Price per day Rs.3000");

						b1.carCal();
						typecar.add("car");
						obj.vehicleno();
						obj.otp();

						break;

					case 2:

						System.out.println("Price per day Rs.4500");

						b1.miniCal();
						typecar.add("Mini traveller");
						obj.vehicleno();
						obj.otp();

						break;

					default:

						System.out.println("wrong option");

					}
					break;

				// intercity

				case 2:

					typeRd.add("Intercity");

					int choice;

					b1.intercityDestination();
					b1.bookdate.add("-");
					b1.returndate.add("-");

					System.out.println("1.sedan\n2.Hatchback\n3.SUV");

					choice = sc.nextInt();

					switch (choice) {

					case 1:

						// obj.todayDate();
						String formattedDate = obj.getFormattedDate();
						b1.intercitySedan();
						typecar.add("Sedan");
						obj.otp();
						obj.vehicleno();

						break;

					case 2:

						String formattedDate1 = obj.getFormattedDate();

						b1.intercityHatchback();
						typecar.add("Hatchback");
						obj.vehicleno();

						obj.otp();

						break;

					case 3:

						String formattedDate2 = obj.getFormattedDate();

						b1.intercitySuv();
						typecar.add("SUV");
						obj.vehicleno();

						obj.otp();

						break;

					default:

						System.out.println("Wrong option");

					}

					break;

				// Trip

				case 3:

					typeRd.add("Trip");

					int choicee;

					b1.destination();
					b1.bookdate.add("-");
					b1.returndate.add("-");

					System.out.println("1.Sedan\n2.Hatchback\n3.SUV");

					choicee = sc.nextInt();

					switch (choicee) {

					case 1:

						b1.sedan();
						typecar.add("Sedan");
						String formattedDate = obj.getFormattedDate();

						String r1 = obj.otp();

						if (r1.equals("yes")) {

							b1.waiting();
							obj.vehicleno();

						}

						break;

					case 2:

						b1.hatchback();
						typecar.add("Hatchback");

						String formattedDate1 = obj.getFormattedDate();

						String r2 = obj.otp();

						if (r2.equals("yes")) {

							b1.waiting();
							obj.vehicleno();

						}

						break;

					case 3:

						b1.suv();
						typecar.add("SUV");

						String formattedDate2 = obj.getFormattedDate();

						String r3 = obj.otp();

						if (r3.equals("yes")) {

							b1.waiting();
							obj.vehicleno();

						}

						break;

					default:

						System.out.println("Wrong option");

					}

					break;

				// send a package method

				case 4:

					typeRd.add("Package");

					b1.destination();
					b1.bookdate.add("-");
					b1.returndate.add("-");
					typecar.add("-");
					obj.vehicleno();

					b1.pack();

					String formattedDate = obj.getFormattedDate();

					String r4 = obj.otp();

					if (r4.equals("yes")) {

						b1.waiting();

						for (int i = 0; i < 5; i++)

						{

							try

							{

								System.out.print(". ");

								TimeUnit.SECONDS.sleep(1);

							}

							catch (InterruptedException e)

							{

							}
						}

						System.out.println("\nYOUR PACKAGE HAS BEEN DELIVERED");

					}

					break;

				default:

					System.out.println("Wrong option");

				}

				for (int i = 0; i < 5; i++)

				{

					try

					{

						System.out.print(". ");

						TimeUnit.SECONDS.sleep(1);

					}

					catch (InterruptedException e)

					{

					}
				}

				System.out.println("\nTake a moment to rate us between 1 to 10\n1-unhappy\t10-Happy");

				int rate = sc.nextInt();

				for (int k = 0; k < rate; k++) {

					System.out.print("* ");

				}

				System.out.println("\nTHANKYOU FOR CHOOSING US!");

				break;

			case 2:
				while (true) {
					System.out.println("Enter PASSWORD");
					int adpass = sc.nextInt();
					String formattedDate = obj.getFormattedDate();
					if (adpass == 1234) {
						System.out.println("TODAYS DATE:" + formattedDate);
						System.out.println("TODAY'S SUMMARY");

						System.out.printf("%-10s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", "USER",
								"BOOKED DATE", "RETURN DATE", "MOBILE NUMBER", "TYPE OF RIDE", "DESTINATION",
								"TYPE OF VEHICLE", " NUMBER PLATE");

						int maxSize = Math.max(Math.max(obj.username.size(), b1.bookdate.size()),
								Math.max(b1.returndate.size(), obj.mobileno.size()));

						for (int i = 0; i < maxSize; i++) {

							String username = i < obj.username.size() ? obj.username.get(i) : "";

							String bookdate = i < b1.bookdate.size() ? b1.bookdate.get(i) : "";

							String returndate = i < b1.returndate.size() ? b1.returndate.get(i) : "";

							String mobileno = i < obj.mobileno.size() ? obj.mobileno.get(i) : "";

							String typeOfRide = i < typeRd.size() ? typeRd.get(i) : "";

							String destination = i < b1.bkDes.size() ? b1.bkDes.get(i) : "";

							String typeofcar = i < typecar.size() ? typecar.get(i) : "";

							String vehiclesno = i < obj.vehno.size() ? obj.vehno.get(i) : "";
							System.out.println(
									"---------------------------------------------------------------------------------------------------------------------------");

							System.out.printf("%-10s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\n", username,
									bookdate, returndate, mobileno, typeOfRide, destination, typeofcar, vehiclesno);

						}
						break;
					} else {
						System.out.println("Wrong Password! Enter again!");
					}
				}
				break;

			}

		} while (admin != 2);

	}

}
