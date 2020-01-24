package org.cshaifasweng.winter.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("custom_item")
public class CustomItem extends Item {
    private List<CatalogItem> items;

    private double lowerPriceBound;
    private double upperPriceBound;

    private String dominantColor;

    private CustomItemType type;

    public CustomItem() {
        super();
        items = new ArrayList<>();
    }

    public CustomItem(double lowerPriceBound, double upperPriceBound, CustomItemType type) {
        super();
        items = new ArrayList<>();
        this.lowerPriceBound = lowerPriceBound;
        this.upperPriceBound = upperPriceBound;
        this.type = type;
    }

    public List<CatalogItem> getItems() {
        return items;
    }

    public void setItems(List<CatalogItem> items) {
        this.items = items;
    }

    public double getLowerPriceBound() {
        return lowerPriceBound;
    }

    public void setLowerPriceBound(double lowerPriceBound) {
        this.lowerPriceBound = lowerPriceBound;
    }

    public double getUpperPriceBound() {
        return upperPriceBound;
    }

    public void setUpperPriceBound(double upperPriceBound) {
        this.upperPriceBound = upperPriceBound;
    }

    public String getDominantColor() {
        return dominantColor;
    }

    public void setDominantColor(String dominantColor) {
        this.dominantColor = dominantColor;
    }

    public CustomItemType getType() {
        return type;
    }

    public void setType(CustomItemType type) {
        this.type = type;
    }
}
