package org.pg4200.ex06;

public class ImmutableAuthorImp implements ImmutableAuthor{
    private final String name;
    private final String surname;

    public ImmutableAuthorImp(){
        this.name = null;
        this.surname = null;
    }

    public ImmutableAuthorImp(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * @param name
     * @return a copy of this Author, but with different name
     */
    @Override
    public ImmutableAuthor withName(String name) {
        return new ImmutableAuthorImp(name, surname);
    }

    /**
     * @param surname
     * @return a copy of this Author, but with different surname
     */
    @Override
    public ImmutableAuthor withSurname(String surname) {
        return new ImmutableAuthorImp(name, surname);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }
}
