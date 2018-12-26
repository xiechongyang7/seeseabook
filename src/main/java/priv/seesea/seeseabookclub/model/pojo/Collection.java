package priv.seesea.seeseabookclub.model.pojo;

import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 收藏
 * 
 * @author http://blog.csdn.net/thewaiting
 *
 */
@Component
@Scope(scopeName = "prototype")
@Alias(value = "userCollection")
public class Collection {

	private String collectionId;
	private String collectionUserId;
	private String collectionBookId;

	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}

	public String getCollectionUserId() {
		return collectionUserId;
	}

	public void setCollectionUserId(String collectionUserId) {
		this.collectionUserId = collectionUserId;
	}

	public String getCollectionBookId() {
		return collectionBookId;
	}

	public void setCollectionBookId(String collectionBookId) {
		this.collectionBookId = collectionBookId;
	}

	private String collectionFolder;




	public String getCollectionFolder() {
		return collectionFolder;
	}

	public void setCollectionFolder(String collectionFolder) {
		this.collectionFolder = collectionFolder;
	}

}
