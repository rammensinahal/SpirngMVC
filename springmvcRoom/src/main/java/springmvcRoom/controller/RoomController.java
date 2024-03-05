package springmvcRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvcRoom.dao.RoomDao;
import springmvcRoom.dto.Room;

@Controller
public class RoomController {
	@Autowired
	private RoomDao dao;

	@RequestMapping("/reg")
	public ModelAndView register() {
		ModelAndView view=new ModelAndView();
		view.addObject("room",new Room());
		view.setViewName("register.jsp");
		return view;

	}

	@RequestMapping("/save")
	public ModelAndView saveRoom(@ModelAttribute Room room) {
		ModelAndView view=new ModelAndView();
		dao.saveRoom(room);
		List<Room> list=dao.getall();
		view.addObject("list", list );
		view.setViewName("disply.jsp");
		return view;

	}
	@RequestMapping("/update")
	public ModelAndView updateRoom(@ModelAttribute Room room) {
		ModelAndView view=new ModelAndView();
		dao.updateRoom(room);
		List<Room> list =dao.getall();
		view.addObject("list",list);
		view.setViewName("disply.jsp");
		return view;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteRoom(@RequestParam int id) {
		ModelAndView view=new ModelAndView();
		boolean r=dao.deleteRoom(id);
		if(r) {
			List<Room> list =dao.getall();
			view.addObject("list", list);
			view.setViewName("disply.jsp");
		}else {
			view.setViewName("register.jsp");
		}
		return view;
	}
	@RequestMapping("/edit")
	public ModelAndView editRoom(@RequestParam int id) {
		ModelAndView view=new ModelAndView();
		Room r=dao.getById(id);
		view.addObject("r",r);
		view.setViewName("edit.jsp");
		return view;
	}

}
