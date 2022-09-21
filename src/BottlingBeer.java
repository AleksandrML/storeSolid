
// пиво в розлив
public class BottlingBeer implements GoodsInBottling, DegreeCorrector {
    protected String name;
    protected float degrees;
    protected int basePricePerMl;
    protected boolean isForeign;

    BottlingBeer(String name, float degrees, int basePricePerMl, boolean isForeign) {
        this.name = name;
        this.degrees = degrees;
        this.basePricePerMl = basePricePerMl;
        this.isForeign = isForeign;
    }

    @Override
    public int calculatePrice(int volumeInMl, int containerPrice) {
        int taxesIncreaseForForeignBeer = isForeign ? 2 : 1;
        return (volumeInMl * basePricePerMl + containerPrice) * taxesIncreaseForForeignBeer;
    }

    @Override
    public String getDescription() {
        String foreignDescriptor = isForeign ? ", иностранное" : "";
        return name + ", цена за мл: " + basePricePerMl + ", оборотов: " + degrees + foreignDescriptor;
    }

    @Override
    public void correctDegree(float degrees) {
        this.degrees = degrees;
    }
}
