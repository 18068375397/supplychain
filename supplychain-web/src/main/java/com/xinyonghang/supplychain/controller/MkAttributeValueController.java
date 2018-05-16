package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkAttributeValueDto;
import com.xinyonghang.supplychain.model.MkAttributeValue;
import com.xinyonghang.supplychain.service.MkAttributeValueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/18.
 */
@RestController
@RequestMapping("/mk/attribute/value")
public class MkAttributeValueController {
    @Resource
    private MkAttributeValueService mkAttributeValueService;

    @RequestMapping("/toAddAttributeValue")
    public ModelAndView toAddAttributeValue() {
        return new ModelAndView("sub/product/addAttributeValue");
    }

    @RequestMapping("/toAttributeValueList")
    public ModelAndView toAttributeValue() {
        return new ModelAndView("sub/product/attributeValueList");
    }

    @RequestMapping("/toEditAttributeValue")
    public ModelAndView toEditAttributeValue() {
        return new ModelAndView("sub/product/editAttributeValue");
    }


    @PostMapping("/add")
    public Result add(MkAttributeValue mkAttributeValue) {
        mkAttributeValueService.save(mkAttributeValue);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkAttributeValueService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkAttributeValue mkAttributeValue) {
        mkAttributeValueService.update(mkAttributeValue);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkAttributeValue mkAttributeValue = mkAttributeValueService.findById(id);
        return ResultGenerator.genSuccessResult(mkAttributeValue);
    }

    @PostMapping("/list")
    public Result list(MkAttributeValueDto mkAttributeValueDto) {
        PageInfo pageInfo = mkAttributeValueService.findList(mkAttributeValueDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
