package rwos.dynamicMenuu.Entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

	@Entity
	public class Menu {
		@Id
		@GeneratedValue(generator = "book_seq")
	    @GenericGenerator(
	        name = "book_seq", 
	        strategy = "rwos.dynamicMenuu.Generator.StringPrefixedSequenceIdGenerator" 
	       )
	    private String mid;
		private String pid;
		private String name;
		private String description;
		private String route;
		private String permission;
		
//		@ManyToOne(cascade = CascadeType.ALL)
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "parent_id", referencedColumnName = "mid")
		private List<Menu> children = new ArrayList<>();
//		private Menu menu;
		
			
		public Menu(){}

		public Menu(String name, String pid, String description, String route, String permission){
			this.name = name;
			this.pid = pid;
			this.description = description;
			this.route = route;
			this.permission = permission;
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
			this.pid = pid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getRoute() {
			return route;
		}

		public void setRoute(String route) {
			this.route = route;
		}

		public String getPermission() {
			return permission;
		}

		public void setPermission(String permission) {
			this.permission = permission;
		}

//		public void setMenu(Menu menu) {
//			this.menu = menu;
//		}

		public List<Menu> getChildren() {
			return children;
		}

		public void setChildren(List<Menu> children) {
			this.children = children;
		}
		
		public void addChildren(Menu menu) {
			this.children.add(menu);
		}
		
		
}
