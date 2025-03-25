package com.dberna2.ddd.collections.application.topproducts;

import com.dberna2.ddd.collections.domain.FindProductRepository;
import com.dberna2.ddd.collections.domain.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class TopProductsFinder {

  private final FindProductRepository findProductRepository;

  public List<Product> execute(final int limit) {

    return this.findProductRepository.findAll()
        .sortByPrice()
        .take(limit)
        .toList();
  }
}
