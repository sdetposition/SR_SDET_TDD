package jsonUtils.invoices;

import java.util.List;

public class Invoices {

	public String catalogName;
	public String lastUpdated;
	public List<Categories> categories;

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}
	
	public String toString() {
		return getCatalogName()+" "+getLastUpdated()+" "+getCategories();
	}

}
