package org.example.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recommendation implements Cloneable{
    private String targetAudience;
    private List<Book> bookList;

    //Constructor
    public Recommendation(String targetAudience){
        this.targetAudience = targetAudience;
        this.bookList = new ArrayList<>();
    }
    //Add book to recommendation list
    public void addBook(Book book){
        bookList.add(book);

    }
    //Remove book from recommendation list
    public void removeBook(Book book){
        bookList.remove(book);

        }

    //change target audience
    public void setTargetAudience(String targetAudience){
        this.targetAudience = targetAudience;
    }

    //Clone method for deep cloning of the recommendation object
    @Override
    public Recommendation clone(){
        try{
            Recommendation clonedRecommendation = (Recommendation) super.clone();
            //Deep clone the book list
            clonedRecommendation.bookList = new ArrayList<>();
            for (Book book : this.bookList){
                clonedRecommendation.bookList.add(book.clone());
            }
            return clonedRecommendation;
        }catch (CloneNotSupportedException e){
            //Handle clone not supported exception
            return null;
        }
    }
    @Override
    public String toString(){
        return "Recommendation{" +
                "targetAudience='" + targetAudience + '\'' +
                ", bookList=" + bookList + '}';
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if ( o == null || getClass() != o.getClass()) return false;
        Recommendation that = (Recommendation) o;
        return Objects.equals(targetAudience, that.targetAudience)&&
                Objects.equals(bookList, that.bookList);
    }
    @Override
    public int hashCode(){
        return Objects.hash(targetAudience, bookList);
    }
}
