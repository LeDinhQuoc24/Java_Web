package vnnhnlm.open_blog.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vnnhnlm.open_blog.model.Blog;

public interface BlogService {
    Page<Blog> findAll( Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);



    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
}
