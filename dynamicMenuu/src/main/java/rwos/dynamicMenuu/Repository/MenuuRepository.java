package rwos.dynamicMenuu.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rwos.dynamicMenuu.Entity.Menu;

@Repository
public interface MenuuRepository extends JpaRepository<Menu, String>{
	@Query(value = "select * from menu where parent_id IS null" , nativeQuery = true)
	public List<Menu> getData();
	
	@Modifying
    @Transactional
    @Query(
        value = "update menu set parent_id = ?1 where mid = ?2",
        nativeQuery = true
    )
    public int updateMenu(String parentId, String Id);
}
