package vnnhnlm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import vnnhnlm.model.Blog;
import vnnhnlm.repository.BlogRepository;
import vnnhnlm.service.BlogService;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}