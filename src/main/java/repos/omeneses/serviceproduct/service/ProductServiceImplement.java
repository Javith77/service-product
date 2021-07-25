package repos.omeneses.serviceproduct.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import repos.omeneses.serviceproduct.entity.Category;
import repos.omeneses.serviceproduct.entity.Product;
import repos.omeneses.serviceproduct.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        product.setStatus("CREATED");
        product.setCreatedAt(new Date());
        return this.productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product productDB = this.get(product.getId());
        if (null == productDB) {
            return null;
        }
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setPrice(product.getPrice());
        productDB.setStatus("UPDATE");
        return this.productRepository.save(product);
    }

    
    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productDB = this.get(id);
        if (null == productDB) {
            return null;
        }
        Double stock  = productDB.getStock() + quantity;
        productDB.setStock(stock);
        return this.productRepository.save(productDB);
    }

    @Override
    public Product delete(Long id) {
        Product productDB = this.get(id);
        if (null == productDB) {
            return null;
        }
        productDB.setStatus("DELETE");
        return this.productRepository.save(productDB);
    }

    @Override
    public Product get(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> listAll() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return this.productRepository.findByCategory(category);
    }

}
