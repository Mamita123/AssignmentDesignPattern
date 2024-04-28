package org.example;


/*public class AccessControlService {
    // Dummy method, replace with actual access control logic
    public boolean isAllowed(String documentIdentifier, String username) {
        // Check if the document identifier matches a predefined rule
        // For example, allow access only to documents with specific identifiers
        if (documentIdentifier.equals("doc1")) {
            // Allow access for specific users
            return username.equals("user1") || username.equals("admin");
        } else if (documentIdentifier.equals("doc2")) {
            // Allow access for all users
            return true;
        } else {
            // Deny access for all other documents
            return false;
        }
    }
}*/

import java.util.HashSet;
import java.util.Set;

// AccessControlService class (Singleton)
class AccessControlService {
    private static AccessControlService instance;
    private Set<String> accessRules;

    private AccessControlService() {
        accessRules = new HashSet<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public boolean isAllowed(String documentIdentifier, String username) {
        return accessRules.contains(username + "-" + documentIdentifier);
    }

    public void grantAccess(String documentIdentifier, String username) {
        accessRules.add(username + "-" + documentIdentifier);
    }
}
