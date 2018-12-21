package com.zhuguang.Item.controller;

import com.zhuguang.Item.service.CategoryService;
import com.zhuguang.data.ResponseData;
import com.zhuguang.item.pojo.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据parentId查询类目
     * @param pid
     * @return
     */
    @RequestMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByParentId(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
        if (pid == null || pid.longValue() < 0){
            return ResponseEntity.badRequest().build();
        }
        List<Category> categoryList = this.categoryService.queryCategoryListByParentId(pid);
        return ResponseEntity.ok(categoryList);
       // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
