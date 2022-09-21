
// напиток в таре
public class DrinkInPackage implements GoodsPieceByPiece {
    protected String name;
    protected int basePricePerPiece;
    protected int packageVolumeMl;

    DrinkInPackage(String name, int basePricePerPiece, int packageVolumeMl) {
        this.name = name;
        this.basePricePerPiece = basePricePerPiece;
        this.packageVolumeMl = packageVolumeMl;
    }

    @Override
    public int calculatePrice(int quantity) {
        return quantity * basePricePerPiece;
    }

    @Override
    public String getDescription() {
        return name + ", мл в шт: " + packageVolumeMl + ", цена за шт: " + basePricePerPiece;
    }
}
