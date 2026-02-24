public class BPI_Atm {
    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        
        // Test different amounts
        int[] testAmounts = {2970, 2750, 250};
        
        for (int amount : testAmounts) {
            System.out.println("\n=== Requesting amount: " + amount + " ===");
            
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiples of 10 pesos.");
            } else if (amount < 20) {
                System.out.println("Minimum withdrawal amount is 20 pesos.");
            } else {
                atmDispenser.dispense(new Currency(amount));
            }
        }
    }
}