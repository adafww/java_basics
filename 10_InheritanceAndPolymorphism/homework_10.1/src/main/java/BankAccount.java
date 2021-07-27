public class BankAccount {

  double bill;

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

    /*
    //второй способ
    if (amount > 0 && amount <= this.bill){


      this.bill -= amount;
      receiver.bill += amount;
      return true;
    }else {

      return false;
    }
    */
  }
}