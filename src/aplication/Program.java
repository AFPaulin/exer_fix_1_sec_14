package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;



public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=1;i<=n;i++) {
			System.out.printf("Product #%d data:\n",i);
			System.out.print("Common, used or imported (c/u/i)? ");
			// entrada de dados de um char
			char ch = sc.next().charAt(0);
			// apos entrada deve se pular uma linha
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (ch == 'u') {
			System.out.print("Manufacture date (DD/MM/YYYY): ");
			Date manufactureDate = sdf.parse(sc.next()); 	
			Product prod = new UsedProduct(name,price,manufactureDate);
			list.add(prod);	
			}else if (ch == 'i') {
			System.out.print("Customs fee: ");
			double customsFee = sc.nextDouble();
			Product prod = new ImportedProduct(name,price,customsFee);
			list.add(prod);	
			}else {
			Product prod = new Product(name,price);
			list.add(prod);
			}
			
			
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		// for diferente
		for (Product prod: list) {
		System.out.println(prod.priceTag());	
		}	
		
		
		
		
		sc.close();
		
	}

}
