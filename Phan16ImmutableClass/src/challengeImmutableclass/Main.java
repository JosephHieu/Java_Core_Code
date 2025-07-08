package challengeImmutableclass;

import challengeImmutableclass.bank.BankAccount;
import challengeImmutableclass.bank.BankCustomer;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//       BankAccount account =
//                new BankAccount(BankAccount.AccountType.CHECKING, 500);
//       System.out.println(account);

        BankCustomer joe = null;
        System.out.println(joe);

        List<BankAccount> accounts = joe.getAccounts();
        accounts.clear();
        System.out.println(joe);










    }
}
