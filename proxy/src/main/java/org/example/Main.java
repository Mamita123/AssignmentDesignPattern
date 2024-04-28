package org.example;

/*public class Main {
    public static void main(String[] args) {
        // Create documents
        Document doc1 = new RealDocument("doc1", "Content of Document 1", "2024-01-01");
        Document doc2 = new RealDocument("doc2", "Content of Document 2", "2024-01-02");

        // Create AccessControlService
        AccessControlService accessControlService = new AccessControlService();

        // Create a user
        User currentUser = new User("user1");

        // Create DocumentProxy objects
        DocumentProxy documentProxy1 = new DocumentProxy(doc1, accessControlService, currentUser);
        DocumentProxy documentProxy2 = new DocumentProxy(doc2, accessControlService, currentUser);

        // Create Library
        Library library = new Library();
        library.addDocument(doc1.getIdentifier(), documentProxy1);
        library.addDocument(doc2.getIdentifier(), documentProxy2);

        // Try to access documents
        try {
            System.out.println("Document 1 Content: " + library.getDocument("doc1").getContent());
            System.out.println("Document 2 Content: " + library.getDocument("doc2").getContent());
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}*/
// Main class
/*public class Main {
    public static void main(String[] args) {
        // Create AccessControlService (Singleton)
        AccessControlService accessControlService = AccessControlService.getInstance();

        // Add access rules
        accessControlService.grantAccess("document1", "user1");
        accessControlService.grantAccess("document2", "admin");

        // Create Library
        Library library = new Library(accessControlService);

        // Add documents to the library
        library.addDocument("document1", new RealDocument("document1", "Content of Document 1", "2024-01-01"));
        library.addProtectedDocument("document2", "Content of Document 2", "2024-01-02");

        // Set current user
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setUsername("user1");

        // Try to access documents
        try {
            Document doc1 = library.getDocument("document1");
            System.out.println("Document 1 Content: " + doc1.getContent());
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        currentUser.setUsername("admin");

        try {
            Document doc2 = library.getDocument("document2");
            System.out.println("Document 2 Content: " + doc2.getContent());
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}*/
public class Main {
    public static void main(String[] args) {
        // Create AccessControlService (Singleton)
        AccessControlService accessControlService = AccessControlService.getInstance();

        // Add access rules
        accessControlService.grantAccess("document1", "user1");
        accessControlService.grantAccess("document2", "admin");

        // Create Library
        Library library = new Library(accessControlService);

        // Add documents to the library
        library.addDocument("document1", new RealDocument("document1", "Content of Document 1", "2024-01-01"));

        // Get an instance of CurrentUser
        CurrentUser currentUser = CurrentUser.getInstance();

        // Set current user username
        currentUser.setUsername("user1");

        // Add protected document with CurrentUser
        library.addProtectedDocument("document2", "Content of Document 2", "2024-01-02", currentUser);

        // Set current user
        currentUser.setUsername("user1");

        // Try to access documents
        try {
            Document doc1 = library.getDocument("document1");
            System.out.println("Document 1 Content: " + doc1.getContent());
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        // Change current user to admin
        currentUser.setUsername("admin");

        // Try to access documents
        try {
            Document doc2 = library.getDocument("document2");
            System.out.println("Document 2 Content: " + doc2.getContent());
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
