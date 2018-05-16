package com.xinyonghang.supplychain.controller;

import com.xinyonghang.supplychain.core.Result;
import com.xinyonghang.supplychain.core.ResultGenerator;
import com.xinyonghang.supplychain.model.MkMenu;
import com.xinyonghang.supplychain.service.MkMenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGeneratorTool on 2018/04/26.
 */
@RestController
@RequestMapping("/mk/menu")
public class MkMenuController {
    @Resource
    private MkMenuService mkMenuService;

    @PostMapping("/add")
    public Result add(MkMenu mkMenu) {
        mkMenuService.save(mkMenu);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        mkMenuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MkMenu mkMenu) {
        mkMenuService.update(mkMenu);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MkMenu mkMenu = mkMenuService.findById(id);
        return ResultGenerator.genSuccessResult(mkMenu);
    }

    @PostMapping("/list")
    public Result list() {
        String treeJson = mkMenuService.findTreeList(0l);
        return ResultGenerator.genSuccessResult(treeJson);
    }
}
