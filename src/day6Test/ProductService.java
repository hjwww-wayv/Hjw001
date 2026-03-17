package day6Test;

import java.util.ArrayList;
import java.util.List;
public class ProductService {
    List<Products> p=new ArrayList<>();
    public ProductService() {
        p.add(new Products(1,"苹果",10,0));
        p.add(new Products(2,"香蕉",20,0));
        p.add(new Products(3,"橘子",30,0));
        p.add(new Products(4,"西瓜",40,0));
    }
    public List<Products> finbyId(int id) {
        List<Products> result1 = new ArrayList<>();
        if(id<0){
            throw new ProException("产品id不得<0");
        }
        for(Products products : p){
            if(products.getId()==id)
                result1.add(products);
        }
        if(result1.size()==0){
            throw new ProException("产品id不存在");
        }
        return result1;
        }
    public List<Products> findInStockProducts(){
        List<Products> result2 = new ArrayList<>();
        for(Products products : p){
            if(products.getStock()>0)
                result2.add(products);
        }
        if(result2.size()==0){
            throw new ProException("没有库存");
        }
        return result2;
    }}

