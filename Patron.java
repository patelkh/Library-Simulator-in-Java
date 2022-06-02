package library;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private int patron_id;
    private String name;
    private ArrayList<LibraryItem> checked_out_items;
    private float fine_amount;

    //Constructor
    public Patron(int id, String name) {
        this.patron_id = id;
        this.name = name;
        this.checked_out_items = new ArrayList<LibraryItem>();
    }

    public float get_fine_amount() {
        return this.fine_amount;
    }
    public int get_patron_id() { return this.patron_id; }
    public ArrayList<LibraryItem> get_checked_out_items() {
        return this.checked_out_items;
    }
    public void set_checked_out_items(LibraryItem item) { this.checked_out_items.add(item); };
    public void remove_library_item(LibraryItem item) {
        this.checked_out_items.remove(item);
    }
}
