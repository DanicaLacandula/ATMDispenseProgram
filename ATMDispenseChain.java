public class ATMDispenseChain implements DispenseChain {
    private DispenseChain chain;
    private DispenseChain startChain;

    public ATMDispenseChain() {
        // Initialize all dispensers
        DispenseChain c1 = new Peso1000Dispenser();
        DispenseChain c2 = new Peso500Dispenser();
        DispenseChain c3 = new Peso200Dispenser();
        DispenseChain c4 = new Peso100Dispenser();
        DispenseChain c5 = new Peso50Dispenser();
        DispenseChain c6 = new Peso20Dispenser();
        
        // Set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
        c4.setNextChain(c5);
        c5.setNextChain(c6);
        
        this.startChain = c1;
        this.chain = c1;
    } 
    
    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 20) {
            startChain.dispense(currency);
        } else {
            System.out.println("Amount too small to dispense.");
        }
    }

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }
}