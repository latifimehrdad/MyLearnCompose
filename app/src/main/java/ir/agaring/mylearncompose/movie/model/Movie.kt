package ir.agaring.mylearncompose.movie.model

/**
 * Created by m-latifi on 7/19/2023.
 */

data class Movie(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String,
    val images: List<String>,
    val rating: String
)

fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            "1",
            "movie1",
            "1998",
            "action",
            "director1",
            "actor1",
            "A firs movie",
            "https://www.s921.ifilo.net/filo/video/TVRRd01TOHhNaTh5Tmc9PQ==/U0hKSmNqRmtaZz09/fxkr.jpg",
            listOf(
                "https://cdn.zoomg.ir/2023/2/2023-top-horror-movies.jpg",
                "https://www.digikala.com/mag/wp-content/uploads/2023/03/0-6.jpg"
            ),
            "7.9"
        ),
        Movie(
            "2",
            "movie2",
            "2000",
            "dram",
            "director2",
            "actor2",
            "A second movie",
            "https://metaraz.ir/wp-content/uploads/2022/06/American-action-movie.jpg",
            listOf(
                "https://www.rouydad24.ir/files/fa/news/1401/3/11/684345_613.png",
                "https://media.sarpoosh.com/images/9902/99-02-c36-105.jpg",
                "https://www.filimo.com/shot/wp-content/uploads/2022/08/John-WickChapter-4.jpg"
            ),
            "8.5"
        )
    )
}
