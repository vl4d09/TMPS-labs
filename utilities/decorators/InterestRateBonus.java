package utilities.decorators;

import domain.models.Account;

public class InterestRateBonus extends AccountDecorator {
    private double bonusRate;

    public InterestRateBonus(Account account, double bonusRate) {
        super(account);
        this.bonusRate = bonusRate;
    }

    public void applyBonus() {
        double bonus = account.getBalance() * bonusRate;
        account.deposit(bonus);
    }
}
