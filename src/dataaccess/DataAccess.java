package dataaccess;

import java.util.HashMap;
import java.util.List;

import business.Book;
import business.BookCopy;
import business.CheckOutRecordEntry;
import business.LibraryMember;
import dataaccess.DataAccessFacade.StorageType;

public interface DataAccess { 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();

	//any database interaction include here
	public void saveNewMember(LibraryMember libraryMember);
	public void saveNewBook(Book book);
	public void saveNewBookCopy(BookCopy bookCopy);
	public boolean searchMember(String memberId);
	public Book searchBook(String isbn);
	public int getMaximumCheckoutLength(String isbn);
	public BookCopy nextAvailableBookCopy(String isbn );
	public void saveMemberCheckoutRecord(String memberId, CheckOutRecordEntry entry);
	public Auth verifyUser(int id, String password);
	public List<CheckOutRecordEntry> getCheckOutRecord(String memberId);
}