public class Record implements Comparable<Record> {

    //Implement a private memeber variable called genre to hold the genre string
    private String genre;
    //Implement a private member called year to hold year int
    private int year;
    //Implement a private variable called artist to hold str
    private String artist;
    //Implement a private variable callee title to hold str
    private String title;

    //Create a constructor that takes three strings and an integer as arguments (in the same
    //order as above) and sets the appropriate member variables.
    public Record(String genre, int year, String artist, String title) {

        this.genre = genre;
        this.year = year;
        this.artist = artist;
        this.title = title;

    }

    //getGenre() returns the genre of the record
    public String getGenre() { return genre; }
    //getYear() returns the year the record was released
    public int getYear() { return year; }
    //getArtist() returns the record artist
    public String getArtist() { return artist; }
    //getTitle() returns the title or the record
    public String getTitle() { return title; }
    //toString() overrides the default java toString method to give a string representation of the record
    @Override
    public String toString() {
        //(like this) "Pop rock  |  1977  |  Fleetwood Mac  |  Rumours”
        return genre + "  |  " + year + "  |  " + artist + "  |  " + title;
    }


    //compareTo(Record other) compares this object with the specified object for order
    //Check Assignment part 1 for more
    @Override
    public int compareTo(Record other) {

        int genrecompare = this.genre.compareTo(other.genre);
        if (genrecompare != 0) {
            return genrecompare;
        }

        //Second sort key (Year - Earliest first)
        int yearcompare = Integer.compare(this.year, other.year);
        if (yearcompare != 0) {
            return yearcompare;
        }

        //Third sort key (Arist - alphabetical)
        int artcompare = this.artist.compareTo(other.artist);
        if (artcompare != 0) {
            return artcompare;
        }

        //Final Tie-breaker sort key (Title - alphabetical)
        int titlecompare = this.title.compareTo(other.title);
        if (titlecompare != 0) {
            return titlecompare;
        }


        return 0;
    }


}

