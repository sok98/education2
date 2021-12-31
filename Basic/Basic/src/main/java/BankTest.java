


public class BankTest {
    public static void main(String[] args) throws Exception {

        int balance = 10000;
        balance -= 2000;
        balance -= 1000;
        balance += 1000;

        System.out.println(balance);

        Account acc = new Account();
        acc.deposit(1000);

        int balance2 = acc.withdraw(400);

        System.out.println(acc.getBalance());

        WRAccount bank1 = new WRAccount();
        bank1.deposit(1000);
        System.out.println(bank1.getBalance());

        KBAccount bank2 = new KBAccount();
        bank2.deposit(1000);
        System.out.println(bank2.getBalance());

        int mode = 0;
        int money = 20000;

        BasicAccount bank = null;

        if ( mode == 0 ) {
             bank = new WRAccount();
        } else if ( mode == 1 ) {
             bank = new KBAccount();
        }

        bank.deposit(money);
        System.out.println(bank.getBalance());

    }
}
class Account {
    private  int balance;

    public int withdraw(int value) throws Exception {

        if ( balance >  value) {
            balance -= value;
        } else {
            throw new Exception("잔고부족");
        }
        return  balance;
    }

    public void deposit(int value) {
        balance += value;
    }

    public int getBalance() {
        return  balance;
    }
}

class BasicAccount {
    protected  int balance;

    public  void deposit(int value) {
        balance += value;
    }
    public  void withdraw(int value) {
        balance -= value;
    }

    public int getBalance() {
        return  balance;
    }
}

class WRAccount  extends  BasicAccount {
    public  void deposit(int value) {
        balance += value * 1.1f;
    }
}

class KBAccount extends  BasicAccount {
}