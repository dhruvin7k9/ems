package springBoot.ems.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springBoot.ems.Entity.Club;
import springBoot.ems.Entity.Event;
import springBoot.ems.Entity.Student;
import springBoot.ems.Service.ClubService;

@Controller
@RequestMapping(value = "/club")
public class ClubController {
	private ClubService clubService;
	
	@Autowired
	public ClubController(ClubService clubService) {
		// TODO Auto-generated constructor stub
		this.clubService = clubService;
	}
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn() {
		return "clubSignIn";
	}
	
	@RequestMapping(value = "/validateClub", method = RequestMethod.POST)
	public String validateClub(@RequestParam String clubName, @RequestParam String clubPassword, ModelMap modelMap, RedirectAttributes redirectAttributes) {
		if(clubService.validateClub(clubName,clubPassword)) {
			redirectAttributes.addAttribute("clubName", clubName); // dk
			return "redirect:showClubDashboard";
		}
		modelMap.addAttribute("msg", "credentials are wrong or club does not exist");
		return "clubSignIn";
	}
	
	@RequestMapping(value = "/registerClub")
	public String registerClub() {
		return "registerClub";
	}
	
	@RequestMapping(value = "/createClub", method = RequestMethod.POST)
	public String createClub(@RequestParam String clubName, @RequestParam String clubPassword, ModelMap modelMap) {
		Club newClub = new Club(clubName, clubPassword);
		if(!clubService.findByClubName(clubName)) {
			clubService.addClub(newClub);
			modelMap.addAttribute("msg", "sign in with the registered credentials");
			return "clubSignIn";
		}
		modelMap.addAttribute("msg", "the club name is already registered\nplease change the club name");
		return "registerClub";
	}
	
	@RequestMapping(value = "/showClubDashboard")
	public String showClubDashboard(@RequestParam("clubName") String clubName, ModelMap modelMap) { // dk
		modelMap.addAttribute("clubName", clubName); // dk
		List<Event> events = clubService.getEventsByClubName(clubName);
		String status = "full";
		modelMap.addAttribute("status", status);
		if (events.isEmpty() == true)
			status = "empty";
		modelMap.addAttribute("status", status);
		modelMap.addAttribute("events", events); // dk
		
		return "clubDashboard";
	}
	// dk
	@RequestMapping(value = "/addEvent")
	public String addEvent(@RequestParam("clubName") String clubName, ModelMap modelMap) { // dk
		modelMap.addAttribute("clubName", clubName); // dk
		return "addEvent";
	}
	
	@RequestMapping(value = "/processNewEvent", method = RequestMethod.POST)
	public String processNewEvent(@RequestParam("clubName") String clubName, 
			@RequestParam(value = "eventName", required = true) String eventName,
			@RequestParam(value = "eventDescription", required = true) String eventDescription,
			@RequestParam(value = "eventRegDue", required = true) 
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
    		LocalDate eventRegDue,
			ModelMap modelMap, RedirectAttributes redirectAttributes) { // dk
		
		Club c = clubService.findByClubName(clubName, true);
		Event e = new Event(eventName, eventDescription, eventRegDue, c);
		clubService.addEvent(c.getcId(), e);
		redirectAttributes.addAttribute("clubName", clubName); // dk
		return "redirect:showClubDashboard";
	}
	
	@RequestMapping(value = "/eventDetails")
	public String eventDetails(@RequestParam("clubName") String clubName,
								@RequestParam("eId") int eId, 
								ModelMap modelMap) { 
		modelMap.addAttribute("clubName", clubName); 
		Event event = clubService.getEventByeId(eId);
		modelMap.addAttribute("event", event);
		
		// getting students directly through event object
		List<Student> students = event.getStudents();
		
		String status = "full";
		modelMap.addAttribute("status", status);
		if (students.isEmpty() == true)
			status = "empty";
		modelMap.addAttribute("status", status);
		modelMap.addAttribute("students", students); // dk
		return "eventDetails";
	}
	
	@RequestMapping(value = "/eventDelete")
	public String eventDelete(@RequestParam("clubName") String clubName,
								@RequestParam("eId") int eId, 
								RedirectAttributes redirectAttributes) { 
		Event e = clubService.getEventByeId(eId);
		Club c = clubService.findByClubName(clubName, true);
		clubService.removeEvent(c.getcId(), e);
		redirectAttributes.addAttribute("clubName", clubName); // dk
		return "redirect:showClubDashboard";
	}
}
