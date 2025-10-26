package jsonUtils.invoices;

import java.util.List;

public class Specifications {

	public String display;
	public String processor;
	public String storage;
	public String ram;
	
	public List<String> storageOptions;
	public List<String> cameraFeatures;
	
	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public List<String> getStorageOptions() {
		return storageOptions;
	}

	public void setStorageOptions(List<String> storageOptions) {
		this.storageOptions = storageOptions;
	}

	public List<String> getCameraFeatures() {
		return cameraFeatures;
	}

	public void setCameraFeatures(List<String> cameraFeatures) {
		this.cameraFeatures = cameraFeatures;
	}

}
