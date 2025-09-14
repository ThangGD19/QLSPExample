package SanPham;


import java.util.*;

public class Main {
	static ArrayList<SanPham> dsSanPham = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] arg) {
		dsSanPham.add(new SanPham(1,"Bánh", "ăn uống", 20.0, 30, "Bánh kem vị socola"));
		dsSanPham.add(new SanPham(2,"Bánh", "ăn uống", 25.0, 15, "Bánh kem vị vani"));
		dsSanPham.add(new SanPham(3,"Bánh", "ăn uống", 30.0, 5, "Bánh kem mix 2 vị socola + vani"));
		
		int chon;
		do {
			System.out.println("\n==== MENU QUAN LY SAN PHAM ====");
			System.out.println("1. CAP NHAT THONG TIN SAN PHAM");
			System.out.println("2. HIEN THI DANH SACH SAN PHAM THEO GIA");
			System.out.println("3. HIEN THI DANH SACH SAN PHAM THEO DANH MUC");
			System.out.println("4. TINH TONG GIA TRI TON KHO THEO DANH MUC");
			System.out.println("5. GIAM GIA SAN PHAM");
			System.out.println("6. DAT HANG");
			System.out.println("7. THOAT"); 
			System.out.println("CHON: ");
			chon = sc.nextInt();
			sc.nextLine();
			
			switch (chon) {
				case 1 -> capNhatSanPham();
				case 2 -> hienThiGiaSP();
				case 3 -> hienThiTheoDanhMuc();
				case 4 -> tongGiaTriTonKho();
				case 5 -> giamGiaSanPham();
				case 6 -> datHang();
				case 7 -> {System.out.println("Thoát chương trình"); 
							System.exit(0);
						}
				default -> System.out.println("Lựa chọn không phù hợp");
			}
		}while(chon !=7);
	}
//update SP
	public static void capNhatSanPham() {
		System.out.println("Nhap ma san pham can cap nhat: ");
		int maSP =sc.nextInt();
		sc.nextLine();
		for (SanPham sp: dsSanPham) {
			if (sp.getMaSP() == maSP) {
				System.out.println("Nhập giá mới: ");
				sp.setGiaSP(sc.nextDouble());
				System.out.println("Nhập số lượng mới: ");
				sp.setSoLuongSP(sc.nextInt()); sc.nextLine();
				System.out.println("Phân loại mới: ");
				sp.setLoaiSP(sc.nextLine());
				System.out.println("Đã cập nhật: " + sp);
				return;
			}
		}
		System.out.println("Không tìm thấy sản phẩm!!!");
	}
	
//giaSP
	public static void hienThiGiaSP() {
		dsSanPham.sort(Comparator.comparingDouble(SanPham :: getGiaSP));
		dsSanPham.forEach(System.out::println);
	}
//DanhMuc
	public static void hienThiTheoDanhMuc() {
		System.out.println("Nhập tên danh mục: ");
		String cat = sc.nextLine();
		for(SanPham sp : dsSanPham){
			if(sp.getLoaiSP().equalsIgnoreCase(cat)) {
				System.out.println(sp);
			}
		}
	}
//TongGiaTriTonKho
	public static void tongGiaTriTonKho() {
		HashMap<String, Double> map = new HashMap<>();
		for(SanPham sp : dsSanPham) {
			map.put(sp.getLoaiSP()	, map.getOrDefault(sp.getLoaiSP(), 0.0) + sp.giaTriTonKho());
		}
		for(String cat : map.keySet()) {
			System.out.println(new DanhMuc(cat, map.get(cat)));
		}
	}
//Discount SP
	public static void giamGiaSanPham() {
		System.out.println("Nhập mã sản phẩm: ");
		int maSP  = sc.nextInt();
		System.out.println("Nhập % giảm giá: ");
		double percent = sc.nextDouble();
		for(SanPham sp : dsSanPham) {
			if(sp.getGiaSP() == maSP) {
				sp.setGiaSP(sp.getGiaSP() * (1 - percent / 100));
				System.out.println("Đã giảm giá: " + sp);
				return;
			}
		}
		System.out.println("Không tìm thấy sản phẩm!!");
	}
//Oder 
	public static void datHang() {
		System.out.println("Nhập mã sản phẩm: ");
		int maSP = sc.nextInt();
		System.out.println("Nhập số lượng: ");
		int SL = sc.nextInt();
		for(SanPham sp : dsSanPham) {
			if(sp.getMaSP() == maSP) {
				if(sp.getSoLuongSP() == SL) {
					Double total = SL * sp.getGiaSP();
					sp.setSoLuongSP(sp.getSoLuongSP() - SL);
					System.out.println("Đặt hàng thành công!! Tổng tiền: " + total);
				}else {
					System.out.println("Không đủ hàng trong kho!!");
				}
				return;
			}
			System.out.println("Không tìm thây sản phẩm!!");
		}
	}	
}	