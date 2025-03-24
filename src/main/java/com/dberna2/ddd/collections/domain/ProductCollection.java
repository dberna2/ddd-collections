package com.dberna2.ddd.collections.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ProductCollection {

  private final List<Product> products;

  public ProductCollection(final List<Product> products) {
    this.products = products;
  }

  public ProductCollection take(int limit) {
    return new ProductCollection(this.products.stream().limit(limit).toList());
  }

  public ProductCollection filterIfPriceIsGreaterThan(final int value) {
    final List<Product> filteredProducts = this.products.stream()
        .filter(product -> product.price() >= value)
        .toList();

    return new ProductCollection(filteredProducts);
  }

  public ProductCollection sortByPrice() {
    final List<Product> sortedProducts = this.products.stream()
        .sorted(Comparator.comparing(Product::price)).toList();

    return new ProductCollection(sortedProducts) ;
  }

  public Map<String, List<Product>> groupByCategory() {
    return this.products.stream()
        .collect(Collectors.groupingBy(Product::category));
  }

  public List<Product> collect() {
    return new ArrayList<>(this.products);
  }
}
