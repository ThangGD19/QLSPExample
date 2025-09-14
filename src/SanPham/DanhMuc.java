package SanPham;

public class DanhMuc {
	private String tenDanhMuc;
	private double tongGiaTri;
	
	public DanhMuc(String tenDanhMuc, double tongGiaTri) {
		this.tenDanhMuc = tenDanhMuc;
		this.tongGiaTri = tongGiaTri;
	}
	
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public double getTongGiaTri() {
		return tongGiaTri;
	}
}
