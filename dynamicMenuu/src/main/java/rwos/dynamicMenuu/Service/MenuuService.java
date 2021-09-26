package rwos.dynamicMenuu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rwos.dynamicMenuu.Entity.Menu;
import rwos.dynamicMenuu.Repository.MenuuRepository;

public interface MenuuService {
//	@Autowired
//	private MenuuRepository menuRepository;
	
	List<Menu> getAllMenus();
	
	Menu getMenuById(String Id);
	
	Menu insertMenu(Menu menu);

	Menu insertChildMenu(String Id, Menu menu);
	
	Menu updateMenu(String Id, Menu menu);
	
	void deleteMenu(String Id);
}
