package com.xinyonghang.supplychain.controller;

import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.model.MkProductCategory;
import com.xinyonghang.supplychain.service.MkProductCategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by CodeGeneratorTool on 2018/04/19.
 */
@RestController
@RequestMapping("/mk/product/category")
public class MkProductCategoryController {
    @Resource
    private MkProductCategoryService mkProductCategoryService;

    @RequestMapping("/toCategory")
    public ModelAndView toAttribute() {
        ModelAndView mv = new ModelAndView("sub/product/category");
        return mv;
    }


    @PostMapping("/add")
    public Result add(MkProductCategory mkProductCategory) {
        mkProductCategoryService.save(mkProductCategory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkProductCategoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkProductCategory mkProductCategory) {
        mkProductCategoryService.update(mkProductCategory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkProductCategory mkProductCategory = mkProductCategoryService.findById(id);
        return ResultGenerator.genSuccessResult(mkProductCategory);
    }

    @PostMapping("/list")
    public Result list() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        System.out.println(request.getSession().getId());

        List<Map<String, Object>> list = mkProductCategoryService.findZtreeList();
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/saveList")
    public Result saveList(@RequestParam String ztreeJsonString) {
        mkProductCategoryService.saveZtreeList(ztreeJsonString);

        return ResultGenerator.genSuccessResult();
    }

    /**
     * 按父节点查询类目
     *
     * @param parentId
     * @return
     */
    @PostMapping("/getCategoryList")
    public Result getCategoryList(@RequestParam Long parentId) {
        List<MkProductCategory> list = mkProductCategoryService.getCategoryByParentId(parentId);
        return ResultGenerator.genSuccessResult(list);
    }

}
