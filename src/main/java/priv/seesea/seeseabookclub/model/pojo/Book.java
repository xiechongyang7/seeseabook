package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 书籍
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class Book implements Serializable {

	private String bookId;
	private String bookUserId;
	private String bookName;
	private String bookAuthor;
	private String bookIntroduce;
	private String bookCatalog;
	private Integer bookValue;
	private Double bookMark;
	private String bookTag;
	private Date bookReplace;
	private String bookRemark;
	private Integer bookStatu;
	private String bookCover;
	private Integer bookFirstClassify;
	private Integer bookSecondClassify;
	private Integer bookThirdClassify;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookUserId() {
		return bookUserId;
	}

	public void setBookUserId(String bookUserId) {
		this.bookUserId = bookUserId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookIntroduce() {
		return bookIntroduce;
	}

	public void setBookIntroduce(String bookIntroduce) {
		this.bookIntroduce = bookIntroduce;
	}

	public String getBookCatalog() {
		return bookCatalog;
	}

	public void setBookCatalog(String bookCatalog) {
		this.bookCatalog = bookCatalog;
	}

	public Integer getBookValue() {
		return bookValue;
	}

	public void setBookValue(Integer bookValue) {
		this.bookValue = bookValue;
	}

	public Double getBookMark() {
		return bookMark;
	}

	public void setBookMark(Double bookMark) {
		this.bookMark = bookMark;
	}

	public String getBookTag() {
		return bookTag;
	}

	public void setBookTag(String bookTag) {
		this.bookTag = bookTag;
	}

	public Date getBookReplace() {
		return bookReplace;
	}

	public void setBookReplace(Date bookReplace) {
		this.bookReplace = bookReplace;
	}

	public String getBookRemark() {
		return bookRemark;
	}

	public void setBookRemark(String bookRemark) {
		this.bookRemark = bookRemark;
	}

	public Integer getBookStatu() {
		return bookStatu;
	}

	public void setBookStatu(Integer bookStatu) {
		this.bookStatu = bookStatu;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

	public Integer getBookFirstClassify() {
		return bookFirstClassify;
	}

	public void setBookFirstClassify(Integer bookFirstClassify) {
		this.bookFirstClassify = bookFirstClassify;
	}

	public Integer getBookSecondClassify() {
		return bookSecondClassify;
	}

	public void setBookSecondClassify(Integer bookSecondClassify) {
		this.bookSecondClassify = bookSecondClassify;
	}

	public Integer getBookThirdClassify() {
		return bookThirdClassify;
	}

	public void setBookThirdClassify(Integer bookThirdClassify) {
		this.bookThirdClassify = bookThirdClassify;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bookId=" + bookId +
				", bookUserId=" + bookUserId +
				", bookName='" + bookName + '\'' +
				", bookAuthor='" + bookAuthor + '\'' +
				", bookIntroduce='" + bookIntroduce + '\'' +
				", bookCatalog='" + bookCatalog + '\'' +
				", bookValue=" + bookValue +
				", bookMark=" + bookMark +
				", bookTag='" + bookTag + '\'' +
				", bookReplace=" + bookReplace +
				", bookRemark='" + bookRemark + '\'' +
				", bookStatu=" + bookStatu +
				", bookCover='" + bookCover + '\'' +
				", bookFirstClassify=" + bookFirstClassify +
				", bookSecondClassify=" + bookSecondClassify +
				", bookThirdClassify=" + bookThirdClassify +
				'}';
	}
}
