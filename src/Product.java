
import java.util.Scanner;

public class Product {
	private String id;
	private String name;
	private float price;
	private int categoryId;
	private boolean status;

	public Product() {

	}
	
	public Product(String id) {
		this.id = id;
	}

	public Product(String id, String name, float price, int categoryId, boolean status) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public boolean setProductId(String productId) {
		try {
			for (Product item : ProductDAPImp.getdata()) {
				if (item.getId().equalsIgnoreCase(productId)) {
					System.err.println("ma san pham da ton tai !!! (nhap lai): ");
					return false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (productId.length() > 0) {
			this.id = productId;
			return true;
		} else {
			System.err.println("ma sản phẩm không được để trống ! ");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public boolean setProductName(String productName) {

		if (productName.length() > 0) {
			this.name = productName;
			return true;
		} else {
			System.err.println("tên sản phẩm không được để trống !  ");
			return false;
		}
	}

	public float getPrice() {
		return price;
	}

	public boolean setPrice(float importPrice) {
		if (importPrice > 1000) {
			this.price = importPrice;
			return true;
		} else {
			System.err.println("giá sản phẩm > 1000 !  ");
			return false;
		}
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap id san pham : ");
		while (true) {
			String reProductId = sc.nextLine();
			boolean check = setProductId(reProductId);
			if (check) {
				break;
			}
		}
		System.out.println("nhap ten san pham : ");
		while (true) {
			String reProductName = sc.nextLine();
			boolean check = setProductName(reProductName);
			if (check) {
				break;
			}
		}
		System.out.println("nhap gia nhap san pham : ");
		while (true) {
			try {
				float reImportPrice = Float.parseFloat(sc.nextLine());
				boolean check = setPrice(reImportPrice);
				if (check) {
					break;
				}
			} catch (Exception e) {
				System.err.println("nhap khong dung dinh dang !!! (nhap lai): ");
			}

			System.out.println("nhap trang thai san pham : ");
			String reStatus = sc.nextLine();
			this.status = Boolean.parseBoolean(reStatus);
			while (!(reStatus.equalsIgnoreCase("true") || reStatus.equalsIgnoreCase("false"))) {
				System.err.println("nhap true hoac false (nhap lai) : ");
				reStatus = sc.nextLine();
				this.status = Boolean.parseBoolean(reStatus);
			}
		}
	}

	String S = "";

	public String Status(boolean prdStatus) {
		if (prdStatus) {
			S = "Hiện";
		} else {
			S = "Ẩn";
		}
		return S;
	}

	public void displayData() {
		System.out.format("%32s%16s%16f%16d%16s",id,name,price,categoryId,Status(status));
        System.out.println("");

	}
}
