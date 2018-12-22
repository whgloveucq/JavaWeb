package com.whg.httpsession;

public class ShoppingItem {
    private Product product;
    private int quality;

    public ShoppingItem(Product product, int quality) {
        this.product = product;
        this.quality = quality;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
