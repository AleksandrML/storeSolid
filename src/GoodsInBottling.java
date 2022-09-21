
// продукт, продаваемый в разлив
public interface GoodsInBottling extends BaseGoods {
    int calculatePrice(int volumeInMl, int containerPrice);
}
