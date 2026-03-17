package day6;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductsService {
    List<Products> p = new ArrayList<>();

    public ProductsService() {
        p.add(new Products("a", 100, 100));
        p.add(new Products("ab", 200, 200));
        p.add(new Products("c", 300, 300));
    }

    //筛选大于等于最低价值的商品
    public List<Products> filterByMinPrice(Double minPrice) {
        if (minPrice == null) {
            throw new ProException("最低价值不能为空");
        }
        if (minPrice < 0) {
            throw new ProException("最低价值不能小于0");
        }
        List<Products> result = new ArrayList<>();
        for (Products product : p) {
            if (product.getPrice() >= minPrice)
                result.add(product);
        }
        if (result.size() == 0) {
            throw new ProException("没有找到符合条件的商品");
        }
        return result;
    }
    //按库存筛选
    public List<Products> filterByStock(int Stock) {
        List<Products> result2 = new ArrayList<>();
        if(Stock < 0) {
            throw new ProException("库存不能小于0");
        }
        for(Products product : p){
            if(product.getStock() == Stock)
            {
                result2.add(product);
            }
        }
        if(result2.size() == 0) {
            throw new ProException("没有找到符合条件的商品");
        }
        return result2;
    }
    //按名字模糊查找
    public List<Products> filterByName(String name) {
        List<Products> result3 = new ArrayList<>();
        if(name == null || name.equals("")) {
            throw new ProException("商品名称不能为空");
        }
        for(Products product : p){
            if(product.getName().contains(name))
            {
                result3.add(product);
            }
        }
        if(result3.size() == 0) {
            throw new ProException("没有找到符合条件的商品");
        }
        return result3;
}}


