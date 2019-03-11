package es.santatecla.user;

import org.springframework.stereotype.Controller;

@Controller
public class UserController extends UserService {
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private UserComponent userComponent;
//	
//	@Autowired
//	private UnitRepository unitRepository;
	
	
//	@PostConstruct
//	public void init() {
//		userRepository.save(new User("Miguel","1234", "ROLE_ADMIN","ROLE_USER"));
//		userRepository.save(new User("Carlos","pass", "ROLE_USER"));
//		
//	}
	
//	@GetMapping("/")
//	public String showUnits(Model model) {
//		model.addAttribute("unit",unitRepository.findAll());
//		return "/index";
//	}
	
//	@RequestMapping("/user")//Request to show the user's name 
//	public String user(Model model) {
//		Boolean b = userComponent.isLoggedUser();
//		model.addAttribute("logged",b);
//		if (b) {
//			User user = userComponent.getLoggedUser();
//			user = userRepository.getById(user.getId());
//			model.addAttribute(user.getName());
//		}
//			
//		return "/index";//Have to create	user template to show the user	
			
}
	
	

