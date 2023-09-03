public class Card {
    private float deposit;

    private float shopBalance;

    private float funds;

    private String numberCard;

    private String paySystem;

    private String currency;

    private int countTransactions = 0;

    private String[] transactions = new String [5];

    public float getDeposit() {
        return deposit;
    }

    public void setFunds(float setFunds) {
        this.deposit = setFunds;
    }

    public float getFunds() {
        return funds;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getPaySystem() {
        return paySystem;
    }

    public void setPaySystem(String paySystem) {
        this.paySystem = paySystem;
    }

    public int getCountTransactions() {
        return countTransactions;
    }

    public void setCountTransactions(int countTransactions) {
        this.countTransactions = countTransactions;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions[countTransactions++] = transactions;
    }

    public void pay (float sumPay) {
        // списать сумму с карты
        boolean payStatus;
      do {
          payStatus = withdrawal(sumPay);
          if (payStatus) {
              String transaction = paySystem + " " + numberCard + ": " + "оплачено " + sumPay + " остаток на карте " + deposit;
              setTransactions(transaction);
              System.out.println(transaction);
              shopBalance = shopBalance + sumPay;
          }
      } while (!payStatus);
       /*
       TODO: перевести денги на счет магазина
         */
    }

    public void transfer(float sumTransfer) {
        //нужно расчитать комисию за перевод
        float comission;
        if (sumTransfer < 50000) {
            comission = 0.0f;
        } else {
            comission = sumTransfer * 0.01f;
        }

        //затем списать денги с карты
        boolean transferStatus;
        byte errorTransaction = 0;
        do {
            transferStatus = withdrawal(sumTransfer + comission);
            if (transferStatus) {
               String transaction = paySystem + " " + numberCard + ": " + "переведено " + sumTransfer + " комиссия составила " + comission + " остаток на карте " + deposit;
               setTransactions(transaction);
               System.out.println(transaction);
            } else errorTransaction++;

        } while (!transferStatus && errorTransaction < 3);

        //и перевести денги на другую карту
    }
    private boolean withdrawal(float sum){
        deposit = deposit - sum;
        if(deposit >=0) return true;
        else return false;
    }


}
