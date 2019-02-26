package es.santatecla.user;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS )
	public class UserComponent {
	
		private User user;
		
		private List<String> roles;
		
		public User getLoggedUser() {
			return user;
		}
		
		public void setLoggedUser(User user) {
			this.user = user;
		}
		
		public boolean isLoggedUser() {
			return this.user != null;
		}
		
		public boolean isUSerInRole(String str) {
			return this.roles.contains(str);
		}

}
