package rwos.dynamicMenuu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rwos.dynamicMenuu.Entity.Menu;
import rwos.dynamicMenuu.Repository.MenuuRepository;
import rwos.dynamicMenuu.Service.MenuuServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/menu")
public class MenuuController {
	@Autowired
	private MenuuRepository menuuRepository;
	
	MenuuServiceImpl menuuService;
	public MenuuController(MenuuServiceImpl menuuService) {
		this.menuuService = menuuService;
	}
	
	@GetMapping()
	public List<Menu> getAllMenus(){
//		return menuuRepository.findAll();
		return menuuRepository.getData();
	}
	
	@PostMapping()
	public Menu saveMenu(@RequestBody Menu menu) {
		System.out.println(menu);
		return menuuService.insertMenu(menu);
	}
	
	@PostMapping("/{parentId}")
    public Menu saveChildMenu(@PathVariable String parentId, @RequestBody Menu menu) {
        return menuuService.insertChildMenu(parentId, menu);
    }
	
	@PutMapping("/{id}")
	public Menu updateMenu(@RequestBody Menu menu, @PathVariable String id) {
		return menuuService.updateMenu(id, menu);
	}
	
	@DeleteMapping("/{id}")
	public void removeMenu(@PathVariable String id) {
		menuuService.deleteMenu(id);
	}
	
}
