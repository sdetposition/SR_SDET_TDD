package jsonUtils.invoices;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseInvoiceJson {

	public static int rev = 0;
	public static void readInvoicesJson(String jsonFilePath)
			throws StreamReadException, DatabindException, IOException {
		ObjectMapper objMapper = new ObjectMapper();
		File file = new File(jsonFilePath);
		Invoices invoices = objMapper.readValue(file, Invoices.class);

		System.out.println("Catalog Name      : " + invoices.getCatalogName());
		System.out.println("Inventory Updated : " + invoices.getLastUpdated());
		List<Categories> catList = invoices.getCategories();

		for (Categories cat : catList) {
			System.out.println("	Cat ID   : " + cat.getCategoryId());
			System.out.println("	Cat Name : " + cat.getCategoryName());
			List<Products> products = cat.getProducts();

			for (Products product : products) {
				System.out.println("		Product ID    	: " + product.getProductId());
				System.out.println("		Product Brand 	: " + product.getBrand());
				System.out.println("		Product Name  	: " + product.getProductName());
				System.out.println("		Product Price 	: " + product.getPrice() + " Rs");

				if (product.getSpecifications() != null) {
					Specifications spec = product.getSpecifications();
					if (spec.getProcessor() != null && !spec.getProcessor().isEmpty()) {
						System.out.println("		Processor    	: " + spec.getProcessor());
					}
					if (spec.getStorage() != null && !spec.getStorage().isEmpty()) {
						System.out.println("		Storage   	: " + spec.getStorage());
					}
					if (spec.getRam() != null && !spec.getRam().isEmpty()) {
						System.out.println("		Ram       	: " + spec.getRam());
					}
					if (spec.getDisplay() != null && !spec.getDisplay().isEmpty()) {
						System.out.println("		Display   	: " + spec.getDisplay());
					}
					if (spec.getStorageOptions() != null && !spec.getStorageOptions().isEmpty()) {
						List<String> storageOps = spec.getStorageOptions();
						System.out.print("		Storage Options : ");
						storageOps.stream().forEach(storage -> System.out.print(storage + ","));
					}
					if (spec.getCameraFeatures() != null && !spec.getCameraFeatures().isEmpty()) {
						System.out.print("\n		Camera Options 	: ");
						spec.getCameraFeatures().stream().forEach(cam -> System.out.print(cam + ","));
					}

				}

				if (product.getReviews() != null && !product.getReviews().isEmpty()) {
					   System.out.println("\n         Revies  	: ");
					product.getReviews().stream().forEach(revie -> {
						
						System.out.println("		Revie "+(++rev));
						System.out.println(
					                     "		Revier Name 	: "+revie.getReviewerName() 
					                    +"\n		Rating 		: " + revie.getRating() 
					                    + "\n		Comments 	: " + revie.getComment()+"\n");});
				}

				System.out.println("\n");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		String jsonPath = System.getProperty("user.dir") + "\\src\\main\\resources\\jsonFiles\\invoices.json";
		System.out.println(jsonPath);

		readInvoicesJson(jsonPath);

	}

}
