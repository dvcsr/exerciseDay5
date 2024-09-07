import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.println("Enter source currency(USD, EUR, GBP or JPY): ");
        String firstCurrency = myScan.nextLine();


        System.out.println("Enter the amount to convert: ");
        double amount = myScan.nextDouble();
        myScan.nextLine();

        System.out.println("Enter target currency(USD, EUR, GBP or JPY): ");
        String secondCurrency = myScan.nextLine();

        String check = firstCurrency + secondCurrency;
        check.toLowerCase();

        double result = 0;
        boolean isValid = true;


        if (check.contains("usd") && check.contains("eur")){
            result = usdEURConverter(firstCurrency, secondCurrency, amount);
        }
        else if (check.contains("usd") && check.contains("gbp")){
            result = usdGBPConverter(firstCurrency, secondCurrency, amount);
        }
        else if (check.contains("usd") && check.contains("jpy")){
            result = usdJPYConverter(firstCurrency, secondCurrency, amount);
        }
        else if (check.contains("eur") && check.contains("gbp")) {
            result = eurGBPConverter(firstCurrency, secondCurrency, amount);
        }
        else if (check.contains("eur") && check.contains("jpy")) {
            result = eurJPYConverter(firstCurrency, secondCurrency, amount);
        }
        else if (check.contains("gbp") && check.contains("jpy")) {
            result = gbpJPYConverter(firstCurrency, secondCurrency, amount);
        }
        else if (firstCurrency.equals(secondCurrency)) result = amount;
        else isValid = false;

        if (isValid) {
            String resultstr = String.format("%.2f", result);
            System.out.printf(amount + " " + firstCurrency.toUpperCase() + " is equal to " + resultstr + " " + secondCurrency.toUpperCase());
        }
        else System.out.println("error, please input correctly");
        }

    public static double usdEURConverter(String cur1, String cur2, double n){
        if (cur1.equalsIgnoreCase("usd") || cur2.equalsIgnoreCase("eur"))
            n = n - 0.08;
        else n = n * 100/92;
        return n;
    }
    public static double usdGBPConverter(String cur1, String cur2, double n){
        if (cur1.equalsIgnoreCase("usd") || cur2.equalsIgnoreCase("gbp"))
            n = n - 0.21;
        else n = n * 100/79;
        return n;
    }
    public static double eurGBPConverter(String cur1, String cur2, double n){
        if (cur1.equalsIgnoreCase("eur") || cur2.equalsIgnoreCase("gbp"))
            n = n * 79/92 ;
        else n = n * 92/79;
        return n;
    }
    public static double usdJPYConverter(String cur1, String cur2, double n){
        if (cur1.equalsIgnoreCase("usd") || cur2.equalsIgnoreCase("jpy"))
            n = n * 147.65;
        else n = n / 147.65;
        return n;
    }
    public static double eurJPYConverter(String cur1, String cur2, double n){
        if (cur1.equalsIgnoreCase("eur") || cur2.equalsIgnoreCase("jpy"))
            n = n * 147.65 / 92 ;
        else n = n * 92 / 147.65 ;
        return n;
    }
    public static double gbpJPYConverter(String cur1, String cur2, double n){
        if (cur1.equalsIgnoreCase("gbp") || cur2.equalsIgnoreCase("jpy"))
            n = 147.65/79 * n ;
        else n = 79/147.65 * n;
        return n;
    }
}
