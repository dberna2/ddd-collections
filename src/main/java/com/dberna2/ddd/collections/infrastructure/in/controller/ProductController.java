package com.dberna2.ddd.collections.infrastructure.in.controller;

import com.dberna2.ddd.collections.application.bestselling.MostExpensiveProductCategoriesFinder;
import com.dberna2.ddd.collections.application.topproducts.TopProductsFinder;
import com.dberna2.ddd.collections.domain.Product;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public final class ProductController {

  private final MostExpensiveProductCategoriesFinder mostExpensiveProductCategoriesFinder;

  private final TopProductsFinder                  topProductsFinder;

  @GetMapping("/categories/most-expensive")
  public ResponseEntity<Map<String, List<Product>>> getMostExpensiveProductCategories() {
    final Map<String, List<Product>> result = this.mostExpensiveProductCategoriesFinder.execute();
    return ResponseEntity.ok(result);
  }

  @GetMapping("/categories/top-products")
  public ResponseEntity<List<Product>> getTopProductsByCategory(
      @RequestParam(value = "limit", defaultValue = "5") final int limit) {
    final List<Product> result = this.topProductsFinder.execute(limit);
    return ResponseEntity.ok(result);
  }
}
