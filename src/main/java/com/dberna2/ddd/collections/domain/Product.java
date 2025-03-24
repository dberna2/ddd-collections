package com.dberna2.ddd.collections.domain;

public final class Product {

  private final String id;
  private final String name;
  private final ProductCategory category;
  private final int price;

  private Product(final String id,
      final String name,
      final ProductCategory category,
      final int price) {
    this.id = id;
    this.name = name;

    this.category = category;
    this.price = price;
  }

  public static Product create(String id, String name, String category, int price) {
    return new Product(id, name, ProductCategory.valueOf(category), price);
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }

  public String category() {
    return category.name();
  }

  public int price() {
    return price;
  }
}
