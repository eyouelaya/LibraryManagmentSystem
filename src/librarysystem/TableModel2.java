package librarysystem;

import business.Book;
import business.BookCopy;
import business.CheckOutRecordEntry;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.List;

public class TableModel2 extends AbstractTableModel {
    private List<CheckOutRecordEntry> checkOutRecordEntryList;
    private String[] columnNames = {"Book ISBN", "Book title", "Book Copy id", "Due date" };

    TableModel2(List<CheckOutRecordEntry> checkOutRecordEntryList) {
        this.checkOutRecordEntryList = checkOutRecordEntryList;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return checkOutRecordEntryList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CheckOutRecordEntry checkOutRecordEntry = checkOutRecordEntryList.get(rowIndex);

        BookCopy bookCopy = checkOutRecordEntry.getBookCopy();
        Book book = bookCopy.getBook();

if (columnIndex == 0) {
        return book.getIsbn();
        } else if (columnIndex == 1) {
        return book.getTitle();
        } else if (columnIndex == 2) {
        return bookCopy.getCopyNum();
        } else  {
//    LocalDate dueDate = LocalDate.of(2020,1,11);
//    return dueDate;
    return checkOutRecordEntry.getDueDate();
        }

    }

}
