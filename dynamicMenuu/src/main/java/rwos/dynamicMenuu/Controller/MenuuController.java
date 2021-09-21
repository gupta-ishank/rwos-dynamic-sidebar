package rwos.dynamicMenuu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rwos.dynamicMenuu.Entity.Menu;
import rwos.dynamicMenuu.Repository.MenuuRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/menu")
public class MenuuController {
	@Autowired
	private MenuuRepository menuRepository;
	
	@GetMapping("")
	public List<Menu> getAllMenus(){
		return menuRepository.findAll();
	}
}
