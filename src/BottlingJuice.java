
// сок в розлив
public class BottlingJuice implements GoodsInBottling {
    protected String name;
    protected int basePricePerMl;

    BottlingJuice(String name, int basePricePerMl) {
        this.name = name;
        this.basePricePerMl = basePricePerMl;
    }

    @Override
    public int calculatePrice(int volumeInMl, int containerPrice) {
        return volumeInMl * basePricePerMl + containerPrice;
    }

    @Override
    public String getDescription() {
        return name + ", цена за мл: " + basePricePerMl;
    }
}
