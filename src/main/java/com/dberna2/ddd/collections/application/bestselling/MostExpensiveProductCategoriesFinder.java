package com.dberna2.ddd.collections.application.bestselling;

import com.dberna2.ddd.collections.domain.FindProductRepository;
import com.dberna2.ddd.collections.domain.Product;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class MostExpensiveProductCategoriesFinder {

  private static final int MINIMUM_PRICE = 100;

  private final FindProductRepository findProductRepository;

  public Map<String, List<Product>> execute() {
    return this.findProductRepository.findAll()
        .filterIfPriceIsGreaterThan(MINIMUM_PRICE)
        .sortByPrice()
        .groupByCategory();
  }
}
