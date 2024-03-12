package io.culturecurated.api.userlist.listitem;

public enum ItemCategory {
    TRAVEL("Travel"),
    MUSIC("Music"),
    TELEVISION("Television"),
    MOVIES("Movies"),
    FOOD("Food"),
    GAMING("Gaming"),
    SHOPPING("Shopping"),
    BOOKS("Books"),
    AUTOMOBILES("Automobiles"),
    ELECTRONICS("Electronics"),
    WEB("Web");

    private final String displayName;

    ItemCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    }
