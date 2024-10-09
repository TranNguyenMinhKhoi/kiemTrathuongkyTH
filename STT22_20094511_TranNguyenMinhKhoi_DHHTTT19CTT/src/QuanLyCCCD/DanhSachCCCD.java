package QuanLyCCCD;

import java.time.LocalDate;

public class DanhSachCCCD {

	public int count;
    public CanCuocCD[] ls;

    public DanhSachCCCD(int n) {
        ls = new CanCuocCD[n];
        count = 0;
    }

    // Tăng kích thước mảng
    private void tangKT() {
        CanCuocCD[] tam = new CanCuocCD[ls.length * 2];
        System.arraycopy(ls, 0, tam, 0, count);
        ls = tam;
    }

    // Thêm CCCD
    public boolean themCCCD(CanCuocCD cc) {
        if (count == ls.length) {
            tangKT();
        }
        for (int i = 0; i < count; i++) {
            if (ls[i].getSoCCCD().equalsIgnoreCase(cc.getSoCCCD())) {
                return false;
            }
        }
        ls[count] = cc;
        count++;
        return true;    
    }

    // Xóa CCCD
    public boolean xoa(String maXoa) {
        int viTri = -1;
        for (int i = 0; i < count; i++) {
            if (ls[i].getSoCCCD().equalsIgnoreCase(maXoa)) {
                viTri = i;
            }
        }
        if (viTri != -1) {
            for (int i = viTri; i < count - 1; i++) {
                ls[i] = ls[i + 1];
            }
            ls[count - 1] = null; 
            count--;
            return true;
        } else {
            return false; 
        }
    }

    // Cập nhật CCCD
    public boolean capNhat(String soCC, LocalDate nc) throws Exception {
        int viTri = -1;
        for (int i = 0; i < count; i++) {
            if (ls[i].getSoCCCD().equalsIgnoreCase(soCC)) {
                viTri = i;
            }
        }
        if (viTri != -1) {
            ls[viTri].setNgayCap(nc);
            return true;
        } else {
            return false; 
        }
    }

    // Sắp xếp CCCD
    public void sapXep() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (ls[i].getNgayCap().compareTo(ls[j].getNgayCap()) > 0) {
                    CanCuocCD tam = ls[i];
                    ls[i] = ls[j];
                    ls[j] = tam;    
                }
            }
        }
    }

    // Lấy danh sách CCCD
    public CanCuocCD[] getCanCuocCDs() {
		return ls;
	}
}
