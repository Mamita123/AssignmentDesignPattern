package org.example;

public class RealDocument implements Document{
    private String identifier;
    private String content;
    private String creationDate;

    public RealDocument(String identifier, String content, String creationDate){
        this.identifier = identifier;
        this.content = content;
        this.creationDate = creationDate;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }


}
