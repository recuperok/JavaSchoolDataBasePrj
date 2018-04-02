package holders;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TextBook implements Serializable {
	private double dblPrice;
	private String strTitle, strIsbn, strAuthor, strImgCover;;
	
	public TextBook(double dblPrice, String strTitle, String strIsbn, String strAuthor, String strImgCover) {
		super();
		this.strImgCover = strImgCover;
		this.dblPrice = dblPrice;
		this.strTitle = strTitle;
		this.strIsbn = strIsbn;
		this.strAuthor = strAuthor;
	}

	public String getStrImgCover() {
		return strImgCover;
	}
	public void setStrImgCover(String strImgCover) {
		this.strImgCover = strImgCover;
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