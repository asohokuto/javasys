package jp.abkc;

public class Juice {
	private String name;
	private int price;

	public Juice(String name,int price) {
		this.name = name;
		this.price = price;
	}
	public Juice() {//引数なしのコンストラクタのデフォルトを設定している
		this("",0);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
