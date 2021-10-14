import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class PortafolioTester {
	Portafolio portafolio;
	StockService stockService;

	public static void main(String[] args) {
		PortafolioTester tester = new PortafolioTester();
		tester.setUp();
		System.out.println(tester.testMarketValue()?"pass":"fail");
	}

	private void setUp() {
		portafolio = new Portafolio();
		stockService = mock(StockService.class);
		portafolio.setStockService(stockService);
	}
	
	private boolean testMarketValue() {
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1","Google", 10);
		Stock microsoftStock = new Stock("2","Microsoft",100);
		
		stocks.add(googleStock);
		stocks.add(microsoftStock);
		
		portafolio.setStocks(stocks);
		when(stockService.getPrice(googleStock)).thenReturn(50.00);
		when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);
		
		double marketValue = portafolio.getMarketValue();
		return marketValue == 100500.0;
	}

}
