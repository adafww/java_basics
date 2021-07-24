public class BankAccount {

  double bill;

  public double getAmount() {

    return bill;
  }

  public void put(double amountToPut) {

    if (amountToPut > 0){

      bill += amountToPut;
    }
  }

  public void take(double amountToTake) {

    if (amountToTake <= bill){

      bill -= amountToTake;
    }
  }
}