public class Song {
    String title ;
    Double duration ;
    public Song (String title , double duration) {
        this.title = title;
        this.duration = duration;
    }
    public Song () {
    }

    public String getTitle() {
        return title;
    }
    public Double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return  "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
}
}
