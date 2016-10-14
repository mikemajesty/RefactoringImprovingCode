class Customer {
  private String _name;
  private Vector _rentals = new Vector();

  public Customer (String name){
    _name = name;
  };

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName (){
    return _name;
  };

  public String statement() {
    Enumeration rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      //show figures for this rental
      result += "\t" + each.getMovie().getTitle()+ "\t" +
      String.valueOf(each.getCharge()) + "\n";
    }
    //add footer lines
    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    result += "You earned " +  String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
    return result;
  }

  private int getTotalFrequentRenterPoints(){
    int result = 0;
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }

  private double amountFor(Rental aRental) {
    double result = 0;
    switch (aRental.getMovie().getPriceCode()) {
    case Movie.REGULAR:
      result += 2;
    if (aRental.getDaysRented() > 2)
      result += (aRental.getDaysRented() - 2) * 1.5;
    break;
    case Movie.NEW_RELEASE:
      result += aRental.getDaysRented() * 3;
    break;
    case Movie.CHILDRENS:
      result += 1.5;
    if (aRental.getDaysRented() > 3)
      result += (aRental.getDaysRented() - 3) * 1.5;
    break;
    }
    return result;
  }

  private double amountFor(Rental aRental) {
    return aRental.getCharge();
  }
}
