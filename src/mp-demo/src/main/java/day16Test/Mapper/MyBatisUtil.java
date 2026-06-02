package day16Test.Mapper;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);

            MybatisConfiguration cfg = (MybatisConfiguration) sqlSessionFactory.getConfiguration();
            // 关键：关闭构造器自动映射，只靠字段名匹配，__row_number__自动忽略
            cfg.setArgNameBasedConstructorAutoMapping(false);
            cfg.setMapUnderscoreToCamelCase(true);

            MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
            // 2005方言生成ROW_NUMBER(无?占位OFFSET，根除@P0报错)
            PaginationInnerInterceptor page = new PaginationInnerInterceptor(DbType.SQL_SERVER2005);
            page.setOverflow(false);
            interceptor.addInnerInterceptor(page);
            cfg.addInterceptor(interceptor);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        return sqlSessionFactory.openSession(true);
    }
}