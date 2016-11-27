package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

	private static CarService instance;

	public static CarService getInstance() {
		if (instance == null) {
			instance = new CarService();
		}
		return instance;
	}

	private List<Car> carList = new ArrayList<>();

	public CarService() {
		carList.add(new Car("George", "A5", 2010, "Germeny", "diesenel"));
		carList.add(new Car("John", "Sline", 2007, "Germany", "benzin"));
		carList.add(new Car("Ivan", "X5", 2006, "Germany", "diesel"));
		carList.add(new Car("George", "Skoda", 2005, "Chehia", "gas"));
		carList.add(new Car("John", "Merseces-Benz", 2003, "Germany", "benzin"));
		carList.add(new Car("Ivan", "MiniCooper", 2002, "Germany", "benzin"));
		carList.add(new Car("Svetlio", "X6", 2001, "Germany", "diesel"));
		
	}
	
	public List<Car> getCars() {
		return Collections.unmodifiableList(carList);
	}

	public void addCar(Car car) {
		carList.add(car);
	}
	
	public PagedResponseCar getCarsInPagesFiltered(int page, int perPage, String withName) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
				.filter((u) -> u.getName().equals(withName) || withName == null)
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());
		
		int totalPages = (int) Math.ceil(((double)carList.size()) / perPage);
		PagedResponseCar response = new PagedResponseCar(pageOfCars, page, totalPages);
	
		return response;
		
	}
	
	public List<String> getAllDistinctCarNames() {
		return carList.stream()
		.map((u) -> u.getName())
		.distinct()
		.collect(Collectors.toList());
	}
	
	public PagedResponseCar getCarsInPagesFilteredByModel(int page, int perPage, String withModel) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
				.filter((u) -> u.getModel().equals(withModel) || withModel == null)
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());
		
		int totalPages = (int) Math.ceil(((double)carList.size()) / perPage);
		PagedResponseCar response = new PagedResponseCar(pageOfCars, page, totalPages);
	
		return response;
	}
	
	public List<String> getAllDistinctCarModels() {
		return carList.stream()
		.map((u) -> u.getModel())
		.distinct()
		.collect(Collectors.toList());
	}

	public PagedResponseCar getCarsInPagesFilteredByYear(int page, int perPage, int withYear) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
				.filter((u) -> u.getYear() == (withYear))// || withYear == null)
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());
		
		int totalPages = (int) Math.ceil(((double)carList.size()) / perPage);
		PagedResponseCar response = new PagedResponseCar(pageOfCars, page, totalPages);
	
		return response;
	}
	
	public List<Integer> getAllDistinctCarYears() {
		return carList.stream()
		.map((u) -> u.getYear())
		.distinct()
		.collect(Collectors.toList());
	}

	public PagedResponseCar getCarsInPagesFilteredByCountry(int page, int perPage, String withCountry) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
				.filter((u) -> u.getProcudedWhere().equals(withCountry) || withCountry == null)
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());
		
		int totalPages = (int) Math.ceil(((double)carList.size()) / perPage);
		PagedResponseCar response = new PagedResponseCar(pageOfCars, page, totalPages);
	
		return response;
	}
	
	public List<String> getAllDistinctCarCountrys() {
		return carList.stream()
		.map((u) -> u.getProcudedWhere())
		.distinct()
		.collect(Collectors.toList());
	}
	
	public PagedResponseCar getCarsInPagesFilteredByFuel(int page, int perPage, String withFuel) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
				.filter((u) -> u.getFuel().equals(withFuel) || withFuel == null)
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());
		
		int totalPages = (int) Math.ceil(((double)carList.size()) / perPage);
		PagedResponseCar response = new PagedResponseCar(pageOfCars, page, totalPages);
	
		return response;
	}
	
	public List<String> getAllDistinctCarFuels() {
		return carList.stream()
		.map((u) -> u.getFuel())
		.distinct()
		.collect(Collectors.toList());
	}
	
	// reset the page
	
}
