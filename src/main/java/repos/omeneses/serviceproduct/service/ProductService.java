package repos.omeneses.serviceproduct.service;

import java.util.List;

import repos.omeneses.serviceproduct.entity.Category;
import repos.omeneses.serviceproduct.entity.Product;

public interface ProductService {
    
    public Product create(Product product);
    public Product update(Product product);
    public Product updateStock(Long id, Double quantity);
    public Product delete(Long id);
    public Product get(Long id);
    public List<Product> listAll();
    public List<Product> findByCategory(Category category);

}
