import java.util.ArrayList;
import java.util.List;

public class ProductDAPImp implements GeneralDAO<Product> {
	private static List<Product> data = new ArrayList<Product>();
	private static final ProductDAPImp instance = new ProductDAPImp();

	private ProductDAPImp() {
	}

	public static ProductDAPImp getInstance() {
		return instance;
	}

	public static List<Product> getdata() {
		return data;
	}

	@Override
	public List<Product> get() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public List<Product> getByName(String name) {
		List<Product> getByName = new ArrayList<>();
        for (int i =0;i<data.size();i++){
            if(data.get(i).getName().equalsIgnoreCase(name)){
                getByName.add(data.get(i));
            }
        }
        return getByName;
	}

	@Override
	public Product findId(Product id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Product entity) {
		if(data.add(entity)) {
			System.out.println("Them moi thanh cong");
			return true;
		}else {
			System.out.println("Them moi khong thanh cong ");
			return false;
		}
		
	}
	@Override
	public boolean edit(Product entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Product entity) {
		if(data.remove(entity)) {
			System.out.println("Xoa thanh cong");
			return true;
		}else {
			System.out.println("Xoa khong thanh cong ");
			return false;
		}
	}

	

}
