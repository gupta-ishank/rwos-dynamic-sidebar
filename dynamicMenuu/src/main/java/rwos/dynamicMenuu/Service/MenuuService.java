package rwos.dynamicMenuu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rwos.dynamicMenuu.Entity.Menu;
import rwos.dynamicMenuu.Repository.MenuuRepository;
	
@Service
@Transactional
public class MenuuService {
	@Autowired
	private MenuuRepository menuRepository;
	
	public List<Menu> getAllMenus(){
		return menuRepository.findAll();
	}
}
