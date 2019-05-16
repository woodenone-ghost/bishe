package zhangjie.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import zhangjie.bo.EntityTransformer;
import zhangjie.cache.EntityConfigCache;
import zhangjie.constants.Constants;
import zhangjie.dao.BillDAO;
import zhangjie.dao.CommodityDAO;
import zhangjie.entity.AjaxResult;
import zhangjie.entity.LineChart;
import zhangjie.entity.Pager;
import zhangjie.entity.PieGraph;
import zhangjie.model.Commodity;
import zhangjie.util.AssertUtil;
import zhangjie.util.BeanUtil;
import zhangjie.util.CategoryUtil;

@Controller
@RequestMapping("/commodity")
public class CommodityController extends BaseController {

	private static final Logger logger = Logger.getLogger(CommodityController.class);

	@SuppressWarnings("unused")
	private static final EntityTransformer TF = new EntityTransformer() {
		public void transform(Map<String, String> mp) {

		}
	};

	@Autowired
	private CommodityDAO commodityDAO;
	@Autowired
	private BillDAO billDAO;

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manage(Model model) {
		model.addAttribute(Constants.ENTITY_CONF, EntityConfigCache.get(Constants.ENTITY_COMMODITY));
		return "commodity/manage";
	}

	@RequestMapping(value = "/sellerManage", method = RequestMethod.GET)
	public String sellerManage(Model model) {
		model.addAttribute(Constants.ENTITY_CONF, EntityConfigCache.get(Constants.ENTITY_COMMODITY));
		return "commodity/sellerManage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(Constants.ENTITY_CONF, EntityConfigCache.get(Constants.ENTITY_COMMODITY));
		return "commodity/add";
	}

