package rwos.dynamicMenuu.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import rwos.dynamicMenuu.Entity.Menu;
import rwos.dynamicMenuu.Repository.MenuuRepository;

@Service
public class MenuuServiceImpl implements MenuuService {
	MenuuRepository menuuRepository;
	
	public MenuuServiceImpl(MenuuRepository menuuRepository) {
		this.menuuRepository = menuuRepository;
	}
	
	@Override
	public List<Menu> getAllMenus(){
		List<Menu> menus = new ArrayList<>();
		menuuRepository.findAll().forEach(menus::add);
		return menus;
	}
	
	@Override
	public Menu getMenuById(String Id) {
		return menuuRepository.findById(Id).get();
	}
	
	@Override
	public Menu insertMenu(Menu menu) {
		return menuuRepository.save(menu);
	}
	
	@Override
	public Menu insertChildMenu(String parentId, Menu menu) {
//		Menu menuFromDb = menuuRepository.findById(parentId).get();
		Menu savedMenu = menuuRepository.save(menu);
		String Id = savedMenu.getMid();
		menuuRepository.updateMenu(parentId, Id);
		return savedMenu;
	}
	
	@Override
	public Menu updateMenu(String Id,  Menu menu) {
		Menu menuFromDb = menuuRepository.findById(Id).get();
		menuFromDb.setName(menu.getName());
		menuFromDb.setMid(menu.getMid());
		menuFromDb.setPid(menu.getPid());
		menuFromDb.setDescription(menu.getDescription());
		menuFromDb.setPermission(menu.getPermission());
		menuFromDb.setRoute(menu.getRoute());
		menuFromDb.setChildren(menu.getChildren());
		menuuRepository.save(menuFromDb);
		return menuFromDb;
	}
	
	@Override
	public void deleteMenu(String Id) {
		menuuRepository.deleteById(Id);
	}
}
