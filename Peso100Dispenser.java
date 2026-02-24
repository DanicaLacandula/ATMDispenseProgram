public class Peso100Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        int amount = cur.getAmount();
        
        if (amount >= 100) {
            int num = amount / 100;
            int remainder = amount % 100;
            System.out.println("Dispensing " + num + " x 100 peso bills");
            
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(cur);
        }
    }
}