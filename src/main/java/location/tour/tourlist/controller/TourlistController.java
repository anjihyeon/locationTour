package location.tour.tourlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import location.tour.tourlist.model.LocationCodeDTO;
import location.tour.tourlist.model.TourDTO;
import location.tour.tourlist.model.TourInfoDTO;
import location.tour.tourlist.model.TourSearchDTO;
import location.tour.tourlist.model.TourlistDTO;
import location.tour.tourlist.service.CategoryCodeService;
import location.tour.tourlist.service.LocationCodeService;
import location.tour.tourlist.service.TourInfoService;
import location.tour.tourlist.service.TourSearchService;
import location.tour.tourlist.service.TourService;
import location.tour.tourlist.service.TourlistService;

@Controller
@RequestMapping("/tour")
public class TourlistController {
	@Autowired
	private TourlistService service;
	@Autowired
	private TourService tservice;
	@Autowired
	private TourInfoService tiservice;
	@Autowired
	private TourSearchService tsservice;
	@Autowired
	private LocationCodeService lservice;
	@Autowired
	private CategoryCodeService cservice;
	
	@RequestMapping(value ="/tourlist", method = RequestMethod.GET)
	public String tourList(Model model,Long type,Long pageNo) throws Exception {
			model.addAttribute("tList", service.tourList(type,pageNo));
			model.addAttribute("lList", lservice.locationcodeList());
			model.addAttribute("cList", cservice.cat1List(type));
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("type", type);			
		return "/tour/tourlist";
	}
	@RequestMapping(value ="/tourAddrCodelist", method = RequestMethod.GET)
	public String tourAddrCodeList(Model model,Long type,Long pageNo,Long addrCode) throws Exception {
			model.addAttribute("tList", service.tourAddrCodeList(type,pageNo,addrCode));
			model.addAttribute("lList", lservice.locationcodeList());
			model.addAttribute("cList", cservice.cat1List(type));
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("type", type);			
			model.addAttribute("addrCode", addrCode);			
		return "/tour/tourlist";
	}
	@RequestMapping(value ="/tourCat1list", method = RequestMethod.GET)
	public String tourCat1List(Model model,Long type,Long pageNo,String cat1) throws Exception {
			model.addAttribute("tList", service.tourcat1List(type,pageNo,cat1));
			model.addAttribute("lList", lservice.locationcodeList());
			model.addAttribute("cList", cservice.cat1List(type));
			model.addAttribute("c2List", cservice.cat2List(type,cat1));
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("type", type);
			model.addAttribute("cat1", cat1);
		return "/tour/tourlist";
	}
	@RequestMapping(value ="/tourCat2list", method = RequestMethod.GET)
	public String tourCat2list(Model model,Long type,Long pageNo,String cat1,String cat2) throws Exception {
			model.addAttribute("tList", service.tourcat2List(type,pageNo,cat1,cat2));
			model.addAttribute("lList", lservice.locationcodeList());
			model.addAttribute("cList", cservice.cat1List(type));
			model.addAttribute("c2List", cservice.cat2List(type,cat1));
			model.addAttribute("c3List", cservice.cat3List(type,cat1,cat2));
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("type", type);
			model.addAttribute("cat1", cat1);
			model.addAttribute("cat2", cat2);
		return "/tour/tourlist";
	}
	@RequestMapping(value ="/tourCat3list", method = RequestMethod.GET)
	public String tourCat3list(Model model,Long type,Long pageNo,String cat1,String cat2,String cat3) throws Exception {
			model.addAttribute("tList", service.tourcat3List(type,pageNo,cat1,cat2,cat3));
			model.addAttribute("lList", lservice.locationcodeList());
			model.addAttribute("cList", cservice.cat1List(type));
			model.addAttribute("c2List", cservice.cat2List(type,cat1));
			model.addAttribute("c3List", cservice.cat3List(type,cat1,cat2));
			model.addAttribute("pageNo", pageNo);
			model.addAttribute("type", type);
			model.addAttribute("cat1", cat1);
			model.addAttribute("cat2", cat2);
			model.addAttribute("cat3", cat3);
		return "/tour/tourlist";
	}
	@RequestMapping(value = "/view",method = RequestMethod.GET)
	public String tourView(Model model,Long type,Long contentid) throws Exception {
		List<TourDTO> tList = tservice.tourList(type, contentid);
		List<TourInfoDTO> tiList = tiservice.tourInfoList(type, contentid);
		model.addAttribute("tList", tList);
		model.addAttribute("tiList", tiList);
		model.addAttribute("type",type);
		model.addAttribute("contentid", contentid);
		return "/tour/view";
	}
	@RequestMapping(value = "/tourSearch",method = RequestMethod.GET)
	public String tourSearch(Model model,String keyword,Long pageNo) throws Exception {
		List<TourSearchDTO> tsList = tsservice.tourSearchList(keyword,pageNo);
		model.addAttribute("tsList", tsList);
		model.addAttribute("keyword",keyword);
		model.addAttribute("pageNo", pageNo);
		return "/tour/tourSearch";
	}
}
