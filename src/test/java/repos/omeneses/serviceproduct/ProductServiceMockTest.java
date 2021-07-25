package repos.omeneses.serviceproduct;

import java.util.Date;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import repos.omeneses.serviceproduct.entity.Category;
import repos.omeneses.serviceproduct.entity.Product;
import repos.omeneses.serviceproduct.repository.ProductRepository;
import repos.omeneses.serviceproduct.service.ProductService;
import repos.omeneses.serviceproduct.service.ProductServiceImplement;

@SpringBootTest
public class ProductServiceMockTest {
    
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.productService = new ProductServiceImplement(this.productRepository); 

        Product product = Product.builder()
        .name("SHOES NIKE")
        .category(Category.builder().id(1L).build())
        .description("")
        .stock(10.0d)
        .price(219.000d)
        .status("CREATED")
        .createdAt(new Date())
        .build();
 
        Mockito.when(productRepository.findById(1l)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(product)).thenReturn(product);
    }

    @Test
    public void whenValidGetId_thenReturnProduct(){
        Product productFound = this.productService.get(1L);
        Assertions.assertThat(productFound.getName()).isEqualTo("SHOES NIKE");
    }

    @Test
    public void whenValidUpdateStock_thenReturnNewStock(){
        Product newStock = this.productService.updateStock(1L, 10d);

        Assertions.assertThat(newStock.getStock()).isEqualTo(20d);
    }

}
