package holders;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TextBook implements Serializable {
	private double dblPrice;
	private String imgCover;
	private String strTitle, strIsbn, strAuthor;

	public TextBook(double dblPrice, String strTitle, String strIsbn, String strAuthor,String imgCover) {
		super();
		this.imgCover = imgCover;
		this.dblPrice = dblPrice;
		this.strTitle = strTitle;
		this.strIsbn = strIsbn;
		this.strAuthor = strAuthor;
	}

	public String getImgCover() {
		return imgCover;
	}

	public void setImgCover(String imgCover) {
		this.imgCover = imgCover;
	}

	public double getDblPrice() {
		return dblPrice;
	}
	
	public void setTitle(String strTitle) {
		this.strTitle = strTitle;
	}
	public String getTitle() {
		return this.strTitle;
	}
	
	public void setIsbn(String strIsbn) {
		this.strIsbn = strIsbn;
	}
	public String getIsbn() {
		return this.strIsbn;
	}
	
	public void setAuthor(String strAuthor) {
		this.strAuthor = strAuthor;
	}
	public String getAuthor() {
		return this.strAuthor;
	}

	@Override
	public String toString() {
		return "TextBook [Price=" + dblPrice + ", strTitle=" + strTitle + ", strIsbn=" + strIsbn + ", strAuthor="
				+ strAuthor + "]";
	}
	
}