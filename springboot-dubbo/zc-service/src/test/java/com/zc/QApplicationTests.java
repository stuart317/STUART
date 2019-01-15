package com.zc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.bean.User;
import com.zc.dao.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


/*    wapper介绍 ：

        Wrapper ： 条件构造抽象类，最顶端父类，抽象类中提供4个方法西面贴源码展示
        AbstractWrapper ： 用于查询条件封装，生成 sql 的 where 条件
        AbstractLambdaWrapper ： Lambda 语法使用 Wrapper统一处理解析 lambda 获取 column。
        LambdaQueryWrapper ：看名称也能明白就是用于Lambda语法使用的查询Wrapper
        LambdaUpdateWrapper ： Lambda 更新封装Wrapper
        QueryWrapper ： Entity 对象封装操作类，不是用lambda语法
        UpdateWrapper ： Update 条件封装，用于Entity对象更新操作*/

@RunWith(SpringRunner.class)
@SpringBootTest()
@MapperScan("com.zc.dao*")
public class QApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void aInsert() {
        User user = new User();
        user.setUsername("小羊");
        user.setPassword("123");
        user.setEmail("abc@mp.com");
        user.setPhone("12200000000");

        Assert.assertTrue(userMapper.insert(user) > 0);
        // 成功直接拿会写的 ID
        System.err.println("\n插入成功 ID 为：" + user.getId());
    }


    @Test
    public void bDelete() {
        //Assert.assertTrue(userMapper.deleteById(23L) > 0);
        //条件删除
        Assert.assertTrue(userMapper.delete(new QueryWrapper<User>()
                .lambda().eq(User::getUsername, "niuniu")) > 0);
    }


    /**
     * 更新操作
     */
    @Test
    public void cUpdate() {
        User user1 = new User();
        user1.setId(7L);
        user1.setEmail("ab@c.cccc");

        Assert.assertTrue(userMapper.updateById(user1) > 0);

        User user2 = new User();
        user2.setUsername("mmp");

        Assert.assertTrue(userMapper.update(user2, //需要更新
                new UpdateWrapper<User>().lambda()    //更新条件
                        .set(User::getPhone, "13488888888")
                        .eq(User::getId, 7L)) > 0);
    }


    /**
     * 条件查询
     */
    @Test
    public void dSelect() {
        //Assert.assertEquals("ab@c.cccc", userMapper.selectById(1L).getEmail());
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getId, 7));
        System.out.println("dSelect>>>:"+user.toString());
    }


    /**
     * 排序
     */
    @Test
    public void orderBy() {
        QueryWrapper<User> ew = new QueryWrapper<>();
        ew.orderByAsc("phone");
        List<User> users = userMapper.selectList(ew);
        Assert.assertTrue(!users.isEmpty());

        for (User user: users) {
            System.out.println(user.toString());
        }
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * </p>
     *  queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Test
    public void selectMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("username");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);

        maps.stream().forEach(map ->{ //lamda 遍历
            System.out.println(map);
        });

      /*  for (Map<String, Object> map : maps) {
            System.out.println(map);
        }*/
    }


    /**
     * 分页查询
     */
    @Test
    public void selectUserListPage() {

        System.out.println("----- baseMapper 自带分页 ------");
        Page<User> page = new Page<>(2, 3);

        IPage<User> userIPage = userMapper.selectPage(page, new QueryWrapper<User>()
                //.eq("password", "202cb962ac59075b964b07152d234b70")
                .like("phone", "%33%")
        );
        Assert.assertSame(page, userIPage);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());

        userIPage.getRecords().stream().forEach(user ->{ //lamda 遍历
            System.out.println(user);
        });

        System.out.println("----- baseMapper 自带分页 ------");
    }

}

