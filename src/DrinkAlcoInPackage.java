
// напиток алкогольный в таре
public class DrinkAlcoInPackage extends DrinkInPackage implements DegreeCorrector {
    protected float degrees;
    protected boolean isForeign;

    DrinkAlcoInPackage(String name, int basePricePerPiece, int packageVolumeMl, float degrees, boolean isForeign) {
        super(name, basePricePerPiece, packageVolumeMl);
        this.degrees = degrees;
        this.isForeign = isForeign;
    }

    @Override
    public int calculatePrice(int quantity) {
        return quantity * basePricePerPiece * (isForeign ? 2 : 1);
    }

    @Override
    public String getDescription() {
        return name + ", мл в шт: " + packageVolumeMl + ", цена за шт: " + basePricePerPiece + ", оборотов: " + degrees + (isForeign ? ", иностранное" : "");
    }

    @Override
    public void correctDegree(float degrees) {
        this.degrees = degrees;
    }
}
