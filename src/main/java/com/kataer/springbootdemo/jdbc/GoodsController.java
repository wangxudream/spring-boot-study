//package com.kataer.springbootdemo.jdbc;
//
//import com.kataer.springbootdemo.entity.Goods;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController //注册restful风格的Controller，自动Json化返回结果
//public class GoodsController {
//    @Autowired
//    private GoodsService goodsService;
//
//    @GetMapping("/goods/{id}")
//    public Goods getGoods(@PathVariable("id") Long id) {
//        return goodsService.getGoodsById(id);
//    }
//
//    @ApiOperation("获取商品列表")
//    @GetMapping("/goods")
//    public List<Goods> getGoodsList() {
//        return goodsService.getGoodsList();
//    }
//
//    /**
//     * post请求处理新增数据
//     *
//     * @param goods
//     */
//    @PostMapping("/goods")
//    public void addGoods(@RequestBody Goods goods) {
//        goodsService.addGoods(goods);
//    }
//
//    /**
//     * put请求处理修改
//     *
//     * @param id
//     * @param goods
//     */
//    @PutMapping("/goods/{id}")
//    public void update(@PathVariable("id") Long id, @RequestBody Goods goods) {
//        goods.setId(id);
//        goodsService.editGoods(goods);
//    }
//
//    /**
//     * delete请求处理删除
//     *
//     * @param id
//     */
//    @DeleteMapping("/goods/{id}")
//    public void delete(@PathVariable("id") Long id) {
//        goodsService.removeGoods(id);
//    }
//}
