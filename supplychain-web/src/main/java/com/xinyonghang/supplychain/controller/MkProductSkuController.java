package com.xinyonghang.supplychain.controller;

import com.google.gson.JsonObject;
import com.xinyonghang.supplychain.model.MkProductSku;
import com.xinyonghang.supplychain.dto.MkProductSkuDto;
import com.xinyonghang.supplychain.service.MkProductSkuService;
import com.github.pagehelper.PageInfo;
import com.xinyonghang.supplychain.utils.GsonUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Map;

/**
 * Created by CodeGeneratorTool on 2018/04/27.
 */
@RestController
@RequestMapping("/mk/product/sku")
public class MkProductSkuController {
    @Resource
    private MkProductSkuService mkProductSkuService;

    @PostMapping("/add")
    public Result add(MkProductSku mkProductSku) {
        mkProductSkuService.save(mkProductSku);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkProductSkuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkProductSku mkProductSku) {
        mkProductSkuService.update(mkProductSku);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkProductSku mkProductSku = mkProductSkuService.findById(id);
        return ResultGenerator.genSuccessResult(mkProductSku);
    }

    @PostMapping("/list")
    public Result list(MkProductSkuDto mkProductSkuDto) {
        PageInfo pageInfo = mkProductSkuService.findList(mkProductSkuDto);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 按品牌,类目 查询商品SKU列表(采购挑选)
     *
     * @return
     */
    @PostMapping("/getProductSkuList")
    public Result getProductList() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        List<Map<String, Object>> list = mkProductSkuService.getProductSkuList(GsonUtil.GsonToMaps(request.getAttribute("jsonString").toString()));
        return ResultGenerator.genSuccessResult(list);
    }
}
