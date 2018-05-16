package com.xinyonghang.supplychain.utils;

import freemarker.template.TemplateExceptionHandler;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.xinyonghang.supplychain.core.ProjectConstant.*;

/**
 * 根据数据表名称生成对应的Model、Mapper、Service、Controller。
 *
 * @author chengjiawei
 * 2018年3月30日下午2:54:41
 */
public class CodeGeneratorUtil {

    //JDBC配置
    private static final String JDBC_URL = "jdbc:sqlserver://192.168.3.222:1433";
    private static final String JDBC_USERNAME = "testERP";
    private static final String JDBC_PASSWORD = "testERP";
    private static final String JDBC_DIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static final String PROJECT_PATH = System.getProperty("user.dir");//项目在硬盘上的基础路径
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/supplychain-utils/src/main/resources/generator/template";//模板位置
    private static final String MODEL_PATH = System.getProperty("user.dir") + "/supplychain-model";//model项目模块
    private static final String SERVICE_PATH = System.getProperty("user.dir") + "/supplychain-service";//service项目模块
    private static final String WEB_PATH = System.getProperty("user.dir") + "/supplychain-web";//web项目模块

    private static final String JAVA_PATH = "/src/main/java"; //java文件路径
    private static final String RESOURCES_PATH = "/src/main/resources";//资源文件路径

    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE);//生成的Service存放路径
    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE);//生成的Service实现存放路径
    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE);//生成的Controller存放路径
    private static final String PACKAGE_PATH_DTO = packageConvertPath(DTO_PACKAGE);//生成的Service存放路径

    private static final String AUTHOR = "CodeGeneratorTool";//@author
    private static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());//@date

    public static void main(String[] args) {
        // 需要生成的表名
        genCode("MK_WAREHOUSE");
    }

    public static void genCode(String... tableNames) {
        for (String tableName : tableNames) {
            //根据需求生成，不需要的注掉，模板有问题的话可以自己修改。
            genModelAndMapper(tableName);
            genDto(tableName);
            genService(tableName);
            genController(tableName);
        }
    }


    private static String createXmlString(String tableName) {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://192.168.3.222:1433;DatabaseName=ERP";
        String userName = "testERP";
        String userPwd = "testERP";
        try {
            Class.forName(driverName);
            System.out.println("加载驱动成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        StringBuffer sb = null;
        try {
            Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("Connection Successful! "); //如果连接成功 控制台输出Connection Successful!
            String sql = "sp_columns " + tableName;
            Statement stmt = dbConn.createStatement();
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            List<String> list = new ArrayList<String>();
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                list.add(columnName);
            }


            sb = new StringBuffer();
            sb.append("<sql id=\"BASE_COLUMN_LIST\">");
            sb.append("\r\n");
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    sb.append(list.get(i));
                } else {
                    sb.append(list.get(i)).append(", ");
                }
            }
            sb.append("\r\n");
            sb.append("</sql>");
            sb.append("\r\n");
            sb.append("<sql id=\"query\">");
            sb.append("\r\n");
            sb.append("<where>");
            sb.append("\r\n");
            sb.append("<if test=\"id != null and id != '' \">");
            sb.append("\r\n");
            sb.append(" AND ID = #{id}");
            sb.append("  </if>");
            sb.append("\r\n");
            sb.append(" </where>");
            sb.append("\r\n");
            sb.append(" </sql >");
            sb.append("\r\n");
            sb.append("<select id=\"findList\" parameterType=\"map\" resultMap=\"BaseResultMap\">");
            sb.append("\r\n");
            sb.append("SELECT <include refid=\"BASE_COLUMN_LIST\" />");
            sb.append("\r\n");
            sb.append(" FROM " + tableName);
            sb.append("\r\n");
            sb.append("  <include refid=\"query\" />");
            sb.append("\r\n");
            sb.append("</select>");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    /**
     * 生成model和Mapper
     *
     * @param tableName
     * @author chengjiawei
     */
    public static void genModelAndMapper(String tableName) {
        Context context = new Context(ModelType.FLAT);
        context.setId("XYHerp");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
        jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
        jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
        jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.addProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        context.addPluginConfiguration(pluginConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(MODEL_PATH + JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(MODEL_PATH + RESOURCES_PATH);
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(MODEL_PATH + JAVA_PATH);
        javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "SqlServer", true, null));
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings;
        MyBatisGenerator generator;
        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            boolean overwrite = true;
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            warnings = new ArrayList<String>();


            generator = new MyBatisGenerator(config, callback, warnings, createXmlString(tableName), tableNameConvertUpperCamel(tableName));
            generator.generate(null);


        } catch (Exception e) {
            throw new RuntimeException("生成Model和Mapper失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("生成Model和Mapper失败：" + warnings);
        }

        String modelName = tableNameConvertUpperCamel(tableName);
        System.out.println(modelName + ".java 生成成功");
        System.out.println(modelName + "Mapper.java 生成成功");
        System.out.println(modelName + "Mapper.xml 生成成功");
    }

    /**
     * 生成service
     *
     * @param tableName
     * @author chengjiawei
     */
    public static void genService(String tableName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = tableNameConvertUpperCamel(tableName);
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));

            data.put("modelNameModel", tableNameConvertLowerCamel(tableName));

            data.put("basePackage", BASE_PACKAGE);

            File file = new File(SERVICE_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data,
                    new FileWriter(file));
            System.out.println(modelNameUpperCamel + "Service.java 生成成功");

            File file1 = new File(SERVICE_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel + "ServiceImpl.java");
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            cfg.getTemplate("service-impl.ftl").process(data,
                    new FileWriter(file1));
            System.out.println(modelNameUpperCamel + "ServiceImpl.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }


    /**
     * 生成controller（可选post和restful两个模板）
     *
     * @param tableName
     * @author chengjiawei
     */
    public static void genDto(String tableName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            data.put("baseRequestMapping", tableNameConvertMappingPath(tableName));
            String modelNameUpperCamel = tableNameConvertUpperCamel(tableName);
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", BASE_PACKAGE);

            File file = new File(MODEL_PATH + JAVA_PATH + PACKAGE_PATH_DTO + modelNameUpperCamel + "Dto.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));
            cfg.getTemplate("dto.ftl").process(data, new FileWriter(file));

            System.out.println(modelNameUpperCamel + "Dto.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Dto失败", e);
        }

    }

    /**
     * 生成controller（可选post和restful两个模板）
     *
     * @param tableName
     * @author chengjiawei
     */
    public static void genController(String tableName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            data.put("baseRequestMapping", tableNameConvertMappingPath(tableName));
            String modelNameUpperCamel = tableNameConvertUpperCamel(tableName);
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", BASE_PACKAGE);

            File file = new File(WEB_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));

            System.out.println(modelNameUpperCamel + "Controller.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }

    }

    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    private static String tableNameConvertLowerCamel(String tableName) {
        StringBuilder result = new StringBuilder();
        if (tableName != null && tableName.length() > 0) {
            tableName = tableName.toLowerCase();//兼容使用大写的表名
            boolean flag = false;
            for (int i = 0; i < tableName.length(); i++) {
                char ch = tableName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }

    private static String tableNameConvertUpperCamel(String tableName) {
        String camel = tableNameConvertLowerCamel(tableName);
        return camel.substring(0, 1).toUpperCase() + camel.substring(1);

    }

    private static String tableNameConvertMappingPath(String tableName) {
        tableName = tableName.toLowerCase();//兼容使用大写的表名
        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }
}
