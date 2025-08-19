package hu.nmovie.main.exception;

public class NMovieNotFoundException extends RuntimeException{
	
	public NMovieNotFoundException(Long id) {
		super("Nincs ilyen film ezzel az azonosítóval!" + id);
	}
	
}
