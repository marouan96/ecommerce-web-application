package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asta.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
