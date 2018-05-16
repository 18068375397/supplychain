package ${basePackage}.dto;
import ${basePackage}.model.${modelNameUpperCamel};

import javax.validation.constraints.NotNull;
/**
* Created by ${author} on ${date}.
*/
public class ${modelNameUpperCamel}Dto extends  ${modelNameUpperCamel}{
    @NotNull
    private Integer page;
    @NotNull
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
