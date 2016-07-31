abstract class Price {
	abstract int getPriceCode();

	abstract double getCharge(int daysRented){
		double result = 2;
		if (daysRented > 2)
		result += (daysRented - 2) * 1.5;
		return result;
	}
	int getFrequentRenterPoints(int daysRented){
		return 1;
	}
}