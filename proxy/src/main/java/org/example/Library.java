package org.example;

import java.util.HashMap;

/*public class Library {
    private HashMap<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addDocument(String identifier, Document document) {
        documents.put(identifier, document);
    }

    public Document getDocument(String identifier) {
        return documents.get(identifier);
    }
}*/
/*class Library {
    private HashMap<String, Document> documents;
    private AccessControlService accessControlService;

    public Library(AccessControlService accessControlService) {
        documents = new HashMap<>();
        this.accessControlService = accessControlService;
    }

    public void addDocument(String identifier, Document document) {
        documents.put(identifier, document);
    }

    public void addProtectedDocument(String identifier, String content, String creationDate) {
        RealDocument realDocument = new RealDocument(identifier, content, creationDate);
        DocumentProxy documentProxy = new DocumentProxy(realDocument, accessControlService);
        addDocument(identifier, documentProxy);
    }

    public Document getDocument(String identifier) {
        return documents.get(identifier);
    }
}*/


import java.util.HashMap;

public class Library {
    private HashMap<String, Document> documents;
    private AccessControlService accessControlService;

    public Library(AccessControlService accessControlService) {
        documents = new HashMap<>();
        this.accessControlService = accessControlService;
    }

    public void addDocument(String identifier, Document document) {
        documents.put(identifier, document);
    }

    public void addProtectedDocument(String identifier, String content, String creationDate, CurrentUser currentUser) {
        RealDocument realDocument = new RealDocument(identifier, content, creationDate);
        DocumentProxy documentProxy = new DocumentProxy(realDocument, accessControlService, currentUser);
        addDocument(identifier, documentProxy);
    }

    public Document getDocument(String identifier) {
        return documents.get(identifier);
    }
}
