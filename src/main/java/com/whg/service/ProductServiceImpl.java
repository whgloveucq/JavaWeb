package com.whg.service;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.whg.model.Product;
/**
 * Created by whg at 19-7-8
 * Included in JavaWeb
 * Go ahead ,do what you say and say what you do .
 **/
@Service
public class ProductServiceImpl implements ProductService  {
private Map<Long,Product> products=new HashMap<Long, Product>();
private AtomicLong generaor=new AtomicLong();
public ProductServiceImpl(){
 Product product=new Product();
 product.setName("Jx1 Powver Drill");
 product.setDescription("Powerful hand drill,made to perfection");
 product.setPrice(129.99F);
 add(product);
}

    @Override
    public Product add(Product product) {
        long newId=generaor.incrementAndGet();
        product.setId(newId);
        products.put(newId,product);
        return  product;
    }

    @Override
    public Product get(long id) {
        return products.get(id);
    }
}
/**/