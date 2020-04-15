package vnnhnlm.open_blog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vnnhnlm.open_blog.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
