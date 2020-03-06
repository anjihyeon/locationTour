package location.tour.index.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import location.tour.tourlist.model.TourDTO;
import location.tour.tourlist.model.TourSearchDTO;
import location.tour.tourlist.model.TourlistDTO;
import location.tour.tourlist.service.TourSearchService;
import location.tour.tourlist.service.TourService;
import location.tour.tourlist.service.TourlistService;

@Controller
public class IndexController {
	@Autowired
	private TourService service;
	@Autowired
	private TourlistService tlservice;
	@Autowired
	private TourSearchService tsservice;
	
	@RequestMapping("/")
	public String indexView() {
		return "/index";
	}
	@RequestMapping(value = "/scorllPage", method = RequestMethod.POST)
	public @ResponseBody List<TourlistDTO> scorllPageView(Long type,Long pageNo) throws Exception {
		return tlservice.tourList(type,pageNo);
	}
	@RequestMapping(value = "/scorllPage2", method = RequestMethod.POST)
	public @ResponseBody List<TourSearchDTO> scorllPageView2(String keyword,Long pageNo) throws Exception {
		return tsservice.tourSearchList(keyword,pageNo);
	}
	@RequestMapping("/map")
	public String mapview() throws Exception  {
		return "/map/map";
	}

}
