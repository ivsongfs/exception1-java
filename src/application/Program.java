package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = scan.nextInt();
	
			System.out.print("Check-in Date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
	
			System.out.print("Check-out Date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(scan.next());
	
			Reservation reserv = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
	
			System.out.println();
			System.out.println("Enter data to update reservation");
			System.out.print("Check-in Date (dd/mm/yyyy): ");
			checkIn = sdf.parse(scan.next());
	
			System.out.print("Check-out Date (dd/mm/yyyy): ");
			checkOut = sdf.parse(scan.next());
	
			reserv.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
		}
		catch (ParseException e) {
			System.out.println("Valor de data inválido!");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		scan.close();
	}

}
