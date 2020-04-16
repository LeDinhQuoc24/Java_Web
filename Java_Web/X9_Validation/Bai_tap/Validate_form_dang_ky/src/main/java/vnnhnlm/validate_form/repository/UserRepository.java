package vnnhnlm.validate_form.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
        import vnnhnlm.validate_form.model.User;

public interface UserRepository extends PagingAndSorting<User,String>{
}
