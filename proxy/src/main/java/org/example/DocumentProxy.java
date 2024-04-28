package org.example;

// DocumentProxy class
class DocumentProxy implements Document {
    private Document document;

    private CurrentUser currentUser;
    private AccessControlService accessControlService;

    public DocumentProxy(Document document, AccessControlService accessControlService, CurrentUser currentUser) {
        this.document = document;
        this.accessControlService = accessControlService;
        this.currentUser = currentUser;
    }

    @Override
    public String getIdentifier() {
        return document.getIdentifier();
    }

    @Override
    public String getContent() {
        if (accessControlService.isAllowed(document.getIdentifier(), currentUser.getUsername())) {
            return document.getContent();
        } else {
            throw new AccessDeniedException("Access Denied!");
        }
    }

    @Override
    public String getCreationDate() {
        return document.getCreationDate();
    }
}
