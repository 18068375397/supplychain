package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.model.MkProductAttrRelation;
import com.xinyonghang.supplychain.service.MkProductAttrRelationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/04/13.
 */
@RestController
@RequestMapping("/mk/product/attr/relation")
public class MkProductAttrRelationController {
    @Resource
    private MkProductAttrRelationService mkProductAttrRelationService;

    @PostMapping("/add")
    public Result add(MkProductAttrRelation mkProductAttrRelation) {
        mkProductAttrRelationService.save(mkProductAttrRelation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkProductAttrRelationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkProductAttrRelation mkProductAttrRelation) {
        mkProductAttrRelationService.update(mkProductAttrRelation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkProductAttrRelation mkProductAttrRelation = mkProductAttrRelationService.findById(id);
        return ResultGenerator.genSuccessResult(mkProductAttrRelation);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MkProductAttrRelation> list = mkProductAttrRelationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
