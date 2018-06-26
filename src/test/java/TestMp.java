import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class TestMp {
    @Test
    public void generatorTest(){
//        全局配置
//        数据源配置
//        策略配置
//        包名策略配置
//        整合配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(false)
                .setIdType(IdType.AUTO)
                .setAuthor("nanGua")
                .setOutputDir("F:\\workSpace\\Java\\project\\myBatisPlus\\src\\main\\java")
                .setFileOverride(true)
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql:///demo")
                .setUsername("root")
                .setPassword("root");

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setDbColumnUnderline(true)
                .setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude("user", "student"); // 生成表

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.li")
                .setMapper("mapper")
                .setEntity("po")
                .setXml("mapper")
                .setService("service")
                .setController("controller");


        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        autoGenerator.execute();
    }
}
