package business;

import java.util.ArrayList;
import java.util.List;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import librarysystem.*;

import javax.swing.*;
import java.time.LocalDate;

public class SystemController {

	private static SystemController instance;
	private DataAccess dataAccess = new DataAccessFacade();
	private List<Author> authorsList;

	private SystemController() {
	}

	public static SystemController getInstance() {
		if (instance == null) instance = new SystemController();
		return instance;
	}

	public void addMember(String memberNo, String firstName, String lastName, String phoneNumber,
						  String state, String city, String street, String zip) {
		try {
			int memberId = Integer.parseInt(memberNo);
			int zipCode = Integer.parseInt(zip);
			int phone = Integer.parseInt(phoneNumber);

			Address address = new Address(state, city, street, zip);
			LibraryMember libraryMember = new LibraryMember(memberNo, firstName, lastName, phoneNumber, address);

			dataAccess.saveNewMember(libraryMember);
			JOptionPane.showMessageDialog(null, "Member id added");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Member Id, Zip and phoneNumber should be a number");
		}


	}


	public void checkOutBook(String memberId, String isbn, CheckOutUIForm checkOutUIForm) {

		Book book = dataAccess.searchBook(isbn);

		if (dataAccess.searchMember(memberId) && book != null) {

			BookCopy availableBookCopy = dataAccess.nextAvailableBookCopy(isbn);

			if (availableBookCopy == null) {
				checkOutUIForm.displayBookUnavailable();
			} else {

				LocalDate todaysDate = LocalDate.now();
				int checkOutLength = dataAccess.getMaximumCheckoutLength(isbn);
				LocalDate dueDate = todaysDate.plusDays(checkOutLength);

				CheckOutRecordEntry checkoutRecordEntry = new CheckOutRecordEntry(todaysDate, dueDate, availableBookCopy);
				availableBookCopy.changeAvailability();

				dataAccess.saveMemberCheckoutRecord(memberId, checkoutRecordEntry);
				checkOutUIForm.displayCheckoutSuccess();

			}

		} else if (!dataAccess.searchMember(memberId)) {
			checkOutUIForm.displayMemberUnavailable();

		} else if (dataAccess.searchBook(isbn) == null) {
			checkOutUIForm.displayBookUnavailable();
		}

	}


	public void addBookCopy(String isbn, int copyNumber) {

		Book book = dataAccess.searchBook(isbn);
		if (book != null) {
			BookCopy bookCopy = new BookCopy(book,book.getNumCopies());
			for(int i=0 ; i<copyNumber; i++)
				book.addCopy();
			dataAccess.saveNewBookCopy(book);
			JOptionPane.showMessageDialog(null, "Book copy added");
		} else {
			JOptionPane.showMessageDialog(null, "The book is not found.");
		}

	}

	public void searchCheckOutRecords(String memberId, CheckoutRecordPrintUI checkoutRecordPrintUI) {

		boolean found = dataAccess.searchMember(memberId);

		if(found) {

			List<CheckOutRecordEntry> recordEntries = dataAccess.getCheckOutRecord(memberId);

			if(recordEntries == null) {
				checkoutRecordPrintUI.displayNoRecordsFound();
			}else {
				checkoutRecordPrintUI.showRecords(recordEntries);
			}


		}else {
			checkoutRecordPrintUI.displayUserNotFound();
		}


	}

	public void addBook(String title, String isbn, List<Author> authors) {
		Book book = new Book(isbn, title, 10, authors);
		if(dataAccess.searchBook(isbn) !=null){
			JOptionPane.showMessageDialog(null, "Book already exists please go to Add Book copy to add more copies");
		}
		else if(authors.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter an Author for the book");
		}else{
			dataAccess.saveNewBook(book);
			JOptionPane.showMessageDialog(null, "Book Added Successfully");
		}
	}

	public List<Author> getAuthorsList() {
		if (authorsList == null) return new ArrayList<>();
		return authorsList;
	}

	public void addAuthors(Author author) {
		if (authorsList == null) authorsList = new ArrayList<>();
		String telephone = author.getTelephone();
		String zip = author.getAddress().getZip();
		try{
			Integer.parseInt(telephone);
			Integer.parseInt(zip);
			authorsList.add(author);
		}catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Phone number & Zip code must be a numbers.");
		}

	}

	public void login(int id, String password, LoginWindow loginWindow) {
		Auth role = dataAccess.verifyUser(id, password);
		if (role == null)
			loginWindow.displayLoginError();
		else {
			loginWindow.login(role);
		}
	}

}
