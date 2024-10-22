class Document {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public DocumentVersion save() {
        return new DocumentVersion(content);
    }

    public void restore(DocumentVersion version) {
        content = version.getContent();
    }
}

class DocumentVersion {
    private String content;

    public DocumentVersion(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class VersionControl {
    private List<DocumentVersion> versions = new ArrayList<>();

    public void saveVersion(Document document) {
        versions.add(document.save());
    }

    public void restoreVersion(Document document, int index) {
        if (index >= 0 && index < versions.size()) {
            document.restore(versions.get(index));
        }
    }

    public void listVersions() {
        for (int i = 0; i < versions.size(); i++) {
            System.out.println("Version " + i + ": " + versions.get(i).getContent());
        }
    }
}

public class MementoDocument {
    public static void main(String[] args) {
        Document document = new Document();
        VersionControl versionControl = new VersionControl();

        document.setContent("Version 1");
        versionControl.saveVersion(document);

        document.setContent("Version 2");
        versionControl.saveVersion(document);

        versionControl.listVersions();

        versionControl.restoreVersion(document, 0);
        System.out.println("Restored Document: " + document.getContent());
    }
}
