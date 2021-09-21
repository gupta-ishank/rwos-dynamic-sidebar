package rwos.dynamicMenuu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rwos.dynamicMenuu.Entity.Menu;

@Repository
public interface MenuuRepository extends JpaRepository<Menu, String>{
	
}
