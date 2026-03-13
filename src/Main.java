import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // region: Input
        Scanner sc = new Scanner(Paths.get("diamonds.csv"));
        ArrayList<Diamond> diamonds = new ArrayList<>();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replaceAll("\"", "");
            String lineSplitted[] = line.split(",");
            diamonds.add(new Diamond(lineSplitted[0], lineSplitted[1], lineSplitted[2], lineSplitted[3], lineSplitted[4], lineSplitted[5], lineSplitted[6], lineSplitted[7], lineSplitted[8], lineSplitted[9], lineSplitted[10]));
        }
        sc.close();
        //endregion

        //Ukol 1
        List<String> kolikFair = diamonds.stream()
                        .filter(x -> x.getCut().equals("Fair"))
                                .map(x -> x.getCut()).toList();
        System.out.println(kolikFair.size());
        double premiumDiamondsCount = diamonds.stream().filter(x -> x.getCut().equals("Premium")).count();
        double averagePriceForPremium = diamonds.stream()
                        .filter(x -> x.getCut().equals("Premium"))
                                .mapToDouble(x -> x.getPrice()).sum() / premiumDiamondsCount;
        System.out.println(Math.round(averagePriceForPremium*100.0)/100.0);

        // Ukol2
        List<Diamond> ideal = diamonds.stream()
                .filter(x -> x.getX().equals(x.getY()))
                .toList();
        ideal.stream().forEach(x -> System.out.println(x.getCut() + " " + x.getColor() + " " + x.getPrice()));
        String idealCuts = ideal.stream().map(x -> x.getCut()).distinct().toList().toString();
        String distinct = diamonds.stream().map(x -> x.getCut()).distinct().toList().toString();
        System.out.println(idealCuts);
        System.out.println(distinct);

        //Ukol 3
        List<Double> allFairDiamonds = diamonds.stream()
                .filter(x -> x.getCut().equals("Fair"))
                .map(x -> x.getPrice()).sorted()
                .toList().reversed();
        Double maxFairDiamond = allFairDiamonds.stream()
                .max(Double::compareTo).orElse(0.0);
        allFairDiamonds.stream().forEach(x -> System.out.println(Math.round((x / maxFairDiamond * 100)*100.0) / 100.0 + "%"));
    }
}
