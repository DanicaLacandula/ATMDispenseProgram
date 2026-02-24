public class Peso20Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        int amount = cur.getAmount();
        
        if (amount >= 20) {
            int num = amount / 20;
            int remainder = amount % 20;
            System.out.println("Dispensing " + num + " x 20 peso bills");
            
            if (remainder != 0) {
                System.out.println("Remaining amount " + remainder + " cannot be dispensed with available denominations.");
            }
        } else {
            System.out.println("Amount " + amount + " cannot be dispensed with available denominations.");
        }
    }
}