package com.jwt.controller;

import com.jwt.config.APIResponse;
import com.jwt.model.Trees;
import com.jwt.services.TreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreesController {

    @Autowired
    private TreesService service;

    @GetMapping
    private APIResponse<List<Trees>> getTrees() {
        List<Trees> alltrees = service.findAlltrees();
        return new APIResponse<>(alltrees.size(), alltrees);
    }

    @GetMapping("/{field}")
    private APIResponse<List<Trees>> getTreesWithSort(@PathVariable String field) {
        List<Trees> alltrees = service.findtreesWithSorting(field);
        return new APIResponse<>(alltrees.size(), alltrees);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Trees>> getTreesWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Trees> treesWithPagination = service.findtreesWithPagination(offset, pageSize);
        long totalRecords = treesWithPagination.getTotalElements();
        return new APIResponse<>((int)totalRecords, treesWithPagination);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Trees>> getTreesWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
        Page<Trees> treesWithPagination = service.findtreesWithPaginationAndSorting(offset, pageSize, field);
        long totalRecords = treesWithPagination.getTotalElements();
        return new APIResponse<>((int)totalRecords, treesWithPagination);
    }

}
