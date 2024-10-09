package QuanLyCCCD;

import java.time.LocalDate;
import java.util.Scanner;

public class TestCCCD {
//	private static DanhSachCCCD danhSach;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DanhSachCCCD ds = new DanhSachCCCD(5);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-------------Menu---------------");
            System.out.println("1. Thêm CCCD");
            System.out.println("2. Xóa CCCD");
            System.out.println("3. Cập nhật CCCD");
            System.out.println("4. Sắp xếp CCCD");
            System.out.println("5. In danh sách CCCD");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Nhập số CCCD: ");
                        String soCC = scanner.nextLine();
                        System.out.print("Nhập họ tên: ");
                        String hoTen = scanner.nextLine();
                        System.out.print("Nhập ngày sinh (yyyy-mm-dd): ");
                        LocalDate ngaySinh = LocalDate.parse(scanner.nextLine());
                        System.out.print("Nhập ngày cấp (yyyy-mm-dd): ");
                        LocalDate ngayCap = LocalDate.parse(scanner.nextLine());
                        System.out.print("Nhập địa chỉ: ");
                        String diaChi = scanner.nextLine();

                        CanCuocCD cc = new CanCuocCD(soCC, hoTen, ngaySinh, ngayCap, diaChi);
                        if (ds.themCCCD(cc)) {
                            System.out.println("Thêm CCCD thành công!");
                        } else {
                            System.out.println("Số CCCD đã tồn tại!");
                        }
                    } catch (Exception e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }

                case 2:
                    System.out.print("Nhập số CCCD cần xóa: ");
                    String maXoa = scanner.nextLine();
                    if (ds.xoa(maXoa)) {
                        System.out.println("Xóa CCCD thành công!");
                    } else {
                        System.out.println("Số CCCD không tồn tại!");
                    }

                case 3:
                    try {
                        System.out.print("Nhập số CCCD cần cập nhật: ");
                        String soCC = scanner.nextLine();
                        System.out.print("Nhập ngày cấp mới (yyyy-mm-dd): ");
                        LocalDate ngayCapMoi = LocalDate.parse(scanner.nextLine());

                        if (ds.capNhat(soCC, ngayCapMoi)) {
                            System.out.println("Cập nhật CCCD thành công!");
                        } else {
                            System.out.println("Số CCCD không tồn tại!");
                        }
                    } catch (Exception e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }

                case 4:
                    ds.sapXep();
                    System.out.println("Đã sắp xếp danh sách CCCD.");
                case 5:
                    CanCuocCD[] danhSachCCCD = ds.getCanCuocCDs();
                    System.out.printf("|%15s|%20s|%15s|%15s|%20s|", "Số CCCD", "Họ Tên", "Ngày Sinh", "Ngày Cấp", "Địa Chỉ");
                    for (int i = 0; i < ds.count; i++) {
                        System.out.println(danhSachCCCD);
                    }
                    

                case 6:
                    System.out.println("Thoát chương trình.");

                default:
                    System.out.println("Lựa chọn không hợp lệ. Chọn lại!");
            }
        } while (choice != 6);

        scanner.close();
	}
}