	@RequestMapping(value = "/add/submit", method = RequestMethod.POST)
	public @ResponseBody AjaxResult addSubmit(String name, String price, String danwei, String category,
			MultipartFile icon, MultipartFile characteristic, HttpSession session) {
		// 字段检查
		AssertUtil.argIsNotNull(icon, "icon is null");
		AssertUtil.strIsNotBlank(name, "name is null");
		AssertUtil.strIsNotBlank(price, "price is null");
		AssertUtil.strIsNotBlank(danwei, "danwei is null");
		AssertUtil.strIsNotBlank(category, "category is null");
		AssertUtil.argIsNotNull(characteristic, "characteristic is null");

		String str = RandomStringUtils.randomAlphanumeric(5);// 得到长度为5的随机字符串
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf1.format(now);

		String iconAddress = time + "_" + str + "_icon" + ".jpg";
		String path = session.getServletContext().getRealPath("/resources/icon/");
		File newFile = new File(path, iconAddress);

		String characteristicAddress = time + "_" + str + "_characteristic" + ".jpg";
		String path1 = session.getServletContext().getRealPath("/resources/characteristic/");
		File newFile1 = new File(path1, characteristicAddress);
		try {
			Commodity entity = new Commodity();
			entity.setIcon(iconAddress);
			entity.setName(name);
			entity.setPrice(price + danwei);
			entity.setCategory(CategoryUtil.wholeCategory(category));
			entity.setBusinessName(this.getSessionUser().getAccount());
			entity.setCharacteristic(characteristicAddress);
			commodityDAO.add(entity);
			icon.transferTo(newFile);
			characteristic.transferTo(newFile1);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commonBO.buildSuccessResult();
	}

	@RequestMapping(value = "/qry")
	public @ResponseBody AjaxResult qry(Integer pageNumber, Integer pageSize) {
		Map<String, String> qryParamMap = this.getQryParamMap();
		if (this.getSessionUser() != null) {
			String identity = this.getSessionUser().getIdentity();
			if (identity.equals("seller")) {
				qryParamMap.put("businessNameZ", this.getSessionUser().getAccount());
			} else if (identity.equals("buyer")) {
				qryParamMap.put("shangjia", "上架");
			}
		}
		logger.info("分页查询开始：" + qryParamMap);
		Pager<Commodity> p = commodityDAO.selectByPage(pageNumber, pageSize, qryParamMap);
		logger.info("分页查询结束，总记录数:" + p.getTotal());
		return commonBO.buildSuccessResult(Constants.PAGER_RESULT, p);
	}

	@RequestMapping(value = "/gotoSearch")
	public String search(Model model, String _QRY_category, String _QRY_name) {
		model.addAttribute(Constants.ENTITY_CONF, EntityConfigCache.get(Constants.ENTITY_COMMODITY));
		model.addAttribute("name", _QRY_name);
		model.addAttribute("category", _QRY_category);
		return "someCommodities";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, Integer id) {
		// 字段检查
		AssertUtil.argIsNotNull(id, "id is null");

		// 从数据库查询记录
		Commodity entity = commodityDAO.selectByPrimaryKey(id);
		AssertUtil.argIsNotNull(entity, "商品不存在");
		String[] str = entity.getPrice().split("/");
		entity.setPrice(str[0].substring(0, str[0].length() - 1));

		// 放入model，传入界面
		model.addAttribute(Constants.ENTITY_RESULT, entity);
		model.addAttribute("danwei", str[1]);
		model.addAttribute(Constants.ENTITY_CONF, EntityConfigCache.get(Constants.ENTITY_COMMODITY));
		return "commodity/edit";
	}

	@RequestMapping(value = "/edit/submit", method = RequestMethod.POST)
	public @ResponseBody AjaxResult editSubmit(int id, String name, String price, String danwei, String category,
			String businessName, MultipartFile icon, MultipartFile characteristic, int salesVolume,
			double evaluationPrice, double evaluationService, HttpSession session) {

		// 字段检查
		AssertUtil.argIsNotNull(id, "id is null");
		AssertUtil.strIsNotBlank(name, "name is null");
		AssertUtil.strIsNotBlank(price, "price is null");
		AssertUtil.strIsNotBlank(danwei, "danwei is null");
		AssertUtil.strIsNotBlank(category, "category is null");
		AssertUtil.strIsNotBlank(businessName, "businessName is null");
		AssertUtil.argIsNotNull(salesVolume, "salesVolume is null");
		AssertUtil.argIsNotNull(evaluationPrice, "evaluationPrice is null");
		AssertUtil.argIsNotNull(evaluationService, "evaluationService is null");

		// 从数据库查询记录
		Commodity dbentity = commodityDAO.selectByPrimaryKey(id);
		AssertUtil.argIsNotNull(dbentity, "商品不存在");

		String str = RandomStringUtils.randomAlphanumeric(5);// 得到长度为5的随机字符串
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf1.format(now);

		String iconAddress = time + "_" + str + "_icon" + ".jpg";
		String path = session.getServletContext().getRealPath("/resources/icon/");
		File newFile = new File(path, iconAddress);

		String characteristicAddress = time + "_" + str + "_characteristic" + ".jpg";
		String path1 = session.getServletContext().getRealPath("/resources/characteristic/");
		File newFile1 = new File(path1, characteristicAddress);
		Commodity entity = new Commodity();
		try {
			entity.setId(id);
			if (null != icon) {
				entity.setIcon(iconAddress);
			} else {
				entity.setIcon(dbentity.getIcon());
			}
			entity.setName(name);
			entity.setPrice(price + danwei);
			entity.setCategory(category);
			entity.setBusinessName(this.getSessionUser().getAccount());
			if (null != characteristic) {
				entity.setCharacteristic(characteristicAddress);
			} else {
				entity.setCharacteristic(dbentity.getCharacteristic());
			}
			entity.setSalesVolume(salesVolume);
			entity.setEvaluationPrice(evaluationPrice);
			entity.setEvaluationService(evaluationService);

			if (null != icon) {
				icon.transferTo(newFile);
			}
			if (null != characteristic) {
				characteristic.transferTo(newFile1);
			}
		} catch (IllegalStateException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(String.format("修改商品开始：%s", BeanUtil.desc(dbentity, null)));
		commodityDAO.update(entity);
		logger.info(String.format("修改商品结束：%s", BeanUtil.desc(entity, null)));

		return commonBO.buildSuccessResult();

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody AjaxResult delete(Integer id) {
		// 字段检查
		AssertUtil.argIsNotNull(id, "id is null");

		// 从数据库查询记录
		Commodity entity = commodityDAO.selectByPrimaryKey(id);
		AssertUtil.argIsNotNull(entity, "商品不存在");

		logger.info(String.format("删除商品开始：%s", BeanUtil.desc(entity, null)));
		commodityDAO.delete(id);
		logger.info(String.format("删除商品结束：%s", BeanUtil.desc(entity, null)));
		return commonBO.buildSuccessResult();
	}

	@RequestMapping(value = "/shangjia", method = RequestMethod.GET)
	public @ResponseBody AjaxResult shangjia(Integer id) {
		// 字段检查
		AssertUtil.argIsNotNull(id, "id is null");

		// 从数据库查询记录
		Commodity entity = commodityDAO.selectByPrimaryKey(id);
		AssertUtil.argIsNotNull(entity, "商品不存在");

		logger.info(String.format("上架商品开始：%s", BeanUtil.desc(entity, null)));
		entity.setShangjia("上架");
		commodityDAO.update(entity);
		logger.info(String.format("上架商品结束：%s", BeanUtil.desc(entity, null)));
		return commonBO.buildSuccessResult();
	}

	@RequestMapping(value = "/xiajia", method = RequestMethod.GET)
	public @ResponseBody AjaxResult xiajia(Integer id) {
		// 字段检查
		AssertUtil.argIsNotNull(id, "id is null");

		// 从数据库查询记录
		Commodity entity = commodityDAO.selectByPrimaryKey(id);
		AssertUtil.argIsNotNull(entity, "商品不存在");

		logger.info(String.format("下架商品开始：%s", BeanUtil.desc(entity, null)));
		entity.setShangjia("下架");
		commodityDAO.update(entity);
		logger.info(String.format("下架商品结束：%s", BeanUtil.desc(entity, null)));
		return commonBO.buildSuccessResult();
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, Integer id) {
		// 字段检查
		AssertUtil.argIsNotNull(id, "id is null");

		// 从数据库查询记录
		Commodity entity = commodityDAO.selectByPrimaryKey(id);
		AssertUtil.argIsNotNull(entity, "商品不存在");

		// 放入model，传入界面
		model.addAttribute(Constants.ENTITY_RESULT, entity);
		model.addAttribute(Constants.ENTITY_CONF, EntityConfigCache.get(Constants.ENTITY_COMMODITY));
		return "commodity/detail";
	}

	@RequestMapping(value = "/lineChart", method = RequestMethod.GET)
	public String lineChart(Model model) {
		model.addAttribute(Constants.ENTITY_CONF, EntityConfigCache.get(Constants.ENTITY_COMMODITY));
		return "commodity/lineChart";
	}

	@RequestMapping(value = "/lineChart/xianshi", method = RequestMethod.POST)
	public String lineChart_xianshi(Model model, Integer id, String selected) {
		// 字段检查
		AssertUtil.argIsNotNull(id, "id is null");
		AssertUtil.strIsNotBlank(selected, "selected is null");

		List<LineChart> list = billDAO.selectDateAndSalesVolumeById(id);
		Commodity commodity = commodityDAO.selectByPrimaryKey(id);

		model.addAttribute("commodity", commodity);
		model.addAttribute("selected", selected);

		List<LineChart> list2 = new ArrayList<LineChart>();
		logger.info(list);
		if (selected.equals("好评数-时间-折线图")) {
			List<LineChart> list1 = billDAO.selectGoodEvaluation(id);
			for (int i = 0; i < list.size(); i++) {
				LineChart dateAndSalesVolume = new LineChart();
				dateAndSalesVolume.setTime(list.get(i).getTime());
				dateAndSalesVolume.setSalesVolume(list.get(i).getSalesVolume());
				dateAndSalesVolume.setBillNumber(list.get(i).getBillNumber());
				if (i >= list1.size()) {
					dateAndSalesVolume.setEvaluationNumber(0);
				} else {
					dateAndSalesVolume.setEvaluationNumber(list1.get(i).getEvaluationNumber());
				}
				list2.add(dateAndSalesVolume);
			}
			model.addAttribute("list1", list2);
			return "commodity/lineChart_xianshi";
		} else if (selected.equals("差评数-时间-折线图")) {
			List<LineChart> list1 = billDAO.selectBadEvaluation(id);
			for (int i = 0; i < list.size(); i++) {
				LineChart dateAndSalesVolume = new LineChart();
				dateAndSalesVolume.setTime(list.get(i).getTime());
				dateAndSalesVolume.setSalesVolume(list.get(i).getSalesVolume());
				dateAndSalesVolume.setBillNumber(list.get(i).getBillNumber());
				if (i >= list1.size()) {
					dateAndSalesVolume.setEvaluationNumber(0);
				} else {
					dateAndSalesVolume.setEvaluationNumber(list1.get(i).getEvaluationNumber());
				}
				list2.add(dateAndSalesVolume);
			}
			model.addAttribute("list1", list2);
			return "commodity/lineChart_xianshi";
		}

		model.addAttribute("list1", list);
		return "commodity/lineChart_xianshi";
	}

	@RequestMapping(value = "/barChart", method = RequestMethod.GET)
	public String barChart(Model model) {
		model.addAttribute(Constants.ENTITY_CONF, EntityConfigCache.get(Constants.ENTITY_COMMODITY));
		return "commodity/barChart";
	}

	@RequestMapping(value = "/pieGraph", method = RequestMethod.GET)
	public String pieGraph(Model model) {
		model.addAttribute(Constants.ENTITY_CONF, EntityConfigCache.get(Constants.ENTITY_COMMODITY));
		return "commodity/pieGraph";
	}

	@RequestMapping(value = "/pieGraph/xianshi", method = RequestMethod.POST)
	public String pieGraph_xianshi(Model model, Integer id, String selected) {
		// 字段检查
		AssertUtil.argIsNotNull(id, "id is null");
		AssertUtil.strIsNotBlank(selected, "selected is null");

		Commodity commodity = commodityDAO.selectByPrimaryKey(id);

		if (selected.equals("男女比例-饼图")) {
			List<PieGraph> list = billDAO.selectSex(id);
			int maleNumber = 0;
			int femaleNumber = 0;
			for (PieGraph pieGraph : list) {
				if (pieGraph.getSex().equals("男")) {
					maleNumber++;
				} else {
					femaleNumber++;
				}
			}
			model.addAttribute("maleNumber", maleNumber);
			model.addAttribute("femaleNumber", femaleNumber);
		} else if (selected.equals("年龄分布-饼图")) {
			List<PieGraph> list = billDAO.selectAge(id);
			int age_49 = 0;
			int age_50_59 = 0;
			int age_60_69 = 0;
			int age_70_79 = 0;
			int age_80_89 = 0;
			int age_90_99 = 0;
			for (PieGraph pieGraph : list) {
				int age = pieGraph.getAge();
				if (age < 50) {
					age_49++;
				} else if (age < 60 && age >= 50) {
					age_50_59++;
				} else if (age < 70 && age >= 60) {
					age_60_69++;
				} else if (age < 80 && age >= 70) {
					age_70_79++;
				} else if (age < 90 && age >= 80) {
					age_80_89++;
				} else if (age >= 90) {
					age_90_99++;
				}
			}
			model.addAttribute("age_49", age_49);
			model.addAttribute("age_50_59", age_50_59);
			model.addAttribute("age_60_69", age_60_69);
			model.addAttribute("age_70_79", age_70_79);
			model.addAttribute("age_80_89", age_80_89);
			model.addAttribute("age_90_99", age_90_99);
		} else if (selected.equals("评价分布-饼图")) {
			List<PieGraph> list = billDAO.selectEvaluation(id);
			int goodNumber = 0;
			int normalNumber = 0;
			int badNumber = 0;
			for (PieGraph pieGraph : list) {
				if (pieGraph.getEvaluation().equals("好评")) {
					goodNumber++;
				} else if (pieGraph.getEvaluation().equals("中评")) {
					normalNumber++;
				} else if (pieGraph.getEvaluation().equals("差评")) {
					badNumber++;
				}
			}
			model.addAttribute("goodNumber", goodNumber);
			model.addAttribute("normalNumber", normalNumber);
			model.addAttribute("badNumber", badNumber);
		}
		model.addAttribute("commodity", commodity);
		model.addAttribute("selected", selected);
		return "commodity/pieGraph_xianshi";
	}
}
