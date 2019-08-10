package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;

public class Program {

  public static void main(String[] args) {
    
    Locale.setDefault(Locale.US);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    
    try {
    System.out.println("Enter contract data");
    System.out.print("Number: ");
    int number = sc.nextInt();
    System.out.print("Date (dd/MM/yyyy): ");
    Date date = sdf.parse(sc.next());
    System.out.print("Contract value: ");
    Double amount = sc.nextDouble();
    System.out.print("Enter the number of installments: ");
    int months = sc.nextInt();
    
    Contract contract = new Contract(number, date, amount);
    ContractService contractService = new ContractService();
    
    contractService.processContract(contract, months);
    
    System.out.println(contract);
    
    }
    catch(ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
    finally {
      sc.close();
    }

  }

}
