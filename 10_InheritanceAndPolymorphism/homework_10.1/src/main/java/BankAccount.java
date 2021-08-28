public class BankAccount {
  protected double bill;

  public double getBill() {
    return bill;
  }

  public void setBill(double bill) {
    this.bill = bill;
  }

  public double getAmount() {
    return bill;
  }

  boolean put(double amountToPut) {
    if (amountToPut > 0){
      bill += amountToPut;
      return true;
    } else {
      return false;
    }
  }

  boolean take(double amountToTake) {
    if (amountToTake <= bill){
      bill -= amountToTake;
      return true;
    }else {
      return false;
    }
  }

  boolean send(BankAccount receiver, double amount){
    if (receiver.take(amount) && receiver.put(amount)){
      return true;
    } else {
      return false;
    }
  }
}