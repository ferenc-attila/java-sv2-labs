package stringconcat.nameconcat;

public class Name {

    String familyName;
    String middleName;
    String givenName;
    Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;
    }

    public String concatNameWesternStyle() {
        String name;
        if (title == null) {
            name = givenName;
            name += " ";
        } else {
            name = title.getTitle();
            name += " ";
            name += givenName;
            name += " ";
        }

        if ("".equals(middleName) || middleName.equals(null)) {
            name += familyName;
        } else {
            name += middleName;
            name += " ";
            name += familyName;
        }
        return name;
    }

    public String concatNameHungarianStyle() {
        String name;
        if (title == Title.DR) {
            name = title.getTitle().concat(" ");
            name = name.concat(familyName);
            name = name.concat(" ");
        } else {
            name = familyName.concat(" ");
        }

        if ("".equals(middleName) || middleName.equals(null)) {
            name = name.concat(givenName);
        } else {
            name = name.concat(middleName);
            name = name.concat(" ");
            name = name.concat(givenName);
        }
        return name;
    }
}
