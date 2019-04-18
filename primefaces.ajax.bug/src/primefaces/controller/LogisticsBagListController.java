package primefaces.controller;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import primefaces.model.LogisticsBag;
import primefaces.model.LogisticsOutbound;
import primefaces.utils.BigDecimalUtils;

@ManagedBean(name = "logisticsBagListController")
@SessionScoped
public class LogisticsBagListController {
	private LogisticsOutbound model;

	@PostConstruct
	public void init() {
		model = new LogisticsOutbound();
		LogisticsBag bag = new LogisticsBag();
		bag.setParent(model);
		model.getBags().add(bag);
	}

	public LogisticsOutbound getModel() {
		return model;
	}

	public void setModel(LogisticsOutbound model) {
		this.model = model;
	}

	public void dimensionChanged(Object row, int index) {
		if (row instanceof LogisticsBag) {
			LogisticsBag bag = (LogisticsBag) row;
			bag.setVol(BigDecimalUtils.multiply(BigDecimalUtils.multiply(bag.getLength(), bag.getWidth()),
					bag.getHeight()));
			BigDecimal totalVol = BigDecimal.ZERO;
			for (LogisticsBag obj : getModel().getBags()) {
				totalVol = BigDecimalUtils.add(totalVol, obj.getVol());
			}
			getModel().setVol(totalVol);
			PrimeFaces.current().ajax().update("entity_form:bagsTable:" + index + ":vol_output");
			PrimeFaces.current().ajax().update("entity_form:bagsTable:" + index + ":vol_input");
			PrimeFaces.current().ajax().update("entity_form:bagsTable:total_vol");
		}
	}

	public void weightChanged(Object row, int index) {
		if (row instanceof LogisticsBag) {
			LogisticsBag bag = (LogisticsBag) row;
			BigDecimal totalWeight = BigDecimal.ZERO;
			for (LogisticsBag obj : getModel().getBags()) {
				totalWeight = BigDecimalUtils.add(totalWeight, obj.getWeight());
			}
			getModel().setWeight(totalWeight);
			PrimeFaces.current().ajax().update("entity_form:bagsTable:total_weight");
		}
	}

	public void addRow(int index) {

		if (getModel() != null) {
			LogisticsBag bag = new LogisticsBag();

			if (index == -1) {
				getModel().getBags().add(bag);
			} else {
				getModel().getBags().add(index + 1, bag);
			}
		}

	}

	public void deleteRow(int index) {
		if (getModel() != null) {

			// 如果是最后一个行，不允许删除
			if (index == 0 && getModel().getBags().size() == 1) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "最后一个子件不能删除", "至少要有一个子件"));
				return;
			}
			getModel().getBags().remove(index);
			// 更新合计信息
			updateSumInfo();
		}
	}

	private void updateSumInfo() {
		// 总数量
		LogisticsOutbound parent = getModel();
		BigDecimal totalVol = BigDecimal.ZERO;
		BigDecimal totalWeight = BigDecimal.ZERO;
		// 计算总体积
		for (LogisticsBag bag : parent.getBags()) {

			totalVol = BigDecimalUtils.add(totalVol, bag.getVol());
			totalWeight = BigDecimalUtils.add(totalWeight, bag.getWeight());
		}
		getModel().setVol(totalVol);
		getModel().setWeight(totalWeight);

		PrimeFaces.current().ajax().update("entity_form:bagsTable:total_vol");
		PrimeFaces.current().ajax().update("entity_form:bagsTable:total_weight");
	}

}
