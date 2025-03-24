package com.dberna2.ddd.collections.infrastructure.out.memory;

import static com.dberna2.ddd.collections.domain.ProductCategory.BOOKS;
import static com.dberna2.ddd.collections.domain.ProductCategory.ELECTRONICS;
import static com.dberna2.ddd.collections.domain.ProductCategory.GAMES;
import static com.dberna2.ddd.collections.domain.ProductCategory.OTHER;
import com.dberna2.ddd.collections.domain.FindProductRepository;
import com.dberna2.ddd.collections.domain.Product;
import com.dberna2.ddd.collections.domain.ProductCollection;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public final class InMemoryFindProductRepository implements FindProductRepository {

  private final List<Product> products;

  public InMemoryFindProductRepository() {
   this.products = this.createProducts();
  }

  @Override
  public ProductCollection findAll() {
    return new ProductCollection(this.products);
  }

  private List<Product> createProducts() {
    return List.of(
        Product.create(UUID.randomUUID().toString(), "Iphone", ELECTRONICS.name(), 1500),
        Product.create(UUID.randomUUID().toString(), "Macbook Pro", ELECTRONICS.name(), 2500),
        Product.create(UUID.randomUUID().toString(), "Macbook Mini", ELECTRONICS.name(), 900),
        Product.create(UUID.randomUUID().toString(), "DDD", BOOKS.name(), 15),
        Product.create(UUID.randomUUID().toString(), "Old Comic", BOOKS.name(), 150),
        Product.create(UUID.randomUUID().toString(), "Carpet", OTHER.name(), 25),
        Product.create(UUID.randomUUID().toString(), "PS5", GAMES.name(), 1100),
        Product.create(UUID.randomUUID().toString(), "Monopoly", GAMES.name(), 50),
        Product.create(UUID.randomUUID().toString(), "Car", GAMES.name(), 70),
        Product.create(UUID.randomUUID().toString(), "Nintendo", GAMES.name(), 1250),
        Product.create(UUID.randomUUID().toString(), "Candel", OTHER.name(), 2),
        Product.create(UUID.randomUUID().toString(), "TV", ELECTRONICS.name(), 1200),
        Product.create(UUID.randomUUID().toString(), "TDD", BOOKS.name(), 12),
        Product.create(UUID.randomUUID().toString(), "Atomic habits", BOOKS.name(), 13),
        Product.create(UUID.randomUUID().toString(), "Blender", OTHER.name(), 110)
    );
  }
}
