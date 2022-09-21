import java.util.List;

// касса
public class CashRegister {

    // использование базового интерфейса здесь реализует open-closed principle (потому что не надо менять
    // эту группу методов, при вводе новых классов с товарами, продаваемыми в розлив, при этом новые классы такие добавить легко).
    public static int sellGoods(GoodsInBottling bottlingGoods, List<String> goodsInBasket, int volumeInMl, int containerPrice) {
        int price = bottlingGoods.calculatePrice(volumeInMl, containerPrice);
        goodsInBasket.add(bottlingGoods.getDescription() + ", всего мл.: " + volumeInMl + ", полная стоимость позиции: " + price);
        return price;
    }

    public static int sellGoods(GoodsPieceByPiece pieceGoods, List<String> goodsInBasket, int quantity) {
        int price = pieceGoods.calculatePrice(quantity);
        goodsInBasket.add(pieceGoods.getDescription() + ", всего шт.: " + quantity + ", полная стоимость позиции: " + price);
        return price;
    }

}
