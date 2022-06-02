package library;

public class LibraryItem {
    private int library_item_id;
    private String title;
    private String location;
    private int checked_out_by;
    private int requested_by;


    //Constructor
    public LibraryItem(int id, String title) {
        this.library_item_id = id;
        this.title = title;
        this.location = "ON_SHELF";
        this.checked_out_by = 0;
        this.requested_by = 0;
    }

    public int get_library_item_id() {
        return this.library_item_id;
    }

    public String get_location() {
        return this.location;
    }

    public int get_checked_out_by() {
        return this.checked_out_by;
    }

    public int get_requested_by() {
        return this.requested_by;
    }

    public void set_location(String value) {
        this.location = value;
    }

    public void set_checked_out_by(int patron_id) {
        this.checked_out_by = patron_id;
    }

    public void set_requested_by(int patron_id) {
        this.requested_by = patron_id;
    }
}
