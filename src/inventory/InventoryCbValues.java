package inventory;

/**
 * Created by Ketter Collins on 13/07/2018.
 */
public class InventoryCbValues {

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    public InventoryCbValues(String product) {

        this.product = product;
    }

    private String product;

}
