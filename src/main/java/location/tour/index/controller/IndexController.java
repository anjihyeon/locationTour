package location.tour.index.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import location.tour.tourlist.model.TourSearchDTO;
import location.tour.tourlist.model.TourlistDTO;
import location.tour.tourlist.service.TourSearchService;
import location.tour.tourlist.service.TourlistService;

@Controller
public class IndexController {
	@Autowired
	private TourlistService service;
	@Autowired
	private TourSearchService tsservice;
	
	@RequestMapping("/")
	public String indexView() {
		return "/index";
	}
	@RequestMapping(value = "/scorllPage", method = RequestMethod.POST)
	public @ResponseBody List<TourlistDTO> scorllPageView(Long type,Long pageNo) throws Exception {
		return service.tourList(type,pageNo);
	}
	@RequestMapping(value = "/scorllPage2", method = RequestMethod.POST)
	public @ResponseBody List<TourSearchDTO> scorllPageView2(String keyword,Long pageNo) throws Exception {
		return tsservice.tourSearchList(keyword,pageNo);
	}
}
