package LambdaExpressions;

import java.util.Arrays;
import java.util.List;

class Invoice {
	int transactionId;

	public Invoice(int transactionId) {
		this.transactionId = transactionId;
	}
	
	@Override
	public String toString() {
		return "Invoice{transactionId=" + transactionId + "}";
	}
}

public class InvoiceObjectCreation {

	public static void main(String[] args) {
		List<Integer> ids = Arrays.asList(101, 102, 103, 104);
		
		ids.stream().map(Invoice::new).forEach(a -> System.out.println(a));

	}

}
