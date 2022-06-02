package library;

import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryItem> holdings;
    private ArrayList<Patron> members;
    private int current_date;

    public Library() {
        this.holdings = new ArrayList<>();
        this.members = new ArrayList<>();
        this.current_date = 0;
    }

    public ArrayList<LibraryItem> get_holdings() {
        return this.holdings;
    }

    public int get_current_date() {
        return this.current_date;
    }

    public String add_library_item(LibraryItem item) {
        this.holdings.add(item);
        return "Item added successfully!";
    }

    public String add_patron(Patron patron) {
        this.members.add(patron);
        return "Patron added successfully!";
    }

    public LibraryItem  lookup_library_item_from_id(int item_id) {
        for (LibraryItem holding : this.holdings) {
            if (holding.get_library_item_id() == item_id) {
                return holding;
            }
        }
        return null;
    }

    public Patron lookup_patron_from_id(int patron_id) {
        for (Patron patron : this.members) {
            if (patron.get_patron_id() == patron_id) {
                return patron;
            }
        }
        return null;
    }

    public String check_out_library_item(int patron_id, int library_id) {
        Patron patron = lookup_patron_from_id(patron_id);
        LibraryItem item = lookup_library_item_from_id(library_id);


        if (patron == null) {
            return "Patron not found!";
        } else if (item == null) {
            return "Invalid item!";
        } else if (item.get_location() == "CHECKED_OUT") {
            return "Item is currently checked out!";
        } else if (item.get_location() == "ON_HOLD_SHELF"
                && item.get_requested_by() != patron_id)  {
            return "Item is on hold for another member!";
        } else {
            if (item.get_requested_by() == patron_id) {
                item.set_requested_by(0);
            }
            item.set_location("CHECKED_OUT");
            item.set_checked_out_by(patron_id);
            patron.set_checked_out_items(item);
        }
        return "Checkout successful!";
    }

    public String return_library_item(int item_id) {
        LibraryItem item = this.lookup_library_item_from_id(item_id);

        if (item == null) {
            return "Item not found!";
        } else if (item.get_location() == "ON_SHELF") {
            return "Item already in library!";
        } else if (item.get_location() == "CHECKED_OUT") {
            Patron patron = this.lookup_patron_from_id(item.get_checked_out_by());
            if (patron == null) {
                return "Patron not found";
            } else {
                patron.remove_library_item(item);
                item.set_checked_out_by(0);
                if (item.get_requested_by() != 0) {
                    item.set_location("ON_HOLD_SHELF");
                } else {
                    item.set_location("ON_SHELF");
                }
            }
        }
        return "Item returned successfully!";
    }

    public String request_library_item(int patron_id, int item_id) {
        Patron patron = this.lookup_patron_from_id(patron_id);
        LibraryItem item = this.lookup_library_item_from_id(item_id);
        String location = item.get_location();
        if (patron == null) {
            return "Patron not found";
        } else if (item == null) {
            return "Item not found! Invalid item!";
        } else if (location == "ON_HOLD_SHELF"
                && item.get_requested_by() != patron_id) {
            return "Item on hold for another patron!";
        } else {
            if (item.get_requested_by() == 0) {
                item.set_requested_by(patron_id);
            }
            if (item.get_location() == "ON_SHELF") {
                item.set_location("ON_HOLD_SHELF");
            }
        }
        return "Hold request successful!";
    }
}
