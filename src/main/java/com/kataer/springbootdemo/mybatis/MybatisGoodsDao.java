package com.kataer.springbootdemo.mybatis;

import com.kataer.springbootdemo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 测试mybatis的使用和
 */
@Repository //标注为数据访问类
public class MybatisGoodsDao {
    //pom文件中引入依赖后,Spring Boot 项目已经为我们自动配置了 JdbcTemplate 组件
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Goods> getGoodsList() {
        return jdbcTemplate.query("select * from goods", (resultSet, i) -> {
            Goods goods = new Goods();
            goods.setId(resultSet.getLong("id"));
            goods.setName(resultSet.getString("name"));
            goods.setPrice(resultSet.getString("price"));
            goods.setPic(resultSet.getString("pic"));
            return goods;
        });
    }


    /**
     * 按id查询
     */
    public Goods getById(Long id) {
        return jdbcTemplate.queryForObject("select * from goods where id=?", new RowMapper<Goods>() {
            @Override
            public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
                Goods goods = new Goods();
                goods.setId(rs.getLong("id"));
                goods.setName(rs.getString("name"));
                goods.setPrice(rs.getString("price"));
                goods.setPic(rs.getString("pic"));
                return goods;
            }
        }, id);
    }


    /**
     * 新增
     */
    public int insert(Goods goods) {
        return jdbcTemplate.update("insert into goods(name,price,pic)values(?,?,?)", goods.getName(), goods.getPrice(),
                goods.getPic());
    }

    /**
     * 删除
     */
    public int delete(Long id) {
        return jdbcTemplate.update("delete from goods where id =?", id);
    }

    /**
     * 更新
     */
    public int update(Goods goods) {
        return jdbcTemplate.update("update goods set name=?,price=?,pic=? where id=?", goods.getName(), goods.getPrice(),
                goods.getPic(), goods.getId());
    }
}
