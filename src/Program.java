
import java.util.List;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DAOFactory factory = new DAOFactory();
		int n, i, id;
		String id1;
		while (true) {
			System.out.println("1. Quản lý danh mục\r\n" + "2. Quản lý sản phẩm\r\n" + "3.Thoát\r\n" + "");
			System.out.println("Chọn chức năng 1 -> 3 :");
			int chon = scanner.nextInt();
			scanner.nextLine();
			switch (chon) {
			case 1:
				GeneralDAO<Category> category = factory.getDAO(Category.class);
				boolean check1 = false;
				do {
					System.out.println("________________Quản lý danh mục________________\r\n"
							+ "1. Hiển thị d/s danh mục sắp xếp theo tên A-Z (status hiển thị ẩn/hiện) (4)\r\n"
							+ "2. Thêm mới danh mục (1) (3)\r\n" + "3. Cập nhật danh mục (1) (3)\r\n"
							+ "4. Xóa danh mục (3)\r\n" + "5. Quay lại\r\n" + "");
					int chonDM = scanner.nextInt();
					switch (chonDM) {
					case 1:
						System.out.println("1. Hiển thị d/s danh mục sắp xếp theo tên A-Z (status hiển thị ẩn/hiện) ");
						category.get().sort((Category c1, Category c2) -> c1.getName().compareTo(c2.getName()));
						System.out.format("%32s%10s%16s", "Id", "Name", "Status");
						System.out.println("");
						for (Category cat : category.get()) {
							cat.displayData();
						}
						break;
					case 2:
						System.out.println("2. Thêm mới danh mục");
						System.out.print("Nhập số danh mục cần thêm mới: ");
						n = scanner.nextInt();
						scanner.nextLine();

						for (i = 0; i < n; i++) {
							Category cat = new Category();
							System.out.println("Nhập danh mục thứ " + (i + 1) + ": ");
							cat.inputData();
							category.add(cat);
						}
						break;
					case 3:
						System.out.println("3. Cập nhật danh mục");

						break;
					case 4:
						System.out.println("4. Xóa danh mục");
						System.out.println("Nhap ma Danh muc can xoa :");
						int xoa = scanner.nextInt();
						Category xoaCategory = new Category(xoa);
						category.remove(xoaCategory);
						break;
					case 5:
						check1 = true;
						break;
					default:
						System.err.println("vui long chon tu 1 ->5");
						break;
					}
					if (check1) {
						break;
					}
				} while (true);
				break;
			case 2:
				GeneralDAO<Product> product = factory.getDAO(Product.class);
				boolean check2 = false;
				do {
					System.out.println("________________Quản lý sản phẩm________________\r\n"
							+ "1. Hiển thị d/s sản phẩm (id, name, price, categoryName, status(ẩn/hiện)) \r\n"
							+ "2. Thêm mới sản phẩm\r\n" + "3. Cập nhật thông tin sản phẩm \r\n"
							+ "4. Xóa sản phẩm \r\n" + "5. Quay lại\r\n" + "");
					int chonSP = scanner.nextInt();
					scanner.nextLine();
					switch (chonSP) {
					case 1:
						System.out.println(
								"1. Hiển thị d/s sản phẩm (id, name, price, categoryName, status(ẩn/hiện))\\r\\n");
						System.out.format("%32s%16s%16s%16s%16s", "Id", "Name", "Price", "CategoryId", "Status");
						System.out.println("");
						for (Product pro : product.get()) {
							pro.displayData();
						}

					case 2:
						System.out.println("2. Thêm mới sản phẩm\r\n");
						 System.out.print("Nhập số sản phẩm cần thêm mới: ");
                         n = scanner.nextInt();
                         scanner.nextLine();
                         for (i = 0; i < n; i++) {
                             Product pro = new Product();
                             System.out.println("Nhập sản phẩm thứ " + (i + 1) + ": ");
                             pro.inputData();
                             product.add(pro);
                         }
						break;
					case 3:
						System.out.println("3. Cập nhật thông tin sản phẩm \r\n");
						break;
					case 4:
						System.out.println("4. Xóa sản phẩm \r\n");
						System.out.println("Nhap ma Danh muc can xoa :");
						String xoa = scanner.nextLine();
						Product xoaCategory = new Product(xoa);
						product.remove(xoaCategory);
						break;
					case 5:
						check2 = true;
						break;
					default:
						System.err.println("vui long chon tu 1 ->5");
						break;
					}
					if (check2) {
						break;
					}
				} while (true);
				break;
			case 3:
				System.exit(0);
			}
		}
	}
}
