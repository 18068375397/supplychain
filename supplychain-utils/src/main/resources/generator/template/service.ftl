package ${basePackage}.service;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.dto.${modelNameUpperCamel}Dto;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Service {
    void save(${modelNameUpperCamel} ${modelNameModel});

    void save(List<${modelNameUpperCamel}> list);

    void deleteById(Long id);

    void deleteByIds(String ids);

    void update(${modelNameUpperCamel} ${modelNameModel});

${modelNameUpperCamel} findById(Long id);

    List<${modelNameUpperCamel}> findByIds(String ids);

    List<${modelNameUpperCamel}> findAll();//获取所有

    PageInfo findList(${modelNameUpperCamel}Dto ${modelNameModel}Dto);
}
