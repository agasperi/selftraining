import java.util.List;

public class Portafolio {
	private StockService stockService;
	private List<Stock> stocks;

	public StockService getStockService() {
		return stockService;
	}
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public double getMarketValue(){
		return stocks.stream()
				.map(stock -> stockService.getPrice(stock) * stock.getQuantity())
				.reduce(0.0,(x,y)->x+y);
	}
}
