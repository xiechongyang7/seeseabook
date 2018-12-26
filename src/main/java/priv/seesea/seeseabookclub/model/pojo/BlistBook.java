package priv.seesea.seeseabookclub.model.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 书单收藏书的从表
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
public class BlistBook {

	/**
	 * 书单主键
	 */
	private String blistBookId;
	/**
	 * 书单的id
	 */
	private String blistBookBlistId;
	/**
	 * 书单收藏书id
	 */
	private String blistBookBookId;

	/**
	 *级练到书籍
	 */
	private List<Book> bookList;

	/**
	 * 级联到书单
	 */
	private List<Blist> blists;

	public List<Blist> getBlists() {
		return blists;
	}

	public void setBlists(List<Blist> blists) {
		this.blists = blists;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public String getBlistBookId() {
		return blistBookId;
	}

	public void setBlistBookId(String blistBookId) {
		this.blistBookId = blistBookId;
	}

	public String getBlistBookBlistId() {
		return blistBookBlistId;
	}

	public void setBlistBookBlistId(String blistBookBlistId) {
		this.blistBookBlistId = blistBookBlistId;
	}

	public String getBlistBookBookId() {
		return blistBookBookId;
	}

	public void setBlistBookBookId(String blistBookBookId) {
		this.blistBookBookId = blistBookBookId;
	}

	@Override
	public String toString() {
		return "BlistBook{" +
				"blistBookId=" + blistBookId +
				", blistBookBlistId=" + blistBookBlistId +
				", blistBookBookId=" + blistBookBookId +
				", bookList=" + bookList +
				", blists=" + blists +
				'}';
	}

}
