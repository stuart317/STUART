package com.zc;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：MyBatis-Plus 的代码生成器
 * 执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 * 创建时间：2019/1/14 19:41
 *
 * @author 朱超
 */
public class CodeGenerator {

    //表对应的基类名
    /*private static final String entityName = "User";*/

    //生成在该目录下
    private static final String package_name = "com.zc";

    //表名
    private static String[] table_names = new String[] {"user"};

    /**
     * @param args
     * @Title: main
     * @Description: 生成
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取 当前项目路径
        String projectPath = curMoudlePath(CodeGenerator.class);
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("ber");
        gc.setFileOverride(true);// 文件覆盖
        gc.setBaseResultMap(true);//生成基本的resultMap
        gc.setBaseColumnList(true);//生成基本的SQL片段
        gc.setOpen(false);

        gc.setEntityName("%s");//实体类名
        /*gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");*/
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&serverTimezone=GMT%2B8&useSSL=false&characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent(package_name);
        /*pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");*/
        pc.setMapper("dao");
        pc.setEntity("bean");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" /*+ pc.getModuleName()*/
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //定义模板
        TemplateConfig tempf = new TemplateConfig();
        tempf.setController(null);//不生成controller
        tempf.setService(null);//不生成 service
        tempf.setServiceImpl(null);//不生成 serviceImpl
        tempf.setXml(null);//不生成 mapper.xml 使用 上面自定义方法
        mpg.setTemplate(tempf);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(table_names);

/*        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);*/

//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//        strategy.setEntityLombokModel(false);
//        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//        strategy.setSuperEntityColumns("id");
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }

    /**
     * 获取 当前项目模块路径
     * @param t
     * @return
     */
    public static String curMoudlePath(Class t){
        //当前类绝对路径
        String path = t.getResource("/").getPath();
        if(path.indexOf("target/")>-1){
            path = path.substring(0, path.indexOf("target/"));
        }
        return path;
    }
}
