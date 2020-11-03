package com.company;

public class BookInformation {

    private String Title;
    private String Publisher;
    private String Writer;
    private String PublishedYear;
    private String Price;
    private String BookState;
    private String ISBNNumber;
    private String SellerID;
    private String SellerEmail;

    public BookInformation(){}

    public BookInformation(String line){
        String[] tokens = line.split(",");
        this.parsing(tokens);
    }//BookList에서 책 정보 받아오기

    public void parsing(String[] tokens){

        this.Title = tokens[0].trim();
        this.Publisher = tokens[1].trim();
        this.Writer = tokens[2].trim();
        this.PublishedYear = tokens[3].trim();
        this.Price = tokens[4].trim();
        this.BookState = tokens[5].trim();
        this.ISBNNumber = tokens[6].trim();
        this.SellerID = tokens[7].trim();
        this.SellerEmail = tokens[8].trim();
    }//BookList에서 받아온 책 정보 파트별로 나누기

    //책 정보에 대한 저장 및 return
    public String getTitle(){
        return Title;
    }

    public void setTitle(String Title){
        this.Title = Title;
    }

    public String getPublisher(){
        return Publisher;
    }

    public void setPublisher(String Publisher){
        this.Publisher = Publisher;
    }

    public String getWriter(){
        return Writer;
    }

    public void setWriter(String Writer){
        this.Writer = Writer;
    }

    public String getPublishedYear(){
        return PublishedYear;
    }

    public void setPublishedYear(String PublishedYear) {
        this.PublishedYear = PublishedYear;
    }

    public String getPrice(){
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getBookState(){
        return BookState;
    }

    public void setBookState(String BookState) {
        this.BookState = BookState;
    }

    public String getISBNNumber(){
        return ISBNNumber;
    }

    public void setISBNNumber(String ISBNNumber) {
        this.ISBNNumber = ISBNNumber;
    }

    public String getSellerID(){
        return SellerID;
    }

    public void setSellerID(String SellerID) {
        this.SellerID = SellerID;
    }

    public String getSellerEmail(){
        return SellerEmail;
    }

    public void setSellerEmail(String SellerEmail) {
        this.SellerEmail = SellerEmail;
    }
}
