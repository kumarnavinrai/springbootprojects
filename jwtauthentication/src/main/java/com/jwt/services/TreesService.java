package com.jwt.services;


import com.jwt.model.Trees;
import com.jwt.repo.TreesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TreesService {

    @Autowired
    private TreesRepository repository;

//    @PostConstruct
//    public void initDB() {
//        List<Trees> trees = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Trees("tree" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//                .collect(Collectors.toList());
//        repository.saveAll(trees);
//    }


    public List<Trees> findAlltrees() {
        return repository.findAll();
    }


    public List<Trees> findtreesWithSorting(String field){
        return  repository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Page<Trees> findtreesWithPagination(int offset,int pageSize){
        Page<Trees> trees = repository.findAll(PageRequest.of(offset, pageSize));
        return  trees;
    }

//    public Page<Trees> findtreesWithPaginationAndSorting(int offset,int pageSize,String field){
//        Page<Trees> trees = repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//        return  trees;
//    }

    public Page<Trees> findtreesWithPaginationAndSorting(int page, int size, String sortField) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortField));
        //Sort sort = Sort.by(sortField1).and(Sort.by(sortField2));
        return repository.findAll(pageable);
    }

}
