package SanPham;

public class SanPham {
	public int maSP;
	public String tenSP;
	public String loaiSP;
	public double giaSP;
	public int soLuongSP;
	public String moTaSP;
	
	public SanPham(int maSP, String tenSP, String loaiSP, double giaSP, int soLuongSP, String moTaSP) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loaiSP = loaiSP;
		this.giaSP = giaSP;
		this.soLuongSP = soLuongSP;
		this.moTaSP = moTaSP;
	}
	public int getMaSP() {
		return maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public String getLoaiSP() {
		return loaiSP;
	}
	public double getGiaSP() {
		return giaSP;
	}
	public int getSoLuongSP() {
		return soLuongSP;
	}
	public String getMoTaSP() {
		return moTaSP;
	}
	
	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}
	public void setGiaSP(double giaSP) {
		this.giaSP = giaSP;
	}
	public void setSoLuongSP(int soLuongSP) {
		this.soLuongSP = soLuongSP;
	}
	public void setMoTaSP(String moTaSP) {
		this.moTaSP = moTaSP;
	}
	
	public double giaTriTonKho() {
		return giaSP * soLuongSP;
	}
	
	public String tostring() {
		return "Mã SP: " + maSP +
				",Tên SP: " + tenSP 	;
	}
	
}
