package org.pg4200.ex06;

import java.util.Arrays;
import java.util.List;

public class ImmutableBookImp implements ImmutableBook{
    private final String title;
    private final int year;

    private final List<ImmutableAuthor> authors;

    public ImmutableBookImp(){
        this(null,0, null);
    }

    public ImmutableBookImp(String title, int year, List<ImmutableAuthor> authors) {
        this.title = title;
        this.year = year;
        this.authors = authors;
    }

    /**
     * @param title
     * @return a copy of this Book, but with different title
     */
    @Override
    public ImmutableBook withTitle(String title) {
        return new ImmutableBookImp(title, year, authors);
    }

    /**
     * @param year
     * @return a copy of this Book, but with different year
     */
    @Override
    public ImmutableBook withYear(int year) {
        return new ImmutableBookImp(title, year, authors);
    }

    /**
     * @param authors
     * @return a copy of this Book, but with different authors
     */
    @Override
    public ImmutableBook withAuthors(List<ImmutableAuthor> authors) {
        return new ImmutableBookImp(title, year, authors);
    }

    /**
     * @param authors
     * @return a copy of this Book, but with different authors
     */
    @Override
    public ImmutableBook withAuthors(ImmutableAuthor... authors) {
        return new ImmutableBookImp(title, year, Arrays.asList(authors));
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public List<ImmutableAuthor> getAuthors() {
        return authors;
    }
}
