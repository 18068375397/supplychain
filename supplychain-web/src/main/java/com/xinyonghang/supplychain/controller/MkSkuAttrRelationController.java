package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkSkuAttrRelationDto;
import com.xinyonghang.supplychain.model.MkSkuAttrRelation;
import com.xinyonghang.supplychain.service.MkSkuAttrRelationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/05/03.
 */
@RestController
@RequestMapping("/mk/sku/attr/relation")
public class MkSkuAttrRelationController {
    @Resource
    private MkSkuAttrRelationService mkSkuAttrRelationService;

    @PostMapping("/add")
    public Result add(MkSkuAttrRelation mkSkuAttrRelation) {
        mkSkuAttrRelationService.save(mkSkuAttrRelation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkSkuAttrRelationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkSkuAttrRelation mkSkuAttrRelation) {
        mkSkuAttrRelationService.update(mkSkuAttrRelation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkSkuAttrRelation mkSkuAttrRelation = mkSkuAttrRelationService.findById(id);
        return ResultGenerator.genSuccessResult(mkSkuAttrRelation);
    }

    @PostMapping("/list")
    public Result list(MkSkuAttrRelationDto mkSkuAttrRelationDto) {
        PageInfo pageInfo = mkSkuAttrRelationService.findList(mkSkuAttrRelationDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
