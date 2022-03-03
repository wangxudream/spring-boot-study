package com.kataer.springbootdemo;

import com.kataer.springbootdemo.ioc.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@SpringBootTest
class SpringBootDemoApplicationTests {

//    @Autowired
//    private CacheManager cacheManager;
//
//    @Autowired
//    private GoodsService goodsService;
//
//    // 显示当前使用的缓存管理器类型
//    @Test
//    void showCacheManager() {
//        // 输出：org.springframework.cache.concurrent.ConcurrentMapCacheManager
//        log.info("------------------>" + cacheManager.getClass().toString());
//    }
//
//    @Test
//    void testCache() {
//        goodsService.getGoodsList();
//        goodsService.getGoodsList();
//        goodsService.getGoodsById(2L);
//        Goods goods = goodsService.getGoodsById(2L);
//        System.out.println(goods);
//        Goods newGoods = new Goods();
//        newGoods.setId(2L);
//        newGoods.setName("orange");
//        newGoods.setPic("orange.jpg");
//        newGoods.setPrice("5.5");
//        goodsService.editGoods(newGoods);
//        Goods goods2 = goodsService.getGoodsById(2L);
//        System.out.println(goods2);
//        goodsService.removeGoods(2L);
//        Goods goods3 = goodsService.getGoodsById(2L);
//        System.out.println(goods3);
////        Goods(id=2, name=watermelon, price=1.5, pic=watermelon.jpg)
////        Goods(id=2, name=orange, price=5.5, pic=orange.jpg)
////        Goods(id=2, name=watermelon, price=1.5, pic=watermelon.jpg)
//    }

    @Autowired
    private Student student;

    @Test
    public void testIoc() {
        System.out.println("student:" + student);
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedisMemery() {
//        OOM command not allowed when used memory > 'maxmemory'.
        for (int i = 9000; i < 15000; i++) {
            redisTemplate.opsForValue().set(i + "", System.currentTimeMillis()+"");
        }
    }
}
