import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // здесь борьба с магическими числами
    final static int onePriceForAnyNoAlcoDrinkPerPiece = 99;
    final static int onePriceForAnyNoAlcoDrinkPerMl = 2;
    final static int onePriceForAnyAlcoDrinkPerPiece = 499;
    final static int onePriceForAnyAlcoDrinkPerMl = 5;
    final static int oneContainerPrice = 1;


    public static void main(String[] args) {

        // создаем магазин, две витрины:
        List<GoodsInBottling> bottlingShowcase = List.of(
                new BottlingBeer("Балтика розливное", 4.5f, onePriceForAnyAlcoDrinkPerMl, false),
                new BottlingJuice("Сок яблочный краснодарский", onePriceForAnyNoAlcoDrinkPerMl),
                new BottlingJuice("Сок апельсиновый из Анголы", onePriceForAnyNoAlcoDrinkPerMl));
        List<GoodsPieceByPiece> piecesShowcase = List.of(
                new DrinkAlcoInPackage("Водка Финляндия", onePriceForAnyAlcoDrinkPerPiece, 500, 40f, true),
                new DrinkInPackage("Молоко простоквашино", onePriceForAnyNoAlcoDrinkPerPiece, 1000));

        System.out.println("Витрина 1 (товары в розлив):");
        int counter = 1;
        for (GoodsInBottling goodInBottling : bottlingShowcase) {
            System.out.println(counter + " " + goodInBottling.getDescription());
            counter += 1;
        }

        System.out.println();
        System.out.println("Витрина 2 (товары поштучно):");
        counter = 1;
        for (GoodsPieceByPiece good: piecesShowcase) {
            System.out.println(counter + " " + good.getDescription());
            counter += 1;
        }

        System.out.println();
        System.out.println("Выберите товар из списка (введите номер витрины, номер позиции и количество в мл. или шт. через пробелы или end для завершения)," +
                " иностранные алкогольные напитки имеют налоговую наценку в 100%, цена тары оплачивается дополнительно:");

        Scanner scanner = new Scanner(System.in);
        List<String> products = new ArrayList<>();
        int sum = 0;
        while (true) {
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Ваш список покупок:");
                System.out.println(products);
                System.out.println("Итого: " + sum);
                break;
                }
            String[] inputParts = input.split("\\s+"); // используем регулярку, чтобы корректно разделять с любым числом пробелов
            if (inputParts.length != 3) {
                System.out.println("Ввод некорректный");
                continue;
            }
            int productIndex = Integer.parseInt(inputParts[1]) - 1;
            int volume = Integer.parseInt(inputParts[2]);
            if (Integer.parseInt(inputParts[0]) == 1) {
                sum = sum + CashRegister.sellGoods(bottlingShowcase.get(productIndex), products, volume, oneContainerPrice);
            } else if (Integer.parseInt(inputParts[0]) == 2) {
                sum = sum + CashRegister.sellGoods(piecesShowcase.get(productIndex), products, volume);
            } else {
                System.out.println("Некорректный выбор номера витрины");
            }
        }

    }

}