package QuanLyCCCD;

import java.time.LocalDate;

public class CanCuocCD {
	private String soCCCD;
	private String hoTen;
	private LocalDate ngaySinh;
	private LocalDate ngayCap;
	private String diaChi;
	//đóng gói
	public String getSoCCCD() {
		return soCCCD;
	}
	public void setSoCCCD(String soCC) throws Exception {
		if(soCCCD != null) {
			this.soCCCD = soCC;
		}else {
			throw new Exception("Số CCCD không được rỗng!");
		}
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) throws Exception {
		if(hoTen != null) {
			this.hoTen = hoTen;
		}else {
			throw new Exception("Họ tên không được rỗng!");
		}
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) throws Exception {
		if(ngaySinh != null && ngaySinh.isBefore(LocalDate.now())) {
			this.ngaySinh = ngaySinh;
		}else {
			throw new Exception("Ngày sinh không được rỗng! Và ngày sinh phải nhỏ hơn năm hiện tại 15 năm");
		}
	}
	public LocalDate getNgayCap() {
		return ngayCap;
	}
	public void setNgayCap(LocalDate nc) throws Exception {
		if(ngayCap.isAfter(ngaySinh)) {
			this.ngayCap = nc;
		}else {
			throw new Exception("Ngày cấp phải lớn hơn ngày sinh 15 năm!");
		}
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	//hàm tạo
	public CanCuocCD() throws Exception {
		this("", "", LocalDate.now(), LocalDate.now(), "");
	}
	public CanCuocCD(String soCC, String hoTen, LocalDate ngaySinh, LocalDate nc, String diaChi) throws Exception {
		if(soCC != null) {
			this.soCCCD = soCC;
		}else {
			throw new Exception("Số CCCD không được rỗng!");
		}
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.ngayCap = nc;
		this.diaChi = diaChi;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "";
		s+=s.formatted("|%15s|%20s|%15s|%15s|%20s|", getSoCCCD(), getHoTen(), getNgaySinh(), getNgayCap(), getDiaChi());
		return s;
	}
}
