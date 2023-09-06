public class Main {

    public static void main(String[] args) {

     Card visaCard = new Card();
     visaCard.setDeposit(0.00f);
     visaCard.setNumberCard("4573 6847 3497 1284");
     visaCard.setPaySystem("VISA");
     visaCard.setCurrency('₽');
     visaCard.pay(250f);
     visaCard.transfer(500.00f);


     System.out.println("\nОперации по карте " + visaCard.getPaySystem() + " " + visaCard.getNumberCard() + ": ");
     String[] transactions = visaCard.getTransactions();
     int countTransactions = visaCard.getCountTransactions();
     for (int id = 0; id < countTransactions; id++) {
         System.out.println("Операция #" + id + " по карте " + transactions[id]);
     }

     Card masterCard = new Card();
     masterCard.setDeposit(5600.00f);
     masterCard.setNumberCard("7836 7562 5734 8693");
     masterCard.setPaySystem("MASTERCARD");
     masterCard.setCurrency('₽');
     masterCard.pay(600f);


     Card unionPay = new Card();
     unionPay.setDeposit(228.0f);
     unionPay.setNumberCard("4352 2831 1230 6932");
     unionPay.setPaySystem("UNIONPAY");
     unionPay.setCurrency('₽');
     unionPay.pay(228f);


     //создадим массив для карт
        Card[] cards = new Card[3];
        cards[0] = visaCard;
        cards[1] = masterCard;
        cards[2] = unionPay;

        cards[0].pay(100.00f);
        cards[1].transfer(200.00f);

        System.out.println("Операции по всем картам: ");
        for (int idCard = 0; idCard < cards.length; idCard++) {
            Card card = cards[idCard];
            String[] cardtransaction = card.getTransactions();
            int cardCountTransaction = card.getCountTransactions();

            for(int id = 0; id < cardCountTransaction; id++) {
                System.out.println("Операция #" + id + " по карте " + cardtransaction[id]);
            }

        }

    }
}