
// товар, продаваемый поштучно
public interface GoodsPieceByPiece extends BaseGoods {
    int calculatePrice(int quantity);
}
