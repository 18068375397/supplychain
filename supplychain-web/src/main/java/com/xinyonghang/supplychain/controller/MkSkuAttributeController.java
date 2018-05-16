package com.xinyonghang.supplychain.controller;

import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.dto.MkSkuAttributeDto;
import com.xinyonghang.supplychain.model.MkSkuAttribute;
import com.xinyonghang.supplychain.service.MkSkuAttributeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGeneratorTool on 2018/05/03.
 */
@RestController
@RequestMapping("/mk/sku/attribute")
public class MkSkuAttributeController {
    @Resource
    private MkSkuAttributeService mkSkuAttributeService;

    @RequestMapping("/toSkuList")
    public ModelAndView toSkuAttributeList() {
        return new ModelAndView("sub/product/skuList");
    }

    @RequestMapping("/toAddSku")
    public ModelAndView toAddSku() {
        return new ModelAndView("sub/product/addSku");
    }

    @RequestMapping("/toEditSku")
    public ModelAndView toEditSku() {
        return new ModelAndView("sub/product/editSku");
    }

    @PostMapping("/add")
    public Result add(MkSkuAttribute mkSkuAttribute) {
        mkSkuAttributeService.save(mkSkuAttribute);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkSkuAttributeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkSkuAttribute mkSkuAttribute) {
        mkSkuAttributeService.update(mkSkuAttribute);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkSkuAttribute mkSkuAttribute = mkSkuAttributeService.findById(id);
        return ResultGenerator.genSuccessResult(mkSkuAttribute);
    }

    @PostMapping("/list")
    public Result list(MkSkuAttributeDto mkSkuAttributeDto) {
        PageInfo pageInfo = mkSkuAttributeService.findList(mkSkuAttributeDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/getSkuAttrList")
    public Result getAttributeList(@RequestParam Long categoryId) throws Exception {
        List<MkSkuAttribute> list = mkSkuAttributeService.getSkuAttrListByCategoryId(categoryId);
        return ResultGenerator.genSuccessResult(list);
    }

}
