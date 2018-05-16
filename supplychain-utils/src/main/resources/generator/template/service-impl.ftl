package ${basePackage}.service.impl;

import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.dto.${modelNameUpperCamel}Dto;
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by ${author} on ${date}.
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl implements ${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    public void save(${modelNameUpperCamel} ${modelNameModel}) {
${modelNameLowerCamel}Mapper.insertSelective(${modelNameModel});
    }

    public void save(List<${modelNameUpperCamel}> list) {
${modelNameLowerCamel}Mapper.insertList(list);
    }

    public void deleteById(Long id) {
${modelNameLowerCamel}Mapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
${modelNameLowerCamel}Mapper.deleteByIds(ids);
    }

    public void update(${modelNameUpperCamel} ${modelNameModel}) {
${modelNameLowerCamel}Mapper.updateByPrimaryKeySelective(${modelNameModel});
    }

    public ${modelNameUpperCamel} findById(Long id) {
         return ${modelNameLowerCamel}Mapper.selectByPrimaryKey(id);
    }

    public List<${modelNameUpperCamel}> findByIds(String ids) {
         return ${modelNameLowerCamel}Mapper.selectByIds(ids);
    }

     public List<${modelNameUpperCamel}> findAll() {
        return ${modelNameLowerCamel}Mapper.selectAll();
     }

     public PageInfo findList(${modelNameUpperCamel}Dto ${modelNameModel}Dto) {
        PageHelper.startPage(${modelNameModel}Dto.getPage(), ${modelNameModel}Dto.getSize());
        List<${modelNameUpperCamel}> list=${modelNameLowerCamel}Mapper.findList(${modelNameModel}Dto);
        return new PageInfo(list);
     }


}
