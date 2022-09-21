public class ProductChecker {

    // здесь реализуется принцип Liskov substitution principle - можно отправлять как DrinkInPackage, так и наследника - DrinkAlcoInPackage
    public int checkVolumeInPiece(DrinkInPackage packagedDrink) {
        return packagedDrink.packageVolumeMl;
    }

}
