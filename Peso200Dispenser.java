public class Peso200Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        int amount = cur.getAmount();
        
        if (amount >= 200) {
            int num = amount / 200;
            int remainder = amount % 200;
            System.out.println("Dispensing " + num + " x 200 peso bills");
            
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(cur);
        }
    }
}