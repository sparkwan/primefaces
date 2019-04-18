package primefaces.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LogisticsOutbound {
	private BigDecimal weight = BigDecimal.ZERO;
	private BigDecimal vol = BigDecimal.ZERO;
	private List<LogisticsBag> bags = new ArrayList<LogisticsBag>();

	public List<LogisticsBag> getBags() {
		return bags;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getVol() {
		return vol;
	}

	public void setVol(BigDecimal vol) {
		this.vol = vol;
	}

	public void setBags(List<LogisticsBag> bags) {
		this.bags = bags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bags == null) ? 0 : bags.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogisticsOutbound other = (LogisticsOutbound) obj;
		if (bags == null) {
			if (other.bags != null)
				return false;
		} else if (!bags.equals(other.bags))
			return false;
		return true;
	}

}
