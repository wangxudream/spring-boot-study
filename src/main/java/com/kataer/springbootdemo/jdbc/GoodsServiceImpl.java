//package com.kataer.springbootdemo.jdbc;
//
//import com.kataer.springbootdemo.entity.Goods;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
////Spring Boot 默认缓存是基于 ConcurrentMapCacheManager 缓存管理器实现的
//@CacheConfig(cacheNames = "goodsCache")
//public class GoodsServiceImpl implements GoodsService {
//
//    @Autowired
//    private GoodsDao goodsDao;
//
//    @Cacheable
//    public List<Goods> getGoodsList() {
//        return goodsDao.getGoodsList();
//    }
//
//    /**
//     * 按id获取商品信息，模拟返回对应商品信息
//     */
//    @Cacheable
//    public Goods getGoodsById(Long id) {
//        return goodsDao.getById(id);
//    }
//
//    /**
//     * 新增商品，模拟返回数据库影响行数
//     */
//    @CachePut(key = "#goods.id")
//    public int addGoods(Goods goods) {
//        return goodsDao.insert(goods);
//    }
//
//    /**
//     * 根据商品id更新商品信息，模拟返回数据库影响行数
//     */
//    @CachePut(key = "#goods.id")
//    public Goods editGoods(Goods goods) {
//        if (goodsDao.update(goods) == 1) {
//            return goods;
//        } else {
//            return goodsDao.getById(goods.getId());
//        }
//    }
//
//    /**
//     * 根据商品id删除对应商品，模拟返回数据库影响行数
//     */
//    @CacheEvict(key = "#id")
//    public int removeGoods(Long id) {
//        return goodsDao.delete(id);
//    }
//
//
////    @CacheConfig 注解用于指定本类中方法使用的缓存名称，该类使用的缓存名称为 GoodsCache ，与其他缓存区域是隔离的。
////    @Cacheable 用于开启方法缓存，缓存的键是方法的参数，缓存的值是方法的返回值。如果多次调用该方法时参数 id 值相同，则第一次会执行方法体，并将返回值放入缓存；后续方法不会再执行方法体，直接将缓存的值返回。
////    @CachePut 可以更新缓存，key = "#id" 表示采用参数中的 id 属性作为键。当缓存中该键的值不存在时，则将返回值放入缓存；当缓存中该键的值已存在时，会更新缓存的内容。
////    @CacheEvict 可以移除缓存，当调用该方法时，会移除 goods 中 id 属性对应的缓存内容。
//}
