package repos.omeneses.serviceproduct;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import repos.omeneses.serviceproduct.entity.Category;
import repos.omeneses.serviceproduct.entity.Product;
import repos.omeneses.serviceproduct.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryMockTest {
    
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFingCategory_thenReturnLisProduct(){
        Product product = Product.builder()
        .name("NIKE")
        .category(Category.builder().id(1L).build())
        .description("")
        .stock(10.0d)
        .price(219.000d)
        .status("CREATED")
        .createdAt(new Date())
        .build();

        productRepository.save(product);

        List<Product> products = productRepository.findByCategory(product.getCategory());

        Assertions.assertThat(products.size()).isEqualTo(3);
    }
}
