public class Peso1000Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        int amount = cur.getAmount();
        
        if (amount >= 1000) {
            int num = amount / 1000;
            int remainder = amount % 1000;
            System.out.println("Dispensing " + num + " x 1000 peso bills");
            
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(cur);
        }
    }
}