package com.atguigu.pojo;

/**
 * ClassName: Cart
 * Package: com.atguigu.pojo
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/16 - 22:09
 * Version: v1.0
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart {


    /**
     * key 编号 value 商品信息
     */
    private Map<Integer,CartItem> items=new LinkedHashMap<>();
    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        //查看是否已经添加国商品，有，数量累加，总金额更新， 五 添加
        CartItem item = items.get(cartItem.getId());
        if(item==null){
            //没有添加
            items.put(cartItem.getId(),cartItem);
        }else{
            //添加过
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear( ){
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id,Integer count ){
        //购物车是否有此物品
        CartItem cartItem = items.get(id);
        if(cartItem!=null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }


    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        Integer totalCount=0;
        for(Map.Entry<Integer,CartItem> entry:items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice=new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry:items.entrySet()){
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
